/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author Maricruz GL
 */
public class Raqueta extends NivelCast{
    
    private static final int ALTO = 429;
    private static final int LARGO = 433; 
    
    private Object juego;
    
    private int posicionx;
    
    private int movimientox;
    
    private static final int Y = 405;
    private static final int WITH = 90;
    private static final int HEIGTH = 15;
    Nivel1 nivel1;
    Nivel2 nivel2;
    Nivel3 nivel3;
    

    
    public Raqueta(Object juego, int nivel){
        inicializador(juego, nivel);
        validaNivel(nivel);
        this.movimientox = 0;
        this.posicionx = 0;                
        
    }
    
    
    public void mover(){
        if(posicionx + movimientox > 0 && posicionx + movimientox < LARGO - WITH ){
            posicionx = posicionx +movimientox;
        }
        
    } 
    
    public void keyReleased(KeyEvent e){
        //
        movimientox = 0;
    }
    
    public void keyPressed(KeyEvent e){
        //verifica el codigo de la tecla
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            movimientox = -2;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            movimientox = 2;
        }
        
        e.setKeyCode(posicionx);
    }
     
     
    public void visualizarRaqueta(Graphics2D g2dr){
        g2dr.fillRect(posicionx, Y, WITH, HEIGTH);
        
    }
    
   public Rectangle obtenerLimite(){
         return new Rectangle(posicionx, Y, WITH, HEIGTH);
    }
   
   public int obtenerAlturaRaqueta(){
       return Y - HEIGTH;
   }

    @Override
    public void inicializador(Object juego, int nivel) {
        if (nivel == 1) {
            this.juego = (Nivel1)juego;
        }
        if (nivel == 2) {
            this.juego = (Nivel2)juego;
        }
        if (nivel == 3) {
           this.juego = (Nivel3)juego;
        }
    }

    @Override
    void validaNivel(int nivel) {
        if (nivel == 1) {
            nivel1 = (Nivel1) juego;
        }
        if (nivel == 2) {
            nivel2 = (Nivel2) juego;
        }
        if (nivel == 3) {
            nivel3 = (Nivel3) juego;
        }
    }
  
    
    
}
