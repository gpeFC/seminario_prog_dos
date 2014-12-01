/******************************************************************************
 * UAEM, Facultad de Ciencias
 * Seminario de Programacion II
 * Emanuel GP
 *
 * Proyecto: Red Neuronal Artificial: Perceptron Multicapa con Retropropagacion
 ******************************************************************************/

public final class Activacion{
	/** Funciones de Activacion. */
    public static double identidadLineal(double potencial){
        return potencial;
    }
    public static double sigmoideLogistico(double potencial){
        return (1.0 / (1.0 + (Math.pow(Math.E, -potencial))));
    }
    public static double sigmoideTangencial(double potencial){
        return ((2.0 / (1.0 + (Math.pow(Math.E, -potencial)))) - 1.0);
    }
    public static double sigmoideHiperbolico(double potencial){
        return (((Math.pow(Math.E, potencial)) - ((Math.pow(Math.E, -potencial)))) / ((Math.pow(Math.E, potencial)) + ((Math.pow(Math.E, -potencial)))));
    }

	/** Derivadas de Funciones de Activacion. */
    public static double derivadaFuncionIdentidad(double potencial){
        return 1.0;
    }
    public static double derivadaFuncionLogistica(double potencial){
        return (Activacion.sigmoideLogistico((potencial) * (1 - Activacion.sigmoideLogistico(potencial))));
    }
    public static double derivadaFuncionTangencial(double potencial){
        return (2*(Math.pow(Math.E, -potencial))) / Math.pow((1.0 + (Math.pow(Math.E, -potencial))), 2);
    }
    public static double derivadaFuncionHiperbolica(double potencial){
        return (1 - Math.pow(Activacion.sigmoideHiperbolico(potencial), 2));
    }
}
