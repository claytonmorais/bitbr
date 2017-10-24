package br.com.bitbr.console.dao;

import br.com.bitbr.console.model.configuration.dao.ConfigurationDAO;
import br.com.bitbr.console.model.instance.dao.InstanceDAO;
import br.com.bitbr.console.model.login.dao.LoginDAO;

/**
 * Classe abstrata dao.
 *
 */
public class DAOFactory {
	
	
	/**
	 * Retorna o DAO InstanceDAO
	 * @return retorna InstanceDAO
	 */
	public static InstanceDAO getInstanceDAO(){
		return new InstanceDAO();
	}
	
	/**
	 * Retorna o DAO LoginDAO
	 * @return retorna LoginDAO
	 */
	public static LoginDAO getLoginDAO(){
		return new LoginDAO();
	}
	
	/**
	 * Retorna o DAO ConfigurationDAO
	 * @return retorna ConfigurationDAO
	 */
	public static ConfigurationDAO getConfigurationDAO(){
		return new ConfigurationDAO();
	}


}
