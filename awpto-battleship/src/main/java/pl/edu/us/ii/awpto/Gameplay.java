package pl.edu.us.ii.awpto;

public class Gameplay {
    private Board board;
    private final int PLAYER_ONE_BOARD = 0;
    private final int PLAYER_TWO_BOARD = 1;
    
    public Gameplay(Board board){
        this.board = board;
    }
   
    public boolean isAvailable(int x, int y, int board) {
        if(board == this.PLAYER_ONE_BOARD) {
            return (this.board.getPlayerOneBoard()[x][y] == 'o' || this.board.getPlayerOneBoard()[x][y] == 'x') ? false : true;
        } else if(board == this.PLAYER_TWO_BOARD){
            return (this.board.getPlayerTwoBoard()[x][y] == 'o' || this.board.getPlayerTwoBoard()[x][y] == 'x') ? false : true;
        }
        return false;
    }
    
    public boolean isHit(int x, int y, int board){
        if(board == this.PLAYER_ONE_BOARD) {
            return (this.board.getPlayerOneBoard()[x][y] == '#') ? true : false;
        } else if(board == this.PLAYER_TWO_BOARD){
            return (this.board.getPlayerTwoBoard()[x][y] == '#') ? true : false;
        }
        return false;
    }
    
    public void setHit(int x, int y, int board, boolean isHit){
        if(board == this.PLAYER_ONE_BOARD) {
            if(isHit == true){ 
                this.board.getPlayerOneBoard()[x][y] = 'o';
            } else {
                this.board.getPlayerOneBoard()[x][y] = 'x';
            }         
        } else if(board == this.PLAYER_TWO_BOARD){
            if(isHit == true){ 
                this.board.getPlayerTwoBoard()[x][y] = 'o';
            } else {
                this.board.getPlayerTwoBoard()[x][y] = 'x';
            }
        }
    }
    
    public boolean matrixIsSquare(char[][] map){
        for(int i = 0; i < map.length; i++){
            if(map.length != map[i].length){ return false; }
        }
        
        return true;
    }
    
    public boolean checkGame(){
        int state = 0;
        for(int i = 0; i < this.board.getHeight(); i++){
            for(int j = 0; j < this.board.getWidth(); j++){
                if(this.board.getPlayerOneBoard()[i][j] == '#' || this.board.getPlayerTwoBoard()[i][j] == '#'){
                    state++;
                }
            }
        }
        
        return (state > 0 ? true : false);
        
    }
    
    public boolean areEqual(char[][] map1, char[][] map2){
        if(map1.length != map2.length){ return false; };
        for(int i = 0; i < map1.length; i++){
            if(map1[i].length != map2[i].length){ return false; }
        }
        
        return true;
    }
}
