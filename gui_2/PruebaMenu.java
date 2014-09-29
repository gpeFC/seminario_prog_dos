import javax.swing.JFrame;

public class PruebaMenu{
	public static void main( String args[] ){
		MarcoMenu marcoMenu = new MarcoMenu();
		marcoMenu.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		marcoMenu.setSize( 600, 200 ); // establece el tamaño del marco
		marcoMenu.setVisible( true ); // muestra el marco
	} // fin de main
}