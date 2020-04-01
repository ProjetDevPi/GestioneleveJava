/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author oXCToo
 */
public class HomeController implements Initializable {
    
    @FXML
    private Label label;
    
      @FXML
    private VBox pnl_scroll;

    
    @FXML
    private AnchorPane rootpane;
    
    @FXML
    private void handleButtonAction(MouseEvent event) {        
       refreshNodes();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
  
         refreshNodes();
    }    
    
    private void refreshNodes()
    {
        pnl_scroll.getChildren().clear();
        
        Node [] nodes = new  Node[15];
        
       
            try {
                
                nodes[1] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
               pnl_scroll.getChildren().add(nodes[1]);
               
                 nodes[2] = (Node)FXMLLoader.load(getClass().getResource("info.fxml"));
               pnl_scroll.getChildren().add(nodes[2]);
               
                  nodes[3] = (Node)FXMLLoader.load(getClass().getResource("separation.fxml"));
               pnl_scroll.getChildren().add(nodes[3]);
               
               
               
               nodes[4] = (Node)FXMLLoader.load(getClass().getResource("teachers.fxml"));
               pnl_scroll.getChildren().add(nodes[4]);
               
             
               
                
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            
           
        }  
    }
    @FXML
    void inscrir(ActionEvent event) throws IOException {
makeFateOut();
    }
    
    
    private void makeFateOut(){
        FadeTransition fadeTransition =new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(rootpane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event ){
                try {
                    loadNextScene();
                } catch (IOException ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
          
      fadeTransition.play();
    }
    private void loadNextScene() throws IOException{
       try { Parent secondView;
        secondView = FXMLLoader.load(getClass().getResource("inscription.fxml"));
        Scene newScene=new Scene(secondView);
        Stage curStage =(Stage) rootpane.getScene().getWindow();
        curStage.setScene(newScene);}
      catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
      private void makeFateOut1(){
        FadeTransition fadeTransition =new FadeTransition();
        fadeTransition.setDuration(Duration.millis(800));
        fadeTransition.setNode(rootpane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished((ActionEvent event )->{
            try {
                loadNextScene1();
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            }
        
        );
          
      fadeTransition.play();
    }
    private void loadNextScene1() throws IOException{
       try { Parent secondView;
        secondView = FXMLLoader.load(getClass().getResource("carnet.fxml"));
        Scene newScene=new Scene(secondView);
        Stage curStage =(Stage) rootpane.getScene().getWindow();
        curStage.setScene(newScene);}
      catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
       @FXML
    void carnet(ActionEvent event) {
makeFateOut1();
    }
}
