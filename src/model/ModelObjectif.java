package model;

import java.util.HashMap;

/**
 * Created by raphael on 13/12/16.
 */
public class ModelObjectif {

    private int objectif;
    private int etatAvancementObjectif;

    public ModelObjectif(int _objectif){
        objectif = _objectif;
        etatAvancementObjectif = 0;
    }

    public int getObjectif(){
        return objectif;
    }

    public int getEtatAvancementObjectif(){
        return etatAvancementObjectif;
    }

    public void setEtatAvancementObjectif(int _avancementObjectif){
        etatAvancementObjectif = _avancementObjectif;
    }

    public boolean verifObjectifAtteint(){
        if(objectif == etatAvancementObjectif){
            return true;
        }
        return false;
    }

    public String toString(){
        return etatAvancementObjectif+"/"+objectif;
    }
}
