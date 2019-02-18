/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolas_locas;

import javax.swing.JFrame;

/**
 *
 * @author Alfonso HA
 */
public class Lienzo extends JFrame{
    public Lienzo (Juego juego) {
        JFrame frame = new JFrame();
        frame.add(juego);
        frame.setSize(400,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
    }
}
