package final_project;

import static final_project.Battleship_board.print;
import static final_project.Battleship_board.shipArray;
import static final_project.Status.SHIP_CELL;

public class Game {
    public static void main(String[] args) {

        Player player1 = new Player(shipArray());
        Player player2 = new Player(shipArray());

        if (selectPlayer() == 1) {

            do {
                System.out.println("Ход первого игрока");
                player1.cellShot(player2.getBoard());
                if (!checkShipsOnBoard(player2.getBoard())) {
                    break;
                }

                System.out.println("Ход второго игрока");
                player2.cellShot(player1.getBoard());
                if (!checkShipsOnBoard(player1.getBoard())) {
                    break;
                }
            } while (true);
        } else {
            do {
                System.out.println("Ход второго игрока");
                player2.cellShot(player1.getBoard());
                if (!checkShipsOnBoard(player1.getBoard())) {
                    break;
                }

                System.out.println("Ход первого игрока");
                player1.cellShot(player2.getBoard());
                if (!checkShipsOnBoard(player2.getBoard())) {
                    break;
                }


            } while (true);
        }

        winnerIs(player1, player2);

        print(player1.getBoard());
        print(player2.getBoard());
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
