package controller;
import model.ModelHero;
import view.Caracteristique;
import view.FenetreJeu;
import view.Quetes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlBoutonCombat implements ActionListener{
  public ModelHero mHero;
  public ModelHero mMob;
  
  public ControlButtonFenetre(ModelHero mHero,ModelHero mMob,FenetreJeu fenetreJeu){
    this.fenetreJeu = fenetreJeu;
    this.mHero=mHero;
    this.mMob=mMob;
    this.fenetre.setInteraction(this);
  }
    public void actionPerformed(ActionEvent actionEvent) {
      if (actionEvent.getActionCommand().equals("Attaque Physique")){
      //To do
      }
      if (actionEvent.getActionCommand().equals("Attaque Magique")){
      //To do
      }
      if (actionEvent.getActionCommand().equals("Defense Physique")){
      //To do
      }
      if (actionEvent.getActionCommand().equals("Defense Magique")){
      //To do
      }
    }
}
