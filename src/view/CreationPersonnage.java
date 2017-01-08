package view;

import model.ModelHero;

import javax.swing.*;
import java.awt.*;

/**
 * Created by raphael on 08/01/17.
 */
public class CreationPersonnage extends JFrame{

    ModelHero modelHero;

    JPanel creationPersoGlobal;
    JPanel creationPerso;
    JPanel creationPersoSexe;
    JPanel creationPersoClasse;
    JPanel creationPersoNom;
    JPanel creationPersoValider;

    JLabel sexe;
    JLabel classe;
    JLabel nom;

    JTextField entrerNom;

    JRadioButton buttonSexeH;
    JRadioButton buttonSexeF;

    ButtonGroup groupSexe;

    JButton valider;

    String[] choixClasse;

    JComboBox listClasse;

    public CreationPersonnage(){

        setTitle("Création du personnage");
        initCreationPerso();
        setResizable(false);
        setSize(900,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void initCreationPerso(){

        creationPersoSexe = new JPanel(new GridLayout(1,3));
        creationPersoClasse = new JPanel(new GridLayout(1,2));
        creationPersoNom = new JPanel(new GridLayout(1,2));
        creationPersoValider = new JPanel();
        creationPerso = new JPanel(new GridLayout(4,1));
        creationPersoGlobal = new JPanel();

        sexe = new JLabel("Sexe");
        buttonSexeF = new JRadioButton("Femme");
        buttonSexeH = new JRadioButton("Homme");
        groupSexe = new ButtonGroup();
        groupSexe.add(buttonSexeF);
        groupSexe.add(buttonSexeH);

        classe = new JLabel("Classe");
        choixClasse = new String[]{"Mage", "Guerrier", "Assassin", "Travelers"};
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

        setContentPane(creationPersoGlobal);
    }
}
