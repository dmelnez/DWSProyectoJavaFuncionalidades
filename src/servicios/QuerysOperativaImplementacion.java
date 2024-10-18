package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dtos.ADto;
import dtos.ClubsDtos;
import dtos.UsuariosDtos;
//import edu.jdbc.conexionPostgresql.util.ADto;
import java.sql.Connection;


public class QuerysOperativaImplementacion implements QuerysOperativaInterfaz {


//////////////////////////// USUARIO OPERATIVA //////////////////////////////////////

public void insertUsuariosAlta(Connection conexionGenerada,UsuariosDtos usuarioNuevo) {
	

	PreparedStatement declaracionSQL = null;
	int resultadoConsulta = 0; // Cambiado a int ya que executeUpdate devuelve un int
	//ADto adto = new ADto();

	try {
	    // Se abre una declaración
	    String query = "INSERT INTO \"sch_moteros\".\"Usuarios\" (id, nombre_usuario, apellidos_usuarioo, dni_usuario, email_usuario, direccion_usuario, telefono_usuario) VALUES (?,?, ?, ?, ?, ?, ?)";
	      
	    	declaracionSQL = conexionGenerada.prepareStatement(query);

		    // Establece los parámetros
		    declaracionSQL.setLong(1, usuarioNuevo.getId_usuarios());
		    declaracionSQL.setString(2, usuarioNuevo.getNombre_usuarioString());
		    declaracionSQL.setString(3, usuarioNuevo.getApellidos_usuarioString());
		    declaracionSQL.setString(4, usuarioNuevo.getDni_usuario());
		    declaracionSQL.setString(5, usuarioNuevo.getEmail_usuario());
		    declaracionSQL.setString(6, usuarioNuevo.getDireccion_usuario());
		    declaracionSQL.setString(7, usuarioNuevo.getTelefono_usuario());

		    // Ejecuta la consulta
		    resultadoConsulta = declaracionSQL.executeUpdate();
	    
	    
	} catch (SQLException e) {
		
		System.err.println("[ERROR-ConsultasPostgresqlImplementacion-insertarUsuario] Error generando o ejecutando la declaracionSQL: " + e);
		
	}

}

public void eliminarUsuario(Connection conexionGenerada, String dniAElimar) {
	
	
	PreparedStatement declaracionSQL = null;
	//String dniAElimar = "nnnnn"; // Cambia este valor por el ID que deseas eliminar

	try {
	    // Se abre la declaración
	    String query = "DELETE FROM \"sch_moteros\".\"Usuarios\" WHERE dni_usuario = ?";
	    declaracionSQL = conexionGenerada.prepareStatement(query);
	    
	    // Establece el parámetro para el ID a eliminar
	    declaracionSQL.setString(1, dniAElimar);
	    
	    // Ejecuta la consulta
	    int filasAfectadas = declaracionSQL.executeUpdate();
	    
	    // Imprimir el resultado
	    if (filasAfectadas > 0) {
	        System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-eliminarUsuario] Usuario con ID " + dniAElimar + " eliminado exitosamente.");
	    } else {
	        System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-eliminarUsuario] No se encontró un usuario con ID " + dniAElimar + ".");
	    }
	    
	}catch (SQLException e) {
	
		
		System.err.println("[ERROR-ConsultasPostgresqlImplementacion-insertarUsuario] Error generando o ejecutando la declaracionSQL: " + e);
		
	}
	
}

///////////////////////////////////////////////////////////////////////////////////

