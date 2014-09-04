import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;

public class PoligonosJPanel extends JPanel
{
// dibuja polígonos y polilíneas
public void paintComponent( Graphics g )
{
super.paintComponent( g ); // llama al método paintComponent de la superclase
// dibuja polígono con objeto polígono
int valoresX[] = { 20, 40, 50, 30, 20, 15 };
int valoresY[] = { 50, 50, 60, 80, 80, 60 };
Polygon poligono1 = new Polygon( valoresX, valoresY, 6 );
g.drawPolygon( poligono1 );
// dibuja polilíneas con dos arreglos
int valoresX2[] = { 70, 90, 100, 80, 70, 65, 60 };
int valoresY2[] = { 100, 100, 110, 110, 130, 110, 90 };
g.drawPolyline( valoresX2, valoresY2, 7 );
// rellena polígono con dos arreglos
int valoresX3[] = { 120, 140, 150, 190 };
int valoresY3[] = { 40, 70, 80, 60 };
g.fillPolygon( valoresX3, valoresY3, 4 );
// dibuja polígono relleno con objeto Polygon
Polygon poligono2= new Polygon();
poligono2.addPoint( 165, 135 );
poligono2.addPoint( 175, 150 );
poligono2.addPoint( 270, 200 );
poligono2.addPoint( 200, 220 );
poligono2.addPoint( 130, 180 );
g.fillPolygon( poligono2 );
} // fin del método paintComponent
}