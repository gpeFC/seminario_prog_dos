import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MarcoFlowLayout extends JFrame{	
	private JButton botonJButtonIzquierda; 
	private JButton botonJButtonCentro; 
	private JButton botonJButtonDerecha;
	
	private FlowLayout esquema; 
	private Container contenedor;

	public MarcoFlowLayout(){
		super("Demostracion de FlowLayout");
		esquema = new FlowLayout(); 
		contenedor = getContentPane(); 
		setLayout(esquema); 

		botonJButtonIzquierda = new JButton("Izquierda");
		add(botonJButtonIzquierda); 
		botonJButtonIzquierda.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				try{
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				}
				catch(Exception e){
					e.printStackTrace();
				}
				esquema.setAlignment(FlowLayout.LEFT);
				esquema.layoutContainer(contenedor);
			} 
		});
		
		botonJButtonCentro = new JButton("Centro");
		add(botonJButtonCentro);
		botonJButtonCentro.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				try{
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				}
				catch(Exception e){
					e.printStackTrace();
				}
				esquema.setAlignment(FlowLayout.CENTER);
				esquema.layoutContainer(contenedor);
			}
		}); 
		
		botonJButtonDerecha = new JButton("Derecha");
		add(botonJButtonDerecha);
		botonJButtonDerecha.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				try{
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				}
				catch(Exception e){
					e.printStackTrace();
				}
				esquema.setAlignment(FlowLayout.RIGHT);
				esquema.layoutContainer(contenedor);
			}
		});
	}
}