package pl.edu.us.ii.awpto;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;

public class Board {
  //Strumienie do wczytywania map
  private InputStream in;
  private Reader reader;
  //mapy 
  private char[][] playerOneBoard;
  private char[][] playerTwoBoard;
  //wymiary map
  private int height;
  private int width;
  /**
   * Konstruktor klasy Board.
   * 
   * @param fileName nazwa pliku do wczytania map
   */
  public Board(String fileName) {
    this.in = Board.class.getClassLoader().getResourceAsStream(fileName);
    this.reader = new InputStreamReader(in);
    this.height = 1;
    this.width = 0;
    initBoards();
  }
    /**
     * Laduje mapy z pliku do tabel.
     */
  public void initBoards() {
    int character;
    String map = "";
    try {
      while ((character = this.reader.read()) != -1) {
        this.width++;
        if (character == 10) { 
          this.height++; 
        }
        map = map + (char) character;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    String[] tmp;
    this.width = (((this.width - (this.height * 3)) / this.height) + 1) / 2;
    map = map.replaceAll("\r\n", " ");
    tmp = map.split(" ");
    playerOneBoard = new char[this.height][this.width];
    playerTwoBoard = new char[this.height][this.width];
    int even = 0; //parzyste jako wiersze 1 mapy
    int odd = 1; //nieparzyste jako wiersze 2 mapy
    for (int i = 0; i < this.height; i++) {
      playerOneBoard[i] = tmp[even].toCharArray();
      playerTwoBoard[i] = tmp[odd].toCharArray();
      even += 2;
      odd += 2;
    }
  }
    
   
    
  public char[][] getPlayerOneBoard() {
    return playerOneBoard;
  }
    
  public char[][] getPlayerTwoBoard() {
    return playerTwoBoard;
  }
    
  public void setPlayerOneBoard(char[][] playerOneBoard) {
    this.playerOneBoard = playerOneBoard;
  }
    
  public void setPlayerTwoBoard(char[][] playerTwoBoard) {
    this.playerTwoBoard = playerTwoBoard;
  }
    
  public int getHeight() {
    return height;
  }
    
  public int getWidth() {
    return width;
  }
  /**
   * Wyswietla plansze gracza nr 1.
   */
  public void showPlayerOneBoard() {
    System.out.println("Player one");
    System.out.print("    ");
    for (int i = 0; i < this.width; i++) { 
      System.out.print(i + "   ");
    }
    System.out.println();
    for (int i = 0; i <= this.width; i++) { 
      System.out.print("_" + "   ");
    }
    System.out.println();
    for (int i = 0; i < this.height; i++) {
      System.out.print(i + (i >= 10 ? "| " : "|  "));
      for (int j = 0; j < this.width; j++) {
        System.out.print(this.playerOneBoard[i][j] + "   ");
      }
      System.out.println();
    }
  }
  /**
   * Wyswietla plansze gracza nr 2.   
   */
  public void showPlayerTwoBoard() {
    System.out.println("Player two");
    System.out.print("    ");
    for (int i = 0; i < this.width; i++) { 
      System.out.print(i + "   ");
    }
    System.out.println();
    for (int i = 0; i <= this.width; i++) { 
      System.out.print("_" + "   ");
    }
    System.out.println();
    for (int i = 0; i < this.height; i++) {
      System.out.print(i + (i >= 10 ? "| " : "|  "));
      for (int j = 0; j < this.width; j++) {
        System.out.print(this.playerTwoBoard[i][j] + "   ");
      }
      System.out.println();
    }
  }
}
