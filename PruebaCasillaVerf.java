import javax.swing.JFrame;

public class PruebaCasillaVerf{
	public static void main(String args[]){
		MarcoCasillaVerf marcoCasilla = new MarcoCasillaVerf();
		marcoCasilla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marcoCasilla.setSize(500, 300); // Establece el tamaño del marco.
		marcoCasilla.setVisible(true); // Muestra el marco.
	}
}