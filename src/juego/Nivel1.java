/**
 * Bolas Locas Todos los derechos reservados
 *
 * Clase: Nivel1
 *
 * Control de versiones: Versión 07/02/2019 -13:00pm 
 * ------- ----------- ----------- ---------- ---------------------- 
 * 1.0 07/02/2019 - 13:00pm
 * Alfonso Hernández Anaya – Maricruz Gonzalez Ledesma
 */
package juego;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * Clase Nivel1
 * Esta clase contiene un panel donde se integran todos lo componentes 
 * necesarios para ejecutar el primer nivel
 * 
 * @author Alfonso Hernández Anaya – Maricruz Gonzalez Ledesma
 */
public class Nivel1 extends JPanel {

    //Variable de tipo pelota
    public Pelota pelota;
    //Variable de tipo raqueta
    public Raqueta raqueta;
    //Variable de tipo porteria
    public Porteria porteria;

    
    
    //Constructor de la clase
    public Nivel1() {
        //Inicializacion de variables 
        this.pelota = new Pelota(this, 1);
        this.raqueta = new Raqueta(this, 1);
        this.porteria = new Porteria(this);
        
        this.pelota.setRaquetaAux(raqueta);
        
        //Recibe todos los eventos del teclado, es deir, si se pulsa una tecla este nos indica cual fue
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            
            //Metodo que se ejecuta cuada vez que presionas unta tecla
            @Override
            public void keyPressed(KeyEvent e) {
                raqueta.keyPressed(e);
            }

            //Metodo que se ejecuta después de qye se deja de presionar la tecla
            @Override
            public void keyReleased(KeyEvent e) {
                raqueta.keyReleased(e);
            }
        });
        //Instruccioin que notifica las acciones del teclado al panel 
        setFocusable(true);

    }

    //metodo que mueve la peloca
    public void moverPelota() {
        pelota.mover();
    }

    //Metodo que mueve la raqueda del usuario  
    public void moverRaqueta() {
        raqueta.mover();
    }
    
    
    //Metodos de acceso a la clase de Raqueta
    public Raqueta getRaqueta() {
        return raqueta;
    }

    public void setRaqueta(Raqueta raqueta) {
        this.raqueta = raqueta;
    }

    
    //Metodo paint, permite dibujar en pantalla
    @Override
    public void paint(Graphics g) {
        //Llama el super constructor de la super clase
        super.paint(g);
        //Instancia de la libreria Graphics2D
        Graphics2D g2d = (Graphics2D) g;
        //Permite pintar las figuras con relleno
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Trae los metodos para visualizar en pantalla cada elemento
        raqueta.visualizarRaqueta(g2d);
        porteria.visualizarPorteria(g2d);
        pelota.vizualizar(g2d);

    }
}
