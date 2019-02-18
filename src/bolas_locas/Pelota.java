package bolas_locas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Maricruz GL
 */
public class Pelota {

    private int posicionX;
    private int posicionY;

    //controlar la direccion del movimiento 
    private int movimientoX;
    private int movimientoY;

    int tamano_pelota = (int) (Math.random() * 100);

    //tamaño de la pelota 
    // private static final int tamano_pelota = 30;
    //lugar utilizado para colocar la pelota, (asociacion de Pelota)
    private Juego juego;

    Random ran = new Random();
    float r;
    float t;
    float b;

    public Pelota(Juego juego) {
        this.juego = juego;

        movimientoX = 1;
        movimientoY = 1;
        posicionX = new Random().nextInt(200);
        posicionY = new Random().nextInt(100);

        r = ran.nextFloat();
        t = ran.nextFloat();
        b = ran.nextFloat();

    }

    public Rectangle obtenerLimitesPelota() {
        // tamano = (int) (Math.random()*255);
        return new Rectangle(posicionX, posicionY, tamano_pelota, tamano_pelota);
    }

    public boolean verificarChoqueRaqueta() {
        //verificar una interseccion entra una pelota y una raqueta
        return juego.getRaqueta().obtenerLimite().intersects(obtenerLimitesPelota());
    }

    /**
     * Permite mover la pelota y rebotar en las paredes
     */
    public void mover() {
        if (posicionX + movimientoX < 0) {
            movimientoX = 1;
            //this.juego.pelotass.add(new Pelota(juego));
        }
        //se va a la izquierda
        if (posicionX + movimientoX > juego.getWidth() - tamano_pelota) {
            movimientoX = -1;

            //this.juego.pelotass.add(new Pelota(juego));
        }

        if (posicionY + movimientoY < 0) {
            movimientoY = 1;
             this.juego.pelotas.add(new Pelota(juego));
        }
        //se va a la derecha
        if (posicionY + movimientoY > juego.getHeight() - tamano_pelota) {
            movimientoY = -1;

             
             this.juego.pelotas.add(new Pelota(juego));


        }
        if (verificarChoqueRaqueta()) {
            movimientoY += -3;
            posicionY = juego.getRaqueta().obtenerAlturaRaqueta() - tamano_pelota;

        }

        posicionX += movimientoX;
        posicionY += movimientoY;

    }

    /**
     * Vizualiza la pelota
     *
     * @param g objeto grafico
     */
    public void vizualizar(Graphics2D g) {

        g.fillOval(posicionX, posicionY, tamano_pelota, tamano_pelota);
        g.setColor(new Color(r, t, b));
    }

}
