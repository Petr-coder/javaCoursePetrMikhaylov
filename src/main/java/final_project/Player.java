package final_project;

import java.util.Scanner;

import static final_project.Battleship_board.*;
import static final_project.Game.checkShipsOnBoard;
import static final_project.Status.*;
import static final_project.ValidateInput.checkIfShipCorrectSize;
import static final_project.ValidateInput.checkIfStringIsNumber;

public class Player {
    private Cell[][] board;
    private String name;

    public Cell[][] getGuessBoard() {
        return guessBoard;
    }

    private Cell[][] guessBoard = Battleship_board.createEmptyBoardGivenSize(10, 10);


    public Player(Cell[][] board) {
        this.board = board;
    }


    public Cell[][] getBoard() {
        return board;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static String[] inputShot() {
        String line;
        String[] coordinates = null;
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;

        while (!flag) {
            line = scanner.nextLine();
            line = line.trim();

            coordinates = line.split("\\D");

            if (!checkIfShipCorrectSize(coordinates, 1)) {
                System.out.println("Координаты должны быть введены в формате -- > 0,0");
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
            } else {
                flag = true;
            }
        }
        return coordinates;
    }

    static Coordinates shotCoordinate() {
        Coordinates coordinate = new Coordinates();

        String[] input = inputShot();
        coordinate.setX(Integer.parseInt(input[0]));
        coordinate.setY(Integer.parseInt(input[1]));

        return coordinate;
    }


    void cellShot(Cell[][] board, Cell[][] guessBoard) {
        boolean shipAfloat = false;
        Coordinates guess = shotCoordinate();
        int x = guess.getX();
        int y = guess.getY();
        if ((!guessBoard[x][y].getStatus().equals(SHIP_CELL) && !guessBoard[x][y].getStatus().equals(PUNCHED_CELL))
                || (!guessBoard[x][y].getStatus().equals(SHIP_CELL) && !guessBoard[x][y].getStatus().equals(DESTROYED))) {
            guessBoard[x][y].setStatus(GUESS);
        }

        if (board[x][y].getStatus().equals(SHIP_CELL)) {
            board[x][y].setStatus(PUNCHED_CELL);
            guessBoard[x][y].setStatus(PUNCHED_CELL);
            System.out.println("Попал");

            shipAfloat = isShipAfloat(board, x, y);

            if (!shipAfloat) {
                System.out.println("Потопил корабль");
                surroundShipWithHalo(board[x][y].getShip(), guessBoard);
                shipDestroyed(board[x][y].getShip(), guessBoard);

            }

            if (checkShipsOnBoard(board)) {
                System.out.println("Доска ваших ходов");
                print(guessBoard);
                cellShot(board, guessBoard);
            }
        } else if (board[x][y].getStatus() != SHIP_CELL) {
            System.out.println("Мимо");
        }
    }

    static boolean isShipAfloat(Cell[][] board, int x, int y) {
        boolean result = false;
        for (int i = 0; i < board[x][y].getShip().size(); i++) {

            int xCoordinate = board[x][y].getShip().get(i).getX();
            int yCoordinate = board[x][y].getShip().get(i).getY();

            if (board[xCoordinate][yCoordinate].getStatus().equals(SHIP_CELL))
                result = true;
        }
        return result;
    }
}