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
        setSize(new Dimension(465,365));
        setLocationRelativeTo(null);
        setVisible(true);	                             // Affiche la fenetre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Ferme avec la croix
        setLocationRelativeTo(null);                     // Affiche au milieu de l'écran
    }

    public void initAttribut(){

        /* JPanel */

        global =  new JPanel(new BorderLayout());
        general = new JPanel();
        haut = new JPanel();
        millieu =  new JPanel();
        bas =  new JPanel();

        /* Grid */

        grille = new JPanel(new GridLayout(3,1));

        /* JButton */

        newGame = new JButton("Nouvelle partie");
        newGame.setPreferredSize(new Dimension(150, 30));
        loadGame = new JButton("Charger");
        loadGame.setPreferredSize(new Dimension(150, 30));
        exit = new JButton("Quitter");
        exit.setPreferredSize(new Dimension(150, 30));

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

        global.add(general,BorderLayout.CENTER);


        setContentPane(global);
    }

    public ModelHero charger(String fileName) throws IOException {
        String line;
        ModelHero h = null;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while ((line = br.readLine()) != null) {
            String tabs[] = line.split(",");
            if(tabs[3].equals("1")) {
                h = new ModelHero(Double.parseDouble(tabs[0]),Integer.parseInt(tabs[1]),tabs[2],ModelEntite.Genre.FEMMME,Integer.parseInt(tabs[4]));
            } else if(tabs[3].equals("2")){
                h = new ModelHero(Double.parseDouble(tabs[0]),Integer.parseInt(tabs[1]),tabs[2],ModelEntite.Genre.HOMME,Integer.parseInt(tabs[4]));
            }
            br.close();
            return h;
        }
        br.close();
        JOptionPane d = new JOptionPane();
        String options[]={ " Ok "};
        String message = "Vous n'avez pas de sauvegarde";
        d.showOptionDialog(null,message,"Chargement sauvegarde",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE,null,options,options[0]);
        return h;
    }
}
