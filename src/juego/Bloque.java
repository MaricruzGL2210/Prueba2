package juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * La clase Bloque
 * Extiende de la clase abstracta NivelCast
 * Sirve para dibujar los bloques 
 * 
 * @author Ahernandez / Mgonzalez
 */
public class Bloque extends NivelCast{
    
    //Constantes se utilizan para propiedes de bloque
    private static final int ALTO = 30;
    private static final int ANCHO = 70;
    private static final int LARGO = 395; 
    
    //Variables de movimiento 
    private int movimientoX1;
    private int movimientoX2;
    
    //Variables para posicion 
    private int posicionY1;
    private int posicionY2;
    private int posicionX1;
    private int posicionX2;
    
    //Objeto Juego 
    Object juego;
    
    //constructor con parametros
    public Bloque(Object juego, int nivel){
        
        //inicializacion de variables 
        inicializador(juego, nivel);
        this.movimientoX1 = 1;
        this.movimientoX2 = 1;
        this.posicionX1 = 50;
        this.posicionX2 = 270;
        this.posicionY1 = 180;
        this.posicionY2 = 250;
    }
    
    //metodo que tiene como objetivo mover 
     public void mover(){
        if(posicionX1 + movimientoX1 < 0 ){
            movimientoX1 = 2;
            //this.juego.pelotass.add(new Pelota(juego));
        }
        if(posicionX2 + movimientoX2 < 0 ){
            movimientoX2 = 3;
            //this.juego.pelotass.add(new Pelota(juego));
        }
        if(posicionX1 + movimientoX1 > LARGO - 25){
            movimientoX1 = -3;
            //this.juego.pelotass.add(new Pelota(juego));
        }
        if(posicionX2 + movimientoX2 > LARGO - 25){
            movimientoX2 = -2;
            //this.juego.pelotass.add(new Pelota(juego));
        }
        posicionX1 += movimientoX1;
        posicionX2 += movimientoX2;
    } 
     
     //metodo que obtiene la altura del bloque
     public int obtenerAltura(){
       return ALTO;
   }
     
     //metodo que obtiene los limites del bloque 1
     public Rectangle obtenerLimiteBloque1(){
         //retorna las propiedades dedl bloque
         return new Rectangle(posicionX1, posicionY2, ANCHO, ALTO);
    }
     
     //metodo que obtiene los limites del bloque 2
     public Rectangle obtenerLimiteBloque2(){
         //propiedades del bloque 2
         return new Rectangle(posicionX2, posicionY2, ANCHO, ALTO);
    }
     
     //metodo que realiza la visualizacion de los objetos a través de la libreria Graphics2D
     public void visualizarBloque(Graphics2D g2d){
         //pinta un rectangulo con las propiedades que le pasamos
        g2d.fillRect(posicionX1, posicionY1, ANCHO, ALTO);
        g2d.fillRect(posicionX2, posicionY2, ANCHO, ALTO);
    }

     
     //metodo abstracto 
    @Override
    void inicializador(Object juego, int nivel) {
        
        if (nivel == 2) {
            this.juego = (Nivel2)juego;
        }
        if (nivel == 3) {
            this.juego = (Nivel3)juego;
        }
    }

    @Override
    void validaNivel(int nivel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
