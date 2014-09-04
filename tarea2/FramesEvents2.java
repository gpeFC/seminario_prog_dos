import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;


public class FramesEvents2 extends JFrame{

	private String nombresImagenes[] = {"bar.jpg", "bob_1.jpg", "homero.gif", "mr_b.gif", "smile.png", "snooopy.gif", "brackb.jpg"};
	private final String nombresColores[] = {"Negro", "Azul", "Naranja", "Rosa", "Rojo", "Blanco", "Amarillo"};
	private final Color coloresFondo[] = {Color.BLACK, Color.BLUE, Color.ORANGE, Color.PINK, Color.RED, 
									 Color.WHITE, Color.YELLOW };

	private JComboBox listaImagenes;
	private JLabel etiquetaImagen;
	private JButton botonCopiar;
	private JList imagenesColores;
	private JList listaVacia;
	private Icon iconos[] = {
		new ImageIcon(getClass().getResource(nombresImagenes[0])),
		new ImageIcon(getClass().getResource(nombresImagenes[1])),
		new ImageIcon(getClass().getResource(nombresImagenes[2])),
		new ImageIcon(getClass().getResource(nombresImagenes[3])),
		new ImageIcon(getClass().getResource(nombresImagenes[4])),
		new ImageIcon(getClass().getResource(nombresImagenes[5])),
		new ImageIcon(getClass().getResource(nombresImagenes[6]))
	};

	public FramesEvents2(){
		super("Listas de seleccion multiple");
		setLayout(new FlowLayout()); 

		listaImagenes = new JComboBox(nombresImagenes);
		listaImagenes.setMaximumRowCount(3);

		imagenesColores = new JList(nombresImagenes);
		imagenesColores.setVisibleRowCount( 5 ); 
		imagenesColores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		imagenesColores.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent evento){
				getContentPane().setBackground(coloresFondo[imagenesColores.getSelectedIndex()]);
			} 
		}); 
		
		botonCopiar = new JButton("Copiar >>>"); 
		botonCopiar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				if(evento.getSource() == botonCopiar){
					int opcion = JOptionPane.showConfirmDialog(FramesEvents2.this, "¿Quieres copiar el contenido?", "Copiar", JOptionPane.YES_NO_OPTION);
					if(opcion == JOptionPane.YES_OPTION){
						listaVacia.setListData(imagenesColores.getSelectedValues());
					}
				}
			}
		});

		listaImagenes.addItemListener(
			new ItemListener(){
				public void itemStateChanged(ItemEvent evento){
					if (evento.getStateChange() == ItemEvent.SELECTED)
						etiquetaImagen.setIcon(iconos[listaImagenes.getSelectedIndex()]);
				} 
			}
		);

		etiquetaImagen = new JLabel(iconos[0]); 

		listaVacia = new JList(); 
		listaVacia.setVisibleRowCount(5); 
		listaVacia.setFixedCellWidth(100); 
		listaVacia.setFixedCellHeight(15); 
		listaVacia.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		add(new JScrollPane(imagenesColores));
		add(botonCopiar);
		add(new JScrollPane(listaVacia));
		add(listaImagenes); 
		add(etiquetaImagen); 
	}
}