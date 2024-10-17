package servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import dtos.UsuariosDtos;

public class OperativaUsuarioImplementacion implements OperativaUsuarioInterfaz {
	
	
	MenuInterfaz me = new MenuImplementacion();
	Scanner sc = new Scanner(System.in);
	QuerysOperativaInterfaz qy = new QuerysOperativaImplementacion();

	public void altaUsuario(List<UsuariosDtos>listaUsuarios, Connection conexionGenerada) {
		
	
		UsuariosDtos nuevoUsuario = new UsuariosDtos();
		
		nuevoUsuario.setId_usuarios(idIncremental(conexionGenerada));
		
		System.out.println("Nombre:");
		nuevoUsuario.setNombre_usuarioString(sc.next());
		
		System.out.println("Primer Apellido:");
		String primerApellido = sc.next();
		
		System.out.println("Segundo Apellido:");
		String segundoApellido = sc.next();
		
		nuevoUsuario.setApellidos_usuarioString(primerApellido + " " + segundoApellido);
		
		System.out.println("Direccion:");
		String direccionUsuario = sc.next();
		nuevoUsuario.setDireccion_usuario(direccionUsuario);
		
		// Comprobar dni
		boolean esValidado = false;
		
		do {
			
			System.out.println("DNI:");
			String dniUsuario = sc.next();
			
			if (validarDNI(dniUsuario)) {
				
				esValidado = true;
				nuevoUsuario.setDni_usuario(dniUsuario);
			}
			
		} while (!esValidado);

      
		
		
				
		/////////////////////////////////////////////////////////////////////////////
		
		System.out.println("Telefono:");
		nuevoUsuario.setTelefono_usuario(sc.next());
		
		System.out.println("Email:");
		nuevoUsuario.setEmail_usuario(sc.next());
		
		qy.insertUsuariosAlta(conexionGenerada, nuevoUsuario);
		
		listaUsuarios.add(nuevoUsuario);
		
		for (var usuario : listaUsuarios) {
			System.out.println(usuario.getId_usuarios());
			System.out.println(usuario.getNombre_usuarioString());
			System.out.println(usuario.getApellidos_usuarioString());
			System.out.println(usuario.getTelefono_usuario());
			System.out.println(usuario.getEmail_usuario());
			System.out.println(usuario.getDni_usuario());

		}
		
	}
	
	
	private long idIncremental(Connection conexionGenerada) {
		
		List<Long>listaIdUsuarios = new ArrayList<Long>();
		listaIdUsuarios = qy.seleccionIdUsuarios(conexionGenerada);
		
		long id = 0;
		
		int tamanioLista = listaIdUsuarios.size();
		
		if(tamanioLista == 0) {
			id = 1;
		}
		
		else {
			id = listaIdUsuarios.get(tamanioLista - 1) + 1;
		}
		
		System.out.println(id);
		
		return id;
	}
	

	/**
	 * Metodo encargado de validar el dni del usuario
	 * @param dniUsu
	 * @return validarDNI | Devuelve un true, si el dni es correcto. Si no lo es, devuelve un false
	 * dmn 1410204
	 */ 
	
	private boolean validarDNI(String dniUsu) {
		
		boolean dniValidado = false;
		
		String dniLetras="TRWAGMYFPDXBNJZSQVHLCKE";
		   

	       String numeros = dniUsu.substring(0, dniUsu.length() - 1);
	       char letra = dniUsu.charAt(dniUsu.length() - 1); 

	      
	       int dniNumeros = Integer.parseInt(numeros);

	       int indice = dniNumeros % 23;
	       
	       if (dniLetras.charAt(indice) == letra) {
			
	    	   dniValidado = true;
	    	   System.out.println("DNI VALIDADO");
	       } 
	        
		   
		return dniValidado;
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////
	
	public void bajaUsuario(List<UsuariosDtos>listaUsuario, Connection conexion) {
		
		System.out.println("DNI: ");
		String dniAEliminar = sc.next();
		
		qy.eliminarUsuario(conexion, dniAEliminar);
		
		/*
		for (UsuariosDtos usuariosDtos : listaUsuario) {
			if(usuariosDtos.getDni_usuario().equals(dniAEliminar)) {
				
				listaUsuario.remove(usuariosDtos);
				System.out.println("Se ha elimina el usuario");
				
			}
		}*/
		
	}
	
	
	public void modDatosUsu(List<UsuariosDtos>listaUsuarios) {
				
		System.out.println("DNI: ");
		String dniUsu = sc.next();
		
		for (UsuariosDtos usuarios : listaUsuarios) {
			if (usuarios.getDni_usuario().equals(dniUsu)) {
				
				int seleccionUsu = me.menuModUsuario();
				
				switch(seleccionUsu) {
				
				case 0:
					System.out.print("Menu Inicial");
					break;
				case 1:
					System.out.print("Nombre (Nuevo)");
					usuarios.setNombre_usuarioString(sc.next());
					break;
				case 2:
					System.out.print("Apellidos (Nuevo)");
					String primerApellido = sc.next();
					System.out.print("Segundo (Nuevo)");
					String segunApellido = sc.next();				
					usuarios.setApellidos_usuarioString(primerApellido + " " + segunApellido);
					break;
				case 3:
					System.out.print("DNI (Nuevo)");
					usuarios.setDni_usuario(sc.next());
					break;
				case 4:
					System.out.print("Email (Nuevo)");
					usuarios.setEmail_usuario(sc.next());
					break;
				case 5:
					System.out.print("Telefono (Nuevo)");
					break;
				default:
					System.err.println("[ALERTA] -> Seleccion no valida.");
					break;
				
				}
				
			}
		}
		
		
		
		
	}
	
	
	

	
}
