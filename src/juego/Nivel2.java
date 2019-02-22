package juego;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
  
/** 
 *  
 * @author Maricruz GL
 */ 
public class Nivel2 extends JPanel implements Runnable{ 
      
    List<Pelota> pelotas = new ArrayList<>();
    Raqueta raqueta;
    Bloque bloque;
    Barra barras;  
    Pelota p;
    int contadorLista = 0;
    Thread h = new Thread(this); 
    
    public Nivel2() {  
        h.start();     
        barras = new Barra(this, 2); 
        raqueta = new Raqueta(this, 2);  
       for (int i = 0; i < 10; i++) {
           p = new Pelota(this, 2);     
        p.setRaquetaAux(raqueta); 
        this.pelotas.add(p);  
       }
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
        for (Pelota p : pelotas) {
                p.mover();
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
           if (!pelotas.isEmpty()){
           for (Pelota p : pelotas) {
               p.vizualizar(g2d); 
           }
           }   
           p.vizualizar(g2d);
           bloque.visualizarBloque(g2d);
           barras.visualizarBarra(g2d); 
    } 

    @Override
    public void run() {
        while (true) {
                    try { 
                        this.moverPelota();
                        this.repaint();
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Nivel1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } 
    }
}
 