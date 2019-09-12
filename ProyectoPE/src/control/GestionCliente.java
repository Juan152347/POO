package control;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Cliente;
import entity.Tour;

public class GestionCliente {
	
	public void insertarCliente() {	
	}
		
		
		
	public void ModificarCliente(long ID,ArrayList<Cliente> listaClientes) {

			Scanner x = new Scanner(System.in);

			for (Cliente click : listaClientes) {

				if (ID == click.getNumeroIdentificacion()) {

					System.out.println("Marque el numero de la opcion que desea modificar:");
					System.out.println("1) " + click.getNombreCompleto());
					System.out.println("2) " + click.getNumeroIdentificacion());
					System.out.println("3) " + click.getTelefonoContacto());
				
					int p;
					System.out.println("Ingrese que opcion desa modificar: ");
					p = x.nextInt();
					switch (p) {

					case 2:

						long cod;
						boolean r = true;
						System.out.println("Ingrese su nuevo numero de identificacion: ");
						cod = x.nextLong();
						r = VerficarExistencia(cod,listaClientes);
						if (r == false) {
							click.setNumeroIdentificacion(cod);
						} 
						else {
							for (int i = 0; r == true; i++) {
								System.out.println("El codigo ya existe ingrese otro: ");
								cod = x.nextLong();
								r = VerficarExistencia(cod,listaClientes);
								if (r == false) {
									click.setNumeroIdentificacion(cod);
								}
							}
						}
						break;

					case 1:

						System.out.println("Ingrese su nuevo nombre");
						click.setNombreCompleto(x.next());
						break;

					case 3:

						System.out.println("Ingrese su nuevo numero de contacto");
						click.setTelefonoContacto(x.next());
						break;
					}
				}
				
				else {System.out.println("El cliente solicitado no exist");}
			}
			
			
		}
		
		
		
	public boolean VerficarExistencia(long ID,ArrayList<Cliente> listaClientes) {
			for (Cliente click : listaClientes) {
				if (ID == click.getNumeroIdentificacion()) {
					return true;
				}

			}
			return false;
		}	
		
	}


