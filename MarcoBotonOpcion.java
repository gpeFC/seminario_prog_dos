import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class MarcoBotonOpcion extends JFrame{
	private JTextField campoTexto; // Mostrar los cambios en el tipo de letra.
	private Font tipoLetraSimple;
	private Font tipoLetraNegrita;
	private Font tipoLetraCursiva;
	private Font tipoLetraNegritaCursiva;

	private JRadioButton simpleRB; 
	private JRadioButton negritaRB;
	private JRadioButton cursivaRB;
	private JRadioButton negritaCursivaRB;
	private ButtonGroup grupoRB;

	public MarcoBotonOpcion(){
		super("Prueba de RadiButton");
		setLayout(new FlowLayout());

		campoTexto = new JTextField("Observe el cambio en el estilo de tipo de letra", 28);
		add(campoTexto);

		// Creacion de los botones de opcion.
		simpleRB = new JRadioButton("Simple", true);
		negritaRB = new JRadioButton("Negrita", false);
		cursivaRB = new JRadioButton("Cursiva", false);
		negritaCursivaRB = new JRadioButton("Negrita/Cursiva", false);

		add(simpleRB);
		add(negritaRB);
		add(cursivaRB);
		add(negritaCursivaRB);

		// Crea una realcion logica entra los objetos JRadioButton.
		grupoRB = new ButtonGroup();
		grupoRB.add(simpleRB);
		grupoRB.add(negritaRB);
		grupoRB.add(cursivaRB);
		grupoRB.add(negritaCursivaRB);

		// Crear los objetos tipo de letra.
		tipoLetraSimple = new Font("Serif", Font.PLAIN, 14);
		tipoLetraNegrita = new Font("Serif", Font.BOLD, 14);
		tipoLetraCursiva = new Font("Serif", Font.ITALIC, 14);
		tipoLetraNegritaCursiva = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
		campoTexto.setFont(tipoLetraSimple);

		// Registra los eventos para los objetos JRadioButton.
		simpleRB.addItemListener(new ManejadorBotonOpcion(tipoLetraSimple));
		negritaRB.addItemListener(new ManejadorBotonOpcion(tipoLetraNegrita));
		cursivaRB.addItemListener(new ManejadorBotonOpcion(tipoLetraCursiva));
		negritaCursivaRB.addItemListener(new ManejadorBotonOpcion(tipoLetraNegritaCursiva));
	}

	// Clase interna privada para manejar los eventos de botones de opcion.
	private class ManejadorBotonOpcion implements ItemListener{
		private Font tipoLetra;

		public ManejadorBotonOpcion(Font f){
			tipoLetra = f;
		}

		// Maneja los eventos de botones de opcion.
		public void itemStateChanged(ItemEvent evento){
			campoTexto.setFont(tipoLetra);
		}
	}
}