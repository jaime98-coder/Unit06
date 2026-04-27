package boletin1_ejercicio04;

import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				BufferedWriter out = new BufferedWriter(
						new FileWriter("src/boletin1_ejercicio04/AlmacenCadenasTexto.txt"))) {
			String palabra;
			System.out.println("Escribe cadenas de texto para guardarlas en el .txt");
			System.out.println("Escribe 'fin' cuando quieras terminar \n");
			do {
				palabra = sc.nextLine();
				if (!palabra.equalsIgnoreCase("fin")) {
					// 1. Escribimos la palabra en el archivo
					out.write(palabra);
					// 2. Añadimos el salto de línea (tal y como pide el enunciado)
					out.newLine();
				}

			} while (!palabra.equalsIgnoreCase("fin"));
			System.out.println("Programa terminado... Has introducido FIN. Revisa tu archivo AlmacenCadenasTexto.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error grave: No se ha podido escribir en el archivo.");
			System.out.println("Motivo: " + e.getMessage());
		}
	}

}
