package boletin1_ejercicio08;

import java.util.TreeMap;

public class GestorMedicion {

	private TreeMap<String, MedicionDiaria> medicion;
	private String ruta;

	public GestorMedicion() {
		this.medicion = new TreeMap<>();
		this.ruta = ruta = "src/boletin1_ejercicio08/datosTemperatura.txt";
	}

}
