package it45;


import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

/** HOla
 * 
 * @author Maricruz GL
 */
public class Cuadrado {
   
    private int posicionX;
    private int posicionY;
   
    //controlar la direccion del movimiento 
    private int movimientoX;
    private int movimientoY;
    
    //tamaño de la pelota 
    private static final int tamano_pelota = 30;
    
    //lugar utilizado para colocar la pelota, (asociacion de Pelota)
    private Juego juego;
    
    Random ran = new Random();
            float r;
            float t ;
            float b;

    public Cuadrado(Juego juego) {
        this.juego = juego;
        
        movimientoX = 1;
        movimientoY = 1;
        posicionX = new Random().nextInt(200);
        posicionY = new Random().nextInt(100);
        
        r = ran.nextFloat();
        t = ran.nextFloat();
        b = ran.nextFloat();
            
    }
    
    /**
     * Permite mover la pelota y rebotar en las paredes 
     */
    public void moverCuadrado(){
        if(posicionX + movimientoX < 0 ){
            movimientoX = 1;
            //this.juego.pelotass.add(new Pelota(juego));
        }
        //se va a la izquierda
        if(posicionX + movimientoX > juego.getWidth() - tamano_pelota){
            movimientoX = -1;
            //this.juego.pelotass.add(new Pelota(juego));
        }
        
        if(posicionY + movimientoY < 0 ){
            movimientoY = 1;
            // this.juego.pelotass.add(new Pelota(juego));
        }
        //se va a la derecha
        if(posicionY + movimientoY > juego.getHeight() - tamano_pelota){
            movimientoY = -1;
             
             this.juego.pelotass.add(new Pelota(juego));
        }
       
        
    }
    
    /**
     * Vizualiza la cuadrado 
     * @param g objeto grafico 
     */
     public void vizualizarCuadrado(Graphics2D g){
          
            g.fillRect(posicionX, posicionY, 20, 20);
            g.setColor(new Color(r, t, b));
        }
    
}
