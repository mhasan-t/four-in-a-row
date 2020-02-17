/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package four_in_a_row_oop;

import java.util.Random;

/**
 *
 * @author Tahnoon
 */
public class PlayingGrid {
    Random r = new Random();
    
    
    
    private final int playerOne = 1;
    private final int playerTwo = 2;
    int currentPlayer = r.nextInt((2 - 1) + 1) + 1;;
    private int[][] grid=new int[7][7];
    
    void setValue(int r, int c){
        if(grid[r][c] == 0){ 
            grid[r][c] = this.currentPlayer; 
            this.changePlayer();
        }
        this.printGrid();
    }
    
    
    void onPlay(int col){
        int emptyHole = getEmptyHole(col);
        
        if( emptyHole != -1 ){
            grid[emptyHole][col] = this.currentPlayer;
            this.changePlayer();
//            this.checkForWin(emptyHole, col);
//            this.printGrid();
        }
    }
    
    
    int getEmptyHole(int col){
        int emptyHole = -1;
        
        for(int i=6; i>=0; i--){
            if( grid[i][col] ==  0 ){
                emptyHole = i;
                break;
            }
        }
        return emptyHole;
    }
    
    
    boolean valueExists(int r, int c){
         if(grid[r][c] == 0){ 
             return false;
         }
         else{
             return true;
         }
    }
    
    void changePlayer(){
        if (this.currentPlayer == this.playerOne){
            this.currentPlayer = this.playerTwo;
        }
        else{
            this.currentPlayer = this.playerOne;
        }
    }
    
    void printGrid(){
        for( int[] d1: grid){
            for( int v : d1 ){
                System.out.print(v+" ");
            }
            System.out.println(" ");
        }
    }
    
    void restartGame(){
        for(int r =0; r<7; r++){
            for(int c =0; c<7; c++){
                grid[r][c] = 0;
            }
        }
        printGrid();
    }
    
    
    int checkForWin(int row, int col){
//        System.out.println("CHECKING FOR "+row+"  "+col);
        
        //checking for vertical match ------------------
        int vCount = 1;
        for (int x=1; x<4 ; x++){
            if( (x+row) <= 6  ){
                if(grid[row][col] == grid[row+x][col] ){
                    vCount++;
//                    System.out.println("COUNTIN row "+row+" col "+col+ " x "+ x);
                }
                else{
                    break;
                }
            }
        }
        
        
        //checking for horizontal match -----------------
        int hCount = 1;
        //left side
        for ( int x = 1; x < 4 ; x++){
            if( x + col <=6 ){
                if ( grid[row][col] == grid[row][col+x] ){
                    hCount++;
                }
            }
            
            //right side
            if( col-x >= 0 ){
                if ( grid[row][col] == grid[row][col-x] ){
                    hCount++;
                }
            }
        }
        
        
        //checking for left-right diagnoal match --------------
        int lrDiagonalCount = 1;
        
        for( int x = 1; x < 4; x ++ ){
            //to right-bottom
            if( x+col <=6 && x+row <= 6 ){
                if( grid[row][col]  ==  grid[row+x][col+x] ){
                    lrDiagonalCount++;
                }
            }
            
            //to left-top
            if ( col-x >=0 && row -x >=0 ){
                if( grid[row][col] ==  grid[row-x][col-x] ){
                    lrDiagonalCount++;
                }
            }
            
        }
        
        
        
         //checking for right-left diagnoal match --------------
        int rlDiagonalCount = 1;
        
        for( int x = 1; x < 4; x ++ ){
            //count toward right top
            if( x+col <=6 && row-x >= 0 ){
                if( grid[row][col]  ==  grid[row-x][col+x] ){
                    rlDiagonalCount++;
                    int z = row-x;
                    int y = col+x;
//                    System.out.println("match "+row+" "+col+"  with "+z+" "+y);
                }
            }
            
            //towards left-bottom
            if( x+row <=6 && col-x >= 0 ){
                if( grid[row][col]  ==  grid[row+x][col-x] ){
                    rlDiagonalCount++;
                }
            }
            
        }
        
//        System.out.println("hcount "+ hCount+ "  v "+vCount+"  rl d "+ rlDiagonalCount+ "  lrd  "+lrDiagonalCount);
        
        if ( hCount>=4 || vCount>=4 || lrDiagonalCount>=4 || rlDiagonalCount>=4 ){
            if( currentPlayer == 1 ){
                System.out.println("WINNER 2");
                return 2;
            }
            else{
                System.out.println("WINNER 1");
                return 1;
            }
        }
        return -1;
    }
    

    
}
