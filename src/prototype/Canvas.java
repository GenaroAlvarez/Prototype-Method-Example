/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype;

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Genaro Mauricio
 */
public class Canvas extends JPanel implements MouseListener {

    /**
     * La clase Canvas actúa como el "Cliente" o "Client". Dentro del método
     * "mouseClicked" existe método "operacion" que exige el
     * patrón de diseño, ya que éste incluye la llamada a la función para
     * clonar.
     */
    private final LinkedList<Forma> lista = new LinkedList<>();
    private boolean isSelected = false;
    private Forma selected = null;
    private int auxX = 0;
    private int auxY = 0;

    public static final Color COLORES[] = {
        Color.BLACK, new Color(0, 83, 153), new Color(142, 216, 248),
        Color.YELLOW, Color.WHITE, Color.GREEN,
        Color.ORANGE, Color.RED};

    public static final String OPCIONES[] = {
        "Negro", "Azul", "Celeste",
        "Amarillo", "Blanco", "Verde",
        "Naranja", "Rojo"
    };

    /* Constructor */
    public Canvas() {
        addMouseListener(this);
    }

    /* Métodos auxiliares */
    private void showElements() {
        System.out.println("|| ======================================================||");
        lista.forEach((forma) -> {
            System.out.println("Forma: " + forma.getClass().getName() + " => ID: " + forma.hashCode() + " => COLOR: " + getColorName(forma.getColor()));
        });
    }

    private Forma isOnForma(int x, int y) {
        for (Forma forma : lista) {
            if ((forma.getX() < x) && (x < forma.getX() + Rectangulo.ANCHO) && (forma.getY() < y) && (y < forma.getY() + Rectangulo.ALTO)) {
                return forma;
            }
        }
        return null;
    }

    private String getColorName(Color color) {
        for (int i = 0; i < COLORES.length; i++) {
            if (COLORES[i] == color) {
                return OPCIONES[i];
            }
        }
        return "";
    }

    private void operacion(Forma aux) {
        Forma nuevo = (Forma) aux.clone();
        lista.add(nuevo);
        javax.swing.JOptionPane.showMessageDialog(this, "¡Forma clonada!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    /* Overrideables */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        lista.forEach((forma) -> {
            forma.draw(g);
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Forma aux = isOnForma(e.getX(), e.getY());
        if (aux != null) {
            switch (e.getButton()) {
                /* Editar el color */
                case 1:
                    String ok[] = {"Aceptar"};
                    JComboBox<String> jc = new JComboBox<>(OPCIONES);
                    int o = JOptionPane.showOptionDialog(this, jc, "Editar color", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, ok, ok[0]);
                    aux.setColor(COLORES[jc.getSelectedIndex()]);
                    break;

                /* Clonar la forma */
                case 3:
                    operacion(aux);
                    break;
            }
            showElements();
        } else {
            /* Crea una nueva forma */
            if (e.getButton() == 1) {
                lista.add(new Rectangulo(Color.RED, e.getX(), e.getY()));
            } else if (e.getButton() == 3) {
                lista.add(new Circulo(Color.RED, e.getX(), e.getY()));
            }
            showElements();
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Forma aux = isOnForma(e.getX(), e.getY());
        if (aux != null) {
            isSelected = true;
            selected = aux;
            auxX = e.getX() - aux.getX();
            auxY = e.getY() - aux.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (isSelected) {
            selected.setX(e.getX() - auxX);
            selected.setY(e.getY() - auxY);
            selected = null;
            isSelected = false;
            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
