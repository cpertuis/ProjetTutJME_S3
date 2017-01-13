package model;

/**
 * Created by raphael on 13/11/16.
 */
public class ModelMob extends ModelEntite{

    public enum Type{
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

    public ModelMob(int vie, int niveau, String nom){
        super(vie,niveau,nom,Genre.NONDEF);
        setTypeMob(0);
    }
    
    public ModelMob(String nom, int typeMob, Genre genre){
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
                break;
    		case 2:
    			this.classe = Type.BANDIT;
                image = "img/bandit.png";
    			vieMax = 200;
                vie = vieMax;
                setDefenceMag(2);
                setDefencePhy(4);
                setForce(15);
                setMagie(15);
                break;
    		case 3:
    			this.classe = Type.TREANT;
                image = "img/treant.png";
    			vieMax = 300;
                vie = vieMax;
                setDefenceMag(3);
                setDefencePhy(3);
                setForce(10);
                setMagie(10);
                break;
    		case 4:
    			this.classe = Type.BOSS;
                image = "img/dragon.png";
    			vieMax = 1000;
                vie = vieMax;
                setDefenceMag(10);
                setDefencePhy(10);
                setForce(30);
                setMagie(20);
                break;
            default:
    			this.classe = Type.BASEMOB;
                image = "img/goblin.png";
    			vieMax = 100;
                vie = vieMax;
                setDefenceMag(2);
                setDefencePhy(2);
                setForce(5);
                setMagie(5);
                break;
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
