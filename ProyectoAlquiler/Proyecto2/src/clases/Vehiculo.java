package clases;

public class Vehiculo {

	
	private String placa ;
	private String modelo ;
	private String color ;
	private int  a�o ;
	private int  estado ;
	
	
	public Vehiculo(String placa, String modelo, String color, int a�o, int estado) {
	
		this.placa = placa;
		this.modelo = modelo;
		this.color = color;
		this.a�o = a�o;
		this.estado = estado;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getA�o() {
		return a�o;
	}


	public void setA�o(int a�o) {
		this.a�o = a�o;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
	
	
}
