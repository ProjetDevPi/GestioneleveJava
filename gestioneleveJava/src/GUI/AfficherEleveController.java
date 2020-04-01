/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import entities.classe;
import entities.eleve;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.EleveService;
import utils.MyConnection;
 import java.util.ArrayList;
import java.util.Optional;
import javafx.animation.FadeTransition;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import utils.MailSend;

/**
 * FXML Controller class
 *
 * @author wejdene
 */
public class AfficherEleveController implements Initializable {
       ObservableList<eleve> listE = null;
        ObservableList<eleve> listEl = null;
    @FXML
    private TableView<eleve> tableE;
     ObservableList<String> et = FXCollections.observableArrayList("Krech","Garderie","Pretaratoire","All");
    @FXML
    private JFXComboBox<String> trie;
    @FXML
    private TableColumn<?, ?> idC;

    @FXML
    private TableColumn<?, ?> nomC;

    @FXML
    private TableColumn<?, ?> prenomC;

    @FXML
    private TableColumn<?, ?> niveauC;

    @FXML
    private TableColumn<?, ?> dateC;
      @FXML
    private ImageView imageC;
      
    @FXML
    private JFXButton maill;
          private Image image;
         EleveService ps = new EleveService();
         
         public static String EditTable = "";
     public static int E_id_selection;
    public static String E_nom_selection;
    public static String E_prenom_selection;
        public static int E_age_selection;
            public static String E_niveau_selection;
                public static String E_adresse_selection;
                    public static String E_image_selection;
       public static Stage MainStage;
    
             @FXML
    private TextField filterfield;
             private Connection cnx;
    private Statement st;
    private PreparedStatement pre;
        @FXML
    private TableColumn<?, ?> abC;
            @FXML
    private TableColumn<?, ?> adresseC;

    @FXML
    private TableColumn<?, ?> ageC;

    @FXML
    private TableColumn<?, ?> imagec1;
       static public eleve missionsel;
            @FXML
    private AnchorPane rootpane;
    /**
     * Initializes the controller class.
     */
         
       
        @FXML
            
