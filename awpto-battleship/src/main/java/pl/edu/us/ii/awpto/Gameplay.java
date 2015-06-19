package pl.edu.us.ii.awpto;

import java.util.Random;

public class Gameplay {
    private Board board;
    private final int PLAYER_ONE_BOARD = 1;
    private final int PLAYER_TWO_BOARD = 2;
    private final int LEFT_HIT = 1;
    private final int TOP_HIT = 2;
    private final int RIGHT_HIT = 3;
    private final int BOTTOM_HIT = 4;
    private boolean isHit;
    private Random rand;
    
    public Gameplay(Board board){
        this.board = board;
        this.isHit = false;
        this.rand = new Random();
    }
   
    public boolean isAvailable(int x, int y, int board) {
        if(board == this.PLAYER_ONE_BOARD) {
            return (this.board.getPlayerOneBoard()[x][y] == 'o' || this.board.getPlayerOneBoard()[x][y] == 'x') ? false : true;
        } else if(board == this.PLAYER_TWO_BOARD){
            return (this.board.getPlayerTwoBoard()[x][y] == 'o' || this.board.getPlayerTwoBoard()[x][y] == 'x') ? false : true;
        }
        return false;
    }
    
    private boolean isHit(int x, int y, int board){
        if(board == this.PLAYER_ONE_BOARD) {
            return (this.board.getPlayerOneBoard()[x][y] == '#') ? true : false;
        } else if(board == this.PLAYER_TWO_BOARD){
            return (this.board.getPlayerTwoBoard()[x][y] == '#') ? true : false;
        }
        return false;
    }
    
    public boolean isInsideOfBoard(int x, int y, int board){
        if(board == this.PLAYER_ONE_BOARD || board == this.PLAYER_TWO_BOARD){
            return (x > (this.board.getHeight() - 1) || x < 0 || y > (this.board.getWidth() - 1) || y < 0) 
                    ? false : true;
        } 
        
        return false;
    }
    
    public boolean setHit(int x, int y, int board){
        if(this.isInsideOfBoard(x, y, board)){
            if(this.isAvailable(x, y, board)){
                this.isHit = this.isHit(x, y, board);
                if(board == this.PLAYER_ONE_BOARD) {
                    if(this.isHit == true){ 
                        this.board.getPlayerOneBoard()[x][y] = 'o';
                        switch(rand.nextInt(4) + 1){
                            case LEFT_HIT: y -= 1;
                                break;
                            case RIGHT_HIT: y += 1;
                                break;
                            case TOP_HIT: x -= 1;
                                break;
                            case BOTTOM_HIT: x += 1;
                                break;
                        }
                        
                        setHit(x, y, board);
                    } else {
                        this.board.getPlayerOneBoard()[x][y] = 'x';
                    }     
                } else if(board == this.PLAYER_TWO_BOARD){
                    if(this.isHit == true){ 
                        this.board.getPlayerTwoBoard()[x][y] = 'o';
                        switch(rand.nextInt(4) + 1){
                            case LEFT_HIT: y -= 1;
                                break;
                            case RIGHT_HIT: y += 1;
                                break;
                            case TOP_HIT: x -= 1;
                                break;
                            case BOTTOM_HIT: x += 1;
                                break;
                        }
                        
                        setHit(x, y, board);
                    } else {
                        this.board.getPlayerTwoBoard()[x][y] = 'x';
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
    
    public boolean matrixIsSquare(char[][] map){
        for(int i = 0; i < map.length; i++){
            if(map.length != map[i].length){ return false; }
        }
        
        return true;
    }
    
    public boolean checkGame(){
        int boardOneState = 0;
        int boardTwoState = 0;
        for(int i = 0; i < this.board.getHeight(); i++){
            for(int j = 0; j < this.board.getWidth(); j++){
                if(this.board.getPlayerOneBoard()[i][j] == '#'){
                    boardOneState++;
                }
                if(this.board.getPlayerTwoBoard()[i][j] == '#'){
                    boardTwoState++;
                }
            }
        }
        if(boardOneState == 0){
            return false;
        } else if(boardTwoState == 0){
            return false;
        }
        return true;
        
    }
    
    public boolean areEqual(char[][] map1, char[][] map2){
        if(map1.length != map2.length){ return false; };
        for(int i = 0; i < map1.length; i++){
            if(map1[i].length != map2[i].length){ return false; }
        }
        
        return true;
    }
    public String whoWin(){
        String winner = "NOONE";
        int boardOneState = 0;
        int boardTwoState = 0;
        for(int i = 0; i < this.board.getHeight(); i++){
            for(int j = 0; j < this.board.getWidth(); j++){
                if(this.board.getPlayerOneBoard()[i][j] == '#'){
                    boardOneState++;
                }
                if(this.board.getPlayerTwoBoard()[i][j] == '#'){
                    boardTwoState++;
                }
            }
        }
        if(boardOneState == 0){
            winner = "PLAYER ONE";
        } else if(boardTwoState == 0){
            winner = "PLAYER TWO";
        }
        return winner;
    }
    
    public boolean getIsHit(){
        return this.isHit;
    }

}
