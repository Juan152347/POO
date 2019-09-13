package control;

import java.util.ArrayList;

import entity.Cliente;
import entity.Reserva;

import java.util.Scanner;

import entity.Cliente;
import entity.Tour;

public class GestionCliente {

	public void eliminarCliente(long cIdentificacion,ArrayList<Cliente>listaClientes,ArrayList<Reserva>reservas){
		boolean b= false;
		int  cont = 0;
		for (Cliente cliente : listaClientes){
			if (cIdentificacion==cliente.getNumeroIdentificacion()) {
				b=true;	
				for (Reserva reserva : reservas ) {
					if(cIdentificacion!=reserva.getCliente().getNumeroIdentificacion()) {
						listaClientes.remove(cont);
						System.out.println("la eliminacion ha sido correcta");
					}
					else {
						System.out.println("El cliente esta asociado a una reserva");
					}
				}
				cont++;
			}
			if(b==false) {
			System.out.println("No existe algun cliente con ese numero de identificacion");
		}
		
	}

	public void ModificarCliente(long ID, ArrayList<Cliente> listaClientes) {

		Scanner x = new Scanner(System.in);
		int op=0;
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
					mod(ID,listaClientes);
					break;

				case 1:

					System.out.println("Ingrese su nuevo nombre");
					mod(ID,x.nextLine(),listaClientes);
					break;

				case 3:

					System.out.println("Ingrese su nuevo numero de contacto");
					mod(x.nextLine(),ID,listaClientes);
					break;
				}
			}

			else {
				System.out.println("El cliente solicitado no exist");
			}
		} while (op != 4);

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
    public void mod(long ID,ArrayList<Cliente> listaCliente) {
    	for (Cliente cliente : listaCliente) {
    		if(cliente.getNumeroIdentificacion()==ID) {
				cliente.setNumeroIdentificacion(ID);;
			}
		}
    }
    public void mod(String telefono,long ID ,ArrayList<Cliente> listaCliente) {
    	for (Cliente cliente : listaCliente) {
			if(cliente.getNumeroIdentificacion()==ID) {
				cliente.setTelefonoContacto(telefono);
			}
		}
    }
	public void insertarCliente() {
		System.out.println("hola que hace");

	}
}
