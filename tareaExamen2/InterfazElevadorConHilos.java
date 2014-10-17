import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfazElevadorConHilos extends JFrame{

	private Escenario escenario;

	public InterfazElevadorConHilos(){
		super("Elevador");

		escenario = new Escenario();

		add(escenario);
	}

	private class Escenario extends JPanel{
		public void paintComponent(Graphics grafico){
			super.paintComponent(grafico);

			grafico.setColor(Color.GRAY);
			grafico.fillRect(0, 0, 350, 125);

			grafico.setColor(Color.GRAY);
			grafico.fillRect(525, 0, 275, 125);

			//grafico.drawString("Generado", 75, 138);
		}
	}
}