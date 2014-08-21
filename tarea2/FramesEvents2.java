import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class FramesEvents2 extends JFrame{

	private String nombres[] = {"bar.jpg", "bob_1.jpg", "homero.gif", "mr_b.gif", "smile.png", "snooopy.gif", "brackb.jpg"};
	private final String nombresColores[] = {"Negro", "Azul", "Naranja", "Rosa", "Rojo", "Blanco", "Amarillo"};
	private final Color colores[] = {Color.BLACK, Color.BLUE, Color.ORANGE, Color.PINK, Color.RED, 
		Color.WHITE, Color.YELLOW };

	private JLabel movRaton;
	private JLabel imgLista;
	private JButton botonCopiar;
	private JComboBox imgsLista;
	private JList imgsColorsLista;
	private JList copiadoLista;

	private Icon iconos[] = {
		new ImageIcon(getClass().getResource(nombres[0])),
		new ImageIcon(getClass().getResource(nombres[1])),
		new ImageIcon(getClass().getResource(nombres[2])),
		new ImageIcon(getClass().getResource(nombres[3])),
		new ImageIcon(getClass().getResource(nombres[4])),
		new ImageIcon(getClass().getResource(nombres[5])),
		new ImageIcon(getClass().getResource(nombres[6]))
	};

	public FramesEvents2(){
		super("Seminario de Programacion II: Proyecto 2");
		setLayout(new FlowLayout());

		movRaton = new JLabel("Raton fuera de JPanel");

		imgsLista = new JComboBox(nombres);
		imgsLista.setMaximumRowCount(3); 

		ManejadorRaton manejador = new ManejadorRaton();
		
		panelRaton.addMouseListener(manejador);
		panelRaton.addMouseMotionListener(manejador);

		imgsColorsLista = new JList(nombresColores);
		imgsColorsLista.setVisibleRowCount(4); 
		imgsColorsLista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		imgsColorsLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		add( new JScrollPane(imgsColorsLista));
		imgsColorsLista.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent evento){
				getContentPane().setBackground(colores[imgsColorsLista.getSelectedIndex()]);
			} 
		});

		add(new JScrollPane(imgsColorsLista));

		botonCopiar = new JButton("<Copiar>>>"); 
			botonCopiar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				copiadoLista.setListData(imgsColorsLista.getSelectedValues());
			}
		});

		imgsLista.addItemListener(
			new ItemListener(){
				public void itemStateChanged(ItemEvent evento){
					if (evento.getStateChange() == ItemEvent.SELECTED)
						imgLista.setIcon(iconos[imgsLista.getSelectedIndex()]);
				} 
			}
		);

		imgLista = new JLabel(iconos[0]);

		add(botonCopiar);

		copiadoLista = new JList(); 
		copiadoLista.setVisibleRowCount(4); 
		copiadoLista.setFixedCellWidth(100); 
		copiadoLista.setFixedCellHeight(15); 
		copiadoLista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		add(new JScrollPane(copiadoLista));

		add(imgsLista); 
		add(imgLista); 
	}

}