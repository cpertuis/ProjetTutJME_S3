package view;


import controller.ControlButtonQuetes;
import model.ModelHero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Quetes extends JFrame {
    public FenetreJeu fenetreJeu;
    public ModelHero modelHero;
    public JPanel quete;
    public JPanel button;
    public JLabel lQuete;
    public JButton buttonExit;
    public JButton abandon;
    ControlButtonQuetes controlButtonQuetes;

    public Quetes(ModelHero modelHero){
        this.modelHero=modelHero;
        initAttribut();
        createWidget();
        setResizable(false);
        setVisible(false);
        setSize(300, 150);
        setLocationRelativeTo(null);
        controlButtonQuetes = new ControlButtonQuetes(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    private void initAttribut(){
        if(modelHero.getQueteEnCours() == true){
            lQuete = new JLabel(modelHero.queteCourante.getObjectif().toString());
        }
        else{
            lQuete = new JLabel("Vous n'avez pas de quêtes.");
        }
    }

    private void createWidget(){
        quete = new JPanel(new GridLayout(2,1)); // A changer en fonction du nombre de quetes
        button = new JPanel(new GridLayout(2,1));
        quete.add(lQuete);
        abandon = new JButton("Abandonner");
        buttonExit = new JButton("Fermer");
        buttonExit.setPreferredSize(new Dimension(150,30));
        if (modelHero.getQueteEnCours())
            button.add(abandon);
        else
            button.add(new JLabel(""));
        button.add(buttonExit);
        quete.add(button);
        setContentPane(quete);
    }

    public void display() {
        setVisible(true);
    }

    public void setFermeQuetes(ActionListener listener){
        buttonExit.addActionListener(listener);
        abandon.addActionListener(listener);
    }

    public void repaint(){
        initAttribut();
        createWidget();
        setResizable(false);
        setVisible(false);
        setSize(300, 150);
        setLocationRelativeTo(null);
        controlButtonQuetes = new ControlButtonQuetes(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
