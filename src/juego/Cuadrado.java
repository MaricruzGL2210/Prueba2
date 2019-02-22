package juego;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

/** 
 * 
 * @author Maricruz GL
 */
public class Cuadrado extends NivelCast{
   
    private int posicionX;
    private int posicionY;
    private int movimientoY;
    
    //tamaño de la pelota 
    private static final int tamano_pelota = 25;
    private static final int ALTO = 429;
    private static final int LARGO = 433; 
    
    //lugar utilizado para colocar la pelota, (asociacion de Pelota)
    private Object juego;
    private Rectangle bossAltura;
    Nivel3 nivel3;
    Random ran = new Random();
    float r;
    float t ;
    float b;

    public Cuadrado(Object juego, int nivel) {
        inicializador(juego, nivel);
        validaNivel(nivel);
        bossAltura = nivel3.boss.obtenerLimite();
        movimientoY = 40;
        posicionY = (int) bossAltura.getHeight();
        posicionX  = (int) bossAltura.getBounds().x;
        
        r = ran.nextFloat();
        t = ran.nextFloat();
        b = ran.nextFloat();
            
    }

    @Override
    void inicializador(Object juego, int nivel) {
        if (nivel == 3) {
            this.juego = (Nivel3)juego;
        }
    }

    @Override
    void validaNivel(int nivel) {
        if (nivel == 3) {
            nivel3 = (Nivel3) juego;
        }
    }
    /**
     * Permite mover la pelota y rebotar en las paredes 
     */
    public void moverCuadrado(){
        Random ran = new Random();
        int rap = ran.nextInt(10);
        int acum;
        if (rap == 10 || rap == 5){
            acum = ran.nextInt(10);
            if (acum == 1) {
                posicionY++;
            }
            if (acum == 2) {
                posicionY += 2;
            }
            if (acum == 3) {
                posicionY += 3;
            }
            if (acum == 4) {
                posicionY += 4;
            }
            if (acum == 5) {
                posicionY += 4;
            }
            if (acum == 6) {
                posicionY += 3;
            }
            if (acum == 7) {
                posicionY ++;
            }
            if (acum == 8) {
                posicionY ++;
            }
            if (acum == 9) {
                posicionY ++;
            }
            if (acum == 10) {
                posicionY += 5;
            }
        } else {
            posicionY ++;
        }
         
        if(verificarChoqueRaqueta()){
            posicionY = 500;
            //posicionY = getRaquetaAux().obtenerAlturaRaqueta()-20;
          this.nivel3.boss.vidas --;
        }
    }
    
    /**
     * Vizualiza la cuadrado 
     * @param g objeto grafico 
     */
     public void vizualizarCuadrado(Graphics2D g){
         g.setColor(new Color(ran.nextInt(200), ran.nextInt(200), ran.nextInt(200)));
         g.fillRect(posicionX, posicionY, 20, 20);
        }
     
     public Rectangle obtenerLimitesCuadrado(){
        return new Rectangle(posicionX, posicionY, 20, 20);
    }
     public boolean verificarChoqueRaqueta(){
        return getRaquetaAux().obtenerLimite().intersects(obtenerLimitesCuadrado());
        
    }
}