public ArrayList<Long> seleccionIdUsuarios(Connection conexionGenerada) {
	
	Statement declaracionSQL = null;
	ResultSet resultadoConsulta = null;
	ADto adto = new ADto();
	ArrayList<Long> listaIdUsuarios = new ArrayList<>();
	
	
	try {
		
		//Se abre una declaración
		declaracionSQL = conexionGenerada.createStatement();
		//Se define la consulta de la declaración y se ejecuta
		resultadoConsulta = declaracionSQL.executeQuery("SELECT id FROM \"sch_moteros\".\"Usuarios\" ORDER BY id ASC");
	    
		//listaUsuarios =
		
		while (resultadoConsulta.next()) {
			
			listaIdUsuarios.add(resultadoConsulta.getLong("id"));
			
		}
			
		//adto.listaTodosUsuarios(resultadoConsulta, listaUsuarios);
		
		//int i = listaUsuarios.size();
		System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Número libros: "/*+ */);
		
		System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Cierre conexión, declaración y resultado");				
	    resultadoConsulta.close();
	    declaracionSQL.close();
		
	} catch (SQLException e) {
		
		System.err.println("[ERROR-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Error generando o ejecutando la declaracionSQL: " + e);
		
	}

	return listaIdUsuarios;
	
}

public void modificarUsuario(Connection conexionGenerada, String nuevoValor, String campoAModificar, String dniUsuario){
	

	 PreparedStatement declaracionSQL = null;

	    try {
	        // Se construye la consulta SQL
	        String query = "UPDATE \"sch_moteros\".\"Usuarios\" SET " + campoAModificar + " = ? WHERE dni_usuario = ?";
	        declaracionSQL = conexionGenerada.prepareStatement(query);
	        
	        // Establece los parámetros
	        declaracionSQL.setString(1, nuevoValor); // Nuevo valor para el campo especificado
	        declaracionSQL.setString(2, dniUsuario); // DNI para filtrar
	        
	        // Ejecuta la consulta
	        int filasAfectadas = declaracionSQL.executeUpdate();
	        
	        // Imprimir el resultado
	        if (filasAfectadas > 0) {
	            System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-actualizarCampoUsuario] Campo " + campoAModificar + " actualizado exitosamente para el usuario con DNI " + dniUsuario + ".");
	        } else {
	            System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-actualizarCampoUsuario] No se encontró un usuario con DNI " + dniUsuario + ".");
	        }
	    } catch (SQLException e) {
	        System.err.println("[ERROR-ConsultasPostgresqlImplementacion-actualizarCampoUsuario] Error generando o ejecutando la declaración SQL: " + e);
	    } finally {
	        // Cerrar recursos
	        if (declaracionSQL != null) {
	            try {
	                declaracionSQL.close();
	            } catch (SQLException e) {
	                System.err.println("[ERROR-ConsultasPostgresqlImplementacion-actualizarCampoUsuario] Error cerrando la declaración SQL: " + e);
	            }
	        }
	    }
	
}


///////////////////////////////////////////////////////////////////////////////////


//////////////////////////// CLUBS OPERATIVA //////////////////////////////////////

public void insertClubsAlta(Connection conexionGenerada, ClubsDtos nuevoClub) {
	

	PreparedStatement declaracionSQL = null;
	int resultadoConsulta = 0; // Cambiado a int ya que executeUpdate devuelve un int
	//ADto adto = new ADto();

	try {
	    // Se abre una declaración
	    String query = "INSERT INTO \"sch_moteros\".\"Clubs\" (id_club, nombre_club, miembros_club, alias_club, codigo_identificativo) VALUES (?, ?, ?, ?, ?)";
	      
	    	declaracionSQL = conexionGenerada.prepareStatement(query);

		    // Establece los parámetros
		    declaracionSQL.setLong(1, nuevoClub.getId());
		    declaracionSQL.setString(2, nuevoClub.getNombreClub());
		    declaracionSQL.setLong(3, nuevoClub.getIdMiembro());
		    declaracionSQL.setString(4, nuevoClub.getAliasClub());
		    declaracionSQL.setString(5, nuevoClub.getCodigoID());

		    // Ejecuta la consulta
		    resultadoConsulta = declaracionSQL.executeUpdate();
	    
	    
	} catch (SQLException e) {
		
		System.err.println("[ERROR-ConsultasPostgresqlImplementacion-insertarUsuario] Error generando o ejecutando la declaracionSQL: " + e);
		
	}
}



