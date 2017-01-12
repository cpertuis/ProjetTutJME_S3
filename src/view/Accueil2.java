package view;

import controller.ControlBoutonAcceuil;
import model.ModelEntite;
import model.ModelHero;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by charly on 08/01/17.
 */
public class Accueil2 extends JFrame{



    /* Control Accueil */

    protected ControlBoutonAcceuil controlBoutonAcceuil;

        /* JPanel */

    protected JPanel global;
    protected JPanel general;
    protected JPanel haut;
    protected JPanel millieu;
    protected JPanel bas;

        /* Grid */

    protected JPanel grille;

        /* JButton */

    public JButton newGame;
    public JButton loadGame;
    public JButton exit;

    public Accueil2(){
        controlBoutonAcceuil = new ControlBoutonAcceuil(this);
        initAttribut();
        creerWidget();
        pack();
        setVisible(true);	                             // Affiche la fenetre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Ferme avec la croix
        setLocationRelativeTo(null);                     // Affiche au milieu de l'écran
    }

    public void initAttribut(){

        /* JPanel */

        global =  new JPanel();
        general = new JPanel();
        haut = new JPanel();
        millieu =  new JPanel();
        bas =  new JPanel();

        /* Grid */

        grille = new JPanel(new GridLayout(3,1));

        /* JButton */

        newGame = new JButton("Nouvelle partie");
        loadGame = new JButton("Charger une partie");
        exit = new JButton("Quitter");

        /* ActionListener */

        newGame.addActionListener(controlBoutonAcceuil);
        loadGame.addActionListener(controlBoutonAcceuil);
        exit.addActionListener(controlBoutonAcceuil);
    }

    public void creerWidget(){

        haut.add(newGame);
        millieu.add(loadGame);
        bas.add(exit);

        grille.add(haut);
        grille.add(millieu);
        grille.add(bas);

        general.add(grille);
        general.setLayout(new BoxLayout(general, BoxLayout.Y_AXIS));

        global.add(general);

        setContentPane(global);
    }

    public ModelHero charger(String fileName) throws IOException {
        String line;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while ((line = br.readLine()) != null) {
            String tabs[] = line.split(",");
            if(tabs[1].equals("1")) {
                br.close();
                return new ModelHero(tabs[0],Integer.parseInt(tabs[2]), ModelEntite.Genre.FEMMME);
            } else if(tabs[1].equals("2")){
                br.close();
                return new ModelHero(tabs[0],Integer.parseInt(tabs[2]), ModelEntite.Genre.HOMME);
            }
        }
        return new ModelHero("Pas de nom",5,ModelEntite.Genre.NONDEF);
    }
}
