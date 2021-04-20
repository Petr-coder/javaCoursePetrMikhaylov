package day11.task1;

public class Picker implements Worker {
    private int salary;
    private boolean isPayed;
    private Warehouse warehouse;

    final int PAYMENT_PER_ORDER = 80;
    final int ACHIEVEMENT_BONUS = 70_000;

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
        warehouse.getCountPickedOrders();
        salary += PAYMENT_PER_ORDER;
    }

    @Override
    public void bonus() {
        if (isPayed() == true) {
            System.out.println("Бонус уже был выплачен");
        } else if (warehouse.countPickedOrders >= warehouse.QUANTITY_FOR_BONUS) {
            salary += ACHIEVEMENT_BONUS;
            isPayed = true;
        } else {
            System.out.println("Бонус пока не доступен");
        }
    }
}
