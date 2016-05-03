/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resttest.service;

import com.mycompany.resttest.database.DatabaseClass;
import com.mycompany.resttest.model.Profile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Janaka Anuruddha
 */
public class ProfileService {

    private Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService() {
//        profiles.put("Janaka", new Profile("Janaka", "Janaka", "Anu"));
//        profiles.put("Thara", new Profile("Thara", "Thara", "Patiya"));
    }

    public List<Profile> getProfiles() {
        return new ArrayList<>(profiles.values());
    }

    public Profile getProfile(String profile) {
        return profiles.get(profile);
    }

    public Profile updateProfile(Profile profile) {
        if (profile.getId() <= 0) {
            return null;
        }
        profiles.put(profile.getName(), profile);
        return profile;
    }

    public Profile addProfile(Profile profile) {
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getName(), profile);
        return profile;
    }

    public Profile removeProfile(String profile) {
        return profiles.remove(profile);
    }

//    public List<Profile> getAllMessages2() {
//        SubMessage sb1 = new SubMessage("111111111");
//        SubMessage sb2 = new SubMessage("222222222");
//        Profile m1 = new Profile(1L, "Hello World", "Janaka", sb1);
//        Profile m2 = new Profile(2L, "Hello Jersey", "Janaka", sb2);
//
//        List<Profile> l = new ArrayList<>();
//        l.add(m1);
//        l.add(m2);
//
//        return l;
//    }
}
