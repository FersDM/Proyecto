package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuPrincipal extends JDialog {
	private JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenu mnPago;
	private JMenu mnRegistro;
	private JMenu mnReporte;
	private JMenuItem mntmVehiculo;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmConductor;
	private JMenuItem mntmCliente;
	private JMenuItem mntmOferta;
	private JMenuItem mntmConsulta;
	private JMenuItem mntmAlquiler;
	private JMenuItem mntmRelaizaPago;
	private JMenuItem mntmConsultasVehiculos;
	private JMenuItem mntmConsultasAlquileres;
	private JMenuItem mntmServicios;
	private JMenuItem mntmVehiculosNoDevueltos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal dialog = new MenuPrincipal();
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
	public MenuPrincipal() {
		setTitle("Men\u00F9Principal");
		setBounds(100, 100, 656, 395);
		getContentPane().setLayout(null);
		
		mntmNewMenuItem = new JMenuItem("New menu item");
		mntmNewMenuItem.setBounds(-13, 11, 64, 3);
		getContentPane().add(mntmNewMenuItem);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmVehiculo = new JMenuItem("Vehiculo");
		mnMantenimiento.add(mntmVehiculo);
		
		mntmConductor = new JMenuItem("Conductor");
		mnMantenimiento.add(mntmConductor);
		
		mntmCliente = new JMenuItem("Cliente");
		mnMantenimiento.add(mntmCliente);
		
		mntmOferta = new JMenuItem("Oferta");
		mnMantenimiento.add(mntmOferta);
		
		mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		mntmConsulta = new JMenuItem("Consulta");
		mnRegistro.add(mntmConsulta);
		
		mntmAlquiler = new JMenuItem("Alquiler");
		mnRegistro.add(mntmAlquiler);
		
		mnPago = new JMenu("Pago");
		menuBar.add(mnPago);
		
		mntmRelaizaPago = new JMenuItem("Realiza Pago");
		mnPago.add(mntmRelaizaPago);
		
		mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		mntmConsultasVehiculos = new JMenuItem("Consultas Vehiculos");
		mnReporte.add(mntmConsultasVehiculos);
		
		mntmConsultasAlquileres = new JMenuItem("Consultas Alquileres");
		mnReporte.add(mntmConsultasAlquileres);
		
		mntmServicios = new JMenuItem("Servicios");
		mnReporte.add(mntmServicios);
		
		mntmVehiculosNoDevueltos = new JMenuItem("Vehiculos No Devueltos");
		mnReporte.add(mntmVehiculosNoDevueltos);

	}
}
