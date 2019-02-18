/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolas_locas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


/**
 *
 * @author Alfonso HA
 */
public class PrincipalBolasLocas extends JFrame{
    private static Juego juego;
    private static Lienzo lienzo;
    private static int nivelActual = 0;
    
    public static void main(String[] args) throws InterruptedException {
        if (nivelActual == 0) {
            nivelActual = 1;
        }
        
        juego = new Juego(nivelActual);
        lienzo = new Lienzo(juego);
        while (true) {
                    try {
                        juego.moverPelota();
                        juego.moverRaqueta();
                        juego.repaint();
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        /*while (true) {
                    try {
                        juego.moverPelota();
                        juego.moverRaqueta();
                        juego.repaint();
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BolasLocasInicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }*/
       
    }
}
