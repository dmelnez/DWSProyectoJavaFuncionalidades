package servicios;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
//import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import dtos.ClubsDtos;
import dtos.UsuariosDtos;

public class OperativaClubImplementacion implements OperativaClubInterfaz {

	Scanner sc = new Scanner(System.in);
	QuerysOperativaInterfaz qy = new QuerysOperativaImplementacion();
	
	public void altaClub(List<ClubsDtos>listaClubs, Connection conexionGenerada) {
		
		ClubsDtos nuevoClub = new ClubsDtos();
		
		// Metodo encargado de la generacion de un id autonumerico.
		
		nuevoClub.setId(idIncremental(conexionGenerada));
		
		//////////////////////////////////////////////////////////////////////////////
		
		// Metodo de la creacion de un codigo referente al club.
		
	      String[] letras = {
	              "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
	              "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
	              "U", "V", "W", "X", "Y", "Z"
	          };
		
        Random random = new Random();
        
        StringBuilder resultado = new StringBuilder();

        int cantidad = 6;
        
        for (int i = 0; i < cantidad; i++) {
            int indiceAleatorio = random.nextInt(letras.length);
            resultado.append(letras[indiceAleatorio]);
        }
        nuevoClub.setCodigoID(resultado.toString());
        
        ////////////////////////////////////////////////////////////////////////////////
        
        System.out.println(resultado);
		
		
		System.out.println("Nombre club: ");
		nuevoClub.setNombreClub(sc.next());
		
		System.out.println("Alias club: ");
		String aliasClub = sc.next();
		nuevoClub.setAliasClub(aliasClub);
		for (ClubsDtos club : listaClubs) {
			if(club.getAliasClub().equals(aliasClub)) {
				System.err.println("[ALERTA] -> El alias ya existe.");
				return;
			}
		}
		
		qy.insertClubsAlta(conexionGenerada, nuevoClub);
		
		nuevoClub.setAliasClub(aliasClub);
		
		listaClubs.add(nuevoClub);
		
		for (ClubsDtos clubsDtos : listaClubs) {
			System.out.println(clubsDtos.getId());
			System.out.println(clubsDtos.getNombreClub());
			System.out.println(clubsDtos.getIdMiembro());
			System.out.println(clubsDtos.getAliasClub());
			System.out.println(clubsDtos.getCodigoID());
		}
		
	}
	
	
	private long idIncremental(Connection conexionGenerada) {
		
		
		List<Long>listaIdClubs = new ArrayList<Long>();
		listaIdClubs = qy.seleccionIdClubs(conexionGenerada);
		
		long id = 0;
		
		int tamanioLista = listaIdClubs.size();
		
		if(tamanioLista == 0) {
			id = 1;
		}
		
		else {
			id = listaIdClubs.get(tamanioLista - 1) + 1;
		}
		
		System.out.println(id);
		
		return id;
	}
	

	public void bajaClub(List<ClubsDtos>listaClubs, Connection conexion) {
		
		System.out.println("Alias club: ");
		String aliasClub = sc.next();
		qy.eliminarClub(conexion, aliasClub);
		try {
			
			
			/*for (ClubsDtos club : listaClubs) {
				if(club.getAliasClub().equals(aliasClub)) {
					
					listaClubs.remove(club);
					System.out.println("Se ha elimina el club");
					
				}
			}*/
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	
	public void modDatosClub(List<ClubsDtos>listaClubs) {
		
		System.out.println("Alias club: ");
		String aliasClub = sc.next();
		
		for (ClubsDtos club : listaClubs) {
			if(club.getAliasClub() == aliasClub) {
				
				System.out.println("Nombre (Nuevo)");
				club.setNombreClub(sc.next());
				
			}
		}
		
		
	}
}
