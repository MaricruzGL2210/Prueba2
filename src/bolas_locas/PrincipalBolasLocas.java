/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolas_locas;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alfonso HA
 */
public class PrincipalBolasLocas {
    public static void main(String[] args) throws InterruptedException {
        Juego juego = new Juego();
        while (true) {
                    try {
                        juego.moverPelota();
                        juego.moverRaqueta();
                        juego.repaint();
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BolasLocasInicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
    }
}
