import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class MarcoMenu extends JFrame{

	private final Color valoresColores[] = { Color.BLACK, Color.BLUE, Color.RED, Color.GREEN };
	private JRadioButtonMenuItem elementosColores[]; // elementos del menú colores
	private JRadioButtonMenuItem fuentes[]; // elementos del menú fuentes
	private JCheckBoxMenuItem elementosEstilos[]; // elementos del menú estilos
	private JLabel mostrarJLabel; // muestra texto de ejemplo
	private ButtonGroup fuentesButtonGroup; // administra elementos del menú fuentes
	private ButtonGroup coloresButtonGroup; // administra elementos del menú colores
	private int estilo; // se utiliza para crear el estilo para la fuente

	// el constructor sin argumentos establece la GUI
	public MarcoMenu(){
		super( "Uso de objetos JMenu" );
		JMenu menuArchivo = new JMenu( "Archivo" ); // crea el menú archivo
		menuArchivo.setMnemonic( 'A' ); // establece el nemónico a A

		// crea el elemento de menú Acerca de...
		JMenuItem elementoAcercaDe = new JMenuItem( "Acerca de..." );
		elementoAcercaDe.setMnemonic( 'c' ); // establece el nemónico a c
		menuArchivo.add( elementoAcercaDe ); // agrega el elemento elementoAcercaDe al menú archivo

		elementoAcercaDe.addActionListener(new ActionListener(){
			public void actionPerformed( ActionEvent evento ){
				JOptionPane.showMessageDialog( MarcoMenu.this, "Este es un ejemplo\ndel uso de menus",
												"Acerca de", JOptionPane.PLAIN_MESSAGE );
			} 
		});

		JMenuItem elementoSalir = new JMenuItem( "Salir" ); // crea el elemento salir
		elementoSalir.setMnemonic( 'S' ); // establece el nemónico a S
		menuArchivo.add( elementoSalir );

		elementoSalir.addActionListener(new ActionListener(){
			public void actionPerformed( ActionEvent evento ){
				System.exit( 0 ); // sale de la aplicación
			}
		});

		JMenuBar barra = new JMenuBar(); // crea la barra de menús
		setJMenuBar( barra ); // agrega la barra de menús a la aplicación
		barra.add( menuArchivo ); // agrega el menú archivo a la barra de menús

		JMenu menuFormato = new JMenu( "Formato" ); // crea el menú formato
		menuFormato.setMnemonic( 'F' ); // establece el nemónico a F

		// arreglo que enlista la cadena colores
		String colores[] = { "Negro", "Azul", "Rojo", "Verde" };

		JMenu menuColor = new JMenu( "Color" ); // crea el menú color
		menuColor.setMnemonic( 'C' ); // establece el nemónico a C

		// crea los elementos de menú de los botones de opción para los colores
		elementosColores = new JRadioButtonMenuItem[ colores.length ];
		coloresButtonGroup = new ButtonGroup(); // administra los colores
		ManejadorElementos manejadorElementos = new ManejadorElementos(); // manejador para colores

		// crea los elementos de menú del botón de opción color
		for ( int cuenta = 0; cuenta < colores.length; cuenta++ ){
			elementosColores[ cuenta ] =
			new JRadioButtonMenuItem( colores[ cuenta ] ); // crea elemento
			menuColor.add( elementosColores[ cuenta ] ); // agrega elemento al menú color
			coloresButtonGroup.add( elementosColores[ cuenta ] ); // lo agrega al grupo
			elementosColores[ cuenta ].addActionListener( manejadorElementos );
		} // fin de for
		elementosColores[ 0 ].setSelected( true ); // selecciona el primer elemento de Color

		menuFormato.add( menuColor ); // agrega el menú color al menú formato
		menuFormato.addSeparator(); // agrega un separador en el menú

		// arreglo que enlista los nombres de las fuentes
		String nombresFuentes[] = { "Serif", "Monospaced", "SansSerif" };
		JMenu menuFuente = new JMenu( "Fuente" ); // crea el menú fuente
		menuFuente.setMnemonic( 'u' ); // establece el nemónico a u

		// crea elementos de menú de botones de opción para los nombres de las fuentes
		fuentes = new JRadioButtonMenuItem[ nombresFuentes.length ];
		fuentesButtonGroup = new ButtonGroup(); // administra los nombres de las fuentes

		// crea elementos de menú de botones de opción de Fuente
		for ( int cuenta = 0; cuenta < fuentes.length; cuenta++ ){
			fuentes[ cuenta ] = new JRadioButtonMenuItem( nombresFuentes[ cuenta ] );
			menuFuente.add( fuentes[ cuenta ] ); // agrega fuente al menú fuente
			fuentesButtonGroup.add( fuentes[ cuenta ] ); // agrega al grupo de botones
			fuentes[ cuenta ].addActionListener( manejadorElementos ); // agrega el manejador
		} // fin de for

		fuentes[ 0 ].setSelected( true ); // selecciona el primer elemento del menú Fuente
		menuFuente.addSeparator(); // agrega barra separadora al menú fuente

		String nombresEstilos[] = { "Negrita", "Cursiva" }; // nombres de los estilos
		elementosEstilos = new JCheckBoxMenuItem[ nombresEstilos.length ];
		ManejadorEstilos manejadorEstilos = new ManejadorEstilos(); // manejador de estilos

		// crea elementos de menú de la casilla de verificación de estilo
		for ( int cuenta = 0; cuenta < nombresEstilos.length; cuenta++ ){
			elementosEstilos[ cuenta ] =
			new JCheckBoxMenuItem( nombresEstilos[ cuenta ] ); // para el estilo
			menuFuente.add( elementosEstilos[ cuenta ] ); // agrega al menú fuente
			elementosEstilos[ cuenta ].addItemListener( manejadorEstilos ); // manejador
		} // fin de for

		menuFormato.add( menuFuente ); // agrega el menú Fuente al menú Formato
		barra.add( menuFormato ); // agrega el menú Formato a la barra de menús

		// establece la etiqueta para mostrar el texto
		mostrarJLabel = new JLabel( "Texto de ejemplo", SwingConstants.CENTER );
		mostrarJLabel.setForeground( valoresColores[ 0 ] );
		mostrarJLabel.setFont( new Font( "'Serif", Font.PLAIN, 72 ) );

		getContentPane().setBackground( Color.CYAN ); // establece el color de fondo
		add( mostrarJLabel, BorderLayout.CENTER ); // agrega mostrarJLabel
	} // fin del constructor de MarcoMenu

	// clase interna para manejar los eventos de acción de los elementos de menú
	private class ManejadorElementos implements ActionListener{
		// procesa las selecciones de color y fuente
		public void actionPerformed( ActionEvent evento ){
			// procesa la selección del color
			for ( int cuenta = 0; cuenta < elementosColores.length; cuenta++ ){
				if ( elementosColores[ cuenta ].isSelected() ){
					mostrarJLabel.setForeground( valoresColores[ cuenta ] );
					break;
				} // fin de if
			} // fin de for

			// procesa la selección de fuente
			for ( int cuenta = 0; cuenta < fuentes.length; cuenta++ ){
				if ( evento.getSource() == fuentes[ cuenta ] ){
					mostrarJLabel.setFont(new Font(fuentes[cuenta].getText(), estilo, 72));
				} // fin de if
			} // fin de for
			repaint(); // vuelve a dibujar la aplicación
		} // fin del método actionPerformed
	} // fin de la clase ManejadorElementos

	// clase interna para manejar los eventos de los elementos de menú de las casillas de verificación
	private class ManejadorEstilos implements ItemListener{
		// procesa las selecciones de estilo de las fuentes
		public void itemStateChanged( ItemEvent e ){
			estilo = 0; // inicializa el estilo
	
			// comprueba la selección de negrita
			if ( elementosEstilos[ 0 ].isSelected() )
				estilo += Font.BOLD; // agrega negrita al estilo
	
			// comprueba la selección de cursiva
			if ( elementosEstilos[ 1 ].isSelected() )
				estilo += Font.ITALIC; // agrega cursiva al estilo
		
			mostrarJLabel.setFont(new Font(mostrarJLabel.getFont().getName(), estilo, 72));
			repaint(); // vuelve a dibujar la aplicación
		} // fin del método itemStateChanged
	} // fin de la clase ManejadorEstilos
} // fin de la clase MarcoMenu