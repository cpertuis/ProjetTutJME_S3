package controller;

import model.ModelHero;
import view.Accueil2;
import view.CreationPersonnage;
import view.FenetreJeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by charly on 08/01/17.
 */
public class ControlBoutonAcceuil implements ActionListener{

    /* Accueil */

    protected Accueil2 accueil;

    public ControlBoutonAcceuil(Accueil2 accueil){
        this.accueil = accueil;
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == accueil.newGame){
            accueil.dispose();
            CreationPersonnage creationPersonnage = new CreationPersonnage();
        }
        if(event.getSource() == accueil.loadGame){
            try {
                accueil.dispose();
                ModelHero hero = accueil.charger("src/save.txt");
                FenetreJeu fenetreJeu = new FenetreJeu(hero);
            } catch (IOException e){
                e.getMessage();
            }
        }
        if(event.getSource() == accueil.exit){
            System.exit(0);
        }
    }
}
