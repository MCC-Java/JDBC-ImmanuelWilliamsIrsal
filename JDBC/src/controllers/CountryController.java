/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDAO;
import java.util.ArrayList;
import java.util.List;
import models.Country;

/**
 *
 * @author ASUS-PC
 */
public class CountryController {
    private CountryDAO cdao;

    public CountryController() {
        this.cdao = new CountryDAO();
    }
    
    /**
     * Retrieving all countries.
     * @return List
     */
    public List<Country> binding() {
        List<Country> countries = new ArrayList<>();
        countries = this.cdao.getCountries();
        return countries;
    }
    
    /**
     * Adding a country
     * @param id
     * @param name
     * @param region
     * @return String
     */
    public String save(String id, String name, String region) {
        String message = "Simpan data gagal";
        int regionId = Integer.parseInt(region);
        Country country = new Country(id, name, regionId);
        if (this.cdao.insert(country)) message = "Simpan data berhasil";
        return message;
    }
    
    /**
     * Updating a country
     * @param id
     * @param name
     * @param region
     * @return String
     */
    public String edit(String id, String name, String region) {
        String message = "Perbarui data gagal";
        int regionId = Integer.parseInt(region);
        Country country = new Country(id, name, regionId);
        if (this.cdao.updateCountryName(country)) message = "Perbarui data berhasil";
        return message;
    }
    
    /**
     * Deleting a country
     * @param id
     * @return String
     */
    public String delete(String id){
        String result = "Hapus data gagal";
        Country country = new Country(id);
        if (this.cdao.delete(country)) result = "Hapus data berhasil";
        return result;
    }
    
    
}
