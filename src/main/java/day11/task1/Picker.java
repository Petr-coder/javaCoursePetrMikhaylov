package day11.task1;

import static day11.task1.Warehouse.getQuantityForBonus;

public class Picker implements Worker {
    private int salary;
    private boolean isPayed;
    private Warehouse warehouse;

    private static final int PAYMENT_PER_ORDER = 80;
    private static final int ACHIEVEMENT_BONUS = 70_000;

    public int getSalary() {
        return salary;
    }

    public boolean isPayed() {
        return isPayed;
    }

    @Override
    public String toString() {
        return "Picker{" +
                "salary=" + salary +
                ", isPayed=" + isPayed +
                '}';
    }

    public Picker(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void doWork() {
        salary += PAYMENT_PER_ORDER;
        warehouse.incrementCountPickedOrders();
    }

    @Override
    public void bonus() {
        if (isPayed() == true) {
            System.out.println("Бонус уже был выплачен");
        } else if (warehouse.getCountPickedOrders() >= getQuantityForBonus()) {
            salary += ACHIEVEMENT_BONUS;
            isPayed = true;
        } else {
            System.out.println("Бонус пока не доступен");
        }
    }
}
