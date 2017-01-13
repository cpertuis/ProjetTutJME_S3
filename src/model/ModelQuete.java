package model;

import jogamp.opengl.macosx.cgl.awt.MacOSXAWTCGLGraphicsConfigurationFactory;

/**
 * Created by raphael on 13/12/16.
 */
public class ModelQuete {

    private String intituleQuete;
    private String contenueQuete;
    private ModelObjectif objectif;
    private ModelMob mob;
    private boolean success;
    private int numeroPNJ;

    public ModelQuete(String _intituleQuete, String _contenueQuete, ModelMob _mob, ModelObjectif _objectif,int _numeroPNJ){
        intituleQuete = _intituleQuete;
        contenueQuete = _contenueQuete;
        objectif = _objectif;
        mob = _mob;
        success = false;
        numeroPNJ=_numeroPNJ;
    }

    public boolean getSuccess(){
        return success;
    }

    public void setSuccess(boolean b){
        success = b;
    }

    public void ajoutObjectif(ModelObjectif objectif){
        this.objectif = objectif;
    }

    public void print(){
        System.out.println("La quête que j'ai à vous proposez se nomme : \n"+intituleQuete+"." +
                           "\n" +
                           "\n"+contenueQuete+
                           "\n"+mob.getNom()+" tués : "+objectif.toString());
    }

    public String toString(){
        return ("La quête que j'ai à vous proposez se nomme : \n"+intituleQuete+"." +
                "\n" +
                "\n"+contenueQuete+
                "\n"+mob.getNom()+" tués : "+objectif.toString());
    }

    public void verifQuete(){
        if(objectif.getEtatAvancementObjectif() == objectif.getObjectif()){
            setSuccess(true);
        }
    }

    public String getObjectif() {
        return intituleQuete+" : "+mob.getNom()+" tués : "+objectif.toString();
    }

    public void updateQuete(){

    }

    public int getNumeroPNJ() {
        return numeroPNJ;
    }
}
