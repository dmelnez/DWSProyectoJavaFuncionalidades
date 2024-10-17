package servicios;

import java.sql.Connection;
import java.util.List;

import dtos.ClubsDtos;
import dtos.UsuariosDtos;

public interface OperativaClubInterfaz {
	/***
	 * Solicita los datos de un nuevo club, y se le añade a la lista de clubs.
	 * @param listaClubs
	 * @author dmn - 09/10/2024
	 */
	public void altaClub(List<ClubsDtos>listaClubs,  Connection conexionGenerada);
	
	/***
	 * Metodo encargado de solicitar el id del club al usuario, y eliminar el club especifiado.
	 * @param listaUsuarios
	 * @author dmn - 10/10/2024
	 */
	public void bajaClub(List<ClubsDtos>listaClubs,  Connection conexion);
	
	/***
	 * Metodo encargado de solicitar el id del club al usuario, y modificar el campo seleccionado
	 * @param listaUsuarios
	 * @author dmn - 10/10/2024
	 */
	public void modDatosClub(List<ClubsDtos>listaClubs);
}
