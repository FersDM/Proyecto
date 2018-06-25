package Arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Vehiculo;

public class ArregloVehiculo {
	private ArrayList<Vehiculo> ve;
	private String archivo;

	public ArregloVehiculo(String archivo) {
		ve = new ArrayList<Vehiculo>();
		this.archivo = archivo;
		cargarVehiculo();
	}

	public int tamaño() {
		return ve.size();
	}

	public Vehiculo obtener(int i) {
		return ve.get(i);
	}

	public void adicionar(Vehiculo x) {
		ve.add(x);
	}

	public void eliminar(Vehiculo x) {
		ve.remove(x);
	}

	public Vehiculo buscar(String placa) {
		Vehiculo x;
		for (int i = 0; i < tamaño(); i++) {
			x = obtener(i);
			if (x.getPlaca().equals(placa));
				return x;
		}
		return null;
	}


	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getArchivo() {
		return archivo;
	}

	public void grabarVehiculo() {
		try {
			PrintWriter pw;
			String linea;
			Vehiculo x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getPlaca() + ";" + x.getModelo() + ";" + x.getColor() + ";" + x.getAño() + ";"
						+ x.getEstado()+ ";" ;
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public void cargarVehiculo() {
		try {
			BufferedReader br;
			String linea,placa,  modelo,  color;
			String s[];
			int  año,  estado;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				placa = s[0].trim();;
				modelo = s[1].trim();
				color = s[2].trim();
				año = Integer.parseInt(s[3].trim());
				estado = Integer.parseInt(s[4].trim());
				adicionar(new Vehiculo(placa,modelo,  color,  año,  estado));
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
