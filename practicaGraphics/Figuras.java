import javax.swing.JFrame;

public class Figuras{
	// ejecuta la aplicación
	public static void main(String args[]){

		// crea marco para objeto FigurasJPanel
		JFrame marco = new JFrame( "Dibujo de figuras en 2D" );
		marco.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		// crea objeto FigurasJPanel
		FigurasJPanel figurasJPanel = new FigurasJPanel();
		marco.add( figurasJPanel ); // agrega figurasJPanel to marco
		marco.setSize( 425, 200 ); // establece el tamaño del marco
		marco.setVisible( true ); // muestra el marco
	} // fin de main
}