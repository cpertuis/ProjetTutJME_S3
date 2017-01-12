package view;


import controller.ControlButtonQuetes;
import model.ModelHero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Quetes extends JFrame {
    FenetreJeu fenetreJeu;
    ModelHero modelHero;
    JPanel quete;
    JLabel lQuete;
    public JButton buttonExit;
    ControlButtonQuetes controlButtonQuetes;

    public Quetes(ModelHero modelHero){
        this.modelHero=modelHero;
        initAttribut();
        createWidget();
        setResizable(false);
        setVisible(false);
        setSize(300, 500);
        setLocationRelativeTo(null);
        controlButtonQuetes = new ControlButtonQuetes(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    private void initAttribut(){
        if(modelHero.getQueteEnCours() == true){
            lQuete = new JLabel("Quête courante :");
            fenetreJeu.queteCourante.print();
        }
        else{
            lQuete = new JLabel("Vous n'avez pas de quêtes.");
        }
    }

    private void createWidget(){
        quete = new JPanel(new GridLayout(2,1)); // A changer en fonction du nombre de quetes
        quete.add(lQuete);
        buttonExit = new JButton("Fermer");
        buttonExit.setPreferredSize(new Dimension(150,30));
        quete.add(buttonExit);
        setContentPane(quete);
    }

    public void display() {
        setVisible(true);
    }

    public void setFermeQuetes(ActionListener listener){
        buttonExit.addActionListener(listener);
    }
}
