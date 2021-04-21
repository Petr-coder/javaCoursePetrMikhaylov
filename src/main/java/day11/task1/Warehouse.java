package day11.task1;

public class Warehouse {

    private int countPickedOrders;
    private int countDeliveredOrders;

    private static final int QUANTITY_FOR_BONUS = 10000;

    public int getCountPickedOrders() {
        return countPickedOrders;
    }

    public static int getQuantityForBonus() {
        return QUANTITY_FOR_BONUS;
    }

    public int getCountDeliveredOrders() {
        return countDeliveredOrders;
    }

    public void incrementCountPickedOrders() {
        countPickedOrders++;
    }

    public void incrementCountDeliveredOrders() {
        countDeliveredOrders++;
    }
    @Override
    public String toString() {
        return "Warehouse{" +
                "countPickedOrders=" + countPickedOrders +
                ", countDeliveredOrders=" + countDeliveredOrders +
                '}';
    }
}
