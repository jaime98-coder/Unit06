package boletin1_ejercicio08;

public class MedicionDiaria {
	private static final String SEPARADOR = ",";

	private String fecha;
	private double temperaturaMaxima;
	private double temperaturaMinima;

	public MedicionDiaria(String fecha, double temperaturaMaxima, double temperaturaMinima) {
		this.fecha = fecha;
		this.temperaturaMaxima = temperaturaMaxima;
		this.temperaturaMinima = temperaturaMinima;
	}

	public String getFecha() {
		return fecha;
	}

	public double getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public double getTemperaturaMinima() {
		return temperaturaMinima;
	}

	public String getFichaPantalla() {
		return fecha + " - " + temperaturaMaxima + " - " + temperaturaMinima;
	}

	public String getFichaArchivo() {
		return fecha + SEPARADOR + temperaturaMaxima + SEPARADOR + temperaturaMinima;
	}

}
