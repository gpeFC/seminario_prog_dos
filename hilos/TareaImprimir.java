import java.util.Random;

public class TareaImprimir implements Runnable{

	private final int tiempoInactividad; // tiempo de inactividad aleatorio para el	subproceso
	private final String nombreTarea; // nombre de la tarea
	private final static Random generador = new Random();

	public TareaImprimir( String nombre ){
		nombreTarea = nombre; // establece el nombre de la tarea

		// elige un tiempo de inactividad aleatorio entre 0 y 5 segundos
		tiempoInactividad = generador.nextInt( 5000 ); // milisegundos
	}

	// el método run contiene el código que ejecutará un subproceso
	public void run(){
		try{
			System.out.printf("%s va a estar inactivo durante %d milisegundos.\n\n", nombreTarea, tiempoInactividad);
			Thread.sleep( tiempoInactividad ); // deja el subproceso inactivo
		}
		catch (InterruptedException excepcion){
			System.out.printf("%s %s\n", nombreTarea, "termino en forma prematura, debido a la interrupcion");
		}
	
		// imprime el nombre de la tarea
		System.out.printf( "%s termino su inactividad\n\n", nombreTarea );
	}
}