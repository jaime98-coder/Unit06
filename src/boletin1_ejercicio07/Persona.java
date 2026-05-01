package boletin1_ejercicio07;

public class Persona {

	private static final String SEPARADOR = ";";

	private String nombre;
	private String telefono;

	public Persona(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	/**
	 * La persona muestra sus propios datos en pantalla
	 * 
	 * @return nombre y telefono con formato legible para el usuario
	 */
	public String getFichaPantalla() {
		return nombre + " - " + telefono;
	}

	/**
	 * Formato específico para guardar en el archivo .txt
	 * 
	 * @return nombre+";"+telefono. --> quedando asi: nombre;telefono
	 */
	public String getFichaArchivo() {
		return nombre + SEPARADOR + telefono;
	}
}
