import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FramesEvents3 extends JFrame{

	private double masaDesde;
	private double masaHacia;
	private double distanciaDesde;
	private double distanciaHacia;
	private double temperaturaDesde;
	private double temperaturaHacia;

	private String MASA[] = {"Convertir", "Miligramos", "Gramos", "Kilogramos", "Tonelada"};
	private String DISTANCIA[] = {"Convertir", "Milimetros", "Centimetros", "Metros", "Kilometros"};
	private String TEMPERATURA[] = {"Convertir", "Celsius", "Farenheit", "Kelvin"};

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

		masaDesdeJL = new JLabel("De:");
		masaDesdeJL.setToolTipText("Etiqueta 'De' masa.");
		masaHaciaJL = new JLabel("A:");
		masaHaciaJL.setToolTipText("Etiqueta 'A' masa.");
		distanciaDesdeJL = new JLabel("De:");
		distanciaDesdeJL.setToolTipText("Etiqueta 'De' distancia.");
		distanciaHaciaJL = new JLabel("A:");
		distanciaHaciaJL.setToolTipText("Etiqueta 'A' distancia.");
		temperaturaDesdeJL = new JLabel("De:");
		temperaturaDesdeJL.setToolTipText("Etiqueta 'De' temperatura.");
		temperaturaHaciaJL = new JLabel("A:");
		temperaturaHaciaJL.setToolTipText("Etiqueta 'A' temperatura.");

		masaDesdeJTF = new JTextField(10);
		masaDesdeJTF.setToolTipText("JTextField 'Entrada' masa.");
		masaHaciaJTF = new JTextField(10);
		masaHaciaJTF.setToolTipText("JTextField 'Salida' masa.");
		distanciaDesdeJTF = new JTextField(10);
		distanciaDesdeJTF.setToolTipText("JTextField 'Entrada' distancia.");
		distanciaHaciaJTF = new JTextField(10);
		distanciaHaciaJTF.setToolTipText("JTextField 'Salida' distancia.");
		temperaturaDesdeJTF = new JTextField(10);
		temperaturaDesdeJTF.setToolTipText("JTextField 'Entrada' temperatura.");
		temperaturaHaciaJTF = new JTextField(10);
		temperaturaHaciaJTF.setToolTipText("JTextField 'Salida' temperatura.");

		ManejadorBotonesConversion manejadorBotones = new ManejadorBotonesConversion();
		borrarJB = new JButton("Borrar");
		borrarJB.setToolTipText("Boton de borrado de datos");
		borrarJB.addActionListener(manejadorBotones);
		convertirMasaJB = new JButton("Convertir");
		convertirMasaJB.setToolTipText("Conversion de escalas de masa");
		convertirMasaJB.addActionListener(manejadorBotones);
		convertirDistanciaJB = new JButton("Convertir");
		convertirDistanciaJB.setToolTipText("Conversion de escalas de distancia");
		convertirDistanciaJB.addActionListener(manejadorBotones);
		convertirTemperaturaJB = new JButton("Convertir");
		convertirTemperaturaJB.setToolTipText("Conversion de escalas de temperatura");
		convertirTemperaturaJB.addActionListener(manejadorBotones);

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

	private class ManejadorBotonesConversion implements ActionListener{
		public void actionPerformed(ActionEvent evento){
			if(evento.getSource() == convertirDistanciaJB){
				int indiceE = distanciaDesdeJCB.getSelectedIndex();
				int indiceS = distanciaHaciaJCB.getSelectedIndex();
				try{
					distanciaDesde = Double.parseDouble(distanciaDesdeJTF.getText());
					if(indiceE==0 || indiceS==0){
						JOptionPane.showMessageDialog(null, "Escala de conversion incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else if(indiceE == indiceS){
						int opcion = JOptionPane.showConfirmDialog(FramesEvents3.this, "La escala de conversion entrada-salida es igual.\n¿Desea continuar...?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if(opcion == JOptionPane.YES_OPTION)
							distanciaHaciaJTF.setText(String.format("%s", distanciaDesde));
					}
					else if(indiceE==1 && indiceS==2){
						distanciaHaciaJTF.setText(String.format("%s", (distanciaDesde/10.0)));
					}
					else if(indiceE==1 && indiceS==3){
						distanciaHaciaJTF.setText(String.format("%s", (distanciaDesde/1000.0)));
					}
					else if(indiceE==1 && indiceS==4){
						distanciaHaciaJTF.setText(String.format("%s", (distanciaDesde/1000000.0)));
					}
					else if(indiceE==2 && indiceS==1){
						distanciaHaciaJTF.setText(String.format("%s", (distanciaDesde*10.0)));
					}
					else if(indiceE==2 && indiceS==3){
						distanciaHaciaJTF.setText(String.format("%s", (distanciaDesde/100.0)));
					}
					else if(indiceE==2 && indiceS==4){
						distanciaHaciaJTF.setText(String.format("%s", (distanciaDesde/100000.0)));
					}
					else if(indiceE==3 && indiceS==1){
						distanciaHaciaJTF.setText(String.format("%s", (distanciaDesde*1000.0)));
					}
					else if(indiceE==3 && indiceS==2){
						distanciaHaciaJTF.setText(String.format("%s", (distanciaDesde*100.0)));
					}
					else if(indiceE==3 && indiceS==4){
						distanciaHaciaJTF.setText(String.format("%s", (distanciaDesde/1000.0)));
					}
					else if(indiceE==4 && indiceS==1){
						distanciaHaciaJTF.setText(String.format("%s", (distanciaDesde*1000000.0)));
					}
					else if(indiceE==4 && indiceS==2){
						distanciaHaciaJTF.setText(String.format("%s", (distanciaDesde*100000.0)));
					}
					else if(indiceE==4 && indiceS==3){
						distanciaHaciaJTF.setText(String.format("%s", (distanciaDesde*1000.0)));
					}
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Dato incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if(evento.getSource() == convertirMasaJB){
				int indiceE = masaDesdeJCB.getSelectedIndex();
				int indiceS = masaHaciaJCB.getSelectedIndex();
				try{
					masaDesde = Double.parseDouble(masaDesdeJTF.getText());
					if(indiceE==0 || indiceS==0){
						JOptionPane.showMessageDialog(null, "Escala de conversion incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else if(indiceE == indiceS){
						int opcion = JOptionPane.showConfirmDialog(FramesEvents3.this, "La escala de conversion entrada-salida es igual.\n¿Desea continuar...?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if(opcion == JOptionPane.YES_OPTION)
							masaHaciaJTF.setText(String.format("%s", masaDesde));
					}
					else if(indiceE==1 && indiceS==2){
						masaHaciaJTF.setText(String.format("%s", (masaDesde/1000.0)));
					}
					else if(indiceE==1 && indiceS==3){
						masaHaciaJTF.setText(String.format("%s", (masaDesde/1000000.0)));
					}
					else if(indiceE==1 && indiceS==4){
						masaHaciaJTF.setText(String.format("%s", (masaDesde/1000000000.0)));
					}
					else if(indiceE==2 && indiceS==1){
						masaHaciaJTF.setText(String.format("%s", (masaDesde*1000.0)));
					}
					else if(indiceE==2 && indiceS==3){
						masaHaciaJTF.setText(String.format("%s", (masaDesde/1000.0)));
					}
					else if(indiceE==2 && indiceS==4){
						masaHaciaJTF.setText(String.format("%s", (masaDesde/1000000.0)));
					}
					else if(indiceE==3 && indiceS==1){
						masaHaciaJTF.setText(String.format("%s", (masaDesde*1000000.0)));
					}
					else if(indiceE==3 && indiceS==2){
						masaHaciaJTF.setText(String.format("%s", (masaDesde*1000.0)));
					}
					else if(indiceE==3 && indiceS==4){
						masaHaciaJTF.setText(String.format("%s", (masaDesde/1000.0)));
					}
					else if(indiceE==4 && indiceS==1){
						masaHaciaJTF.setText(String.format("%s", (masaDesde*1000000000.0)));
					}
					else if(indiceE==4 && indiceS==2){
						masaHaciaJTF.setText(String.format("%s", (masaDesde*1000000.0)));
					}
					else if(indiceE==4 && indiceS==3){
						masaHaciaJTF.setText(String.format("%s", (masaDesde*1000.0)));
					}
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Dato incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if(evento.getSource() == convertirTemperaturaJB){
				int indiceE = temperaturaDesdeJCB.getSelectedIndex();
				int indiceS = temperaturaHaciaJCB.getSelectedIndex();
				try{
					temperaturaDesde = Double.parseDouble(temperaturaDesdeJTF.getText());
					if(indiceE==0 || indiceS==0){
						JOptionPane.showMessageDialog(null, "Escala de conversion incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else if(indiceE == indiceS){
						int opcion = JOptionPane.showConfirmDialog(FramesEvents3.this, "La escala de conversion entrada-salida es igual.\n¿Desea continuar...?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if(opcion == JOptionPane.YES_OPTION)
							temperaturaHaciaJTF.setText(String.format("%s", temperaturaDesde));
					}
					else if(indiceE==1 && indiceS==2){
						temperaturaHaciaJTF.setText(String.format("%s", (32.0+(1.8*temperaturaDesde))));
					}
					else if(indiceE==1 && indiceS==3){
						temperaturaHaciaJTF.setText(String.format("%s", (temperaturaDesde+273.0)));
					}
					else if(indiceE==2 && indiceS==1){
						temperaturaHaciaJTF.setText(String.format("%s", ((temperaturaDesde-32.0)/1.8)));
					}
					else if(indiceE==2 && indiceS==3){
						temperaturaHaciaJTF.setText(String.format("%s", (((temperaturaDesde-32.0)/1.8)+273.0)));
					}
					else if(indiceE==3 && indiceS==1){
						temperaturaHaciaJTF.setText(String.format("%s", (temperaturaDesde-273.0)));
					}
					else if(indiceE==3 && indiceS==2){
						temperaturaHaciaJTF.setText(String.format("%s", (((temperaturaDesde-273)*1.8)+32.0)));
					}
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Dato incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if(evento.getSource() == borrarJB){
				distanciaDesdeJTF.setText("");
				distanciaDesdeJCB.setSelectedIndex(0);
				distanciaHaciaJCB.setSelectedIndex(0);
				distanciaHaciaJTF.setText("");
				masaDesdeJTF.setText("");
				masaDesdeJCB.setSelectedIndex(0);
				masaDesdeJCB.setSelectedIndex(0);
				masaHaciaJTF.setText("");
				temperaturaDesdeJTF.setText("");
				temperaturaDesdeJCB.setSelectedIndex(0);
				temperaturaDesdeJCB.setSelectedIndex(0);
				temperaturaHaciaJTF.setText("");
			}
		}
	}
}