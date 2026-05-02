package boletin2_ejercicio02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Declaración de variables primitivas
		boolean salir = false;
		String nombrePersona;
		Scanner sc = new Scanner(System.in);
		GestorFirmas miGestor = new GestorFirmas();

		System.out.println("------Bienvenido al programa de inserción al libro de firmas------");

		// Carga fundamental para que el programa conozca el pasado
		miGestor.cargarDatos();

		do {
			System.out.println("\nIntroduce el nombre a insertar (escribe 'salir' para finalizar):");
			// Usamos trim() para evitar espacios en blanco accidentales
			nombrePersona = sc.nextLine().trim();

			if (nombrePersona.equalsIgnoreCase("salir")) {
				salir = true;
				System.out.println("¡Fin de la inserción!");
			} else {
				// Doble validación UX: Avisamos al usuario si ya firmó
				if (miGestor.existeFirma(nombrePersona)) {
					System.out.println("Lo siento, " + nombrePersona + " ya ha firmado el libro.");
				} else if (nombrePersona.equalsIgnoreCase("")) {
					System.out.println("No dejes en blanco la casilla nombre");

				} else {
					Persona persona = new Persona(nombrePersona);
					miGestor.registrarPersona(persona);
					System.out.println("Firma de " + nombrePersona + " registrada correctamente.");
				}
			}

		} while (!salir);

		// Volcamos la memoria RAM al disco duro
		miGestor.guardarDatos();

		System.out.println("\n--- LISTADO FINAL DE FIRMAS ---");

		// Uso del Patrón Bandera desde el Gestor
		if (miGestor.estaVacio()) {
			System.out.println("El libro está vacío.");
		} else {
			// El Main es quien hace el sysout
			for (Persona personaConcreta : miGestor.obtenerNombres()) {
				System.out.println("- " + personaConcreta.getNombre());
			}
		}

		sc.close();
	}
}