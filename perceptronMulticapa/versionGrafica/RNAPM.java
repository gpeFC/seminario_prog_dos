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
		TopologiaRed menuTopologia = new TopologiaRed();
		menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuTopologia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPrincipal.setSize(250, 250);
		menuTopologia.setSize(250, 250);
		menuPrincipal.setVisible(true);
		menuTopologia.setVisible(true);
	}
}