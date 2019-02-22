/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vectormx
 */
public class Boss extends NivelCast implements Runnable{
    private static final int ANCHO = 65;
    private static final int ALTO = 0;
    private static final int LARGO = 395; 
    private int posicionX;
    private int movimientoX;
    Object juego;
    int nivel;
    Nivel3 nivel3;

    Cuadrado cuadrado;
    
    public int vidas;
    
    public Boss(Object juego, int nivel) {
        inicializador(juego, nivel);
        validaNivel(nivel);
        posicionX = 0;
        movimientoX = 1;
        vidas = 10;
    }
    public void visualizarBoss(Graphics2D g2d) {
        g2d.fillRoundRect(posicionX, ALTO, ANCHO, 40, 30, 20);
    }
    public int obtenerAltura(){
       return ALTO + 40;
   }
    public Rectangle obtenerLimite(){
         return new Rectangle(posicionX, ALTO, ANCHO, 40);
    }
    public void mover(){
        Random ran = new Random();
        int box = ran.nextInt(100);
        if(posicionX + movimientoX < 0 ){
            movimientoX = 1;
            
        }
        if(posicionX + movimientoX > LARGO - 25){
            movimientoX = -1;
        }
        posicionX += movimientoX;
        posicionX += movimientoX;
        if (box == 3){
            cuadrado = new Cuadrado(nivel3, 3);
            cuadrado.setRaquetaAux(nivel3.raqueta);
            this.nivel3.cuadrados.add(cuadrado);
        }
         
    }  
    
    @Override
    void inicializador(Object juego, int nivel) {
        if (nivel == 3) {
            this.juego = (Nivel3)juego;
        }
    }

    @Override
    void validaNivel(int nivel) {
        if (nivel == 3) {
            nivel3 = (Nivel3) juego;
        }
    }

    @Override
    public void run() {
        this.nivel3.cuadrados.add(new Cuadrado(nivel3, 3));
    }
}
