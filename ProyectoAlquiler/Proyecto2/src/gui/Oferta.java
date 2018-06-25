package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Oferta extends JDialog implements ActionListener {
	
	DefaultTableModel mod=new DefaultTableModel();
	
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnListar;
	private JLabel lblID;
	private JTextField txtID;
	private JLabel lblPlaca;
	private JLabel lblPrecio;
	private JLabel lblDescripcion;
	private JLabel lblFechaSalida;
	private JTextField txtPlaca;
	private JTextField txtPrecio;
	private JTextField txtDescripcion;
	private JTextField txtFechaSalida;
	private JScrollPane scrollPane;
	private JTable tblDato;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Oferta dialog = new Oferta();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Oferta() {
		setBounds(100, 100, 609, 482);
		getContentPane().setLayout(null);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(478, 8, 89, 23);
		getContentPane().add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(478, 42, 89, 23);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(478, 76, 89, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(478, 110, 89, 23);
		getContentPane().add(btnEliminar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(478, 144, 89, 23);
		getContentPane().add(btnListar);
		
		lblID = new JLabel("Id");
		lblID.setBounds(10, 12, 65, 14);
		getContentPane().add(lblID);
		
		txtID = new JTextField();
		txtID.setBounds(85, 9, 110, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(10, 46, 65, 14);
		getContentPane().add(lblPlaca);
		
		lblPrecio = new JLabel("PrecioxDia");
		lblPrecio.setBounds(10, 80, 65, 14);
		getContentPane().add(lblPrecio);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 114, 54, 14);
		getContentPane().add(lblDescripcion);
		
		lblFechaSalida = new JLabel("FechaSalida");
		lblFechaSalida.setBounds(10, 148, 65, 14);
		getContentPane().add(lblFechaSalida);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(85, 43, 110, 20);
		getContentPane().add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(85, 77, 110, 20);
		getContentPane().add(txtPrecio);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(85, 111, 110, 20);
		getContentPane().add(txtDescripcion);
		
		txtFechaSalida = new JTextField();
		txtFechaSalida.setColumns(10);
		txtFechaSalida.setBounds(85, 145, 110, 20);
		getContentPane().add(txtFechaSalida);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 173, 573, 259);
		getContentPane().add(scrollPane);
		
		tblDato = new JTable();
		scrollPane.setViewportView(tblDato);
		
		// CONFIGURAR LA TABLA
		//AGREE COLUMNAS
		mod.addColumn("Id");
		mod.addColumn("Placa");
		mod.addColumn("Precio por Dia");
		mod.addColumn("Descripcion");
		mod.addColumn("Fecha salida");
		
		//ASIGNAR EL MODELO A LA  TABLA
		tblDato.setModel(mod);

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnListar) {
			actionPerformedBtnListar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
	}
	protected void actionPerformedBtnListar(ActionEvent arg0) {
	}
}
