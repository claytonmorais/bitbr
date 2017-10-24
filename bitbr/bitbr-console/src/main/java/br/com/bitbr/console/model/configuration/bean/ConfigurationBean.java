package br.com.bitbr.console.model.configuration.bean;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.com.bitbr.console.exception.AuthenticationException;
import br.com.bitbr.console.exception.ConsoleException;
import br.com.bitbr.console.model.vo.Configuration;
import br.com.bitbr.console.model.vo.Instance;
import br.com.bitbr.util.ConfigUtil;

/**
 * Classe para efetuar a autenticação
 *
 */
public class ConfigurationBean {
	
	private static ConfigurationBean INSTANCE;
	
	/**
	 * Obtém a instancia do objeto (Singleton)
	 * @return Instancia
	 * @throws AuthenticationException 
	 */
	public static ConfigurationBean getInstance() throws AuthenticationException{
		
		if (INSTANCE == null ){
			INSTANCE = new ConfigurationBean();
		}
		
		return INSTANCE;		
	}
	
	/**
	 * Construtor padrão
	 * 
	 * @throws AuthenticationException
	 */
	private ConfigurationBean() throws AuthenticationException{
		
	}
	
	
	/**
	 * Salva a configuração 
	 * 
	 * @param configuration configuration
	 * @throws ConsoleException
	 */
	public void save(Configuration configuration,Instance instance) throws ConsoleException {		

		try {
			ConfigUtil config = ConfigUtil.getConfig(instance.getDescription());
			config.setConfigValue("txMimSale", configuration.getTxMimSale());
			config.setConfigValue("txMimPurchase", configuration.getTxMimPurchase());
			config.setConfigValue("txMaxPurchase", configuration.getTxMaxPurchase());
			config.setConfigValue("txMaxSale", configuration.getTxMaxSale());
		} catch (FileNotFoundException expt) {
			throw new ConsoleException("Erro ao salvar as configurações:",expt);
		} catch (IOException expt) {
			throw new ConsoleException("Erro ao salvar as configurações:",expt);
		}	
		
			
	}
	

}
