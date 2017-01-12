package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by raphael on 12/01/17.
 */
public class ImagePanel extends JPanel{

    private Image img;

    public ImagePanel(Image img){
        this.img = img;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
