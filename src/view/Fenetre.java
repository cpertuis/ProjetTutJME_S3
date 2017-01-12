package view;

import javax.swing.*;

import controller.ControlBouton;
import model.ModelEntite;
import model.ModelHero;
import model.ModelMob;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;




public class Fenetre extends JFrame {

    //public ControlButton controlBut;
	//public ControlMenu controlMen;
	protected JButton attaquePhy;
	protected JButton attaqueMag;
	protected JButton defPhy;
	protected JButton defMag;




    public Fenetre(ModelMob monstre, ModelHero hero) {
		setTitle("Combat");
		setResizable(true);
		initAttribute();
	
		creerWidget(monstre, hero);
		setSize(900,600);                                // Fixe la taille par défaut
		setVisible(true);                                // Affiche la fenetre
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  // Gestion de la fermeture
    }


    public void creerWidget(ModelMob monstre, ModelHero hero) {    	
    	ImageIcon icon = new ImageIcon(new ImageIcon("mon_image.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    	JLabel image = new JLabel( icon);
    	JLabel vieJoueur = new JLabel(hero.getVie()+"/"+hero.getVieMax());
    	ImageIcon icon2 = new ImageIcon(new ImageIcon("mon_image2.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    	JLabel image2 = new JLabel( icon2);
    	JLabel vieMob = new JLabel(monstre.getVie()+"/"+monstre.getVieMax());
        attaquePhy = new JButton("Attaque Physique"); // Creation des objets à ajouter
        attaqueMag = new JButton("Attaque Magique");
        defPhy = new JButton("Defense Physique");
        defMag = new JButton("Defense Magique");

        JPanel ligne2 = new JPanel();
        ligne2.setLayout(new BoxLayout(ligne2, BoxLayout.LINE_AXIS));
        ligne2.setBackground(Color.WHITE);
        ligne2.add(attaquePhy);
        ligne2.add(attaqueMag);
        
        JPanel ligne3 = new JPanel();
        ligne3.setLayout(new BoxLayout(ligne3, BoxLayout.LINE_AXIS));
        ligne3.add(defPhy);
        ligne3.add(defMag);
        
        JPanel panNom = new JPanel();
        panNom.setBackground(Color.white);
        panNom.setPreferredSize(new Dimension(300, 100));
        panNom.setBorder(BorderFactory.createTitledBorder("Combat"));
        JLabel nomLabel = new JLabel(monstre.getNom());
        panNom.add(nomLabel);
            
        JPanel global = new JPanel();
	    global.setPreferredSize(new Dimension(900, 600));
	    global.setBackground(Color.WHITE);
	    global.setLayout(new GridBagLayout());
	    
	    GridBagConstraints gbc = new GridBagConstraints();
	    	    
	    gbc.gridx = 2;
	    gbc.gridy = 1;
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    global.add(image, gbc);
	    
	    gbc.gridx = 4;
	    gbc.gridy = 1;
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    global.add(image2, gbc);
	    
	    gbc.gridx = 3;
	    gbc.gridy = 3;
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    global.add(panNom, gbc);
	    
	    gbc.gridx = 3;
	    gbc.gridy = 5;
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    global.add(ligne2, gbc);
	    
	    gbc.gridx = 4;
	    gbc.gridy = 2;
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    global.add(vieJoueur, gbc);
	    
	    
	    gbc.gridx = 2;
	    gbc.gridy = 2;
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    global.add(vieMob, gbc);

	    setContentPane(global);
    }
    public void initAttribute(){

    }
    public static void main(String[] args) {
    	 
        javax.swing.SwingUtilities.invokeLater( new Runnable() {
     
          public void run() {
        	  ModelMob monstre = new ModelMob("paul");
        	  ModelHero hero = new ModelHero("raph", ModelEntite.Genre.HOMME,4);
              Fenetre fen = new Fenetre(monstre,hero);
          }
        });
      }

}

