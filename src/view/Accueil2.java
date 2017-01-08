package view;

import controller.ControlBouton;

import javax.swing.*;
import java.awt.*;

/**
 * Created by charly on 08/01/17.
 */
public class Accueil2 extends JFrame{

    /* Control Accueil */

    protected ControlBouton controlBouton;

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

        newGame.addActionListener(controlBouton);
        loadGame.addActionListener(controlBouton);
        exit.addActionListener(controlBouton);
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
}
