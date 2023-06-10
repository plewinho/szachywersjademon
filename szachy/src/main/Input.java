package main;

import pieces.Piece;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input extends MouseAdapter {

    Board board;

    // konstruktor klasy Input, który pobiera obiekt Board
    public Input(Board board) {
        this.board = board;
    }

    // nadpisanie metody mousePressed klasy MouseAdapter, która wywołuje się, gdy użytkownik kliknie na planszę
    @Override
    public void mousePressed(MouseEvent e) {

        // obliczenie kolumny i wiersza klikniętego pola
        int col = e.getX() / board.tileSize;
        int row = e.getY() / board.tileSize;

        // pobranie obiektu figury znajdującej się na klikniętym polu i ustawienie go jako wybranej figury
        Piece pieceXY = board.getPiece(col, row);
        if (pieceXY != null) {
            board.selectedPiece = pieceXY;
        }
    }

    // nadpisanie metody mouseDragged klasy MouseAdapter, która wywołuje się, gdy użytkownik przesuwa myszkę po planszy
    @Override
    public void mouseDragged(MouseEvent e) {

        // jeśli wybrana figura istnieje, ustaw jej pozycję na pozycję kursora myszy i przerysuj planszę
        if(board.selectedPiece != null){
            board.selectedPiece.xPos = e.getX() - board.tileSize / 2;
            board.selectedPiece.yPos = e.getY() - board.tileSize / 2;
            board.repaint();
        }
    }

    // nadpisanie metody mouseReleased klasy MouseAdapter, która wywołuje się, gdy użytkownik puści przycisk myszy
    @Override
    public void mouseReleased(MouseEvent e) {

        // obliczenie kolumny i wiersza pola, na które użytkownik upuścił figurę
        int col = e.getX() / board.tileSize;
        int row = e.getY() / board.tileSize;

        // jeśli wybrana figura istnieje, utworzenie nowego obiektu klasy Move i sprawdzenie, czy ruch jest prawidłowy
        if(board.selectedPiece != null){
            Move move = new Move(board, board.selectedPiece, col, row);

            // jeśli ruch jest prawidłowy, wykonaj ruch i przerysuj planszę, w przeciwnym razie przywróć wybraną figurę do jej pierwotnego położenia
            if(board.isValidMove(move)){
                board.makeMove(move);
            } else {
                board.selectedPiece.xPos = board.selectedPiece.col * board.tileSize;
                board.selectedPiece.yPos = board.selectedPiece.row * board.tileSize;
            }
        }

        // odznaczenie wybranej figury i przerysowanie planszy
        board.selectedPiece = null;
        board.repaint();
    }
}
