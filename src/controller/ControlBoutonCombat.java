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
  public double degats
  public int choixMob;
  public boolean degatSta;
  
  public ControlButtonFenetre(ModelHero mHero,ModelHero mMob,Fenetre fenetreJeu){
    this.fenetreJeu = fenetreJeu;
    this.mHero=mHero;
    this.mMob=mMob;
    this.fenetre.setInteraction(this);
  }
    public void actionPerformed(ActionEvent actionEvent) {
	  if (actionEvent.getActionCommand().equals("Attaque Physique") || actionEvent.getActionCommand().equals("Attaque Magique")){

		  if (actionEvent.getActionCommand().equals("Attaque Physique")){
			degats = modelCombat.attaquePhy(mHero);
			degats = modelCombat.defencePhy(degats, mMob);
		  }
		  if (actionEvent.getActionCommand().equals("Attaque Magique")){
			degats = modelCombat.attaqueMag(mHero);
			degats = modelCombat.defenceMag(degats, mMob);
		  }
		  choixMob = rand.nextInt(2);
          if(choixMob == 1){
          	degats = modelCombat.esquive(degats);
          }
          else if(choixMob == 2){
          	degats = modelCombat.parade(degats);
          }
          mMob.perteVie(degats);
		  nomLabel.setText(nomLabel.getText()+"\nLe monstre perd "+degats+" points de vies.");
          if(mMob.estMort()){
			fenetreJeu = new Fenetre(mMob, mHero, 3);
			break;
		  }
		  else{
			  fenetreJeu = new Fenetre(mMob,mHero,2,nomLabel);
		  }
          degatSta = false;
          while(degatSta == false){
		  	choixMob = rand.nextInt(2);
		   	if(choixMob == 1){
		   		degats = modelCombat.attaquePhy(mMob);
		   		degats = modelCombat.defencePhy(degats, mHero);
		   		degatSta = true;
		   	}
		   	else if(choixMob == 2){
		   		degats = modelCombat.attaqueMag(mMob);
		   		degats = modelCombat.defenceMag(degats, mHero);
		   		degatSta = true;
		   	}
		   	else{
		   		degatSta = false;
		   	}
		  }
		  nomLabel.setText(nomLabel.getText()+"\nLe monstre vous attaque que faite vous ?");
		  
	  }
	  else{
		  if (actionEvent.getActionCommand().equals("Esquive")){
			degats = modelCombat.esquive(degats);
		  }
		  if (actionEvent.getActionCommand().equals("Parade")){
			degats = modelCombat.parade(degats);
		}
	  }  
    }
}
