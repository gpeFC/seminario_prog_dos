import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfazControlColores extends JFrame{

	private JSlider rangoColorJS;

	private AreaJPanel areaDibujo;

	public InterfazControlColores(){

		areaDibujo = new AreaJPanel();

		add(areaDibujo);

	}

	private class AreaJPanel extends JPanel{
		public void paintComponent(Graphics areaDibujo){
			super.paintComponent(areaDibujo);
			
			// establece nuevo color de dibujo, usando valores enteros
			areaDibujo.setColor( new Color( 255, 0, 0 ) );
			areaDibujo.fillRect( 500, 25, 25, 20 );
			areaDibujo.drawString( "RGB actual: " + areaDibujo.getColor(), 130, 40 );
			
			// establece nuevo color de dibujo, usando valores de punto flotante
			areaDibujo.setColor( new Color( 0.50f, 0.75f, 0.0f ) );
			areaDibujo.fillRect( 500, 50, 25, 20 );
			areaDibujo.drawString( "RGB actual: " + areaDibujo.getColor(), 130, 65 );
			
			// establece nuevo color de dibujo, usando objetos Color static
			areaDibujo.setColor( Color.BLUE );
			areaDibujo.fillRect( 500, 75, 25, 20 );
			areaDibujo.drawString( "RGB actual: " + areaDibujo.getColor(), 130, 90 );
			
			// muestra los valores RGB individuales
			Color color = Color.MAGENTA;
			areaDibujo.setColor( color );
			areaDibujo.fillRect( 500, 100, 25, 20 );
			areaDibujo.drawString( "Valores RGB: " + color.getRed() + ", " +
			color.getGreen() + ", " + color.getBlue(), 130, 115 );
		}
	}
}