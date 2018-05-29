package de.syrocon.jee8demo.rest;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseBroadcaster;
import javax.ws.rs.sse.SseEventSink;

@Path("sse")
public class SseResource {
	@Context
	Sse sse;

	SseBroadcaster sseBroadcaster;

	@PostConstruct
	void init() {
		sseBroadcaster = sse.newBroadcaster();
	}

	@GET
	@Produces(MediaType.SERVER_SENT_EVENTS)
	public void register(@Context SseEventSink sseEventSink) {
		sseBroadcaster.register(sseEventSink);
	}

	public void greet() {
		sseBroadcaster.broadcast(sse.newEvent("Hello!"));
	}
}
