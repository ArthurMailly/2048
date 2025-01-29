package com.ares.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class bdConnection {
    String jdbcUrl = "jdbc:postgresql://localhost:5432/DMQH_java";
    String username = "";//ICI AJOUTER VOTRE NOM D'UTILISATEUR
    String password = "";//ICI AJOUTER VOTRE MOT DE PASSE

    private static final String CREATE_TABLE_SQL = "CREATE TABLE score"
            + "("
            + "username VARCHAR(255) PRIMARY KEY,"
            + "score INT"
            + ")";
    private static final String INSERT_SQL = "INSERT INTO score (username, score) VALUES (?, ?)";
    private static final String SELECT_SQL = "SELECT * FROM score WHERE username = '%s'";
    private static final String UPDATE_SQL = "UPDATE score SET score = ? WHERE username = ?";
    private static final String DELETE_SQL = "DELETE FROM score WHERE username = '%s'";
    private static final String SELECT_ALL_SQL = "SELECT * FROM score";
    private static final String DROP_TABLE="DROP TABLE score";

    public bdConnection() {
        try
        {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            if(connection != null)
            {
                System.out.println("Connected to the database");
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public void CreateDB()
    {
        try
        {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_SQL);
            preparedStatement.executeUpdate();
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public ResultSet printAllinDB()
    {
        ResultSet resultSet = null;
        try
        {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void insertNewScore(int score)
    {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
         PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {

        preparedStatement.setString(1, username);
        preparedStatement.setInt(2, score);

        int rowsInserted = preparedStatement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Insertion réussie !");
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateScore(int newScore) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
    
            preparedStatement.setInt(1, newScore);
            preparedStatement.setString(2, username);
    
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Mise à jour réussie !");
            } else {
                System.out.println("Aucun utilisateur trouvé.");
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DropTable()
    {
        try
        {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(DROP_TABLE);
            preparedStatement.executeUpdate();
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }


    public void closeConnection()
    {
        try
        {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            connection.close();
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
    
