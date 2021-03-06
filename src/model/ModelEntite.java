package model;

import java.io.PrintStream;

/**
 * Created by raphael on 11/11/16.
 */
public class ModelEntite {

    protected double vie;
    protected double vieMax;
    protected int niveau;
    protected int force;
    protected int magie;
    protected int attaquePhy;
    protected int attaqueMag;
    protected int defencePhy;
    protected int defenceMag;
    public String image;
    public enum Genre {
        HOMME("Homme"),
        FEMMME("Femme"),
        NONDEF("Indefinie");

        private String genre = "";

        Genre(String genre) {
            this.genre = genre;
        }

        public String toString(){
            return genre;
        }
    }
    protected String nom;
    Genre baseGenre = Genre.NONDEF;
    Genre genre;

    ModelEntite(String _nom,Genre _genre){
        vie = 150;
        niveau = 1;
        nom = _nom;
        genre = _genre;
    }

    ModelEntite(double _vie, int _niveau,String _nom, Genre _genre){
        vie = _vie;
        niveau = _niveau;
        nom = _nom;
        genre = _genre;
        force+= 3;
        magie+= 2;
        defenceMag+= 1;
        defencePhy+= 2;

        if(niveau > 1){
            for(int i = 1; i < niveau; i++){
                if((vie / 2) % 2 != 0){
                    vie = vie + vie/2 + 1;
                }
                else{
                    vie = vie + vie/2;
                }
            }
        }
    }

    public void setVie(double vie){
        this.vie = vie;
    }

    public void setVieMax(double vieMax){
        this.vieMax = vieMax;
    }

    public void setForce(int force){
        this.force = force;
    }
    public void setAttaquePhy(int attaquePhy){
        this.attaquePhy = attaquePhy;
    }

    public void setAttaqueMag(int attaqueMag){
        this.attaqueMag = attaqueMag;
    }
    public void setDefencePhy(int defencePhy){
        this.defencePhy = defencePhy;
    }

    public void setDefenceMag(int defenceMag){
        this.defenceMag = defenceMag;
    }

    public void setMagie(int magie){
        this.magie = magie;
    }

    public void setNiveau(int niveau){
        this.niveau = niveau;
    }

    public void setGenre(int i){
        if(i <= 3 && i > 0){
            switch (i){
                case 1 :
                    genre = Genre.FEMMME;
                    break;
                case 2 :
                    genre = Genre.HOMME;
                    break;
                case 3 :
                    genre = Genre.NONDEF;
                    break;
            }
        }
        else{
            System.out.println("Vous ne pouvez pas mettre un nombre superieur à 3 ou inferieur à 0");
        }
    }

    void setNom(String nom){
        this.nom = nom;
    }

    public double getVie(){
        return vie;
    }

    public double getVieMax() {
        return vieMax;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getNiveau(){
        return niveau;
    }

    public String getNom(){
        return nom;
    }

    public  int getDefPhy(){
        return defencePhy;
    }

    public int getDefMag(){
        return defenceMag;
    }
    
    public  int getAttPhy(){
        return attaquePhy;
    }

    public int getAttMag(){
        return attaqueMag;
    }
    
    public int getForce(){
        return force;
    }

    public int getMagie(){
        return magie;
    }

    public void gainNiveau(){
        niveau++;

        if((vieMax / 2) % 2 != 0){
            setVieMax(vieMax + (vieMax + 1)/2);
        }
        else{
            setVieMax(vieMax + vieMax/2);
        }

        vie = vieMax;
    }

    public boolean estMort(){
        if(vie <= 0){
            return true;
        }
        return false;
    }

    public void perteVie(double degats){
        setVie(vie-degats);
    }

    public void regenVie(){
        while(vie < vieMax){
            //incrémenter de 1 la vie tout les x secondes
        }
    }

    public void print() {
        if(estMort()){
            System.out.println("Le personnage "+nom+" est actuellement mort.");
        }
        else{
            System.out.println("Ce personnage s'apelle "+nom+",c'est "+genre+" de niveau "+niveau+" et possede "+vie+" points de vie.");
        }
    }

    public void sauvegarder(PrintStream ps) {
        String toWrite;
        toWrite = vie+","+niveau+","+nom+",";
        if(genre == Genre.FEMMME){
            toWrite += "1";
        } else if(genre == Genre.HOMME){
            toWrite += "2";
        } else {
            toWrite +="0";
        }
        ps.print(toWrite);
    }
}
