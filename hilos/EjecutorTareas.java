import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class EjecutorTareas{

	public static void main(String[] args){

		// crea y nombra cada objeto Runnable
		TareaImprimir tarea1 = new TareaImprimir( "tarea1" );
		TareaImprimir tarea2 = new TareaImprimir( "tarea2" );
		TareaImprimir tarea3 = new TareaImprimir( "tarea3" );

		System.out.println( "Iniciando Executor" );
		
		// crea objeto ExecutorService para administrar los subprocesos
		ExecutorService ejecutorSubprocesos = Executors.newCachedThreadPool();

		// inicia los subprocesos y los coloca en el estado ejecutable
		ejecutorSubprocesos.execute( tarea1 ); // inicia tarea1
		ejecutorSubprocesos.execute( tarea2 ); // inicia tarea2
		ejecutorSubprocesos.execute( tarea3 ); // inicia tarea3
		
		// cierra los subprocesos trabajadores cuando terminan sus tareas
		ejecutorSubprocesos.shutdown();
		System.out.println( "Tareas iniciadas, main termina.\n" );
	}
}