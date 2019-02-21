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
 * @author vectormx
 */
public class Barra extends NivelCast{

    private static final int ALTO = 10;
    private static final int ANCHO = 110;
    private static final int X_B1 = 0;
    private static final int X_B2 = 160;
    private static final int X_B3 = 330;
    private static final int Y_B = 25;
    
    Object juego; 
    public Barra(Object juego, int nivel){
        inicializador(juego, nivel);
    }
    
    public int obtenerAltura(){
       return Y_B + ALTO + 15;
   }
    public Rectangle obtenerLimiteBarra1(){
         return new Rectangle(X_B1, Y_B, ANCHO, ALTO);
    }
    public Rectangle obtenerLimiteBarra2(){
         return new Rectangle(X_B2, Y_B, ANCHO, ALTO);
    }
    public Rectangle obtenerLimiteBarra3(){
         return new Rectangle(X_B3, Y_B, ANCHO, ALTO);
    }
    public void visualizarBarra(Graphics2D g2d){
        g2d.fillRect(X_B1, Y_B, ANCHO, ALTO);
        g2d.fillRect(X_B2, Y_B, ANCHO, ALTO);
        g2d.fillRect(X_B3, Y_B, ANCHO, ALTO);
    }
    @Override
    void inicializador(Object juego, int nivel) {
        if (nivel == 2) {
            this.juego = (Nivel2)juego;
        }
    }

    @Override
    void validaNivel(int nivel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
