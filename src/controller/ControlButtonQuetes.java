package controller;

import view.Fenetre;
import view.FenetreJeu;
import view.Quetes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlButtonQuetes implements ActionListener {

    Quetes quetes;
    FenetreJeu fenetreJeu;


    public ControlButtonQuetes(Quetes quetes, FenetreJeu fenetreJeu){
        this.quetes= quetes;
        this.fenetreJeu=fenetreJeu;
        quetes.setFermeQuetes(this);
    }
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() ==  quetes.buttonExit){
            quetes.dispose();
        }
        if (actionEvent.getSource() == quetes.abandon){

            if (quetes.modelHero.queteCourante.getNumeroPNJ()==1){
                quetes.pnj1.setQueteDonnee(false);
            }
            if (quetes.modelHero.queteCourante.getNumeroPNJ()==2){
                quetes.pnj1.setQueteDonnee(false);            }
            if (quetes.modelHero.queteCourante.getNumeroPNJ()==3){
                quetes.pnj1.setQueteDonnee(false);            }

            quetes.modelHero.setQueteEnCours(false);
            quetes.repaint();
        }
    }
}
