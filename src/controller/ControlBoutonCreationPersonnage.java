package controller;

import model.ModelEntite;
import model.ModelHero;
import model.ModelMob;
import model.ModelPnj;
import view.CreationPersonnage;
import view.FenetreJeu;

import java.awt.event.ActionEvent;
import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by charly on 11/01/17.
 */
public class ControlBoutonCreationPersonnage implements java.awt.event.ActionListener{

    /* Création personnage */

    private CreationPersonnage perso;

    public ControlBoutonCreationPersonnage(CreationPersonnage _perso){
        perso = _perso;
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == perso.valider){
            perso.dispose();
            ModelHero hero = new ModelHero(perso.entrerNom.getText(),choixClasse(),choixGenre());
            FenetreJeu fenetreJeu = new FenetreJeu(hero);
            List<ModelPnj> pnj = new ArrayList<ModelPnj>();
            //List<ModelMob> mob = new ArrayList<ModelMob>();
            hero.print();
        }
    }

    public ModelEntite.Genre choixGenre(){
        if(perso.buttonSexeF.isSelected()){
            return ModelEntite.Genre.FEMMME;
        }
        if(perso.buttonSexeH.isSelected()){
            return ModelEntite.Genre.HOMME;
        }
        else return ModelEntite.Genre.NONDEF;
    }

    public int choixClasse(){
        if(perso.listClasse.getSelectedItem().equals("Assassin")) {
            return 1;
        } else if (perso.listClasse.getSelectedItem().equals("Guerrier")) {
            return 2;
        } else if (perso.listClasse.getSelectedItem().equals("Mage")) {
            return 3;
        }  else if (perso.listClasse.getSelectedItem().equals("Traveler")) {
            return 4;
        } else {
            return 5;
        }
    }
}
