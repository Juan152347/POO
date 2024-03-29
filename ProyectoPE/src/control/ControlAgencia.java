package control;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Scanner;

import entity.Tour;
import entity.Reserva;
import entity.ServicioAdicional;
import entity.Cliente;

public class ControlAgencia {

	private GestionTours gestiontours;

	private GestionCliente gestionCliente;

	private ArrayList<Tour> listaTours;
	private ArrayList<Reserva> reservas;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<ServicioAdicional> sageneral;

	public ControlAgencia() {

		GestionTours a = new GestionTours();
		GestionCliente b = new GestionCliente();
		this.listaTours = new ArrayList<>();
		this.reservas = new ArrayList<>();
		this.listaClientes = new ArrayList<>();
		this.sageneral= new ArrayList<>();
		a.llenarlistaTour(listaTours);
		b.llenarlistaCliente(listaClientes);
		llenarserv();
	}
	public void llenarserv() {
		ServicioAdicional saux=new ServicioAdicional(1,"mini nevera",15000);
		sageneral.add(saux);
		ServicioAdicional saux2=new ServicioAdicional(2,"habitacion con ventana",15000);
		sageneral.add(saux2);
		ServicioAdicional saux3=new ServicioAdicional(1,"servicio al cuarto",15000);
	}

	public GestionTours getGestiontours() {
		return gestiontours;
	}

	public void setGestiontours(GestionTours gestiontours) {
		this.gestiontours = gestiontours;
	}

	public GestionCliente getGestionCliente() {
		return gestionCliente;
	}

	public void setGestionCliente(GestionCliente gestionCliente) {
		this.gestionCliente = gestionCliente;
	}

	public ArrayList<Tour> getListaTours() {
		return listaTours;
	}

	public void setListatoures(ArrayList<Tour> listatoures) {
		this.listaTours = listatoures;
	}

	public ArrayList<Reserva> getListareservas() {
		return reservas;
	}

	public void setListareservas(ArrayList<Reserva> listareservas) {
		this.reservas = listareservas;
	}

	public ArrayList<Cliente> getlClientes() {
		return listaClientes;
	}

	public void setlClientes(ArrayList<Cliente> lClientes) {
		this.listaClientes = lClientes;
	}

////////////////////////////// VER LISTA DE TOURS ////////////////////////////////////////////////
	public void verlistatours() {
		for (Tour tour : this.listaTours) {
			System.out.println("codigo" + " " + "nombre" + " " + "precio");
			System.out.println(tour.getCodigoIdentidad() + " " + tour.getNombreComercial() + " " + tour.getPrecio());
		}
	}

	public boolean validarTour(long codigo) {
		if (codigo > 1000000 && codigo < 10000000) {
			for (Tour tour : this.listaTours) {
				if (codigo == tour.getCodigoIdentidad()) {
					return false;
				}

			}
			return true;
		} else {
			return false;
		}

	}
/////////////////////// VER LISTA CLIENTES REGISTRADOS ////////////////////////////////////////////

