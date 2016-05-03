/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resttest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Janaka Anuruddha
 */
@Path("/")
public class CommentResource {

    @GET
    public String test() {
        return "new sub resource";
    }

    @GET
    @Path("/{commentId}")
    public String test2(@PathParam("messageId") int messageId, @PathParam("commentId") int commentID) {
        return "Message ID " + messageId + " Comment " + commentID;
    }

}
