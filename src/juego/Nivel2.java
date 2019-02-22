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
public class Nivel2 extends JPanel{ 
      
    List<Pelota> pelotas = new ArrayList<>();
    Raqueta raqueta;
    Bloque bloque;
    Barra barras;  
    Pelota p;   
    
    public Nivel2() {  
        p = new Pelota(this, 2);     
        barras = new Barra(this, 2); 
        raqueta = new Raqueta(this, 2);
        p.setRaquetaAux(raqueta);
        this.pelotas.add(p); 
                 
        p = new Pelota(this, 2);    
        p.setRaquetaAux(raqueta); 
        //this.pelotas.add(p);    
        bloque = new Bloque(this, 2);
            addKeyListener(new KeyListener() { 
                @Override  
                public void keyTyped(KeyEvent e) {
                    
                } 
 
                @Override 
                public void keyPressed(KeyEvent e) {
                    raqueta.keyPressed(e);
                }
     
                @Override
                public void keyReleased(KeyEvent e) {
                   raqueta.keyReleased(e);
                }
            });
             
            setFocusable(true);
        
    }
        
    public void moverPelota(){ 
              
        for(int i = 0; i < pelotas.size(); i++) {
            pelotas.get(i).mover();
        }  
    }    
    
    public void moverBloque() {
        bloque.mover(); 
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
  
    @Override
    public void paint(Graphics g){
           super.paint(g);
           Graphics2D g2d = (Graphics2D) g;
           g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
           raqueta.visualizarRaqueta(g2d); 
           for (Pelota p : pelotas) {
               p.vizualizar(g2d); 
           }
           bloque.visualizarBloque(g2d);
           barras.visualizarBarra(g2d);
    } 
}
