package de.syrocon.jee8demo.rest;

import java.net.URI;
import java.util.concurrent.CompletionStage;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.sse.SseEventSource;

public class SseClient {
	public static void main(String[] args) throws InterruptedException {
		WebTarget target = ClientBuilder.newClient().target("http://localhost:8080/jee8demo/rest/sse");
		try (SseEventSource sseEventSource = SseEventSource.target(target).build()) {

			sseEventSource.register(System.out::println);
			sseEventSource.open();

			Thread.sleep(5000);
		}

		Client client = ClientBuilder.newClient();
		URI service = URI.create("http://localhost/service/resource");

		CompletionStage<Response> cs1 = client.target(service).request().rx().post(Entity.text("1"));
		CompletionStage<Response> cs2 = client.target(service).request().rx().post(Entity.text("2"));

		cs1.thenCombine(cs2, (r1, r2) -> {
			String s1 = r1.readEntity(String.class);
			String s2 = r2.readEntity(String.class);

			return client.target(service).request().rx().post(Entity.text(s1 + s2));
		}).thenAccept(responseCompletionStage -> responseCompletionStage.thenAccept(r3 -> {
			String s3 = r3.readEntity(String.class);

			System.out.println(s3);
		}));
	}
}
