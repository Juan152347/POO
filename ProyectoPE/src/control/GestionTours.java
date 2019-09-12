package control;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Tour;

public class GestionTours {

	public GestionTours() {
	}

	public void insertarTour(long codigo, String nombre, String lugarp, String hora, double precio,ArrayList<Tour> ListaTours) {
		ControlAgencia ca = new ControlAgencia();
		Tour ntour = new Tour(codigo, nombre, lugarp, hora, precio);
		if (ca.validarTour(codigo)) {
			ListaTours.add(ntour);
		}
	}
	public void ModificarTour(long codigo,ArrayList<Tour> listaTours) {

		Scanner x = new Scanner(System.in);

		for (Tour tour : listaTours) {

			if (codigo == tour.getCodigoIdentidad()) {

				System.out.println("Marque el numero de la opcion que desea modificar:");
				System.out.println("1) " + tour.getCodigoIdentidad());
				System.out.println("2) " + tour.getNombreComercial());
				System.out.println("3) " + tour.getLugarPartida());
				System.out.println("4) " + tour.getHoraPartida());
				System.out.println("5) " + tour.getPrecio());

				int p;
				System.out.println("Ingrese que opcion desa modificar: ");
				p = x.nextInt();
				switch (p) {

				case 1:

					long cod;
					boolean r = true;
					System.out.println("Ingrese su nuevo codigo: ");
					cod = x.nextLong();
					r = VerficarExistencia(cod,listaTours);
					if (r == false) {
						tour.setCodigoIdentidad(cod);
					} else {
						for (int i = 0; r == true; i++) {
							System.out.println("El codigo ya existe ingrese otro: ");
							cod = x.nextLong();
							r = VerficarExistencia(cod,listaTours);
							if (r == false) {
								tour.setCodigoIdentidad(cod);
							}
						}
					}
					break;

				case 2:

					System.out.println("Ingrese el nombre de tour que desea modificar");
					tour.setNombreComercial(x.next());
					break;

				case 3:

					System.out.println("Ingrese el nuevo lugar");
					tour.setLugarPartida(x.next());
					break;

				case 4:

					System.out.println("Ingrese su nueva hora de partida");
					tour.setHoraPartida(x.next());
					break;

				case 5:
					System.out.println("Ingrese su nuevo precio: ");
					tour.setPrecio(x.nextDouble());
					break;

				}
			}
		}
	}

	public boolean VerficarExistencia(long codigo,ArrayList<Tour> listaTours) {
		for (Tour tour : listaTours) {
			if (codigo == tour.getCodigoIdentidad()) {
				return true;
			}

		}
		return false;
	}
}

