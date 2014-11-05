/******************************************************************************
 * UAEM, Facultad de Ciencias
 * Seminario de Programacion II
 * Emanuel GP
 *
 * Proyecto: Red Neuronal Artificial: Perceptron Multicapa con Retropropagacion
 ******************************************************************************/

import java.awt.*;
import javax.swing.*;

public class MenuPrincipal extends JFrame{

		// Objetos GUI - Menu principal.
	private JButton continuar;
	private JRadioButton crearRed;
	private JRadioButton mostrarRed;
	private JRadioButton aplicarRed;
	private JRadioButton entrenarRed;
	private JRadioButton eliminarRed;
	private JRadioButton modificarRed;
	private ButtonGroup menuOpciones;

	public MenuPrincipal(){
		super("RNA - Perceptron Multicapa");
		setLayout(new FlowLayout());

		continuar = new JButton("Continuar");

		crearRed = new JRadioButton("Crear Red", true);
		mostrarRed = new JRadioButton("Mostrar Red", false);
		aplicarRed = new JRadioButton("Aplicar Red", false);
		entrenarRed = new JRadioButton("Entrenar Red", false);
		eliminarRed = new JRadioButton("Eliminar Red", false);
		modificarRed = new JRadioButton("Modificar Red", false);

		menuOpciones = new ButtonGroup();
		menuOpciones.add(crearRed);
		menuOpciones.add(mostrarRed);
		menuOpciones.add(aplicarRed);
		menuOpciones.add(entrenarRed);
		menuOpciones.add(eliminarRed);
		menuOpciones.add(modificarRed);

		add(crearRed);
		add(mostrarRed);
		add(aplicarRed);
		add(entrenarRed);
		add(eliminarRed);
		add(modificarRed);
		add(continuar);
	}
}