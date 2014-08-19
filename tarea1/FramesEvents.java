import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.Icon;


public class FramesEvents extends JFrame{
	private JLabel etiquetaUsuario;
	private JLabel etiquetaContrasenia;

	private Font letraSimple;
	private Font letraNegrita;
	private Font letraCursiva;
	private Font letraNegritaCursiva;

	private JTextField textoUsuarioEditable;
	private JTextField textoUsuarioNoEditable;
	private JTextField textoContraseniaNoEditable;
	private JPasswordField textoContraseniaEditable;

	private JButton botonTextoBorrar;
	private JButton botonIconoBorrar;

	private JCheckBox negritaCB;
	private JCheckBox cursivaCB;

	private JRadioButton negritaRB;
	private JRadioButton cursivaRB;
	private ButtonGroup grupoBotonesRB;

	private Icon usuario;
	private Icon contrasenia;
	private Icon borrarTexto;

	public FramesEvents(){
		super("Proyecto 1: Seminario de Programación II");
		setLayout(new FlowLayout());

		usuario = new ImageIcon(getClass().getResource("usuario.png"));
		contrasenia = new ImageIcon(getClass().getResource("contrasenia.png"));
		borrarTexto = new ImageIcon(getClass().getResource("borrar.png"));

		etiquetaUsuario = new JLabel(); // Constructor de JLabel sin argumentos
		etiquetaUsuario.setText("Usuario + <Enter>");
		etiquetaUsuario.setIcon(usuario); // agrega icono a JLabel
		etiquetaUsuario.setHorizontalTextPosition( SwingConstants.CENTER );
		etiquetaUsuario.setVerticalTextPosition( SwingConstants.NORTH );
		etiquetaUsuario.setToolTipText("Etiqueta USUARIO");

		etiquetaContrasenia = new JLabel(); // Constructor de JLabel sin argumentos
		etiquetaContrasenia.setText("Contraseña + <Enter>");
		etiquetaContrasenia.setIcon(contrasenia); // agrega icono a JLabel
		etiquetaContrasenia.setHorizontalTextPosition( SwingConstants.CENTER );
		etiquetaContrasenia.setVerticalTextPosition( SwingConstants.BOTTOM );
		etiquetaContrasenia.setToolTipText("Etiqueta CONTRASEÑA");

		textoUsuarioEditable = new JTextField(15);
		textoUsuarioEditable.setToolTipText("Campo de texto editable.");
		textoUsuarioNoEditable = new JTextField(15);
		textoUsuarioNoEditable.setEditable(false);
		textoUsuarioNoEditable.setToolTipText("Campo de texto no editable 1.");
		textoContraseniaNoEditable = new JTextField(15);
		textoContraseniaNoEditable.setEditable(false);
		textoContraseniaNoEditable.setToolTipText("Campo de texto no editable 2.");
		textoContraseniaEditable = new JPasswordField(15);
		textoContraseniaEditable.setToolTipText("Campo de contraseña no editable.");

		letraSimple = new Font( "Arial", Font.PLAIN, 14 );
		letraNegrita = new Font( "Arial", Font.BOLD, 14 );
		letraCursiva = new Font( "Arial", Font.ITALIC, 14 );
		letraNegritaCursiva = new Font("Arial", Font.BOLD + Font.ITALIC, 14);
		textoUsuarioNoEditable.setFont(letraSimple);
		textoContraseniaNoEditable.setFont(letraSimple);

		botonTextoBorrar = new JButton("<Borrar Contenido>");
		botonIconoBorrar = new JButton(borrarTexto);

		ManejadorCamposTextoBotonesJB manejadorTF = new ManejadorCamposTextoBotonesJB();
		textoUsuarioEditable.addActionListener(manejadorTF);
		textoUsuarioNoEditable.addActionListener(manejadorTF);
		textoContraseniaNoEditable.addActionListener(manejadorTF);
		textoContraseniaEditable.addActionListener(manejadorTF);
		botonTextoBorrar.addActionListener(manejadorTF);
		botonIconoBorrar.addActionListener(manejadorTF);

		negritaCB = new JCheckBox("Negrita");
		cursivaCB = new JCheckBox("Cursiva");

		negritaRB = new JRadioButton("Negrita");
		cursivaRB = new JRadioButton("Cursiva");

		grupoBotonesRB = new ButtonGroup();
		grupoBotonesRB.add(negritaRB);
		grupoBotonesRB.add(cursivaRB);

		ManejadorCBRB manejadorCB = new ManejadorCBRB();
		negritaCB.addItemListener(manejadorCB);
		cursivaCB.addItemListener(manejadorCB);
		negritaRB.addItemListener(manejadorCB);
		cursivaRB.addItemListener(manejadorCB);

		add(etiquetaUsuario);
		add(textoUsuarioEditable);
		add(textoUsuarioNoEditable);
		add(botonTextoBorrar);
		add(negritaCB);
		add(cursivaCB);
		add(etiquetaContrasenia);
		add(textoContraseniaEditable);
		add(textoContraseniaNoEditable);
		add(botonIconoBorrar);
		add(negritaRB);
		add(cursivaRB);

	}

	private class ManejadorCamposTextoBotonesJB implements ActionListener{
		public void actionPerformed(ActionEvent evento){
			if(evento.getSource() == textoUsuarioEditable){
				textoUsuarioNoEditable.setText(String.format("%s", evento.getActionCommand()));
				textoUsuarioEditable.setText(String.format("", evento.getActionCommand()));
			}
			else if(evento.getSource() == textoContraseniaEditable){
				textoContraseniaNoEditable.setText(String.format("%s", new String(textoContraseniaEditable.getPassword())));
				textoContraseniaEditable.setText(String.format("", evento.getActionCommand()));
			}
			else if(evento.getSource() == botonTextoBorrar){
				int opcion = JOptionPane.showConfirmDialog(FramesEvents.this, "¿Desea borrar el contenido?", "Borrar", JOptionPane.YES_NO_OPTION);
				if(opcion == JOptionPane.YES_OPTION)
					textoUsuarioNoEditable.setText(String.format("", evento.getActionCommand()));
			}
			else if(evento.getSource() == botonIconoBorrar){
				int opcion = JOptionPane.showConfirmDialog(FramesEvents.this, "¿Desea borrar el contenido?", "Borrar", JOptionPane.YES_NO_OPTION);
				if(opcion == JOptionPane.YES_OPTION)
					textoContraseniaNoEditable.setText(String.format("", evento.getActionCommand()));
			}
		}
	}

	private class ManejadorCBRB implements ItemListener{
		public void itemStateChanged(ItemEvent evento){
			if ((evento.getSource() == negritaCB) || (evento.getSource() == cursivaCB)){
				if((negritaCB.isSelected()) && (cursivaCB.isSelected()))
					textoUsuarioNoEditable.setFont(letraNegritaCursiva);

				else if(negritaCB.isSelected())
					textoUsuarioNoEditable.setFont(letraNegrita);

				else if(cursivaCB.isSelected())
					textoUsuarioNoEditable.setFont(letraCursiva);

				else
					textoUsuarioNoEditable.setFont(letraSimple);
			}
			else if((evento.getSource() ==  negritaRB) || (evento.getSource() == cursivaRB)){
				if(negritaRB.isSelected())
					textoContraseniaNoEditable.setFont(letraNegrita);

				else if(cursivaRB.isSelected())
					textoContraseniaNoEditable.setFont(letraCursiva);
			}
		}
	}
}