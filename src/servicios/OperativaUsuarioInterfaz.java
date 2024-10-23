package servicios;

import java.sql.Connection;
import java.util.List;

import dtos.UsuariosDtos;

public interface OperativaUsuarioInterfaz {
	/***
	 * Solicita los datos de un nuevo usuario, y se le añade a la lista de usuarios.
	 * @param listaUsuarios
	 * @author dmn - 09/10/2024
	 */
	public void altaUsuario(List<UsuariosDtos>listaUsuarios, Connection conexionGenerada);
	
	/***
	 * Metodo encargado de solicitar el dni al usuario, y eliminar al usuario especifiado.
	 * @param listaUsuarios
	 * @author dmn - 10/10/2024
	 */
	public void bajaUsuario(List<UsuariosDtos>listaUsuario,  Connection conexion);
	
	/***
	 * Metodo encargado de solicitar el dni al usuario, y modificar el campo seleccionado
	 * @param listaUsuarios
	 * @author dmn - 10/10/2024
	 */
	public void modDatosUsu(List<UsuariosDtos>listaUsuarios, Connection conexionGenerada);
	
	public void accesoUsuario(Connection conexionGenerada);
	
}
