package final_project;

import java.util.Scanner;

import static final_project.Battleship_board.checkIfShipCorrectSize;
import static final_project.Battleship_board.checkIfStringIsNumber;
import static final_project.Game.checkShipsOnBoard;
import static final_project.Status.PUNCHED_CELL;
import static final_project.Status.SHIP_CELL;

public class Player {
    private Cell[][] board;
    private String name;


    public Player(Cell[][] board) {
        this.board = board;
    }


    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static String[] inputShot() {
        String line;
        String[] coordinates;
        Scanner scanner = new Scanner(System.in);
        boolean flag;

        do {
            flag = true;
            line = scanner.nextLine();
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
            }

        }
        while (!flag);

        return coordinates;
    }


    static Coordinates shotCoordinate() {
        Coordinates coordinate = new Coordinates();

        String[] input = inputShot();
        coordinate.setX(Integer.parseInt(input[0]));
        coordinate.setY(Integer.parseInt(input[1]));

        return coordinate;
    }


    void cellShot(Cell[][] board) {
        Coordinates coordinate = shotCoordinate();

        if (board[coordinate.getX()][coordinate.getY()].getStatus().equals(SHIP_CELL)) {
            board[coordinate.getX()][coordinate.getY()].setStatus(PUNCHED_CELL);
            System.out.println("Попал");

            for (int i = 0; i < board[coordinate.getX()][coordinate.getY()].getShip().size(); i++) {
                if (board[coordinate.getX()][coordinate.getY()].getShip().get(i).getX() == coordinate.getX() && board[coordinate.getX()][coordinate.getY()].getShip().get(i).getY() == coordinate.getY()) {
                    board[coordinate.getX()][coordinate.getY()].getShip().remove(i);
                }
            }

            if (board[coordinate.getX()][coordinate.getY()].getShip().size() == 0) {
                System.out.println("Потопил корабль");
            }
            if (checkShipsOnBoard(board)) {
                cellShot(board);
            }
        } else if (board[coordinate.getX()][coordinate.getY()].getStatus() != SHIP_CELL) {
            System.out.println("Мимо");
        }
    }
}