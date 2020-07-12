package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Region;
import tools.Koneksi;

/**
 *
 * @author ASUS-PC BigBoss
 */
public class RegionDAO {
    private Connection connection = null;

    public RegionDAO() {
        this.connection = new Koneksi().getConnection();
    }
    
    /**
     * Function for retrieving all regions
     * @return all row from region
     */
    
    public List<Region> getRegions(){
        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM region";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region();
                region.setId(resultSet.getInt(1));
                region.setName(resultSet.getString(2));
                regions.add(region);
            }
        } catch (Exception e) {
        }
        return regions;
    }
    
    /**
     *  Inserting new data into Region
     * @param region Id and Name
     * @return True if correct and vice versa.
     */
    
    public boolean insert(Region region){
        boolean result = false;
        String query = "INSERT INTO region VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, region.getId());
            statement.setString(2, region.getName());
            statement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    /**
     *  Updating a data from Region
     * @param region Id and Name
     * @return True if correct and vice versa.
     */
    
    public boolean update(Region region){
        boolean result = false;
        String query = "UPDATE region SET name = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, region.getName());            
            statement.setInt(2, region.getId());
            statement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    /**
     *  Delete a data from Region
     * @param region Id
     * @return True if correct and vice versa.
     */
    
    public boolean delete(Region region){
        boolean result = false;
        String query = "DELETE FROM region WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, region.getId());
            statement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public Region getById(int id) {
        Region region = null;
        String query = "SELECT * FROM region WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                region = new Region(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return region;
    }
    
    public List<Region> search (String keyword) {
        List<Region> regions = new ArrayList<>();
//        String query = "SELECT * FROM region WHERE id LIKE '%"+keyword+"%' OR name LIKE '%"+keyword+"%'";
        String query = "SELECT * FROM region WHERE id LIKE ? OR name LIKE ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%"+keyword+"%");
            statement.setString(2, "%"+keyword+"%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region(resultSet.getInt(1), resultSet.getString("name"));
                regions.add(region);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return regions;
    }
}
