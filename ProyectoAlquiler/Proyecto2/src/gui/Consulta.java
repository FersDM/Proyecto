package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class Consulta extends JDialog {
	
	DefaultTableModel mod=new DefaultTableModel();
	
	private JLabel lblCodigoAlquiler;
	private JLabel lblCodigoCliente;
	private JTextField txtCodigoalquiler;
	private JTextField txtCodcliente;
	private JComboBox cboCodCliente;
	private JButton btnProceder;
	private JButton btnConsultar;
	private JScrollPane scrollPane;
	private JTable tblDato;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulta dialog = new Consulta();
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
	public Consulta() {
		setBounds(100, 100, 670, 449);
		getContentPane().setLayout(null);
		
		lblCodigoAlquiler = new JLabel("Codigo");
		lblCodigoAlquiler.setBounds(10, 11, 46, 14);
		getContentPane().add(lblCodigoAlquiler);
		
		lblCodigoCliente = new JLabel("Cliente");
		lblCodigoCliente.setBounds(10, 44, 46, 14);
		getContentPane().add(lblCodigoCliente);
		
		txtCodigoalquiler = new JTextField();
		txtCodigoalquiler.setBounds(79, 8, 86, 20);
		getContentPane().add(txtCodigoalquiler);
		txtCodigoalquiler.setColumns(10);
		
		txtCodcliente = new JTextField();
		txtCodcliente.setBounds(79, 41, 86, 20);
		getContentPane().add(txtCodcliente);
		txtCodcliente.setColumns(10);
		
		cboCodCliente = new JComboBox();
		cboCodCliente.setModel(new DefaultComboBoxModel(new String[] {"10001", "10002", "10003", "10004", "10005", "10006", "10007", "10008", "10009", "10010"}));
		cboCodCliente.setBounds(196, 41, 89, 20);
		getContentPane().add(cboCodCliente);
		
		btnProceder = new JButton("Proceder");
		btnProceder.setBounds(196, 7, 89, 23);
		getContentPane().add(btnProceder);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(534, 11, 89, 23);
		getContentPane().add(btnConsultar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 634, 330);
		getContentPane().add(scrollPane);
		
		tblDato = new JTable();
		scrollPane.setViewportView(tblDato);
		
		// CONFIGURAR LA TABLA
		//AGREE COLUMNAS
		
		mod.addColumn("Codigo Cliente");
		mod.addColumn("Cliente");
		mod.addColumn("Fecha consulta");
		mod.addColumn("Hora consulta");
		mod.addColumn("Monto pagar");
		mod.addColumn("Estado");
		
		
		
		//ASIGNAR EL MODELO A LA  TABLA
		tblDato.setModel(mod);

	}
}
