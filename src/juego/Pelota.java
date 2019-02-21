package juego;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Maricruz GL
 */
public class Pelota extends NivelCast{
   
    private static final int ALTO = 429;
    private static final int LARGO = 433; 
    private int posicionX;
    private int posicionY;
   
    //controlar la direccion del movimiento 
    private int movimientoX;
    private int movimientoY;
    
    
    int tamano_pelota = 25;
    //tamaño de la pelota 
    //private static final int tamano_pelota = 30;
    
    //lugar utilizado para colocar la pelota, (asociacion de Pelota)
    private Object juego;
    private int nivel;
    
    Random ran = new Random();
            float r;
            float t ;
            float b;

            Nivel1 nivel1;
            Nivel2 nivel2;
            Nivel3 nivel3;
            
    public Pelota(Object juego, int nivel) {
        inicializador(juego, nivel);
        this.juego = juego;
        movimientoX = 1;
        movimientoY = 1;
        posicionX = new Random().nextInt(300);
        posicionY = new Random().nextInt(200);
        
        r = ran.nextFloat();
        t = ran.nextFloat();
        b = ran.nextFloat();
        this.nivel = nivel;
        
        validaNivel(nivel);
          
        
    }
    
    public Rectangle obtenerLimitesPelota(){
        return new Rectangle(posicionX, posicionY, tamano_pelota, tamano_pelota);
    }
    
    
    public boolean verificarChoqueRaqueta(){
        //verificar una interseccion entra una pelota y una raqueta
        return getRaquetaAux().obtenerLimite().intersects(obtenerLimitesPelota());
        
    }
    public boolean verificarChoqueBarra1(){
        return nivel2.barras.obtenerLimiteBarra1().intersects(obtenerLimitesPelota());
    }
    public boolean verificarChoqueBarra2(){
        return nivel2.barras.obtenerLimiteBarra2().intersects(obtenerLimitesPelota());
    }
    public boolean verificarChoqueBarra3(){
        return nivel2.barras.obtenerLimiteBarra3().intersects(obtenerLimitesPelota());
    }
    public boolean verificarChoquePorteria() {
        return nivel1.porteria.obtenerLimites().intersects(nivel1.porteria.POSICIONXP3, nivel1.porteria.POSICIONYP3, 85, 5);
    }
    public boolean verificarChoqueBloque1() {
        return nivel2.bloque.obtenerLimiteBloque1().intersects(obtenerLimitesPelota());
    }
    public boolean verificarChoqueBloque2() {
        return nivel2.bloque.obtenerLimiteBloque2().intersects(obtenerLimitesPelota());
    }
    /**
     * Permite mover la pelota y rebotar en las paredes 
     */
    public void mover(){
        if(posicionX + movimientoX < 0 ){
            movimientoX = 1;
            
        }
        //se va a la izquierda
        if(posicionX + movimientoX > LARGO - tamano_pelota){
            movimientoX = -1;
            //this.juego.pelotass.add(new Pelota(juego));
        }
        
        if(posicionY + movimientoY < 0 ){
            movimientoY = 1;
             //this.juego.pelotas.add(new Pelota(juego));
        }
        //se va a la derecha
        if(posicionY + movimientoY > ALTO - tamano_pelota){
            movimientoY = -1;
          //   this.juego.pelotas.add(new Pelota(juego));

 
        }
        if(verificarChoqueRaqueta()){
            movimientoY += -3;
            posicionY = getRaquetaAux().obtenerAlturaRaqueta()-tamano_pelota;
          
        }
//        System.out.println("ALtura Por -->" + (n1.porteria.obtenerAlturaPorteria()));
        
        if (nivel == 1){
            if (verificarChoquePorteria()) {
            movimientoY += -2;
            posicionY = nivel1.porteria.obtenerAlturaPorteria() - tamano_pelota;
        }
        }
        if (nivel == 2) {
            if (verificarChoqueBarra1()) {
                movimientoY += 1;
                posicionY = nivel2.barras.obtenerAltura() - tamano_pelota;
            }
            if (verificarChoqueBarra2()) {
                movimientoY += 1;
                posicionY = nivel2.barras.obtenerAltura() - tamano_pelota;
            }
            if (verificarChoqueBarra3()) {
                movimientoY += 1;
                posicionY = nivel2.barras.obtenerAltura() - tamano_pelota;
            }
            if (verificarChoqueBloque1()) {
                movimientoX += 2;
                posicionX += nivel2.bloque.obtenerAltura() - tamano_pelota;
                Pelota p = new Pelota(nivel2, 2);
                p.setRaquetaAux(this.nivel2.raqueta);
                this.nivel2.pelotas.add(p);
            }
            if (verificarChoqueBloque2()) {
                movimientoX += 2;
                posicionX += nivel2.bloque.obtenerAltura() - tamano_pelota;
            }
        }
        posicionX += movimientoX;
        posicionY += movimientoY;
    }
    
    /**
     * Vizualiza la pelota 
     * @param g objeto grafico 
     */
     public void vizualizar(Graphics2D g){
            g.fillOval(posicionX, posicionY, tamano_pelota, tamano_pelota);
            g.setColor(new Color(r, t, b));
        }
    @Override
    public void inicializador(Object juego, int nivel) {
        if (nivel == 1) {
            this.juego = (Nivel1)juego;
        }
        if (nivel == 2) {
            this.juego = (Nivel2)juego;
        }
        if (nivel == 3) {
            this.juego = (Nivel3)juego;
        }
    }

    @Override
    void validaNivel(int nivel) {
        if (nivel == 1) {
            nivel1 = (Nivel1) juego;
        }
        if (nivel == 2) {
            nivel2 = (Nivel2) juego;
        }
        if (nivel == 3) {
            nivel3 = (Nivel3) juego;
        }
    }
    
}
