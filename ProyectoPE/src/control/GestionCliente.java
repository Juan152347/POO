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
	public void llenarlistaCliente(ArrayList<Cliente> clientes){
		Cliente aux=new Cliente(1034656717,"juanR","3005263714");
		clientes.add(aux);
		Cliente aux2=new Cliente(632145897,"juanA","11111111");
		clientes.add(aux2);
		Cliente aux3=new Cliente(78896544,"mateo","8888888");
		clientes.add(aux3);
	}
////////////////////////////////////// ELIMINAR CLIENTE /////////////////////////////////////////////////

	public void eliminarCliente( ArrayList<Cliente> listaClientes, ArrayList<Reserva> reservas) {
		Scanner sc=new Scanner(System.in);
		System.out.println("digite la identificacion del cliente");
		Cliente aux=new Cliente();
		long cIdentificacion=sc.nextLong();
		boolean esta = buscarCliente(cIdentificacion, listaClientes);
		boolean eliminable = true;
		if (esta) {
			for (Reserva reserva : reservas) {
				if (cIdentificacion == reserva.getCliente().getNumeroIdentificacion()) {
					eliminable = false;
					System.out.println("no se puede eliminar el cliente");
				}
			}
			if (eliminable) {
				for (Cliente cliente : listaClientes) {
					if (cIdentificacion == cliente.getNumeroIdentificacion()) {
						aux=cliente;
						
					}
					
				}
				listaClientes.remove(aux);
				System.out.println("eliminacion exitosa");
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
		
		if (VerificarExistencia(ID, listaClientes)) {
		do {
            
			

				System.out.println("Marque el numero de la opcion que desea modificarr:");
				System.out.println("1.Nombre");
				System.out.println("2.ID");
				System.out.println("3.Telefono");
				System.out.println("4.salir");

				System.out.println("Ingrese que opcion desa modificar: ");
				op = x.nextInt();
				switch (op) {

				case 2:
					
                   Cliente aux2= new Cliente();
					System.out.println("Ingrese su nuevo numero de identificacion: ");
				
					long n=x.nextLong();
					boolean esta=estanumerocliente(n,listaClientes);
					
					if(!esta) {
						for (Cliente cliente : listaClientes) {
							if(cliente.getNumeroIdentificacion()==ID) {
								aux2=cliente;
							}
						}
						aux2.setNumeroIdentificacion(n);
					}else {
						System.out.println("hay un cliente con ese id");
					}
					
					break;

				case 1:
                    Cliente aux=new Cliente();
					System.out.println("Ingrese su nuevo nombre");
					x.next();
					String nombre=x.nextLine();
					for(Cliente cli: listaClientes) {
						if(cli.getNumeroIdentificacion()==ID) {
						aux=cli;
						}
					}
					aux.setNombreCompleto(nombre);
					break;

				case 3:
					Cliente aux3=new Cliente();
					System.out.println("Ingrese su nuevo numero de contacto");
					x.next();
					String nc=x.nextLine();
					for (Cliente cliente : listaClientes) {
						if (cliente.getNumeroIdentificacion()==ID) {
							aux3=cliente;
						}
					}
					aux3.setTelefonoContacto(nc);
					break;
				}
			
		} while (op != 4);
		}

		else {
			System.out.println("El cliente solicitado no existe");
		}
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
  public boolean estanumerocliente(long ID, ArrayList<Cliente> listaClientes) {
	  for (Cliente cliente : listaClientes) {
		if(ID==cliente.getNumeroIdentificacion()) {
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

	public boolean buscarCliente(long ID, ArrayList<Cliente> listaClientes) {
		for (Cliente cliente : listaClientes) {
			if (ID == cliente.getNumeroIdentificacion()) {
				return true;
			}
		}
		return false;
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
