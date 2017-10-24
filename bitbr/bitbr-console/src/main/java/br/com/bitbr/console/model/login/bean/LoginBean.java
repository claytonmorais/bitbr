package br.com.bitbr.console.model.login.bean;

import br.com.bitbr.console.exception.AuthenticationException;
import br.com.bitbr.console.exception.InvalidPasswordException;

/**
 * Classe para efetuar a autenticação
 *
 */
public class LoginBean {
	
	private static LoginBean INSTANCE;
	
	/**
	 * Obtém a instancia do objeto (Singleton)
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
	 * Construtor padrão
	 * 
	 * @throws AuthenticationException
	 */
	private LoginBean() throws AuthenticationException{
		
	}
	
	
	/**
	 * Efetua a autenticação
	 * 
	 * @param username usuario
	 * @param passowrd senha
	 * @throws AuthenticationException
	 * @throws InvalidPasswordException
	 */
	public void login(String username, String password) throws AuthenticationException, InvalidPasswordException {
		 if (!"admin".equals(username) && !"admin".equals(password) ){
			 throw new InvalidPasswordException("Senha inválida");
		 }
	}
	

}
