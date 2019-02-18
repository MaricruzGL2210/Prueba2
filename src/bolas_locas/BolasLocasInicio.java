/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolas_locas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author Alfonso HA
 */
public class BolasLocasInicio extends JFrame{
    private JPanel panelPrincipal;
    private JButton btnInicio;
    private Juego juego;
    public BolasLocasInicio() {
        this.setSize(450,500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("Bolas Locas");
        panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setSize(450,500);
       
        panelPrincipal.setLayout(null);
        btnInicio = new JButton("Comenzar Juego");
        btnInicio.setBounds(30, 20, 200, 35);
        panelPrincipal.add(btnInicio);
        this.add(panelPrincipal);
         
        accionBotones();
        accionTeclas();
        setFocusable(true);
    }
    public BolasLocasInicio(Juego juego) {
        this.juego = juego;
    }
    public void accionBotones() {
        btnInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose();
                JFrame frame = new JFrame("Pelota rebotando");
                juego = new Juego();
                frame.add(juego);
                frame.setSize(300, 400);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(panelPrincipal);
                JLabel prueba = new JLabel("Pulsa Espacio Para Comenzar");
                prueba.setBounds(300,50,10,10);
                juego.add(prueba);
                        
                /*
                */
            }
        });
    }
    
    public void accionTeclas(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    System.out.println("Hola");
                    iniciar();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        setFocusable(true);
    }
    public void iniciar() {
        while (true) {
                    try {
                        juego.moverPelota();
                        juego.moverRaqueta();
                        juego.repaint();
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BolasLocasInicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
    }
}
