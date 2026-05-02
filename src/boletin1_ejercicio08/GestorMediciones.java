package boletin1_ejercicio08;

import java.io.*;
import java.util.Collection;
import java.util.TreeMap;

public class GestorMediciones {

	private TreeMap<String, MedicionDiaria> mediciones;
	private String ruta;

	public GestorMediciones() {
		this.mediciones = new TreeMap<>();
		this.ruta = "src/boletin1_ejercicio08/datosTemperatura.txt";
	}

	public void cargarDatos() {
		try (BufferedReader in = new BufferedReader(new FileReader(ruta))) {
			String lineaTXT;
			String[] partesMapa;
			lineaTXT = in.readLine();

			while (lineaTXT != null) {
				partesMapa = lineaTXT.split(",");
				if (partesMapa.length == 3) {
					MedicionDiaria medicionGuardada = new MedicionDiaria(partesMapa[0],
							Double.parseDouble(partesMapa[1].trim()), Double.parseDouble(partesMapa[2].trim()));
					mediciones.put(partesMapa[0], medicionGuardada);
				}
				lineaTXT = in.readLine();
			}

		} catch (FileNotFoundException e) {
			// Si no existe la ruta, no pasa nada
		} catch (IOException e) {
			System.out.println("ERROR grave de LECTURA: " + e.getMessage());

		}
	}

	public void guardarDatos() {
		try (BufferedWriter out = new BufferedWriter(new FileWriter(ruta))) {
			for (MedicionDiaria medicion : mediciones.values()) {
				out.write(medicion.getFichaArchivo());
				out.newLine();
			}
		} catch (IOException e) {
			System.out.println("ERROR grave de ESCRITURA. No se ha podido guardar" + e.getMessage());
		}
	}

	public boolean estaVacio() {
		return mediciones.isEmpty();
	}

	public boolean existeFecha(String fecha) {
		return mediciones.containsKey(fecha);
	}

	public void registrarNuevaTemperatura(String fechaTemp, double temperaturaMax, double temperaturaMin) {
		MedicionDiaria nuevaMedicion = new MedicionDiaria(fechaTemp, temperaturaMax, temperaturaMin);
		mediciones.put(fechaTemp, nuevaMedicion);
	}

	/**
	 * Devolvemos la colección entera para que el Main la pinte
	 * 
	 * @return los valores (clave,valor) del treeMap de mediciones.
	 */
	public Collection<MedicionDiaria> obtenerHistorialTemperaturas() {
		return mediciones.values();
	}

	public double calcularMaximoHistorico() {
		double maximoAbsoluto = Double.MIN_VALUE;
		for (MedicionDiaria medicion : mediciones.values()) {
			if (medicion.getTemperaturaMaxima() > maximoAbsoluto) {
				maximoAbsoluto = medicion.getTemperaturaMaxima();
			}
		}
		return maximoAbsoluto;
	}

	public double calcularMinimoHistorico() {
		double minimoAbsoluto = Double.MAX_VALUE;
		for (MedicionDiaria medicion : mediciones.values()) {
			if (medicion.getTemperaturaMinima() < minimoAbsoluto) {
				minimoAbsoluto = medicion.getTemperaturaMinima();
			}
		}
		return minimoAbsoluto;
	}

}
