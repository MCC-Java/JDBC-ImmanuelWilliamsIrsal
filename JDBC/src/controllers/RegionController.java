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
    
    /**
     * Search function
     * @param keyword
     * @return list
     */
    public List<Region> search(String keyword) {
        return this.rdao.search(keyword);
    }
    
    public Region getById (String id) {
        return this.rdao.getById(Integer.parseInt(id));
    }
    
    /**
     * Adding a new region
     * @param id 
     * @param name
     * @return String 
     */
    public String save(String id, String name){
        String result = "Simpan data gagal";
//        use this if id is not setted auto increment.
//        int regionId = Integer.parseInt(id);
//        Region region = new Region(regionId, name);

        Region region = new Region(name);
        if (this.rdao.insert(region)) result = "Simpan data berhasil";
        return result;
    }
    
    /**
     * edit a region
     * @param id
     * @param name
     * @return String 
     */
    
    public String edit(String id, String name){
        String result = "Perbarui data gagal";
        int regionId = Integer.parseInt(id);
        Region region = new Region(regionId,name);
        if (this.rdao.update(region)) result = "Perbarui data berhasil";
        return result;
    }
    
    /**
     * delete a region
     * @param id
     * @return String 
     */
    public String delete(String id){
        String result = "Hapus data gagal";
        int regionId = Integer.parseInt(id);
        Region region = new Region(regionId);
        if (this.rdao.delete(region)) result = "Hapus data berhasil";
        return result;
    }
}
