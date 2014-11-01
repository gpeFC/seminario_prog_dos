import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfazDibujoFormas extends JFrame{

	private int coordenadaXRect, coordenadaXCirc, coordenadaXOval, coordenadaX;
	private int coordenadaYRect, coordenadaYCirc, coordenadaYOval, coordenadaY;
	private int alturaFigura;
	private int anchuraFigura;
	private String colores[] = {"Negro", "Rojo", "Azul", "Gris", "Cyan"};
	private JLabel menuFigurasJL;
	private JButton limpiarAreaJB;
	private JCheckBox rellenoFiguraJCB;
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

	private Color coloresColor[] = {Color.BLACK, Color.RED, Color.BLUE, Color.GRAY, Color.CYAN};
	private Color colorForma = coloresColor[0];

	private AreaDeDibujo areaDibujo;

	public InterfazDibujoFormas(){
		super("Figuras: Contornos y Rellenos");

		esquema = new BorderLayout(5,100);

		coordenadaX = 0;
		coordenadaY = 0;
		coordenadaXRect = coordenadaX;
		coordenadaYRect = coordenadaY;
		coordenadaXCirc = coordenadaX;
		coordenadaYCirc = coordenadaY;
		coordenadaXOval = coordenadaX;
		coordenadaYOval = coordenadaY;

		alturaFigura = 0;
		anchuraFigura = 0;

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
		
		ovaloJRB = new JRadioButton("Ovalo");
		circuloJRB = new JRadioButton("Circulo");
		rectanguloJRB = new JRadioButton("Rectangulo", true);
		
		opcionesFiguras = new ButtonGroup();
		opcionesFiguras.add(ovaloJRB);
		opcionesFiguras.add(circuloJRB);
		opcionesFiguras.add(rectanguloJRB);

		ManejadorFormas manejadorFormas = new ManejadorFormas();
		limpiarAreaJB.addItemListener(manejadorFormas);
		ovaloJRB.addItemListener(manejadorFormas);
		circuloJRB.addItemListener(manejadorFormas);
		rectanguloJRB.addItemListener(manejadorFormas);

		listaColoresJCB = new JComboBox(colores);
		listaColoresJCB.setMaximumRowCount(3);
		listaColoresJCB.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent evento){
				if (evento.getStateChange() == ItemEvent.SELECTED){
					if(listaColoresJCB.getSelectedIndex() == 0)
						colorForma = coloresColor[0];
					else if(listaColoresJCB.getSelectedIndex() == 1)
						colorForma = coloresColor[1];
					else if(listaColoresJCB.getSelectedIndex() == 2)
						colorForma = coloresColor[2];
					else if(listaColoresJCB.getSelectedIndex() == 3)
						colorForma = coloresColor[3];
				}
			}
		});

		areaDibujo = new AreaDeDibujo();
		areaDibujo.setBackground(Color.WHITE);

		ManejadorRaton manejador = new ManejadorRaton();
		areaDibujo.addMouseListener(manejador);
		areaDibujo.addMouseMotionListener(manejador);

		panelSuperior.add(limpiarAreaJB);

		panelCentral.add(menuFigurasJL);
		panelCentral.add(rectanguloJRB);
		panelCentral.add(circuloJRB);
		panelCentral.add(ovaloJRB);

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
			areaDibujo.setColor(colorForma);
			areaDibujo.fillRect(coordenadaX, coordenadaY, anchuraFigura, alturaFigura);
			areaDibujo.fillOval(coordenadaX, coordenadaY, anchuraFigura, alturaFigura);
		}
	}

	private class ManejadorFormas implements ItemListener{
		public void itemStateChanged(ItemEvent evento) {
			if(evento.getSource() == limpiarAreaJB){
				coordenadaX = 0;
				coordenadaY = 0;
				alturaFigura = 0;
				anchuraFigura = 0;
				rectanguloJRB = new JRadioButton("Rectangulo", true);
				colorForma = coloresColor[0];
				areaDibujo.repaint();
			}
			else if(evento.getSource() == rectanguloJRB){
				coordenadaXRect = coordenadaX;
				coordenadaYRect = coordenadaY;
				coordenadaXCirc = 0;
				coordenadaYCirc = 0;
				coordenadaXOval = 0;
				coordenadaYOval = 0;
			}
			else if(evento.getSource() == circuloJRB){
				coordenadaXRect = 0;
				coordenadaYRect = 0;
				coordenadaXCirc = coordenadaX;
				coordenadaYCirc = coordenadaY;
				coordenadaXOval = 0;
				coordenadaYOval = 0;
			}
			else if(evento.getSource() == ovaloJRB){
				coordenadaXRect = 0;
				coordenadaYRect = 0;
				coordenadaXCirc = 0;
				coordenadaYCirc = 0;
				coordenadaXOval = coordenadaX;
				coordenadaYOval = coordenadaY;
			}
		}
	}

	private class ManejadorRaton implements MouseListener, MouseMotionListener{
		// Los manejadores de eventos de MouseListener
		// manejan el evento cuando se suelta el ratón justo después de oprimir el botón
		public void mouseClicked(MouseEvent evento){
			//barraEstado.setText(String.format("Se hizo clic en [%d, %d]",	evento.getX(), evento.getY()));
		}

		// maneja evento cuando se oprime el ratón
		public void mousePressed(MouseEvent evento){
			coordenadaX = evento.getX();
			coordenadaY = evento.getY();
			areaDibujo.repaint();
			//barraEstado.setText(String.format("Se oprimio en [%d, %d]", evento.getX(), evento.getY()));
		}

		// maneja evento cuando se suelta el botón del ratón después de arrastrarlo
		public void mouseReleased(MouseEvent evento){
			anchuraFigura = evento.getX() - coordenadaX;
			alturaFigura = evento.getY() - coordenadaY;
			areaDibujo.repaint();
			//barraEstado.setText(String.format("Se solto en [%d, %d]", evento.getX(), evento.getY()));
		}

		// maneja evento cuando el ratón entra al área
		public void mouseEntered(MouseEvent evento){
			//barraEstado.setText( String.format("Raton entro en [%d, %d]", evento.getX(), evento.getY()));
			//panelRaton.setBackground( Color.GREEN );
		}

		// maneja evento cuando el ratón sale del área
		public void mouseExited(MouseEvent evento){
			//barraEstado.setText("Raton fuera de JPanel");
			//panelRaton.setBackground( Color.WHITE );
		}

		// Los manejadores de eventos de MouseMotionListener manejan
		// el evento cuando el usuario arrastra el ratón con el botón oprimido
		public void mouseDragged(MouseEvent evento){
			anchuraFigura = evento.getX() - coordenadaX;
			alturaFigura = evento.getY() - coordenadaY;
			areaDibujo.repaint();
			//barraEstado.setText(String.format("Se arrastro en [%d, %d]", evento.getX(), evento.getY()));
		}

		// maneja evento cuando el usuario mueve el ratón
		public void mouseMoved(MouseEvent evento){
			//barraEstado.setText( String.format("Se movio en [%d, %d]", evento.getX(), evento.getY()));
		}
	}
}