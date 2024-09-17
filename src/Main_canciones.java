import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_canciones {

	// Lee los datos del archivo de texto original y los añade a la lista de canciones
	private static void leerArchivo(ArrayList<Cancion> lista) throws FileNotFoundException, IOException {
		File archivo;
		FileReader lector;
		BufferedReader br;
		archivo = new File("canciones.txt");
		lector = new FileReader(archivo);
		br = new BufferedReader(lector);

		String linea = "";

		while ((linea = br.readLine()) != null) {
			String[] campos = linea.split(",");
			Cancion cancion = new Cancion(campos[0], campos[1], campos[2], campos[3], campos[4]);
			lista.add(cancion);
		}

		// Cierro el lector/br
		lector.close();
		br.close();
	}

	// Serializa los objetos de la lista y los copia al nuevo archivo
	private static void copiarDatosArchivoNuevo(ArrayList<Cancion> lista) throws FileNotFoundException, IOException {
		FileOutputStream archivo2;
		ObjectOutputStream serializador;

		archivo2 = new FileOutputStream("canciones2.dat");
		serializador = new ObjectOutputStream(archivo2);

		for (Cancion x : lista) {
			serializador.writeObject(x);
		}

		serializador.close();
	}

	// Lee los datos del archivo 2 y los muestra por pantalla
	private static void leerDatos() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream archivo3=null;
		ObjectInputStream deserializador=null;
		archivo3 = new FileInputStream("canciones2.dat");
		deserializador = new ObjectInputStream(archivo3);

		while (archivo3.available() > 0) {
			Cancion cancion = (Cancion) deserializador.readObject();
			System.out.println(cancion);
			System.out.println("----------------------");
		}
		deserializador.close();

	}

	public static void main(String[] args) {
		ArrayList<Cancion> lista = new ArrayList<Cancion>();
		Scanner entrada = new Scanner(System.in);
		int opcion;
		try {
			do {
				System.out.println(
						"Seleccione la opción que desea realizar\n1-Copiar datos en un archivo nuevo\n2-Imprimir datos del archivo1 por pantalla\n3-Salir");
				opcion = Integer.parseInt(entrada.nextLine());
				switch (opcion) {
				case 1:
					leerArchivo(lista);
					copiarDatosArchivoNuevo(lista);
					break;
				case 2:
					leerDatos();
					break;
				case 3:
					System.out.println("Has salido del menú");
					break;
				default:
					System.out.println("Opción no válida");
					break;
				}
			} while (opcion != 3);

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

}