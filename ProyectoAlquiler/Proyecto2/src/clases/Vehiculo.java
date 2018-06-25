package clases;

public class Vehiculo {

	
	private String placa ;
	private String modelo ;
	private String color ;
	private int  año ;
	private int  estado ;
	
	
	public Vehiculo(String placa, String modelo, String color, int año, int estado) {
	
		this.placa = placa;
		this.modelo = modelo;
		this.color = color;
		this.año = año;
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


	public int getAño() {
		return año;
	}


	public void setAño(int año) {
		this.año = año;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
	
	
}
