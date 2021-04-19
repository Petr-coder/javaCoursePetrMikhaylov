package day11.task1;

public class Courier implements Worker {
    private int salary;
    private boolean isPayed;
    Warehouse warehouse;
    final int PAYMENT_PER_ORDER = 100;
    final int ACHIEVEMENT_BONUS = 50_000;

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
        warehouse.countDeliveredOrders++;
        salary += PAYMENT_PER_ORDER;
    }

    @Override
    public void bonus() {
        if (isPayed() == true) {
            System.out.println("Бонус уже был выплачен");
        } else if (warehouse.countDeliveredOrders >= warehouse.QUANTITY_FOR_BONUS) {
            salary += ACHIEVEMENT_BONUS;
            isPayed = true;
        } else {
            System.out.println("Бонус пока не доступен");
        }
    }
}