    void absence(ActionEvent e) throws IOException {
        
 Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
            MainStage = stage1;
      
                  E_id_selection = tableE.getSelectionModel().getSelectedItem().getId();
    
         

        
        Parent root = FXMLLoader.load(getClass().getResource("ajouabsence.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("absence");
       stage.show();
         
         
        
    }
    
    
@FXML  
    void edit(ActionEvent e) throws IOException {
        
 Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
 

        MainStage = stage1;
        EditTable = ((Button) e.getSource()).getText();

           
            
            E_id_selection = tableE.getSelectionModel().getSelectedItem().getId();
            E_nom_selection = tableE.getSelectionModel().getSelectedItem().getNom();
            E_prenom_selection = tableE.getSelectionModel().getSelectedItem().getPrenom();
            E_age_selection = tableE.getSelectionModel().getSelectedItem().getAge();
                E_niveau_selection = tableE.getSelectionModel().getSelectedItem().getNiveau();
            E_adresse_selection = tableE.getSelectionModel().getSelectedItem().getAdresse();
            E_image_selection = tableE.getSelectionModel().getSelectedItem().getNom_image();
       
            
         

         
        Parent root = FXMLLoader.load(getClass().getResource("editeleve.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Edit");
        stage.show();
        
   
        
 
     
      
    }
      @FXML
            
    void classe(ActionEvent e) throws IOException {
        
 Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
            MainStage = stage1;
      
                  E_id_selection = tableE.getSelectionModel().getSelectedItem().getId();
    
         

        
        Parent root = FXMLLoader.load(getClass().getResource("affecterclasse.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("classe");
       stage.show();
         
         
        
    }
       @FXML
    private void trie_eleve(ActionEvent event) throws IOException, SQLException, ParseException {
 
 if(trie.getValue()=="Krech"||trie.getValue()=="Garderie"||trie.getValue()=="Pretaratoire"){
              try {
            listEl = ps.getEleve_niveau(trie.getSelectionModel().getSelectedItem().toString());
            System.out.println(listEl);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableE.setItems(listEl);}
 else{
         try {
            listE = ps.getEleve();
          
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableE.setItems(listE);}
 }
    
                 @FXML
    private void show_details_Personne(ActionEvent event) throws IOException {

        missionsel = tableE.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(""));
         Parent root = FXMLLoader.load(getClass().getResource("showdetailsEleve.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("details");
       stage.show();
     

       
       
    }
    

    
     private void showProductImage(String nomm) throws SQLException{
        cnx = MyConnection.getInstance().getCnx();
        st=cnx.createStatement();
        try {
           String req="Select * from eleve";
            
            
       ResultSet     rs ;
       rs=st.executeQuery(req);
     
    
            while(rs.next()) {
                
                if (rs.getString("nom").equals(nomm))
                {                 
                
                
                String a=rs.getString("nom_image");
                
           
                image = new Image("file:"+a+"", imageC.getFitWidth(), imageC.getFitHeight(), true, true);
                imageC.setImage(image);
                imageC.setPreserveRatio(true);
            
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEleveController.class.getName()).log(Level.SEVERE, null, ex);
        
        
    }
        }
     
        
            private void setCellValueFromTableToTextField(){
        tableE.setOnMouseClicked(e -> {
            eleve pl = tableE.getItems().get(tableE.getSelectionModel().getSelectedIndex());
      
    
   
      
            try {
                
                showProductImage(pl.getNom());
            } catch (SQLException ex) {
                Logger.getLogger(AfficherEleveController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        });
        
        
    }
            
 @FXML
    void delete(ActionEvent event) throws IOException, SQLException {
     if (!tableE.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Student ");
            alert.setHeaderText("Are you sure you want to delete this student"
                    + tableE.getSelectionModel().getSelectedItem().getId() + "?");
            Optional<ButtonType> result = alert.showAndWait();
        
        
          if (result.get() == ButtonType.OK) {
        
       int id =tableE.getSelectionModel().getSelectedItem().getId();
       int idclasse =ps.findidclasse(id);
       classe c =new classe();
       c =ps.findnbreE(idclasse);
       System.out.println(c);
    int nb=   c.getNbre_eleve();
    System.out.println(nb);
    c.setId(idclasse);
    c.setNbre_eleve(nb-1);
    ps.updateC(c);
    
        ObservableList<eleve> ll, ttmission;
        ttmission = tableE.getItems();
        // ta3tina les lignes selectionnés 
        ll = tableE.getSelectionModel().getSelectedItems();

        for (eleve m : ll) {
           
            ps.DeleteProduit(m.getId());
        }
        JOptionPane.showMessageDialog(null, "supprimer");

    }
          }
          else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error of selection");
            alert.setHeaderText("you need to select a student  ");

            Optional<ButtonType> result = alert.showAndWait();
        }
             try {
            listE = ps.getEleve();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableE.setItems(listE);

    }
         
               public static void close() {
        MainStage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            trie.setItems(et);
           setCellValueFromTableToTextField();
           
            idC.setCellValueFactory(new PropertyValueFactory<>("id"));
       nomC.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomC.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         niveauC.setCellValueFactory(new PropertyValueFactory<>("niveau")); 
            abC.setCellValueFactory(new PropertyValueFactory<>("nbre_absence"));
            dateC.setCellValueFactory(new PropertyValueFactory<>("date_naissance"));
               adresseC.setCellValueFactory(new PropertyValueFactory<>("adresse"));
               
     ageC.setCellValueFactory(new PropertyValueFactory<>("age"));
      imagec1.setCellValueFactory(new PropertyValueFactory<>("nom_image"));
            
         
      
          
              try {
            listE = ps.getEleve();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableE.setItems(listE);
        // TODO
        
          FilteredList<eleve> filteredData = new FilteredList<>(listE, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		filterfield.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(eleve -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (eleve.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (eleve.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<eleve> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableE.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableE.setItems(sortedData);
    }    
  /***redirection to absence */  
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
    /*********************************/
    
       @FXML
    void toClasse(ActionEvent event) throws IOException {
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
        secondView = FXMLLoader.load(getClass().getResource("afficherClasse.fxml"));
        Scene newScene=new Scene(secondView);
        Stage curStage =(Stage) rootpane.getScene().getWindow();
        curStage.setScene(newScene);}
      catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    /*************************************/
    
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
    /**********************************/
    
        @FXML
    private void envoyer(ActionEvent event) throws IOException, Exception {
       
    maill.setOnMouseClicked(e -> {
             eleve p =tableE.getItems().get(tableE.getSelectionModel().getSelectedIndex());
             //y récuperi l produit
          int idd=p.getId();
          
          eleve el= new eleve();
        try {
            el=ps.findeleve(idd);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
   int iduser=     el.getUser_id();
   String nom=el.getNom();
      String prenom=el.getPrenom();
  
        try {
            String mail=ps.getemail(iduser);
         
               MailSend m = new MailSend();
                String subject = "Mail de confirmation Kido";
          
                
                  String message = "********l'inscription de Vote Enfant "+nom+" a été Confirmé******* \n "
                            + " \n"
                            + "     Vous-Trouvourez ci Jointe la Facture a Payer"
                            + " \n"
                          + "                     Année 2020-2021"
                          + " \n"
                          + "\n Activité        |     Cotisation     |   inscrit      | Prix    |      Totale"
                          + "\n photo                    10DT            Oui             10Dt"
                          + "\n Cantine                  100DT          Oui             100Dt"
                          + "\n Club                       50DT            Oui             50Dt"
                          + "\n Bibliothéque           80DT            Oui             80Dt"
                          + "\n Féte de l'Année       40DT            Oui             40Dt"
                          + "\n Frais D'adhesions                                            35Dt"
                          + "\n                                                                                         315DT ";
                 
                m.sendMail("wejdene.benjeddou@esprit.tn",mail, subject, message);
                TextInputDialog dialog = new TextInputDialog();
                    
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);


   alert.setHeaderText(null);
         alert.setContentText("Votre Mail a été Envoyeé avec succée a " +mail);
         alert.showAndWait();
         DialogPane dialogPane = alert.getDialogPane();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
 
                });

            

        

            }
       
}
