package modelDM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import oggetti.Film;


public class FilmModelDM {

	private static final String TABELLA_FILM = "FILM";
	
	
	public synchronized void doSave(Film film) throws SQLException {
        System.out.println("tentato salvataggio");
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + FilmModelDM.TABELLA_FILM
		+ " (Titolo, genere, durata, regista, trailer, trama, immagine) "
		+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
		
			preparedStatement.setString(1, film.getTitolo());
			preparedStatement.setString(2, film.getGenere());
			preparedStatement.setInt(3, film.getDurata());
			preparedStatement.setString(4, film.getRegista());
			preparedStatement.setString(5, film.getTrailer());
			preparedStatement.setString(6, film.getTrama());
			preparedStatement.setString(7, film.getImmagine());
			

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

	
	public synchronized Film doRetrieveByKey(String titolo) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Film film = new Film();

		String selectSQL = "SELECT * FROM " + FilmModelDM.TABELLA_FILM + " WHERE Titolo = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, titolo);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
		
				film.setTitolo(rs.getString("titolo"));
				film.setGenere(rs.getString("genere"));
				film.setDurata(rs.getInt("durata"));
				film.setRegista(rs.getString("regista"));
				film.setTrailer(rs.getString("trailer"));
				film.setTrama(rs.getString("trama"));
				film.setImmagine(rs.getString("immagine"));
				
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		
		if(film.getTitolo()==null)
			return null;
		else  		
		return film ;
	}
	
	
	public synchronized boolean doDelete(String titolo) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + FilmModelDM.TABELLA_FILM + " WHERE Titolo = ?";

		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, titolo);

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


	public synchronized ArrayList<Film> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Film> films = new ArrayList<Film>();

		String selectSQL = "SELECT * FROM " + FilmModelDM.TABELLA_FILM;
	
		try {
			connection = DriverMaagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Film film = new Film();
				
				film.setTitolo(rs.getString("titolo"));
				film.setGenere(rs.getString("genere"));
				film.setDurata(rs.getInt("durata"));
				film.setRegista(rs.getString("regista"));
				film.setTrailer(rs.getString("trailer"));
				film.setTrama(rs.getString("trama"));
				film.setImmagine(rs.getString("immagine"));
				

				films.add(film);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return films;
	}

	
}