import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfazElevadorConHilos extends JFrame{

	private int botonValX[] = {326,332,339};
	private int botonSupValY[] = {61,75,61};
	private int botonInfValY[] = {205,191,205};

	private Escenario escenario;

	public InterfazElevadorConHilos(){
		super("Elevador");

		escenario = new Escenario();
		escenario.setBackground(Color.BLACK);

		add(escenario);
	}

	private class Escenario extends JPanel{
		public void paintComponent(Graphics grafico){
			super.paintComponent(grafico);

			// Plantas.
			grafico.setColor(Color.LIGHT_GRAY);
			grafico.fillRect(5, 5, 350, 125);
			grafico.fillRect(5, 135, 350, 125);
			grafico.fillRect(530, 5, 275, 125);
			grafico.fillRect(530, 135, 275, 125);			

			// Botones.
			grafico.setColor(Color.BLACK);
			grafico.fillRect(315, 45, 35, 45);
			grafico.fillRect(315, 175, 35, 45);
			grafico.setColor(Color.WHITE);
			grafico.fillRect(318, 48, 29, 39);
			grafico.fillRect(318, 178, 29, 39);
			grafico.setColor(Color.LIGHT_GRAY);
			grafico.fillRect(323, 58, 19, 20);
			grafico.fillRect(323, 188, 19, 20);
			grafico.setColor(Color.BLACK);
			grafico.fillPolygon(botonValX,botonSupValY,3);
			grafico.setColor(Color.RED);
			grafico.fillPolygon(botonValX,botonInfValY,3);


			// Elevador.
			grafico.setColor(Color.BLUE);
			grafico.fillRect(360, 135, 165, 125);
			grafico.setColor(Color.ORANGE);
			grafico.fillRect(365, 140, 75, 115);
			grafico.fillRect(445, 140, 75, 115);
			grafico.setColor(Color.BLACK);
			grafico.fillRect(375, 145, 60, 50);
			grafico.fillRect(450, 145, 60, 50);
			grafico.setColor(Color.GRAY);
			grafico.fillRect(383, 153, 45, 35);
			grafico.fillRect(458, 153, 45, 35);

			//grafico.drawString("Generado", 75, 138);
		}
	}
}