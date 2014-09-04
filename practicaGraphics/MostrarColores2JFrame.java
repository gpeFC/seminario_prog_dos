import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class MostrarColores2JFrame extends JFrame{
	private JButton cambiarColorJButton;
	private Color color = Color.LIGHT_GRAY;
	private JPanel coloresJPanel;
	
	public MostrarColores2JFrame(){
		super("Uso de JColorChooser");

		coloresJPanel = new JPanel();
		coloresJPanel.setBackground(color);

		cambiarColorJButton = new JButton("Cambiar color");
		
		cambiarColorJButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				color = JColorChooser.showDialog(MostrarColores2JFrame.this, "Seleccione un color", color);
				
				if(color == null)
					color = Color.LIGHT_GRAY;
				
				coloresJPanel.setBackground(color);
			}
		});

		add(coloresJPanel, BorderLayout.CENTER);
		add(cambiarColorJButton, BorderLayout.SOUTH);
		setSize(400, 130);
		setVisible(true);
	}
}