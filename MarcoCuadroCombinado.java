import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MarcoCuadroCombinado extends JFrame{

	private JComboBox imagenesJComboBox;
	private JLabel etiqueta;
	private String nombres[] = {"bar.jpg", "bob_1.jpg", "homero.gif", "mr_b.gif", "smile.png"};

	private Icon iconos[] = {
		new ImageIcon(getClass().getResource(nombres[0])),
		new ImageIcon(getClass().getResource(nombres[1])),
		new ImageIcon(getClass().getResource(nombres[2])),
		new ImageIcon(getClass().getResource(nombres[3])),
		new ImageIcon(getClass().getResource(nombres[4]))
	};

	public MarcoCuadroCombinado(){
		super("Prueba de JComboBox");
		setLayout(new FlowLayout()); 

		imagenesJComboBox = new JComboBox(nombres);
		imagenesJComboBox.setMaximumRowCount(3); 

		imagenesJComboBox.addItemListener(
			new ItemListener(){
				public void itemStateChanged(ItemEvent evento){
					if (evento.getStateChange() == ItemEvent.SELECTED)
						etiqueta.setIcon(iconos[imagenesJComboBox.getSelectedIndex()]);
				} 
			}
		); 

		add(imagenesJComboBox); 
		etiqueta = new JLabel(iconos[0]); 
		add(etiqueta); 
	} 
} 