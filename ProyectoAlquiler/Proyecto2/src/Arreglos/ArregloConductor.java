package Arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Conductor;

public class ArregloConductor {

	private ArrayList<Conductor> co;
	private String archivo;

	public ArregloConductor(String archivo) {
		co = new ArrayList<Conductor>();
		this.archivo = archivo;
		cargarConductor();
	}

	public int tamaño() {
		return co.size();
	}

	public Conductor obtener(int i) {
		return co.get(i);
	}

	public void adicionar(Conductor x) {
		co.add(x);
	}

	public void eliminar(Conductor x) {
		co.remove(x);
	}

	public Conductor buscar(int codigo) {
		Conductor x;
		for (int i = 0; i < tamaño(); i++) {
			x = obtener(i);
			if (x.getIdConductor() == codigo)
				return x;
		}
		return null;
	}

	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 1;
		else
			return obtener(tamaño() - 1).getIdConductor() + 1;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getArchivo() {
		return archivo;
	}

	public void grabarConductor() {
		try {
			PrintWriter pw;
			String linea;
			Conductor x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getIdConductor() + ";" + x.getNroBrevete() + ";" + x.getNombre() + ";" + x.getApellido() + ";"
						+ x.getCategoria()+ ";" ;
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public void cargarConductor() {
		try {
			BufferedReader br;
			String linea, nroBrevete,  nombre,  apellido,  categoria;
			String s[];
			int idConductor;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				idConductor = Integer.parseInt(s[0].trim());
				nroBrevete = s[1].trim();
				nombre = s[2].trim();
				apellido = s[3].trim();
				categoria = s[4].trim();
				adicionar(new Conductor(idConductor,nroBrevete,  nombre,  apellido,  categoria));
			}
			br.close();
		} catch (Exception e) {
		}
	}

	public boolean existeArchivo() {
		File f = new File(archivo);
		return f.exists();
	}
}
