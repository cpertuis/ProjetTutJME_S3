package controller;

import model.ModelHero;
import view.Accueil2;
import view.CreationPersonnage;
import view.FenetreJeu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
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
                if(verifSauvegadeExistante("src/save.txt")){
                    ModelHero hero = accueil.charger("src/save.txt");
                    FenetreJeu fenetreJeu = new FenetreJeu(hero);
                    accueil.dispose();
                }
            } catch (IOException e){
                e.getMessage();
            }
        }
        if(event.getSource() == accueil.exit){
            System.exit(0);
        }
    }

    public boolean verifSauvegadeExistante(String fileName) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        if(br.readLine() == null){
            JOptionPane d = new JOptionPane();
            String options[]={ " Ok "};
            String message = "Vous n'avez pas de sauvegarde";
            d.showOptionDialog(null,message,"Chargement sauvegarde",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE,null,options,options[0]);
            return false;
        }
        return true;
    }
}
