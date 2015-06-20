package pl.edu.us.ii.awpto;

import java.util.Random;

public class Gameplay {
  private Board board;
  private final int playerOneBoard = 1;
  private final int playerTwoBoard = 2;
  private final int leftHit = 1;
  private final int topHit = 2;
  private final int rightHit = 3;
  private final int bottomHit = 4;
  private boolean isHit;
  private Random rand;
  public Gameplay(){}
  /**
   * Kontruktor klasy Gameplay.  
   * @param board obiekt klasy Board
   */
  public Gameplay(Board board) { 
    this.board = board;
    this.isHit = false;
    this.rand = new Random();
  }
  /**
   * Sprawdza czy pole jest dostepne.
   * @param pointX pierwszy wymiar tablicy
   * @param pointY drugi wymiar tablicy
   * @param board zmienna okreslajaca, na ktorej planszy operujemy
   * @return true albo false
   */
  public boolean isAvailable(int pointX, int pointY, int board) {
    if (board == this.playerOneBoard) {
      return (this.board.getPlayerOneBoard()[pointX][pointY] == 'o' 
        || this.board.getPlayerOneBoard()[pointX][pointY] == 'x') ? false : true;
    } else if (board == this.playerTwoBoard) {
      return (this.board.getPlayerTwoBoard()[pointX][pointY] == 'o' 
        || this.board.getPlayerTwoBoard()[pointX][pointY] == 'x') ? false : true;
    }
    return false;
  }
    
  public boolean isHit(int pointX, int pointY, int board) {
    if (board == this.playerOneBoard) {
      return (this.board.getPlayerOneBoard()[pointX][pointY] == '#') ? true : false;
    } else if (board == this.playerTwoBoard) {
      return (this.board.getPlayerTwoBoard()[pointX][pointY] == '#') ? true : false;
    }
    return false;
  }
  /**
   * Sprawdza czy znajdujemy sie na planszy.  
   * @param pointX pierwszy wymiar tablicy
   * @param pointY drugi wymiar tablicy
   * @param board zmienna okreslajaca, na ktorej planszy operujemy
   * @return true albo false
   */
  public boolean isInsideOfBoard(int pointX, int pointY, int board) {
    if (board == this.playerOneBoard || board == this.playerTwoBoard) {
      return (pointX > (this.board.getHeight() - 1) || pointX < 0 
        || pointY > (this.board.getWidth() - 1) || pointY < 0) 
        ? false : true;
    } 
        
    return false;
  }
  /**
   * Ustawia uderzenie.  
   * @param pointX pierwszy wymiar tablicy
   * @param pointY drugi wymiar tablicy
   * @param board board zmienna okreslajaca, na ktorej planszy operujemy
   * @return true albo false
   */
  public boolean setHit(int pointX, int pointY, int board) {
    if (this.isInsideOfBoard(pointX, pointY, board)) {
      if (this.isAvailable(pointX, pointY, board)) {
        this.isHit = this.isHit(pointX, pointY, board);
        if (board == this.playerOneBoard) {
          if (this.isHit == true) { 
            this.board.getPlayerOneBoard()[pointX][pointY] = 'o';
            switch (rand.nextInt(4) + 1) {
              case leftHit: pointY -= 1;
                    break;
              case rightHit: pointY += 1;
                    break;
              case topHit: pointX -= 1;
                    break;
              case bottomHit: pointX += 1;
                    break;
              default: System.out.println("Nie ma takiego ruchu.");
            }
                        
            setHit(pointX, pointY, board);
          } else {
            this.board.getPlayerOneBoard()[pointX][pointY] = 'x';
          }     
        } else if (board == this.playerTwoBoard) {
          if (this.isHit == true) { 
            this.board.getPlayerTwoBoard()[pointX][pointY] = 'o';
            switch (rand.nextInt(4) + 1) {
              case leftHit: pointY -= 1;
                  break;
              case rightHit: pointY += 1;
                  break;
              case topHit: pointX -= 1;
                  break;
              case bottomHit: pointX += 1;
                  break;
              default: System.out.println("Nie ma takiego ruchu.");
            }            
            setHit(pointX, pointY, board);
          } else {
            this.board.getPlayerTwoBoard()[pointX][pointY] = 'x';
          }
        }
      } else {
        return false;
      }
    } else {
      return false;
    }      
    return true;
  }
  /**
   * Sprawdza czy macierze sa kwadratowe.  
   * @param board wykorzystywana do pobrania dlugosci planszy
   * @return true albo false
   */
  public boolean isMatrix(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      if (board.length != board[i].length) {
        return false; 
      }
    }    
    return true;
  }
  /**
   * Sprawdza czy gra nie jest skonczona.
   * @return true albo false
   */
  public boolean checkGame() {
    int boardOneState = 0;
    int boardTwoState = 0;
    for (int i = 0; i < this.board.getHeight(); i++) {
      for (int j = 0; j < this.board.getWidth(); j++) {
        if (this.board.getPlayerOneBoard()[i][j] == '#') {
          boardOneState++;
        }
        if (this.board.getPlayerTwoBoard()[i][j] == '#') {
          boardTwoState++;
        }
      }
    }
    if (boardOneState == 0) {
      return false;
    } else if (boardTwoState == 0) {
      return false;
    }
    return true;    
  }
  /**
   * Sprawdza czy plansze są równe.  
   * @param boardOne plansza gracza nr 1
   * @param boardTwo plansza gracza nr 2
   * @return true albo false
   */
  public boolean areEqual(char[][] boardOne, char[][] boardTwo) {
    if (boardOne.length != boardTwo.length) { 
      return false; 
    }
    for (int i = 0; i < boardOne.length; i++) {
      if (boardOne[i].length != boardTwo[i].length) { 
        return false; 
      }
    }  
    return true;
  }
  /**  
   * Sprwadza, ktory gracz wygral.
   * @return String object
   */
  public String whoWin() {
    String winner = "NOONE";
    int boardOneState = 0;
    int boardTwoState = 0;
    for (int i = 0; i < this.board.getHeight(); i++) {
      for (int j = 0; j < this.board.getWidth(); j++) {
        if (this.board.getPlayerOneBoard()[i][j] == '#') {
          boardOneState++;
        }
        if (this.board.getPlayerTwoBoard()[i][j] == '#') {
          boardTwoState++;
        }
      }
    }
    if (boardOneState == 0) {
      winner = "PLAYER ONE";
    } else if (boardTwoState == 0) {
      winner = "PLAYER TWO";
    }
    return winner;
  }
    
  public boolean getIsHit() {
    return this.isHit;
  }
  /**
   * Sprawdza czy statki sie zgadzaja.
   * @return true albo false
   */
  public boolean numberOfShipsIsEqual() {
	int playerOne = 0;
	int playerTwo = 0;
	for(int i = 0; i < this.board.getHeight(); i++){
	  for(int j = 0; j < this.board.getWidth(); j++){
		if(this.board.getPlayerOneBoard()[i][j] == '#') {
		  playerOne++;
		}
		if(this.board.getPlayerTwoBoard()[i][j] == '#') {
		  playerTwo++;
		}
      }
	}
	return (playerOne == playerTwo ? true : false);
  }

}
