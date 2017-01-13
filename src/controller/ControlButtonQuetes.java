package controller;

import view.Quetes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlButtonQuetes implements ActionListener {

    Quetes quetes;

    public ControlButtonQuetes(Quetes quetes){
        this.quetes= quetes;
        quetes.setFermeQuetes(this);
    }
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() ==  quetes.buttonExit){
            quetes.dispose();
        }
        if (actionEvent.getSource() == quetes.abandon){
            /*
            if (quetes.modelHero.queteCourante.getNumeroPNJ()==1){
                quetes.fenetreJeu.pnj1.setQueteDonnee(false);}
            if (quetes.modelHero.queteCourante.getNumeroPNJ()==2){
                quetes.fenetreJeu.pnj2.setQueteDonnee(false);}
            if (quetes.modelHero.queteCourante.getNumeroPNJ()==3){
                quetes.fenetreJeu.pnj3.setQueteDonnee(false);}
             */
            quetes.modelHero.setQueteEnCours(false);
            quetes.repaint();
        }
    }
}
