package clases;

public class Alquiler {
	
	private int id;
	private String codigoCliente;
	private String placa;
	private String  fechaAlquiler;
	private int  dias;
	private double  precioxDia;
	private int  estado;
	private int  reservado;
	
	public Alquiler(int id, String codigoCliente, String placa, String fechaAlquiler, int dias, double precioxDia,
			int estado, int reservado) {
		
		this.id = id;
		this.codigoCliente = codigoCliente;
		this.placa = placa;
		this.fechaAlquiler = fechaAlquiler;
		this.dias = dias;
		this.precioxDia = precioxDia;
		this.estado = estado;
		this.reservado = reservado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getFechaAlquiler() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(String fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public double getPrecioxDia() {
		return precioxDia;
	}

	public void setPrecioxDia(double precioxDia) {
		this.precioxDia = precioxDia;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getReservado() {
		return reservado;
	}

	public void setReservado(int reservado) {
		this.reservado = reservado;
	}
	
	
	
	
	
}
