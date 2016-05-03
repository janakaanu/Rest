/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resttest.resources;

import com.mycompany.resttest.model.Profile;
import com.mycompany.resttest.service.ProfileService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Janaka Anuruddha
 */
@Path("profiles")
@Consumes(MediaType.APPLICATION_JSON)//These annotation can use in class level or method level
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

    ProfileService ms = new ProfileService();

    @GET
//    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getProfiles() {
        return ms.getProfiles();
    }

    @GET
    @Path("/{profileName}")
//    @Produces(MediaType.APPLICATION_XML)
    public Profile getProfile(@PathParam("profileName") String profileName) {
        return ms.getProfile(profileName);
    }

    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
    public Profile saveProfile(Profile profile) {
        return ms.addProfile(profile);
    }

    @PUT
    @Path("/{profileName}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
    public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
        profile.setName(profileName);
        return ms.updateProfile(profile);
    }

    @DELETE
    @Path("/{profileName}")
//    @Produces(MediaType.APPLICATION_JSON)
    public Profile delProfiles(@PathParam("profileName") String profileName) {
        return ms.removeProfile(profileName);
    }

}
