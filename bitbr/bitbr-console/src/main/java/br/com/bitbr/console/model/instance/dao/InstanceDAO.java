package br.com.bitbr.console.model.instance.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.bitbr.console.model.vo.Instance;
import br.com.bitbr.dao.AbstractDAO;

public class InstanceDAO extends AbstractDAO {
	
	public List<Instance> getAllInstances() throws SQLException {
		List<Instance> listReturns = new ArrayList<Instance>();
		
		Statement stm = null;
		Connection connection = null;
		ResultSet rs = null;
		try {
		
		connection = getConnection();
		stm= connection.createStatement();
	    rs = stm.executeQuery("SELECT NAME,SERVER,PORT,DESCRIPTION FROM BITBR.INSTANCE");

	    while(rs.next()){
	       listReturns.add(new Instance(rs.getString("NAME"), rs.getString("SERVER"), rs.getString("PORT"), rs.getString("DESCRIPTION")));	       
	    }
	    
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeResultSet(rs);
			closeStatment(stm);
			closeConnection(connection);
		
		}
	    
		return listReturns;
	}	

}
