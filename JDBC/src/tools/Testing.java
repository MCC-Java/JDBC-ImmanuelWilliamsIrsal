package tools;

import controllers.CountryController;
import controllers.RegionController;
import java.util.List;
import models.Region;

/**
 *
 * @author ASUS-PC BigBoss
 */
public class Testing {
    public static void main(String[] args) {
//        System.out.println(new Koneksi().getConnection());

        RegionController regionController = new RegionController();
        CountryController countryController = new CountryController();
        
//        insert new region
//        System.out.println(regionController.save("12", "South Africa"));

//        update a region
//        System.out.println(regionController.edit("1", "Korea"));

//        delete a region
//        System.out.println(regionController.delete("12"));
        
//        get Regions
//        for (Region region : regionController.search()){
//            System.out.println("ID: "+region.getId()
//            +", Name: "+region.getName()); 
//        }

//        search a region
//        List<Region> daftarRegions = regionController.search("1");
//        for (Region region : daftarRegions) {
//            System.out.println("ID: "+region.getId()+", Name: "+region.getName());
//        }

        Region region = regionController.getById("2");
        System.out.println("ID: "+region.getId()+", Name: "+region.getName());
            

//        insert a country
//        System.out.println(countryController.save("JP", "Japan", "2"));

//        update a country
//        System.out.println(countryController.editName("KR", "South Korea", "2"));

//        delete a country
//        System.out.println(countryController.delete("JP"));

//        get Countries
//        for (Country country : countryController.binding()){
//            System.out.println("ID: "+country.getId()
//            +", Name: "+country.getName()+", Region: "+country.getRegion()); 
//        }
    }
}
