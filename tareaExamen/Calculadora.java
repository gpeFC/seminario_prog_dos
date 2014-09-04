import javax.swing.JFrame;

public class Calculadora{
	public static void main(String args[]){
		InterfazCalculadora calculadora = new InterfazCalculadora();
		calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculadora.setResizable(false);
		calculadora.setSize(380, 280);
		calculadora.setVisible(true);
	}
}