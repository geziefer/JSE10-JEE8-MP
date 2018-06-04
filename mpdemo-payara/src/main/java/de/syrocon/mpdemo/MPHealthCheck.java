package de.syrocon.mpdemo;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

@Health
@ApplicationScoped
public class MPHealthCheck implements HealthCheck {
	public HealthCheckResponse call() {
		return HealthCheckResponse.named("ping").up().withData("Hello", "world").build();
	}

}
