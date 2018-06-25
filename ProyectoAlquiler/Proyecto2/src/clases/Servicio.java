package clases;

public class Servicio {
	
	private int id ;
	private int idConductor ;
	private double precioxHora;
	private double horasdeServicio;
	private int codigoCliente;
	private String placa;
	
	public Servicio(int id, int idConductor, double precioxHora, double horasdeServicio, int codigoCliente,
			String placa) {
	
		this.id = id;
		this.idConductor = idConductor;
		this.precioxHora = precioxHora;
		this.horasdeServicio = horasdeServicio;
		this.codigoCliente = codigoCliente;
		this.placa = placa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(int idConductor) {
		this.idConductor = idConductor;
	}

	public double getPrecioxHora() {
		return precioxHora;
	}

	public void setPrecioxHora(double precioxHora) {
		this.precioxHora = precioxHora;
	}

	public double getHorasdeServicio() {
		return horasdeServicio;
	}

	public void setHorasdeServicio(double horasdeServicio) {
		this.horasdeServicio = horasdeServicio;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	
	
}
