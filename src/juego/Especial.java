/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vectormx
 */
public class Especial implements Runnable{
    Nivel3 juego;
    Rectangle raqueta;
    private int posicionX;
    private int posicionY;
    private int movimientoY;
    Random ran = new Random();
    
    public Especial(Nivel3 juego) {
        this.juego = juego;
        raqueta = juego.raqueta.obtenerLimite();
        posicionX = raqueta.getBounds().x + 25;
        posicionY = raqueta.getBounds().y;
                
    }
    public void lanzarEspecial() {
        Thread h = new Thread(this);
        h.start();
        //juego.cuadrados.clear();
    }
    public void vizualizarEspecial(Graphics2D g){
         g.setColor(new Color(ran.nextInt(200), ran.nextInt(200), ran.nextInt(200)));
         g.fillOval(posicionX, posicionY, 20, 20);
        }

    @Override
    public void run() {
        int c  =0;
        while(c<250) {
            try {
            posicionY += -1;
            juego.repaint();
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Especial.class.getName()).log(Level.SEVERE, null, ex);
            }
            c++;
        }
        try {
            Thread.sleep(10);
            juego.cuadrados.clear();
            juego.balas.clear();
        } catch (InterruptedException ex) {
            Logger.getLogger(Especial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
