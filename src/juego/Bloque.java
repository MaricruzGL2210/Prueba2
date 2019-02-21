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
public class Bloque extends NivelCast{
    private static final int ALTO = 30;
    private static final int ANCHO = 70;
    private int movimientoX1;
    private int posicionY1;
    private int posicionY2;
    private int posicionX1;
    private int movimientoX2;
    private int posicionX2;
    private static final int LARGO = 395; 
    Object juego;
    
    public Bloque(Object juego, int nivel){
        inicializador(juego, nivel);
        this.movimientoX1 = 1;
        this.movimientoX2 = 1;
        this.posicionX1 = 50;
        this.posicionX2 = 270;
        this.posicionY1 = 180;
        this.posicionY2 = 250;
    }
     public void mover(){
        if(posicionX1 + movimientoX1 < 0 ){
            movimientoX1 = 2;
            //this.juego.pelotass.add(new Pelota(juego));
        }
        if(posicionX2 + movimientoX2 < 0 ){
            movimientoX2 = 3;
            //this.juego.pelotass.add(new Pelota(juego));
        }
        if(posicionX1 + movimientoX1 > LARGO - 25){
            movimientoX1 = -3;
            //this.juego.pelotass.add(new Pelota(juego));
        }
        if(posicionX2 + movimientoX2 > LARGO - 25){
            movimientoX2 = -2;
            //this.juego.pelotass.add(new Pelota(juego));
        }
        posicionX1 += movimientoX1;
        posicionX2 += movimientoX2;
    } 
     
     public int obtenerAltura(){
       return ALTO;
   }
     public Rectangle obtenerLimiteBloque1(){
         return new Rectangle(posicionX1, posicionY2, ANCHO, ALTO);
    }
     public Rectangle obtenerLimiteBloque2(){
         return new Rectangle(posicionX2, posicionY2, ANCHO, ALTO);
    }
     public void visualizarBloque(Graphics2D g2d){
        g2d.fillRect(posicionX1, posicionY1, ANCHO, ALTO);
        g2d.fillRect(posicionX2, posicionY2, ANCHO, ALTO);
    }

    @Override
    void inicializador(Object juego, int nivel) {
        
        if (nivel == 2) {
            this.juego = (Nivel2)juego;
        }
        if (nivel == 3) {
            this.juego = (Nivel3)juego;
        }
    }

    @Override
    void validaNivel(int nivel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
