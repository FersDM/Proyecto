package libreria;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;

public class Fecha {

	public static void setDias(JComboBox <String> cbo) {
		for (int i=1; i<=31; i++)
			cbo.addItem("" + i);
	}
	public static void setMeses(JComboBox <String> cbo) {
		cbo.addItem("Ene");
		cbo.addItem("Feb");
		cbo.addItem("Mar");
		cbo.addItem("Abr");
		cbo.addItem("May");
		cbo.addItem("Jun");
		cbo.addItem("Jul");
		cbo.addItem("Ago");
		cbo.addItem("Set");
		cbo.addItem("Oct");
		cbo.addItem("Nov");
		cbo.addItem("Dic");
	}
	public static void setAños(JComboBox <String> cbo) {
		Calendar c = new GregorianCalendar();
		int añoActual = c.get(Calendar.YEAR);
		for (int i=añoActual; i>=1900; i--)
			cbo.addItem("" + i);
	}	
	public static void setFecha(JComboBox <String> dia, JComboBox <String> mes, 
								 JComboBox <String> año) {
		Calendar c = new GregorianCalendar();
		dia.setSelectedIndex(c.get(Calendar.DAY_OF_MONTH)-1);
		mes.setSelectedIndex(c.get(Calendar.MONTH));
		año.setSelectedItem("" + c.get(Calendar.YEAR));
	}
	public static void setFecha(JComboBox <String> dia, JComboBox <String> mes, 
			                    JComboBox <String> año, String s) {
		dia.setSelectedItem(s.substring(0,2));
		mes.setSelectedIndex(Integer.parseInt(s.substring(3,5))-1);
		año.setSelectedItem(s.substring(6));
	}
	public static String getFecha(JComboBox <String> dia, JComboBox <String> mes,
			                      JComboBox <String> año) { 
		return String.format("%02d/", dia.getSelectedIndex()+1) +
			   String.format("%02d/", mes.getSelectedIndex()+1) +
			   año.getSelectedItem().toString();
	}
	
}
