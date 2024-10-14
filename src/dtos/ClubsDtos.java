package dtos;


/**
 * Clase que contendra todos los atributos que compondran a un club.
 * @author dmn 101024
 */
public class ClubsDtos {

	long id;
	
	String nombreClub = "aaaaa";
	
	long idMiembro = 99999;
	
	String aliasClub = "aaaaa";
	
	String codigoID = "aaaaa";
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreClub() {
		return nombreClub;
	}

	public void setNombreClub(String nombreClub) {
		this.nombreClub = nombreClub;
	}

	public long getIdMiembro() {
		return idMiembro;
	}

	public void setIdMiembro(long idMiembro) {
		this.idMiembro = idMiembro;
	}

	public String getAliasClub() {
		return aliasClub;
	}

	public void setAliasClub(String aliasClub) {
		this.aliasClub = aliasClub;
	}
	
	public String getCodigoID() {
		return codigoID;
	}

	public void setCodigoID(String codigoID) {
		this.codigoID = codigoID;
	}

	
	public ClubsDtos(long id, String nombreClub, long idMiembro, String aliasClub,String codigoID ) {
		super();
		this.id = id;
		this.nombreClub = nombreClub;
		this.idMiembro = idMiembro;
		this.aliasClub = aliasClub;
		this.codigoID = codigoID;
	}

	public ClubsDtos() {
		super();
	}

	
	
}
