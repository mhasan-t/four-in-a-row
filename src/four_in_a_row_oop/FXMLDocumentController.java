/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package four_in_a_row_oop;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 *
 * @author Tahnoon
 */
public class FXMLDocumentController implements Initializable {

    final PlayingGrid playingGrid = new PlayingGrid();
    
    @FXML
    private GridPane gridBoard;
    
    
    @FXML
    private Button c00, c01, c02, c03, c04, c05, c06,
                                  c10, c11, c12, c13, c14, c15, c16,
                                c20, c21, c22, c23, c24, c25, c26,
                                c30, c31, c32, c33, c34, c35, c36,
                                c40, c41, c42, c43, c44, c45, c46,
                                c60, c61, c62, c63, c64, c65, c66,
                                restartBtn;
   
    
    @FXML
    private Circle turnIndicator;
    @FXML
    private Label turnIndicatorText, winMsg;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
//        System.out.println("YOU CLICKED "+ ((Control)event.getSource()).getId()   );
        String id = ((Control)event.getSource()).getId();
        int row = Character.getNumericValue(id.toCharArray()[1]);
        int column = Character.getNumericValue(id.toCharArray()[2]);
        
        Button clickedBtn = (Button) ((Control)event.getSource()).getScene().lookup("#"+id);
        int emptyRow = playingGrid.getEmptyHole(column);
        if( emptyRow != -1){
            String btnToColorId = "c"+emptyRow+column;
            Button btnToColor =  (Button) ((Control)event.getSource()).getScene().lookup("#"+btnToColorId);
            if(playingGrid.currentPlayer == 1){
                btnToColor.setStyle("-fx-background-color: #ff0000; -fx-background-radius: 100");
            }
            else{
                btnToColor.setStyle("-fx-background-color: #0dff00; -fx-background-radius: 100");
            }
            changeIndicator();
        }
        int emptyH = playingGrid.getEmptyHole(column);
        playingGrid.onPlay(column);
        if( emptyH != -1){
            int winner = playingGrid.checkForWin(emptyH, column);
            if( winner == 1 ){
                disableButtons();
                winMsg.setStyle("-fx-text-fill: #ff0000");
                winMsg.setText("WINNER IS PLAYER ONE");
            }
            if (winner == 2){
                disableButtons();
                winMsg.setStyle("-fx-text-fill: #0dff00");
                winMsg.setText("WINNER IS PLAYER TWO");
            }
        }
        
        
        
    }
    
    
    @FXML
    void restartGame(ActionEvent event) {
            playingGrid.restartGame();
            for(int r =0; r<7; r++){
                for(int c =0; c<7; c++){
                    Button btnTemp = (Button) ((Control)event.getSource()).getScene().lookup("#c"+r+c);
                    btnTemp.setStyle("-fx-background-radius: 100; -fx-background-color:  #aaaaaa");
                }
            }
            enableButtons();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if ( playingGrid.currentPlayer == 1 ){
            turnIndicatorText.setText("One");
            turnIndicatorText.setStyle("-fx-text-fill: #ff0000");
            turnIndicator.setStyle("-fx-fill: #ff0000");
        }
        else{
            turnIndicatorText.setText("Two");
            turnIndicatorText.setStyle("-fx-text-fill: #ff0000");
            turnIndicator.setStyle("-fx-fill: #0dff00");
        }
    }    
    
    
    
    
    void changeIndicator(){
        if( turnIndicator.getStyle() == "-fx-fill: #ff0000" ){
            turnIndicatorText.setStyle("-fx-text-fill: #0dff00");
            turnIndicatorText.setText("Two");
            turnIndicator.setStyle("-fx-fill: #0dff00");
        }
        else{
            turnIndicatorText.setText("One");
            turnIndicatorText.setStyle("-fx-text-fill: #ff0000");
            turnIndicator.setStyle("-fx-fill: #ff0000");
        }
    }
    
    void disableButtons(){
        for(int r =0; r<7; r++){
                for(int c =0; c<7; c++){
                    Button btnTemp = (Button) c00.getScene().lookup("#c"+r+c);
                    btnTemp.setDisable(true);
                }
        }
    }
    
    void enableButtons(){
        for(int r =0; r<7; r++){
                for(int c =0; c<7; c++){
                    Button btnTemp = (Button) c00.getScene().lookup("#c"+r+c);
                    btnTemp.setDisable(false);
                }
        }
    }
   
    
}
