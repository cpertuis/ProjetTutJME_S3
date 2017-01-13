package view;

import model.ModelHero;
import model.ModelPnj;
import model.ModelQuete;

import javax.swing.*;
import java.awt.*;

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
    public JPanel reponse;
    public JPanel infoQuete;
    public JPanel infoPNJ;
    public JPanel global;

    public FenetrePNJ(ModelHero modelHero, ModelPnj modelPnj){
        this.modelHero=modelHero;
        this.modelPnj=modelPnj;
        setTitle("PNJ");
        initFen();
        creationVue();
        setSize(900,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }


    public void initFen() {
        reponse = new JPanel(new GridLayout(1,2));
        infoQuete = new JPanel(new GridLayout(2,1));
        infoPNJ = new JPanel(new GridLayout(1,2));
        texteQuete= new JTextArea("");
        texteQuete.setEditable(false);
        accepter = new JButton("Accepter");
        accepter.setBackground(new Color(0,255,0));
        refuser = new JButton("Refuser");
        accepter.setBackground(new Color(250,0,0));
        nomPnj = new JLabel(modelPnj.getNom());
        if (modelHero.getQueteEnCours()){
            texteQuete.setText("Vous avez déja une quête en cours \n Revenez plus tard");
            global =new JPanel();
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
                global =new JPanel(new GridLayout(2,1));
            }
        }

        if (modelPnj.getNom().equals("Tavernier")){
            imgPNJ = new JLabel(new ImageIcon( "img/Tavernier.jpg"));
        }
        if (modelPnj.getNom().equals("Arcania")){
            imgPNJ = new JLabel(new ImageIcon( "img/Arcania.jpg"));
        }
        if (modelPnj.getNom().equals("Skovald")){
            imgPNJ = new JLabel(new ImageIcon( "img/Skovald.jpg"));
        }
    }

    private void creationVue() {
        infoQuete.add(nomPnj);
        infoQuete.add(texteQuete);
        infoPNJ.add(infoQuete);
        infoPNJ.add(imgPNJ);
        global.add(infoPNJ);
        if (!modelHero.getQueteEnCours()){
            if (!modelPnj.getQueteDonnee()){
                reponse.add(accepter);
                reponse.add(refuser);
                global.add(reponse);
            }
        }
        setContentPane(global);
    }

    public void queteAcceptee(ModelQuete quete){
        if(modelHero.getQueteEnCours() == false){
            modelHero.queteCourante = quete;
        }
        else{
            JOptionPane jOptionPane = new JOptionPane();
            String options[]={ " Ok "};
            String message = "Vous avez déja une quête en cours";
            jOptionPane.showOptionDialog(null,message,"Attention",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
        }
    }
}
