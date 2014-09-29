import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfazDibujoFormas extends JFrame{
	private String colores[] = {"Negro", "Rojo", "Azul", "Amarillo", "Cafe", "Cyan", "Rosa"};
	private JLabel menuFigurasJL;
	private JButton limpiarAreaJB;
	private JCheckBox rellenoFiguraJCB;
	private JRadioButton arcoJRB;
	private JRadioButton ovaloJRB;
	private JRadioButton circuloJRB;
	private JRadioButton rectanguloJRB;
	private ButtonGroup opcionesFiguras;
	private JComboBox listaColoresJCB;

	private JPanel panelSuperior;
	private JPanel panelCentral;
	private JPanel panelInferior;
	private JPanel panelControl;
	
	private BorderLayout esquema;

	private AreaDeDibujo areaDibujo;

	public InterfazDibujoFormas(){
		super("Figuras: Contornos y Rellenos");

		esquema = new BorderLayout(5,100);

		panelSuperior = new JPanel();
		panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(5,1));
		panelInferior = new JPanel();
		panelControl = new JPanel();
		panelControl.setLayout(esquema);
		panelControl.setPreferredSize(new Dimension(250,400));

		menuFigurasJL = new JLabel("Figura a dibujar");
		limpiarAreaJB = new JButton("Limpiar dibujo");
		rellenoFiguraJCB = new JCheckBox("Rellenar figura");
		
		arcoJRB = new JRadioButton("Arco");
		ovaloJRB = new JRadioButton("Ovalo");
		circuloJRB = new JRadioButton("Circulo");
		rectanguloJRB = new JRadioButton("Rectangulo", true);
		
		opcionesFiguras = new ButtonGroup();
		opcionesFiguras.add(arcoJRB);
		opcionesFiguras.add(ovaloJRB);
		opcionesFiguras.add(circuloJRB);
		opcionesFiguras.add(rectanguloJRB);

		listaColoresJCB = new JComboBox(colores);
		listaColoresJCB.setMaximumRowCount(5);

		areaDibujo = new AreaDeDibujo();
		areaDibujo.setBackground(Color.WHITE);

		panelSuperior.add(limpiarAreaJB);

		panelCentral.add(menuFigurasJL);
		panelCentral.add(rectanguloJRB);
		panelCentral.add(circuloJRB);
		panelCentral.add(ovaloJRB);
		panelCentral.add(arcoJRB);

		panelInferior.add(listaColoresJCB);
		panelInferior.add(rellenoFiguraJCB);

		panelControl.add(panelSuperior, BorderLayout.NORTH);
		panelControl.add(panelCentral, BorderLayout.CENTER);
		panelControl.add(panelInferior, BorderLayout.SOUTH);

		add(panelControl, BorderLayout.WEST);
		add(areaDibujo);
	}

	private class AreaDeDibujo extends JPanel{
		public void paintComponent(Graphics areaDibujo){
			super.paintComponent(areaDibujo);
		}
	}
}