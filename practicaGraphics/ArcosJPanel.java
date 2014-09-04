import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ArcosJPanel extends JPanel
{
// dibuja rectángulos y arcos
public void paintComponent( Graphics g )
{
super.paintComponent( g ); // llama al método paintComponent de la superclase
// empieza en 0 y se extiende hasta 360 grados
g.setColor( Color.RED );
g.drawRect( 15, 35, 80, 80 );
g.setColor( Color.BLACK );
g.drawArc( 15, 35, 80, 80, 0, 360 );
// empieza en 0 y se extiende hasta 110
g.setColor( Color.RED );
g.drawRect( 100, 35, 80, 80 );
g.setColor( Color.BLACK );
g.drawArc( 100, 35, 80, 80, 0, 110 );
// empieza en 0 y se extiende hasta -270 grados
g.setColor( Color.RED );
g.drawRect( 185, 35, 80, 80 );
g.setColor( Color.BLACK );
g.drawArc( 185, 35, 80, 80, 0, -270 );
// empieza en 0 y se extiende hasta 360 grados
g.fillArc( 15, 120, 80, 40, 0, 360 );
// empieza en 270 y se extiende hasta -90 grados
g.fillArc( 100, 120, 80, 40, 270, -90 );
// empieza en 0 y se extiende hasta -270 grados
g.fillArc( 185, 120, 80, 40, 0, -270 );
} // fin del método paintComponent
}