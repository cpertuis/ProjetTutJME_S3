package controller;

import model.ModelHero;
import view.Caracteristique;
import view.FenetreJeu;
import view.Quetes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlButtonFenetre implements ActionListener {
    public ModelHero mHero;
    public FenetreJeu fenetreJeu;

    public ControlButtonFenetre(ModelHero mHero, FenetreJeu fenetreJeu){
        this.fenetreJeu = fenetreJeu;
        this.mHero=mHero;
        fenetreJeu.setInteraction(this);
    }
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() ==  fenetreJeu.buttonCaractéristique){
            new Caracteristique(mHero).display();
        }

        if (actionEvent.getSource()== fenetreJeu.buttonQuete){
            new Quetes().display();
        }
    }
}
