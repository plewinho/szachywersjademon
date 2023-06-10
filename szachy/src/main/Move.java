package main;

import pieces.Piece;

public class Move {

    //  zmienne przechowujące współrzędne pola startowego i docelowego ruchu
    int oldCol;
    int oldRow;
    int newCol;
    int newRow;

    //  przechowujących obiekt figury i ewentualnie figury zbieranej w trakcie ruchu
    Piece piece;
    Piece capture;

    // konstruktor klasy Move pobiera obiekt Board i figurę, którą należy przesunąć, a następnie ustawia wartości współrzędnych, obiektów Piece i capture
    public Move(Board board, Piece piece, int newCol, int newRow){

        // zapisanie współrzędnych pola startowego figury
        this.oldCol = piece.col;
        this.oldRow = piece.row;

        // zapisanie współrzędnych pola docelowego ruchu
        this.newCol = newCol;
        this.newRow = newRow;

        // zapisanie obiektu figury, którą należy przesunąć
        this.piece = piece;

        // zapisanie obiektu figury zbieranej w trakcie ruchu
        this.capture = board.getPiece(newCol, newRow);
    }
}
