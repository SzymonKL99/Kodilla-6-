package com.kodilla.testing2.facebook;
import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_CREATE_ACCOUNT = "//a[text()='Utwórz nowe konto']";
    public static final String XPATH_DAY = "//select[@name='birthday_day']";
    public static final String XPATH_MONTH = "//select[@name='birthday_month']";
    public static final String XPATH_YEAR = "//select[@name='birthday_year']";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com/");

        WebElement acceptCookiesButton = driver.findElement(By.cssSelector("button[data-cookiebanner=\"accept_button\"]"));
        if (acceptCookiesButton.isDisplayed()) {
            acceptCookiesButton.click();
        }

        WebElement createAccountLink = driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT));
        createAccountLink.click();

        WebElement dayDropdown = driver.findElement(By.xpath(XPATH_DAY));
        Select daySelect = new Select(dayDropdown);
        daySelect.selectByVisibleText("15");

        WebElement monthDropdown = driver.findElement(By.xpath(XPATH_MONTH));
        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByVisibleText("październik");

        WebElement yearDropdown = driver.findElement(By.xpath(XPATH_YEAR));
        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByVisibleText("1990");
    }
}