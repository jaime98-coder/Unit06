package boletin2_ejercicio02;

import java.io.*;
import java.util.Collection;
import java.util.LinkedHashSet;

public class GestorFirmas {
	private LinkedHashSet<Persona> registroPersonas;
	private String ruta;

	public GestorFirmas() {
		this.registroPersonas = new LinkedHashSet<>();
		this.ruta = "src/boletin2_ejercicio02/firmas.txt";
	}

	// Leemos las firmas antiguas para que la memoria RAM no empiece vacía
	public void cargarDatos() {
		try (BufferedReader in = new BufferedReader(new FileReader(ruta))) {
			String lineaTXT;
			lineaTXT = in.readLine();
			while (lineaTXT != null) {
				// Al meterlas en el LinkedHashSet, nos aseguramos de purgar posibles duplicados
				// antiguos del TXT
				registroPersonas.add(new Persona(lineaTXT));
				lineaTXT = in.readLine();
			}
		} catch (FileNotFoundException e) {
			// Es normal si el archivo no existe aún
		} catch (IOException e) {
			System.out.println("Error de lectura: " + e.getMessage());
		}
	}

	public void guardarDatos() {
		try (BufferedWriter out = new BufferedWriter(new FileWriter(ruta))) {
			// Escribimos toda la colección limpia y en orden
			for (Persona p : registroPersonas) {
				out.write(p.getNombre());
				out.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error de escritura: " + e.getMessage());
		}
	}

	// Método inteligente para que el Main consulte antes de intentar registrar
	public boolean existeFirma(String nombre) {
		return registroPersonas.contains(new Persona(nombre));
	}

	public void registrarPersona(Persona personaARegistrar) {
		registroPersonas.add(personaARegistrar);
	}

	// El Gestor devuelve la bandeja, no imprime
	public Collection<Persona> obtenerNombres() {
		return registroPersonas;
	}

	public boolean estaVacio() {
		return registroPersonas.isEmpty();
	}
}