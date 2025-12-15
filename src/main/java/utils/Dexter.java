package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase de utilidades varias para diferentes propósitos.
 * - Manejo de excepciones.
 * - Entrada de datos desde consola.
 * - Generación de datos aleatorios.
 * - Medición de tiempo de ejecución.
 * - Lectura de archivos.
 * - Progreso visual.
 * - Validación de números primos.
 * - Generación de nombres y títulos aleatorios.
 * - Otros métodos útiles.
 */
public class Dexter {
	private static List<String> lines = new ArrayList<>();
	private static Map<Integer, String> map = new HashMap<>();
	private static int counter = 0;
	private static int characters = 0;
	private static Random r = new Random();
	private static Scanner scan = new Scanner(System.in);
	
	// Para ficheros
	public static final String SEMICOLON = ";";
	public static final String PIPE = "|";
	public static final String COMMA = ",";
	
	/**
	 * Manejo de excepciones: Imprime el tipo de excepción,
	 * la línea donde ocurrió y el mensaje asociado.
	 * @param e La excepción a manejar.
	 */
	public static void printException(Exception e) {
		System.err.println(e.getClass().getSimpleName() + " at line " 
						+ e.getStackTrace()[0].getLineNumber() + ": " + e.getMessage());
	}
	
	/**
	 * Entrada de datos desde consola: Solicita al usuario
	 * una cadena no vacía.
	 * @param s El mensaje a mostrar al usuario.
	 * @return La cadena ingresada por el usuario.
	 * @throws IOException
	 */
	public static String toScan(String s) {
		String line = "";
		do {
    		System.out.print(s + ": ");
    		line = scan.nextLine().trim();
    	} while(line.isEmpty());
		return line;
    }
	
	/**
	 * Entrada de datos desde consola: Solicita al usuario
	 * un entero válido.
	 * @param s El mensaje a mostrar al usuario.
 	 * @return El entero ingresado por el usuario.
 	 * @throws IOException
	 */
	public static int toScanInt(String s) {
		String line = "";
	    while (true) {
	        try {
	        	do {
	        		System.out.print(s + ": ");
	        		line = scan.nextLine().trim();
	        	} while(line.isEmpty());
	        	
	            int num = Integer.parseInt(line);
	            return num;
	        } catch (Exception e) {
	            printException(e);
	        }
	    }
	}
	
	/**
	 * Entrada de datos desde consola: Solicita al usuario
	 * un long válido.
	 * @param s El mensaje a mostrar al usuario.
 	 * @return El long ingresado por el usuario.
 	 * @throws IOException
	 */
	public static long toScanLong(String s) {
		System.out.print(s + ": ");
		return scan.nextLong();
	}
	
	/**
	 * Entrada de datos desde consola: Solicita al usuario
	 * un double válido.
	 * @param s El mensaje a mostrar al usuario.
 	 * @return El double ingresado por el usuario.
 	 * @throws IOException
	 */
	public static double toScanDouble(String s) {
		System.out.print(s + ": ");
		return scan.nextDouble();
	}
	
	/**
	 * Limpia el buffer del scanner.
	 */
	public static void cleanBuffer() {
		scan.nextLine();
	}
	
	/**
	 * Genera un ID aleatorio compuesto por un número
	 * de 8 dígitos seguido de una letra mayúscula.
	 * @return El ID generado.
	 */
	public static String toGetID() {
		int num = r.nextInt(40000000, 49999999);
		char[] ch = {
				'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M',
				'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
				'U', 'V', 'W', 'X', 'Y', 'Z'
		};
		return Integer.toString(num) + ch[r.nextInt(1, 26)];
	}
	
	/**
	 * Genera un número double aleatorio entre min y max.
	 * @param min El valor mínimo (inclusive).
	 * @param max El valor máximo (exclusive).
	 * @return El número double generado.
	 */
	public static double toGetDouble(int min, int max) {
		double d = r.nextInt(min, max)/100.0;
		return d;
	}
	
	/**
	 * Genera un valor booleano aleatorio.
	 * @return El valor booleano generado.
	 */
	public static boolean toGetBoolean() {
		return r.nextBoolean();
	}
	
