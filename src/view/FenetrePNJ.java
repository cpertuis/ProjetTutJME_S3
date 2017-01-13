package view;

import controller.ControlBoutonPNJ;
import model.ModelHero;
import model.ModelPnj;
import model.ModelQuete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static java.awt.GridBagConstraints.BOTH;
import static java.awt.GridBagConstraints.NONE;

/**
 * Created by Tanguy on 12/01/2017.
 */
public class FenetrePNJ extends JFrame{

    public ModelHero modelHero;
    public ModelPnj modelPnj;
    public JLabel nomPnj;
    public JTextArea texteQuete;
    public JLabel imgPNJ;
    public JButton accepter;
    public JButton refuser;
    public JPanel global;
    public ControlBoutonPNJ controlBoutonPNJ;

    public FenetrePNJ(ModelHero modelHero, ModelPnj modelPnj){
        this.modelHero=modelHero;
        this.modelPnj=modelPnj;
        setTitle("PNJ");
        initFen();
        creationVue();
        setResizable(false);
        setSize(new Dimension(465,365));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }


    public void initFen() {
        texteQuete= new JTextArea("");
        texteQuete.setEditable(false);
        accepter = new JButton("Accepter");
        accepter.setBackground(new Color(0,255,0));
        accepter.setPreferredSize(new Dimension(150, 50));

        refuser = new JButton("Refuser");
        refuser.setBackground(new Color(250,0,0));
        refuser.setMaximumSize(new Dimension(150, 50));

        nomPnj = new JLabel(modelPnj.getNom());
        if (modelHero.getQueteEnCours()){
            texteQuete.setText("Vous avez déja une quête en cours \n Revenez plus tard");
            global =new JPanel(new GridBagLayout());
        }else {
            if (modelPnj.getQueteDonnee()){
                if (modelPnj.getQuete().getSuccess()){
                    texteQuete.setText("Bravo vous avez réussi ma quête. \n\n\n\n\n Vous avez gagné un niveau.");
                    global =new JPanel();                } else {
                    texteQuete.setText("Vous n'avez pas fini ma quête. \n Revenez plus tard.");
                    global =new JPanel();
                }
            }else {
                texteQuete.setText(modelPnj.getQuete().toString());
                global =new JPanel(new GridBagLayout());
            }
        }

        if (modelPnj.getNom().equals("Tavernier")){
            imgPNJ = new JLabel(new ImageIcon( "img/Tavernier.jpg"));
        }
        if (modelPnj.getNom().equals("Arcania")){
            imgPNJ = new JLabel(new ImageIcon( "img/Arcania.png"));
        }
        if (modelPnj.getNom().equals("Skovald")){
            imgPNJ = new JLabel(new ImageIcon( "img/Skovald.jpg"));
        }
    }

    private void creationVue() {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weightx=10;
        gbc.weighty=10;
        gbc.fill=BOTH;

        gbc.gridx=0;
        gbc.gridwidth=7;
        gbc.gridy=0;
        gbc.gridheight=1;
        global.add(nomPnj);

        gbc.gridx=0;
        gbc.gridwidth=7;
        gbc.gridy=1;
        gbc.gridheight=7;
        global.add(texteQuete,gbc);

        gbc.gridx=7;
        gbc.gridwidth=3;
        gbc.gridy=0;
        gbc.gridheight=4;
        global.add(imgPNJ,gbc);

        if (!modelHero.getQueteEnCours()){
            if (!modelPnj.getQueteDonnee()){
                gbc.weightx=10;
                gbc.weighty=10;
                gbc.fill=BOTH;

                gbc.gridx=0;
                gbc.gridwidth=7;
                gbc.gridy=0;
                gbc.gridheight=1;
                global.add(nomPnj);

                gbc.gridx=0;
                gbc.gridwidth=7;
                gbc.gridy=1;
                gbc.gridheight=7;
                global.add(texteQuete,gbc);

                gbc.gridx=7;
                gbc.gridwidth=3;
                gbc.gridy=0;
                gbc.gridheight=4;
                global.add(imgPNJ,gbc);

                gbc.fill=NONE;
                gbc.gridx=3;
                gbc.gridwidth=3;
                gbc.gridy=8;
                gbc.gridheight=2;
                global.add(accepter,gbc);

                gbc.gridx=7;
                gbc.gridwidth=3;
                gbc.gridy=8;
                gbc.gridheight=2;
                global.add(refuser,gbc);
            }
        }
        setContentPane(global);
        controlBoutonPNJ=new ControlBoutonPNJ(this,modelHero,modelPnj);
    }

    public void queteAcceptee(ModelQuete quete){
        if(modelHero.getQueteEnCours() == false){
            modelHero.queteCourante = quete;
            modelHero.setQueteEnCours(true);
        }
        else{
            JOptionPane jOptionPane = new JOptionPane();
            String options[]={ " Ok "};
            String message = "Vous avez déja une quête en cours";
            jOptionPane.showOptionDialog(null,message,"Attention",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
        }
    }

    public void setInteraction(ActionListener listener) {
        accepter.addActionListener(listener);
        refuser.addActionListener(listener);
    }
}
