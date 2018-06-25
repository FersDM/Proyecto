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

import Arreglos.ArregloCliente;

import libreria.Alerta;



public class DlgCliente extends JDialog implements ActionListener, MouseListener {
	
	private static final long serialVersionUID = 1L;

	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JLabel lblApellido;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JButton btnAceptar;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGrabar;
	private JScrollPane scrollPane;
	private JTable tblCliente;
	private DefaultTableModel modelo;	
	
	ArregloCliente ac = new ArregloCliente("clientes.txt");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgCliente dialog = new DlgCliente();
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
	public DlgCliente() {
		setTitle("Mantenimiento | Clientes");
		setResizable(false);
		setIconImage(new ImageIcon("imagenes/PrimaTaxi.png").getImage());
		setSize(1000, 600);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(728, 45, 111, 23);
		getContentPane().add(lblCodigo);
	
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(728, 75, 111, 23);
		getContentPane().add(lblNombres);
		
		lblApellido = new JLabel("Apellidos");
		lblApellido.setBounds(728, 105, 111, 23);
		getContentPane().add(lblApellido);

		lblTelefono = new JLabel("Teléfono");
		lblTelefono.setBounds(728, 139, 111, 23);
		getContentPane().add(lblTelefono);
	
		lblDni = new JLabel("DNI");
		lblDni.setBounds(738, 173, 111, 23);
		getContentPane().add(lblDni);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(833, 45, 151, 23);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(833, 75, 151, 23);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(833, 105, 151, 23);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(833, 139, 151, 23);
		getContentPane().add(txtTelefono);
	
		txtDni = new JTextField();
		txtDni.setBounds(833, 173, 151, 23);
		getContentPane().add(txtDni);

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
		
		tblCliente = new JTable();
		tblCliente.addMouseListener(this);
		tblCliente.setFont(new Font("Tahoma", Font.PLAIN, 9));
		tblCliente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCliente);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Teléfono");
		modelo.addColumn("DNI");
		tblCliente.setModel(modelo);
		
		txtCodigo.setEditable(false);
		habilitarEntradas(false);
		ajustarAnchoColumnas();	
		
		listar();
		editarFila();
	}
	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblCliente.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 8));  // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna( 8));  // nombres
		tcm.getColumn(2).setPreferredWidth(anchoColumna( 8));  // Apellido
		tcm.getColumn(3).setPreferredWidth(anchoColumna( 8));  // Telefono
		tcm.getColumn(4).setPreferredWidth(anchoColumna( 8));  // Dni

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
		txtCodigo.setText("" + ac.codigoCorrelativo());
		habilitarEntradas(true);
		txtNombres.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(false);
		if (ac.tamaño() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			Alerta.mensaje(this, "No existen conductor");	
		}
		else {
			btnAceptar.setEnabled(true);
			habilitarEntradas(true);
			editarFila();
			txtNombres.requestFocus();
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
				ac.grabarClientes();
				Alerta.mensaje(this, "\"" + ac.getArchivo() + "\" ha sido actualizado");
			}
			else
				Alerta.mensaje(this, "No se actualizó  \"" + ac.getArchivo() + "\"");
		}
		else {
			ac.grabarClientes();
			Alerta.mensaje(this, "\"" + ac.getArchivo() + "\" ha sido creado");
		}
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblCliente) {
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
		int codigoCliente = leerCodigo();
		String nombres = leerNombres();
		if (nombres.length() > 0) {
			String apellidos = leerApellido();
			if (apellidos.length() > 0) {
						String telefono = leerTelefono();
						if (telefono.length() > 0) {
							String dni = leerDni();
							if (dni.length() > 0){
										if (btnIngresar.isEnabled() == false) {
											clases.Cliente nuevo = new clases.Cliente(codigoCliente,  nombres,  apellidos,  telefono,  dni);
											ac.adicionar(nuevo);
											btnIngresar.setEnabled(true);
										}
										if (btnModificar.isEnabled() == false) {
											clases.Cliente x = ac.buscar(codigoCliente);
											x.setNombres(nombres);
											x.setApellidos(apellidos);
											x.setTelefono(telefono);
											x.setDni(dni);
											btnModificar.setEnabled(true);
										}	
										listar();
										habilitarEntradas(false);
									}
									
							
							else {
								Alerta.mensaje(this, "Ingrese DNI correcto");
								txtDni.setText("");
								txtDni.requestFocus();
							}
						}
						else {
							Alerta.mensaje(this, "Ingrese TELEFONO correcto");
							txtTelefono.setText("");
							txtTelefono.requestFocus();
						}
					}
				
				else {
					Alerta.mensaje(this, "Ingrese APELLIDO MATERNO correcto");
					txtApellido.setText("");
					txtApellido.requestFocus();
			}
		}
		else {
			Alerta.mensaje(this, "Ingrese NOMBRES correctos");
			txtNombres.setText("");
			txtNombres.requestFocus();
		}
		}
	
	public void listar() {
		clases.Cliente x;
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblCliente.getSelectedRow();
		if (modelo.getRowCount() == ac.tamaño()-1)
			posFila = ac.tamaño()-1;
		if (posFila == ac.tamaño())
			posFila --;
		modelo.setRowCount(0);
		for (int i=0; i<ac.tamaño(); i++) {
			x = ac.obtener(i);
			Object[] fila = { x.getCodigoCliente(), 
						      x.getNombres(),
						      x.getApellidos(),
						      x.getTelefono(),
						      x.getDni(),
						      };
			modelo.addRow(fila);
		}
		if (ac.tamaño() > 0)
			tblCliente.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void limpieza() {
		txtCodigo.setText("");
		txtNombres.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		txtDni.setText("");
	}
	void editarFila() {
		if (ac.tamaño() == 0)
			limpieza();
		else {
			clases.Cliente x = ac.obtener(tblCliente.getSelectedRow());
			txtCodigo.setText("" + x.getCodigoCliente());
			txtNombres.setText(x.getNombres());
			txtApellido.setText(x.getApellidos());
			txtTelefono.setText(x.getTelefono());
			txtDni.setText(x.getDni());
		}
	}
	void habilitarEntradas(boolean sino) {
		btnAceptar.setEnabled(sino);
		txtNombres.setEditable(sino);
		txtApellido.setEditable(sino);
		txtTelefono.setEditable(sino);
		txtDni.setEditable(sino);
	}
	void habilitarBotones(boolean sino) {
		btnIngresar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	String leerNombres() {
		return txtNombres.getText().trim();
	}
	String leerApellido() {
		return txtApellido.getText().trim();
	}
	String leerTelefono()
	{
		return txtTelefono.getText().trim();
	}
	String leerDni() {
		return txtDni.getText().trim();
	}
	
}
