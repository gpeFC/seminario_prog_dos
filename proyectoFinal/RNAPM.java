/******************************************************************************
 * UAEM, Facultad de Ciencias
 * Seminario de Programacion II
 * Emanuel GP
 *
 * Proyecto: Red Neuronal Artificial: Perceptron Multicapa con Retropropagacion
 ******************************************************************************/

import javax.swing.JFrame;

public class RNAPM{
	public static void main(String args[]){
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.setSize(520, 380);
		menuPrincipal.setVisible(true);

		CrearRed nuevaRed = new CrearRed();
		nuevaRed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nuevaRed.setSize(250, 350);
		nuevaRed.setVisible(true);
	}
}