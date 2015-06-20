package pl.edu.us.ii.awpto;

import org.junit.Assert;
import org.junit.Test;

public class AppTest{
	
	@Test
	public void boardsAreNotEmptyOne(){
		// Arrange
		Board board = new Board("maps.txt");
		
		// Act 
		char[][] result = board.getPlayerOneBoard();

		// Assert
		Assert.assertNotNull(result);
	}

	@Test
	public void boardsAreNotEmptyTwo(){
		// Arrange
		Board board = new Board("maps.txt");
		
		// Act 
		char[][] result = board.getPlayerTwoBoard();

		// Assert
		Assert.assertNotNull(result);
	}
	
	@Test
	public void boardsAreEmptyOne(){
		// Arrange
		Board board = new Board();
		
		// Act
		char[][] result = board.getPlayerOneBoard();
		
		// Assert
		Assert.assertNull(result);
	}

	@Test
	public void boardsAreEmptyTwo(){
		// Arrange
		Board board = new Board();
		
		// Act
		char[][] result = board.getPlayerTwoBoard();
		
		// Assert
		Assert.assertNull(result);
	}	
	
	@Test
	public void boardsOneIsMartix(){
		// Arrange
		Board board = new Board("maps.txt");
		Gameplay game = new Gameplay(board);
		
		// Act
		boolean result = game.isMatrix(board.getPlayerOneBoard());
		
		// Assert
		Assert.assertTrue(result);
	}

	@Test
	public void boardsTwoIsMartix(){
		// Arrange
		Board board = new Board("maps.txt");
		Gameplay game = new Gameplay(board);
		
		// Act
		boolean result = game.isMatrix(board.getPlayerTwoBoard());
		
		// Assert
		Assert.assertTrue(result);
	}
	
	@Test
	public void boardOneIsNotMatrix(){
		// Arrange
		Board board = new Board();
		Gameplay game = new Gameplay(board);
		char[][] playerOneBoard = {
				{'~','~','~','~'},
				{'#','#','#','~'},
				{'x','o','x','x'}
		};
		
		// Act
		boolean result = game.isMatrix(playerOneBoard);
		
		Assert.assertFalse(result);
	}

	@Test
	public void boardTwoIsNotMatrix(){
		// Arrange
		Board board = new Board();
		Gameplay game = new Gameplay(board);
		char[][] playerTwoBoard = {
				{'~','~','~'},
				{'#','x','x'},
				{'o','#','x'},
				{'~','~','#'}
		};
		
		// Act
		boolean result = game.isMatrix(playerTwoBoard);

		Assert.assertFalse(result);
	}
	
	@Test
	public void boardsAreEqual(){
		// Arrange
		Board board = new Board("maps.txt");
		Gameplay game = new Gameplay(board);
		
		// Act 
		boolean result = game.areEqual(board.getPlayerOneBoard(), board.getPlayerTwoBoard());
		
		// Assert
		Assert.assertTrue(result);
	}
	
	@Test
	public void gameIsNotFinished(){
		// Arrange
		Board board = new Board("maps.txt");
		Gameplay game = new Gameplay(board);
		
		// Act 
		boolean result = game.checkGame();
		
		// Assert
		Assert.assertTrue(result);
	}
	
	@Test
	public void gameIsFinished(){
		// Arrange
		Board board = new Board("filledmaps.txt");
		Gameplay game = new Gameplay(board);
		
		// Act 
		boolean result = game.checkGame();
		
		// Assert
		Assert.assertFalse(result);
	}
	
	@Test
	public void fieldIsHit(){
		// Arrange
		Board board = new Board("maps.txt");
		Gameplay game = new Gameplay(board);
		
		//Act
		boolean result = game.isHit(0, 8, 1);
	
		// Assert
		Assert.assertTrue(result);
	}
	
	@Test
	public void fieldIsNotHit(){
		// Arrange
		Board board = new Board("maps.txt");
		Gameplay game = new Gameplay(board);
		
		//Act
		boolean result = game.isHit(0, 7, 1);
	
		// Assert
		Assert.assertFalse(result);
	}
	
	@Test
	public void fieldIsAvailable(){
		// Arrange
		Board board = new Board("maps.txt");
		Gameplay game = new Gameplay(board);
		
		//Act
		boolean result = game.isAvailable(0, 6, 1);
	
		// Assert
		Assert.assertTrue(result);
	}
	

	@Test
	public void fieldIsNotAvailable(){
		// Arrange
		Board board = new Board("filledmaps.txt");
		Gameplay game = new Gameplay(board);
		
		//Act
		boolean result = game.isAvailable(0, 8, 1);
	
		// Assert
		Assert.assertFalse(result);
	}
	
