package day17;

import static day17.ChessPiece.*;

public class Task2 {
    public static void main(String[] args) {

        ChessPiece[][] board = createEmptyChessboardOfGivenSize(8, 8);
        board[0][0] = ROOK_BLACK;
        board[0][5] = ROOK_BLACK;
        board[0][6] = KING_BLACK;

        board[1][1] = ROOK_WHITE;
        board[1][4] = PAWN_BLACK;
        board[1][5] = PAWN_BLACK;
        board[1][7] = PAWN_BLACK;

        board[2][0] = PAWN_BLACK;
        board[2][2] = KNIGHT_BLACK;
        board[2][6] = PAWN_BLACK;

        board[3][0] = QUEEN_BLACK;
        board[3][3] = BISHOP_WHITE;

        board[4][3] = BISHOP_BLACK;
        board[4][4] = PAWN_WHITE;

        board[5][4] = BISHOP_WHITE;
        board[5][5] = PAWN_WHITE;

        board[6][0] = PAWN_WHITE;
        board[6][3] = QUEEN_WHITE;
        board[6][5] = PAWN_WHITE;
        board[6][7] = PAWN_WHITE;

        board[7][5] = ROOK_WHITE;
        board[7][6] = KING_WHITE;

        ChessBoard chessBoard = new ChessBoard(board);
        chessBoard.print();
    }

    static ChessPiece[][] createEmptyChessboardOfGivenSize(int row, int column) {
        ChessPiece[][] chessPieces = new ChessPiece[row][column];

        for (int i = 0; i < chessPieces.length; i++) {
            for (int j = 0; j < chessPieces[i].length; j++) {
                chessPieces[i][j] = EMPTY;
            }
        }
        return chessPieces;
    }
}
