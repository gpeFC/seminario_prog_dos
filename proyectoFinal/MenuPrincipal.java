/******************************************************************************
 * UAEM, Facultad de Ciencias
 * Seminario de Programacion II
 * Emanuel GP
 *
 * Proyecto: Red Neuronal Artificial: Perceptron Multicapa con Retropropagacion
 ******************************************************************************/

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MenuPrincipal extends JFrame{

		// Objetos GUI - Menu principal.
	private JLabel logotipoJL;
	private JButton salirJB;
	private JButton continuarJB;
	private JRadioButton crearRedJRB;
	private JRadioButton mostrarRedJRB;
	private JRadioButton aplicarRedJRB;
	private JRadioButton entrenarRedJRB;
	private JRadioButton eliminarRedJRB;
	private JRadioButton modificarRedJRB;
	private ButtonGroup menuOpcionesBG;
	private JPanel panelAreaImagenJP;
	private JPanel panelBotonesAccionJP;
	private JPanel panelBotonesSeleccionJP;

	public MenuPrincipal(){
		super("RNA - Perceptron Multicapa");
		setLayout(new FlowLayout());

		Icon icono = new ImageIcon(getClass().getResource("iconopm2.jpg"));
		logotipoJL = new JLabel(icono);

		salirJB = new JButton("Salir");
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

		panelAreaImagenJP = new JPanel();
		panelAreaImagenJP.setLayout(new FlowLayout());
		panelAreaImagenJP.setPreferredSize(new Dimension(350,300));
		
		panelBotonesAccionJP = new JPanel();
		panelBotonesAccionJP.setLayout(new GridLayout(1,2,160,200));
		panelBotonesAccionJP.setPreferredSize(new Dimension(500,30));
		
		panelBotonesSeleccionJP = new JPanel();
		panelBotonesSeleccionJP.setLayout(new GridLayout(6,1));
		panelBotonesSeleccionJP.setPreferredSize(new Dimension(150,300));

		panelAreaImagenJP.add(logotipoJL);

		panelBotonesAccionJP.add(continuarJB);
		panelBotonesAccionJP.add(salirJB);

		panelBotonesSeleccionJP.add(crearRedJRB);
		panelBotonesSeleccionJP.add(mostrarRedJRB);
		panelBotonesSeleccionJP.add(aplicarRedJRB);
		panelBotonesSeleccionJP.add(entrenarRedJRB);
		panelBotonesSeleccionJP.add(eliminarRedJRB);
		panelBotonesSeleccionJP.add(modificarRedJRB);

		add(panelBotonesSeleccionJP);
		add(panelAreaImagenJP);
		add(panelBotonesAccionJP);
	}
}