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
public class Circulo extends Forma {

    private int radio;
    public static final int RADIO = 100;

    /* Constructor */
    public Circulo(Color clr, int x, int y) {
        super(clr, x, y);
        radio = RADIO;
    }

    /* Getters y setters */
    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    /* Overridables */
    @Override
    void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getRadio(), getRadio());
    }

    @Override
    public Object clone() {
        return new Circulo(getColor(), getX(), getY());
    }

}
