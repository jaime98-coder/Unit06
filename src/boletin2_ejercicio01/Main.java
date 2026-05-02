package boletin2_ejercicio01;

public class Main {

	public static void main(String[] args) {
		String rutaCarta = "src/boletin2_ejercicio01/carta.txt";
		AnalizadorTexto analizadorTxt = new AnalizadorTexto(rutaCarta);
		analizadorTxt.procesarArchivo();

		System.out.println("DATOS DE LA RUTA ESPECIFICADA");
		System.out.println("Total caracteres (contando espacios): " + analizadorTxt.getContadorCaracteres());
		System.out.println("Total líneas: " + analizadorTxt.getContadorLineas());
		System.out.println("Total palabras: " + analizadorTxt.getContadorPalabras());

	}
}
