package gui;

import javax.swing.text.View;

import model.OnOffModel;
import model.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class Presenter implements Observer {

    private OnOffModel model; //muss vom Typ "OnOffModel sein, da sonst Methoden von Observer nicht verfügbar wären
    private view view; // Interface kann als Datentyp verwendet werden

    public Presenter() {
        this.model = new OnOffModel();
        model.addObserver(this);

        this.view = new OnOffView();
        view.setButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            model.toogle(); //Alternativ abfrage Zustand und entsprechend setAn oder SetAus aufrufen!

            }
        });

    }


    @Override
    public void update(Observable o, Object arg) {
        //Daten vom Model holen
        boolean an = model.isAn();

        //View aktualisieren
        if (an) {
            view.setAusgabeText("An");
            view.setButtonText("Aus");
        } else {
            view.setAusgabeText("Aus");
            view.setButtonText("An");
        }

    }


}
