package pl.edu.us.ii.awpto;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Random;
import java.util.Scanner;


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
    
    public Board(String fileName){
        this.in = Board.class.getClassLoader().getResourceAsStream(fileName);
        this.reader = new InputStreamReader(in);
        
        this.height = 1;
        this.width = 0;

        initBoards();
    }
    
    public void initBoards(){
        int c;
        String map = "";
        String[] tmp;
        
        try {
            while((c = this.reader.read()) != -1){
                this.width++;
                if(c == 10) this.height++;
                map = map + (char) c;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        this.width = (((this.width - (this.height * 3)) / this.height) + 1) / 2;
        map = map.replaceAll("\r\n", " ");
        tmp = map.split(" ");

        playerOneBoard = new char[this.height][this.width];
        playerTwoBoard = new char[this.height][this.width];
        
        int even = 0; //parzyste jako wiersze 1 mapy
        int odd = 1; //nieparzyste jako wiersze 2 mapy
        for(int i = 0; i < this.height; i++){
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
    public void showPlayerOneBoard(){
        System.out.println("Player one");
        System.out.print("    ");
        for(int i = 0; i < this.width; i++){ 
            System.out.print(i + "   ");
            
        }
        System.out.println();
        for(int i = 0; i <= this.width; i++){ 
            System.out.print("_" + "   ");
        }
        System.out.println();
        for(int i = 0; i < this.height; i++){
            System.out.print(i + (i >= 10 ? "| " : "|  "));
            for(int j = 0; j < this.width; j++){
                System.out.print(this.playerOneBoard[i][j] + "   ");
            }
            System.out.println();
        }
    }
    
    public void showPlayerTwoBoard(){
        System.out.println("Player two");
        System.out.print("    ");
        for(int i = 0; i < this.width; i++){ 
            System.out.print(i + "   ");
        }
        System.out.println();
        for(int i = 0; i <= this.width; i++){ 
            System.out.print("_" + "   ");
        }
        System.out.println();
        for(int i = 0; i < this.height; i++){
            System.out.print(i + (i >= 10 ? "| " : "|  "));
            for(int j = 0; j < this.width; j++){
                System.out.print(this.playerTwoBoard[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
