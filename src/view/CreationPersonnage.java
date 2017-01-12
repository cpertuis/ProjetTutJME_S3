package view;

import controller.ControlBoutonCreationPersonnage;

import javax.swing.*;
import java.awt.*;

/**
 * Created by raphael on 08/01/17.
 */
public class CreationPersonnage extends JFrame{

    public Image imageFond;

    public ImagePanel creationPersoGlobal;
    public JPanel creationPerso;
    public JPanel creationPersoSexe;
    public JPanel creationPersoClasse;
    public JPanel creationPersoNom;
    public JPanel creationPersoValider;

    public JLabel sexe;
    public JLabel classe;
    public JLabel nom;

    public JTextField entrerNom;

    public JRadioButton buttonSexeH;
    public JRadioButton buttonSexeF;

    public ButtonGroup groupSexe;

    public JButton valider;

    public String[] choixClasse;

    public JComboBox listClasse;

    public ControlBoutonCreationPersonnage controlBoutonCreationPersonnage;

    public CreationPersonnage(){

        controlBoutonCreationPersonnage = new ControlBoutonCreationPersonnage(this);
        setTitle("Création du personnage");
        initCreationPerso();
        setResizable(false);
        setSize(900,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void initCreationPerso(){
        imageFond = Toolkit.getDefaultToolkit().createImage("img/CreationPerso.jpg");

        creationPersoSexe = new JPanel(new GridLayout(1,3));
        creationPersoClasse = new JPanel(new GridLayout(1,2));
        creationPersoNom = new JPanel(new GridLayout(1,2));
        creationPersoValider = new JPanel();
        creationPerso = new JPanel(new GridLayout(4,1));
        creationPersoGlobal = new ImagePanel(imageFond);

        sexe = new JLabel("Sexe");
        buttonSexeF = new JRadioButton("Femme");
        buttonSexeH = new JRadioButton("Homme");
        groupSexe = new ButtonGroup();
        groupSexe.add(buttonSexeF);
        groupSexe.add(buttonSexeH);

        classe = new JLabel("Classe");
        choixClasse = new String[]{"Mage", "Guerrier", "Assassin", "Traveler"};
        listClasse = new JComboBox(choixClasse);

        nom = new JLabel("Nom");
        entrerNom = new JTextField();
        entrerNom.setColumns(15);

        valider = new JButton("Valider");

        creationPersoSexe.add(sexe);
        creationPersoSexe.add(buttonSexeF);
        creationPersoSexe.add(buttonSexeH);
        creationPersoClasse.add(classe);
        creationPersoClasse.add(listClasse);
        creationPersoNom.add(nom);
        creationPersoNom.add(entrerNom);
        creationPersoValider.add(valider);
        creationPerso.add(creationPersoSexe);
        creationPerso.add(creationPersoClasse);
        creationPerso.add(creationPersoNom);
        creationPerso.add(creationPersoValider);


        creationPersoGlobal.add(creationPerso);

        valider.addActionListener(controlBoutonCreationPersonnage);

        setContentPane(creationPersoGlobal);
    }
}
