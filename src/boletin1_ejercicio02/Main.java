package boletin1_ejercicio02;

import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Forma moderna de creacion. El try con paréntesis cierra automáticamente lo
		// que declares dentro
		try (Scanner sc = new Scanner(new FileReader("src/boletin1_ejercicio02/Enteros.txt"))) {
			double suma = 0;
			int contador = 0;
			double media = 0;
			while (sc.hasNextDouble()) {
				double numero = sc.nextDouble();
				suma += numero;
				contador++;
			}
			
			if (contador > 0) {
				media = suma / contador;
				System.out.println("Suma: " + suma);
				System.out.println("Media: " + media);
			} else {
				System.out.println("No hay ningún número en el .txt seleccionado");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error grave: No se ha podido leer el archivo.");
			System.out.println("Motivo: " + e.getMessage());
		}

	}

}
