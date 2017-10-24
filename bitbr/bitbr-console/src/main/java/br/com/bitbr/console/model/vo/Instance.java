/**
 * 
 */
package br.com.bitbr.console.model.vo;

import java.io.Serializable;

/**
 * Classe para salvar as configurações do robô
 *
 */
public class Instance implements Serializable {

	private String name;
	private String server;
	private String port;
	private String description;
	
	/**
	 * Serial id
	 */
	private static final long serialVersionUID = 215531474050365670L;

	public Instance(String name, String server, String port, String description) {
		this.name = name;
		this.server = server;
		this.port = port;
		this.description = description;
	}

	@Override
	public String toString() {		
		return this.name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the server
	 */
	public String getServer() {
		return server;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

}
