package servicios;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dtos.ClubsDtos;
import dtos.UsuariosDtos;

public interface QuerysOperativaInterfaz {

	public void insertUsuariosAlta(Connection conexionGenerada,UsuariosDtos usuarioNuevo);
	public ArrayList<Long> seleccionIdUsuarios(Connection conexionGenerada);
	public void eliminarUsuario(Connection conexionGenerada, String dniAElimar);
	
	public void insertClubsAlta(Connection conexionGenerada, ClubsDtos nuevoClub);
	public ArrayList<Long> seleccionIdClubs(Connection conexionGenerada);
	public void eliminarClub(Connection conexionGenerada, String clubAEliminar);
}
