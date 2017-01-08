package controller;

import view.Accueil2;
import view.JME;

import java.awt.event.ActionEvent;

/**
 * Created by charly on 08/01/17.
 */
public class ControlBoutonAcceuil {

    /* Accueil */

    protected Accueil2 accueil;

    public ControlBoutonAcceuil(Accueil2 accueil){
        this.accueil = accueil;
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == accueil.newGame){

        }
        if(event.getSource() == accueil.loadGame){

        }
        if(event.getSource() == accueil.exit){
            System.exit(0);
        }
    }
}
