/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import bolas_locas.*;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Maricruz GL
 */
public class Porteria {

    private Juego juego;
    
    private int posicionxP;
    
    private int posicionyP;
    
     private int posicionxP2;
    
    private int posicionyP2;
    
    private int posicionxP3;
    
    private int posicionyP3;
    
    public Porteria(Juego juego){
        this.juego = juego;
        
        this.posicionxP = 150;
        this.posicionyP = 8;
        
        this.posicionxP2 = 240;
        this.posicionyP2 = 8;

        this.posicionxP3 = 155;
        this.posicionyP3 = 8;
        
    }
    
    public void visualizarPorteria(Graphics2D g){
        g.fill3DRect(posicionxP, posicionyP, 5, 30, true);
        
        g.fill3DRect(posicionxP2, posicionyP2, 5, 30, true);
        
        g.fill3DRect(posicionxP3, posicionyP3, 85, 2, true);
    }
    
     public Porteria limitesPorteria(Graphics2D g){
        return new Porteria(juego);
    }
    
}
