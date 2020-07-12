package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Country;
import models.Region;
import tools.Koneksi;

/**
 *
 * @author ASUS-PC BigBoss
 */
public class CountryDAO {
    private Connection connection = null;

    public CountryDAO() {
        this.connection = new Koneksi().getConnection();
    }
    
    public List<Country> getCountries(){
        List<Country> countries = new ArrayList<>();
        String query = "SELECT * FROM country";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Country country = new Country();
                country.setId(rs.getString(1));
                country.setName(rs.getString(2));
                country.setRegion(rs.getInt(3));
                countries.add(country);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return countries;
    }
    
    public boolean insert(Country country) {
        boolean result = false;
        String query = "INSERT INTO country VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, country.getId());
            statement.setString(2, country.getName());
            statement.setInt(3, country.getRegion());
            statement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public boolean updateCountryName(Country country) {
        boolean result = false;
        String query = "UPDATE country SET name = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, country.getName());
            statement.setString(2, country.getId());
            statement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public boolean updateCountryRegion(Country country) {
        boolean result = false;
        String query = "UPDATE country SET name = ?, region = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, country.getName());
            statement.setInt(2, country.getRegion());
            statement.setString(3, country.getId());
            statement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public boolean delete(Country country) {
        boolean result = false;
        String query = "DELETE FROM country WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, country.getId());
            statement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public Country getById(String id) {
        Country country = null;
        String query = "SELECT * FROM country WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                country = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return country;
    }
    
    public List<Country> search (String keyword) {
        List<Country> countries = new ArrayList<>();
        String query = "SELECT * FROM country WHERE id LIKE ? OR name LIKE ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%"+keyword+"%");
            statement.setString(2, "%"+keyword+"%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                countries.add(country);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return countries;
    }
    
} 
