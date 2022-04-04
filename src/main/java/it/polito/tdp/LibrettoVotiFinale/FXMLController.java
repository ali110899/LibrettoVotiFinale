package it.polito.tdp.LibrettoVotiFinale;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.mio.Libretto;
import it.polito.tdp.librettovoti.mio.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	//SI RICORDA QUAL'è LA CLASSE MODEL SU CUI LAVORARE
	private Libretto model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> cmbPunti;  //non ci metto l'oggetto Voto poichè fa riferimento a qualcosa di già creato

    @FXML
    private TextField txtNome;
    
    @FXML
    private Label txtStatus;

    @FXML
    private TextArea txtVoti;

    @FXML
    void handleNuovoVoto(ActionEvent event) {

    	// FASE 1  acquisizione e controllo dati
    	String nome = txtNome.getText();
    	Integer punti = cmbPunti.getValue();  //così mi prende anche il valore null (campo vuoto)
    	
    	//Controlli di validita
    	if(nome.equals("") || punti == null) {
    		// ERRORE, non posso eseguire l'operazione
    		txtStatus.setText("ERRORE: occorre inserire nome evoto");
    		return;  //così non faccio più le operazioni inutili che vengono dopo
    	}
    	
    	//FASE 2 esecuzione dell'operazione
    	boolean ok = model.add(new Voto(nome, punti)); //capisco se l'aggiunta nel Libretto dell'esame è andata a buon fine
    	
    	//FASE 3 visualizzazione/aggiornamento del risultato
    	if (ok) {
    		List<Voto> voti = model.getVoti();
    		txtVoti.clear();
    		txtVoti.appendText("Hai superato " +voti.size()+" esame/i\n");
    	
    		for(Voto v: voti) {
    			txtVoti.appendText(v.toString()+ "\n");
    		}
    	
    		txtNome.clear();
    		cmbPunti.setValue(null);
    		txtStatus.setText("");
    	} else {
    		txtStatus.setText("ERRORE: esame già esistente");
    	}
    }

    //ATTRAVERSO IL SETMODEL SO QUAL'è IL MODEL
    public void setModel(Libretto model) {
    	this.model = model;
    }
    
    @FXML
    void initialize() {
        assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoti != null : "fx:id=\"txtVoti\" was not injected: check your FXML file 'Scene.fxml'.";

        // MI CREO LA MIA TENDINA
        cmbPunti.getItems().clear();
        for(int p=1; p<=30; p++ ) {
        	cmbPunti.getItems().add(p);  //popolo la mia combo-box con numeri da 1 a 30
        }
        
    }

}
