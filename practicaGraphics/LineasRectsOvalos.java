import java.awt.Color;
import javax.swing.JFrame;

public class LineasRectsOvalos{
	public static void main(String args[]){
		JFrame marco =
		new JFrame( "Dibujo de lineas, rectangulos y ovalos" );
		marco.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		LineasRectsOvalosJPanel lineasRectsOvalosJPanel =
		new LineasRectsOvalosJPanel();
		lineasRectsOvalosJPanel.setBackground( Color.WHITE );
		marco.add( lineasRectsOvalosJPanel );marco.setSize( 400, 210 );
		marco.setVisible( true );
	}
}