package de.syrocon.jee8demo.cdi;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import org.junit.Test;

public class SETest {

	@Test
	public void test() {
		SeContainer seContainer = SeContainerInitializer.newInstance().initialize();
		Greeter greeting = seContainer.select(Greeter.class).get();
		greeting.greet();
		seContainer.close();
	}

}
