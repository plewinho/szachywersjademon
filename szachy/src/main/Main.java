package main;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


       JFrame frame = new JFrame(); // tworzenie nowego okna JFrame
       frame.getContentPane().setBackground(Color.white); // tlo = czarne
       frame.setLayout(new GridBagLayout()); // ustawianie layoutu okna
       frame.setMinimumSize(new Dimension(1000,1000)); // ustawienie rozmiaru okna
       frame.setLocationRelativeTo(null); // ustawienie okna na srodku ekranu

       //tworzenie planszy
       Board board = new Board();

       //dodawanie planszy do okna
       frame.add(board);

       //wyswietlanie okna
       frame.setVisible(true);

}}