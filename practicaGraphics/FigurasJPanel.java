import java.awt.Color;
import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.GradientPaint;
import java.awt.TexturePaint;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class FigurasJPanel extends JPanel{
	public void paintComponent(Graphics g){

		super.paintComponent( g ); // llama al método paintComponent de la superclase

		Graphics2D g2d = ( Graphics2D ) g; // convierte a g en objeto Graphics2D

		// dibuja un elipse en 2D, relleno con un gradiente color azul-amarillo
		g2d.setPaint( new GradientPaint( 5, 30, Color.BLUE, 35, 100,
		Color.YELLOW, true ) );
		g2d.fill( new Ellipse2D.Double( 5, 30, 65, 100 ) );

		// dibuja rectángulo en 2D de color rojo
		g2d.setPaint( Color.RED );
		g2d.setStroke( new BasicStroke( 10.0f ) );
		g2d.draw( new Rectangle2D.Double( 80, 30, 65, 100 ) );

		// dibuja rectángulo delimitador en 2D, con un fondo con búfer
		BufferedImage imagenBuf = new BufferedImage( 10, 10,
		BufferedImage.TYPE_INT_RGB );

		// obtiene objeto Graphics2D de imagenBuf y dibuja en él
		Graphics2D gg = imagenBuf.createGraphics();
		gg.setColor( Color.YELLOW ); // dibuja en color amarillo
		gg.fillRect( 0, 0, 10, 10 ); // dibuja un rectángulo relleno
		gg.setColor( Color.BLACK ); // dibuja en color negro
		gg.drawRect( 1, 1, 6, 6 ); // dibuja un rectángulo
		gg.setColor( Color.BLUE ); // dibuja en color azul
		gg.fillRect( 1, 1, 3, 3 ); // dibuja un rectángulo relleno
		gg.setColor( Color.RED ); // dibuja en color rojo
		gg.fillRect( 4, 4, 3, 3 ); // dibuja un rectángulo relleno

		// pinta a imagenBuf en el objeto JFrame
		g2d.setPaint( new TexturePaint( imagenBuf,
		new Rectangle( 10, 10 ) ) );
		g2d.fill(
		new RoundRectangle2D.Double( 155, 30, 75, 100, 50, 50 ) );

		// dibuja arco en forma de pastel en 2D, de color blanco
		g2d.setPaint( Color.WHITE );
		g2d.setStroke( new BasicStroke( 6.0f ) );
		g2d.draw(
		new Arc2D.Double( 240, 30, 75, 100, 0, 270, Arc2D.PIE ) );

		// dibuja líneas 2D en verde y amarillo
		g2d.setPaint( Color.GREEN );
		g2d.draw( new Line2D.Double( 395, 30, 320, 150 ) );
		
		// dibuja línea 2D usando el trazo
		float guiones[] = { 10 }; // especifica el patrón de guiones
		g2d.setPaint( Color.YELLOW );
		g2d.setStroke( new BasicStroke( 4, BasicStroke.CAP_ROUND,
		BasicStroke.JOIN_ROUND, 10, guiones, 0 ) );
		g2d.draw( new Line2D.Double( 320, 30, 395, 150 ) );
	}
}