package de.syrocon.jee8demo.cdi;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class SEDemo {

	public static void main(String[] args) {
		SeContainer seContainer = SeContainerInitializer.newInstance().initialize();
		Greeter greeting = seContainer.select(Greeter.class).get();
		greeting.greet();
		seContainer.close();
	}

}
