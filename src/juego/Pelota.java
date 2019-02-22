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
    private boolean estado;
    
    Random ran = new Random();
            float r;
            float t ;
            float b;
            

            Nivel1 nivel1;
            Nivel2 nivel2;
            Nivel3 nivel3;
            
    public Pelota(Object juego, int nivel) {
        inicializador(juego, nivel);
        validaNivel(nivel);
        this.juego = juego;
        movimientoX = 1; 
        movimientoY = 1;
        posicionX = new Random().nextInt(300);
        posicionY = new Random().nextInt((150 - 100) + 1) + 100;
        
        r = ran.nextFloat();
        t = ran.nextFloat();
        b = ran.nextFloat();
        this.nivel = nivel; 
         
        
          
        
    }
    
    public Rectangle obtenerLimitesPelota(){
        return new Rectangle(posicionX, posicionY, tamano_pelota, tamano_pelota);
    }
    
    
    public boolean verificarChoqueRaqueta(){
        //verificar una interseccion entra una pelota y una raqueta
        return getRaquetaAux().obtenerLimite().intersects(obtenerLimitesPelota());
        
    }
    public boolean verificarChoqueBoss(){
        return nivel3.boss.obtenerLimite().intersects(obtenerLimitesPelota());
        
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
        return nivel1.porteria.obtenerLimites().intersects(obtenerLimitesPelota());
    }
    public boolean verificarChoquePorteriaP1() {
        return nivel1.porteria.obtenerLimitesP1().intersects(obtenerLimitesPelota());
    }
    public boolean verificarChoquePorteriaP2() {
        return nivel1.porteria.obtenerLimitesP2().intersects(obtenerLimitesPelota());
    }
    public boolean verificarChoqueBloque1S() {
        estado = Boolean.FALSE;
        if (nivel == 2) {
            estado = nivel2.bloque.obtenerLimiteBloque1S().intersects(obtenerLimitesPelota());
        }
        if (nivel == 3) {
           estado = nivel3.bloque.obtenerLimiteBloque1S().intersects(obtenerLimitesPelota()); 
        }
        return estado;
    }
    public boolean verificarChoquePorteriaP1I() {
        boolean estado = false;
        int pelotaX = obtenerLimitesPelota().x + tamano_pelota;
        int poste1IX = nivel1.porteria.obtenerAnchoPorteriaP1I().x;
        int poste1IY = nivel1.porteria.obtenerAlturaPorteriaP1() + 40;
        int posteY = obtenerLimitesPelota().y + tamano_pelota;
        if (pelotaX == poste1IX && posteY <= poste1IY){
            estado = true; 
        }
        return estado;
    }
    public boolean verificarChoquePorteriaP1D() {
        boolean estado = false;
        int pelotaX = obtenerLimitesPelota().x;
        int poste1IX = nivel1.porteria.obtenerAnchoPorteriaP1I().x + 8;
        int poste1IY = nivel1.porteria.obtenerAlturaPorteriaP1() + 40;
        int posteY = obtenerLimitesPelota().y + tamano_pelota;
        if (pelotaX == poste1IX && posteY <= poste1IY){
            estado = true; 
        }
        return estado;
    }
          public boolean verificarChoquePorteriaP2I() {
        boolean estado = false;
        int pelotaX = obtenerLimitesPelota().x + tamano_pelota;
        int poste1IX = nivel1.porteria.obtenerAnchoPorteriaP2I().x;
        int poste1IY = nivel1.porteria.obtenerAlturaPorteriaP2() + 40;
        int posteY = obtenerLimitesPelota().y + tamano_pelota;
        if (pelotaX == poste1IX && posteY <= poste1IY){
            estado = true; 
        }
        return estado;
    }  
          public boolean verificarChoquePorteriaP2D() {
        boolean estado = false;
        int pelotaX = obtenerLimitesPelota().x;
        int poste1IX = nivel1.porteria.obtenerAnchoPorteriaP2I().x + 8;
        int poste1IY = nivel1.porteria.obtenerAlturaPorteriaP2() + 40;
        int posteY = obtenerLimitesPelota().y;
        if (pelotaX == poste1IX && posteY <= poste1IY){
            estado = true; 
        }
        return estado;
    }  

    public boolean verificarChoqueBloque1I() {
        estado = Boolean.FALSE;
        if (nivel == 2) {
            estado = nivel2.bloque.obtenerLimiteBloque1I().intersects(obtenerLimitesPelota());
        }
        if (nivel == 3) {
            estado = nivel3.bloque.obtenerLimiteBloque1I().intersects(obtenerLimitesPelota());
        }
        return estado;
    }
    public boolean verificarChoqueBloque2S() {
        estado = Boolean.FALSE;
        if (nivel == 2) {
            estado = nivel2.bloque.obtenerLimiteBloque1I().intersects(obtenerLimitesPelota());
        }
        if (nivel == 3) {
            estado = nivel3.bloque.obtenerLimiteBloque1I().intersects(obtenerLimitesPelota());
        }
        return estado;
    }
    public boolean verificarChoqueBloque2I() {
        estado = Boolean.FALSE;
        if (nivel == 2) {
            estado = nivel2.bloque.obtenerLimiteBloque1I().intersects(obtenerLimitesPelota());
        }
        if (nivel == 3) {
            estado = nivel3.bloque.obtenerLimiteBloque1I().intersects(obtenerLimitesPelota());
        }
        return estado;
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
            //nivel2.pelotas.add(new Pelota(juego,2));
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
            movimientoY = 1;
                System.out.println("Gol");
        }
            if (verificarChoquePorteriaP1()) {
                movimientoY = 1;
            }
            if (verificarChoquePorteriaP2()) { 
                movimientoY = 1;
            }
            if (verificarChoquePorteriaP1I()) { 
                movimientoX = -1;
            }
            if (verificarChoquePorteriaP1D()) { 
                movimientoX = 1;
                movimientoY = -1;
            }
            if (verificarChoquePorteriaP2I()) { 
                movimientoX = -1;
                movimientoY = -1;
            }
            if (verificarChoquePorteriaP2D()) { 
                movimientoX = 1;
            }
        }/*
        if (nivel == 2) {
            if (verificarChoqueBarra1()) {
                movimientoY = 1;
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
        }*/
         if (nivel == 2 || nivel == 3) {   
             Pelota pAux;
            if (verificarChoqueBloque1S()) {
                movimientoY = -2;
                if (nivel == 2){
                    pAux = new Pelota(nivel1, 2);
                    pAux.setRaquetaAux(nivel2.raqueta);
                    nivel2.pelotas.add(pAux);
                }
                
            }
            if (verificarChoqueBloque1I()) {
                movimientoY = 1;
                if (nivel == 2){
                    pAux = new Pelota(nivel1, 2);
                    pAux.setRaquetaAux(nivel2.raqueta);
                    nivel2.pelotas.add(pAux);
                }
            }
            if (verificarChoqueBloque2S()) {
                movimientoY = -2;
            }
            if (verificarChoqueBloque2I()) {
                movimientoY = 1;
 
            }  
        }
        if (nivel == 3) {
        if (verificarChoqueBoss()) {
                posicionY += 30;
                movimientoY = 30;
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
