package org.example.view.imagem_config;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImagemFundo extends JPanel {

    private Image img;

    public ImagemFundo(String caminho) {
        URL imgURL = getClass().getClassLoader().getResource(caminho);
        if (imgURL != null) {
            img = new ImageIcon(imgURL).getImage();
        } else {
            System.out.println("Imagem não encontrada " + caminho);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }
}