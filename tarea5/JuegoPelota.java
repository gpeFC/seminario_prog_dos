import javax.swing.JFrame;

public class JuegoPelota{
	public static void main(String args[]){
		InterfazJuegoPelota juegoPelota = new InterfazJuegoPelota();
		juegoPelota.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		juegoPelota.setSize(1024, 600);
		juegoPelota.setVisible(true);
	}
}