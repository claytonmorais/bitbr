package br.com.bitbr.console.model.configuration.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.bitbr.console.model.vo.Configuration;
import br.com.bitbr.dao.AbstractDAO;

public class ConfigurationDAO extends AbstractDAO {
	

	/**
	 * Salva as configurações da instancia
	 * @param configuration
	 * @throws SQLException
	 */
	public void save(Configuration configuration) throws SQLException {
		Statement stm = null;
		Connection connection = null;
		try {
		
			connection = getConnection();
			stm= connection.createStatement();
		    stm.execute("SELECT NAME,SERVER,PORT,DESCRIPTION FROM BITBR.INSTANCE");
	    
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeStatment(stm);
			closeConnection(connection);		
		}		
	}	

}
