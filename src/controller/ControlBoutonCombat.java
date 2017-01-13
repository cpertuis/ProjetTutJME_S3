package controller;
import model.ModelCombat;
import model.ModelHero;
import model.ModelMob;
import view.Fenetre;
import view.FenetreJeu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.jme3.math.FastMath.rand;

public class ControlBoutonCombat implements ActionListener{
    public ModelHero mHero;
    public ModelMob mMob;
    public double degats;
    public int choixMob;
    public boolean degatSta;
    public ModelCombat modelCombat;
    public Fenetre fenetre;
  
    public ControlBoutonCombat(ModelHero mHero, ModelMob mMob, Fenetre fenetre){
        degats = 0;
        modelCombat = new ModelCombat();
        this.mHero=mHero;
        this.mMob=mMob;
        this.fenetre = fenetre;
        this.fenetre.setInteraction(this);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == fenetre.attaquePhy || actionEvent.getSource() == fenetre.attaqueMag) {

            if (actionEvent.getSource() == fenetre.attaquePhy ) {
                degats = modelCombat.attaquePhy(mHero);
                System.out.println(degats);
                degats = modelCombat.defencePhy(degats, mMob);

            }
            if (actionEvent.getSource() == fenetre.attaqueMag) {
                degats = modelCombat.attaqueMag(mHero);
                System.out.println(degats);
                degats = modelCombat.defenceMag(degats, mMob);
            }
            choixMob = rand.nextInt(2);
            if (choixMob == 1) {
                degats = modelCombat.esquive(degats);
            } else if (choixMob == 2) {
                degats = modelCombat.parade(degats);
            }
            mMob.perteVie(degats);
            fenetre.nomLabel.setText("Le monstre perd " + degats + " points de vies.");
            if (mMob.estMort()) {
                fenetre.dispose();
                JOptionPane d = new JOptionPane();
                String options[]={ " Ok "};
                String message = "Vous avez gagné le combat !";
                d.showOptionDialog(null,message,"Victoire",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE,null,options,options[0]);
                if(mMob.getClasse() == mHero.queteCourante.getMob().getClasse()){
                    mHero.queteCourante.updateQuete();
                    System.out.println(mHero.queteCourante.getSuccess());
                }
            } else {
                fenetre.dispose();
                fenetre = new Fenetre(mMob, mHero, 2, fenetre.nomLabel);
            }
            degatSta = false;
            while (degatSta == false) {
                choixMob = rand.nextInt(2);
                if (choixMob == 1) {
                    degats = modelCombat.attaquePhy(mMob);
                    degats = modelCombat.defencePhy(degats, mHero);
                    degatSta = true;
                } else if (choixMob == 2) {
                    degats = modelCombat.attaqueMag(mMob);
                    degats = modelCombat.defenceMag(degats, mHero);
                    degatSta = true;
                } else {
                    degatSta = false;
                }
            }
            fenetre.nomLabel.setText("Le monstre vous attaque que faite vous ?");

        } else {
            if (actionEvent.getActionCommand().equals("Esquive")) {
                degats = modelCombat.esquive(degats);
            }
            if (actionEvent.getActionCommand().equals("Parade")) {
                degats = modelCombat.parade(degats);
            }
            if (actionEvent.getActionCommand().equals("Encaisser")) {
                degats = degats - 1;
            }
            mHero.perteVie(degats);
            fenetre.nomLabel.setText("Vous perdez " + degats + " depoints de vie.");
            if (mHero.estMort()) {
                fenetre.dispose();
                fenetre = new Fenetre(mMob, mHero, 4);
            } else {
                fenetre.dispose();
                fenetre = new Fenetre(mMob, mHero, 1, fenetre.nomLabel);
            }
        }
    }
}