	@Test
	public void playerShootInsideOfBoard(){
		// Arrange
		Board board = new Board("maps.txt");
		Gameplay game = new Gameplay(board);
		
		// Act
		boolean result = game.isInsideOfBoard(6, 8, 1);
		
		// Assert
		Assert.assertTrue(result);
	}
	
	@Test
	public void playerShootOutsideOfBoard(){
		// Arrange
		Board board = new Board("maps.txt");
		Gameplay game = new Gameplay(board);
		
		// Act
		boolean result = game.isInsideOfBoard(10, 32, 1);
		
		// Assert
		Assert.assertFalse(result);
	}
	
	@Test
	public void whoWinTheGame(){
		// Arrange
		Board board = new Board("filledmaps.txt");
		Gameplay game = new Gameplay(board);
		
		// Act 
		String result = game.whoWin();
		
		// Assert
		Assert.assertSame("PLAYER ONE", result);
	}
	
	@Test
	public void whoLooseTheGame(){
		// Arrange
		Board board = new Board("filledmaps.txt");
		Gameplay game = new Gameplay(board);
		
		// Act 
		String result = game.whoWin();
		
		// Assert
		Assert.assertNotSame("PLAYER TWO", result);
	}
	
	@Test
	public void playerHitShip(){
		// Arrange
		Board board = new Board("maps.txt");
		Gameplay game = new Gameplay(board);
		
		// Act 
		game.setHit(0, 8, 1);
		char result = board.getPlayerOneBoard()[0][8];
		
		// Assert
		Assert.assertSame('o', result);	
	}
	
	@Test
	public void playerHitShipCheckReturn(){
		// Arrange
		Board board = new Board("maps.txt");
		Gameplay game = new Gameplay(board);
		
		// Act 
		boolean result = game.setHit(0, 8, 1); 
		
		// Assert
		Assert.assertTrue(result);
	}
	
	@Test
	public void playerNotHitShip(){
		// Arrange
		Board board = new Board("maps.txt");
		Gameplay game = new Gameplay(board);
		
		// Act 
		game.setHit(1, 6, 1);
		char result = board.getPlayerOneBoard()[1][6];
		
		// Assert
		Assert.assertSame('x', result);
		
	}
	
	@Test
	public void playerNotHitShipCheckReturn(){
		// Arrange
		Board board = new Board("filledmaps.txt");
		Gameplay game = new Gameplay(board);
		
		// Act 
		boolean result = game.setHit(0, 8, 1); 
		
		// Assert
		Assert.assertFalse(result);
	}
	
	@Test
	public void boardHaveTheSameNumberOfShips() {
		// Arrange
		Board board = new Board("maps.txt");
		Gameplay game = new Gameplay(board);
		
		// Act
		boolean result = game.numberOfShipsIsEqual();
		
		// Assert
		Assert.assertTrue(result);
	}
	@Test
	public void boardHaveNotTheSameNumberOfShips() {
		// Arrange
		Board board = new Board("filledmaps.txt");
		Gameplay game = new Gameplay(board);
		
		// Act
		boolean result = game.numberOfShipsIsEqual();
		
		// Assert
		Assert.assertFalse(result);
	}
	
	@Test
	public void checkPerformanceOfNextMove(){
		// Arrange
		Board board = new Board("maps.txt");
		Gameplay game = new Gameplay(board);
		
		// Act
		game.setHit(4, 7, 1);
		int result = 0;
		for (int i = 0; i < board.getHeight(); i++) {
		  for (int j = 0; j < board.getWidth(); j++) {
		    if ((board.getPlayerOneBoard()[i][j] == 'o') || (board.getPlayerOneBoard()[i][j] == 'x')) {
		    	result++;
		    }
		  }
		}
		
		// Assert
		Assert.assertTrue(result > 2);
	}
	
	@Test
	public void checkNotPerformanceOfNextMove(){
		// Arrange
		Board board = new Board("maps.txt");
		Gameplay game = new Gameplay(board);
		
		// Act
		game.setHit(0, 7, 1);
		int result = 0;
		for (int i = 0; i < board.getHeight(); i++) {
		  for (int j = 0; j < board.getWidth(); j++) {
		    if ((board.getPlayerOneBoard()[i][j] == 'o') || (board.getPlayerOneBoard()[i][j] == 'x')) {
		    	result++;
		    }
		  }
		}
		
		// Assert
		Assert.assertTrue(result == 1);
	}
}