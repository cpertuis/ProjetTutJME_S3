/*import java.util.Random;
import java.util.Scanner;

import model.ModelMob;
import model.ModelCombat;
import model.ModelEntite;

public class Combats {
	Scanner input = new Scanner(System.in);  // Reading from System.in
    Random rand = new Random();
	ModelCombat modelCombat = new ModelCombat();
    public ModelEntite Fight(ModelEntite joueur, ModelEntite monstre) {
    	double degats = 0;
    	int choixMob = 0;
    	boolean degatSta = false;
    	System.out.println("Le combats commence entre "+joueur.getNom()+" et le "+((ModelMob) monstre).getClasse()+" "+monstre.getNom());
    	System.out.println(joueur.getNom()+" commence.");
    	while(joueur.getVie() <= 0 || monstre.getVie() <= 0){
            degatSta = false;
    		while(degatSta == false){
		    	System.out.println("1. Attaque direct\n2. Attaque magique");
		    	int a = input.nextInt();
		    	if(a == 1){
		    		degats = modelCombat.attaquePhy(joueur);
		    		degats = modelCombat.defencePhy(degats, monstre);
		    		degatSta = true;
		    	}
		    	else if(a == 2){
		    		degats = modelCombat.attaqueMag(joueur);
		    		degats = modelCombat.defenceMag(degats, monstre);
		    		degatSta = true;
		    	}
		    	else{
		    		degatSta = false;
		    	}
    		}
            choixMob = rand.nextInt(2);
            if(choixMob == 1){
            	degats = modelCombat.esquive(degats);
            }
            else if(choixMob == 2){
            	degats = modelCombat.parade(degats);
            }
            monstre.perteVie(degats);
            System.out.println("Le "+((ModelMob) monstre).getClasse()+" "+monstre.getNom()+" subit "+degats+" points de degats.\nIl lui reste "+monstre.getVie()+" points de vie.");
            
            degatSta = false;
            while(degatSta == false){
		    	choixMob = rand.nextInt(2);
		    	if(choixMob == 1){
		    		degats = modelCombat.attaquePhy(monstre);
		    		degats = modelCombat.defencePhy(degats, joueur);
		    		degatSta = true;
		    	}
		    	else if(choixMob == 2){
		    		degats = modelCombat.attaqueMag(monstre);
		    		degats = modelCombat.defenceMag(degats, joueur);
		    		degatSta = true;
		    	}
		    	else{
		    		degatSta = false;
		    	}
    		}
            System.out.println("L'enemie attaque que voulez vous faire ?\n1. Esquive\n2. Parade\nAutre chiffre. Prendre l'attaque");
            int b = input.nextInt();
            if(b == 1){
            	degats = modelCombat.esquive(degats);
            }
            else if(b == 2){
            	degats = modelCombat.parade(degats);
            }
            else{
            	degats = degats-1;
            }
            joueur.perteVie(degats);
            System.out.println("Vous avez subit "+degats+" points de degats.\nIl vous reste "+joueur.getVie()+" points de vie.");
            
    	}
    	if(joueur.getVie() > 0){
	    	System.out.println("Vous avez gagn�");
	    	joueur.print();
	    	monstre.print();
	    	return joueur;
    	}else{
    		System.out.println("Vous avez perdu, "+((ModelMob) monstre).getClasse()+" "+monstre.getNom()+" a gagn�");
    		return monstre;
    	}
    }
}*/