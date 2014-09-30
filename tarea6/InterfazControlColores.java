import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfazControlColores extends JFrame{

	private JSlider rangoRojoJS;
	private JSlider rangoVerdeJS;
	private JSlider rangoAzulJS;

	private JPanel panelSliders;
	private JPanel panelCentral;

	private AreaJPanel areaDibujo;

	public InterfazControlColores(){

		rangoRojoJS = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
		rangoRojoJS.setMajorTickSpacing(25);
		rangoRojoJS.setPaintTicks(true);
		rangoVerdeJS = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
		rangoVerdeJS.setMajorTickSpacing(25);
		rangoVerdeJS.setPaintTicks(true);
		rangoAzulJS = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
		rangoAzulJS.setMajorTickSpacing(25);
		rangoAzulJS.setPaintTicks(true);

		panelSliders = new JPanel();
		panelSliders.setLayout(new BorderLayout());
		panelSliders.setPreferredSize(new Dimension(300,200));
		panelSliders.add(rangoRojoJS, BorderLayout.NORTH);
		panelSliders.add(rangoVerdeJS, BorderLayout.CENTER);
		panelSliders.add(rangoAzulJS, BorderLayout.SOUTH);

		panelCentral = new JPanel();
		panelCentral.setPreferredSize(new Dimension(300,400));
		panelCentral.add(panelSliders, BorderLayout.CENTER);

		areaDibujo = new AreaJPanel();
		areaDibujo.setPreferredSize(new Dimension(300,400));

		add(areaDibujo, BorderLayout.EAST);
		add(panelCentral, BorderLayout.WEST);

	}

	private class AreaJPanel extends JPanel{
		public void paintComponent(Graphics areaDibujo){
			super.paintComponent(areaDibujo);
			
			// establece nuevo color de dibujo, usando valores enteros
			areaDibujo.setColor( new Color( 255, 0, 0 ) );
			areaDibujo.fillRect( 0, 25, 25, 20 );
			areaDibujo.drawString( "RGB actual: " + areaDibujo.getColor(), 130, 40 );
			
			// establece nuevo color de dibujo, usando valores de punto flotante
			areaDibujo.setColor( new Color( 0.50f, 0.75f, 0.0f ) );
			areaDibujo.fillRect( 0, 50, 25, 20 );
			areaDibujo.drawString( "RGB actual: " + areaDibujo.getColor(), 130, 65 );
			
			// establece nuevo color de dibujo, usando objetos Color static
			areaDibujo.setColor( Color.BLUE );
			areaDibujo.fillRect( 0, 75, 25, 20 );
			areaDibujo.drawString( "RGB actual: " + areaDibujo.getColor(), 130, 90 );
			
			// muestra los valores RGB individuales
			Color color = Color.MAGENTA;
			areaDibujo.setColor( color );
			areaDibujo.fillRect( 0, 100, 25, 20 );
			areaDibujo.drawString( "Valores RGB: " + color.getRed() + ", " +
			color.getGreen() + ", " + color.getBlue(), 130, 115 );
		}
	}
}