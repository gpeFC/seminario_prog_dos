import javax.swing.JOptionPane;
import java.lang.NumberFormatException;

public class Adivina{

	
	public static void main(String args[]){

		String ingreso;
		int aleatorio = (int)(Math.random()*10 + 1);
		int numero;

		System.out.printf("%d\n", aleatorio);

		JOptionPane.showMessageDialog(null, "Intenta adivinar un numero entre 1 y 10.");
		numero = 0;
		while(numero != aleatorio){
			do{
				ingreso = JOptionPane.showInputDialog("Ingresa un numero: ");
				try{
					numero = Integer.parseInt(ingreso);
					break;
				
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Dato incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}while(true);
			if(numero == aleatorio){
				JOptionPane.showMessageDialog(null, "¡Has adivinado el numero!", "Felicidades", JOptionPane.PLAIN_MESSAGE);
				break;
			}
			else if(numero > aleatorio){
				JOptionPane.showMessageDialog(null, "El numero "+numero+" es mayor al buscado.", "Continua", JOptionPane.INFORMATION_MESSAGE);
			}

			else if(numero < aleatorio){
				JOptionPane.showMessageDialog(null, "El numero "+numero+" es menor al buscado.", "Continua", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}