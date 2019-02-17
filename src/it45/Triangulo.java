/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it45;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D; 
import java.awt.event.MouseEvent;

/**
 *
 * @author Maricruz GL
 */
public class Triangulo {
    
     private Juego juego;
     
     public Triangulo(Juego juego){
         this.juego = juego;
        
     }
   
     public void posicionTriangulo(){
         
     }
     
    public void visualizaTriangulo(Graphics2D g){
        g.setColor (Color.GRAY); 
        int [] vx2 = {30, 10, 10};
        int [] vy2 = {70, 100, 50};
        g.fillPolygon (vx2, vy2, 3);
        
        int [] vx3 = {100, 10, 10};
        int [] vy3 = {100, 100, 50};
        g.fillPolygon (vx3, vy3, 3);
    }
          
    
}
