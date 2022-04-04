package it.polito.tdp.LibrettoVotiFinale;

import javafx.application.Application;
import static javafx.application.Application.launch;

import it.polito.tdp.librettovoti.mio.Libretto;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
    	
    	//HO CREATO UN NUOVO OGGETTO FXMLLoader E NEL COSTRUTTORE GLI DICO QUALE SCENA DEVE CREARE 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml/"));
        //CHIAMO IL METODO LOAD CHE ATTIVA IL CARICAMENTO 
        Parent root = loader.load();
        //MI SALO IN UNA VARIABILE IL CONTROLLER CREATO
        FXMLController controller = loader.getController();
        
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        scene.getRoot().setStyle("-fx-font-family: 'serif'");

        
        //CREO LA CLASSE MODEL
        Libretto model = new Libretto();
        //CHIAMIAMO IL METODO SETMODEL
        controller.setModel(model);
        
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
