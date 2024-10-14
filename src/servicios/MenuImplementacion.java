package servicios;

import java.util.Scanner;

public class MenuImplementacion implements MenuInterfaz {

	Scanner sc = new Scanner(System.in);
	
	public int menuInicial() {
		int seleccionUsuario;
		
		System.out.println("#####################");
		System.out.println("#### MENU INICIAL ###");
		System.out.println("#####################");
		System.out.println("[0] -> Cerrar aplicacion.");
		System.out.println("[1] -> Alta nuevo usuario.");
		System.out.println("[2] -> Alta nuevo club.");
		System.out.println("[3] -> Baja club.");
		System.out.println("[4] -> Baja usuario.");
		System.out.println("[5] -> Modificacion club.");
		System.out.println("[6] -> Modificacion usuario.");
		seleccionUsuario = sc.nextInt();
		
		return seleccionUsuario;
	}
	
	public int accesoUsuario() {
		int seleccionUsuario;
		
		System.out.println("#########################");
		System.out.println("##### ACCESO USUARIO ####");
		System.out.println("#########################");
		System.out.println("[0] -> Subir al menu.");
		System.out.println("[1] -> Acceso Persona independiente.");
		System.out.println("[2] -> Acceso Club.");
		
		seleccionUsuario = sc.nextInt();
		
		return seleccionUsuario;
	}
	
	/*
	public int prefijoNumeroTelefono() {
		
		int seleccionUsuario;
		
		System.out.println("########################");
		System.out.println("#### NUMERO TELEFONO ###");
		System.out.println("########################");
		System.out.println("[0] -> España: +34.");
		System.out.println("[1] -> Francia: +33.");
		System.out.println("[2] -> Italia: +39.");
		System.out.println("[3] -> Reino Unido: +44.");
		System.out.println("[4] -> Alemania: +49.");
		
		seleccionUsuario = sc.nextInt();
		
		return seleccionUsuario;
	}*/
	
	
	public int menuModUsuario() {
		System.out.println("¿Que desea modificar?");
		System.out.println("[0] -> Subir un menu.");
		System.out.println("[1] -> Nombre.");
		System.out.println("[2] -> Apellidos.");
		System.out.println("[3] -> DNI.");
		System.out.println("[4] -> Email.");
		System.out.println("[5] -> Telefono.");
		
		int seleccionUsu = sc.nextInt();
		return seleccionUsu;
	}
	

	
}
