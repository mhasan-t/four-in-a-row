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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Tahnoon
 */
public class MenuSceneController implements Initializable {
    @FXML
    private Button newGame;

    
     @FXML
     private TextField playerOneNameField, playerTwoNameField;
    /**
     * Initializes the controller class.
     */
    
    public void newGameFunc(ActionEvent event) throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        Parent newGameParent = (Parent) loader.load();
//         Parent menuSceneRoot = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
         
         
         FXMLDocumentController controller  = loader.getController();
         controller.getNames(playerOneNameField.getText(), playerTwoNameField.getText());
         controller.initialize(null, null);
         
         Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
         Scene newGameScene = new Scene(newGameParent);
         
         window.setScene(newGameScene);
         window.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
