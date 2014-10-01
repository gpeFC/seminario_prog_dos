import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfazControlColores extends JFrame{

	private JSlider rangoRojoJS;
	private JSlider rangoVerdeJS;
	private JSlider rangoAzulJS;

	private JPanel panelDatos;

	private AreaColoresSliders colorSlider;

	public InterfazControlColores(){

		super("Selector de Color");

		rangoRojoJS = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
		rangoRojoJS.setMajorTickSpacing(25);
		rangoRojoJS.setPaintTicks(true);
		rangoVerdeJS = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
		rangoVerdeJS.setMajorTickSpacing(25);
		rangoVerdeJS.setPaintTicks(true);
		rangoAzulJS = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 0);
		rangoAzulJS.setMajorTickSpacing(25);
		rangoAzulJS.setPaintTicks(true);

		colorSlider = new AreaColoresSliders();
		colorSlider.add(rangoRojoJS);
		colorSlider.add(rangoVerdeJS);
		colorSlider.add(rangoAzulJS);

		panelDatos = new JPanel();
		panelDatos.setBackground(Color.BLACK);
		panelDatos.setPreferredSize(new Dimension(350,50));

		add(colorSlider);
		add(panelDatos, BorderLayout.SOUTH);
	}

	private class AreaColoresSliders extends JPanel{
		public void paintComponent(Graphics colorSlider){
			super.paintComponent(colorSlider);
			
			// establece nuevo color de dibujo, usando valores enteros
			colorSlider.setColor( new Color( 255, 0, 0 ) );
			colorSlider.fillRect( 25, 5, 40, 20 );
			
			// establece nuevo color de dibujo, usando valores de punto flotante
			colorSlider.setColor( new Color( 0.50f, 0.75f, 0.0f ) );
			colorSlider.fillRect( 25, 36, 40, 20 );
			
			// establece nuevo color de dibujo, usando objetos Color static
			colorSlider.setColor( Color.BLUE );
			colorSlider.fillRect( 25, 68, 40, 20 );

			colorSlider.setColor( new Color( 25, 50, 0 ) );
			colorSlider.fillRect( 150, 110, 120, 50 );
			colorSlider.drawString("Generado", 75, 138);
		}
	}
}