package servicios;

import java.sql.Connection;
import java.util.ArrayList;

import dtos.UsuariosDtos;

public interface QuerysOperativaInterfaz {
	public ArrayList<UsuariosDtos> insertarusuario(Connection conexionGenerada);
}