public void eliminarClub(Connection conexionGenerada, String clubAEliminar) {
	
	
	PreparedStatement declaracionSQL = null;

	try {
	    // Se abre la declaración
	    String query = "DELETE FROM \"sch_moteros\".\"Clubs\" WHERE alias_club = ?";
	    declaracionSQL = conexionGenerada.prepareStatement(query);
	    
	    // Establece el parámetro para el ID a eliminar
	    declaracionSQL.setString(1, clubAEliminar);
	    
	    // Ejecuta la consulta
	    int filasAfectadas = declaracionSQL.executeUpdate();
	    
	    // Imprimir el resultado
	    if (filasAfectadas > 0) {
	        System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-eliminarUsuario] Usuario con ID " + clubAEliminar + " eliminado exitosamente.");
	    } else {
	        System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-eliminarUsuario] No se encontró un usuario con ID " + clubAEliminar + ".");
	    }
	    
	}catch (SQLException e) {
	
		
		System.err.println("[ERROR-ConsultasPostgresqlImplementacion-insertarUsuario] Error generando o ejecutando la declaracionSQL: " + e);
		
	}
	
}


public ArrayList<Long> seleccionIdClubs(Connection conexionGenerada) {
	
	Statement declaracionSQL = null;
	ResultSet resultadoConsulta = null;
	ADto adto = new ADto();
	ArrayList<Long> listaIdClubs = new ArrayList<>();
	
	
try {
		
		//Se abre una declaración
		declaracionSQL = conexionGenerada.createStatement();
		//Se define la consulta de la declaración y se ejecuta
		resultadoConsulta = declaracionSQL.executeQuery("SELECT id_club FROM \"sch_moteros\".\"Clubs\" ORDER BY id_club ASC");
		
		
		while (resultadoConsulta.next()) {
			
			listaIdClubs.add(resultadoConsulta.getLong("id_club"));
			
		}
		
			
		//adto.listaTodosUsuarios(resultadoConsulta, listaUsuarios);
		
		//int i = listaUsuarios.size();
		System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Número libros: "/*+ */);
		
		System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Cierre conexión, declaración y resultado");				
	    resultadoConsulta.close();
	    declaracionSQL.close();
		
	} catch (SQLException e) {
		
		System.err.println("[ERROR-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Error generando o ejecutando la declaracionSQL: " + e);
		
	}

	return listaIdClubs;
	
}



public void modificarClubs(Connection conexionGenerada, String nuevoValor, String campoAModificar, String aliasClub){
	

	 PreparedStatement declaracionSQL = null;

	    try {
	        // Se construye la consulta SQL
	        String query = "UPDATE \"sch_moteros\".\"Clubs\" SET " + campoAModificar + " = ? WHERE alias_club = ?";
	        declaracionSQL = conexionGenerada.prepareStatement(query);
	        
	        // Establece los parámetros
	        declaracionSQL.setString(1, nuevoValor); // Nuevo valor para el campo especificado
	        declaracionSQL.setString(2, aliasClub); // DNI para filtrar
	        
	        // Ejecuta la consulta
	        int filasAfectadas = declaracionSQL.executeUpdate();
	        
	        // Imprimir el resultado
	        if (filasAfectadas > 0) {
	            System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-actualizarCampoUsuario] Campo " + campoAModificar + " actualizado exitosamente para el usuario con DNI " + aliasClub + ".");
	        } else {
	            System.out.println("[INFORMACIÓN-ConsultasPostgresqlImplementacion-actualizarCampoUsuario] No se encontró un usuario con DNI " + aliasClub + ".");
	        }
	    } catch (SQLException e) {
	        System.err.println("[ERROR-ConsultasPostgresqlImplementacion-actualizarCampoUsuario] Error generando o ejecutando la declaración SQL: " + e);
	    } finally {
	        // Cerrar recursos
	        if (declaracionSQL != null) {
	            try {
	                declaracionSQL.close();
	            } catch (SQLException e) {
	                System.err.println("[ERROR-ConsultasPostgresqlImplementacion-actualizarCampoUsuario] Error cerrando la declaración SQL: " + e);
	            }
	        }
	    }
	
}

///////////////////////////////////////////////////////////////////////////////////


}
