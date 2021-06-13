package final_project;


import java.util.*;

import static final_project.Status.*;

public class Battleship_board {
    static final int FOUR_DECK_SHiP = 4;
    static final int THREE_DECK_SHiP = 3;
    static final int TWO_DECK_SHiP = 2;
    static final int ONE_DECK_SHiP = 1;

    static final int ROW_COUNT = 10;
    static final int COLUMN_COUNT = 10;

    /**
     * создаем массив Cell, каждое из них = EMPTY
     */
    static Cell[][] createEmptyBoardGivenSize(int row, int column) {
        Cell[][] ships = new Cell[row][column];

        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[i].length; j++) {
                ships[i][j] = new Cell(i, j);
                ships[i][j].setStatus(EMPTY);
            }
        }
        return ships;
    }

    /**
     * принимаем на вход строку координат до тех пор пока не пройдет все проверки
     */
    static String[] input(int size, Cell[][] board) {
        String line;
        String[] coordinates;
        Scanner scanner = new Scanner(System.in);
        boolean flag;
        do {
            flag = true;
            line = scanner.nextLine();
            coordinates = line.split("\\D");


            if (!checkIfShipCorrectSize(coordinates, size)) {
                System.out.println("Размер корабля не равен " + size);
                System.out.println("Введите координаты снова");
                flag = false;
            } else if (coordinates.length <= 0) {
                System.out.println("Введены не валидные данные");
                System.out.println("Введите координаты снова");
                flag = false;
            } else if (!checkIfStringIsNumber(coordinates)) {
                System.out.println("Часть ввведенных данных не является целочисленным " +
                        "положительным числом от 0 до 9");
                System.out.println("Введите координаты снова");
                flag = false;
            } else if (!checkIfCoordinatesCellsEmptyVer2(coordinates, board)) {
                System.out.println("Координаты не соответствуют пустым точкам на доске");
                System.out.println("Введите координаты снова");
                flag = false;
            } else if (!checkIfShipInOneRawVer2(coordinates)) {
                flag = false;
            }

        }
        while (!flag);

        return coordinates;
    }

    /**
     * проверяем корректность длины корабля
     */
    static boolean checkIfShipCorrectSize(String[] line, int size) {
        boolean result = true;
        if (line.length / 2 != size)
            result = false;
        return result;
    }

    /**
     * код для проверки число или нет в предела от 0 до +9
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
        int vertical = Integer.parseInt(coordinates[0]);

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
                    System.out.println("Горизонтальный кораблик");
                    result = false;
                }
            }
        } else if (checkIfShipVerticalVer2(coordinates)) {
            for (int i = 0; i < arrayX.size() - 1; i++) {
                if (arrayX.get(i) == arrayX.get(i + 1) - 1)
                    System.out.println("Координаты не расположены вертикально и подряд");
                System.out.println("Вертикальный кораблик");
                result = false;
            }
        }
//        else {
//            System.out.println("Корабль не расположен строго по вертикали или горизонтали");
//            result = false;
//        }
        return result;
    }

    /**
     * создаём корабль в формате List
     */
    static List<Coordinates> createShipCoordinatesList(int shipsSize, Cell[][] board) {
        int numbersCount = shipsSize * 2;

        List<Coordinates> ship = new ArrayList<>();

        String[] coordinates = input(shipsSize, board);

        checkIfShipCorrectSize(coordinates, shipsSize);
        for (int i = 0; i < numbersCount - 1; i += 2) {
            ship.add(new Coordinates(Integer.parseInt(coordinates[i]), Integer.parseInt(coordinates[i + 1])));
        }

        return ship;
    }

    /**
     * добавляем корабль на доску и присваиваем ячейке корабль
     */
    static void addShipToBoard(List<Coordinates> list, Cell[][] board) {
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i).getX();
            int y = list.get(i).getY();

            board[x][y].setStatus(SHIP_CELL);
            board[x][y].setShip(list);

        }
    }

    /**
     * После всех проверок и сообщений о повторном вводе корректных данных вокруг корабля создаем ореол
     */
    static void surroundShipWithHalo(List<Coordinates> list, Cell[][] board) {
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i).getX();
            int y = list.get(i).getY();

            if (y != 0 && board[x][y - 1].getStatus() == EMPTY) {
                board[x][y - 1].setStatus(HALO_SHIP);
            }

            if (x != 0 && board[x - 1][y].getStatus() == EMPTY) {
                board[x - 1][y].setStatus(HALO_SHIP);
            }

            if (x != 0 && y != 0 && board[x - 1][y - 1].getStatus() == EMPTY) {
                board[x - 1][y - 1].setStatus(HALO_SHIP);
            }

            if ((x < board.length - 1) && (y < board.length - 1) && board[x + 1][y + 1].getStatus() == EMPTY) {
                board[x + 1][y + 1].setStatus(HALO_SHIP);
            }

            if ((y < board.length - 1) && board[x][y + 1].getStatus() == EMPTY) {
                board[x][y + 1].setStatus(HALO_SHIP);
            }

            if (x != 0 && (y < board.length - 1) && board[x - 1][y + 1].getStatus() == EMPTY) {
                board[x - 1][y + 1].setStatus(HALO_SHIP);
            }

            if (x != 0 && (y < board.length - 1) && board[x - 1][y + 1].getStatus() == EMPTY) {
                board[x - 1][y + 1].setStatus(HALO_SHIP);
            }

            if (y != 0 && (x < board.length - 1) && board[x + 1][y - 1].getStatus() == EMPTY) {
                board[x + 1][y - 1].setStatus(HALO_SHIP);
            }

            if ((x < board.length - 1) && board[x + 1][y].getStatus() == EMPTY) {
                board[x + 1][y].setStatus(HALO_SHIP);
            }
        }
    }

    /**
     * созданный корабль добавляем на доску
     */
    static void createShip(Cell[][] board, int shipSize) {
        List<Coordinates> ship = createShipCoordinatesList(shipSize, board);
        addShipToBoard(ship, board);
        surroundShipWithHalo(ship, board);
    }

    /**
     * создаём доску для игрока
     */
    static Cell[][] shipArray() {
        Cell[][] board = createEmptyBoardGivenSize(ROW_COUNT, COLUMN_COUNT);

        System.out.println("Введите координаты четырехпалубного корабля (формат: x,y;x,y;x,y;x,y)");
        createShip(board, FOUR_DECK_SHiP);

        System.out.println("Введите координаты первого трехпалубного корабля (формат: x,y;x,y;x,y)");
        createShip(board, THREE_DECK_SHiP);

        System.out.println("Введите координаты второго трехпалубного корабля (формат: x,y;x,y;x,y)");
        createShip(board, THREE_DECK_SHiP);

        System.out.println("Введите координаты первого двуххпалубного корабля (формат: x,y;x,y)");
        createShip(board, TWO_DECK_SHiP);

        System.out.println("Введите координаты второго двуххпалубного корабля (формат: x,y;x,y)");
        createShip(board, TWO_DECK_SHiP);

        System.out.println("Введите координаты третьего двуххпалубного корабля (формат: x,y;x,y)");
        createShip(board, TWO_DECK_SHiP);

        System.out.println("Введите координаты первого однопалубного корабля (формат: x,y)");
        createShip(board, ONE_DECK_SHiP);

        System.out.println("Введите координаты второго однопалубного корабля (формат: x,y)");
        createShip(board, ONE_DECK_SHiP);

        System.out.println("Введите координаты третьего однопалубного корабля (формат: x,y)");
        createShip(board, ONE_DECK_SHiP);

        System.out.println("Введите координаты четвертого однопалубного корабля (формат: x,y)");
        createShip(board, ONE_DECK_SHiP);

        return board;
    }

    /**
     * выводим доску в виде изображений ячеек
     */
    static void print(Cell[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].getStatus().getName());
            }
            System.out.println();
        }
        System.out.println();
    }
}
