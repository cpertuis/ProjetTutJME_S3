package view;

import controller.ControlButtonCarac;
import controller.ControlButtonFenetre;
import model.ModelHero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class FenetreJeu extends JFrame {

    protected ModelHero modelH;

    public ControlButtonFenetre controlButtonFenetre;
    public JPanel panoGlobalJeu;

    public JPanel pInteractionCampement;
    public JPanel pInteractionVillage;
    public JPanel pInteractionCaverne;
    public JPanel pInteractionChateau;
    public JPanel pInteractionForet;
    public JPanel pInteractionTaverne;
    public JButton buttonCaractéristique;
    public JButton buttonQuete;
    public JButton bInteractionCampement;
    public JButton bInteractionCaverne;
    public JButton bInteractionChateau;
    public JButton bInteractionForet;
    public JButton bInteractionTaverne1;
    public JButton bInteractionTaverne2;
    public JButton bInteractionVillage1;
    public JButton bInteractionVillage2;


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
    public JPanel village;
    public JLabel imgVillage;
    public JPanel pOnglets;
    public JPanel pBanniere;
    public JPanel pMilieuCampement;
    public JPanel pMilieuCaverne;
    public JPanel pMilieuChateau;
    public JPanel pMilieuForet;
    public JPanel pMilieuTaverne;
    public JPanel pMilieuVillage;
    public JPanel pDialogue;
    public JPanel pBoutons;
    public JPanel pBas;
    public JPanel pReponse;
    public JPanel jeu;



    public JTextField textReponse;
    public JButton buttonReponse;
    public JButton buttonSauver;

    public JTextArea tableauAll;

    public FenetreJeu(ModelHero modelH) {

        this.modelH=modelH;
        setTitle("RPG");
        initJeu();
        plateauDeJeu();
        setResizable(true);
        setSize(new Dimension(1200,900));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initJeu() {
        panoGlobalJeu = new JPanel();
        pReponse = new JPanel(new GridLayout(1,2));
        taverne = new JPanel(new GridLayout(3,1));
        chateau= new JPanel(new GridLayout(3,1));
        caverne= new JPanel(new GridLayout(3,1));
        campement= new JPanel(new GridLayout(3,1));
        foret= new JPanel(new GridLayout(3,1));
        village= new JPanel(new GridLayout(3,1));
        pOnglets= new JPanel();
        pBanniere= new JPanel();
        pMilieuCampement= new JPanel(new GridLayout(1,3));
        pMilieuCaverne= new JPanel(new GridLayout(1,3));
        pMilieuChateau= new JPanel(new GridLayout(1,3));
        pMilieuForet= new JPanel(new GridLayout(1,3));
        pMilieuTaverne= new JPanel(new GridLayout(1,3));
        pMilieuVillage= new JPanel(new GridLayout(1,3));
        pInteractionCaverne= new JPanel(new GridLayout(3,1));
        pInteractionCampement= new JPanel(new GridLayout(3,1));
        pInteractionChateau= new JPanel(new GridLayout(3,1));
        pInteractionForet= new JPanel(new GridLayout(3,1));
        pInteractionTaverne= new JPanel(new GridLayout(3,1));
        pInteractionVillage= new JPanel(new GridLayout(3,1));
        pDialogue= new JPanel();
        pBoutons= new JPanel(new GridLayout(2,1));
        pBas= new JPanel(new GridLayout(1,3));
        vide = new JPanel();
        onglets = new JTabbedPane(SwingConstants.TOP);

        buttonCaractéristique = new JButton("Caractéristique");
        buttonCaractéristique.setPreferredSize(new Dimension(150, 50));

        buttonQuete = new JButton("Quête");
        buttonQuete.setPreferredSize(new Dimension(150, 50));

        buttonSauver = new JButton("Sauvegarder");
        buttonSauver.setPreferredSize(new Dimension(150, 50));


        pReponse = new JPanel();

        textReponse = new JTextField();
        textReponse.setColumns(10);
        buttonReponse = new JButton("Valider");
        buttonReponse.setMnemonic(KeyEvent.VK_ENTER);

        imgCaverne = new JLabel( new ImageIcon( "img/Caverne.jpg"));
        imgChateau = new JLabel( new ImageIcon( "img/Chateau.jpg"));
        imgForet = new JLabel( new ImageIcon( "img/Foret.jpg"));
        imgCampement = new JLabel( new ImageIcon( "img/Campement.jpg"));
        imgTaverne = new JLabel( new ImageIcon( "img/Taverne.jpg"));
        imgVillage = new JLabel( new ImageIcon( "img/Village.jpg"));

        imgCaverne.setPreferredSize(new Dimension(20,20));
        imgChateau.setPreferredSize(new Dimension(20,20));
        imgForet.setPreferredSize(new Dimension(20,20));
        imgCampement.setPreferredSize(new Dimension(20,20));
        imgTaverne.setPreferredSize(new Dimension(20,20));
        imgVillage.setPreferredSize(new Dimension(20,20));

        bInteractionCampement = new JButton("Combattre");
        bInteractionCampement.setPreferredSize(new Dimension(150, 50));
        bInteractionCaverne = new JButton("Combattre");
        bInteractionCaverne.setPreferredSize(new Dimension(150, 50));
        bInteractionChateau = new JButton("Combattre");
        bInteractionChateau.setPreferredSize(new Dimension(150, 50));
        bInteractionForet = new JButton("Combattre");
        bInteractionForet.setPreferredSize(new Dimension(150, 50));
        bInteractionTaverne1 = new JButton("Parler au tavernier");
        bInteractionTaverne1.setPreferredSize(new Dimension(150, 50));
        bInteractionTaverne2 = new JButton("Parler à l'homme louche");
        bInteractionTaverne2.setPreferredSize(new Dimension(150, 50));
        bInteractionVillage1 = new JButton("Parler a un garde");
        bInteractionVillage1.setPreferredSize(new Dimension(150, 50));
        bInteractionVillage2 = new JButton("Parler a un chien");
        bInteractionVillage2.setPreferredSize(new Dimension(150, 50));
        tableauAll = new JTextArea("");
    }

    public void plateauDeJeu() {
        tableauAll.setBackground(Color.LIGHT_GRAY);


        pBoutons.add(buttonCaractéristique);
        pBoutons.add(buttonQuete);
        pBas.add(buttonSauver);
        pReponse.add(textReponse);
        pReponse.add(buttonReponse);
        pBas.add(pReponse);

        pInteractionCampement.add(bInteractionCampement);
        pMilieuCampement.add(pInteractionCampement);
        pMilieuCampement.add(tableauAll);
        tableauAll.setText("");
        pMilieuCampement.add(pBoutons);
        campement.add(imgCampement);
        campement.add(pMilieuCampement);
        campement.add(pBas);

        pInteractionVillage.add(bInteractionVillage1);
        pInteractionVillage.add(bInteractionVillage2);
        pMilieuVillage.add(pInteractionVillage);
        pMilieuCampement.add(tableauAll);
        tableauAll.setText("");
        pMilieuCampement.add(pBoutons);
        village.add(imgVillage);
        village.add(pMilieuVillage);
        village.add(pBas);

        pInteractionTaverne.add(bInteractionTaverne1);
        pInteractionTaverne.add(bInteractionTaverne2);
        pMilieuTaverne.add(pInteractionTaverne);
        pMilieuTaverne.add(tableauAll);
        tableauAll.setText("");
        pMilieuTaverne.add(pBoutons);
        taverne.add(imgTaverne);
        taverne.add(pMilieuTaverne);
        taverne.add(pBas);

        pInteractionForet.add(bInteractionForet);
        pMilieuForet.add(pInteractionForet);
        pMilieuForet.add(tableauAll);
        tableauAll.setText("");
        pMilieuForet.add(pBoutons);
        foret.add(imgForet);
        foret.add(pMilieuForet);
        foret.add(pBas);

        pInteractionCaverne.add(bInteractionCaverne);
        pMilieuCaverne.add(pInteractionCaverne);
        pMilieuCaverne.add(tableauAll);
        tableauAll.setText("");
        pMilieuCaverne.add(pBoutons);
        caverne.add(imgCaverne);
        caverne.add(pMilieuCaverne);
        caverne.add(pBas);

        pInteractionChateau.add(bInteractionChateau);
        pMilieuChateau.add(pInteractionChateau);
        pMilieuChateau.add(tableauAll);
        tableauAll.setText("");
        pMilieuChateau.add(pBoutons);
        chateau.add(imgChateau);
        chateau.add(pMilieuChateau);
        chateau.add(pBas);

        onglets.addTab("village",village);
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
        buttonCaractéristique.addActionListener(listener);
        buttonQuete.addActionListener(listener);
        buttonReponse.addActionListener(listener);
    }

    public void display() {
        setVisible(true);
    }
}