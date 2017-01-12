package controller;

import model.ModelEntite;
import model.ModelHero;
import model.ModelMob;
import model.ModelPnj;
import view.CreationPersonnage;
import view.FenetreJeu;

import javax.swing.*;
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
            ModelHero hero = creerHero();
            if(hero != null) {
                List<ModelPnj> pnj = new ArrayList<ModelPnj>();
                //List<ModelMob> mob = new ArrayList<ModelMob>();
                FenetreJeu fenetreJeu = new FenetreJeu(hero);
                perso.dispose();
            }
        }
    }

    public ModelHero creerHero(){
        boolean verif;
        verif = verifChamp();
        if(verif) {
            return new ModelHero(perso.entrerNom.getText(), choixGenre(), choixClasse());
        }
        return null;
    }

    public boolean verifChamp(){
        if (choixGenre().equals(ModelEntite.Genre.NONDEF)){
            JOptionPane d = new JOptionPane();
            String options[]={ " Ok "};
            String message = "Vous n'avez pas choisi un genre";
            d.showOptionDialog(null,message,"Création personnage",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE,null,options,options[0]);
            return false;
        } else if(perso.entrerNom.getText().equals("")){
            JOptionPane d = new JOptionPane();
            String options[]={ " Ok "};
            String message = "Vous n'avez pas saisi un nom";
            d.showOptionDialog(null,message,"Création personnage",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE,null,options,options[0]);
            return false;
        }
        return true;
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
