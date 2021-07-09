package final_project;

import java.util.*;

import static final_project.Status.EMPTY;
import static final_project.Status.HALO_SHIP;

public class ValidateInput {

    /**
     * проверяем количество координат правильное
     */
    static boolean checkIfShipCorrectSize(String[] line, int size) {
        boolean result = true;
        if (line.length / 2 != size)
            result = false;
        return result;
    }

    /**
     * проверяем находится ли число в пределах от 0 до +9
     */
    static boolean checkIfStringIsNumber(String[] coordinates) {
        boolean result = true;

        for (int i = 0; i < coordinates.length; i++) {
            if (!(coordinates[i].matches("\\d{1}") && (Integer.parseInt(coordinates[i]) < 10
                    && Integer.parseInt(coordinates[i]) >= 0)))
                result = false;
        }

        return result;
    }

    /**
     * проверяем, что координаты соответствуют пустым точкам на доске
     */
    static boolean checkIfCoordinatesCellsEmptyVer2(String[] coordinates, Cell[][] board) {
        boolean result = true;
        for (int i = 0; i < coordinates.length / 2; i = i + 2) {
            if (board[Integer.parseInt(coordinates[i])][Integer.parseInt(coordinates[i + 1])].getStatus() != EMPTY)
                result = false;
        }
        return result;
    }

    /**
     * проверяем, что координаты соответствуют ореолу на доске
     */
    static boolean checkOverlayOnShipsHalo(String[] coordinates, Cell[][] board) {
        boolean result = false;
        for (int i = 0; i < coordinates.length / 2; i = i + 2) {
            if (board[Integer.parseInt(coordinates[i])][Integer.parseInt(coordinates[i + 1])].getStatus() == HALO_SHIP)
                result = true;
        }
        return result;
    }

    /**
     * проверяем что точки расположены горизонтально и в одну линию
     */
    static boolean checkIfShipHorizontalVer2(String[] coordinates) {
        Set<Boolean> set = new HashSet();
        boolean result = true;
        int horizontal = Integer.parseInt(coordinates[0]);

        for (int i = 0; i < coordinates.length; i = i + 2) {
            if (Integer.parseInt(coordinates[i]) == horizontal) {
                set.add(true);
            } else {
                set.add(false);
            }
        }
        if (set.contains(false)) {
            result = false;
        }
        return result;
    }

    /**
     * проверяем что точки расположены вертикально и в одну линию
     */
    static boolean checkIfShipVerticalVer2(String[] coordinates) {
        Set<Boolean> set = new HashSet();
        boolean result = true;
        int vertical = Integer.parseInt(coordinates[1]);

        for (int i = 1; i < coordinates.length; i = i + 2) {
            if (Integer.parseInt(coordinates[i]) == vertical) {
                set.add(true);
            } else {
                set.add(false);
            }
        }

        if (set.contains(false)) {
            result = false;
        }
        return result;
    }

    /**
     * проверяем, что координаты расположены подряд
     */
    static boolean checkIfShipInOneRawVer2(String[] coordinates) {
        List<Integer> arrayX = new ArrayList<>();
        List<Integer> arrayY = new ArrayList<>();

        for (int i = 0; i < coordinates.length; i = i + 2) {
            arrayX.add(Integer.parseInt(coordinates[i]));
        }

        for (int i = 1; i < coordinates.length; i = i + 2) {
            arrayY.add(Integer.parseInt(coordinates[i]));
        }

        boolean result = true;
        Collections.sort(arrayX);
        Collections.sort(arrayY);

        if (checkIfShipHorizontalVer2(coordinates)) {
            for (int i = 0; i < arrayY.size() - 1; i++) {
                if (arrayY.get(i) != arrayY.get(i + 1) - 1) {
                    System.out.println("Координаты не расположены горизонтально и подряд");
                    result = false;
                }
            }
        } else if (checkIfShipVerticalVer2(coordinates)) {
            for (int i = 0; i < arrayX.size() - 1; i++) {
                if (arrayX.get(i) != arrayX.get(i + 1) - 1) {
                    System.out.println("Координаты " + "не расположены подряд");
                    result = false;
                }
            }
        } else {
            result = false;
            System.out.println("Else result");
        }

        return result;
    }
}
