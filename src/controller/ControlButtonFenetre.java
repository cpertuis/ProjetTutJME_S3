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

    public ControlButtonFenetre(ModelHero mHero,FenetreJeu fenetreJeu){
        this.fenetreJeu = fenetreJeu;
        this.mHero=mHero;
        this.mHero=mMob;
        this.fenetreJeu.setInteraction(this);
    }
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getActionCommand().equals("Caracteristique")){
            afficherCaracteristique();
        }

        if (actionEvent.getActionCommand().equals("Quetes")){
            afficherQuetes();
        }
        if (actionEvent.getActionCommand().equals("Combattre")){
        	if(actionEvent.getSource()==bInteractionCampement){
        		ModelMob mob = new ModelMob(("Goblin",5, ModelEntite.Genre.HOMME));
            	new Fenetre(mob,mHero);
        	}
        	if(actionEvent.getSource()==bInteractionCaverne){
        		ModelMob mob = new ModelMob(("Dragon",4, ModelEntite.Genre.HOMME));
            	new Fenetre(mob,mHero);
        	}
        	if(actionEvent.getSource()==bInteractionForet){
        		ModelMob mob = new ModelMob(("Treant",3, ModelEntite.Genre.NONDEF));
            	new Fenetre(mob,mHero);
        	}
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
