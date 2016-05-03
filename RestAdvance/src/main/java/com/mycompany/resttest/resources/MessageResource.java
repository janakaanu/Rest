/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resttest.resources;

import com.mycompany.resttest.model.Message;
import com.mycompany.resttest.resources.beans.MessageFilterBeans;
import com.mycompany.resttest.service.MessageService;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Janaka Anuruddha
 */
@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)//These annotation can use in class level or method level
@Produces(MediaType.APPLICATION_JSON)
//@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML}) // PROVIDE JSON OR XML ACCORDING TO THE REQUEST CONTENt TYPE
public class MessageResource {

    MessageService ms = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getJSONMessages(@QueryParam("year") int year,
            @QueryParam("start") int start) {

        if (year > 0) {
            //do somthing
        }
        if (start >= 0) {
            //do somthing
        }
        return ms.getAllMessages();
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Message> getXMLMessages(@QueryParam("year") int year,
            @QueryParam("start") int start) {

        if (year > 0) {
            //do somthing
        }
        if (start >= 0) {
            //do somthing
        }
        return ms.getAllMessages();
    }

    @GET
    @Path("beanParam")
    public List<Message> getMessages2(@BeanParam MessageFilterBeans messageFilterBeans) {

        if (messageFilterBeans.getYear() > 0) {
            return new ArrayList<>();
            //do somthing
        }
        if (messageFilterBeans.getStart() >= 0) {
            //do somthing
        }
        return ms.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long Id,
            @Context UriInfo uriInfo) {

        Message message = ms.getMessage(Id);
        message.addLinks(getUriForSelf(uriInfo, message), "self");
        message.addLinks(getUriForProfile(uriInfo, message), "profile");
        message.addLinks(getUriForComments(uriInfo, message), "comment");
        return message;
    }

    private String getUriForSelf(UriInfo uriInfo, Message message) {
        String url = uriInfo.getBaseUriBuilder()
                .path(MessageResource.class)
                .path(Long.toString(message.getId()))
                .build().toString();
        return url;
    }

    private String getUriForProfile(UriInfo uriInfo, Message message) {
        String url = uriInfo.getBaseUriBuilder()
                .path(ProfileResource.class)
                .path(message.getAuthor())
                .build().toString();
        return url;
    }

    private String getUriForComments(UriInfo uriInfo, Message message) {
        String url = uriInfo.getBaseUriBuilder()
                .path(MessageResource.class)
                .path(MessageResource.class, "getCommentResource")
                .path(CommentResource.class)
                .resolveTemplate("messageId", message.getId())
                .build().toString();
        return url;
    }

//    //SAVE THE MESSAGE RETURN IT
//    @POST
//    public Message saveMessage(Message message) {
//        return ms.addMessage(message);
//    }
//
//    //SAVE THE MESSAGE AND RETURN IT WITH STATUS CODE USING RESPONSE BUILDER
//    @POST
//    public Response saveMessage2(Message message) {
//        Message newMessage = ms.addMessage(message);
//        return Response.status(Status.CREATED)
//                .entity(newMessage)
//                .build();
//    }
    //SAVE THE MESSAGE AND RETURN IT WITH STATUS CODE USING RESPONSE BUILDER
    @POST
    public Response saveMessage3(@Context UriInfo uriInfo, Message message) {
        Message newMessage = ms.addMessage(message);
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build(); //Heder value | Location
        return Response.created(uri)
                .entity(newMessage)
                .build();
    }

    @PUT
    @Path("/{messageId}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId") long Id, Message message) {
        message.setId(Id);
        return ms.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public Message delMessages(@PathParam("messageId") long Id) {
        return ms.removeMessage(Id);
    }

    @Path("/{messageId}/comments")
    public CommentResource getCommentResource() {
        return new CommentResource();
    }

}
