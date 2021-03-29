package org.geektimes.rest.demo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * FileName: RestClientPostDemo
 *
 * @author Mozzie
 * @email: mozzie.zhou@gmail.com
 * @date 2021/3/29 11:21 上午
 * @Description
 */
public class RestClientPostDemo {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        Response response = client
                .target("http://127.0.0.1:8080/hello/world")      // WebTarget
                .request() // Invocation.Builder
                .post(Entity.entity("{\"value\":111}", MediaType.APPLICATION_JSON));                //  Response

        String content = response.readEntity(String.class);

        System.out.println(content);
    }
}
