package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.w3c.dom.CDATASection;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.MouseEvent;
import java.awt.Font;

import libreria.Alerta;
import libreria.Fecha;
import libreria.Libreria;
import Arreglos.ArregloOferta;
import Arreglos.ArregloVehiculo;
import clases.Oferta;
import com.toedter.calendar.JDateChooser;

public class DlgOferta extends JDialog implements ActionListener, MouseListener {
	
	private static final long serialVersionUID = 1L;

	private JLabel lblId;
	private JLabel lblPlaca;
	private JLabel lblPrecio;
	private JLabel lblFechaSalida;
	private JLabel lblDescripcion;
	private JTextField txtCodigo;
	private JTextField txtPrecio;
	private JTextField txtDescripcion;
	private JComboBox <String> cboPlaca;
	private JButton btnAceptar;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGrabar;
	private JScrollPane scrollPane;
	private JTable tblOferta;
	private DefaultTableModel modelo;	
	
	ArregloOferta ac = new ArregloOferta("oferta.txt");
	ArregloVehiculo ve = new ArregloVehiculo("vehiculo.txt");
	private JDateChooser dcFecha;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgOferta dialog = new DlgOferta();
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
	public DlgOferta() {
		setTitle("Mantenimiento | Clientes");
		setResizable(false);
		setIconImage(new ImageIcon("imagenes/PrimaTaxi.png").getImage());
		setSize(1000, 600);
		getContentPane().setLayout(null);
		
		lblId = new JLabel("Código");
		lblId.setBounds(728, 89, 111, 23);
		getContentPane().add(lblId);
	
		lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(728, 119, 111, 23);
		getContentPane().add(lblPlaca);
		
		
		lblPrecio = new JLabel("Precio por Dia");
		lblPrecio.setBounds(728, 149, 111, 23);
		getContentPane().add(lblPrecio);

		lblFechaSalida = new JLabel("Fec. Salida");
		lblFechaSalida.setBounds(728, 217, 111, 23);
		getContentPane().add(lblFechaSalida);
	
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(728, 183, 111, 23);
		getContentPane().add(lblDescripcion);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(833, 89, 151, 23);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(833, 149, 151, 23);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);

		
		cboPlaca = new JComboBox <String> ();
		cboPlaca.setBounds(833, 119, 150, 23);
		getContentPane().add(cboPlaca);
		
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(833, 183, 151, 23);
		getContentPane().add(txtDescripcion);

