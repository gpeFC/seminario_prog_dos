import javax.swing.JFrame;

public class ElevadorConHilos{
	public static void main(String args[]){
		InterfazElevadorConHilos elevador = new InterfazElevadorConHilos();
		InterfazDeControlHilos control = new InterfazDeControlHilos();
		elevador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		control.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		elevador.setSize(817, 293);
		control.setSize(250, 150);
		elevador.setVisible(true);
		control.setVisible(true);
	}
}