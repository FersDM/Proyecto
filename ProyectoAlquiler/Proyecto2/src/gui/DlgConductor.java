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

import libreria.Alerta;
import libreria.Fecha;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class DlgConductor extends JDialog implements ActionListener, MouseListener {
	
	private static final long serialVersionUID = 1L;

	private JLabel lblidConductor;
	private JLabel lblBrevete;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblCategoria;
	private JTextField txtConductor;
	private JTextField txtBrevete;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JButton btnAceptar;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGrabar;
	private JScrollPane scrollPane;
	private JTable tblConductor;
	private DefaultTableModel modelo;	
	
	ArregloConductor co = new ArregloConductor("conductor.txt");
	private JComboBox cboCategoria;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgConductor dialog = new DlgConductor();
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
	public DlgConductor() {
		setTitle("Mantenimiento | Conductor");
		setResizable(false);
		setIconImage(new ImageIcon("imagenes/PrimaTaxi.png").getImage());
		setSize(1000, 600);
		getContentPane().setLayout(null);
		
		lblidConductor = new JLabel("Id Conductor");
		lblidConductor.setBounds(728, 45, 111, 23);
		getContentPane().add(lblidConductor);
	
		lblBrevete = new JLabel("Nro Brevete");
		lblBrevete.setBounds(728, 75, 111, 23);
		getContentPane().add(lblBrevete);
		
		lblNombre = new JLabel("Nombres");
		lblNombre.setBounds(728, 105, 111, 23);
		getContentPane().add(lblNombre);

		lblApellido = new JLabel("Apellidos");
		lblApellido.setBounds(728, 139, 111, 23);
		getContentPane().add(lblApellido);
	
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(728, 173, 111, 23);
		getContentPane().add(lblCategoria);
		
		txtConductor = new JTextField();
		txtConductor.setBounds(833, 45, 151, 23);
		getContentPane().add(txtConductor);
		txtConductor.setColumns(10);
		
		txtBrevete = new JTextField();
		txtBrevete.setBounds(833, 75, 151, 23);
		getContentPane().add(txtBrevete);
		txtBrevete.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(833, 105, 151, 23);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(833, 139, 151, 23);
		getContentPane().add(txtApellidos);

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
		
		tblConductor = new JTable();
		tblConductor.addMouseListener(this);
		tblConductor.setFont(new Font("Tahoma", Font.PLAIN, 9));
		tblConductor.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblConductor);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Id Conductor");
		modelo.addColumn("Nro Brevete");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Categoria");
		tblConductor.setModel(modelo);
		
		txtConductor.setEditable(false);
		
		cboCategoria = new JComboBox();
		cboCategoria.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "A1", "A2"}));
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
		TableColumnModel tcm = tblConductor.getColumnModel();
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
		txtConductor.setText("" + co.codigoCorrelativo());
		habilitarEntradas(true);
		txtBrevete.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(false);
		if (co.tamaño() == 0) {
			btnAceptar.setEnabled(false);
			habilitarEntradas(false);
			Alerta.mensaje(this, "No existen Conductor");	
		}
		else {
			btnAceptar.setEnabled(true);
			habilitarEntradas(true);
			editarFila();
			txtBrevete.requestFocus();
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (co.tamaño() == 0)
			Alerta.mensaje(this, "No existen Conductor");
		else {
			int ok = Alerta.confirmar(this, "¿ Desea eliminar el registro ?");
			if (ok == 0) {
				co.eliminar(co.buscar(leerIdConductor()));
				listar();
				editarFila();
			}
		}
	}
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		btnIngresar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnAceptar.setEnabled(false);
		if (co.existeArchivo()) {
			int ok = Alerta.confirmar(this, "¿ Desea actualizar \"" + co.getArchivo() + "\" ?");
			if (ok == 0) {
				co.grabarConductor();
				Alerta.mensaje(this, "\"" + co.getArchivo() + "\" ha sido actualizado");
			}
			else
				Alerta.mensaje(this, "No se actualizó  \"" + co.getArchivo() + "\"");
		}
		else {
			co.grabarConductor();
			Alerta.mensaje(this, "\"" + co.getArchivo() + "\" ha sido creado");
		}
	}
	

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblConductor) {
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
		int idConductor = leerIdConductor();
		String nroBrevete = leerBrevete();
		if (nroBrevete.length() > 0) {
			String nombre = leerNombres();
			if (nombre.length() > 0) {
						String apellido = leerApellidos();
						if (apellido.length() > 0) {
							String categoria = leerCategoria();
							
							{
										if (btnIngresar.isEnabled() == false) {
											clases.Conductor nuevo = new clases.Conductor( idConductor,  nroBrevete,  nombre,  apellido,  categoria);
											co.adicionar(nuevo);
											btnIngresar.setEnabled(true);
										}
										if (btnModificar.isEnabled() == false) {
											clases.Conductor x = co.buscar(idConductor);
											x.setNroBrevete(nroBrevete);
											x.setNombre(nombre);
											x.setApellido(apellido);
											x.setCategoria(categoria);
											btnModificar.setEnabled(true);
											}
										listar();
										habilitarEntradas(false);
							}
						}
						else {
							Alerta.mensaje(this, "Ingrese Apellido correcto");
							txtApellidos.setText("");
							txtApellidos.requestFocus();
						}
					}
				
				else {
					Alerta.mensaje(this, "Ingrese Nombre  correcto");
					txtNombres.setText("");
					txtNombres.requestFocus();
			}
		}
		else {
			Alerta.mensaje(this, "Ingrese Brevete correctos");
			txtBrevete.setText("");
			txtBrevete.requestFocus();
		}
		}
	
	public void listar() {
		clases.Conductor x;
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblConductor.getSelectedRow();
		if (modelo.getRowCount() == co.tamaño()-1)
			posFila = co.tamaño()-1;
		if (posFila == co.tamaño())
			posFila --;
		modelo.setRowCount(0);
		for (int i=0; i<co.tamaño(); i++) {
			x = co.obtener(i);
			Object[] fila = { x.getIdConductor(), 
						      x.getNroBrevete(),
						      x.getNombre(),
						      x.getApellido(),
						      x.getCategoria(),
						      };
			modelo.addRow(fila);
		}
		if (co.tamaño() > 0)
			tblConductor.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void limpieza() {
		txtConductor.setText("");
		txtBrevete.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		cboCategoria.setSelectedItem("Seleccionar");
	}
	void editarFila() {
		if (co.tamaño() == 0)
			limpieza();
		else {
			clases.Conductor x = co.obtener(tblConductor.getSelectedRow());
			txtConductor.setText("" + x.getIdConductor());
			txtBrevete.setText(x.getNroBrevete());
			txtNombres.setText(x.getNombre());
			txtApellidos.setText(x.getApellido());
			cboCategoria.setSelectedItem(x.getCategoria());
		}
	}
	void habilitarEntradas(boolean sino) {
		btnAceptar.setEnabled(sino);
		txtBrevete.setEditable(sino);
		txtNombres.setEditable(sino);
		txtApellidos.setEditable(sino);
	}
	void habilitarBotones(boolean sino) {
		btnIngresar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	int leerIdConductor() {
		return Integer.parseInt(txtConductor.getText().trim());
	}
	String leerBrevete() {
		return txtBrevete.getText().trim();
	}
	String leerNombres() {
		return txtNombres.getText().trim();
	}
	String leerApellidos()
	{
		return txtApellidos.getText().trim();
	}
	String leerCategoria() {
		return cboCategoria.getSelectedItem().toString();
	}
}
