package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public final static String SHOPPINGTASK = "SHOPPING TASK";
    public final static String PAINTINGTASK = "PAINTING TASK";
    public final static  String DRIVINGTASK = "DRIVING TASK";

    public final Task taskCreate(final String taskClass) {
        return switch (taskClass) {
            case SHOPPINGTASK -> new ShoppingTask("Buy phones and smartwatches", "Samsung", 3200.00);
            case PAINTINGTASK -> new PaintingTask("Paint the room", "white", "kitchen");
            case DRIVINGTASK -> new DrivingTask("Deliver the food", "Wrocław ul.Sloneczna 7", "car");
            default -> null;
        };
    }
}
