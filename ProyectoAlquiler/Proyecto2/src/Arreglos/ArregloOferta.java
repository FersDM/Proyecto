package Arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Oferta;

public class ArregloOferta {

	private ArrayList<Oferta> ao;
	private String archivo;

	public ArregloOferta(String archivo) {
		ao = new ArrayList<Oferta>();
		this.archivo = archivo;
		cargarOferta();
	}

	public void adicionar(Oferta c) {
		ao.add(c);
	}

	public int tamaño() {
		return ao.size();
	}

	public Oferta obtener(int i) {
		return ao.get(i);
	}

	public void eliminar(Oferta c) {
		ao.remove(c);
	}

	public Oferta buscar(int codigo) {
		Oferta c;
		for (int i = 0; i < tamaño(); i++) {
			c = obtener(i);
			if (c.getId() == codigo)
				return c;
		}
		return null;
	}

	public int codigoCorrelativo() {
		if (tamaño() == 0) {
			return 10000001;
		}
		else {
			return obtener(tamaño() - 1).getId() + 1;
		}
	}

	public String getArchivo() {
		return archivo;
	}

	public void eliminarAlFinal() {
		if (tamaño() > 0)
			ao.remove(tamaño() - 1);
	}

	public void eliminarTodo() {
		if (tamaño() > 0)
			ao.clear();
	}

	public void grabarOferta() {
		try {
			PrintWriter pw;
			String linea;
			Oferta x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getId() + ";" + x.getPlaca() + ";" + x.getPrecioxDia() + ";" + x.getDescripcion()
						+ ";" + x.getFechaSalida();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}

	public void cargarOferta() {
		try {
			BufferedReader br;
			String linea,placa,descripcion,fSalida, s[];
			int codId;
			double precioxDia;
			Oferta nuevo;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codId = Integer.parseInt(s[0].trim());
    			placa= s[1].trim();
				precioxDia = Double.parseDouble(s[2].trim());
				descripcion= s[3].trim();
				fSalida= s[4].trim();
				
				

				nuevo = new Oferta(codId, placa, precioxDia, descripcion, fSalida);
				adicionar(nuevo);
			}
			br.close();
		}
		catch (Exception e) {
		}
	}

	public boolean existeArchivo() {
		File f = new File(archivo);
		return f.exists();
	}

}
