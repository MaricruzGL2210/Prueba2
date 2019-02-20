package juego;

import bolas_locas.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import juego_prueba.PanelLoco;

/**
 *
 * @author Maricruz GL
 */
public class Nivel1 extends JPanel{
    private Lienzo lienzo;
   // private Pelota pelota;
    
    List<Pelota> pelotas = new ArrayList<>();
    private Raqueta raqueta;
    private Triangulo triangulo;
    private Porteria porteria;
    private Cuadrado cuadrado;
    JPanel p;
    
    public Nivel1(int nivel) {
        p = new JPanel();
        
        if (nivel == 1) {
            System.out.println("NIvel 1");
       this.pelotas.add(new Pelota(this));
       raqueta = new Raqueta(this);
       triangulo = new Triangulo(this);
        porteria = new Porteria(this);
        cuadrado = new Cuadrado(this);
        
            addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {
                  
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                        try {
                        Thread.sleep(1000);
                        iniciar(Nivel1.this);
                        System.out.println("Holas");
                        }catch(Exception ex){
                            
                        }
                    }
                    raqueta.keyPressed(e);
                }

                @Override
                public void keyReleased(KeyEvent e) {
                   raqueta.keyReleased(e);
                }
            });
            
            setFocusable(true);
        }
    }
   /* public Juego(){
        lienzo = new Lienzo(this);
       this.pelotas.add(new Pelota(this));
       raqueta = new Raqueta(this);
       triangulo = new Triangulo(this);
        porteria = new Porteria(this);
        cuadrado = new Cuadrado(this);
        
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        
        
    }*/
    
    public void moverPelota(){
        for(int i = 0; i < pelotas.size();i++){
            pelotas.get(i).mover();
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
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Nivel1 juego = new Nivel1(1);
        frame.add(juego);
        frame.setVisible(true);
        frame.setSize(400,500);
        boolean b = true;
        int c = 0;
        while (b) {
                    try {
                        juego.moverPelota();
                        juego.moverRaqueta();
                        juego.repaint();
                        Thread.sleep(10);
                        c++;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Nivel1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (c > 30) {
                        b = false;
                    }
                }
         int s = 0;
        if (b == false) {
           s = JOptionPane.showConfirmDialog(null, "Avanzar", "Avanzar,", JOptionPane.YES_NO_OPTION);
        }   
        if (s == JOptionPane.YES_OPTION) {
            
            JFrame frame2= new JFrame(); 
            Nivel1 juego1 = new Nivel1(1);
            frame2.setSize(400,500);
            frame2.setVisible(true);
            //frame2.remove(juego);
            frame2.add(juego1);            
            while (true) {
                    try {
                        juego1.moverPelota();
                        juego1.moverRaqueta();
                        juego1.repaint();
                        Thread.sleep(10);
                        c++;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Nivel1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (c > 1000) {
                        b = false;
                    }
                }
        }
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
           for(Pelota p :pelotas){
               p.vizualizar(g2d);
           }
    }
    
    public void iniciar(Nivel1 juego){
       /* while (true) {
                    try {
                        juego.moverPelota();
                        juego.moverRaqueta();
                        juego.repaint();
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }*/
    }
}
