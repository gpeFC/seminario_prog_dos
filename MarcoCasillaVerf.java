import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class MarcoCasillaVerf extends JFrame{
	private JTextField campoTexto; // Muestra el texto en tipos de letra cambiantes.
	private JCheckBox negritaJCB; // Para seleccionar/deseleccionar negrita.
	private JCheckBox cursivaJCB; // Para seleccionar/deseleccionar cursiva.
	private Icon newIcon = new ImageIcon(getClass().getResource("c_2.jpg"));

	public MarcoCasillaVerf(){
		super("Prueba de JCheckBox");
		setLayout(new FlowLayout()); // Establece el esquema del marco.

		// Establece JTextField y su tipo de letra.
		campoTexto = new JTextField("Observe como cambia el estilo de tipo de letra", 20);
		campoTexto.setFont(new Font("Serif", Font.PLAIN, 14));
		add(campoTexto); // Agrega campoTexto a JFrame.

		negritaJCB = new JCheckBox("Negrita", newIcon); // Crea la casilla de verificacion "Negrita".
		cursivaJCB = new JCheckBox("Cursiva"); // Crea la casilla de verificacion "Cursiva".

		add(negritaJCB); // Agrega la casilla de verificacion "Negrita" a JFrame.
		add(cursivaJCB); // Agrega la casilla de verificacion "Cursiva" a JFrame.

		ManejadorCheckBox manejador = new ManejadorCheckBox();
		negritaJCB.addItemListener(manejador);
		cursivaJCB.addItemListener(manejador);
	}

	// Clase interna para manejar los eventos ItemListener.
	private class ManejadorCheckBox implements ItemListener{
		private int valNegrita = Font.PLAIN; // Controla el estilo de tipo de letra negrita.
		private int valCursiva = Font.PLAIN; // Controla el estilo de tipo de letra cursiva.

		// Responde a los eventos de casilla de verificacion.
		public void itemStateChanged(ItemEvent evento){

			// Procesa los eventos de la casilla de verificacion "negrita".
			if(evento.getSource() == negritaJCB)
				valNegrita = negritaJCB.isSelected() ? Font.BOLD: Font.PLAIN;

			// Procesa los eventos de la casilla de verificacion "cursiva".
			if(evento.getSource() == cursivaJCB)
				valCursiva = cursivaJCB.isSelected() ? Font.ITALIC : Font.PLAIN;

			// Establece el tipo de letra del campo texto.
			campoTexto.setFont(new Font("Serif", valNegrita + valCursiva, 14));
		}
	}
}