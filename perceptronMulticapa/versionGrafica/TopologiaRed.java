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

		// Objetos GUI - Topologia red.
	private JButton continuar;
	private JRadioButton redSimple;
	private JRadioButton redMulticapa;
	private ButtonGroup menuTopologia;

	public TopologiaRed(){
		super("Topologia Perceptron");
		setLayout(new FlowLayout());

		continuar = new JButton("Continuar");

		redSimple = new JRadioButton("Perceptron Simple", true);
		redMulticapa = new JRadioButton("Perceptron Multicapa", false);

		menuTopologia = new ButtonGroup();
		menuTopologia.add(redSimple);
		menuTopologia.add(redMulticapa);

		add(redSimple);
		add(redMulticapa);
		add(continuar);
	}
}