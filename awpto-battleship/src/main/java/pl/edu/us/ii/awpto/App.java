package pl.edu.us.ii.awpto;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Board board = new Board("maps.txt");
        Gameplay game = new Gameplay(board);
        Random rand = new Random();
        int x, y, i;
        
        System.out.println("---- Start game ----");
        board.showPlayerOneBoard();
        board.showPlayerOneBoard();

        i = 1;
        while(game.checkGame()){
            System.out.println("---- Round " + i + " ----");
            do{
                x = rand.nextInt(board.getWidth());
                y = rand.nextInt(board.getWidth());
            } while(!game.setHit(x, y, 1));
            board.showPlayerOneBoard();
            do{
                x = rand.nextInt(board.getWidth());
                y = rand.nextInt(board.getWidth());
            } while(!game.setHit(x, y, 2));
            board.showPlayerTwoBoard();
            System.out.println();
            i++;
        }
        
        System.out.println("Winner: " + game.whoWin());
    }
}
