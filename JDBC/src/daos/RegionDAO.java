package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