	public void verlistaclientes() {
		for (Cliente cliente : this.listaClientes) {
			System.out.println("numero de identificacion"+" "+"nombre"+" "+"telefono");
			System.out.println(cliente.getNumeroIdentificacion() + " " + cliente.getNombreCompleto() + " "
					+ cliente.getTelefonoContacto());
		}
	}

//////////////////////////////////////// RESERVAR TOUR ////////////////////////////////////////////////////
	public void reservarTour() {
		Scanner sc = new Scanner(System.in);
		boolean estat = false, estac = false;
		Tour auxt = new Tour();
		Cliente auxc = new Cliente();
		System.out.println("digite codigo de identificacion del tour :");
		long codt = sc.nextLong();
		for (Tour tour : listaTours) {
			if (tour.getCodigoIdentidad() == codt) {
				estat = true;
				auxt = tour;
			}
		}
		System.out.println("digite el numero de identificacion del cliente :");
		long codc = sc.nextLong();
		for (Cliente cliente : listaClientes) {
			if (cliente.getNumeroIdentificacion() == codc) {
				estac = true;
				auxc = cliente;
			}
		}
		if (estat && estac) {
			boolean fval = false;
			boolean fval2=false;
			Reserva auxr = new Reserva();
			auxr.setNumeroReserva(numerodereserva());
			Calendar cal = Calendar.getInstance();
			while (!fval && !fval2) {
				System.out.println("digite la fecha de la reserva :");
				System.out.println("a�o:");
				int a�o = sc.nextInt();
				System.out.println("mes:");
				int mes = sc.nextInt();
				System.out.println("dia:");
				int dia = sc.nextInt();
				cal.set(a�o, mes, dia);
				cal.set(Calendar.HOUR_OF_DAY, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);
				cal.set(Calendar.MILLISECOND, 0);
				fval = validarFecha(cal, auxc, auxt);
				fval2 = validarFecha(cal);
				if (!fval) {
					System.out.println("no se puede hacer la reserva intente de nuevo");
				}

			}

			System.out.println("�cuantas personas?");
			auxr.setCantidadPersonas(sc.nextInt());
			System.out.println("desea servicios adicionales S/N");
			char op = sc.next().charAt(0);
			if (op == 's' || op == 'S') {
				for (ServicioAdicional sa : sageneral) {
					System.out.println("codigo del servicio:");
					System.out.println(sa.getServicio());
					System.out.println("Nombre del servicio:");
					System.out.println(sa.getNombreServicio());
					System.out.println("Precio:");
					System.out.println(sa.getPrecio());

				}
				char op2;

				do {
					System.out.println("digite el codigo de servicio:");
					long ca = sc.nextLong();
					for (ServicioAdicional sa : sageneral) {
						if (sa.getServicio() == ca) {
							auxr.getServiciosAdicionales().add(sa);
						}
					}
					System.out.println("quiere agregar otro servicio S/N");
					op2 = sc.next().charAt(0);
				} while (op2 == 's' || op2 == 'S');
			}

			auxr.setFecha(cal);
			auxr.setTourReservado(auxt);
			auxr.setCliente(auxc);
			double ac = 0;
			System.out.println("datos de reserva");
			System.out.println("numero de reserva:" + " " + auxr.getNumeroReserva());
			System.out.println("fecha:" + " " + auxr.getFecha().getTime());
			System.out.println("nombre del tour:" + " " + auxr.getTourReservado().getNombreComercial());
			System.out.println("hora de partida:" + " " + auxr.getTourReservado().getHoraPartida());
			System.out.println("lugar de partida:" + " " + auxr.getTourReservado().getLugarPartida());
			System.out.println("precio del tour:" + " " + auxr.getTourReservado().getPrecio());
			System.out.println("Nombre del cliente:" + " " + auxr.getCliente().getNombreCompleto());
			System.out.println("personas adicionales:" + " " + auxr.getCantidadPersonas());
			System.out.println("servicios adicionales:");
			for (ServicioAdicional ser : auxr.getServiciosAdicionales()) {
				System.out.println("Nombre del servicio:" + ser.getNombreServicio());
				System.out.println("precio:" + ser.getPrecio());
				ac += ser.getPrecio();
			}
			double pto = calcularprecioreserva(auxr.getCantidadPersonas(), auxr.getTourReservado()) + ac;
			System.out.println("precio:" + " " + pto);
			auxr.setPrecio(pto);
			System.out.println("desea realizar el pago S/N");
			char op3 = sc.next().charAt(0);
			if (op3 == 's' || op3 == 'S') {
				auxr.setPagado(true);
			} else {
				auxr.setPagado(false);
			}
			reservas.add(auxr);
		} else {
			System.out.println("el tour o cliente no existe");
		}

	}

	public double calcularprecioreserva(int cantidad, Tour tour) {
		double can = tour.getPrecio() * 0.25;
		double ptotal = tour.getPrecio() + (can * cantidad);
		return ptotal;
	}

	public long numerodereserva() {
		long i = Math.round((Math.random() * (9999 - 1000 + 1) + 1000));
		for (Reserva Reserva : reservas) {
			if (i == Reserva.getNumeroReserva()) {
				return numerodereserva();
			}
		}
		return i;
	}

	public boolean validarFecha(Calendar fecha, Cliente cli, Tour tou) {
		for (Reserva reserva : reservas) {
			if (cli == reserva.getCliente() && fecha.compareTo(reserva.getFecha()) == 0
					&& tou == reserva.getTourReservado()) {
				return false;
			}
		}
		return true;
	}

