package controller;

import model.ModelHero;
import model.ModelPnj;
import view.CreationPersonnage;
import view.FenetreJeu;
import view.FenetrePNJ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Tanguy on 13/01/2017.
 */
public class ControlBoutonPNJ implements ActionListener{
    protected FenetrePNJ fenetrePNJ;
    protected ModelHero modelHero;
    protected ModelPnj modelPnj;

    public ControlBoutonPNJ(FenetrePNJ fenetrePNJ, ModelHero modelHero, ModelPnj modelPnj){
        this.fenetrePNJ=fenetrePNJ;
        this.modelHero=modelHero;
        this.modelPnj=modelPnj;
        this.fenetrePNJ.setInteraction(this);
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == fenetrePNJ.accepter){
            fenetrePNJ.dispose();
            fenetrePNJ.queteAcceptee(modelPnj.getQuete());
            modelPnj.setQueteDonnee(true);
        }

        if(event.getSource() == fenetrePNJ.refuser){
            fenetrePNJ.dispose();
        }
    }
}
