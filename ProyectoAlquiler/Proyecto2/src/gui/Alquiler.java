package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Alquiler extends JDialog {
	
	DefaultTableModel mod=new DefaultTableModel();
	
	private JButton btnAlquiler;
	private JLabel lblCodigo;
	private JLabel lblNewLabel;
	private JLabel lblAuto;
	private JTextField txtCodigo;
	private JTextField txtCliente;
	private JTextField txtAuto;
	private JButton btnNewButton;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JScrollPane scrollPane;
	private JTable tblDato;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alquiler dialog = new Alquiler();
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
	public Alquiler() {
		setBounds(100, 100, 664, 458);
		getContentPane().setLayout(null);
		
		btnAlquiler = new JButton("Alquiler");
		btnAlquiler.setBounds(521, 33, 89, 23);
		getContentPane().add(btnAlquiler);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 37, 59, 14);
		getContentPane().add(lblCodigo);
		
		lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(10, 62, 46, 14);
		getContentPane().add(lblNewLabel);
		
		lblAuto = new JLabel("Auto");
		lblAuto.setBounds(10, 87, 46, 14);
		getContentPane().add(lblAuto);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(59, 34, 86, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(59, 62, 86, 20);
		getContentPane().add(txtCliente);
		txtCliente.setColumns(10);
		
		txtAuto = new JTextField();
		txtAuto.setBounds(59, 87, 86, 20);
		getContentPane().add(txtAuto);
		txtAuto.setColumns(10);
		
		btnNewButton = new JButton("Proceder");
		btnNewButton.setBounds(177, 33, 89, 23);
		getContentPane().add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"10001", "10002", "10003", "10004", "10005", "10006", "10007", "10008", "10009", "10010"}));
		comboBox.setBounds(177, 59, 89, 20);
		getContentPane().add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"20001", "20002", "20003", "20004", "20005", "20006", "20007", "20008", "20009", "20010"}));
		comboBox_1.setBounds(177, 84, 89, 20);
		getContentPane().add(comboBox_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 628, 296);
		getContentPane().add(scrollPane);
		
		tblDato = new JTable();
		scrollPane.setViewportView(tblDato);
		
		// CONFIGURAR LA TABLA
				//AGREE COLUMNAS
				mod.addColumn("Id");
				mod.addColumn("Codigo Cliente");
				mod.addColumn("Placa");
				mod.addColumn("Fecha Alquiler");
				mod.addColumn("Dias");
				mod.addColumn("Precio por dia");
				mod.addColumn("Estado");
				mod.addColumn("Reservado");
				
				
				//ASIGNAR EL MODELO A LA  TABLA
				tblDato.setModel(mod);

	}
}
