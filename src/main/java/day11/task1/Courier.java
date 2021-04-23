package day11.task1;

import static day11.task1.Warehouse.getQuantityForBonus;

public class Courier implements Worker {
    private int salary;
    private boolean isPayed;
    private Warehouse warehouse;
    private final int PAYMENT_PER_ORDER = 100;
    private final int ACHIEVEMENT_BONUS = 50_000;

    public int getSalary() {
        return salary;
    }

    public boolean isPayed() {
        return isPayed;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "salary=" + salary +
                ", isPayed=" + isPayed +
                '}';
    }

    public Courier(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void doWork() {
        salary += PAYMENT_PER_ORDER;
        warehouse.incrementCountDeliveredOrders();
    }

    @Override
    public void bonus() {
        if (isPayed()) {
            System.out.println("Бонус уже был выплачен");
        } else if (warehouse.getCountDeliveredOrders() >= getQuantityForBonus()) {
            salary += ACHIEVEMENT_BONUS;
            isPayed = true;
        } else {
            System.out.println("Бонус пока не доступен");
        }
    }
}

