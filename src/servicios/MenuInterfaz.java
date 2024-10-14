package servicios;

public interface MenuInterfaz {

	/***
	 * Muestra el menu principal, y recoge la seleccion del usuario
	 * @author dmn - 09/10/2024
	 * @return int seleccionUsuario
	 */
	public int menuInicial();
	
	/**
	 * Menu encargado de mostrar todos los campos que el usuario podra podificar. 
	 * Recogera la seleccion del usuario
	 * @return seleccionUsu -> Seleccion del usuario
	 * @author dmn 101024
	 */
	public int menuModUsuario();
}
