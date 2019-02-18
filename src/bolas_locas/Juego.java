package bolas_locas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Maricruz GL
 */
public class Juego extends JPanel{
    
   // private Pelota pelota;
    
    List<Pelota> pelotass = new ArrayList<>();
    private Raqueta raqueta;
    private Triangulo triangulo;
    private Porteria porteria;
    private Cuadrado cuadrado;
    
    
    public Juego(){
       this.pelotass.add(new Pelota(this));
       raqueta = new Raqueta(this);
        addKeyListener(new KeyListener() {

           @Override
           public void keyTyped(KeyEvent e) {
           }

           @Override
           public void keyPressed(KeyEvent e) {
               raqueta.keyProssed(e);
           }

           @Override
           public void keyReleased(KeyEvent e) {
               raqueta.keyReleased(e);
           }
       });
        setFocusable(true); 
        
        triangulo = new Triangulo(this);
        porteria = new Porteria(this);
        cuadrado = new Cuadrado(this);
    }
    
    public void moverPelota(){
        for(int i = 0; i < pelotass.size();i++){
            pelotass.get(i).mover();
        }
            
    }
    
    public void moverCuadrado(){
            
          cuadrado.moverCuadrado();
       
            
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
    
    public Porteria obtenerLimPorteria(){
        return new Porteria(this);
    }
    
    @Override
    public void paint(Graphics g){
           super.paint(g);
           Graphics2D g2d = (Graphics2D) g;
           
           raqueta.visualizarRaqueta(g2d);
           triangulo.visualizaTriangulo(g2d);
           porteria.visualizarPorteria(g2d);
           cuadrado.vizualizarCuadrado(g2d);
           
           g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
           //pelota.vizualizar(g2d); 
           for(Pelota p :pelotass){
               p.vizualizar(g2d);
           }
          
    }
    
    public static void main(String[] args) throws InterruptedException{
        JFrame frame = new JFrame("Pelota En Movimiento");
        
        Juego juego = new Juego();
        
        frame.add(juego);
        frame.setSize(400,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true){
            juego.moverPelota();
            juego.moverRaqueta();
            juego.moverCuadrado();
            juego.moverCuadrado();
            juego.repaint();
            Thread.sleep(10);
        }
    }

   
}
