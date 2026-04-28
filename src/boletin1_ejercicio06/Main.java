package boletin1_ejercicio06;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> listaNumeros = new ArrayList<>();
		try (Scanner sc = new Scanner(new FileReader("src/boletin1_ejercicio06/NumerosEnterosDesordenados.txt"))) {
			while (sc.hasNextInt()) {
				int numero = sc.nextInt();
				listaNumeros.add(numero);
			}
			Collections.sort(listaNumeros);
			// listaNumeros.sort(null) Tambien se puede usar para que se ordene por su orden
			// natural

		} catch (IOException e) {
			System.out.println("Error grave. No se pudo leer el archivo");
			System.out.println("Motivo: " + e.getMessage());
		}

		try (BufferedWriter out = new BufferedWriter(
				new FileWriter("src/boletin1_ejercicio06/NumerosEnterosOrdenados.txt"))) {
			for (int numero : listaNumeros) {
				out.write(String.valueOf(numero));
				out.newLine();
			}

		} catch (IOException e) {
			System.out.println("Error grave: No se ha podido insertar el texto");
			System.out.println("Motivo: " + e.getMessage());
		}

	}

}