	public boolean validarFecha(Calendar fecha) {
		Calendar fechaA = Calendar.getInstance();
		long mils = Math.abs(fechaA.getTimeInMillis() - fecha.getTimeInMillis());
		long dias = Math.abs(mils / 1000 / 60 / 60 / 24);
		if (dias > 2) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validarfechamod(Calendar fecha) {
		for (Reserva reserva : reservas) {
			if (reserva.getFecha().compareTo(fecha) == 0) {
				return false;
			}
		}
		return true;
	}

///////////////////////////////      MODIFICAR RESERVA /////////////////////////////////////////////////////////////////////////

	public void modificarreserva(long nreserva) {
		boolean esta = false;
		Reserva aux = new Reserva();
		ServicioAdicional aux2 =new ServicioAdicional();
		ServicioAdicional aux3 =new ServicioAdicional();
		for (Reserva reserva : reservas) {
			if (nreserva == reserva.getNumeroReserva()) {
				esta = true;
				aux = reserva;
			}
		}
		if (esta) {
			Scanner sc = new Scanner(System.in);
			int op = 0;
			boolean fval = false;
			Calendar cal = Calendar.getInstance();
			do {
				System.out.println("que dato desea modificar: ");
				System.out.println("1. fecha");
				System.out.println("2. servicios adicionales");
				System.out.println("3.cantidad de personas");
				System.out.println("4.salir");
				op = sc.nextInt();
				switch (op) {
				case 1:
					while (!fval) {
						System.out.println("digite la fecha de la reserva");
						System.out.println("a�o:");
						int a�o = sc.nextInt();
						System.out.println("mes:");
						int mes = sc.nextInt();
						System.out.println("dia:");
						int dia = sc.nextInt();
						cal.set(a�o, mes, dia);
						fval = validarfechamod(cal);
						if (!fval) {
							System.out.println("fecha invalida");
						}
					}
					aux.setFecha(cal);
					break;
				case 2:
					for (ServicioAdicional sa : aux.getServiciosAdicionales()) {
						System.out.println("codigo del servicio:");
						System.out.println(sa.getServicio());
						System.out.println("Nombre del servicio:");
						System.out.println(sa.getNombreServicio());
						System.out.println("Precio:");
						System.out.println(sa.getPrecio());
					}
					System.out.println("desea agregar o quitar servicios adicionales A/Q");
					char op2 = sc.next().charAt(0);
					if (op2 == 'A' || op2 == 'a') {
						for (ServicioAdicional sa2 : sageneral) {
							System.out.println("codigo del servicio:");
							System.out.println(sa2.getServicio());
							System.out.println("Nombre del servicio:");
							System.out.println(sa2.getNombreServicio());
							System.out.println("Precio:");
							System.out.println(sa2.getPrecio());
						}
						char ops;
						do {
							System.out.println("digite el codigo del servicio que quiere agregar");
							long cod = sc.nextLong();
							for (ServicioAdicional sa3 : sageneral) {
								if (sa3.getServicio() == cod) {
									//aux.getServiciosAdicionales().add(sa3);
									aux2=sa3;
								}
							}
							aux.getServiciosAdicionales().add(aux2);
							System.out.println("desea agregar otro servicio S/N");
							ops = sc.next().charAt(0);
						} while (ops == 's' || ops == 'S');
					} else if (op2 == 'q' || op2 == 'Q') {
						char ops2;
						do {
							System.out.println("digite el codigo del servicio que desea quitar:");
							long cod2 = sc.nextLong();
							for (ServicioAdicional sa4 : aux.getServiciosAdicionales()) {
								if (sa4.getServicio() == cod2) {
									//aux.getServiciosAdicionales().remove(aux.getServiciosAdicionales().indexOf(sa4));
									aux3=sa4;
								}
							}
							aux.getServiciosAdicionales().remove(aux3);
							System.out.println("desea quitar otro servicio S/N:");
							ops2 = sc.next().charAt(0);
						} while (ops2 == 's' || ops2 == 'S');
					}
					break;
				case 3:
					System.out.println("�cuantas personas?");
					int per = sc.nextInt();
					if (per >= 1) {
						aux.setCantidadPersonas(per);
					} else {
						System.out.println("tiene que haber minimo una persona");
					}
					break;
				default:
					break;
				}
			} while (op != 4);
		} else {
			System.out.println("la reserva no existe");
		}
	}

/////////////////////////////// ELIMINAR RESERVAR //////////////////////////////////////////////////
	public void eliminarReserva(long reserva) {

		for (Reserva reserva1 : reservas) {
			if (reserva == reserva1.getNumeroReserva()) {
				reservas.remove(reservas.indexOf(reserva1));
				System.out.println("La eliminacion de la reserva ha sido correcta");
			} else {
				System.out.println("No existe ese numero de reserva");
			}
		}

	}

////////////////////////////////// VER LISTADO RESERVAS ///////////////////////////////////////

	public void verListadoReservas() {
		for (Reserva reserva : reservas) {
			System.out.println("numero de reserva " + reserva.getNumeroReserva() + "fecha de reserva  "
					+ reserva.getFecha().getTime() + "cantidad de personas " + reserva.getCantidadPersonas() + "precio de reserva"
					+ reserva.getPrecio());
		}
	}

//////////////////////////////////// VER LISTADO FECHA ESPECIFICAR ////////////////////////////////
	public void verListadorReservaEsp(long codTour, Calendar fecha) {
		int cont = 0;
		for (Reserva reserva : reservas) {
			if (codTour == reserva.getTourReservado().getCodigoIdentidad() && fecha.compareTo(reserva.getFecha())==0) {
				System.out.println(cont + " " + reserva.getCliente().getNombreCompleto());
				cont++;
			}
		}
		System.out.println(cont + " personas iran al tour");
	}
}
