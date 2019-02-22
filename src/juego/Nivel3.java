package juego;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;  
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
    Nivel3 nivel3;
    Boolean estatusBala;
    Boolean isLanzada;  
    Cuadrado cuadrado;
    
    private Contenedor estatus;
  
    public Nivel3() {
        nivel3 = this;
        pelota = new Pelota(this, 3);
        raqueta = new Raqueta(this, 3); 
        pelota.setRaquetaAux(raqueta);
        bloque = new Bloque(this, 3); 
        boss = new Boss(this, 3); 
        cuadrado = new Cuadrado(this, 3);
        cuadrado.setRaquetaAux(raqueta);
        cuadrados.add(cuadrado); 
        estatusBala = false;
        isLanzada = false;
            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                     
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        moverEspecial(); 
                        isLanzada = true;   
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
            
            Thread hilo = new Thread(this);
            hilo.start();
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
        while(true){  
        try {
            Thread.sleep(200);
            validaBala();
        } catch (InterruptedException ex) {
            Logger.getLogger(Nivel3.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    } 
  public void validaBala() throws InterruptedException{
      Thread.sleep(20); 
      Random ran = new Random();
      int timerGenerar = ran.nextInt(35);
      if (balas.isEmpty() && timerGenerar == 10) {
            balas.add(new Especial(this));
            this.repaint();   
            this.estatusBala = true;
            this.isLanzada = false;
        }
  } 

    public Contenedor getEstatus() {
        return estatus;
    }

    public void setEstatus(Contenedor estatus) {
        this.estatus = estatus;
    }
  
  
}
