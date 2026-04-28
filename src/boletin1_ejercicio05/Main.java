package boletin1_ejercicio05;

import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				BufferedWriter out = new BufferedWriter(new FileWriter("src/boletin1_ejercicio05/datos.txt", true))) {
			String nombre;
			int edad;
			System.out.println("Introduce nombre: ");
			nombre = sc.nextLine();
			System.out.println("Introduce edad: ");
			edad = sc.nextInt();
			out.write(nombre);
			out.write(String.valueOf(edad));
			// Para separar cada insercion
			out.newLine();

		} catch (IOException e) {
			System.out.println("Error grave: No se ha podido insertar el texto");
			System.out.println("Motivo: " + e.getMessage());
		}

	}

}
