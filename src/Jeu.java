import controller.ControlGroup;
import model.ModelHero;
import view.Caracteristique;
import view.Fenetre;

public class Jeu {
    public static void main(String[] args){

        javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        ModelHero m =new ModelHero(20,1,"Julius");
                        m.setClasse(3);
                        m.gainNiveau();
                        Fenetre fenetre = new Fenetre(m);
                    }
                }
        );
    }
}
