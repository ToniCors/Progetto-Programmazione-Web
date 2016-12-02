package modelDM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import oggetti.Cliente;


public class ClienteModelDM {

	private static final String TABELLA_CLIENTE = "CLIENTE";
	
	
	public synchronized void doSave(Cliente cliente) throws SQLException {
        System.out.println("tentato salvataggio");
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ClienteModelDM.TABELLA_CLIENTE
		+ " (nome, cognome, Username, email, passWorld, sesso, cellulare ,dataDiNascita) "
		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ? )";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
		
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCognome());
			preparedStatement.setString(3, cliente.getUsername());
			preparedStatement.setString(4, cliente.getEmail());
			preparedStatement.setString(5, cliente.getPassword());
			preparedStatement.setString(6, cliente.getSesso());
			preparedStatement.setString(7, cliente.getCellulare());
			preparedStatement.setString(8,cliente.getDataNascitaStr());

			preparedStatement.executeUpdate();
			System.out.println("eseguito");
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		System.out.println("salvato");
	}

	
	public synchronized Cliente doRetrieveByKey(String user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Cliente cliente = new Cliente();

		String selectSQL = "SELECT * FROM " + ClienteModelDM.TABELLA_CLIENTE + " WHERE Username = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, user);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
		
				cliente.setNome(rs.getString("nome"));
				cliente.setCognome(rs.getString("cognome"));
				cliente.setUsername(rs.getString("username"));
				cliente.setEmail(rs.getString("email"));
				cliente.setPassword(rs.getString("passWorld"));
				cliente.setSesso(rs.getString("sesso"));
				cliente.setCellulare(rs.getString("cellulare"));
				cliente.setDataNascita(rs.getString("dataDiNascita"));
				//System.out.println("rs= "+rs.getString("dataDiNascita") );
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		if(cliente.getUsername()==null)
			return null;
		else  		
		return cliente ;
	}
	
	public synchronized boolean doRetrieveByEmeil(String emeil) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean esiste=false;

		String selectSQL = "SELECT * FROM " + ClienteModelDM.TABELLA_CLIENTE + " WHERE email = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, emeil);

			ResultSet rs = preparedStatement.executeQuery();
			rs.next();

			if (rs.next()) {
				esiste=true;
				
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
				
		return  esiste;
	}
	
	
	public synchronized boolean doDelete(String user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ClienteModelDM.TABELLA_CLIENTE + " WHERE Username = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, user);

			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}


	public synchronized Collection<Cliente> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Cliente> clienti = new LinkedList<Cliente>();

		String selectSQL = "SELECT * FROM " + ClienteModelDM.TABELLA_CLIENTE;
	
		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setNome(rs.getString("nome"));
				cliente.setCognome(rs.getString("cognome"));
				cliente.setUsername(rs.getString("username"));
				cliente.setEmail(rs.getString("email"));
				cliente.setPassword(rs.getString("passWorld"));
				cliente.setSesso(rs.getString("sesso"));
				cliente.setCellulare(rs.getString("cellulare"));
				cliente.setDataNascita(rs.getString("dataDiNascita"));
				//System.out.println("rs= "+rs.getString("dataDiNascita") );

				clienti.add(cliente);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return clienti;
	}

	
}