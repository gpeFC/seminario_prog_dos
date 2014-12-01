/******************************************************************************
 * UAEM, Facultad de Ciencias
 * Seminario de Programacion II
 * Emanuel GP
 *
 * Proyecto: Red Neuronal Artificial: Perceptron Multicapa con Retropropagacion
 ******************************************************************************/

public class CapaNeuronal{
	private int[] funciones;		// Indicador de funcion de activacion por neurona.
	private double[] delthas;		// Delthas calculados de cada neurona.
	private double[] salidas;		// Salidas obtenidas de cada neurona.
	private double[] entradas;		// Entradas para cada neurona.
	private double[][] antiguos;	// Pesos anteriores de cada neurona.
	private Neurona[] neuronas;		// Neuronas de la capa.

	/** Constructor para inicializar el objeto 'capa neuronal'. */
	public CapaNeuronal(int numNeurs, int numArgs){
		this.entradas = new double[numArgs];
		for(int i=0; i<numArgs; i++)
			this.entradas[i] = 0.0;
		this.funciones = new int[numNeurs];
		this.delthas = new double[numNeurs];
		this.salidas = new double[numNeurs];
		this.antiguos = new double[numNeurs][numArgs];
		this.neuronas = new Neurona[numNeurs];
		for(int i=0; i<numNeurs; i++){
			this.funciones[i] = 0;
			this.delthas[i] = 0.0;
			this.salidas[i] = 0.0;
			this.neuronas[i] = new Neurona(numArgs);
			for(int j=0; j<numArgs; j++)
				this.antiguos[i][j] = 0.0;
		}
	}

	public void establecerFunciones(int[] funciones){
		this.funciones = funciones;
	}

	public void establecerEntrada(double[] entradas){
		this.entradas = entradas;
	}

	public void establecerAlphas(double alpha){
		for(int i=0; i<this.neuronas.length; i++)
			this.neuronas[i].establecerAlpha(alpha);
	}

	public void establecerAlphas(){
		double alpha=0.0;
		for(int i=0; i<this.neuronas.length; i++){
			do{
				alpha = (Math.random()*10 + 1)/10.0;
			}while(alpha == 0.0);
			this.neuronas[i].establecerAlpha(alpha);
		}
	}

	public int[] obtenerFunciones(){
		return this.funciones;
	}

	public double[] obtenerDelthas(){
		return this.delthas;
	}

	public double[] obtenerSalidas(){
		return this.salidas;
	}

	public double[][] obtenerPesosActuales(){
		double[][] pesos = new double[this.neuronas.length][this.entradas.length];
		for(int i=0; i<this.neuronas.length; i++)
			pesos[i] =this.neuronas[i].obtenerPesos();
		return pesos;
	}

	public double[][] obtenerPesosAntiguos(){
		return this.antiguos;
	}

	public Neurona[] obtenerNeuronas(){
		return this.neuronas;
	}

	public void actualizarAlphas(){
	}

	/** Método para actualizar el valor del umbral\bias de cada una de las neuronas de la capa.(Simple) */
	public void actualizarBiases(int indice, double error){
		this.neuronas[indice].establecerUmbral(this.neuronas[indice].obtenerBias() + (this.neuronas[indice].obtenerAlpha()*error));
	}

	/** Método para actualizar el valor del umbral\bias de cada una de las neuronas de la capa.(Multicapa) */
	public void actualizarBiases(){
		double biasActual, biasNuevo=0.0;
		for(int i=0; i<this.neuronas.length; i++){
			biasActual = this.neuronas[i].obtenerBias();
			biasNuevo = biasActual + (this.neuronas[i].obtenerAlpha() * this.delthas[i]);
			System.out.printf("\nUmb: (%f) = (%f) + [(%f)*(%f)]\n", biasNuevo, biasActual, this.neuronas[i].obtenerAlpha(), this.delthas[i]);
			this.neuronas[i].establecerUmbral(biasNuevo);
		}
	}

	/** Método para actualizar el valor de los pesos sinapticos de cada una de las neuronas de la capa.(Simple) */
	public void actualizarPesos(int indice, double error){
		double[] pesosActuales;
		double[] pesosNuevos = new double[this.entradas.length];
		pesosActuales = this.neuronas[indice].obtenerPesos();
		for(int j=0; j<this.entradas.length; j++)
			pesosNuevos[j] = pesosActuales[j] + (this.neuronas[indice].obtenerAlpha()*error*this.entradas[j]);
		this.neuronas[indice].establecerPesos(pesosNuevos);
	}

