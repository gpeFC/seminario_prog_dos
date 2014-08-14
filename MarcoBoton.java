import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MarcoBoton extends JFrame{
	private JButton botonSimple;
	private JButton botonElegante;

	// Agregar botones JButton a JFrame.
	public MarcoBoton(){
		super("Prueba de botones");
		setLayout(new FlowLayout()); // Establece el esquema del marco.

		botonSimple = new JButton("Boton Simple"); // Boton con texto.
		add(botonSimple); // Agrega botonSimple a JFrame.

		Icon imgGif1 = new ImageIcon(getClass().getResource("ref_1.gif"));
		Icon imgGif2 = new ImageIcon(getClass().getResource("ref_2.gif"));

		botonElegante = new JButton("Boton Elegante", imgGif1); // Establece la imagen inicial del boton.
		botonElegante.setRolloverIcon(imgGif2); // Establece la imagen de susticion.

		add(botonElegante); // Agrega botonElegante a JFrame.

		ManejadorBoton manejador = new ManejadorBoton(); // Objeto(manejador) para manejar los eventos de boton.
		botonElegante.addActionListener(manejador);
		botonSimple.addActionListener(manejador);
	}

	// Clase interna para manejar los eventos de boton.
		private class ManejadorBoton implements ActionListener{

			// Manejador del evento boton.
			public void actionPerformed(ActionEvent evento){
				JOptionPane.showMessageDialog(MarcoBoton.this, String.format(
					"Usted oprimio: %s", evento.getActionCommand()));
			}
		}
}