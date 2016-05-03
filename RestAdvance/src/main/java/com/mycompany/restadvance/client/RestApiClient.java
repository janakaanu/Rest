/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restadvance.client;

import com.mycompany.resttest.model.Message;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Janaka Anuruddha
 */
public class RestApiClient {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();

 //       Response response = client.target("http://localhost:8084/RestAdvance/webapi/messages/1").request(MediaType.APPLICATION_JSON).get();
//        Message msg = response.readEntity(Message.class);
//        System.out.println("Message 1 " + msg.getMessage());
        WebTarget baseTarget = client.target("http://localhost:8084/RestAdvance/webapi/");
        WebTarget messageTarget = baseTarget.path("messages");
        WebTarget singleMessageTarget = messageTarget.path("{messageId}");

        Message newMessage = new Message(1L, "My new message from client", "Janaka");
        Response postResponse = messageTarget
                .request()
                .post(Entity.json(newMessage));

        if (postResponse.getStatus() != 201) {
            System.out.println("Error");
        } else {
            System.out.println(postResponse.readEntity(Message.class).getMessage());
        }

        System.out.println(postResponse);

        Message message1 = singleMessageTarget
                .resolveTemplate("messageId", "1")
                .request(MediaType.APPLICATION_JSON)
                .get(Message.class);
        System.out.println(message1.getMessage());

        Message message2 = singleMessageTarget
                .resolveTemplate("messageId", "2")
                .request(MediaType.APPLICATION_JSON)
                .get(Message.class);
        System.out.println(message2.getMessage());

//        String message3 = client
//                .target("http://localhost:8084/RestAdvance/webapi/messages/1")
//                .request(MediaType.APPLICATION_JSON)
//                .get(String.class);
//        System.out.println(message3);
    }

}
