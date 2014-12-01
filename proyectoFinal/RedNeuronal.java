/******************************************************************************
 * UAEM, Facultad de Ciencias
 * Seminario de Programacion II
 * Emanuel GP
 *
 * Proyecto: Red Neuronal Artificial: Perceptron Multicapa con Retropropagacion
 ******************************************************************************/

import java.util.ArrayList;

public class RedNeuronal{
	private String nombre;
	private String configuracionAlphas;
	private String configuracionFunciones;
	private ArrayList<CapaNeuronal> redNeuronal;

	public RedNeuronal(String nombre, String configAlphas, String configFunciones){
		this.nombre = nombre;
		this.configuracionAlphas = configAlphas;
		this.configuracionFunciones = configFunciones;
		this.redNeuronal = null;
	}

	public String obtenerNombreRed(){
		return this.nombre;
	}

	public ArrayList<CapaNeuronal> obtenerRedNeuronal(){
		return this.redNeuronal;
	}

	public void establecerNombreRed(String nombre){
		this.nombre = nombre;
	}

	public void establecerConfiguracionAlphas(String configuracionAlphas){
		this.configuracionAlphas = configuracionAlphas;
	}

	public void establecerConfiguracionAlphas(int indice){
		double alpha=0.0;
		CapaNeuronal capa;
		if(indice == 1){
			do{
				alpha = (Math.random()*10 + 1)/10.0;
			}while(alpha == 0.0);
			for(int i=0; i<this.redNeuronal.size(); i++){
				capa = this.redNeuronal.get(i);
				capa.establecerAlphas(alpha);
			}
		}
		else if(indice == 2){
			for(int i=0; i<this.redNeuronal.size(); i++){
				capa = this.redNeuronal.get(i);
				do{
					alpha = (Math.random()*10 + 1)/10.0;
				}while(alpha == 0.0);
				capa.establecerAlphas(alpha);
			}
		}
		else if(indice == 3){
			for(int i=0; i<this.redNeuronal.size(); i++){
				capa = this.redNeuronal.get(i);
				capa.establecerAlphas();
			}
		}
	}

	public void establecerConfiguracionFunciones(String configuracionFunciones){
		this.configuracionFunciones = configuracionFunciones;
	}

	public void establecerConfiguracionFunciones(int funcion, int numNeurs){
		int[] funciones = new int[numNeurs];
		CapaNeuronal capaNeuronal = this.redNeuronal.get(0);
		for(int i=0; i<numNeurs; i++)
			funciones[i] = funcion;
		capaNeuronal.establecerFunciones(funciones);
	}

	public void establecerConfiguracionFunciones(int funcion, int[] numNeursCapa){
		int[] funciones;
		CapaNeuronal capa;
		for(int i=0; i<numNeursCapa.length; i++){
			capa = this.redNeuronal.get(i);
			funciones = new int[numNeursCapa[i]];
			for(int j=0; j<numNeursCapa[i]; j++)
				funciones[j] = funcion;
			capa.establecerFunciones(funciones);
		}
	}

	public void establecerConfiguracionFunciones(int funcionSalida, int funcionOcultas, int[] numNeursCapa){
		int[] funciones;
		CapaNeuronal capa;
		for(int i=0; i<numNeursCapa.length; i++){
			capa = this.redNeuronal.get(i);
			funciones = new int[numNeursCapa[i]];
			if(i == numNeursCapa.length-1){
				for(int j=0; j<numNeursCapa[i]; j++)
					funciones[j] = funcionSalida;
				capa.establecerFunciones(funciones);
			}
			else{
				for(int j=0; j<numNeursCapa[i]; j++)
					funciones[j] = funcionOcultas;
				capa.establecerFunciones(funciones);
			}
		}
	}

	public void establecerConfiguracionFunciones(int[] funciones, int indice){
		CapaNeuronal capa;
		capa = this.redNeuronal.get(indice);
		capa.establecerFunciones(funciones);
	}

	public void establecerRedNeuronal(int numArgs, int numCapas, int[] numNeursCapa){
		CapaNeuronal capaNeuronal;
		this.redNeuronal = new ArrayList<CapaNeuronal>(numCapas);
		for(int i=0; i<numCapas; i++){
			if(i == 0){
				capaNeuronal = new CapaNeuronal(numNeursCapa[i], numArgs);
				this.redNeuronal.add(capaNeuronal);
			}
			else{
				capaNeuronal = new CapaNeuronal(numNeursCapa[i], numNeursCapa[i-1]);
				this.redNeuronal.add(capaNeuronal);
			}
		}
	}

	public double[] aplicarRedNeuronal(double[][] entradas){
		double salida, salidas[], temporal[];
		salidas = new double[entradas.length];
		for(int i=0; i<entradas.length; i++){
			realizarPropagacion(entradas[i]);
			temporal = this.redNeuronal.get(this.redNeuronal.size()-1).obtenerSalidas();
			salida = 0.0;
			for(int j=0; j<temporal.length; j++)
				salida = salida + temporal[j];
			salida = salida / ((double)temporal.length);
			salidas[i] = salida;
		}
		return salidas;
	}

	public void realizarPropagacion(double[] entradas){
		CapaNeuronal capa, previa;
		for(int i=0; i<this.redNeuronal.size(); i++){
			capa = this.redNeuronal.get(i);
			if(i == 0){
				capa.establecerEntrada(entradas);
				capa.calcularSalidas();
			}
			else{
				previa = this.redNeuronal.get(i-1);
				capa.establecerEntrada(previa.obtenerSalidas());
				capa.calcularSalidas();
			}
		}
	}

	public void realizarRetroPropagacion(double salida){
		double[] salidas, errores;
		Neurona[] neuronas;
		CapaNeuronal capa, previa;
		for(int i=this.redNeuronal.size()-1; i>=0; i--){
			capa = this.redNeuronal.get(i);
			if(i == this.redNeuronal.size()-1){
				salidas = capa.obtenerSalidas();
				errores = new double[salidas.length];
				for(int j=0; j<salidas.length; j++)
					errores[j] = salida - salidas[j];
				capa.calcularDelthas(errores);
			}
			else{
				previa = this.redNeuronal.get(i+1);
				errores = previa.obtenerDelthas();
				neuronas = previa.obtenerNeuronas();
				capa.calcularDelthas(errores, neuronas);
			}
		}
	}

	public void actualizarParametrosNeuronales(int indice, double eta){
		CapaNeuronal capa;
		for(int i=this.redNeuronal.size()-1; i>=0; i--){
			capa = this.redNeuronal.get(i);
			capa.actualizarBiases();
			capa.actualizarPesos(eta, indice);
		}
	}

	public void mostrarDatosPerceptron(){
		CapaNeuronal capa;
		System.out.printf("\nNombre:                  %s", this.nombre);
		System.out.printf("\nConfiguracion/TDA:       %s", this.configuracionAlphas);
		System.out.printf("\nConfiguracion/Funciones: %s", this.configuracionFunciones);
		for(int i=0; i<this.redNeuronal.size(); i++){
			capa = this.redNeuronal.get(i);
			System.out.printf("\nCapa (%d)", i+1);
			capa.mostrarDatosCapa();
		}
	}
}