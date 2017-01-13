package view;

import controller.ControlButtonCarac;
import controller.ControlButtonFenetre;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class FenetreJeu extends JFrame {

    /* Hero, Quete, Objectif et mob*/

    protected ModelHero modelH;

    public ModelPnj pnj1;
    public ModelPnj pnj2;
    public ModelPnj pnj3;

    protected ModelQuete quete1;
    protected ModelQuete quete2;
    protected ModelQuete quete3;

    protected ModelObjectif objectif1;
    protected ModelObjectif objectif2;
    protected ModelObjectif objectif3;

    protected ModelMob mob1;
    protected ModelMob mob2;
    protected ModelMob mob3;
    /* Composante fenêtre */

    public ControlButtonFenetre controlButtonFenetre;
    public JPanel panoGlobalJeu;

    public JPanel pInteractionCampement;
    public JPanel pInteractionCaverne;
    public JPanel pInteractionChateau;
    public JPanel pInteractionForet;
    public JPanel pInteractionTaverne;

    public JButton buttonCaracteristiqueCampement;
    public JButton buttonCaracteristiqueCaverne;
    public JButton buttonCaracteristiqueChateau;
    public JButton buttonCaracteristiqueForet;
    public JButton buttonCaracteristiqueTaverne;

    public JButton buttonQueteCampement;
    public JButton buttonQueteCaverne;
    public JButton buttonQueteChateau;
    public JButton buttonQueteForet;
    public JButton buttonQueteTaverne;

    public JButton bInteractionCampement;
    public JButton bInteractionCaverne;
    public JButton bInteractionChateau;
    public JButton bInteractionForet;
    public JButton bInteractionTaverne1;
    public JButton bInteractionTaverne2;

    public JTabbedPane onglets;
    public JPanel vide;
    public JPanel taverne;
    public JLabel imgTaverne;
    public JPanel chateau;
    public JLabel imgChateau;
    public JPanel caverne;
    public JLabel imgCaverne;
    public JPanel campement;
    public JLabel imgCampement;
    public JPanel foret;
    public JLabel imgForet;
    public JPanel pOnglets;
    public JPanel pBanniere;
    public JPanel pMilieuCampement;
    public JPanel pMilieuCaverne;
    public JPanel pMilieuChateau;
    public JPanel pMilieuForet;
    public JPanel pMilieuTaverne;
    public JPanel pDialogue;

    public JLabel imgMilieuCampement;
    public JLabel imgMilieuCaverne;
    public JLabel imgMilieuChateau;
    public JLabel imgMilieuForet;
    public JLabel imgMilieuTaverne;

    public JPanel pBoutonsCampement;
    public JPanel pBoutonsCaverne;
    public JPanel pBoutonsChateau;
    public JPanel pBoutonsForet;
    public JPanel pBoutonsTaverne;

    public JPanel jeu;

    public JTextField textReponse;
    public JButton buttonReponse;

    public JButton buttonSauverCampement;
    public JButton buttonSauverCaverne;
    public JButton buttonSauverChateau;
    public JButton buttonSauverForet;
    public JButton buttonSauverTaverne;

    public FenetreJeu(ModelHero modelH) {

        this.modelH=modelH;
        setTitle("RPG");
        initJeu();
        plateauDeJeu();
        setResizable(false);
        setSize(new Dimension(465,365));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initJeu() {
        objectif1 = new ModelObjectif(3);
        objectif2 = new ModelObjectif(2);
        objectif3 = new ModelObjectif(1);

        mob1 = new ModelMob("Tréant");
        mob2 = new ModelMob("Bandit");
        mob3 = new ModelMob("Dragon");

        quete1 = new ModelQuete("Du bois pour les chopines", "Bien le bonjour, \nEst ce que vous pouvez m'aider, j'aurais besoin de bois pour mes chopines. \nMais pas n'importe lequel, du bois de tréants, Y'en a dans la forêt, \nVous pourriez aller m'en chercher ?", mob1, objectif1);
        quete2 = new ModelQuete("Pas de bandits chez moi", "Vous là, ça vous dirait de casser du bandits ? \nY'en a plein dans le campement pas loin du village, \net ils menacent la paix chez nous. Allez y est revenez quand ce sera fini !", mob2, objectif2);
        quete3 = new ModelQuete("Du feu dans la caverne", "Aventuriez, je suis content de vous voir, \nUne créature puissante a élu domicile dans la caverne au nord. \n Il faudrait la déloger, je peux compter sur vous ?", mob3, objectif3);

        pnj1 = new ModelPnj("Tavernier", quete1, ModelEntite.Genre.HOMME);
        pnj2 = new ModelPnj("Skovald", quete2, ModelEntite.Genre.HOMME);
        pnj3 = new ModelPnj("Arcania", quete3, ModelEntite.Genre.FEMMME);

        panoGlobalJeu = new JPanel();
        taverne = new JPanel(new GridLayout(2,1));
        chateau= new JPanel(new GridLayout(2,1));
        caverne= new JPanel(new GridLayout(2,1));
        campement= new JPanel(new GridLayout(2,1));
        foret= new JPanel(new GridLayout(2,1));
        pOnglets= new JPanel();
        pBanniere= new JPanel();
        pMilieuCampement= new JPanel(new GridLayout(1,3));
        pMilieuCaverne= new JPanel(new GridLayout(1,3));
        pMilieuChateau= new JPanel(new GridLayout(1,3));
        pMilieuForet= new JPanel(new GridLayout(1,3));
        pMilieuTaverne= new JPanel(new GridLayout(1,3));
        pInteractionCaverne= new JPanel(new GridLayout(3,1));
        pInteractionCampement= new JPanel(new GridLayout(3,1));
        pInteractionChateau= new JPanel(new GridLayout(3,1));
        pInteractionForet= new JPanel(new GridLayout(3,1));
        pInteractionTaverne= new JPanel(new GridLayout(3,1));
        pDialogue= new JPanel();
        pBoutonsCampement= new JPanel(new GridLayout(3,1));
        pBoutonsCaverne= new JPanel(new GridLayout(3,1));
        pBoutonsChateau= new JPanel(new GridLayout(3,1));
        pBoutonsForet= new JPanel(new GridLayout(3,1));
        pBoutonsTaverne= new JPanel(new GridLayout(3,1));
        vide = new JPanel();
        onglets = new JTabbedPane(SwingConstants.TOP);

        buttonCaracteristiqueCampement = new JButton("Caractéristique");
        buttonCaracteristiqueCampement.setPreferredSize(new Dimension(150, 50));

        buttonCaracteristiqueCaverne = new JButton("Caractéristique");
        buttonCaracteristiqueCaverne.setPreferredSize(new Dimension(150, 50));

        buttonCaracteristiqueChateau = new JButton("Caractéristique");
        buttonCaracteristiqueChateau.setPreferredSize(new Dimension(150, 50));

        buttonCaracteristiqueForet = new JButton("Caractéristique");
        buttonCaracteristiqueForet.setPreferredSize(new Dimension(150, 50));

        buttonCaracteristiqueTaverne = new JButton("Caractéristique");
        buttonCaracteristiqueTaverne.setPreferredSize(new Dimension(150, 50));


        buttonQueteCampement = new JButton("Quête");
        buttonQueteCampement.setPreferredSize(new Dimension(150, 50));

        buttonQueteCaverne = new JButton("Quête");
        buttonQueteCaverne.setPreferredSize(new Dimension(150, 50));

        buttonQueteChateau = new JButton("Quête");
        buttonQueteChateau.setPreferredSize(new Dimension(150, 50));

        buttonQueteForet = new JButton("Quête");
        buttonQueteForet.setPreferredSize(new Dimension(150, 50));

        buttonQueteTaverne = new JButton("Quête");
        buttonQueteTaverne.setPreferredSize(new Dimension(150, 50));

        buttonSauverCampement = new JButton("Sauvegarder");
        buttonSauverCampement.setPreferredSize(new Dimension(150, 50));

        buttonSauverCaverne = new JButton("Sauvegarder");
        buttonSauverCaverne.setPreferredSize(new Dimension(150, 50));

        buttonSauverChateau = new JButton("Sauvegarder");
        buttonSauverChateau.setPreferredSize(new Dimension(150, 50));

        buttonSauverForet = new JButton("Sauvegarder");
        buttonSauverForet.setPreferredSize(new Dimension(150, 50));

        buttonSauverTaverne = new JButton("Sauvegarder");
        buttonSauverTaverne.setPreferredSize(new Dimension(150, 50));



        textReponse = new JTextField();
        textReponse.setColumns(10);
        buttonReponse = new JButton("Valider");
        buttonReponse.setMnemonic(KeyEvent.VK_ENTER);

        imgCaverne = new JLabel( new ImageIcon( "img/Caverne.jpg"));
        imgChateau = new JLabel( new ImageIcon( "img/Chateau.jpg"));
        imgForet = new JLabel( new ImageIcon( "img/Foret.jpg"));
        imgCampement = new JLabel( new ImageIcon( "img/CampementBandit.jpg"));
        imgTaverne = new JLabel( new ImageIcon( "img/Taverne.jpg"));
        imgMilieuCampement = new JLabel(new ImageIcon("img/imageMilieu.png"));
        imgMilieuChateau = new JLabel(new ImageIcon("img/imageMilieu.png"));
        imgMilieuForet = new JLabel(new ImageIcon("img/imageMilieu.png"));
        imgMilieuCaverne = new JLabel(new ImageIcon("img/imageMilieu.png"));
        imgMilieuTaverne = new JLabel(new ImageIcon("img/imageMilieu.png"));

        imgCaverne.setPreferredSize(new Dimension(20,20));
        imgChateau.setPreferredSize(new Dimension(20,20));
        imgForet.setPreferredSize(new Dimension(20,20));
        imgCampement.setPreferredSize(new Dimension(20,20));
        imgTaverne.setPreferredSize(new Dimension(20,20));

        bInteractionCampement = new JButton("Combattre");
        bInteractionCampement.setPreferredSize(new Dimension(150, 50));
        bInteractionCaverne = new JButton("Combattre");
        bInteractionCaverne.setPreferredSize(new Dimension(150, 50));
        bInteractionChateau = new JButton("Commandante");
        bInteractionChateau.setPreferredSize(new Dimension(150, 50));
        bInteractionForet = new JButton("Combattre");
        bInteractionForet.setPreferredSize(new Dimension(150, 50));
        bInteractionTaverne1 = new JButton("Tavernier");
        bInteractionTaverne1.setPreferredSize(new Dimension(150, 50));
        bInteractionTaverne2 = new JButton("Aventurier");
        bInteractionTaverne2.setPreferredSize(new Dimension(150, 50));
    }

    public void plateauDeJeu() {

        pBoutonsCampement.add(buttonCaracteristiqueCampement);
        pBoutonsCampement.add(buttonQueteCampement);
        pBoutonsCampement.add(buttonSauverCampement);
        pInteractionCampement.add(bInteractionCampement);
        pMilieuCampement.add(pInteractionCampement);
        pMilieuCampement.add(imgMilieuCampement);
        pMilieuCampement.add(pBoutonsCampement);
        campement.add(imgCampement);
        campement.add(pMilieuCampement);

        pBoutonsTaverne.add(buttonCaracteristiqueTaverne);
        pBoutonsTaverne.add(buttonQueteTaverne);
        pBoutonsTaverne.add(buttonSauverTaverne);
        pInteractionTaverne.add(bInteractionTaverne1);
        pInteractionTaverne.add(bInteractionTaverne2);
        pMilieuTaverne.add(pInteractionTaverne);
        pMilieuTaverne.add(imgMilieuTaverne);
        pMilieuTaverne.add(pBoutonsTaverne);
        taverne.add(imgTaverne);
        taverne.add(pMilieuTaverne);

        pBoutonsForet.add(buttonCaracteristiqueForet);
        pBoutonsForet.add(buttonQueteForet);
        pBoutonsForet.add(buttonSauverForet);
        pInteractionForet.add(bInteractionForet);
        pMilieuForet.add(pInteractionForet);
        pMilieuForet.add(imgMilieuForet);
        pMilieuForet.add(pBoutonsForet);
        foret.add(imgForet);
        foret.add(pMilieuForet);

        pBoutonsCaverne.add(buttonCaracteristiqueCaverne);
        pBoutonsCaverne.add(buttonQueteCaverne);
        pBoutonsCaverne.add(buttonSauverCaverne);
        pInteractionCaverne.add(bInteractionCaverne);
        pMilieuCaverne.add(pInteractionCaverne);
        pMilieuCaverne.add(imgMilieuCaverne);
        pMilieuCaverne.add(pBoutonsCaverne);
        caverne.add(imgCaverne);
        caverne.add(pMilieuCaverne);

        pBoutonsChateau.add(buttonCaracteristiqueChateau);
        pBoutonsChateau.add(buttonQueteChateau);
        pBoutonsChateau.add(buttonSauverChateau);
        pInteractionChateau.add(bInteractionChateau);
        pMilieuChateau.add(pInteractionChateau);
        pMilieuChateau.add(imgMilieuChateau);
        pMilieuChateau.add(pBoutonsChateau);
        chateau.add(imgChateau);
        chateau.add(pMilieuChateau);

        onglets.addTab("taverne",taverne );
        onglets.addTab("chateau",chateau );
        onglets.addTab("caverne",caverne );
        onglets.addTab("campement",campement );
        onglets.addTab("foret",foret);
        panoGlobalJeu.add(onglets);


        setContentPane(panoGlobalJeu);

        controlButtonFenetre = new ControlButtonFenetre(modelH,this);
    }

    public void setInteraction(ActionListener listener) {
        buttonCaracteristiqueCampement.addActionListener(listener);
        buttonCaracteristiqueCaverne.addActionListener(listener);
        buttonCaracteristiqueChateau.addActionListener(listener);
        buttonCaracteristiqueForet.addActionListener(listener);
        buttonCaracteristiqueTaverne.addActionListener(listener);

        buttonQueteCampement.addActionListener(listener);
        buttonQueteCaverne.addActionListener(listener);
        buttonQueteChateau.addActionListener(listener);
        buttonQueteForet.addActionListener(listener);
        buttonQueteTaverne.addActionListener(listener);

        buttonSauverCampement.addActionListener(listener);
        buttonSauverCaverne.addActionListener(listener);
        buttonSauverChateau.addActionListener(listener);
        buttonSauverForet.addActionListener(listener);
        buttonSauverTaverne.addActionListener(listener);

        bInteractionCampement.addActionListener(listener);
        bInteractionCaverne.addActionListener(listener);
        bInteractionChateau.addActionListener(listener);
        bInteractionForet.addActionListener(listener);
        bInteractionTaverne1.addActionListener(listener);

        buttonCaracteristiqueCampement.setActionCommand("Caracteristique");
        buttonCaracteristiqueCaverne.setActionCommand("Caracteristique");
        buttonCaracteristiqueChateau.setActionCommand("Caracteristique");
        buttonCaracteristiqueForet.setActionCommand("Caracteristique");
        buttonCaracteristiqueTaverne.setActionCommand("Caracteristique");

        buttonQueteCampement.setActionCommand("Quetes");
        buttonQueteCaverne.setActionCommand("Quetes");
        buttonQueteChateau.setActionCommand("Quetes");
        buttonQueteForet.setActionCommand("Quetes");
        buttonQueteTaverne.setActionCommand("Quetes");

        buttonSauverCampement.setActionCommand("Sauver");
        buttonSauverCaverne.setActionCommand("Sauver");
        buttonSauverChateau.setActionCommand("Sauver");
        buttonSauverForet.setActionCommand("Sauver");
        buttonSauverTaverne.setActionCommand("Sauver");

        bInteractionCampement.setActionCommand("Combattre");
        bInteractionCaverne.setActionCommand("Combattre");
        bInteractionChateau.setActionCommand("Jarl");
        bInteractionForet.setActionCommand("Combattre");
        bInteractionTaverne1.setActionCommand("Tavernier");

    }

    public void display() {
        setVisible(true);
    }

    public void sauvegarder() throws IOException{
        String file = "src/save.txt";
        PrintStream ps = new PrintStream(new File(file));
        modelH.sauvegarder(ps);
        JOptionPane d = new JOptionPane();
        String options[]={ " Ok "};
        String message = "Sauvegarde effectué";
        d.showOptionDialog(null,message,"Sauvegarde",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
    }
}