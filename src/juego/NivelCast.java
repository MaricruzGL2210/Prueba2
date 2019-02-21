/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

/**
 *
 * @author vectormx
 */
public abstract class NivelCast {
    private Raqueta raquetaAux;
    
    abstract void inicializador(Object juego, int nivel);
    abstract void validaNivel(int nivel);
    
    public Raqueta getRaquetaAux() {
        return raquetaAux;
    }

    public void setRaquetaAux(Raqueta raquetaAux) {
        this.raquetaAux = raquetaAux;
    }
    
}
