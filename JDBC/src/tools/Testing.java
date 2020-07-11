package tools;

import controllers.RegionController;
import models.Region;

/**
 *
 * @author ASUS-PC BigBoss
 */
public class Testing {
    public static void main(String[] args) {
//        System.out.println(new Koneksi().getConnection());

        RegionController regionController = new RegionController();
        
//        insert new region
//        System.out.println(regionController.save("12", "South Africa"));

//        update a region
//        System.out.println(regionController.edit("1", "Korea"));

//        delete a region
//        System.out.println(regionController.delete("12"));
        
//        get Regions
        for (Region region : regionController.binding()){
            System.out.println("ID: "+region.getId()
            +", Name: "+region.getName()); 
        }
    }
}
