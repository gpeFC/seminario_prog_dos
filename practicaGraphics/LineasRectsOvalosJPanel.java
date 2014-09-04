import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class LineasRectsOvalosJPanel extends JPanel{
	public void paintComponent( Graphics g ){
		super.paintComponent( g );

		this.setBackground( Color.BLACK );
		
		g.setColor( Color.RED );
		g.drawLine( 5, 30, 380, 30 );

		g.setColor( Color.BLUE );
		
		g.fillRect( 100, 40, 90, 55 );
		g.drawRoundRect( 290, 40, 90, 55, 20, 20 );
		

		g.setColor( Color.WHITE );
		g.drawRect( 5, 40, 90, 55 );
		g.fillRoundRect( 195, 40, 90, 55, 50, 50 );
		
		

		g.setColor( Color.MAGENTA );
		g.draw3DRect( 5, 100, 90, 55, true );
		g.fillOval( 290, 100, 90, 55 );
		

		g.setColor( Color.YELLOW );
		g.drawOval( 195, 100, 90, 55 );
		g.fill3DRect( 100, 100, 90, 55, false );
		
	} 
}