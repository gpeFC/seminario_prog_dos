import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


public class SubprocesoCombinado{

	public static void main(String[] args){

		System.out.println("Creacion de subprocesos");

		// crea cada subproceso con un nuevo objeto Runnable
		Thread subproceso1 = new Thread(new TareaImprimir("tarea1SP"));
		Thread subproceso2 = new Thread(new TareaImprimir("tarea2SP"));
		Thread subproceso3 = new Thread(new TareaImprimir("tarea3SP"));
				
		System.out.println( "Subprocesos creados, iniciando tareas." );
		
		// inicia los subprocesos y los coloca en el estado "en ejecución"
		subproceso1.start(); // invoca al método run de tarea1
		subproceso2.start(); // invoca al método run de tarea2
		subproceso3.start(); // invoca al método run de tarea3
		
		System.out.println( "Tareas iniciadas, main termina.\n" );

		// crea y nombra cada objeto Runnable
		TareaImprimir tarea1 = new TareaImprimir( "tarea1ES" );
		TareaImprimir tarea2 = new TareaImprimir( "tarea2ES" );
		TareaImprimir tarea3 = new TareaImprimir( "tarea3ES" );


		System.out.println( "Iniciando Executor\n" );
		
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