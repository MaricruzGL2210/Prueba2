/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it45;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author Maricruz GL
 */
public class Raqueta {
    
    private Juego juego ;
    
    private int posicionx;
    
    private int movimientox;
    
    private static final int Y = 330;
    private static final int WITH = 60;
    private static final int HEIGTH = 10;
    

    
    public Raqueta(Juego juego){
        this.juego = juego;
        
        this.movimientox = 0;
        this.posicionx = 0;                
        
    }
    
    
    public void mover(){
        if(posicionx + movimientox > 0 && posicionx + movimientox < juego.getWidth()-WITH ){
            posicionx = posicionx +movimientox;
        }
        
    }
    
    public void keyReleased(KeyEvent e){
        //
        movimientox = 0;
    }
    
    public void keyProssed(KeyEvent e){
        //verifica el codigo de la tecla
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            movimientox = -1;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            movimientox = 1;
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
  
    
    
}
