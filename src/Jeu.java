import model.ModelHero;
import view.Accueil2;
import view.CreationPersonnage;
import view.FenetreJeu;

public class Jeu {


    public static void main(String[] args){

        javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        ModelHero m =new ModelHero(20,1,"Julius");
                        m.setClasse(3);
                        m.gainNiveau();
                        m.perteVie(5);
                        Accueil2 accueil = new Accueil2();
                    }
                }
        );
    }
}
