package model;

/**
 * Created by raphael on 13/11/16.
 */
public class ModelMob extends ModelEntite{

    private enum Type{
        LOUP("Loup"),
        BANDIT("Bandit"),
        TREANT("Tréant"),
        BOSS("Dragon"),
        BASEMOB("Goblin");

        private String intitule = "";

        Type(String intitule) {
            this.intitule = intitule;
        }

        public String toString(){
            return intitule;
        }

    }
    public Type classe;

    public ModelMob(String nom){
        super(nom,Genre.NONDEF);
        setTypeMob(0);
    }

    ModelMob(int vie, int niveau, String nom){
        super(vie,niveau,nom,Genre.NONDEF);
        setTypeMob(0);
    }
    
    ModelMob(String nom, int typeMob, Genre genre){
    	super(nom, genre);
    	setTypeMob(typeMob);
    }

    public Type getClasse(){
        return classe;
    }
    
    public void setTypeMob(int numMob){
    	switch (numMob){
    		case 1:
    			this.classe = Type.LOUP;
    			vieMax = 300;
                vie = vieMax;
                setDefenceMag(10);
                setDefencePhy(10);
                setForce(15);
                setMagie(10);
    		case 2:
    			this.classe = Type.BANDIT;
    			vieMax = 500;
                vie = vieMax;
                setDefenceMag(20);
                setDefencePhy(20);
                setForce(15);
                setMagie(15);
    		case 3:
    			this.classe = Type.TREANT;
    			vieMax = 150;
                vie = vieMax;
                setDefenceMag(2);
                setDefencePhy(5);
                setForce(10);
                setMagie(10);
    		case 4:
    			this.classe = Type.BOSS;	
    			vieMax = 2000;
                vie = vieMax;
                setDefenceMag(20);
                setDefencePhy(20);
                setForce(30);
                setMagie(20);
    		default:
    			this.classe = Type.BASEMOB;
    			vieMax = 100;
                vie = vieMax;
                setDefenceMag(2);
                setDefencePhy(2);
                setForce(5);
                setMagie(5);
    	}
    		
    }

    public void print() {
        if(vie <= 0){
            System.out.println("Le monstre "+nom+" est mort.");
        }
        else{
            System.out.println("Ce monstre s'apelle "+nom+", c'est "+genre+" "+classe+" de niveau "+niveau+" et possede "+vie+" points de vie.");
        }
    }

}