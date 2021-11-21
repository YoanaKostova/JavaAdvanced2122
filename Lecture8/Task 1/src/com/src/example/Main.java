package com.src.example;

import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/world?" +
                            "user=root&password=123456");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT city.Name, country.Name, city.Population, countrylanguage.Language FROM city\n" +
                    "JOIN country ON city.CountryCode = country.Code\n" +
                    "JOIN countrylanguage ON city.CountryCode = countrylanguage.CountryCode\n" +
                    "WHERE city.Population > 1000000\n" +
                    "ORDER BY city.Name;");
            List<City> cities = new ArrayList<>();
            City tempCity = new City();
            String previousCity = "";
            List<String> languages = new ArrayList<>();

            if(rs.next()){
                tempCity = new City(rs.getString("city.name"),rs.getString("country.name"),rs.getLong("city.population"));
                tempCity.addLanguage(rs.getString("countrylanguage.Language"));
                previousCity = rs.getString("city.name");
            }
            while (rs.next()) {
                if(rs.getString("city.name").equals(previousCity)){
                    tempCity.addLanguage(rs.getString("countrylanguage.Language"));
                }else{
                    cities.add(tempCity);
                    languages.clear();
                    tempCity = new City(rs.getString("city.name"),rs.getString("country.name"),rs.getLong("city.population"));
                    tempCity.addLanguage(rs.getString("countrylanguage.Language"));
                    previousCity = rs.getString("city.name");
                }
            }
            cities.add(tempCity);

            System.out.println(mostSpokenLanguage(listAllLanguages(cities)));

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                }
                stmt = null;
            }
        }
    }

    public static String mostSpokenLanguage(List<String> languages){
        Collections.sort(languages);
        int max = 0;
        int temp = 0;
        String resLanguage = "";

        for (int i = 0; i < languages.size() - 1; i++) {
            for (int j = i+1; j <languages.size() ; j++) {
                if(languages.get(i).equals(languages.get(j))){
                    temp++;
                }else{
                    if (max < temp) {
                        max = temp;
                        resLanguage = languages.get(i);
                    }
                    temp = 0;
                    i = j;
                    break;
                }
            }
        }
        return resLanguage;
    }

    public static List<String> listAllLanguages(List<City> cities){
        List<String> result = new ArrayList<>();
        for (City city : cities) {
            List<String> temp = city.getLanguages();
            for (String s : temp) {
                result.add(s);
            }
        }
        return result;
    }
}