	/**
	 * Imprime una cadena rodeada de signos iguales.
	 * @param s La cadena a imprimir.
	 */	
	public static void toGetString(String s) {
		for (int i = 0; i < s.length(); i++) {
			System.out.print("=");
		}
		System.out.print(" " + s + " ");
		
		for (int i = 0; i < s.length(); i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	/**
	 * Selecciona aleatoriamente una cadena de un array dado.
	 * @param s El array de cadenas.
	 * @return La cadena seleccionada.
	 */
	public static String toGetString(String[] s) {
		return s[r.nextInt(s.length)];
	}
	
	/**
	 * Genera un número entero aleatorio.
	 * @return El número entero generado.
	 */
	public static int toGetInteger() {
		return r.nextInt();
	}
	
	/**
	 * Selecciona aleatoriamente un entero de un array dado.
	 * @param i El array de enteros.
	 * @return El entero seleccionado.
	 */
	public static int toGetInteger(int[] i) {
		return i[r.nextInt(i.length)];
	}
	
	/**
	 * Genera un número entero aleatorio entre min y max.
	 * @param min El valor mínimo (inclusive).
	 * @param max El valor máximo (exclusive).
	 * @return El número entero generado.
	 */
	public static int toGetInteger(int min, int max) {
		return r.nextInt(min, max);
	}
	
	/**
	 * Verifica si un número es primo.
	 * @param num El número a verificar.
	 * @return true si el número es primo, false en caso contrario.
	 */
	public static boolean isPrime(int num) {
	    if (num <= 1) return false;
	    if (num == 2) return true;
	    if (num % 2 == 0) return false;
	    for (int i = 3; i <= Math.sqrt(num); i += 2) {
	        if (num % i == 0) return false;
	    }
	    return true;
	}
	
	/**
	 * Genera un número long aleatorio entre min y max.
	 * @param min El valor mínimo (inclusive).
	 * @param max El valor máximo (exclusive).
	 * @return El número long generado.
	 */
	public static long toGetLong(long min, long max) {
		return r.nextLong(min, max);
	}
	
	/**
	 * Mide el tiempo de ejecución de una tarea dada.
	 * @param task La tarea a medir.
	 * @return El tiempo de ejecución en milisegundos.
	 */
	public long toTime(Runnable task) {
        long start = System.currentTimeMillis();
        task.run();
        return System.currentTimeMillis() - start;
    }
	
	/**
	 * Muestra un progreso visual en la consola.
	 * @param ch El carácter a utilizar para el progreso.
	 * @param total El total de pasos en el progreso.
	 * @param sleep El tiempo de espera entre pasos en milisegundos.
	 */
	public static void toGetProgress(String ch, int total, int sleep) {
		for (int i = 0; i <= total; i++) {
	        System.out.print(ch);
	        try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	    System.out.println();
	}
	
	/**
	 * Lee un archivo y cuenta los caracteres por línea.
	 * @param archivo La ruta del archivo a leer.
	 * @return El contenido del archivo como una cadena.
	 * @throws IOException
	 */
	public static String toLeerArchivo(String archivo) throws IOException{
		Path ruta = Paths.get(archivo);
		StringBuilder builder = new StringBuilder();
		
		lines = Files.readAllLines(ruta);
		for(String linea : lines) {
			builder.append(linea+"\n");
			map.put(counter, linea);
			counter++;
		}
		
		for(Map.Entry<Integer, String> linea : map.entrySet()) {
			Integer numLines = linea.getKey();
			String content = linea.getValue();
			System.out.println("La línea " + numLines + 
					" tiene " + content.length() + " caracteres");
			characters += content.length();
		}
		System.out.println("Total = " + characters + " caracteres");
		return builder.toString();
	}
	
	/**
	 * Genera un nombre completo aleatorio.
	 * @return El nombre generado.
	 */
	public static String toGetName() {
		String[] first = {
	            "Alice", "Alejandro", 
	            "Ben", "Beatriz", 
	            "Charlie", "Carmen", 
	            "Daniel", "Dolores", 
	            "Emily", "Eduardo", 
	            "Frank", "Fernanda", 
	            "Grace", "Guillermo", 
	            "Henry", "Helena", 
	            "Isla", "Ignacio", 
	            "Jack", "Jimena", 
	            "Karen", "Kevin", 
	            "Liam", "Lucía", 
	            "Mia", "Mateo", 
	            "Noah", "Natalia", 
	            "Olivia", "Oscar", 
	            "Paul", "Pilar", 
	            "Quinn", "Queralt", 
	            "Rachel", "Raúl", 
	            "Sophie", "Sergio", 
	            "Thomas", "Tatiana", 
	            "Ursula", "Ulises", 
	            "Victor", "Valeria", 
	            "Wendy", "Wilmer", 
	            "Xander", "Ximena", 
	            "Yasmin", "Yago", 
	            "Zoe", "Zacarías"
	    };

	    String[] last = {
	            "Anderson", "Alonso", 
	            "Brown", "Barrios", 
	            "Carter", "Castillo", 
	            "Davis", "Díaz", 
	            "Evans", "Esparza", 
	            "Foster", "Fernández", 
	            "Garcia", "González", 
	            "Harris", "Herrera", 
	            "Ingram", "Iglesias", 
	            "Johnson", "Jiménez", 
	            "King", "Keller", 
	            "Lopez", "Luna", 
	            "Martinez", "Moreno", 
	            "Nelson", "Navarro", 
	            "Ortiz", "Oliver", 
	            "Parker", "Pérez", 
	            "Quinn", "Quijano", 
	            "Robinson", "Ramírez", 
	            "Smith", "Santos", 
	            "Taylor", "Torres", 
	            "Underwood", "Urbina", 
	            "Valentine", "Vargas", 
	            "Walker", "Wenceslao", 
	            "Xavier", "Ximénez", 
	            "Young", "Ybarra", 
	            "Zimmerman", "Zamora"
	    };
	    return first[r.nextInt(first.length)] + " " + last[r.nextInt(last.length)];
	}
	/**
	 * Genera un correo electrónico aleatorio basado en un nombre.
	 * @return El correo electrónico generado.
	 */
	public static String toGetEmail(String name) {
		name = toGetName().toLowerCase();
		name.replace(" ", "");
		String[] domains = {
				"gmail.com", "yahoo.com", "outlook.com",
				"hotmail.com", "aol.com", "icloud.com",
				"mail.com", "protonmail.com", "zoho.com",
				"gmx.com"
		};
		String domain = domains[r.nextInt(domains.length)];
		String emailName = name.toLowerCase().replace(" ", ".");
		return emailName + "@" + domain;
	}
	/** * Genera un departamento aleatorio.
	 * @return El departamento generado.
	 */
	public static String toGetDepartment() {
		String[] departments = {
				"Ventas", "Marketing", "Recursos Humanos",
				"Desarrollo", "Finanzas", "Atención al Cliente",
				"Operaciones", "IT", "Legal", "Compras"
		};
		return toGetString(departments);
	}
	/**
	 * Genera un salario aleatorio.
	 * @return El salario generado.
	 */
	public static int toGetSalary() {
		int[] salaries = { 
				30000, 35000, 40000, 45000, 50000,
				55000, 60000, 65000, 70000, 75000
		};
		return toGetInteger(salaries);
	}
	/**
	 * Genera un título aleatorio compuesto por un
	 * adjetivo, un sustantivo y un complemento.
	 * @return El título generado.
	 */
	public static String toGetTitle() {
	    String[] a = {
	        "Oscuro", "Misterioso", "Increíble", "Perdido", "Eterno",
	        "Secreto", "Invisible", "Fantástico", "Siniestro", "Radiante"
	    };

	    String[] s = {
	        "Bosque", "Destino", "Viaje", "Reino", "Mundo",
	        "Labyrinth", "Sueño", "Enigma", "Secreto", "Guardian"
	    };

	    String[] c = {
	        "del Alba", "de la Noche", "del Más Allá", "de los Sueños",
	        "de la Tormenta", "del Olvido", "de la Mente", "del Corazón",
	        "de las Sombras", "de la Esperanza"
	    };

	    String adj = toGetString(a);
	    String sust = toGetString(s);
	    String com = toGetString(c);

	    return adj + " " + sust + " " + com;
	}
}
