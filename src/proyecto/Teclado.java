package proyecto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teclado {
	public enum comparenumber {
		MAYOR, MENOR, MAYORIGUAL, MENORIGUAL
	}

	public enum range {
		INCLUIDOS, NOINCLUIDOS, PRIMEROINCLUIDO, SEGUNDOINCLUIDO
	}

	// PASO 1) CREAR LA CLASE ABRIR TECLADO PARA NO CREARLA EN TODAS LAS FUNCIONES
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
//		Realizar la clase Teclado para leer valores desde el teclado que contenga métodos estáticos para leer
//		de forma segura, con su correspondiente manejo de excepciones, de forma que se pueda incluir en
//		cualquier proyecto, e invocar a estos métodos desde cualquier otra clase sin tener que repetir las
//		tediosas tareas asociadas a una lectura segura de datos. Si el usuario no introduce lo deseado, se lo
//		volveremos a pedir repetidas veces hasta que introduzca un valor válido. La utilidad de esta clase
//		será simplificar la escritura de estas operaciones, por lo que el nombre de los métodos lo vamos a
//		elegir de forma que sea igualmente breve. Realizar los siguientes métodos:
//		• Cerrar teclado.
//		• Lectura de un carácter.
//		• Lectura de una cadena.
//		• Lectura de un boolean: se le pasará como parámetro tres mensajes. La función
//		mostrará el siguiente menú al usuario:
//		Mensaje 1
//		1.- Mensaje 2
//		2.- Mensaje 3
//		El usuario tendrá que introducir 1 ó 2. Si introduce 1, la función devolverá true. Si
//		introduce 2, la función devolverá false.
//		Ejemplo:
//		 Elige color:
//		1.- Rojo
//		2.- Verde
//		• Lectura de un boolean: se le pasará como parámetro un mensaje que será la pregunta
//		que se le realizará al usuario. La función debe recibir del usuario una 's' ó una 'n' en
//		minúscula o en mayúscula. Si el usuario introduce 's' o 'S', la función devolverá true.
//		Si introduce ‘n’ o ‘N’, devolverá false.
//		Ejemplo: ¿Estás casado? (s/n):
//		Utiliza sobrecarga para que se llame igual que la función anterior.
//		• Para la entrada de datos numéricos, hacer los siguientes métodos para los tipos byte,
//		short, int, long, float, double.
//		✔ Lectura de un número cualquiera.
//		✔ Lectura de un número que sea mayor/menor/igual que un valor pasado como
//		parámetro. Utiliza sobrecarga para que se llame igual para todos los tipos.
//		También se le pasará como parámetro un enum para indicar:
//		➢ mayor o igual que el valor
//		➢ menor o igual que el valor
//		➢ mayor que el valor
//		➢ menor que el valor
//		✔ Lectura de un número que debe estar entre un valor mínimo y un valor máximo
//		que se le pasarán como parámetros. El valor mínimo y el valor máximo pueden
//		ser iguales pero si el valor mínimo es mayor que el valor máximo, se lanzará la
//		excepción IllegalArgumentException. Utiliza sobrecarga para que se llame igual
//		para todos los tipos. También se le pasará como parámetro un enum para indicar:
//		➢ Ambos incluidos
//		➢ Ambos excluidos
//		➢ El mínimo incluido y el máximo excluido
//		➢ El mínimo excluido y el máximo incluido 

//		Incluir en el proyecto lo siguiente:
//			1. Planteamiento.
//			2. Diagrama de casos de uso.
//			3. Pruebas de caja negra.

	}

	public static void closekeyboard() {
		// PASO 1) FUNCION PARA CERRAR TECLADO
		keyboard.close();
	}

	public static char read_char(String Question) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN CARACTER
		// PASO 2) COMPROBAMOS SI ES UN CARACTER
		// PASO 3) SI NO SE INTRODUCE UN CARACTER LE PEDIMOS QUE INTRODUZCA OTRO
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		String b = null;
		boolean c = true;
		char g = 0;
		do {
			System.out.println(Question);
			b = keyboard.nextLine();
			if (b.length() != 1) {
				System.out.println("Introduzca un carácter valido");
			} else {
				g = b.charAt(0);
				c = false;
			}
		} while (c);

		return g;
	}

	public static String read_String(String Question) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UNA CADENA
		// PASO 2) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		String b = null;
		boolean c = true;
		do {
			System.out.println(Question);
			b = keyboard.nextLine();
			if (b.equals("")) {
				System.out.println("Introduzca una cadena valida");
			} else {
				c = false;
			}
		} while (c);
		return b;
	}

	public static Boolean read_Boolean(String Question, String Answer1, String Answer2) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO, 1 O 2
		// PASO 2) COMPROBAMOS SI ES UNO DE ELLOS
		// PASO 3) SI NO SE INTRODUCE UNO DE ESOS NUMEROS, LE PEDIMOS QUE INTRODUZCA
		// OTRO DE NUEVO
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		boolean a = false;
		int number;
		System.out.println(Question);
		System.out.println("1. " + Answer1);
		System.out.println("2. " + Answer2);
		number = read_range(1, 2, range.INCLUIDOS);
		if (number == 1) {
			a = true;
		} else if (number == 2) {
			a = false;
		}
		return a;
	}

	public static Boolean read_Boolean(String Question) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN CARACTER QUE SEA N o S
		// PASO 2) COMPROBAMOS SI ES UNO DE ELLOS
		// PASO 3) SI NO SE INTRODUCE UNO DE ESOS CARACTERES, LE PEDIMOS QUE INTRODUZCA
		// OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		char Answer;
		do {
			Answer = Character.toLowerCase(read_char(Question + "(s/n)"));
		} while (Answer != 's' && Answer != 'n');
		return Answer == 's';
	}

	public static byte read_byte(String Question) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO
		// PASO 2) COMPROBAMOS SI EL NUMERO INTRODUCIDO ENTRA DENTRO DEL RANGO
		// PASO 3) SI NO SE INTRODUCE UNO DENTRO DEL RANGO, LE PEDIMOS QUE INTRODUZCA
		// OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		byte a = 1;
		boolean error = false;
		System.out.println(Question);
		do {
			error = false;
			try {
				a = keyboard.nextByte();
			} catch (InputMismatchException e) {
				error = true;
				System.out.println("Error, por favor introduce un número válido");
			} finally {
				keyboard.nextLine();// Limpieza del buffer
			}
		} while (error);
		return a;

	}

	public static short read_short(String Question) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO
		// PASO 2) COMPROBAMOS SI EL NUMERO INTRODUCIDO ENTRA DENTRO DEL RANGO
		// PASO 3) SI NO SE INTRODUCE UNO DENTRO DEL RANGO, LE PEDIMOS QUE INTRODUZCA
		// OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		short a = 1;
		boolean error = false;
		System.out.println(Question);
		do {
			error = false;
			try {
				a = keyboard.nextShort();
			} catch (InputMismatchException e) {
				error = true;
				System.out.println("Error, por favor introduce un número válido");
			} finally {
				keyboard.nextLine();// Limpieza del buffer
			}
		} while (error);
		return a;

	}

	public static int read_int(String Question) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO
		// PASO 2) COMPROBAMOS SI EL NUMERO INTRODUCIDO ENTRA DENTRO DEL RANGO
		// PASO 3) SI NO SE INTRODUCE UNO DENTRO DEL RANGO, LE PEDIMOS QUE INTRODUZCA
		// OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		int a = 1;
		boolean error = false;
		System.out.println(Question);
		do {
			error = false;
			try {
				a = keyboard.nextInt();
			} catch (InputMismatchException e) {
				error = true;
				System.out.println("Error, por favor introduce un número válido");
			} finally {
				keyboard.nextLine();// Limpieza del buffer
			}
		} while (error);
		return a;

	}

	public static long read_long(String Question) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO
		// PASO 2) COMPROBAMOS SI EL NUMERO INTRODUCIDO ENTRA DENTRO DEL RANGO
		// PASO 3) SI NO SE INTRODUCE UNO DENTRO DEL RANGO, LE PEDIMOS QUE INTRODUZCA
		// OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		long a = 1;
		boolean error = false;
		System.out.println(Question);
		do {
			error = false;
			try {
				a = keyboard.nextLong();
			} catch (InputMismatchException e) {
				error = true;
				System.out.println("Error, por favor introduce un número válido");
			} finally {
				keyboard.nextLine();// Limpieza del buffer
			}
		} while (error);
		return a;
	}

	public static double read_double(String Question) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO
		// PASO 2) COMPROBAMOS SI EL NUMERO INTRODUCIDO ENTRA DENTRO DEL RANGO
		// PASO 3) SI NO SE INTRODUCE UNO DENTRO DEL RANGO, LE PEDIMOS QUE INTRODUZCA
		// OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		double a = 1;
		boolean error = false;
		System.out.println(Question);
		do {
			error = false;
			try {
				a = keyboard.nextDouble();
			} catch (InputMismatchException e) {
				error = true;
				System.out.println("Error, por favor introduce un número válido");
			} finally {
				keyboard.nextLine();// Limpieza del buffer
			}
		} while (error);
		return a;
	}

	public static float read_float(String Question) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO
		// PASO 2) COMPROBAMOS SI EL NUMERO INTRODUCIDO ENTRA DENTRO DEL RANGO
		// PASO 3) SI NO SE INTRODUCE UNO DENTRO DEL RANGO, LE PEDIMOS QUE INTRODUZCA
		// OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		float a = 1;
		boolean error = false;
		System.out.println(Question);
		do {
			error = false;
			try {
				a = keyboard.nextFloat();
			} catch (InputMismatchException e) {
				error = true;
				System.out.println("Error, por favor introduce un número válido");
			} finally {
				keyboard.nextLine();// Limpieza del buffer
			}
		} while (error);
		return a;
	}

	public static int read_limit(int b, comparenumber sign) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO
		// PASO 2) DEPENDE DE EL VALOR DEL ENUM, EL NUMERO SERA MAYOR, MENOR, MAYORIGUAL
		// o MENORIGUAL
		// PASO 3) SI NO SE INTRODUCE UNO DENTRO DEL RANGO DE VALORES VALIDO, LE PEDIMOS
		// QUE INTRODUZCA OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		int number = 0;
		boolean error = false;
		do {
			error = false;
			if (sign == comparenumber.MAYOR) {
				number = read_int("Dime un numero mayor " + "que " + b);
				if (number <= b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (sign == comparenumber.MENOR) {
				number = read_int("Dime un numero menor " + "que " + b);
				if (number >= b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (sign == comparenumber.MAYORIGUAL) {
				number = read_int("Dime un numero mayor o igual " + "que " + b);
				if (number < b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (sign == comparenumber.MENORIGUAL) {
				number = read_int("Dime un numero menor o igual " + "que " + b);
				if (number > b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			}
		} while (error);
		return number;
	}

	public 	static short read_limit(short b, comparenumber sign) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO
		// PASO 2) DEPENDE DE EL VALOR DEL ENUM, EL NUMERO SERA MAYOR, MENOR, MAYORIGUAL
		// o MENORIGUAL
		// PASO 3) SI NO SE INTRODUCE UNO DENTRO DEL RANGO DE VALORES VALIDO, LE PEDIMOS
		// QUE INTRODUZCA OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		short number = 0;
		boolean error = false;
		do {
			error = false;
			if (sign == comparenumber.MAYOR) {
				number = read_short("Dime un numero mayor " + "que " + b);
				if (number <= b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (sign == comparenumber.MENOR) {
				number = read_short("Dime un numero menor " + "que " + b);
				if (number >= b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (sign == comparenumber.MAYORIGUAL) {
				number = read_short("Dime un numero mayor o igual " + "que " + b);
				if (number < b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (sign == comparenumber.MENORIGUAL) {
				number = read_short("Dime un numero menor o igual " + "que " + b);
				if (number > b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			}
		} while (error);
		return number;
	}

	public static byte read_limit(byte b, comparenumber sign) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO
		// PASO 2) DEPENDE DE EL VALOR DEL ENUM, EL NUMERO SERA MAYOR, MENOR, MAYORIGUAL
		// o MENORIGUAL
		// PASO 3) SI NO SE INTRODUCE UNO DENTRO DEL RANGO DE VALORES VALIDO, LE PEDIMOS
		// QUE INTRODUZCA OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		byte number = 0;
		boolean error = false;
		do {
			error = false;
			if (sign == comparenumber.MAYOR) {
				number = read_byte("Dime un numero mayor " + "que " + b);
				if (number <= b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (sign == comparenumber.MENOR) {
				number = read_byte("Dime un numero menor " + "que " + b);
				if (number >= b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (sign == comparenumber.MAYORIGUAL) {
				number = read_byte("Dime un numero mayor o igual " + "que " + b);
				if (number < b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (sign == comparenumber.MENORIGUAL) {
				number = read_byte("Dime un numero menor o igual " + "que " + b);
				if (number > b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			}
		} while (error);
		return number;
	}

	public static double read_limit(double b, comparenumber sign) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO
		// PASO 2) DEPENDE DE EL VALOR DEL ENUM, EL NUMERO SERA MAYOR, MENOR, MAYORIGUAL
		// o MENORIGUAL
		// PASO 3) SI NO SE INTRODUCE UNO DENTRO DEL RANGO DE VALORES VALIDO, LE PEDIMOS
		// QUE INTRODUZCA OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		double number = 0;
		boolean error = false;
		do {
			error = false;
			if (sign == comparenumber.MAYOR) {
				number = read_double("Dime un numero mayor " + "que " + b);
				if (number <= b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (sign == comparenumber.MENOR) {
				number = read_double("Dime un numero menor " + "que " + b);
				if (number >= b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (sign == comparenumber.MAYORIGUAL) {
				number = read_double("Dime un numero mayor o igual " + "que " + b);
				if (number < b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (sign == comparenumber.MENORIGUAL) {
				number = read_double("Dime un numero menor o igual " + "que " + b);
				if (number > b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			}
		} while (error);
		return number;
	}

	public static long read_limit(long b, comparenumber sign) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO
		// PASO 2) DEPENDE DE EL VALOR DEL ENUM, EL NUMERO SERA MAYOR, MENOR, MAYORIGUAL
		// o MENORIGUAL
		// PASO 3) SI NO SE INTRODUCE UNO DENTRO DEL RANGO DE VALORES VALIDO, LE PEDIMOS
		// QUE INTRODUZCA OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		long number = 0;
		boolean error = false;
		do {
			error = false;
			if (sign == comparenumber.MAYOR) {
				number = read_long("Dime un numero mayor " + "que " + b);
				if (number <= b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (sign == comparenumber.MENOR) {
				number = read_long("Dime un numero menor " + "que " + b);
				if (number >= b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (sign == comparenumber.MAYORIGUAL) {
				number = read_long("Dime un numero mayor o igual " + "que " + b);
				if (number < b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (sign == comparenumber.MENORIGUAL) {
				number = read_long("Dime un numero menor o igual " + "que " + b);
				if (number > b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			}
		} while (error);
		return number;
	}

	public static float read_limit(float b, comparenumber sign) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO
		// PASO 2) DEPENDE DE EL VALOR DEL ENUM, EL NUMERO SERA MAYOR, MENOR, MAYORIGUAL
		// o MENORIGUAL
		// PASO 3) SI NO SE INTRODUCE UNO DENTRO DEL RANGO DE VALORES VALIDO, LE PEDIMOS
		// QUE INTRODUZCA OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		float number = 0;
		boolean error = false;
		do {
			error = false;
			if (sign == comparenumber.MAYOR) {
				number = read_float("Dime un numero mayor " + "que " + b);
				if (number <= b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (sign == comparenumber.MENOR) {
				number = read_float("Dime un numero menor " + "que " + b);
				if (number >= b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (sign == comparenumber.MAYORIGUAL) {
				number = read_float("Dime un numero mayor o igual " + "que " + b);
				if (number < b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (sign == comparenumber.MENORIGUAL) {
				number = read_float("Dime un numero menor o igual " + "que " + b);
				if (number > b) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			}
		} while (error);
		return number;
	}

	public static int read_range(int min, int max, range rango) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO ENTRE UN RANGO
		// PASO 2) DEPENDE DE EL VALOR DEL ENUM, EL RANGO TENDRA LOS EXTREMOS INCLUIDOS,
		// NO INCLUIDOS, UNO SI Y EL OTRO NO.
		// PASO 3) SI NO SE INTRODUCE UNO DENTRO DEL RANGO DE VALORES VALIDO, LE PEDIMOS
		// QUE INTRODUZCA OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		boolean error;
		int number = 0;
		if (min > max) {
			throw new IllegalArgumentException();
		}
		do {

			error = false;
			if (rango == range.INCLUIDOS) {
				number = read_int("Dime un numero entre " + min + " y " + max + ", ambos incluidos");

				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (rango == range.NOINCLUIDOS) {
				number = read_int(
						"Dime un numero entre " + min + " y " + max + ", " + min + " y " + max + " no incluidos");

				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (rango == range.PRIMEROINCLUIDO) {
				number = read_int("Dime un numero entre " + min + " y " + max + ", " + min + "  incluido");
				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (rango == range.SEGUNDOINCLUIDO) {
				number = read_int("Dime un numero entre " + min + " y " + max + ", " + max + "  incluido");
				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			}
		} while (error);
		return number;
	}

	public static byte read_range(byte min, byte max, range rango) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO ENTRE UN RANGO
		// PASO 2) DEPENDE DE EL VALOR DEL ENUM, EL RANGO TENDRA LOS EXTREMOS INCLUIDOS,
		// NO INCLUIDOS, UNO SI Y EL OTRO NO.
		// PASO 3) SI NO SE INTRODUCE UNO DENTRO DEL RANGO DE VALORES VALIDO, LE PEDIMOS
		// QUE INTRODUZCA OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		boolean error;
		byte number = 0;
		if (min > max) {
			throw new IllegalArgumentException();
		}
		do {

			error = false;
			if (rango == range.INCLUIDOS) {
				number = read_byte("Dime un numero entre " + min + " y " + max + ", ambos incluidos");

				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (rango == range.NOINCLUIDOS) {
				number = read_byte(
						"Dime un numero entre " + min + " y " + max + ", " + min + " y " + max + " no incluidos");

				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (rango == range.PRIMEROINCLUIDO) {
				number = read_byte("Dime un numero entre " + min + " y " + max + ", " + min + "  incluido");
				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (rango == range.SEGUNDOINCLUIDO) {
				number = read_byte("Dime un numero entre " + min + " y " + max + ", " + max + "  incluido");
				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			}

		} while (error);
		return number;

	}

	public static short read_range(short min, short max, range rango) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO ENTRE UN RANGO
		// PASO 2) DEPENDE DE EL VALOR DEL ENUM, EL RANGO TENDRA LOS EXTREMOS INCLUIDOS,
		// NO INCLUIDOS, UNO SI Y EL OTRO NO.
		// PASO 3) SI NO SE INTRODUCE UNO DENTRO DEL RANGO DE VALORES VALIDO, LE PEDIMOS
		// QUE INTRODUZCA OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		boolean error;
		short number = 0;
		if (min > max) {
			throw new IllegalArgumentException();
		}
		do {

			error = false;
			if (rango == range.INCLUIDOS) {
				number = read_short("Dime un numero entre " + min + " y " + max + ", ambos incluidos");

				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (rango == range.NOINCLUIDOS) {
				number = read_short(
						"Dime un numero entre " + min + " y " + max + ", " + min + " y " + max + " no incluidos");

				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (rango == range.PRIMEROINCLUIDO) {
				number = read_short("Dime un numero entre " + min + " y " + max + ", " + min + "  incluido");
				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (rango == range.SEGUNDOINCLUIDO) {
				number = read_short("Dime un numero entre " + min + " y " + max + ", " + max + "  incluido");
				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			}

		} while (error);
		return number;
	}

	public static long read_range(long min, long max, range rango) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO ENTRE UN RANGO
		// PASO 2) DEPENDE DE EL VALOR DEL ENUM, EL RANGO TENDRA LOS EXTREMOS INCLUIDOS,
		// NO INCLUIDOS, UNO SI Y EL OTRO NO.
		// PASO 3) SI NO SE INTRODUCE UNO DENTRO DEL RANGO DE VALORES VALIDO, LE PEDIMOS
		// QUE INTRODUZCA OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		boolean error;
		long number = 0;
		if (min > max) {
			throw new IllegalArgumentException();
		}
		do {

			error = false;
			if (rango == range.INCLUIDOS) {
				number = read_long("Dime un numero entre " + min + " y " + max + ", ambos incluidos");

				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (rango == range.NOINCLUIDOS) {
				number = read_long(
						"Dime un numero entre " + min + " y " + max + ", " + min + " y " + max + " no incluidos");

				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (rango == range.PRIMEROINCLUIDO) {
				number = read_long("Dime un numero entre " + min + " y " + max + ", " + min + "  incluido");
				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (rango == range.SEGUNDOINCLUIDO) {
				number = read_long("Dime un numero entre " + min + " y " + max + ", " + max + "  incluido");
				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			}

		} while (error);
		return number;
	}

	public static double read_range(double min, double max, range rango) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO ENTRE UN RANGO
		// PASO 2) DEPENDE DE EL VALOR DEL ENUM, EL RANGO TENDRA LOS EXTREMOS INCLUIDOS,
		// NO INCLUIDOS, UNO SI Y EL OTRO NO.
		// PASO 3) SI NO SE INTRODUCE UNO DENTRO DEL RANGO DE VALORES VALIDO, LE PEDIMOS
		// QUE INTRODUZCA OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		boolean error;
		double number = 0;
		if (min > max) {
			throw new IllegalArgumentException();
		}
		do {

			error = false;
			if (rango == range.INCLUIDOS) {
				number = read_double("Dime un numero entre " + min + " y " + max + ", ambos incluidos");

				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (rango == range.NOINCLUIDOS) {
				number = read_double(
						"Dime un numero entre " + min + " y " + max + ", " + min + " y " + max + " no incluidos");

				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (rango == range.PRIMEROINCLUIDO) {
				number = read_double("Dime un numero entre " + min + " y " + max + ", " + min + "  incluido");
				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (rango == range.SEGUNDOINCLUIDO) {
				number = read_double("Dime un numero entre " + min + " y " + max + ", " + max + "  incluido");
				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			}

		} while (error);
		return number;
	}

	public static float read_range(float min, float max, range rango) {
		// PASO 1) PEDIMOS AL USUARIO QUE INTRODUZCA UN NUMERO ENTRE UN RANGO
		// PASO 2) DEPENDE DE EL VALOR DEL ENUM, EL RANGO TENDRA LOS EXTREMOS INCLUIDOS,
		// NO INCLUIDOS, UNO SI Y EL OTRO NO.
		// PASO 3) SI NO SE INTRODUCE UNO DENTRO DEL RANGO DE VALORES VALIDO, LE PEDIMOS
		// QUE INTRODUZCA OTRO DE NUEVO.
		// PASO 4) SI LO INTRODUCIDO ES LO BUSCADO, SE DEVUELVE
		boolean error;
		float number = 0;
		if (min > max) {
			throw new IllegalArgumentException();
		}
		do {

			error = false;
			if (rango == range.INCLUIDOS) {
				number = read_float("Dime un numero entre " + min + " y " + max + ", ambos incluidos");

				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (rango == range.NOINCLUIDOS) {
				number = read_float(
						"Dime un numero entre " + min + " y " + max + ", " + min + " y " + max + " no incluidos");

				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (rango == range.PRIMEROINCLUIDO) {
				number = read_float("Dime un numero entre " + min + " y " + max + ", " + min + "  incluido");
				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			} else if (rango == range.SEGUNDOINCLUIDO) {
				number = read_float("Dime un numero entre " + min + " y " + max + ", " + max + "  incluido");
				if (number > max || number < min) {
					System.out.println("Introduzca un número valido");
					error = true;
				}
			}

		} while (error);
		return number;
	}
}
