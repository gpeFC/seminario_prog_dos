import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MarcoDetallesRaton extends JFrame{

	private String detalles; 
	private JLabel barraEstado1;
	private JLabel barraEstado2;
	private JLabel barraEstado3;

	public MarcoDetallesRaton(){
		super("Clics y botones del raton");

		barraEstado1 = new JLabel("Haga clic en el raton");
		barraEstado2 = new JLabel("Haga clic en el raton");
		barraEstado3 = new JLabel("Haga clic en el raton");

		add(barraEstado1, BorderLayout.NORTH);
		add(barraEstado2, BorderLayout.CENTER);
		add(barraEstado3, BorderLayout.SOUTH);
		addMouseListener(new ManejadorClicRaton()); 
	} 

	private class ManejadorClicRaton extends MouseAdapter{
		
		public void mouseClicked(MouseEvent evento){
			int xPos = evento.getX(); 
			int yPos = evento.getY(); 

			detalles = String.format("Se hizo clic %d vez(veces)",	evento.getClickCount());

			if (evento.isMetaDown()){
				detalles += " con el boton derecho del raton";
				barraEstado1.setText(detalles);
			}
			else if (evento.isAltDown()){
				detalles += " con el boton central del raton";
				barraEstado2.setText(detalles);
			}
			else{
				detalles += " con el boton izquierdo del raton";
				barraEstado3.setText(detalles);
			}
		} 
	} 
}