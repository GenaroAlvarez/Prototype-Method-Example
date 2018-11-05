/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Genaro Mauricio
 */
public class Rectangulo extends Forma {

    private int ancho;
    private int alto;

    public static final int ALTO = 100;
    public static final int ANCHO = 200;

    /* Contructor */
    public Rectangulo(Color clr, int x, int y) {
        super(clr, x, y);
        ancho = ANCHO;
        alto = ALTO;
    }

    /* Getters y setters */
    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    /* Overridables */
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getAncho(), getAlto());
    }

    @Override
    public Object clone() {
        return new Rectangulo(getColor(), getX(), getY());
    }

}
