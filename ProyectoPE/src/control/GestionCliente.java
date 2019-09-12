package control;

import java.util.ArrayList;

import entity.Cliente;
import entity.Reserva;

import java.util.Scanner;

import entity.Cliente;
import entity.Tour;

public class GestionCliente {

	public void eliminarCliente(long cIdentificacion, ArrayList<Cliente> listaClientes, ArrayList<Reserva> reservas) {
		for (Cliente cliente : listaClientes) {
			if (cIdentificacion == cliente.getNumeroIdentificacion()) {
				for (Reserva reserva : reservas) {
					if (cIdentificacion != reserva.getCliente().getNumeroIdentificacion()) {
						// listaClientes.remove(index)s
						System.out.println("la eliminacion ha sido correcta");
					}
				}
			}
			System.out.println("No existe algun cliente con ese numero de identificacion");
		}

	}

	public void ModificarCliente(long ID, ArrayList<Cliente> listaClientes) {

		Scanner x = new Scanner(System.in);
		int p;
		do {

			if (VerificarExistencia(ID, listaClientes)) {

				System.out.println("Marque el numero de la opcion que desea modificarr:");
				System.out.println("1.Nombre");
				System.out.println("2.ID");
				System.out.println("3.Telefono");
				System.out.println("4.salir");

				System.out.println("Ingrese que opcion desa modificar: ");
				p = x.nextInt();
				switch (p) {

				case 2:

					long cod;
					boolean r = true;
					System.out.println("Ingrese su nuevo numero de identificacion: ");
					cod = x.nextLong();
					r = VerficarExistencia(cod, listaClientes);
					if (r == false) {
						click.setNumeroIdentificacion(cod);
					} else {
						for (int i = 0; r == true; i++) {
							System.out.println("El codigo ya existe ingrese otro: ");
							cod = x.nextLong();
							r = VerficarExistencia(cod, listaClientes);
							if (r == false) {
								click.setNumeroIdentificacion(cod);
							}
						}
					}
					break;

				case 1:

					System.out.println("Ingrese su nuevo nombre");
					modnombre(ID,x.nextLine(),listaClientes);
					break;

				case 3:

					System.out.println("Ingrese su nuevo numero de contacto");
					click.setTelefonoContacto(x.next());
					break;
				}
			}

			else {
				System.out.println("El cliente solicitado no exist");
			}
		} while (p != 4);

	}

	public boolean VerificarExistencia(long ID, ArrayList<Cliente> listaClientes) {
		for (Cliente click : listaClientes) {
			if (ID == click.getNumeroIdentificacion()) {
				return true;
			}

		}
		return false;
	}
    public void mod(long ID,String nombre,ArrayList<Cliente> listaCliente) {
    	for (Cliente cliente : listaCliente) {
			if(cliente.getNumeroIdentificacion()==ID) {
				cliente.setNombreCompleto(nombre);
			}
		}
    }
	public void insertarCliente() {
		System.out.println("hola que hace");

	}
}
