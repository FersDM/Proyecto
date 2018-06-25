package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Arreglos.ArregloConductor;
import Arreglos.ArregloVehiculo;
import clases.Vehiculo;
import libreria.Alerta;
import libreria.Fecha;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class DlgVehiculo extends JDialog implements ActionListener, MouseListener {
	
	private static final long serialVersionUID = 1L;

	private JLabel lblPlaca;
	private JLabel lblModelo;
	private JLabel lblColor;
	private JLabel lblAño;
	private JLabel lblEstado;
	private JTextField txtPlaca;
	private JTextField txtModelo;
	private JTextField txtColor;
	private JTextField txtAño;
	private JButton btnAceptar;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGrabar;
	private JScrollPane scrollPane;
	private JTable tblVehiculo;
	private DefaultTableModel modelo;	
	
	ArregloVehiculo av = new ArregloVehiculo("vehiculo.txt");
	
	private JComboBox cboCategoria;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgVehiculo dialog = new DlgVehiculo();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the dialog.
	 */
	public DlgVehiculo() {
		setTitle("Mantenimiento | Vehiculo");
		setResizable(false);
		setIconImage(new ImageIcon("imagenes/PrimaTaxi.png").getImage());
		setSize(1000, 600);
		getContentPane().setLayout(null);
		
		lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(728, 45, 111, 23);
		getContentPane().add(lblPlaca);
	
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(728, 75, 111, 23);
		getContentPane().add(lblModelo);
		
		lblColor = new JLabel("Color");
		lblColor.setBounds(728, 105, 111, 23);
		getContentPane().add(lblColor);

		lblAño = new JLabel("A\u00F1o");
		lblAño.setBounds(728, 139, 111, 23);
		getContentPane().add(lblAño);
	
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(728, 173, 111, 23);
		getContentPane().add(lblEstado);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(833, 45, 151, 23);
		getContentPane().add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(833, 75, 151, 23);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setBounds(833, 105, 151, 23);
		getContentPane().add(txtColor);
		txtColor.setColumns(10);
		
		txtAño = new JTextField();
		txtAño.setBounds(833, 139, 151, 23);
		getContentPane().add(txtAño);

		btnAceptar = new JButton(new ImageIcon("imagenes/aceptar.png"));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(947, 218, 20, 23);
		getContentPane().add(btnAceptar);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon("imagenes/ingresar.png"));
		btnIngresar.setBounds(794, 255, 150, 33);
		getContentPane().add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon("imagenes/modificar.png"));
		btnModificar.setBounds(794, 299, 150, 33);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon("imagenes/eliminar.png"));
		btnEliminar.setBounds(794, 343, 150, 33);		
		getContentPane().add(btnEliminar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(new ImageIcon("imagenes/grabar.png"));
		btnGrabar.setBounds(794, 387, 150, 33);
		getContentPane().add(btnGrabar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 700, 550);
		getContentPane().add(scrollPane);
		
		tblVehiculo = new JTable();
		tblVehiculo.addMouseListener(this);
		tblVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		tblVehiculo.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblVehiculo);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Placa");
		modelo.addColumn("Modelo");
		modelo.addColumn("Color");
		modelo.addColumn("Año");
		modelo.addColumn("Estado");
		tblVehiculo.setModel(modelo);
		
		txtPlaca.setEditable(false);
		
		cboCategoria = new JComboBox();
		cboCategoria.setModel(new DefaultComboBoxModel(new String[] { "Libre", "Ocupado","Seleccionar"}));
		cboCategoria.setBounds(833, 174, 151, 20);
		getContentPane().add(cboCategoria);
		habilitarEntradas(false);
		ajustarAnchoColumnas();	
		
		listar();
		editarFila();
	}
	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblVehiculo.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 8));  
		tcm.getColumn(1).setPreferredWidth(anchoColumna( 8));
		tcm.getColumn(2).setPreferredWidth(anchoColumna( 8)); 
		tcm.getColumn(3).setPreferredWidth(anchoColumna( 8));  
		tcm.getColumn(4).setPreferredWidth(anchoColumna( 8));  

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		btnIngresar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(true);
		limpieza();
		habilitarEntradas(true);
		txtPlaca.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(false);
		if (av.tamaño() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			Alerta.mensaje(this, "No existen Vehiculos");	
		}
		else {
			btnAceptar.setEnabled(true);
			habilitarEntradas(true);
			editarFila();
			txtPlaca.requestFocus();
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (av.tamaño() == 0)
			Alerta.mensaje(this, "No existen Vehiculo");
		else {
			int ok = Alerta.confirmar(this, "¿ Desea eliminar el registro ?");
			if (ok == 0) {
				av.eliminar(av.buscar(leerPlaca()));
				listar();
				editarFila();
			}
		}
	}
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (av.existeArchivo()) {
			int ok = Alerta.confirmar(this, "¿ Desea actualizar \"" + av.getArchivo() + "\" ?");
			if (ok == 0) {
				av.grabarVehiculo();
				Alerta.mensaje(this, "\"" + av.getArchivo() + "\" ha sido actualizado");
			}
			else
				Alerta.mensaje(this, "No se actualizó  \"" + av.getArchivo() + "\"");
		}
		else {
			av.grabarVehiculo();
			Alerta.mensaje(this, "\"" + av.getArchivo() + "\" ha sido creado");
		}
	}
	

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblVehiculo) {
			mouseClickedTblCliente(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}

	protected void mouseClickedTblCliente(MouseEvent arg0) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		String placa = leerPlaca();
		String modelo = leerModelo();
		if (modelo.length() > 0) {
			String color = leerColor();
			if (color.length() > 0) {
						int año = leerAño();
							int estado = leerCategoria();
							
							
										if (btnIngresar.isEnabled() == false) {
											clases.Vehiculo nuevo = new clases.Vehiculo(placa,modelo,  color,  año,  estado);
											av.adicionar(nuevo);
											btnIngresar.setEnabled(true);
										}
										if (btnModificar.isEnabled() == false) {
											 Vehiculo x = av.buscar(placa);
											x.setModelo(modelo);
											x.setColor(color);
											x.setAño(año);
											x.setEstado(estado);
											btnModificar.setEnabled(true);
											}
										listar();
										habilitarEntradas(false);
										
			              }else {
								Alerta.mensaje(this, "Ingrese Color correcto");
								txtColor.setText("");
								txtColor.requestFocus();
			
						}}
						else {
							Alerta.mensaje(this, "Ingrese Año correcto");
							txtAño.setText("");
							txtAño.requestFocus();
					
				}}
	
		
	
	public void listar() {
		clases.Vehiculo x;
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblVehiculo.getSelectedRow();
		if (modelo.getRowCount() == av.tamaño()-1)
			posFila = av.tamaño()-1;
		if (posFila == av.tamaño())
			posFila --;
		modelo.setRowCount(0);
		for (int i=0; i<av.tamaño(); i++) {
			x = av.obtener(i);
			Object[] fila = { x.getPlaca(), 
						      x.getModelo(),
						      x.getColor(),
						      x.getAño(),
						      x.getEstado(),
						      };
			modelo.addRow(fila);
		}
		if (av.tamaño() > 0)
			tblVehiculo.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void limpieza() {
		txtPlaca.setText("");
		txtModelo.setText("");
		txtColor.setText("");
		txtAño.setText("");
		cboCategoria.setSelectedItem("Seleccionar");
	}
	void editarFila() {
		if (av.tamaño() == 0)
			limpieza();
		else {
			Vehiculo x = av.obtener(tblVehiculo.getSelectedRow());
			txtPlaca.setText( x.getPlaca());
			txtModelo.setText(x.getModelo());
			txtColor.setText(x.getColor());
			txtAño.setText(""+x.getAño());
			cboCategoria.setSelectedIndex(x.getEstado());
		}
	}
	void habilitarEntradas(boolean sino) {
		btnAceptar.setEnabled(sino);
		txtPlaca.setEditable(sino);
		txtModelo.setEditable(sino);
		txtColor.setEditable(sino);
		txtAño.setEditable(sino);
		cboCategoria.setEditable(sino);
	}
	void habilitarBotones(boolean sino) {
		btnIngresar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	String leerPlaca() {
		return txtPlaca.getText().trim();
	}
	String leerModelo() {
		return txtModelo.getText().trim();
	}
	String leerColor() {
		return txtColor.getText().trim();
	}
	int leerAño()
	{
		return Integer.parseInt(txtAño.getText().trim()) ;
	}
	int leerCategoria() {
		return cboCategoria.getSelectedIndex();
	}
}
