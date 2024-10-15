package dtos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class ADto {
	
public ArrayList<UsuariosDtos> resultsUsuario(ResultSet resultadoConsulta){
		
		ArrayList<UsuariosDtos> listaUsuarios = new ArrayList<>();
		
		//Leemos el resultado de la consulta hasta que no queden filas
		try {
			while (resultadoConsulta.next()) {
				
				listaUsuarios.add(new UsuariosDtos(resultadoConsulta.getLong("id"),
						resultadoConsulta.getString("nombre_usuario"),
						resultadoConsulta.getString("apellidos_usuarioo"),
						resultadoConsulta.getString("dni_usuario"),
						resultadoConsulta.getString("email_usuario"),
						resultadoConsulta.getString("telefono_usario"))
						//resultadoConsulta.getString("direccion_usuario"))
						);
			}
			
			int i = listaUsuarios.size();
			System.out.println("[INFORMACIÓN-ADto-resultsALibrosDto] Numero de usuarios: "+i);
			
		} catch (SQLException e) {
			System.err.println("[ERROR-ADto-resultsALibrosDto] Error al pasar el result set a lista de LibroDto" + e);
		}
		
		return listaUsuarios;
		
	}
	
	public void resultsAClubs() {
		
	}
	
	
}
