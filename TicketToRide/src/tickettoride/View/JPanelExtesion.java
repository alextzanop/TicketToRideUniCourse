/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickettoride.View;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 *
 * @author Sovengarde
 */
public class JPanelExtesion extends JPanel {

      Image image;

        public JPanelExtesion(Image img) {
            image=img;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }