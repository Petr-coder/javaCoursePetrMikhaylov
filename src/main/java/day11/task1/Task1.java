package day11.task1;

import static day11.task1.Warehouse.QUANTITY_FOR_BONUS;

public class Task1 {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Picker picker = new Picker(warehouse);
        Courier courier = new Courier(warehouse);

        businessProcess(courier);
        System.out.println(courier.toString());

        businessProcess(picker);
        System.out.println(picker.toString());

    }

    static void businessProcess(Worker worker) {
        for (int i = 0; i < QUANTITY_FOR_BONUS; i++) {
            worker.doWork();
        }
        worker.bonus();
    }
}
