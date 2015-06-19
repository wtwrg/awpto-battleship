package pl.edu.us.ii.awpto;

import java.util.Random;

/** 
 * The battleship game.
 *
 */
public class App{
  /**
   * The main method. 
   * @param args for arguments
   */
  public static void main(String[] args) {
    Board board = new Board("maps.txt");
    Random rand = new Random();
    int pointX; 
    int pointY; 
    int iterations = 1;
    System.out.println("---- Start game ----");
    board.showPlayerOneBoard();
    board.showPlayerOneBoard();
    Gameplay game = new Gameplay(board);
    if (game.areEqual(board.getPlayerOneBoard(), board.getPlayerTwoBoard()) 
        || game.isMatrix(board.getPlayerOneBoard())) {
      while (game.checkGame()) {
        System.out.println("---- Round " + iterations + " ----");
        do {
          pointX = rand.nextInt(board.getWidth());
          pointY = rand.nextInt(board.getWidth());
        } while (!game.setHit(pointX, pointY, 1));
        board.showPlayerOneBoard();
        do {
          pointX = rand.nextInt(board.getWidth());
          pointY = rand.nextInt(board.getWidth());
        } while (!game.setHit(pointX, pointY, 2));
        board.showPlayerTwoBoard();
        System.out.println();
        iterations++;
      }
              
      System.out.println("Winner: " + game.whoWin());  
    } else {
      System.out.println("Nie mozna rozegrac gry.");
    }
  }
}
