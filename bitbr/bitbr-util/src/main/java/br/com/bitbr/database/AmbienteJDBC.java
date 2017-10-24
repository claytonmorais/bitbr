package br.com.bitbr.database;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.bitbr.util.GenericCollectionUtils;


public enum AmbienteJDBC {

	

	BITBR("BITBR",DataBase.MYSQL,"localhost","3306","bitbr?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

	private String name;
	private DataBase dataBase;
	private String server; 
	private String port; 
	private String dataBaseName;
	
	AmbienteJDBC(String name, DataBase dataBase, String server, String port, String dataBaseName){
		this.name = name;
		this.dataBase = dataBase;
		this.server = server;
		this.port = port;
		this.dataBaseName = dataBaseName;
	}	

	/**
	 * Retorna o objeto name
	 * @return Valor do name
	 */
	public String getName() {
		return name;
	}	
	
	
	/**
	 * Retorna o objeto dataBase
	 * @return Valor do dataBase
	 */
	public DataBase getDataBase() {
		return dataBase;
	}

	/**
	 * Retorna o objeto server
	 * @return Valor do server
	 */
	public String getServer() {
		return server;
	}

	/**
	 * Retorna o objeto port
	 * @return Valor do port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * Retorna o objeto dataBaseName
	 * @return Valor do dataBaseName
	 */
	public String getDataBaseName() {
		return dataBaseName;
	}
	
	/**
	 * Busca o elemento pelo nome
	 * @param name nome
	 * @return Objeto encontrado
	 */
	public static AmbienteJDBC findByName(String name){
	    return (AmbienteJDBC) GenericCollectionUtils.findByProperty(new ArrayList<AmbienteJDBC>(Arrays.asList(values())), name, "name");
	}
	
}
