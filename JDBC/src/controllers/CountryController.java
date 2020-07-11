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
    
    public List<Country> binding() {
        List<Country> countries = new ArrayList<>();
        countries = this.cdao.getCountries();
        return countries;
    }
    
    public String save(String id, String name, String region) {
        String message = "Simpan data gagal";
        int regionId = Integer.parseInt(region);
        Country country = new Country(id, name, regionId);
        if (this.cdao.insert(country)) message = "Simpan data berhasil";
        return message;
    }
    
    public String editName(String id, String name, String region) {
        String message = "Perbarui data gagal";
        int regionId = Integer.parseInt(region);
        Country country = new Country(id, name, regionId);
        if (this.cdao.updateCountryName(country)) message = "Perbarui data berhasil";
        return message;
    }
    
//    public String editRegion(String id, String name, String region) {
//        String message = "Simpan data gagal";
//        int regionId = Integer.parseInt(region);
//        Country country = new Country(id, name, regionId);
//        if (this.cdao.updateCountryName(country)) message = "Simpan data berhasil";
//        return message;
//    }
    
    public String delete(String id){
        String result = "Hapus data gagal";
        Country country = new Country(id);
        if (this.cdao.delete(country)) result = "Hapus data berhasil";
        return result;
    }
    
    
}
