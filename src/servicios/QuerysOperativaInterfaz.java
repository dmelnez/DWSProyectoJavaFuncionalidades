package servicios;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dtos.ClubsDtos;
import dtos.UsuariosDtos;

public interface QuerysOperativaInterfaz {

	/**
	 * Metodo encargado de insertar un nuevo usuario con sus correspondientes campos, en la base de
	 * datos.
	 * @param conexionGenerada
	 * @param usuarioNuevo | Usuario nuevo creado
	 * @author dmn - 17/10/2024
	 */
	public void insertUsuariosAlta(Connection conexionGenerada, UsuariosDtos usuarioNuevo);
	
	/**
	 * Metodo encargado de seleecionar todos los id de los usuarios de la base de datos.
	 * @param conexionGenerada
	 * @param usuarioNuevo | Usuario nuevo creado
	 * @author dmn - 17/10/2024
	 */
	public ArrayList<Long>seleccionIdUsuarios(Connection conexionGenerada);
	
	/**
	 * Metodo encargado de solicitar el dni, con el que se eliminara el usuario correspondiente.
	 * @param conexionGenerada
	 * @param conexion | conexion a la base de datos |  dniAEliminar - variable del dni a eliminar
	 * @author dmn - 17/10/2024
	 */
	public void eliminarUsuario(Connection conexionGenerada, String dniAElimar);
	
	
	public void modificarUsuario(Connection conexionGenerada, String nuevoValor, String campoAModificar, String dniUsuario);

	
	/**
	 * Metodo encargado de insertar un nuevo club con sus correspondientes campos, en la base de
	 * datos
	 * @param conexionGenerada
	 * @param usuarioNuevo - Usuario nuevo creado 
	 * @author dmn - 17/10/2024
	 */
	public void insertClubsAlta(Connection conexionGenerada, ClubsDtos nuevoClub);
	
	/**
	 * Metodo encargado de seleecionar todos los id de los clubs de la base de datos.
	 * @param conexionGenerada
	 * @param conexion | conexion a la base de datos
	 * @author dmn - 17/10/2024
	 */
	public ArrayList<Long> seleccionIdClubs(Connection conexionGenerada);
	
	
	/**
	 * Metodo encargado de solicitar el aliasClub, con el que se eliminara el club correspondiente.
	 * @param conexionGenerada
	 * @param conexion | conexion a la base de datos |  dniAEliminar - variable del dni a eliminar
	 * @author dmn - 17/10/2024
	 */
	public void eliminarClub(Connection conexionGenerada, String clubAEliminar);
	
	
	

}
