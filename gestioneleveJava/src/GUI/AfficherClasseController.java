/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entities.absence;
import entities.classe;
import entities.eleve;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.ClasseService;

/**
 * FXML Controller class
 *
 * @author wejdene
 */
public class AfficherClasseController implements Initializable {
    
  ObservableList<classe> listC = null;
      @FXML
    private TextField filterfield;

    @FXML
    private JFXComboBox<String> salle;

    @FXML
    private JFXTextField nbre;

    @FXML
    private Label lab;
   @FXML
    private AnchorPane rootpane;
    @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField cap;

    @FXML
    private Text add;

    @FXML
    private TableView<classe> tableC;

    @FXML
    private TableColumn<?, ?> nomC;

    @FXML
    private TableColumn<?, ?> nbreC;
     @FXML
    private Label nbe;

    
    ClasseService cs =new ClasseService();
    

    @FXML
    private TableColumn<?, ?> capC;

    @FXML
    private TableColumn<?, ?> salleC;
       ObservableList<String> et = FXCollections.observableArrayList("2B","3A","5N","7H","6D");
       
       
    @FXML
    void addC(ActionEvent event) throws SQLException, IOException {
     
            
String nomm= nom.getText();


 int nb = Integer.parseInt(nbre.getText());
 int capp= Integer.parseInt(cap.getText());
  
   String r = salle.getSelectionModel().getSelectedItem().toString();

  




classe a = new classe();
a.setNom_classe(nomm);
a.setNbre_eleve(nb);
a.setCapacite(capp);
a.setSalle(r);

cs.ajouuterClasse(a);
  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         alert.setHeaderText(null);
         alert.setContentText("Classe" +nomm+ " ajoutée ");
         alert.showAndWait();
         DialogPane dialogPane = alert.getDialogPane();

        try {
            listC = cs.getClasse();
        } catch (SQLException ex) {
            Logger.getLogger(AffichercarnetController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableC.setItems(listC);
        
      
        

    }
    
     @FXML
    void toAbsence(ActionEvent event) throws IOException {
makeFateOutA();
   
    }
              private void makeFateOutA(){
        FadeTransition fadeTransition =new FadeTransition();
        fadeTransition.setDuration(Duration.millis(800));
        fadeTransition.setNode(rootpane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished((ActionEvent event )->{
            try {
                loadNextSceneA();
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            }
        
        );
          
      fadeTransition.play();
    }
    private void loadNextSceneA() throws IOException{
       try { Parent secondView;
        secondView = FXMLLoader.load(getClass().getResource("afficherabsence.fxml"));
        Scene newScene=new Scene(secondView);
        Stage curStage =(Stage) rootpane.getScene().getWindow();
        curStage.setScene(newScene);}
      catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
       @FXML
    void toEleve(ActionEvent event) throws IOException {
 makeFateOutC();
   
    }
         private void makeFateOutC(){
        FadeTransition fadeTransition =new FadeTransition();
        fadeTransition.setDuration(Duration.millis(800));
        fadeTransition.setNode(rootpane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished((ActionEvent event )->{
            try {
                loadNextSceneC();
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            }
        
        );
          
      fadeTransition.play();
    }
    private void loadNextSceneC() throws IOException{
       try { Parent secondView;
        secondView = FXMLLoader.load(getClass().getResource("afficherEleve.fxml"));
        Scene newScene=new Scene(secondView);
        Stage curStage =(Stage) rootpane.getScene().getWindow();
        curStage.setScene(newScene);}
      catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
       @FXML
    void toCarnet(ActionEvent event) throws IOException {
makeFateOutR();
   
    }
         private void makeFateOutR(){
        FadeTransition fadeTransition =new FadeTransition();
        fadeTransition.setDuration(Duration.millis(800));
        fadeTransition.setNode(rootpane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished((ActionEvent event )->{
            try {
                loadNextSceneR();
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            }
        
        );
          
      fadeTransition.play();
    }
    private void loadNextSceneR() throws IOException{
       try { Parent secondView;
        secondView = FXMLLoader.load(getClass().getResource("affichercarnet.fxml"));
        Scene newScene=new Scene(secondView);
        Stage curStage =(Stage) rootpane.getScene().getWindow();
        curStage.setScene(newScene);}
      catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
       @FXML
    void retour(MouseEvent event) throws IOException {
  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

        Parent root2 = FXMLLoader.load(getClass().getResource("affichercarnet.fxml"));
        Scene scene2 = new Scene(root2);
        Stage stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage2.setScene(scene2);
        stage2.centerOnScreen();
        stage2.setTitle("Menu");
        
      stage2.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          int nbee;
      try {
          nbee = cs.TotalEleve();
             nbe.setText(String.valueOf(nbee));
      } catch (SQLException ex) {
          Logger.getLogger(AfficherClasseController.class.getName()).log(Level.SEVERE, null, ex);
      }
     
        
                 nomC.setCellValueFactory(new PropertyValueFactory<>("nom_classe"));
                     capC.setCellValueFactory(new PropertyValueFactory<>("capacite"));
       nbreC.setCellValueFactory(new PropertyValueFactory<>("nbre_eleve"));
        salleC.setCellValueFactory(new PropertyValueFactory<>("salle"));
          
              try {
            listC = cs.getClasse();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableC.setItems(listC); 
        salle.setItems(et);
    }    
    
}
