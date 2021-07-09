package final_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static final_project.Status.*;
import static final_project.ValidateInput.*;

public class Battleship_board {
    static final int FOUR_CELL_SHiP = 4;
    static final int THREE_CELL_SHiP = 3;
    static final int TWO_CELL_SHiP = 2;
    static final int ONE_CELL_SHiP = 1;

    static final int ROW_COUNT = 10;
    static final int COLUMN_COUNT = 10;

    /**
     * создаем массив Cell, каждое из Cell = EMPTY
     */
    static Cell[][] createEmptyBoardGivenSize(int row, int column) {
        Cell[][] board = new Cell[row][column];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Cell(new Coordinates(i, j), EMPTY);
            }
        }
        return board;
    }

    /**
     * принимаем на вход строку координат до тех пор, пока не пройдет все проверки
     */
    static String[] input(int size, Cell[][] board) {
        String line;
        String[] coordinates = null;
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;

        while (!flag) {
            line = scanner.nextLine();
            line = line.trim();
            coordinates = line.split("\\D");
            flag = checkIfInputCorrect(coordinates, size, board);
        }

        return coordinates;
    }


    static boolean checkIfInputCorrect(String[] coordinates, int size, Cell[][] board) {
        boolean result = true;

        if (!checkIfShipCorrectSize(coordinates, size)) {
            System.out.println("Размер корабля не равен " + size);
            System.out.println("Введите координаты снова");
            result = false;
        } else if (coordinates.length <= 0) {
            System.out.println("Введены не валидные данные");
            System.out.println("Введите координаты снова");
            result = false;
        } else if (!checkIfStringIsNumber(coordinates)) {
            System.out.println("Часть ввведенных данных не является целочисленным " +
                    "положительным числом от 0 до 9");
            System.out.println("Введите координаты снова");
            result = false;
        } else if (checkOverlayOnShipsHalo(coordinates, board)) {
            System.out.println("Попытка установить корабль на ореол другого корабля");
            System.out.println("Введите координаты снова");
            result = false;
        } else if (!checkIfCoordinatesCellsEmptyVer2(coordinates, board)) {
            System.out.println("Координаты не соответствуют пустым точкам на доске");
            System.out.println("Введите координаты снова");
            result = false;
        } else if (!checkIfShipInOneRawVer2(coordinates)) {
            System.out.println("Ячейки не расположены подряд и в одну линию");
            result = false;
        }
        return result;
    }

    /**
     * создаём корабль в формате List
     */
    static List<Coordinates> createShipCoordinatesList(int shipsSize, Cell[][] board) {
        print(board);
        int numbersCount = shipsSize * 2;

        List<Coordinates> ship = new ArrayList<>();

        String[] coordinates = input(shipsSize, board);

        checkIfShipCorrectSize(coordinates, shipsSize);
        for (int i = 0; i < numbersCount; i += 2) {
            ship.add(new Coordinates(Integer.parseInt(coordinates[i]), Integer.parseInt(coordinates[i + 1])));
        }

        return ship;
    }

    /**
     * Метод, добавляющий корабль на доску и присваивающий ячейке корабль
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
     * После всех проверок и сообщений о повторном вводе корректных данных создаем ореол вокруг корабля
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
     * меняем ячейки корабля с punched на destroyed
     */
    static void shipDestroyed(List<Coordinates> list, Cell[][] board) {
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i).getX();
            int y = list.get(i).getY();
            board[x][y].setStatus(DESTROYED);
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
     * создаём доску для игрока, запрашивая ввод данных
     */
    static Cell[][] shipArray() {
        Cell[][] board = createEmptyBoardGivenSize(ROW_COUNT, COLUMN_COUNT);

        System.out.println("Введите координаты четырехпалубного корабля (формат: x,y;x,y;x,y;x,y)");
        createShip(board, FOUR_CELL_SHiP);

        System.out.println("Введите координаты первого трехпалубного корабля (формат: x,y;x,y;x,y)");
        createShip(board, THREE_CELL_SHiP);

        System.out.println("Введите координаты второго трехпалубного корабля (формат: x,y;x,y;x,y)");
        createShip(board, THREE_CELL_SHiP);

        System.out.println("Введите координаты первого двуххпалубного корабля (формат: x,y;x,y)");
        createShip(board, TWO_CELL_SHiP);

        System.out.println("Введите координаты второго двуххпалубного корабля (формат: x,y;x,y)");
        createShip(board, TWO_CELL_SHiP);

        System.out.println("Введите координаты третьего двуххпалубного корабля (формат: x,y;x,y)");
        createShip(board, TWO_CELL_SHiP);

        System.out.println("Введите координаты первого однопалубного корабля (формат: x,y)");
        createShip(board, ONE_CELL_SHiP);

        System.out.println("Введите координаты второго однопалубного корабля (формат: x,y)");
        createShip(board, ONE_CELL_SHiP);

        System.out.println("Введите координаты третьего однопалубного корабля (формат: x,y)");
        createShip(board, ONE_CELL_SHiP);

        System.out.println("Введите координаты четвертого однопалубного корабля (формат: x,y)");
        createShip(board, ONE_CELL_SHiP);

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

    /**
     * выводим доску в виде изображений ячеек
     */
    static void printTwoBoards(Cell[][] board, Cell[][] guessBoard) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].getStatus().getName());
            }

            System.out.print("         ");

            for (int j = 0; j < guessBoard[i].length; j++) {
                System.out.print(guessBoard[i][j].getStatus().getName());
            }

            System.out.println();
        }
        System.out.println();
    }

    static void printTwoBoardsForNextPlayer(Cell[][] board, Cell[][] guessBoard) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].getStatus().getName());
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < guessBoard.length; i++) {
            for (int j = 0; j < guessBoard[i].length; j++) {
                System.out.print(guessBoard[i][j].getStatus().getName());
            }
            System.out.println();
        }
        System.out.println();
    }


}
