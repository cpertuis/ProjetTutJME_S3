package view;

import javax.swing.*;

import controller.ControlBoutonCombat;
import model.ModelHero;
import model.ModelMob;

import java.awt.*;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame{

    public ControlBoutonCombat controlBoutonCombat;
	protected JButton attaquePhy;
	protected JButton ok;
	protected JButton newCombat;
	protected JButton attaqueMag;
	protected JButton defPhy;
	protected JButton defMag;
	protected JButton enq;
	protected JLabel image;
	protected ImageIcon icon;
	protected JLabel vieJoueur;
	protected ImageIcon icon2;
	protected JLabel image2;
	protected JLabel vieMob;
	protected JLabel win;
	Protacted JLabel loos;
	protected JPanel ligne2;
	protected JPanel ligne3;
	protected JPanel panNom;
	public JLabel nomLabel;
	protected JPanel global;
	protected GridBagConstraints gbc;

	 public Fenetre(ModelMob monstre, ModelHero hero, int stat) {
			setTitle("Combat");
			setResizable(true);
			initAttribute(hero, monstre);
		
			if(stat == 1){
				creerWidget(monstre, hero);
			}
			else{
				creerWidget2(monstre, hero);
			}
			setSize(900,600);                                // Fixe la taille par dÃ©faut
			setVisible(true);                                // Affiche la fenetre
		 	setLocationRelativeTo(null);                     // Affiche au milieu de l'écran
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  // Gestion de la fermeture
	    } 
	 
	 public Fenetre(ModelMob monstre, ModelHero hero, int stat, JLabel nomLabel) {
			setTitle("Combat");
			setResizable(true);
			initAttribute(hero, monstre);
			this.nomLabel.setText(nomLabel.getText());
			if(stat == 1){
				creerWidget(monstre, hero);
			}
			else{
				creerWidget2(monstre, hero);
			}
			setSize(900,600);                                // Fixe la taille par dÃ©faut
			setVisible(true);                                // Affiche la fenetre
		 	setLocationRelativeTo(null);                     // Affiche au milieu de l'écran
		 	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  // Gestion de la fermeture
	    }


    public void creerWidget(ModelMob monstre, ModelHero hero) {    	
        ligne2.setLayout(new BoxLayout(ligne2, BoxLayout.LINE_AXIS));
        ligne2.setBackground(Color.WHITE);
        ligne2.add(attaquePhy);
        ligne2.add(attaqueMag);
        
        panNom.setBackground(Color.white);
        panNom.setPreferredSize(new Dimension(300, 100));
        panNom.setBorder(BorderFactory.createTitledBorder("Combat"));
        panNom.add(nomLabel);
            
	    global.setPreferredSize(new Dimension(900, 600));
	    global.setBackground(Color.WHITE);
	    global.setLayout(new GridBagLayout());
	    	    	    
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
    
    public void creerWidget2(ModelMob monstre, ModelHero hero) { 
        ligne3.setLayout(new BoxLayout(ligne3, BoxLayout.LINE_AXIS));
        ligne3.add(defPhy);
        ligne3.add(defMag);
        ligne3.add(enq);
        
        panNom.setBackground(Color.white);
        panNom.setPreferredSize(new Dimension(300, 100));
        panNom.setBorder(BorderFactory.createTitledBorder("Combat"));
        panNom.add(nomLabel);
            
	    global.setPreferredSize(new Dimension(900, 600));
	    global.setBackground(Color.WHITE);
	    global.setLayout(new GridBagLayout());
	    	    	    
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
	    global.add(ligne3, gbc);
	    
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
	
	public void creerWidget3(ModelMob monstre, ModelHero hero) { 
        
		ligne3.setLayout(new BoxLayout(ligne3, BoxLayout.LINE_AXIS));
        ligne3.add(ok);
        ligne3.add(newCombat);
		
        panNom.setBackground(Color.white);
        panNom.setPreferredSize(new Dimension(300, 100));
        panNom.setBorder(BorderFactory.createTitledBorder("Combat"));
        panNom.add(win);
            
	    global.setPreferredSize(new Dimension(900, 600));
	    global.setBackground(Color.WHITE);
	    global.setLayout(new GridBagLayout());

	    gbc.gridx = 3;
	    gbc.gridy = 3;
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    global.add(panWin, gbc);

	    setContentPane(global);
    }
	
	public void creerWidget4(ModelMob monstre, ModelHero hero) { 
        
        panNom.setBackground(Color.white);
        panNom.setPreferredSize(new Dimension(300, 100));
        panNom.setBorder(BorderFactory.createTitledBorder("Combat"));
        panNom.add(loos);
            
	    global.setPreferredSize(new Dimension(900, 600));
	    global.setBackground(Color.WHITE);
	    global.setLayout(new GridBagLayout());

	    gbc.gridx = 3;
	    gbc.gridy = 3;
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    global.add(panWin, gbc);

	    setContentPane(global);
    }
    
    public void initAttribute(ModelHero hero, ModelMob monstre){
    	icon = new ImageIcon(new ImageIcon(hero.image).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    	image = new JLabel( icon);
    	vieJoueur = new JLabel(hero.getVie()+"/"+hero.getVieMax());
    	icon2 = new ImageIcon(new ImageIcon(monstre.image).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    	image2 = new JLabel( icon2);
    	vieMob = new JLabel(monstre.getVie()+"/"+monstre.getVieMax());
        attaquePhy = new JButton("Attaque Physique"); // Creation des objets Ã  ajouter
        attaqueMag = new JButton("Attaque Magique");
        defPhy = new JButton("Esquive");
        defMag = new JButton("Parade");
        enq = new JButton("Encaisser");
		ok = new JButton("OK");
		newCombat = new JButton("Nouveau combat");
        ligne2 = new JPanel();
        ligne3 = new JPanel();
        panNom = new JPanel();
        nomLabel = new JLabel(monstre.getNom());
		win = new JLabel("Vous avez gagné");
		loos = new JLabel("Vous avez perdu");
        global = new JPanel();
	    gbc = new GridBagConstraints();
		controlBoutonCombat = new ControlBoutonCombat(hero,monstre,this);
    }

    public void setInteraction(ActionListener listener) {
    	attaquePhy.addActionListener(listener);
    	attaqueMag.addActionListener(listener);
    	defPhy.addActionListener(listener);
    	defMag.addActionListener(listener);
    	enq.addActionListener(listener);
    	ok.addActionListener(listener);
    	newCombat.addActionListener(listener);
    	attaquePhy.setActionCommand("Attaque physique");
    	attaqueMag.setActionCommand("Attaque magique");
    	defPhy.setActionCommand("Esquive");
    	defMag.setActionCommand("Parade");
    	enq.setActionCommand("Encaisser");
    	ok.setActionCommand("ok");
    	newCombat.setActionCommand("Nouveau Combat");
    }

}

