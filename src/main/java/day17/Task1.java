package day17;

import static day17.ChessPiece.PAWN_WHITE;
import static day17.ChessPiece.ROOK_BLACK;

public class Task1 {
    public static void main(String[] args) {
        String[] array = new String[8];

        for (int i = 0; i < 4; i++) {
            array[i] = PAWN_WHITE.getName();
        }

        for (int i = 4; i < 8; i++) {
            array[i] = ROOK_BLACK.getName();
        }

        for (int i = 0; i < 8; i++) {
            System.out.print(array[i] + " ");
        }

    }
}