package final_project;

import static final_project.Battleship_board.*;
import static final_project.Status.SHIP_CELL;

public class Game {
    public static void main(String[] args) {

        System.out.println("Игрок № 1 разместите ваш флот кораблей");
        Player player1 = new Player(shipArray());
        printTwoBoards(player1.getBoard(), player1.getGuessBoard());

        System.out.println("Игрок № 2 разместите ваш флот кораблей");
        Player player2 = new Player(shipArray());
        printTwoBoards(player2.getBoard(), player2.getGuessBoard());

        if (selectPlayer() == 1) {

            while (true) {
                print(player1.getBoard());
                System.out.println("Ход первого игрока");
                System.out.println("Доска с вашим флотом отображается выше, чтобы при смене хода соперник не видел её." +
                        "\nНиже отображается доска с вашими ходами ");
                print(player1.getGuessBoard());
                System.out.println("Введите координаты");
                player1.cellShot(player2.getBoard(), player1.getGuessBoard());
                if (!checkShipsOnBoard(player2.getBoard())) {
                    break;
                }

                print(player2.getBoard());
                System.out.println("Ход второго игрока");
                System.out.println("Доска с вашим флотом отображается выше, чтобы при смене хода соперник не видел её." +
                        "\nНиже отображается доска с вашими ходами ");
                print(player2.getGuessBoard());
                System.out.println("Введите координаты");
                player2.cellShot(player1.getBoard(), player2.getGuessBoard());
                if (!checkShipsOnBoard(player1.getBoard())) {
                    break;
                }
            }

        } else {

            while (true) {
                print(player2.getBoard());
                System.out.println("Ход второго игрока");
                System.out.println("Доска с вашим флотом отображается выше, чтобы при смене хода соперник не видел её." +
                        "\nНиже отображается доска с вашими ходами ");
                print(player2.getGuessBoard());
                System.out.println("Введите координаты");
                player2.cellShot(player1.getBoard(), player2.getGuessBoard());
                if (!checkShipsOnBoard(player1.getBoard())) {
                    break;
                }

                print(player1.getBoard());
                System.out.println("Ход первого игрока");
                System.out.println("Доска с вашим флотом отображается выше, чтобы при смене хода соперник не видел её." +
                        "\nНиже отображается доска с вашими ходами ");
                print(player1.getGuessBoard());
                System.out.println("Введите координаты");
                player1.cellShot(player2.getBoard(), player1.getGuessBoard());
                if (!checkShipsOnBoard(player2.getBoard())) {
                    break;
                }
            }
        }

        winnerIs(player1, player2);

        System.out.println("Доска первого игрока");
        printTwoBoards(player1.getBoard(), player1.getGuessBoard());
        System.out.println("Доска второго игрока");
        printTwoBoards(player2.getBoard(), player2.getGuessBoard());
    }


    /**
     * выбор игрока, начинающего игру
     */
    static int selectPlayer() {
        int player = (int) (Math.random() * (2) + 1);
        System.out.println("игру начинает игрок № " + player);
        return player;
    }

    /**
     * после хода проверяем есть ли непотопленные корабли
     */
    static boolean checkShipsOnBoard(Cell[][] board) {
        boolean containsShip = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getStatus() == SHIP_CELL) {
                    containsShip = true;
                }
            }
        }
        return containsShip;
    }

    /**
     * объявляем победителя
     */
    static void winnerIs(Player player1, Player player2) {
        if (!checkShipsOnBoard(player1.getBoard())) {
            System.out.println("Победил игрок № 2");
        } else if (!checkShipsOnBoard(player2.getBoard())) ;
        System.out.println("Победил игрок № 1");
    }

}
