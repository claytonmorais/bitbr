package br.com.bitbr.database;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.bitbr.util.GenericCollectionUtils;



public enum DataBase {
	
//	/jdbc:mysql://localhost/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC

	/* {0}=server, {1} = port, {2} = dataBaseName */
	MYSQL("MYSQL","com.mysql.cj.jdbc.Driver","jdbc:mysql://{0}:{1}/{2}");
	
	
	
	private String name;
	private String driver;
	private String urlSchemma;
	
	/**
	 * Construtor padrão
	 * @param name nome do banco
	 * @param driver driver class
	 * @param urlSchemma schemma da url para formatação
	 */
	DataBase(String name, String driver, String urlSchemma){
		this.name = name;
		this.driver = driver;
		this.urlSchemma = urlSchemma;
	}

	/**
	 * Retorna o objeto name
	 * @return Valor do name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retorna o objeto driver
	 * @return Valor do driver
	 */
	public String getDriver() {
		return driver;
	}	
	
	/**
	 * Retorna o objeto protocolSchemma
	 * @return Valor do protocolSchemma
	 */
	public String getUrlSchemma() {
		return urlSchemma;
	}

	/**
	 * Busca o elemento pelo nome
	 * @param name nome
	 * @return Objeto encontrado
	 */
	public static DataBase findByName(String name){
	    return (DataBase) GenericCollectionUtils.findByProperty(new ArrayList<DataBase>(Arrays.asList(values())), name, "name");
	}

	
}
