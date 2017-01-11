package model;

/**
 * Created by raphael on 13/12/16.
 */
public class ModelQuete {

    private String intituleQuete;
    private String contenueQuete;
    ModelObjectif objectif;
    private boolean success;

    public ModelQuete(String intituleQuete, String contenueQuete){
        this.intituleQuete = intituleQuete;
        this.contenueQuete = contenueQuete;
        objectif = null;
        success = false;
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

    void print(){
        System.out.println("La quête que j'ai à vous proposez se nomme : "+intituleQuete+"." +
                           "\n" +
                           "\n"+contenueQuete+
                           "\n"+objectif.toString());
    }
}
