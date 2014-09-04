import javax.swing.JFrame;

public class DibujarArcos
{
public static void main( String args[] )
{
// crea marco para ArcosJPanel
JFrame marco = new JFrame( "Dibujo de arcos" );
marco.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
ArcosJPanel arcosJPanel = new ArcosJPanel(); // crea objeto ArcosJPanel
marco.add( arcosJPanel ); // agrega arcosJPanel al marco
marco.setSize( 300, 210 ); // establece el tamaño del marco
marco.setVisible( true ); // muestra el marco
} // fin de main
}