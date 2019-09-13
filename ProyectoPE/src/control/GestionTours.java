package control;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Tour;
import entity.Tour;

public class GestionTours {

	public GestionTours() {
	}

	public void insertarTour(long codigo, String nombre, String lugarp, String hora, double precio,
			ArrayList<Tour> ListaTours) {
		ControlAgencia ca = new ControlAgencia();
		Tour ntour = new Tour(codigo, nombre, lugarp, hora, precio);
		if (ca.validarTour(codigo)) {
			ListaTours.add(ntour);
		}
	}

	public void ModificarTour(long codigo, ArrayList<Tour> listaTours) {

		Scanner x = new Scanner(System.in);
		int p = 0;

		do {

			if (VerificarExistencia(codigo, listaTours)) {

				System.out.println("Marque el numero de la opcion que desea modificar:");
				System.out.println("1.Codigo");
				System.out.println("2.Nombre Comercial");
				System.out.println("3.Lugar de Partida");
				System.out.println("4.Hora de Partida");
				System.out.println("5.Precio");
				System.out.println("6.Salir");

				System.out.println("Ingrese que opcion desa modificar: ");
				p = x.nextInt();
				switch (p) {

				case 1: 
					
					
					break;
				
				
				}
				
				
			} 
			
			
			
			
			
			else {
				System.out.println("El cliente solicitado no exist");
			}
		} while (p != 6);
	}

	
	
	
	
	
	
	
	
////////////////////////////////////  VERIFICAR EXISTENCIA /////////////////////////////////////////	
	public boolean VerificarExistencia(long codigo, ArrayList<Tour> listaTours) {
		for (Tour tour : listaTours) {
			if (codigo == tour.getCodigoIdentidad()) {
				return true;
			}

		}
		return false;
	}
///////////////////////////////MODIFICAR//////////////////////////////////////////////////////////	
	  public void mod (long cod,String nombre,ArrayList<Tour> listaTours) {
	    	for (Tour tour : listaTours) {
				if(tour.getCodigoIdentidad()==cod) {
					tour.setNombreComercial(nombre);
				}
			}
	    }
///////////////////////////////////////////////////////////////////////////////////////////////////	  
	  public void mod(String lugar,long cod,ArrayList<Tour> listaTours) {
	    	for (Tour tour : listaTours) {
				if(tour.getCodigoIdentidad()==cod) {
					tour.setLugarPartida(lugar);
				}
			}
	    }
//////////////////////////////////////////////////////////////////////////////////////////////////7
	  public void mod(ArrayList<Tour> listaTours,String hora,long cod) {
	    	for (Tour tour : listaTours) {
				if(tour.getCodigoIdentidad()==cod) {
					tour.setHoraPartida(hora);;
				}
			}
	    }
//////////////////////////////////////////////////////////////////////////////////////////////////

}
