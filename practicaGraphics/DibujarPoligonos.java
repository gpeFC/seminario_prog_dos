import javax.swing.JFrame;

public class DibujarPoligonos{
	public static void main(String args[]){
		JFrame marco = new JFrame("Dibujo de poligonos");
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PoligonosJPanel poligonosJPanel = new PoligonosJPanel();
		marco.add(poligonosJPanel);
		marco.setSize(280, 270);
		marco.setVisible(true);
	}
}