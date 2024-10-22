package servicios;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import java.awt.SystemTray;
import java.security.AlgorithmConstraints;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import dtos.UsuariosDtos;

public class OperativaUsuarioImplementacion implements OperativaUsuarioInterfaz {
	
	
	MenuInterfaz me = new MenuImplementacion();
	Scanner sc = new Scanner(System.in);
	QuerysOperativaInterfaz qy = new QuerysOperativaImplementacion();
	

	private SecretKey secretKey;
	
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
		
		boolean esValidadoPass = false;
		
		do {
			System.out.println("Contraseña: ");
			String pass1 = sc.next();
			
			
			System.out.println("Valida contraseña: ");
			String pass2 = sc.next();

			if (pass1.equals(pass2)) {
				
				System.out.println("Contraseña validada");
				
				try {
					// Validar el codigo de encriptacion de contraseña
					String contraseniaEncriptada = Util.EncriptarPassword.encriptarPassword(pass2);
					System.out.println(contraseniaEncriptada);
					nuevoUsuario.setpassword(contraseniaEncriptada);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				
				
				esValidadoPass = true;
				break;
			}
			
			
		} while (!esValidadoPass);
		
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
		
	}
	
	
	public void modDatosUsu(List<UsuariosDtos>listaUsuarios, Connection conexionGenerada) {
				
		System.out.println("DNI: ");
		String dniUsu = sc.next();
		

		int seleccionUsu = me.menuModUsuario();

		String campoAModificar;

		switch(seleccionUsu) {
		    case 0:
		        System.out.print("Menu Inicial");
		        break;
		    case 1:
		        campoAModificar = "nombre_usuario"; // Sin punto y coma
		        System.out.print("Nombre (Nuevo): ");
		        String nombreNuevo = sc.next();
		        
		        qy.modificarUsuario(conexionGenerada, nombreNuevo, campoAModificar, dniUsu);
		        break;
		    case 2:
		        campoAModificar = "apellidos_usuario"; // Sin punto y coma
		        System.out.print("Apellidos (Nuevo): ");
		        String primerApellido = sc.next();
		        System.out.print("Segundo (Nuevo): ");
		        String segundoApellido = sc.next();   
		        
		        String apellidoCompletoString = primerApellido + " " + segundoApellido;
		        
		        qy.modificarUsuario(conexionGenerada, apellidoCompletoString, campoAModificar, dniUsu);
		        break;
		    case 3:
		        campoAModificar = "dni_usuario"; // Sin punto y coma
		        System.out.print("DNI (Nuevo): ");
		        String dniNuevo = sc.next();
		        qy.modificarUsuario(conexionGenerada, dniNuevo, campoAModificar, dniUsu);
		        break;
		    case 4:
		        campoAModificar = "email_usuario"; // Sin punto y coma
		        System.out.print("Email (Nuevo): ");
		        String emailNuevo = sc.next();
		        qy.modificarUsuario(conexionGenerada, emailNuevo, campoAModificar, dniUsu);
		        break;
		    case 5:
		        campoAModificar = "telefono_usuario"; // Sin punto y coma
		        System.out.print("Teléfono (Nuevo): ");
		        String telefonoNuevo = sc.next();
		        qy.modificarUsuario(conexionGenerada, telefonoNuevo, campoAModificar, dniUsu);
		        break;
		    default:
		        System.err.println("[ALERTA] -> Selección no válida.");
		        break;
		
		
			
		}
			
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////


	
}
