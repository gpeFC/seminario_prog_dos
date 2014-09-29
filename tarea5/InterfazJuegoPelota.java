/*
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class InterfazJuegoPelota extends JFrame{
	private int VALORX = 450;
	private int VALORY = 100;
	private String tecla;
	private String ACCIONES[] = {"ArribaIzquierda", "Arriba", "ArribaDerecha", "Izquierda", "CambiarColor", 
								 "Derecha", "AbajoIzquierda", "Abajo", "AbajoDerecha"};
	private JButton botonesAcciones[];
	private GridLayout rejillaAcciones;
	private JPanel panelBotones;
	private JPanel panelAcciones;
	private Color colorFondo = Color.LIGHT_GRAY;

	private AreaDeMovimiento areaJuego;
	
	public InterfazJuegoPelota(){
		super("Juego de Pelota 1");

		botonesAcciones = new JButton[ACCIONES.length];
		rejillaAcciones = new GridLayout(3,3,1,1);
		panelBotones = new JPanel();
		panelAcciones = new JPanel();
		panelAcciones.setBackground(colorFondo);

		areaJuego = new AreaDeMovimiento();

		ManejadorAcciones manejador = new ManejadorAcciones();

		for(int cuenta = 0; cuenta < ACCIONES.length; cuenta++){
			botonesAcciones[cuenta] = new JButton(ACCIONES[cuenta]);
			panelBotones.add(botonesAcciones[cuenta]);
			botonesAcciones[cuenta].addActionListener(manejador);
		}

		panelBotones.setLayout(rejillaAcciones);
		panelBotones.setPreferredSize(new Dimension(450,180));
		panelAcciones.add(panelBotones);
		add(areaJuego);
		add(panelAcciones, BorderLayout.SOUTH);
	}

	private class AreaDeMovimiento extends JPanel{
		public void paintComponent(Graphics areaDibujo){
			super.paintComponent(areaDibujo);
			areaDibujo.setColor(Color.BLUE);
			areaDibujo.fillOval(VALORX, VALORY, 70, 70);
		}
	}

	private class ManejadorAcciones implements ActionListener{
		public void actionPerformed(ActionEvent evento){
			if(evento.getSource() == botonesAcciones[0]){
				VALORX--;
				VALORY--;
				areaJuego.repaint();
			}
			else if(evento.getSource() == botonesAcciones[1]){
				VALORY--;
				areaJuego.repaint();
			}
			else if(evento.getSource() == botonesAcciones[2]){
				VALORX++;
				VALORY--;
				areaJuego.repaint();
			}
			else if(evento.getSource() == botonesAcciones[3]){
				VALORX--;
				areaJuego.repaint();
			}
			else if(evento.getSource() == botonesAcciones[4]){
				colorFondo = JColorChooser.showDialog(InterfazJuegoPelota.this, "Seleccione un color", colorFondo);
				if(colorFondo == null)
					colorFondo = Color.LIGHT_GRAY;
				panelAcciones.setBackground(colorFondo);
			}
			else if(evento.getSource() == botonesAcciones[5]){
				VALORX++;
				areaJuego.repaint();
			}
			else if(evento.getSource() == botonesAcciones[6]){
				VALORX--;
				VALORY++;
				areaJuego.repaint();
			}
			else if(evento.getSource() == botonesAcciones[7]){
				VALORY++;
				areaJuego.repaint();
			}
			else if(evento.getSource() == botonesAcciones[8]){
				VALORX++;
				VALORY++;
				areaJuego.repaint();
			}
		}
	}
}