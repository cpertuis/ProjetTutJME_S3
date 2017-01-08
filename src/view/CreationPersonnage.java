package view;

import model.ModelHero;

import javax.swing.*;

/**
 * Created by raphael on 08/01/17.
 */
public class CreationPersonnage extends JFrame{

    ModelHero modelHero;

    JPanel creationPerso;

    JLabel sexe;
    JLabel classe;
    JLabel nom;

    JTextField entrerNom;

    JRadioButton buttonSexeH;
    JRadioButton buttonSexeF;

    ButtonGroup groupSexe;

    String[] choixClasse;

    public CreationPersonnage(){

        setTitle("Création du personnage");
    }

    void initCreatioPerso(){

        creationPerso = new JPanel();

        sexe = new JLabel("Sexe");
        buttonSexeF = new JRadioButton("Femme");
        buttonSexeH = new JRadioButton("Homme");
        groupSexe = new ButtonGroup();
        groupSexe.add(buttonSexeF);
        groupSexe.add(buttonSexeH);

        classe = new JLabel("Classe");
        choixClasse = new String[]{"Mage", "Guerrier", "Assassin", "Travelers"};
    }
}
