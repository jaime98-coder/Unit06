package boletin1_ejercicio07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.TreeMap;

public class GestorAgenda {

	private TreeMap<String, Persona> agenda;
	private String rutaArchivo;

	public GestorAgenda() {
		this.agenda = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		this.rutaArchivo = "src/boletin1_ejercicio07/agenda.txt";
	}

	public void cargarDatos() {
		try (BufferedReader in = new BufferedReader(new FileReader(rutaArchivo))) {
			String lineaTXT;
			String[] partes;
			lineaTXT = in.readLine();

			while (lineaTXT != null) {
				partes = lineaTXT.split(";");
				if (partes.length == 2) {
					Persona contactoGuardado = new Persona(partes[0], partes[1]);
					agenda.put(partes[0], contactoGuardado);
				}
				lineaTXT = in.readLine();
			}
			

		} catch (FileNotFoundException e) {
			// Lo dejamos vacío de forma controlada. Si no existe, no pasa nada, la agenda
			// nace vacía.

		} catch (IOException e) {
			System.out.println("Error grave de LECTURA: " + e.getMessage());

		}
	}

	public void guardarDatos() {
		try (BufferedWriter out = new BufferedWriter(new FileWriter(rutaArchivo))) {
			for (Persona contacto : agenda.values()) {
				out.write(contacto.getFichaArchivo());
				out.newLine();
			}
			
		} catch (IOException e) {
			System.out.println("ERROR GRAVE: No se ha podido guardar");
		}
	}

	public boolean estaLlena() {
		boolean llena = false;

		if (agenda.size() >= 20) {
			llena = true;
		}
		return llena;
	}

	public boolean estaVacia() {
		return agenda.isEmpty();
	}

	public int getCantidadContactos() {
		return agenda.size();
	}

	public boolean existeContacto(String nombre) {
		if (agenda.containsKey(nombre)) {
			return true;
		}
		return false;
	}

	public void agregarContacto(String nombre, String telefono) {
		Persona nuevoContacto = new Persona(nombre, telefono);
		agenda.put(nombre, nuevoContacto);
	}

	public Persona buscarContacto(String nombre) {
		return agenda.get(nombre);
	}

	/**
	 * Devolvemos la colección entera para que el Main la pinte
	 * @return los valores (clave,valor) de la agenda.
	 */
	public Collection<Persona> obtenerTodosContactos() {
		return agenda.values();
	}

}
