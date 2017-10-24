package br.com.bitbr.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;



/**
 * Classe factory para conexão jdbc
 *
 */
public class JDBCConnection {

	private static JDBCConnection INSTANCE;

	private AmbienteJDBC ambiente;
	
	private JDBCConnection (AmbienteJDBC ambiente){
		this.ambiente = ambiente;
	}	
	
	/**
	 * Construtor padrão
	 * @param ambiente ambiente selecionado
	 * @return Instancia do objeto (Singleton)
	 */
	public static JDBCConnection getInstance(AmbienteJDBC ambiente){
		if (INSTANCE == null){
			INSTANCE = new JDBCConnection(ambiente);
		}		
		return INSTANCE;
	}
	
	/**
	 * Efetua a conexão jdbc de acordo com o ambiente selecionado
	 * @param user usuário
	 * @param password senha
	 * @return Objeto connection 
	 * @throws  
	 * @throws SisadException 
	 */
	private Connection connect(String user, String password) throws SQLException {
		Connection conn = null; 
			try {
				Class.forName(ambiente.getDataBase().getDriver());
				conn = DriverManager.getConnection(formatURLSchemma(ambiente), user, password);								
			} catch (ClassNotFoundException e) {
				throw new SQLException("Erro ao econtrar o driver jdbc: ",e);
			}				
			
			return conn;
	}
	/**
	 * Gera a url efetuando o parse na urlSchemma
	 * @param ambiente ambiente selecionado
	 * @return URL formatada
	 */
	private String formatURLSchemma(AmbienteJDBC ambiente) {
		Object[] schemmaValues = { ambiente.getServer(),ambiente.getPort(),ambiente.getDataBaseName() };
		return MessageFormat.format(ambiente.getDataBase().getUrlSchemma(), schemmaValues);
	}

	/**
	 * Obtém a conexão
	 * @return
	 * @throws SQLException 
	 * @throws Exception
	 */
	public static Connection getConnection() throws SQLException {		
		return getInstance(AmbienteJDBC.BITBR).connect("root", "");
	}
	
	
}
