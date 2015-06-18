package pl.edu.us.ii.awpto;

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
        
        board.showPlayerOneBoard();
        board.showPlayerTwoBoard();
        System.out.print(game.isHit(0, 9, 0));
        board.showPlayerOneBoard();
        game.setHit(0, 9, 0, game.isHit(0, 9, 0));
        board.showPlayerOneBoard();
        System.out.println(game.checkGame());
    }
}
