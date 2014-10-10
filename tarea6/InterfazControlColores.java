import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfazControlColores extends JFrame{

	private JLabel etiquetaRojoJL;
	private JLabel etiquetaVerdeJL;
	private JLabel etiquetaAzulJL;

	private JButton botonColorJB;

	private JTextField valorRojoJTF;
	private JTextField valorVerdeJTF;
	private JTextField valorAzulJTF;
	private JTextField textoColorJTF;

	private Color colorRojoC = Color.RED;
	private Color colorVerdeC = Color.GREEN;
	private Color colorAzul = Color.BLUE;

	private JSlider rangoRojoJS;
	private JSlider rangoVerdeJS;
	private JSlider rangoAzulJS;

	private JPanel panelDatos;

	private AreaColoresSliders colorSlider;

	public InterfazControlColores(){

		super("Selector de Color");

		etiquetaRojoJL = new JLabel("Rojo:");
		etiquetaVerdeJL = new JLabel("Verde:");
		etiquetaAzulJL = new  JLabel("Azul:");

		botonColorJB = new JButton("Aplicar color");

		valorRojoJTF = new JTextField(5);
		valorVerdeJTF = new JTextField(5);
		valorAzulJTF = new JTextField(5);
		textoColorJTF = new JTextField("Selector de color con slider's");
		//textoColorJTF.setFont(Font.BOLD);
		textoColorJTF.setEditable(false);

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
		panelDatos.add(etiquetaRojoJL);
		panelDatos.add(valorRojoJTF);
		panelDatos.add(etiquetaVerdeJL);
		panelDatos.add(valorVerdeJTF);
		panelDatos.add(etiquetaAzulJL);
		panelDatos.add(valorAzulJTF);
		panelDatos.add(textoColorJTF);
		panelDatos.add(botonColorJB);
		//panelDatos.setBackground(Color.CYAN);
		panelDatos.setPreferredSize(new Dimension(350,60));

		add(colorSlider);
		add(panelDatos, BorderLayout.SOUTH);
	}

	private class AreaColoresSliders extends JPanel{
		public void paintComponent(Graphics colorSlider){
			super.paintComponent(colorSlider);
			
			// establece nuevo color de dibujo, usando valores enteros
			colorSlider.setColor(colorRojoC);
			colorSlider.fillRect(25, 5, 40, 20);
			
			// establece nuevo color de dibujo, usando valores de punto flotante
			colorSlider.setColor(colorVerdeC);
			colorSlider.fillRect(25, 36, 40, 20);
			
			// establece nuevo color de dibujo, usando objetos Color static
			colorSlider.setColor(colorAzul);
			colorSlider.fillRect(25, 68, 40, 20);

			colorSlider.setColor(new Color( 25, 50, 0 ));
			colorSlider.fillRect(150, 110, 120, 50);
			colorSlider.drawString("Generado", 75, 138);
		}
	}
}