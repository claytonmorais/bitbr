package br.com.bitbr.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.bitbr.config.exception.ConfigException;

/**
 * Utilitário para carregar o arquivo de properties 
 *
 */
public class ConfigUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigUtil.class);
	
	private static Properties prop = new Properties();
	
	private static ConfigUtil INSTANCE;
	
	private String path;
	
	/**
	 * Construtor padrão - Path String
	 * @throws Exception em caso de erro.
	 */
	private ConfigUtil(String path) throws ConfigException{
		LOGGER.debug("invocando o constutor: ["+this.getClass().getName()+"]");	
		this.path = path;
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(path));
			prop.load(inputStream);
		} catch (IOException e) {
			throw new ConfigException("property file 'config.properties' not found in the classpath");
		} 
		
	}
	
	/**
	 * Construtor padrão input InputStream
	 * @throws Exception em caso de erro.
	 */
	private ConfigUtil(InputStream input) throws ConfigException{
		LOGGER.debug("invocando o constutor: ["+this.getClass().getName()+"]");	
		try {
			prop.load(input);
		} catch (IOException e) {
			throw new ConfigException("property file 'config.properties' not found in the classpath");
		} 
		
	}	
	
	/**
	 * Obtém a a instancia
	 * @param path caminho do properties
	 * @return Objeto config
	 * @throws ConfigException
	 */
	public static ConfigUtil getConfig(String path) throws ConfigException{
		if (INSTANCE == null){
			INSTANCE = new ConfigUtil(path);
		}		
		return INSTANCE;
	}
	
	/**
	 * Obtém a a instancia
	 * @param input via inputstream
	 * @return Objeto config
	 * @throws ConfigException
	 */
	public static ConfigUtil getConfig(InputStream input) throws ConfigException{
		if (INSTANCE == null){
			INSTANCE = new ConfigUtil(input);
		}		
		return INSTANCE;
	}	
	
	/**
	 * Obtém o valor da propriedade
	 * @param keyProps chave da propriedade
	 * @return Valor da propriedade.
	 */
	public synchronized String getConfigValue (String keyProps){
		LOGGER.debug("obtendo o valor da propriedade: ["+keyProps+"]");
		return prop.getProperty(keyProps);
	}
	

	/**
	 * Altera o valor da propriedade
	 * @param keyProps chave da propriedade
	 * @param value valor a ser alterado	  
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public synchronized void setConfigValue (String keyProps, String value) throws FileNotFoundException, IOException{
		LOGGER.debug("obtendo o valor da propriedade: ["+keyProps+","+value+"]");
		prop.setProperty(keyProps,value);
		prop.store(new FileOutputStream(path), null);
	}	
	

}
