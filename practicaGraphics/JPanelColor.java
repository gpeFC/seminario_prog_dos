import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
public class JPanelColor extends JPanel{
	
	// dibuja rectángulos y objetos String en distintos colores
	public void paintComponent(Graphics g){
		super.paintComponent(g); // llama al método paintComponent de la superclase
		this.setBackground(Color.BLACK);

		// establece nuevo color de dibujo, usando valores enteros
		g.setColor(new Color( 255, 0, 0));
		g.fillRect(15, 25, 100, 20);
		g.drawString("RGB actual: " + g.getColor(), 130, 40);

		// establece nuevo color de dibujo, usando valores de punto flotante
		g.setColor(new Color( 0.50f, 0.75f, 0.0f));
		g.fillRect(15, 50, 100, 20);
		g.drawString("RGB actual: " + g.getColor(), 130, 65);

		// establece nuevo color de dibujo, usando objetos Color static
		g.setColor(Color.CYAN);
		g.fillRect(15, 75, 100, 20);
		g.drawString("RGB actual: " + g.getColor(), 130, 90);

		// muestra los valores RGB individuales
		Color color = Color.YELLOW;
		g.setColor( color );
		g.fillRect( 15, 100, 100, 20 );
		g.drawString("Valores RGB: " + color.getRed() + ", " +
					 color.getGreen() + ", " + color.getBlue(), 130, 115);
	}
}