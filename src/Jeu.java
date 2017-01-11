import model.ModelHero;
import view.Accueil2;
import view.CreationPersonnage;
import view.FenetreJeu;

public class Jeu {


    public static void main(String[] args){

        javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {

                        Accueil2 accueil = new Accueil2();
                    }
                }
        );
    }
}
