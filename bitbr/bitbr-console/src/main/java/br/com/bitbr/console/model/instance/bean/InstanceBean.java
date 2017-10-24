package br.com.bitbr.console.model.instance.bean;

import java.sql.SQLException;
import java.util.List;

import br.com.bitbr.console.dao.DAOFactory;
import br.com.bitbr.console.exception.AuthenticationException;
import br.com.bitbr.console.exception.ConsoleException;
import br.com.bitbr.console.model.vo.Configuration;
import br.com.bitbr.console.model.vo.Instance;

/**
 * Classe para efetuar a autenticação
 *
 */
public class InstanceBean {
	
	private static InstanceBean INSTANCE;
	
	/**
	 * Obtém a instancia do objeto (Singleton)
	 * @return Instancia
	 * @throws AuthenticationException 
	 */
	public static InstanceBean getInstance() throws AuthenticationException{
		
		if (INSTANCE == null ){
			INSTANCE = new InstanceBean();
		}
		
		return INSTANCE;		
	}
	
	/**
	 * Construtor padrão
	 * 
	 * @throws AuthenticationException
	 */
	private InstanceBean() throws AuthenticationException{
		
	}
	
	
	/**
	 * Salva a configuração 
	 * 
	 * @param configuration configuration
	 * @throws ConsoleException
	 */
	public void save(Configuration configuration) throws ConsoleException {
		try {
			DAOFactory.getConfigurationDAO().save(configuration);
		} catch (SQLException e) {
			throw new ConsoleException("Erro ao salvar as configurações da instancia: ",e);
		}		
	}

	public List<Instance> getAllInstances() {
		try {
			return DAOFactory.getInstanceDAO().getAllInstances();
		} catch (SQLException e) {
			throw new ConsoleException("Erro ao obter as instancias: ",e);
		}
	}
	

}
