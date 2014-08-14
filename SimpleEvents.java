import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SimpleEvents extends JFrame{

	static final int WIDTH  = 300;
	static final int HEIGHT = 180;

	double var1 = 0.0;
	double var2 = 0.0;

	public static void main(String args[]){
		SimpleEvents frame = new SimpleEvents();

		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		frame.setSize(WIDTH, HEIGHT);

		frame.setVisible(true);

		frame.setResizable(true);
	}

	public SimpleEvents(){
		super("Seminario de Programacion 2");
		//setBounds(100, 100, 450, 375);

		var1 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un numero: "));

		var2 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa otro numero: "));

		final JButton boton = new JButton();

		boton.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent arg0){
				JOptionPane.showMessageDialog(null, (var1+var2), "Resultado: ", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		});
		boton.setText("Boton");
		getContentPane().add(boton, BorderLayout.CENTER);
	}
}