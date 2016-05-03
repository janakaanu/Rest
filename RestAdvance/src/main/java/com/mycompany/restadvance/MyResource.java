/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restadvance;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author Janaka Anuruddha
 */
@Path("test")
@Singleton
public class MyResource {

    @Context
    SecurityContext securityContext;

    private int count;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        count++;
        return "Hello Called " + count + " time(s)";
    }

}
