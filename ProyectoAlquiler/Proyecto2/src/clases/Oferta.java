package clases;

public class Oferta {

	private int id ;
	private  String placa ;
	private  double precioxDia;
	private String descripcion;
	private String fechaSalida;//dd/m/aa
	
	
	public Oferta(int id, String placa, double precioxDia, String descripcion, String fechaSalida) {
		
		this.id = id;
		this.placa = placa;
		this.precioxDia = precioxDia;
		this.descripcion = descripcion;
		this.fechaSalida = fechaSalida;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public double getPrecioxDia() {
		return precioxDia;
	}


	public void setPrecioxDia(double precioxDia) {
		this.precioxDia = precioxDia;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	
	
	
}
