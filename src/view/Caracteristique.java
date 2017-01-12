package view;

import controller.ControlButtonCarac;
import model.ModelHero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Caracteristique extends JFrame {
    public ControlButtonCarac controlButtonCarac;
    public JLabel nom, genre, classe, niveau, vie, force, magie, defMagie, defPhy;
    public String snom, sgenre, sclasse, sniveau, svie, sforce, smagie, sDefMagie, sDefPhy;
    public JPanel carac;
    public ModelHero mHero;
    public JButton buttonExit;

    public Caracteristique(ModelHero mHero){

        setTitle("Caractéristiques Héro");
        this.mHero=mHero;
        initAttribut();
        createWidget();
        setResizable(false);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    private void initAttribut() {
        snom= "Nom du Héro : "+mHero.getNom();
        sgenre= "Sexe : "+mHero.getGenre();
        sclasse= "Classe : "+mHero.getClasse();
        sniveau= "Niveau : "+mHero.getNiveau();
        svie= "Vie : "+mHero.getVie()+"/"+mHero.getVieMax();
        sforce = "Force : "+mHero.getForce();
        smagie = "Magie : "+mHero.getMagie();
        sDefMagie = "Defense Magique : "+mHero.getDefMag();
        sDefPhy = "Defense Physique : "+mHero.getDefPhy();

        nom = new JLabel(snom);
        genre = new JLabel(sgenre);
        classe = new JLabel(sclasse);
        niveau  = new JLabel(sniveau);
        vie = new JLabel(svie);
        force = new JLabel(sforce);
        magie = new JLabel(smagie);
        defPhy = new JLabel(sDefPhy);
        defMagie = new JLabel(sDefMagie);
    }

    private void createWidget() {
        carac = new JPanel(new GridLayout(10,1));
        carac.setBorder(BorderFactory.createLineBorder(Color.black));
        carac.add(nom);
        carac.add(genre);
        carac.add(classe);
        carac.add(niveau);
        carac.add(vie);
        carac.add(force);
        carac.add(magie);
        carac.add(defPhy);
        carac.add(defMagie);
        buttonExit = new JButton("Fermer");
        buttonExit.setPreferredSize(new Dimension(150,30));
        carac.add(buttonExit);
        setContentPane(carac);

        controlButtonCarac = new ControlButtonCarac(mHero,this);
    }

    public void display() {
        setVisible(true);
    }

    public void setFermeCarac(ActionListener listener){
        buttonExit.addActionListener(listener);
    }
}
