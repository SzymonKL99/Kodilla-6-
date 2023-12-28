package com.kodilla.patterns2.facade.api;

import com.kodilla.patterns2.facade.ShopService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Aspect
@Service
@EnableAspectJAutoProxy
public class OrderFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacade.class);
    private final ShopService shopService;
    @Autowired
    public OrderFacade(ShopService shopService) {
        this.shopService = shopService;
    }
    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..)) && args(order, userId)")
    public void logBeforeProcessOrder(OrderDto order, Long userId) {
        LOGGER.info("process Order is called with order: " + order + ", userId: " + userId);
    }

    @Around("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..)) && args(order, userId)")
    public Object logAroundProcessOrder(ProceedingJoinPoint joinPoint, OrderDto order, Long userId) throws Throwable {
        Object result;
        try {
            result = joinPoint.proceed();
            LOGGER.info("Process Order execution completed successfully");
        } catch (Throwable throwable) {
            LOGGER.error("Error during process Order execution: " + throwable.getMessage());
            throw throwable;
        }
        return result;
    }
    public void processOrder(final OrderDto order, final Long userId) throws OrderProcessingException {
        boolean wasError = false;
        Long orderId = shopService.openOrder(userId);
        LOGGER.info("Registering new order, ID: " + orderId);
        if (orderId < 0) {
            LOGGER.error(OrderProcessingException.ERR_NOT_AUTHORISED);
            wasError = true;
            throw new OrderProcessingException(OrderProcessingException.ERR_NOT_AUTHORISED);
        }
        try {
            for (ItemDto orderItem : order.getItems()) {
                LOGGER.info("Adding item " + orderItem.getProductId() + ", " + orderItem.getQuantity() + " pcs");
                shopService.addItem(orderId, orderItem.getProductId(), orderItem.getQuantity());
            }
            BigDecimal value = shopService.calculateValue(orderId);
            LOGGER.info("Order value is: " + value + " USD");
            if (!shopService.doPayment(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_PAYMENT_REJECTED);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_PAYMENT_REJECTED);
            }
            LOGGER.info("Payment for order was done");
            if (!shopService.verifyOrder(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_VERIFICATION_ERROR);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_VERIFICATION_ERROR);
            }
            LOGGER.info("Order is ready to submit");
            if (!shopService.submitOrder(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_SUBMITTING_ERROR);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_SUBMITTING_ERROR);
            }
            LOGGER.info("Order " + orderId + " submitted");
        } finally {
            if (wasError) {
                LOGGER.info("Cancelling order " + orderId);
                shopService.cancelOrder(orderId);
            }
        }
    }
}