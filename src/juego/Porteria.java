/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Maricruz GL
 */
public class Porteria {

    private Nivel1 juego;
    
    public static final int POSICIONXP = 160;
    public static final int POSICIONYP = 3;
    
    public static final int POSICIONXP2 = 250;
    public static final int POSICIONYP2 = 3;
    
    public static final int POSICIONXP3 = 165;
    public static final int POSICIONYP3 = 3;
    
    public Porteria(Nivel1 juego){
        this.juego = juego;
    }
    
    public void visualizarPorteria(Graphics2D g){
        g.fill3DRect(POSICIONXP, POSICIONYP, 8, 40, true);
        g.fill3DRect(POSICIONXP2, POSICIONYP2, 8, 40, true);
        g.fill3DRect(POSICIONXP3, POSICIONYP3, 85, 5, true);
    }
    
     public Rectangle obtenerLimites(){
         return new Rectangle(POSICIONXP3, POSICIONYP3, 85, 5);
    } 
    public int obtenerAlturaPorteria(){
       return POSICIONYP3;
   }
}
