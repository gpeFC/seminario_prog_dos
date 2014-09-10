import javax.swing.JFrame;

public class DibujarArcos{
	public static void main(String args[]){
		JFrame marco = new JFrame("Dibujo de arcos");
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ArcosJPanel arcosJPanel = new ArcosJPanel();
		marco.add(arcosJPanel);
		marco.setSize(300, 210);
		marco.setVisible(true);
	} 
}