package controller;

import model.ModelEntite;
import model.ModelHero;
import model.ModelMob;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlButtonFenetre implements ActionListener {
    public ModelHero mHero;
    public FenetreJeu fenetreJeu;

    public ControlButtonFenetre(ModelHero mHero,FenetreJeu fenetreJeu){
        this.fenetreJeu = fenetreJeu;
        this.mHero = mHero;
        this.fenetreJeu.setInteraction(this);
    }
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getActionCommand().equals("Caracteristique")){
            afficherCaracteristique();
        }

        if (actionEvent.getActionCommand().equals("Quetes")){
            afficherQuetes();
        }

        if (actionEvent.getActionCommand().equals("Soin")){
            mHero.setVie(mHero.getVieMax());
            JOptionPane jOptionPane = new JOptionPane();
            String options[]={ " Ok "};
            String message = "Vous avez regagné votre vie";
            jOptionPane.showOptionDialog(null,message,"Attention",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
        }
        if(actionEvent.getSource() == fenetreJeu.bInteractionTaverne1){
            if(actionEvent.getActionCommand().equals("Tavernier")){
                new FenetrePNJ(mHero,fenetreJeu.pnj1);
            }
        }

        if(actionEvent.getSource() == fenetreJeu.bInteractionTaverne2){
            if(actionEvent.getActionCommand().equals("Aventurier")){
                new FenetrePNJ(mHero,fenetreJeu.pnj2);
            }
        }

        if(actionEvent.getSource() == fenetreJeu.bInteractionChateau){
            if(actionEvent.getActionCommand().equals("Jarl")){
                new FenetrePNJ(mHero,fenetreJeu.pnj3);
            }
        }

        if (actionEvent.getActionCommand().equals("Combattre")){
        	if(actionEvent.getSource()== fenetreJeu.bInteractionCampement){
        		ModelMob mob = new ModelMob("Goblin",5, ModelEntite.Genre.HOMME);
            	new Fenetre(mob,mHero,1);
        	}
        	if(actionEvent.getSource()== fenetreJeu.bInteractionCaverne){
        		ModelMob mob = new ModelMob("Dragon",4, ModelEntite.Genre.HOMME);
            	new Fenetre(mob,mHero,1);
        	}
        	if(actionEvent.getSource()== fenetreJeu.bInteractionForet){
        		ModelMob mob = new ModelMob("Treant",3, ModelEntite.Genre.NONDEF);
            	new Fenetre(mob,mHero,1);
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
        Quetes quetes = new Quetes(this.mHero,fenetreJeu.pnj1,fenetreJeu.pnj2,fenetreJeu.pnj3);
        quetes.display();
    }

    public void afficherCaracteristique(){
        Caracteristique caracteristique = new Caracteristique(mHero);
        caracteristique.display();
    }
}
