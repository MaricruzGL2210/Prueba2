package juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * La clase Barra
 * Se crea un las porpiedades que se usaran para la barra 
 * 
 * @author Ahernandez / Mgonzalez
 *
 */
public class Barra extends NivelCast{

    //Se declara constantes para propiedades de la barra
    private static final int ALTO = 10;
    private static final int ANCHO = 110;
    
    //Constantese para la posicion de las barras
    private static final int X_B1 = 0;
    private static final int X_B2 = 160;
    private static final int X_B3 = 330;
    private static final int Y_B = 25;
    
    Object juego;
    
    //metodo que recibe el objeto de juego y el nivel de jueho 
    public Barra(Object juego, int nivel){
        //inicializador de juego y nivel
        inicializador(juego, nivel);
    }
    
    //metodo que obtiene las propiedades de la barra
    public int obtenerAltura(){
       return Y_B + ALTO + 15;
   }
    
    //metodos que obtienen los limites de las barras que se integran en el juego
    public Rectangle obtenerLimiteBarra1(){
         return new Rectangle(X_B1, Y_B, ANCHO, ALTO);
    }
    public Rectangle obtenerLimiteBarra2(){
         return new Rectangle(X_B2, Y_B, ANCHO, ALTO);
    }
    public Rectangle obtenerLimiteBarra3(){
         return new Rectangle(X_B3, Y_B, ANCHO, ALTO);
    }
    
    //metodo que hace que se muestren las barras
    public void visualizarBarra(Graphics2D g2d){
        g2d.fillRect(X_B1, Y_B, ANCHO, ALTO);
        g2d.fillRect(X_B2, Y_B, ANCHO, ALTO);
        g2d.fillRect(X_B3, Y_B, ANCHO, ALTO);
    }
    
    //metodo abstracto que obtiene el nivel de juego y lo convierte en juego
    @Override
    void inicializador(Object juego, int nivel) {
        //Validador de nivel
        if (nivel == 2) {
            this.juego = (Nivel2)juego;
        }
    }

    //metodo abstracto que obtiene el nivel y lo valida.
    @Override
    void validaNivel(int nivel) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
