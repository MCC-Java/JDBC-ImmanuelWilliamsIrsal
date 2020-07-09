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
        for (Region region : regionController.binding()){
            System.out.println("ID: "+region.getId()
            +", Name: "+region.getName()); 
        }
    }
}
