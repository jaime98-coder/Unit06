package boletin2_ejercicio01;

import java.io.*;

public class AnalizadorTexto {
	private int totalCaracteres;
	private int totalLineas;
	private int totalPalabras;
	private String ruta;

	public AnalizadorTexto(String ruta) {
		this.ruta = ruta;

		totalCaracteres = 0;
		totalLineas = 0;
		totalPalabras = 0;
	}

	public int getContadorCaracteres() {
		return totalCaracteres;
	}

	public int getContadorLineas() {
		return totalLineas;
	}

	public int getContadorPalabras() {
		return totalPalabras;
	}

	public String getRuta() {
		return ruta;
	}

	public void procesarArchivo() {

		try (BufferedReader in = new BufferedReader(new FileReader(ruta))) {
			String[] palabras = null;
			String lineaTXT = in.readLine();
			while (lineaTXT != null) {

				totalCaracteres += lineaTXT.length();
				totalLineas++;
				palabras = lineaTXT.split(" ");
				totalPalabras += palabras.length;
				lineaTXT = in.readLine();

			}

		} catch (IOException e) {
			System.out.println("ERROR de lectura ");
		}

	}

}
