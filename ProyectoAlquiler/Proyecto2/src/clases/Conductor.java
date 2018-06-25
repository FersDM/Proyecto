package clases;

public class Conductor {
	
	private int idConductor;
	private String  nroBrevete;
	private String nombre ;
	private String  apellido;
	private String  categoria;
	
	
	public Conductor(int idConductor, String nroBrevete, String nombre, String apellido, String categoria) {
		
		this.idConductor = idConductor;
		this.nroBrevete = nroBrevete;
		this.nombre = nombre;
		this.apellido = apellido;
		this.categoria = categoria;
	}


	public int getIdConductor() {
		return idConductor;
	}


	public void setIdConductor(int idConductor) {
		this.idConductor = idConductor;
	}


	public String getNroBrevete() {
		return nroBrevete;
	}


	public void setNroBrevete(String nroBrevete) {
		this.nroBrevete = nroBrevete;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	
}
