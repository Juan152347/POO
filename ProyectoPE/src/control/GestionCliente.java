package control;

import java.util.ArrayList;

import entity.Cliente;
import entity.Reserva;

import java.util.Scanner;

import entity.Cliente;
import entity.Tour;

public class GestionCliente {
	
	public GestionCliente() {
	}
////////////////////////////////////// ELIMINAR CLIENTE /////////////////////////////////////////////////

	public void eliminarCliente(long cIdentificacion, ArrayList<Cliente> listaClientes, ArrayList<Reserva> reservas) {
		Cliente aux = buscarCliente(cIdentificacion, listaClientes);
		boolean eliminable = true;
		if (aux != null) {
			for (Reserva reserva : reservas) {
				if (aux == reserva.getCliente()) {
					eliminable = false;
					System.out.println("no se puede eliminar el cliente");
				}
			}
			if (eliminable) {
				for (Cliente cliente : listaClientes) {
					if (aux == cliente) {
						listaClientes.remove(listaClientes.indexOf(cliente));
						System.out.println("eliminacion exitosa");
					}
				}
			}
		} 
	else {
			System.out.println("el cliente no existe");
		}
	}

//////////////////////////////// MODIFICAR CLIENTE ////////////////////////////////////////////////

	public void ModificarCliente(long ID, ArrayList<Cliente> listaClientes) {

		Scanner x = new Scanner(System.in);
		int op = 0;
		do {

			if (VerificarExistencia(ID, listaClientes)) {

				System.out.println("Marque el numero de la opcion que desea modificarr:");
				System.out.println("1.Nombre");
				System.out.println("2.ID");
				System.out.println("3.Telefono");
				System.out.println("4.salir");

				System.out.println("Ingrese que opcion desa modificar: ");
				op = x.nextInt();
				switch (op) {

				case 2:

					System.out.println("Ingrese su nuevo numero de identificacion: ");
					mod(ID, listaClientes, x.nextLong());
					break;

				case 1:

					System.out.println("Ingrese su nuevo nombre");
					mod(ID, x.nextLine(), listaClientes);
					break;

				case 3:

					System.out.println("Ingrese su nuevo numero de contacto");
					mod(x.nextLine(), ID, listaClientes);
					break;
				}
			}

			else {
				System.out.println("El cliente solicitado no exist");
			}
		} while (op != 4);

	}

//////////////////////////////// VERIFICAR EXISTENCIA ///////////////////////////////////////////

	public boolean VerificarExistencia(long ID, ArrayList<Cliente> listaClientes) {
		for (Cliente click : listaClientes) {
			if (ID == click.getNumeroIdentificacion()) {
				return true;
			}

		}
		return false;
	}

///////////////////////////////// MOD NOMBRE CLIENTE /////////////////////////////////////////////////////7/

	public void mod(long ID, String nombre, ArrayList<Cliente> listaCliente) {
		for (Cliente cliente : listaCliente) {
			if (cliente.getNumeroIdentificacion() == ID) {
				cliente.setNombreCompleto(nombre);
			}
		}
	}

/////////////////////////////////// MOD ID CLIENTE //////////////////////////////////////////////////

	public void mod(long ID, ArrayList<Cliente> listaCliente, long IDn) {
		boolean idesta = false;
		for (Cliente cliente : listaCliente) {
			if (IDn == cliente.getNumeroIdentificacion()) {
				idesta = true;
			}
		}
		for (Cliente cliente : listaCliente) {
			if (cliente.getNumeroIdentificacion() == ID && idesta == false) {
				cliente.setNumeroIdentificacion(IDn);

			}
		}
	}

/////////////////////////////// MOD TELEFONO CLIENTE ////////////////////////////////////////////

	public void mod(String telefono, long ID, ArrayList<Cliente> listaCliente) {
		for (Cliente cliente : listaCliente) {
			if (cliente.getNumeroIdentificacion() == ID) {
				cliente.setTelefonoContacto(telefono);
			}
		}
	}

//////////////////////////////// INSERTAR CLIENTE ///////////////////////////////////////////////

	public void insertarCliente(long ID, String nombre, String telefono, ArrayList<Cliente> listaCliente) {
		Cliente ncliente = new Cliente(ID, nombre, telefono);
		if (!buscarCliente(listaCliente, ID)) {
			listaCliente.add(ncliente);
		}

	}

/////   /////   /////   /////     /////   /////   /////     /////   /////   /////     /////   /////   /////

	public Cliente buscarCliente(long ID, ArrayList<Cliente> listaClientes) {
		for (Cliente cliente : listaClientes) {
			if (ID == cliente.getNumeroIdentificacion()) {
				return cliente;
			}
		}
		return null;
	}

/////   /////   /////   /////     /////   /////   /////     /////   /////   /////     /////   /////   /////

	public boolean buscarCliente(ArrayList<Cliente> listaCliente, long ID) {
		for (Cliente cliente : listaCliente) {
			if (ID == cliente.getNumeroIdentificacion()) {
				
				return true;
			}
		}
		return false;
	}
}
