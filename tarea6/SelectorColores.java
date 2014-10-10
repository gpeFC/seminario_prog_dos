import javax.swing.JFrame;

public class SelectorColores{
	public static void main(String args[]){
		InterfazControlColores selectorColores = new InterfazControlColores();
		selectorColores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		selectorColores.setSize(350, 260);
		selectorColores.setVisible(true);
	}
}