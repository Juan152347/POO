package boundary;

import control.ControlAgencia;
import control.GestionTours;
import entity.Tour;


public class PantallaAgencia {

	private ControlAgencia agencia;

	public PantallaAgencia() {
		this.agencia = new ControlAgencia();
	}
	
	public static void main(String[] args) {
		ControlAgencia ca=new ControlAgencia();
		GestionTours gt=new GestionTours();
		ca.setGestiontours(gt);
		Tour a=new Tour();
		gt.insertarTour(5555555l, "aaa", "bbbb", "2:00", 5000.0, ca.getListaTours());
		ca.verlistatours();
		System.out.println("a");
		gt.ModificarTour(5555555l, ca.getListaTours());
	}	
}