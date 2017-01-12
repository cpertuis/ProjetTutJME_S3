package controller;

import model.ModelHero;
import view.Caracteristique;
import view.FenetreJeu;
import view.Quetes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlButtonFenetre implements ActionListener {
    public ModelHero mHero;
    public FenetreJeu fenetreJeu;

    public ControlButtonFenetre(ModelHero mHero, FenetreJeu fenetreJeu){
        this.fenetreJeu = fenetreJeu;
        this.mHero=mHero;
        this.fenetreJeu.setInteraction(this);
    }
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getActionCommand().equals("Caracteristique")){
            afficherCaracteristique();
        }

        if (actionEvent.getActionCommand().equals("Quetes")){
            afficherQuetes();
        }

        if(actionEvent.getActionCommand().equals("Sauver")){
            try {
                sauvgarder();
            } catch (IOException e){
                e.getMessage();
            }
        }
    }

    public void sauvgarder() throws IOException{
        fenetreJeu.sauvegarder();
    }

    public void afficherQuetes(){
        new Quetes().display();
    }

    public void afficherCaracteristique(){
        new Caracteristique(mHero).display();
    }
}
