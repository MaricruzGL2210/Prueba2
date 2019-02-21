package juego;
 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel; 

/**
 *
 * @author Maricruz GL
 */  
public class Nivel1 extends JPanel{
    
    Pelota pelota;
    Raqueta raqueta;
    Porteria porteria; 
         
    public Nivel1() {    
        this.pelota = new Pelota(this,1);  
        this.raqueta = new Raqueta(this,1);
        this.porteria = new Porteria(this);
        this.pelota.setRaquetaAux(raqueta);    
         
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
     
    @Override   
    public void paint(Graphics g){
           super.paint(g);
           Graphics2D g2d = (Graphics2D) g;
           g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
             
           raqueta.visualizarRaqueta(g2d);
           porteria.visualizarPorteria(g2d);
           pelota.vizualizar(g2d); 
           
    }
}
 