package br.com.bitbr.console.model.login.bean;

import br.com.bitbr.console.exception.AuthenticationException;
import br.com.bitbr.console.exception.InvalidPasswordException;

/**
 * Classe para efetuar a autentica��o
 *
 */
public class LoginBean {
	
	private static LoginBean INSTANCE;
	
	/**
	 * Obt�m a instancia do objeto (Singleton)
	 * @return Instancia
	 * @throws AuthenticationException 
	 */
	public static LoginBean getInstance() throws AuthenticationException{
		
		if (INSTANCE == null ){
			INSTANCE = new LoginBean();
		}
		
		return INSTANCE;		
	}
	
	/**
	 * Construtor padr�o
	 * 
	 * @throws AuthenticationException
	 */
	private LoginBean() throws AuthenticationException{
		
	}
	
	
	/**
	 * Efetua a autentica��o
	 * 
	 * @param username usuario
	 * @param passowrd senha
	 * @throws AuthenticationException
	 * @throws InvalidPasswordException
	 */
	public void login(String username, String password) throws AuthenticationException, InvalidPasswordException {
		 if (!"admin".equals(username) && !"admin".equals(password) ){
			 throw new InvalidPasswordException("Senha inv�lida");
		 }
	}
	

}
