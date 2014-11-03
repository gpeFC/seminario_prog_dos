/******************************************************************************
 * UAEM, Facultad de Ciencias
 * Seminario de Programacion II
 * Emanuel GP
 *
 * Proyecto: Red Neuronal Artificial: Perceptron Multicapa con Retropropagacion
 ******************************************************************************/

public final class ReglaPropagacion{
	/** Regla de propagacion para redes feedforward multicapas: Suma Ponderada */
	public static double sumaPonderada(double bias, double[] entrada, double[] pesos){
		double potencial = 0.0;
		for(int i=0; i<pesos.length; i++){
			potencial = potencial + (pesos[i] * entrada[i]);
		}
		potencial = potencial + bias;
		return potencial;
	}
}
