package pl.edu.us.ii.awpto;

import org.junit.Assert;
import org.junit.Test;

public class AppTest{
	
	@Test
	public void boardsAreNotEmpty(){
		// Arrange
		Board board = new Board("maps.txt");
		
		// Act 
		char[][] result1 = board.getPlayerOneBoard();
		char[][] result2 = board.getPlayerTwoBoard();
		// Assert
		Assert.assertNotNull(result1);
		Assert.assertNotNull(result2);
	}
	
	@Test
	public void boardsAreEmpty(){
		// Arrange
		Board board = new Board();
		
		// Act
		char[][] result1 = board.getPlayerOneBoard();
		char[][] result2 = board.getPlayerTwoBoard();
		
		// Assert
		Assert.assertNull(result1);
		Assert.assertNull(result2);
	}
	
	@Test
	public void boardsAreMartix(){
		// Arrange
		Board board = new Board("maps.txt");
		Gameplay game = new Gameplay(board);
		
		// Act
		boolean result1 = game.isMatrix(board.getPlayerOneBoard());
		boolean result2 = game.isMatrix(board.getPlayerTwoBoard());
		
		// Assert
		Assert.assertTrue(result1);
		Assert.assertTrue(result2);
	}
	
	@Test
	public void boardAreNotMatrix(){
		// Arrange
		Board board = new Board();
		Gameplay game = new Gameplay(board);
		char[][] playerOneBoard = {
				{'~','~','~','~'},
				{'#','#','#','~'},
				{'x','o','x','x'}
		};
		char[][] playerTwoBoard = {
				{'~','~','~'},
				{'#','x','x'},
				{'o','#','x'},
				{'~','~','#'}
		};
		
		// Act
		boolean result1 = game.isMatrix(playerOneBoard);
		boolean result2 = game.isMatrix(playerTwoBoard);
		
		Assert.assertFalse(result1);
		Assert.assertFalse(result2);
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
	
}