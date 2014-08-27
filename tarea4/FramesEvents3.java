import java.awt.*;
import javax.swing.*;

public class FramesEvents3 extends JFrame{

	private double masaDesde;
	private double masaHacia;
	private double distanciaDesde;
	private double distanciaHacia;
	private double temperaturaDesde;
	private double temperaturaHacia;

	private String masaDesdeS;
	private String masaHaciaS;
	private String distanciaDesdeS;
	private String distanciaHaciaS;
	private String temperaturaDesdeS;
	private String temperaturaHaciaS;

	private String MASA[] = {"Miligramos", "Gramos", "Kilogramos"};
	private String DISTANCIA[] = {"Milimetros", "Metros", "Kilometros"};
	private String TEMPERATURA[] = {"Celsius", "Farenheit", "Kelvin"};

	private JLabel masaDesdeJL;
	private JLabel masaHaciaJL;
	private JLabel distanciaDesdeJL;
	private JLabel distanciaHaciaJL;
	private JLabel temperaturaDesdeJL;
	private JLabel temperaturaHaciaJL;

	private JTextField masaDesdeJTF;
	private JTextField masaHaciaJTF;
	private JTextField distanciaDesdeJTF;
	private JTextField distanciaHaciaJTF;
	private JTextField temperaturaDesdeJTF;
	private JTextField temperaturaHaciaJTF;

	private JButton borrarJB;
	private JButton convertirMasaJB;
	private JButton convertirDistanciaJB;
	private JButton convertirTemperaturaJB;

	private JComboBox masaDesdeJCB;
	private JComboBox masaHaciaJCB;
	private JComboBox distanciaDesdeJCB;
	private JComboBox distanciaHaciaJCB;
	private JComboBox temperaturaDesdeJCB;
	private JComboBox temperaturaHaciaJCB;

	private JPanel panelMasa;
	private JPanel panelBorrado;
	private JPanel panelDistancia;
	private JPanel panelTemperatura;

	public FramesEvents3(){
		super("Conversor");

		Box panelComplejo = Box.createVerticalBox();

		masaDesde = 0.0;
		masaHacia = 0.0;
		distanciaDesde = 0.0;
		distanciaHacia = 0.0;
		temperaturaDesde = 0.0;
		temperaturaHacia = 0.0;

		masaDesdeS = "";
		masaHaciaS = "";
		distanciaDesdeS = "";
		distanciaHaciaS = "";
		temperaturaDesdeS = "";
		temperaturaHaciaS = "";

		masaDesdeJL = new JLabel("De:");
		masaHaciaJL = new JLabel("A:");
		distanciaDesdeJL = new JLabel("De:");
		distanciaHaciaJL = new JLabel("A:");
		temperaturaDesdeJL = new JLabel("De:");
		temperaturaHaciaJL = new JLabel("A:");

		masaDesdeJTF = new JTextField(10);
		masaHaciaJTF = new JTextField(10);
		distanciaDesdeJTF = new JTextField(10);
		distanciaHaciaJTF = new JTextField(10);
		temperaturaDesdeJTF = new JTextField(10);
		temperaturaHaciaJTF = new JTextField(10);

		borrarJB = new JButton("Borrar");
		convertirMasaJB = new JButton("Convertir");
		convertirDistanciaJB = new JButton("Convertir");
		convertirTemperaturaJB = new JButton("Convertir");

		masaDesdeJCB = new JComboBox(MASA);
		masaHaciaJCB = new JComboBox(MASA);
		distanciaDesdeJCB = new JComboBox(DISTANCIA);
		distanciaHaciaJCB = new JComboBox(DISTANCIA);
		temperaturaDesdeJCB = new JComboBox(TEMPERATURA);
		temperaturaHaciaJCB = new JComboBox(TEMPERATURA);

		panelMasa = new JPanel();
		panelMasa.setLayout(new FlowLayout());
		panelMasa.add(masaDesdeJL);
		panelMasa.add(masaDesdeJTF);
		panelMasa.add(masaDesdeJCB);
		panelMasa.add(convertirMasaJB);
		panelMasa.add(masaHaciaJL);
		panelMasa.add(masaHaciaJCB);
		panelMasa.add(masaHaciaJTF);
		panelMasa.setBackground(Color.RED);

		panelBorrado = new JPanel();
		panelBorrado.setLayout(new BorderLayout());
		panelBorrado.add(borrarJB, BorderLayout.EAST);
		panelBorrado.setBackground(Color.CYAN);

		panelDistancia = new JPanel();
		panelDistancia.setLayout(new FlowLayout());
		panelDistancia.add(distanciaDesdeJL);
		panelDistancia.add(distanciaDesdeJTF);
		panelDistancia.add(distanciaDesdeJCB);
		panelDistancia.add(convertirDistanciaJB);
		panelDistancia.add(distanciaHaciaJL);
		panelDistancia.add(distanciaHaciaJCB);
		panelDistancia.add(distanciaHaciaJTF);
		panelDistancia.setBackground(Color.YELLOW);

		panelTemperatura = new JPanel();
		panelTemperatura.setLayout(new FlowLayout());
		panelTemperatura.add(temperaturaDesdeJL);
		panelTemperatura.add(temperaturaDesdeJTF);
		panelTemperatura.add(temperaturaDesdeJCB);
		panelTemperatura.add(convertirTemperaturaJB);
		panelTemperatura.add(temperaturaHaciaJL);
		panelTemperatura.add(temperaturaHaciaJCB);
		panelTemperatura.add(temperaturaHaciaJTF);
		panelTemperatura.setBackground(Color.MAGENTA);

		panelDistancia.setBorder(BorderFactory.createTitledBorder("Conversion de unidades de distancia."));
		panelMasa.setBorder(BorderFactory.createTitledBorder("Conversion de unidades de masa."));
		panelTemperatura.setBorder(BorderFactory.createTitledBorder("Conversion de unidades de temperatura."));
		panelBorrado.setBorder(BorderFactory.createTitledBorder("Borrador."));

		panelComplejo.add(panelDistancia);
		panelComplejo.add(panelMasa);
		panelComplejo.add(panelTemperatura);
		panelComplejo.add(panelBorrado);

		add(panelComplejo);
	}
}