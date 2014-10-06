import java.util.Random;

public class ArregloSimple{

	private final int arreglo[]; // el arreglo entero compartido
	private int indiceEscritura = 0; // índice del siguiente elemento a escribir
	private final static Random generador = new Random();

	// construye un objeto ArregloSimple de un tamaño dado
	public ArregloSimple(int tamanio){
		arreglo = new int[ tamanio ];
	} // fin del constructor

	// agrega un valor al arreglo compartido
	public synchronized void agregar(int valor){
		int posicion = indiceEscritura; // almacena el índice de escritura

		try{
			Thread.sleep( generador.nextInt( 500 ) );
		}
		catch(InterruptedException ex){
			ex.printStackTrace();
		}

		// coloca el valor en el elemento apropiado
		arreglo[ posicion ] = valor;
		
		System.out.printf( "%s escribio %2d en el elemento %d.\n",
		
		Thread.currentThread().getName(), valor, posicion );
		
		++indiceEscritura; // incrementa el índice del siguiente elemento a escribir
		
		System.out.printf( "Siguiente indice de escritura: %d\n", indiceEscritura );
	}

	// se utiliza para imprimir el contenido del arreglo entero compartido
	public String toString(){
		String cadenaArreglo = "\nContenido de ArregloSimple:\n";

		for (int i = 0; i < arreglo.length; i++)
			cadenaArreglo += arreglo[ i ] + " ";

		return cadenaArreglo;
	} 
}