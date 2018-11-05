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
public abstract class Forma implements Cloneable {

    private Color color;
    private int x;
    private int y;

    /* Constructor */
    public Forma(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    } 
    
    /* Getters y setters */
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /* Funciones abstractas */
    public abstract Object clone();

    abstract void draw(Graphics g);

}
