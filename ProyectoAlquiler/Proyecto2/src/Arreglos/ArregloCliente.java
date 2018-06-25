package Arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Cliente;

    public class ArregloCliente {
	private ArrayList<Cliente> cli;
	private String archivo;

	public ArregloCliente(String archivo) {
		cli = new ArrayList<Cliente>();
		this.archivo = archivo;
		cargarClientes();
	}

	public int tamaño() {
		return cli.size();
	}

	public Cliente obtener(int i) {
		return cli.get(i);
	}

	public void adicionar(Cliente x) {
		cli.add(x);
	}

	public void eliminar(Cliente x) {
		cli.remove(x);
	}

	public Cliente buscar(int codigo) {
		Cliente x;
		for (int i = 0; i < tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigoCliente() == codigo)
				return x;
		}
		return null;
	}

	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 10001;
		else
			return obtener(tamaño() - 1).getCodigoCliente() + 1;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getArchivo() {
		return archivo;
	}

	public void grabarClientes() {
		try {
			PrintWriter pw;
			String linea;
			Cliente x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodigoCliente() + ";" + x.getNombres() + ";" + x.getApellidos() + ";" + x.getTelefono() + ";"
						+ x.getDni() + ";" ;
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public void cargarClientes() {
		try {
			BufferedReader br;
			String linea,  nombres,  apellidos,  telefono,  dni;
			String s[];
			int codigoCliente;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoCliente = Integer.parseInt(s[0].trim());
				nombres = s[1].trim();
				apellidos = s[2].trim();
				telefono = s[3].trim();
				dni = s[4].trim();
				adicionar(new Cliente(codigoCliente,  nombres,  apellidos,  telefono,  dni));
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
