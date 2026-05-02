package boletin1_ejercicio08;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		GestorMediciones miGestorTemp = new GestorMediciones();
		int opcionElegida;
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		String fechaMedicion;
		double temperaturaMaxima;
		double temperaturaMinima;
		boolean temperaturasVálidas;

		miGestorTemp.cargarDatos();
		do {

			System.out.println("\n----MEDICIONES DE TEMPERATURA----");
			System.out.println("1. Registrar nueva temperatura");
			System.out.println("2. Mostrar historial de registros");
			System.out.println("3. Salir");
			opcionElegida = sc.nextInt();
			sc.nextLine();

			switch (opcionElegida) {
			case 1: {
				System.out.println("Accediendo a registrar nueva temperatura...");

				System.out.println("Introduce la FECHA de la medición:");
				fechaMedicion = sc.nextLine();
				if (miGestorTemp.existeFecha(fechaMedicion)) {
					System.out.println("La fecha registrada ya existe");
				} else {
					temperaturasVálidas = false;
					do {
						System.out.println("Introduce la TEMPERATURA MÁXIMA de la medición:");
						temperaturaMaxima = sc.nextDouble();
						sc.nextLine();
						System.out.println("Introduce la TEMPERATURA MÍNIMA de la medición:");
						temperaturaMinima = sc.nextDouble();
						sc.nextLine();
						if (temperaturaMaxima < temperaturaMinima) {
							System.out.println(
									"Error: La temperatura máxima no puede ser inferior a la mínima. Repita los datos.");
						} else {
							// Salida del bucle de validacion de temperaturas
							temperaturasVálidas = true;
						}
					} while (!temperaturasVálidas);
					miGestorTemp.registrarNuevaTemperatura(fechaMedicion, temperaturaMaxima, temperaturaMinima);
					System.out.println("Nueva temperatura insertada correctamente");
				}
				break;
			}

			case 2: {
				System.out.println("Accediendo al historial de registros...");
				if (miGestorTemp.estaVacio()) {
					System.out.println("El historial de registros está vacío");
				} else {
					for (MedicionDiaria medicion : miGestorTemp.obtenerHistorialTemperaturas()) {
						System.out.println(medicion.getFichaPantalla());
					}
					System.out.println("Máxima temperatura del historial: " + miGestorTemp.calcularMaximoHistorico());
					System.out.println("Mínima temperatura del historial: " + miGestorTemp.calcularMinimoHistorico());
				}
				break;
			}
			case 3: {
				System.out.println("Saliendo del sistema de mediciones de temperatura y guardando...");
				salir = true;
				miGestorTemp.guardarDatos();
				System.out.println("¡Datos guardados correctamente!");
				break;
			}
			default: {
				System.out.println("Elige una opción válida (1-3)");
			}

			}
		} while (!salir);
		sc.close();
	}

}
