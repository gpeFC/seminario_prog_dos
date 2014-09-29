import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class MarcoSlider extends JFrame{
	private JSlider diametroJSlider; // control deslizable para seleccionar el diámetro
	private PanelOvalo miPanel; // panel para dibujar el círculo
	
	// constructor sin argumentos
	public MarcoSlider(){
		super( "Demostracion de JSlider" );

		miPanel = new PanelOvalo(); // crea panel para dibujar el círculo
		miPanel.setBackground( Color.YELLOW ); // establece el color de fondo en amarillo

		// establece objeto JSlider para controlar el valor del diámetro
		diametroJSlider = new JSlider( SwingConstants.HORIZONTAL, 0, 200, 10 );
		diametroJSlider.setMajorTickSpacing( 10 ); // crea una marca cada 10
		diametroJSlider.setPaintTicks( true ); // dibuja las marcas en el control

		// registra el componente que escucha los eventos del objeto JSlider
		diametroJSlider.addChangeListener(new ChangeListener(){ // clase interna anónima
		// maneja el cambio en el valor del control deslizable
			public void stateChanged( ChangeEvent e ){
				miPanel.establecerDiametro( diametroJSlider.getValue() );
			} // fin del método stateChanged
		});

		add(diametroJSlider, BorderLayout.SOUTH ); // agrega el control deslizable al marco
		add(miPanel, BorderLayout.CENTER ); // agrega el panel al marco
	}
}