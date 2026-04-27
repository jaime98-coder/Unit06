package boletin1_ejercicio01;

import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Forma antigua, teniendo que declaralro en null y meter el cierre del recurso sc en un finally.
		Scanner sc = null;
		try {
			FileReader in = new FileReader("src/boletin1_ejercicio01/NumerosReales.txt");
			sc = new Scanner(in);
			double suma = 0;
			double mediaAritmetica = 0;
			int contador = 0;

			while (sc.hasNextDouble()) {
				double numero = sc.nextDouble();
				suma += numero;
				contador++;
			}
			if (contador > 0) {
				mediaAritmetica = suma / contador;
				System.out.println("La suma de los números del .txt es: " + suma);
				System.out.println("La media de los números del .txt  es: " + mediaAritmetica);
			} else {
				System.out.println("El archivo está vacío, no hay números para calcular");
			}

		} catch (IOException e) {
			// Si el archivo no existe o hay error, cae aquí
			System.out.println("Error grave: No se ha podido leer el archivo.");
			System.out.println("Motivo: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}
}
