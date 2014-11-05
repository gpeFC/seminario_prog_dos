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
	private JButton continuarJB;
	private JRadioButton crearRedJRB;
	private JRadioButton mostrarRedJRB;
	private JRadioButton aplicarRedJRB;
	private JRadioButton entrenarRedJRB;
	private JRadioButton eliminarRedJRB;
	private JRadioButton modificarRedJRB;
	private ButtonGroup menuOpcionesBG;

	public MenuPrincipal(){
		super("RNA - Perceptron Multicapa");
		setLayout(new FlowLayout());

		continuarJB = new JButton("Continuar");

		crearRedJRB = new JRadioButton("Crear Red", true);
		mostrarRedJRB = new JRadioButton("Mostrar Red", false);
		aplicarRedJRB = new JRadioButton("Aplicar Red", false);
		entrenarRedJRB = new JRadioButton("Entrenar Red", false);
		eliminarRedJRB = new JRadioButton("Eliminar Red", false);
		modificarRedJRB = new JRadioButton("Modificar Red", false);

		menuOpcionesBG = new ButtonGroup();
		menuOpcionesBG.add(crearRedJRB);
		menuOpcionesBG.add(mostrarRedJRB);
		menuOpcionesBG.add(aplicarRedJRB);
		menuOpcionesBG.add(entrenarRedJRB);
		menuOpcionesBG.add(eliminarRedJRB);
		menuOpcionesBG.add(modificarRedJRB);

		add(crearRedJRB);
		add(mostrarRedJRB);
		add(aplicarRedJRB);
		add(entrenarRedJRB);
		add(eliminarRedJRB);
		add(modificarRedJRB);
		add(continuarJB);
	}
}