	/** Método para actualizar el valor de los pesos sinapticos de cada una de las neuronas de la capa.(Multicapa) */
	public void actualizarPesos(double eta, int indice){
		double[] pesosActuales;
		double[] pesosNuevos = new double[this.entradas.length];
		for(int i=0; i<this.neuronas.length; i++){
			pesosActuales = this.neuronas[i].obtenerPesos();
			if(indice == 1){
				for(int j=0; j<this.entradas.length; j++)
					pesosNuevos[j] = pesosActuales[j] + (this.neuronas[i].obtenerAlpha() * this.delthas[i] * this.entradas[j]);
				this.neuronas[i].establecerPesos(pesosNuevos);
			}
			else if(indice == 2){
				for(int j=0; j<this.entradas.length; j++){
					pesosNuevos[j] = pesosActuales[j] + (this.neuronas[i].obtenerAlpha() * this.delthas[i] * this.entradas[j]);
					pesosNuevos[j] = pesosNuevos[j] + (eta * this.antiguos[i][j]);
					this.antiguos[i][j] = pesosActuales[j] - pesosNuevos[j];
				}
				this.neuronas[i].establecerPesos(pesosNuevos);
			}
		}
	}

	/** Método para calcular y establecer el deltha de cada neurona de la capa de salida. */
	public void calcularDelthas(double[] errores){
		for(int i=0; i<this.neuronas.length; i++){
			if(this.funciones[i] == 1)
				this.delthas[i] = errores[i] * Activacion.derivadaFuncionIdentidad(ReglaPropagacion.sumaPonderada(this.neuronas[i].obtenerBias(), this.entradas, this.neuronas[i].obtenerPesos()));
			else if(this.funciones[i] == 2)
				this.delthas[i] = errores[i] * Activacion.derivadaFuncionLogistica(ReglaPropagacion.sumaPonderada(this.neuronas[i].obtenerBias(), this.entradas, this.neuronas[i].obtenerPesos()));
			else if(this.funciones[i] == 3)
				this.delthas[i] = errores[i] * Activacion.derivadaFuncionTangencial(ReglaPropagacion.sumaPonderada(this.neuronas[i].obtenerBias(), this.entradas, this.neuronas[i].obtenerPesos()));
			else if(this.funciones[i] == 4)
				this.delthas[i] = errores[i] * Activacion.derivadaFuncionHiperbolica(ReglaPropagacion.sumaPonderada(this.neuronas[i].obtenerBias(), this.entradas, this.neuronas[i].obtenerPesos()));
		}
	}

	/** Método para calcular y establecer el deltha de cada neurona de las capas ocultas. */
	public void calcularDelthas(double[] deltas, Neurona[] neuronas){
		double sumaDeltha, pesos[];
		for(int i=0; i<this.neuronas.length; i++){
			sumaDeltha = 0.0;
			for(int j=0; j<neuronas.length; j++){
				pesos = neuronas[j].obtenerPesos();
				sumaDeltha = sumaDeltha + (deltas[j]*pesos[i]);
			}
			if(this.funciones[i] == 1)
				this.delthas[i] = Activacion.derivadaFuncionIdentidad(ReglaPropagacion.sumaPonderada(this.neuronas[i].obtenerBias(), this.entradas, this.neuronas[i].obtenerPesos()))*sumaDeltha;
			else if(this.funciones[i] == 2)
				this.delthas[i] = Activacion.derivadaFuncionLogistica(ReglaPropagacion.sumaPonderada(this.neuronas[i].obtenerBias(), this.entradas, this.neuronas[i].obtenerPesos()))*sumaDeltha;
			else if(this.funciones[i] == 3)
				this.delthas[i] = Activacion.derivadaFuncionTangencial(ReglaPropagacion.sumaPonderada(this.neuronas[i].obtenerBias(), this.entradas, this.neuronas[i].obtenerPesos()))*sumaDeltha;
			else if(this.funciones[i] == 4)
				this.delthas[i] = Activacion.derivadaFuncionHiperbolica(ReglaPropagacion.sumaPonderada(this.neuronas[i].obtenerBias(), this.entradas, this.neuronas[i].obtenerPesos()))*sumaDeltha;
		}
	}

	/** Método para calcular y establecer la salida de cada neurona de la capa en un mismo arreglo. */
	public void calcularSalidas(){
		for(int i=0; i<this.neuronas.length; i++){
			this.neuronas[i].calcularSalida(this.funciones[i], this.entradas);
			this.salidas[i] = this.neuronas[i].obtenerSalida();
		}
	}

	public void calcularIncremento(int indice, double[] pesosPrevios, double[] pesosActuales){
		for(int i=0; i<pesosPrevios.length; i++)
			this.antiguos[indice][i] = pesosPrevios[i] - pesosActuales[i];
	}

	public void mostrarDatosCapa(){
		double[] pesos;
		for(int i=0; i<neuronas.length; i++){
			System.out.printf("\nNeurona (%d) {", i+1);
			System.out.printf("Alpha:(%f) |", neuronas[i].obtenerAlpha());
			System.out.printf(" Umbral:(%f) |", neuronas[i].obtenerBias());
			pesos = neuronas[i].obtenerPesos();
			System.out.printf(" Pesos:[");
			for(int j=0; j<pesos.length; j++)
				System.out.printf("(%f)", pesos[j]);
			System.out.printf("]}");
		}
	}
}
