package model;

import java.io.PrintStream;

/**
 * Created by raphael on 11/11/16.
 */

public class ModelHero extends ModelEntite {

    public enum Classe{
        MAGE("Mage"),
        GUERRIER("Guerrier"),
        ASSASSIN("Assassin"),
        TRAVELERS("Traveler"),
        BASECLASSE("Aventurier");

        private String intitule = "";

        Classe(String intitule) {
            this.intitule = intitule;
        }

        public String toString(){
            return intitule;
        }

    }
    private Classe baseIntitule = Classe.BASECLASSE;
    private Classe classe;

    private boolean queteEnCours;

    public ModelQuete queteCourante;

    public ModelHero(String nom, Genre _genre, int _classe){
        super(nom,_genre);
        classe = null;
        setClasseNouveauPerso(_classe);
        queteEnCours = false;
        queteCourante = null;
    }

    public ModelHero(double vie, int niveau, String nom, Genre _genre, int _classe){
        super(vie,niveau,nom,_genre);
        classe = null;
        setClasseChargementPerso(_classe);
        queteEnCours = false;
        queteCourante = null;
    }

    public void setClasseNouveauPerso(int i){
        if(i <= 5 && i > 0){
            switch (i){
                case 1 :
                    classe = Classe.ASSASSIN;
                    image = "img/assassin.png";
                    vieMax = 300;
                    vie = vieMax;
                    setDefenceMag(10);
                    setDefencePhy(6);
                    setForce(20);
                    setMagie(8);
                    break;
                case 2 :
                    classe = Classe.GUERRIER;
                    image = "img/guerrier.png";
                    vieMax = 500;
                    vie = vieMax;
                    setDefenceMag(15);
                    setDefencePhy(20);
                    setForce(8);
                    setMagie(4);
                    break;
                case 3 :
                    classe = Classe.MAGE;
                    image = "img/mage.png";
                    vieMax = 250;
                    vie = vieMax;
                    setDefenceMag(15);
                    setDefencePhy(8);
                    setForce(6);
                    setMagie(25);
                    break;
                case 4 :
                    classe = Classe.TRAVELERS;
                    image = "img/traveler.png";
                    vieMax = 350;
                    vie = vieMax;
                    setDefenceMag(10);
                    setDefencePhy(8);
                    setForce(14);
                    setMagie(10);
                    break;
                case 5 :
                    classe = Classe.BASECLASSE;
                    setDefenceMag(10);
                    setDefencePhy(10);
                    setForce(8);
                    setMagie(8);
                    break;
            }
        }
    }

    public void setClasseChargementPerso(int i){
        if(i <= 5 && i > 0){
            switch (i){
                case 1 :
                    classe = Classe.ASSASSIN;
                    vieMax = 300;
                    setDefenceMag(10);
                    setDefencePhy(6);
                    setForce(20);
                    setMagie(8);
                    break;
                case 2 :
                    classe = Classe.GUERRIER;
                    vieMax = 500;
                    setDefenceMag(15);
                    setDefencePhy(20);
                    setForce(8);
                    setMagie(4);
                    break;
                case 3 :
                    classe = Classe.MAGE;
                    vieMax = 250;
                    setDefenceMag(15);
                    setDefencePhy(8);
                    setForce(6);
                    setMagie(25);
                    break;
                case 4 :
                    classe = Classe.TRAVELERS;
                    vieMax = 350;
                    setDefenceMag(10);
                    setDefencePhy(8);
                    setForce(14);
                    setMagie(10);
                    break;
                case 5 :
                    classe = Classe.BASECLASSE;
					vieMax = vie;
                    setDefenceMag(10);
                    setDefencePhy(10);
                    setForce(8);
                    setMagie(8);
                    break;
            }
        }
    }

    public void print() {
        if(vie <= 0){
            System.out.println("Le personnage "+nom+" est actuellement mort.");
        }
        else{
            System.out.println("Ce personnage s'apelle "+nom+", c'est "+genre+" "+classe+" de niveau "+niveau+" et possede "+vie+" points de vie.");
        }
    }

    public Classe getClasse() {
        return classe;
    }

    public String getClasseString(){
        if(getClasse().equals(Classe.ASSASSIN)){
            return ",1";
        } else if(getClasse().equals(Classe.GUERRIER)){
            return ",2";
        } else if(getClasse().equals(Classe.MAGE)){
            return ",3";
        } else if(getClasse().equals(Classe.TRAVELERS)){
            return ",4";
        } else {
            return ",5";
        }
    }

    public boolean getQueteEnCours(){
        return queteEnCours;
    }

    public void setQueteEnCours(boolean b){
        queteEnCours = b;
    }

    public void sauvegarder(PrintStream ps){
        super.sauvegarder(ps);
        String toWrite;
        toWrite = getClasseString();
        ps.print(toWrite);
        ps.println();
    }
}