package libreria;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Alerta {
	
	public static void mensaje(JDialog jd, String s) {
		JOptionPane.showMessageDialog(jd, s, "PrimaTaxi ® >>> MN-Global ®", 2);
	}
	public static int confirmar(JDialog jd, String s) {
		return JOptionPane.showConfirmDialog(jd, s, "PrimaTaxi ® >>> MN-Global ®", 0, 3, null);
	}
	
}
