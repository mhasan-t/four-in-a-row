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
            this.printGrid();
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
    
//    public static void main(String[] args) {
//        
//        for( int[] d1: grid){
//            for( int v : d1 ){
//                System.out.print(v+" ");
//            }
//            System.out.println(" ");
//        }
//    }
    
}
