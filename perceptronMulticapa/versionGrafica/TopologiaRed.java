/******************************************************************************
 * UAEM, Facultad de Ciencias
 * Seminario de Programacion II
 * Emanuel GP
 *
 * Proyecto: Red Neuronal Artificial: Perceptron Multicapa con Retropropagacion
 ******************************************************************************/

import java.awt.*;
import javax.swing.*;

public class TopologiaRed extends JFrame{

		// Objetos Primitivos.
	private String nombreRed;

		// Objetos GUI - Topologia red.
	private JButton continuarJB;
	private JTextField nombreRedJTF;
	private JRadioButton redSimpleJRB;
	private JRadioButton redMulticapaJRB;
	private ButtonGroup menuTopologiaBG;

	public TopologiaRed(){
		super("Topologia Perceptron");
		setLayout(new FlowLayout());

		continuarJB = new JButton("Continuar");

		nombreRedJTF = new JTextField(15);

		redSimpleJRB = new JRadioButton("Perceptron Simple", true);
		redMulticapaJRB = new JRadioButton("Perceptron Multicapa", false);

		menuTopologiaBG = new ButtonGroup();
		menuTopologiaBG.add(redSimpleJRB);
		menuTopologiaBG.add(redMulticapaJRB);

		add(redSimpleJRB);
		add(redMulticapaJRB);
		add(nombreRedJTF);
		add(continuarJB);
	}
}