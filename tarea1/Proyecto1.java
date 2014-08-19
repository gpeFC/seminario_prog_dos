import javax.swing.JFrame;

public class Proyecto1{
	public static void main(String args[]){

		FramesEvents marcoBoton = new FramesEvents();
		marcoBoton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marcoBoton.setSize(900, 300);
		marcoBoton.setResizable(false);
		marcoBoton.setVisible(true);

	}
}