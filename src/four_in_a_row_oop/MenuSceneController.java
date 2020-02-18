/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package four_in_a_row_oop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Tahnoon
 */
public class MenuSceneController implements Initializable {
    @FXML
    private Button newGame;

    /**
     * Initializes the controller class.
     */
    
    public void newGameFunc(ActionEvent event) throws IOException{
         Parent menuSceneRoot = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
         Scene newGameScene = new Scene(menuSceneRoot);
         
         Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
         
         window.setScene(newGameScene);
         window.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
