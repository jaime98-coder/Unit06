package boletin1_ejercicio07;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Persona> listaContactos = new ArrayList<>();
		Scanner scOpcion = new Scanner(System.in);
		Scanner scannerDatos = new Scanner(System.in);
		int opcionElegida;
		System.out.println("1. Nuevo contacto:");
		System.out.println("2. Buscar por nombre. ");
		System.out.println("3. Mostrar todos. ");
		System.out.println("4. Salir. ");
		do {
			System.out.println("Elige una de las 4 opciones:");
			opcionElegida = scOpcion.nextInt();
			scOpcion.nextLine();
			switch (opcionElegida) {

			case 1: {
				System.out.println("Accediendo a nuevo contacto... ");
				if (listaContactos.size() >= 20) {
					System.out.println("Agenda llena. Se ha alcanzado el LÍMITE de contactos.");
					break;
				} else {

					try (Scanner sc = new Scanner(System.in);
							BufferedWriter out = new BufferedWriter(
									new FileWriter("src/boletin1_ejercicio07/agenda.txt", true))) {
						String nombreContacto = sc.nextLine();
						String tlfContacto = sc.nextLine();
						Persona contacto = new Persona(nombreContacto, tlfContacto);
						listaContactos.add(contacto);

						for (Persona contactoConcreto : listaContactos) {
							out.write(contactoConcreto.getNombre());
							out.write(";");
							out.write(contactoConcreto.getTelefono());
							out.newLine();
						}

					} catch (IOException e) {
						System.out.println("Error grave: No se pudo insertar en el archivo");
						System.out.println("Motivo: " + e.getMessage());
					}
				}
				break;
			}
			case 2: {
				System.out.println("Accediendo a buscar por nombre... ");
				String nombreABuscar;
				System.out.println("Introduce el nombre que deseas buscar: ");
				nombreABuscar = scannerDatos.nextLine();
				for (Persona contacto : listaContactos) {
					if (contacto.getNombre().equalsIgnoreCase(nombreABuscar)) {
						System.out.println("Teléfono del contacto introducido: " + contacto.getTelefono());
					}
				}
				break;
			}
			case 3: {
				System.out.println("Accediendo a mostrar todos... ");
				for (Persona contacto : listaContactos) {
					System.out.println(contacto.getNombre());
					System.out.println(contacto.getTelefono());
				}
				break;
			}
			case 4: {
				System.out.println("Saliendo de la agenda y guardando cambios...");
				break;
			}
			}
		} while (opcionElegida != 4);

		scOpcion.close();
		scannerDatos.close();
	}
}
