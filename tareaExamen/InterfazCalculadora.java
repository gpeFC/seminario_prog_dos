import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Stack;
import java.util.EmptyStackException;
import java.util.PriorityQueue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfazCalculadora extends JFrame{
	private final String NUMEROS[] = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ".", "="};
	private final String OPERACIONES[] = {"C", "Rz", "%", "^", "*", "/", "+", "-"};										

	private JButton botonesNumeros[];
	private JButton botonesOperaciones[];

	private JTextArea entradaDeDatos;
	private JTextField salidaDeMensajes;

	private GridLayout rejillaNumeros;
	private GridLayout rejillaOperaciones;

	private JPanel panelDeDatos;
	private JPanel panelDeBotones;
	private JPanel panelDePaneles;
	private JPanel panelDeBotonesNumeros;
	private JPanel panelDeBotonesOperaciones;

	public InterfazCalculadora(){
		super("Calculadora");

		entradaDeDatos = new JTextArea(2,33);
		salidaDeMensajes = new JTextField(33);
		salidaDeMensajes.setEditable(false);

		botonesNumeros = new JButton[NUMEROS.length];
		botonesOperaciones = new JButton[OPERACIONES.length];

		rejillaNumeros = new GridLayout(4,3,5,5);
		rejillaOperaciones = new GridLayout(4,2,5,5);

		panelDeDatos = new JPanel();
		panelDeBotones = new JPanel();
		panelDePaneles = new JPanel();
		panelDeBotonesNumeros = new JPanel();
		panelDeBotonesOperaciones = new JPanel();

		ManejadorBotones manejador = new ManejadorBotones();

		for(int cuenta = 0; cuenta < NUMEROS.length; cuenta++){
			botonesNumeros[cuenta] = new JButton(NUMEROS[cuenta]);
			panelDeBotonesNumeros.add(botonesNumeros[cuenta]);
			botonesNumeros[cuenta].addActionListener(manejador);
		}

		for(int cuenta = 0; cuenta < OPERACIONES.length; cuenta++){
			botonesOperaciones[cuenta] = new JButton(OPERACIONES[cuenta]);
			panelDeBotonesOperaciones.add(botonesOperaciones[cuenta]);
			botonesOperaciones[cuenta].addActionListener(manejador);
		}

		panelDeBotonesNumeros.setLayout(rejillaNumeros);
		panelDeBotonesNumeros.setPreferredSize(new Dimension(240,180));
		panelDeBotonesOperaciones.setLayout(rejillaOperaciones);
		panelDeBotonesOperaciones.setPreferredSize(new Dimension(120,180));

		panelDeDatos.add(new JScrollPane(entradaDeDatos));
		panelDeDatos.add(salidaDeMensajes);

		panelDeBotones.add(panelDeBotonesNumeros);
		panelDeBotones.add(panelDeBotonesOperaciones);

		add(panelDeDatos);
		add(panelDeBotones, BorderLayout.SOUTH);
	}

	private boolean revisaPrecedencia(String token1, String token2){
		boolean valorPrescd = true;
		if( ((token1.equals("+")) || (token1.equals("-"))) && ((token2.equals("+")) || (token2.equals("-"))) ){
			valorPrescd = true;
		}
		else if( ((token1.equals("+")) || (token1.equals("-"))) && ((token2.equals("*")) || (token2.equals("/")) || (token2.equals("%"))) ){
			valorPrescd = false;
		}
		else if( ((token1.equals("+")) || (token1.equals("-"))) && ((token2.equals("R")) || (token2.equals("^"))) ){
			valorPrescd = false;
		}
		else if( ((token1.equals("*")) || (token1.equals("/")) || (token1.equals("%"))) && ( (token2.equals("+")) || (token2.equals("-")) ) ){
			valorPrescd = true;
		}
		else if( ((token1.equals("*")) || (token1.equals("/")) || (token1.equals("%"))) && ((token2.equals("*")) || (token2.equals("/")) || (token2.equals("%"))) ){
			valorPrescd = true;
		}
		else if( ((token1.equals("*")) || (token1.equals("/")) || (token1.equals("%"))) && ( (token2.equals("R")) || (token2.equals("^")) ) ){
			valorPrescd = false;
		}
		else if( (token1.equals("R")) || (token1.equals("^")) ){
			valorPrescd = true;
		}
		return valorPrescd;
	}

	private double resuelveExpresion(String[] expresionFormada){
		double resultadoExpresion;
		double operando1, operando2;
		String termino = "";
		String tokenPila = "";
		ArrayList<String> listaTokens = new ArrayList<String>();
		ArrayList<String> listaTemporal = new ArrayList<String>();
		Stack<Double> pilaResultado = new Stack<Double>();
		Stack<String> pilaTemporal = new Stack<String>();

		for(int i=0; i<expresionFormada.length; i++)
			listaTemporal.add(expresionFormada[i]);

		for(int i=0; i<listaTemporal.size(); i++){
			termino = listaTemporal.get(i);
			try{
				double numero = Double.parseDouble(termino);
				listaTokens.add(termino);
			}
			catch(NumberFormatException e){
				if(pilaTemporal.isEmpty()){
					pilaTemporal.push(termino);
				}
				else{
					while(!(pilaTemporal.isEmpty()) && revisaPrecedencia(pilaTemporal.peek(), termino)){
						tokenPila = pilaTemporal.pop();
						listaTokens.add(tokenPila);
					}
					pilaTemporal.push(termino);
				}
			}
		}
		while(!(pilaTemporal.isEmpty())){
			tokenPila = pilaTemporal.pop();
			listaTokens.add(tokenPila);
		}

		for(int i=0; i<listaTokens.size(); i++){
			String itemActual = listaTokens.get(i);
			try{
				double numero = Double.parseDouble(itemActual);
				pilaResultado.push(numero);
			}
			catch(NumberFormatException e){
				resultadoExpresion = 0.0;
				if(itemActual.equals("R")){
					operando1 = pilaResultado.pop();
					resultadoExpresion = Math.sqrt(operando1);
					pilaResultado.push(resultadoExpresion);
				}
				else{
					operando2 = pilaResultado.pop();
					operando1 = pilaResultado.pop();
					if(itemActual.equals("+")){
						resultadoExpresion = operando1 + operando2;
						pilaResultado.push(resultadoExpresion);
					}
					else if(itemActual.equals("-")){
						if(operando1 < operando2){
							resultadoExpresion = operando1 - operando2;
							resultadoExpresion = (-1) * resultadoExpresion;
						}
						else{
							resultadoExpresion = operando1 - operando2;
						}
						pilaResultado.push(resultadoExpresion);
					}
					else if(itemActual.equals("*")){
						resultadoExpresion = operando1 * operando2;
						pilaResultado.push(resultadoExpresion);
					}
					else if(itemActual.equals("/")){
						resultadoExpresion = operando1 / operando2;
						pilaResultado.push(resultadoExpresion);
					}
					else if(itemActual.equals("%")){
						resultadoExpresion = operando1 % operando2;
						pilaResultado.push(resultadoExpresion);
					}
					else if(itemActual.equals("^")){
						resultadoExpresion = Math.pow(operando1, operando2);
						pilaResultado.push(resultadoExpresion);
					}
				}
			}
		}

		return pilaResultado.pop();
	}

	private class ManejadorBotones implements ActionListener{
		public void actionPerformed(ActionEvent evento){
			if(evento.getSource() == botonesNumeros[0]){
				entradaDeDatos.setText(String.format("%s", (entradaDeDatos.getText()+"7")));
			}
			else if(evento.getSource() == botonesNumeros[1]){
				entradaDeDatos.setText(String.format("%s", (entradaDeDatos.getText()+"8")));
			}
			else if(evento.getSource() == botonesNumeros[2]){
				entradaDeDatos.setText(String.format("%s", (entradaDeDatos.getText()+"9")));
			}
			else if(evento.getSource() == botonesNumeros[3]){
				entradaDeDatos.setText(String.format("%s", (entradaDeDatos.getText()+"4")));
			}
			else if(evento.getSource() == botonesNumeros[4]){
				entradaDeDatos.setText(String.format("%s", (entradaDeDatos.getText()+"5")));
			}
			else if(evento.getSource() == botonesNumeros[5]){
				entradaDeDatos.setText(String.format("%s", (entradaDeDatos.getText()+"6")));
			}
			else if(evento.getSource() == botonesNumeros[6]){
				entradaDeDatos.setText(String.format("%s", (entradaDeDatos.getText()+"1")));
			}
			else if(evento.getSource() == botonesNumeros[7]){
				entradaDeDatos.setText(String.format("%s", (entradaDeDatos.getText()+"2")));
			}
			else if(evento.getSource() == botonesNumeros[8]){
				entradaDeDatos.setText(String.format("%s", (entradaDeDatos.getText()+"3")));
			}
			else if(evento.getSource() == botonesNumeros[9]){
				entradaDeDatos.setText(String.format("%s", (entradaDeDatos.getText()+"0")));
			}
			else if(evento.getSource() == botonesNumeros[10]){
				entradaDeDatos.setText(String.format("%s", (entradaDeDatos.getText()+".")));
			}
			else if(evento.getSource() == botonesNumeros[11]){
				String expresionFormada = String.format("%s", entradaDeDatos.getText());
				String expresionRegular = "([+|-]?{1}[0-9]+)|([[+|-]?{1}[0-9]+[+|-|*|/|%|^|R]{1}[0-9]+]*)";
				
				if(expresionFormada.matches(expresionRegular)){
					salidaDeMensajes.setText("");
					StringTokenizer tokens = new StringTokenizer(expresionFormada, expresionRegular, true);
					String arregloTokens[] = new String[tokens.countTokens()];
					
					int contador = 0;
					while(tokens.hasMoreTokens()){
						arregloTokens[contador] = tokens.nextToken(expresionRegular);
						contador++;
					}
					try{
						entradaDeDatos.setText(String.format("%s", resuelveExpresion(arregloTokens)));
					}
					catch(Exception excepcion){
						salidaDeMensajes.setText("Expresion mal formada.");
					}
				}
			}
			else if(evento.getSource() == botonesOperaciones[0]){
				entradaDeDatos.setText("");
				salidaDeMensajes.setText("");
			}
			else if(evento.getSource() == botonesOperaciones[1]){
				entradaDeDatos.setText(String.format("%s", (entradaDeDatos.getText()+"R")));
			}
			else if(evento.getSource() == botonesOperaciones[2]){
				entradaDeDatos.setText(String.format("%s", (entradaDeDatos.getText()+"%")));
			}
			else if(evento.getSource() == botonesOperaciones[3]){
				entradaDeDatos.setText(String.format("%s", (entradaDeDatos.getText()+"^")));
			}
			else if(evento.getSource() == botonesOperaciones[4]){
				entradaDeDatos.setText(String.format("%s", (entradaDeDatos.getText()+"*")));
			}
			else if(evento.getSource() == botonesOperaciones[5]){
				entradaDeDatos.setText(String.format("%s", (entradaDeDatos.getText()+"/")));
			}
			else if(evento.getSource() == botonesOperaciones[6]){
				entradaDeDatos.setText(String.format("%s", (entradaDeDatos.getText()+"+")));
			}
			else if(evento.getSource() == botonesOperaciones[7]){
				entradaDeDatos.setText(String.format("%s", (entradaDeDatos.getText()+"-")));
			}
		}
	}
}