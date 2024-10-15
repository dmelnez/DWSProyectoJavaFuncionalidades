package controladores;

import java.io.Console;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexionBaseDatos.*;
import dtos.ClubsDtos;
import dtos.UsuariosDtos;
import edu.jdbc.conexionPostgresql.servicios.ConexionPostgresqlImplementacion;
import edu.jdbc.conexionPostgresql.servicios.ConexionPostgresqlInterfaz;
import edu.jdbc.conexionPostgresql.servicios.ConsultasPostgresqlImplementacion;
import edu.jdbc.conexionPostgresql.servicios.ConsultasPostgresqlInterfaz;
import servicios.ConexionBaseDatosPostgresqlImplementacion;
import servicios.ConexionBaseDatosPostgresqlInterfaz;
import servicios.FicheroImplementacion;
import servicios.FicheroInterfaz;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;
import servicios.OperativaClubImplementacion;
import servicios.OperativaClubInterfaz;
import servicios.OperativaUsuarioImplementacion;
import servicios.OperativaUsuarioInterfaz;

public class Inicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<UsuariosDtos>listaUsuarios = new ArrayList<UsuariosDtos>();
		List<ClubsDtos>listaClubs = new ArrayList<ClubsDtos>();
		
		OperativaUsuarioInterfaz opUsu = new OperativaUsuarioImplementacion();
		OperativaClubInterfaz opClub = new OperativaClubImplementacion();
		FicheroInterfaz fi = new FicheroImplementacion();
		
		MenuInterfaz me = new MenuImplementacion();

		ConexionBaseDatosPostgresqlInterfaz cpi = new ConexionBaseDatosPostgresqlImplementacion();
		//ConsultasPostgresqlInterfaz consultaspi = new ConsultasPostgresqlImplementacion();
		
		try {
			Connection conexion = cpi.generaConexion();
			
			if(conexion != null) {
				System.out.println("CONEXION ESTABLECIDA");
				}	
			
		} catch (Exception e) {
			System.err.println("[ERROR-Main] Se ha producido un error al ejecutar la aplicación: " + e);
		}
			
		boolean esCerrar = false;
		String mensajeLog = "aaaaa";
		
		try {
			
			do {
				int selecionMenu = me.menuInicial();
				switch(selecionMenu) {	
				case 0:
					System.out.println("Se cerrara la aplicacion");
					mensajeLog = "[INFO] - Se cerrara la aplicacion.";
					fi.ficheroLog(mensajeLog);
					esCerrar = true;
					break;
				case 1:
					System.out.println("Se dara de alta un nuevo usuario");
					mensajeLog = "Seleccion -> Alta nuevo usuario.";					
					fi.ficheroLog(mensajeLog);
					opUsu.altaUsuario(listaUsuarios);
					break;
				case 2:
					System.out.println("Se dara de alta un nuevo club.");
					mensajeLog = "Seleccion -> Alta nuevo club.";
					fi.ficheroLog(mensajeLog);
					opClub.altaClub(listaClubs);
					break;
				case 3:
					System.out.println("Baja club.");
					mensajeLog = "Seleccion -> Baja nuevo club.";
					fi.ficheroLog(mensajeLog);
					opClub.bajaClub(listaClubs);
					break;
				case 4:
					System.out.println("Baja usuario.");
					mensajeLog = "Seleccion -> Baja nuevo usuario.";
					fi.ficheroLog(mensajeLog);
					opUsu.bajaUsuario(listaUsuarios);
					break;
				case 5:
					System.out.println("Modificacion club.");
					mensajeLog = "Seleccion -> Modificacion club.";
					fi.ficheroLog(mensajeLog);
					opClub.modDatosClub(listaClubs);
					break;
				case 6:
					System.out.println("Modificacion usuario.");
					mensajeLog = "Seleccion -> Modificacion club.";
					fi.ficheroLog(mensajeLog);
					opUsu.modDatosUsu(listaUsuarios);
					break;
				default:
					System.err.println("[ALERTA] -> Seleccion no valida.");
					mensajeLog = "[ALERTA] -> Seleccion no valida.";
					fi.ficheroLog(mensajeLog);
				
					break;
				}
				
			}while(!esCerrar);
					
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
}
