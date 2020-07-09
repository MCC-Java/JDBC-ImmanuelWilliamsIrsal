/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import java.util.ArrayList;
import java.util.List;
import models.Region;

/**
 *
 * @author ASUS-PC BigBoss
 */
public class RegionController {
    private RegionDAO rdao;

    public RegionController() {
        this.rdao = new RegionDAO();
    }
    
    /**
     * Call function getRegion from DAO
     * @return list of regions.
     */
    
    public List<Region> binding(){
        List<Region> regions = new ArrayList<>();
        regions = this.rdao.getRegions();
        return regions;
//        return this.rdao.getRegions();
    }
    
    
}
