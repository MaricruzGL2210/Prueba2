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
public class P {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Pelota rebotando");
        Juego juego = new Juego();
        frame.add(juego);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        while (true) {
            juego.moverPelota();
            juego.moverRaqueta();
            juego.repaint();
            Thread.sleep(10);
        }
    }
}
