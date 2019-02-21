package juego;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/** 
 *
 * @author Maricruz GL 
 */
public class Nivel3 extends JPanel implements Runnable{ 
     
    Pelota pelota;
    Raqueta raqueta;
    Bloque bloque;
    Boss boss;
    List<Cuadrado> cuadrados = new ArrayList<>();
    List<Especial> balas = new ArrayList<>();
  
    public Nivel3() {
        pelota = new Pelota(this, 3);
        raqueta = new Raqueta(this, 3); 
        pelota.setRaquetaAux(raqueta);
        bloque = new Bloque(this, 3); 
        boss = new Boss(this, 3); 
        cuadrados.add(new Cuadrado(this, 3)); 
        balas.add(new Especial(this));
         
            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                  
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        moverEspecial(); 
        } else {
                    raqueta.keyPressed(e);
                    }  
                }  
 
                @Override
                public void keyReleased(KeyEvent e) {
                   raqueta.keyReleased(e);
                }
            });
              
            setFocusable(true);
        
    }
    
    public void moverPelota(){
        pelota.mover();
    }
    
    
    public void moverRaqueta(){
         raqueta.mover();
    }
      
    public Raqueta getRaqueta() {  
        return raqueta;
    }
 
    public void setRaqueta(Raqueta raqueta) {
        this.raqueta = raqueta; 
    }
    public void moverBloque() {  
        bloque.mover();  
    }   
     
    public void moverBoss(){ 
        boss.mover(); 
     }  
    @Override
    public void paint(Graphics g){
           super.paint(g);
           Graphics2D g2d = (Graphics2D) g;
           g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
           raqueta.visualizarRaqueta(g2d);
           pelota.vizualizar(g2d); 
           bloque.visualizarBloque(g2d);
           boss.visualizarBoss(g2d);
           for (Cuadrado c : cuadrados){
               c.vizualizarCuadrado(g2d);
           }
           for (Especial es : balas) {
               es.vizualizarEspecial(g2d);
           }
           
    }  

    public void moverCuadrado() {
        for (Cuadrado c : cuadrados) {
            c.moverCuadrado(); 
        }
    }   

    public void moverEspecial() {
        for (Especial es : balas) {
            es.lanzarEspecial();
        }
    }  
     
    @Override 
    public void run() {
        
    }
  
}
