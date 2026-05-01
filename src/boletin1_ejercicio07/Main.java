package boletin1_ejercicio07;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String nombreContacto;
		String tlfContacto;

		int opcionElegida;
		boolean salir = false;

		Scanner sc = new Scanner(System.in);
		GestorAgenda miGestor = new GestorAgenda();

		miGestor.cargarDatos();
		System.out.println("Agenda cargada correctamente. Contactos actuales:" + miGestor.getCantidadContactos());

		do {
			System.out.println("\n ------AGENDA------");
			System.out.println("1. Nuevo contacto.");
			System.out.println("2. Buscar por nombre. ");
			System.out.println("3. Mostrar todos. ");
			System.out.println("4. Salir y Guardar. ");
			System.out.println("Elige una de las 4 opciones:");
			opcionElegida = sc.nextInt();
			sc.nextLine();
			switch (opcionElegida) {

			case 1: {
				System.out.println("Accediendo a nuevo contacto... ");
				if (miGestor.estaLlena()) {
					System.out.println("Agenda llena. Se ha alcanzado el LÍMITE de contactos.");
				} else {
					System.out.println("Introduce NOMBRE del contacto:");
					nombreContacto = sc.nextLine();
					if (miGestor.existeContacto(nombreContacto)) {
						System.out.println("El contacto introducido YA EXISTE en la agenda");
					} else {
						System.out.println("Introduce el TELÉFONO: ");
						tlfContacto = sc.nextLine();

						miGestor.agregarContacto(nombreContacto, tlfContacto);
						System.out.println("Contacto guardado.");
					}
				}
				break;
			}
			case 2: {
				System.out.println("Accediendo a buscar por nombre... ");

				System.out.println("Introduce el nombre que deseas buscar: ");
				nombreContacto = sc.nextLine();

				Persona contactoEncontrado = miGestor.buscarContacto(nombreContacto);

				if (contactoEncontrado != null) {
					System.out.println("Teléfono del contacto introducido: " + contactoEncontrado.getFichaPantalla());
				} else {
					System.out.println("No se ha encontrado ningún contacto con el nombre introducido...");
				}

				break;
			}
			case 3: {
				System.out.println("Accediendo a mostrar todos... ");
				if (miGestor.estaVacia()) {
					System.out.println("La agenda está vacía.");
				} else {
					for (Persona contacto : miGestor.obtenerTodosContactos()) {
						System.out.println(contacto.getFichaPantalla());
					}
				}
				break;
			}
			case 4: {
				System.out.println("Saliendo de la agenda y guardando cambios...");
				salir = true;
				miGestor.guardarDatos();
				System.out.println("¡Archivo guardado correctamente!");
				System.out.println("\nGracias por utilizar la agenda. ¡Hasta pronto!");
				break;
			}
			default: {
				System.out.println("Selecciona una opción válida");
			}
			}
		} while (!salir);

		sc.close();
	}
}
