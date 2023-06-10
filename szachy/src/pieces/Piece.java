package pieces;

import main.Board;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Piece {

    public int col, row; // kolumna i wiersz gdzie znajduje sie figura
    public int xPos, yPos; // x i y gdzie figura jest rysowana

    public boolean isWhite; // czy biala
    public String name; // nazwa figury
    public int value; // wartosc figury

    public boolean isFirstMove = true;

    BufferedImage sheet; // obrazek z zestawem figur
    {
        try {
            sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream("pieces.png"));
        }   catch (IOException e){
            e.printStackTrace();

    }

    }
    protected int sheetScale = sheet.getWidth()/6;

    Image sprite; //obrazek reprezentujacy dana figure
    Board board; // plansza, na ktorej znajduje sie figura
    public  Piece(Board board){

        this.board = board;
    }

    public boolean isValidMovement(int col, int row){

        return true;
    }

    public boolean moveCollidesWithPiece(int col, int row){

        return false;
    }

    public void paint(Graphics2D g2d){
        g2d.drawImage(sprite, xPos, yPos, null); // rysowanie obrazka figury na planszy
    }

}
