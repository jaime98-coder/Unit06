package boletin1_ejercicio03;

import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new FileReader("src/boletin1_ejercicio03/Alumnos.txt"))) {
			double sumaEdad = 0;
			double sumaEstatura = 0;
			int contador = 0;
			System.out.println("Listado de alumnos");
			while (sc.hasNext()) {
				// 1. Leemos el nombre
				String nombre = sc.next();
				System.out.println("Nombre: " + nombre);

				// 2. Leemos la edad como String y convertimos a entero
				String edadTexto = sc.next();
				int edad = Integer.parseInt(edadTexto);
				sumaEdad += edad;

				// 3. Leemos la estatura como String y convertimos a double
				String estaturaTexto = sc.next();
				// En este caso el replace no es necesario porque el .txt tiene ya los puntos,
				// pero valdría si el .txt tuviese , porque estuviese escrito con la
				// configuración española (decimales con ,)
				double estatura = Double.parseDouble(estaturaTexto.replace(",", "."));
				sumaEstatura += estatura;
				contador++;
			}
			if (contador > 0) {
				double mediaEdad = sumaEdad / contador;
				double mediaEstatura = sumaEstatura / contador;
				System.out.println("------ Estadisticas finales ------");
				System.out.println("Media de edad: " + mediaEdad);
				System.out.println("Media de estatura: " + mediaEstatura);
			} else {
				System.out.println("El archivo .txt está vacio");
			}

		} catch (IOException e) {
			System.out.println("ERROR: No se ha podido leer el archivo");
			System.out.println("Motivo: " + e.getMessage());
		}
	}
}