		btnAceptar = new JButton(new ImageIcon("imagenes/aceptar.png"));
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(902, 269, 20, 23);
		getContentPane().add(btnAceptar);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon("imagenes/ingresar.png"));
		btnIngresar.setBounds(772, 303, 150, 33);
		getContentPane().add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon("imagenes/modificar.png"));
		btnModificar.setBounds(772, 343, 150, 33);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon("imagenes/eliminar.png"));
		btnEliminar.setBounds(772, 383, 150, 33);		
		getContentPane().add(btnEliminar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(new ImageIcon("imagenes/grabar.png"));
		btnGrabar.setBounds(772, 423, 150, 33);
		getContentPane().add(btnGrabar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 700, 550);
		getContentPane().add(scrollPane);
		
		tblOferta = new JTable();
		tblOferta.addMouseListener(this);
		tblOferta.setFont(new Font("Tahoma", Font.PLAIN, 9));
		tblOferta.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblOferta);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Id");
		modelo.addColumn("Placa");
		modelo.addColumn("Precio por Dia");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Fecha Salida");
		
		tblOferta.setModel(modelo);
		
		txtCodigo.setEditable(false);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(833, 217, 151, 20);
		getContentPane().add(dcFecha);
		dcFecha.setEnabled(false);
		habilitarEntradas(false);
		ajustarAnchoColumnas();	
		llenarCombo();
		listar();
		editarFila();
	}
	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblOferta.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 8));
		tcm.getColumn(1).setPreferredWidth(anchoColumna( 8));  
		tcm.getColumn(2).setPreferredWidth(anchoColumna( 8));  
		tcm.getColumn(3).setPreferredWidth(anchoColumna( 8));  
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10)); 
		
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
		dcFecha.setEnabled(true);
		
		limpieza();
		txtCodigo.setText("" + ac.codigoCorrelativo());
		habilitarEntradas(true);
		cboPlaca.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(false);
		if (ac.tamaño() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			Alerta.mensaje(this, "No existen Autos");	
		}
		else {
			btnAceptar.setEnabled(true);
			habilitarEntradas(true);
			editarFila();
			cboPlaca.requestFocus();
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (ac.tamaño() == 0)
			Alerta.mensaje(this, "No existen clientes");
		else {
			int ok = Alerta.confirmar(this, "¿ Desea eliminar el registro ?");
			if (ok == 0) {
				ac.eliminar(ac.buscar(leerCodigo()));
				listar();
				editarFila();
			}
		}
	}
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (ac.existeArchivo()) {
			int ok = Alerta.confirmar(this, "¿ Desea actualizar \"" + ac.getArchivo() + "\" ?");
			if (ok == 0) {
				ac.grabarOferta();
				Alerta.mensaje(this, "\"" + ac.getArchivo() + "\" ha sido actualizado");
			}
			else
				Alerta.mensaje(this, "No se actualizó  \"" + ac.getArchivo() + "\"");
		}
		else {
			ac.grabarOferta();
			Alerta.mensaje(this, "\"" + ac.getArchivo() + "\" ha sido creado");
		}
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblOferta) {
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
		dcFecha.setEnabled(false);
		int id = leerCodigo();
		String placa = leerPlaca();
		if (placa.length() > 0) {
			double precio=leerPrecio();
			String descripcion = leerDescripcion();
			if (descripcion.length() > 0) {
						String fechaS = leerFecha();
						if (fechaS.length() > 0) {
							
										if (btnIngresar.isEnabled() == false) {
											clases.Oferta nuevo = new clases.Oferta(id,  placa,  precio,  descripcion,  fechaS);
											ac.adicionar(nuevo);
											btnIngresar.setEnabled(true);
										}
										if (btnModificar.isEnabled() == false) {
											clases.Oferta x = ac.buscar(id);
											x.setPlaca(placa);
											x.setPrecioxDia(precio);
											x.setDescripcion(descripcion);
											x.setFechaSalida(fechaS);
											btnModificar.setEnabled(true);
										}	
										listar();
										habilitarEntradas(false);
									}
									
							
							else {
								Alerta.mensaje(this, "Ingrese fecha correcta");
								dcFecha.setDate(null);
								dcFecha.requestFocus();
							}
						}
						else {
							Alerta.mensaje(this, "Ingrese descripcion correcto");
							txtDescripcion.setText("");
							txtDescripcion.requestFocus();
						}
					
			}
		}
	void listar() {
		Oferta x;
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblOferta.getSelectedRow();
		if (modelo.getRowCount() == ac.tamaño()-1)
			posFila = ac.tamaño()-1;
		if (posFila == ac.tamaño())
			posFila --;
		modelo.setRowCount(0);
		for (int i=0; i<ac.tamaño(); i++) {
			x = ac.obtener(i);
			Object[] fila = { x.getId(), 
						      x.getPlaca(),
						      x.getPrecioxDia(),
						      x.getDescripcion(),
						      x.getFechaSalida(),
						      };
			modelo.addRow(fila);
		}
		if (ac.tamaño() > 0)
			tblOferta.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	void limpieza() {
		txtCodigo.setText("");
		cboPlaca.setSelectedItem("Selecionar");
		txtPrecio.setText("");
		txtDescripcion.setText("");
	}
	void editarFila() {
		if (ac.tamaño() == 0)
			limpieza();
		else {
			Oferta x = ac.obtener(tblOferta.getSelectedRow());
			txtCodigo.setText("" + x.getId());
			cboPlaca.setSelectedItem(x.getPlaca());
			txtPrecio.setText(""+x.getPrecioxDia());
			txtDescripcion.setText(x.getDescripcion());
			dcFecha.setToolTipText(x.getFechaSalida());
		}
	}
	void habilitarEntradas(boolean sino) {
		btnAceptar.setEnabled(sino);
		txtPrecio.setEditable(sino);
		cboPlaca.setEnabled(sino);
		txtDescripcion.setEditable(sino);
	}
	void habilitarBotones(boolean sino) {
		btnIngresar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	String leerPlaca() {
		return cboPlaca.getSelectedItem().toString().trim();
	}
	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	String leerDescripcion() {
		return txtDescripcion.getText().trim();
	}
	
	String leerFecha(){
		SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
		return f.format(dcFecha.getDate());
	}
	

	
	//llena el combo 
	void llenarCombo(){
		cboPlaca.addItem("[Seleccionar]");
		for (int i = 0; i <ve.tamaño(); i++) {
			
			cboPlaca.addItem(ve.obtener(i).getPlaca());
			;
		}
		
	}

	
}
