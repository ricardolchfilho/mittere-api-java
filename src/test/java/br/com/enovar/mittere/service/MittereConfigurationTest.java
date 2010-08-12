package br.com.enovar.mittere.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MittereConfigurationTest {
	
	MittereConfiguration configuration;
	
	@Before
	public void setUp() throws Exception {
		configuration = new MittereConfiguration();
	}
	
	@Test
	public void shouldConfigureWithUsernameCorrectly() {
		String username = "benevas";
		String password = "1234";
		
		MittereConfiguration.configureWithUsernameAndPassword(username, password);
		
		assertEquals(username, configuration.getUsername());
	}
	
	@Test
	public void shouldConfigureWithPasswordCorrectly() {
		String username = "benevas";
		String password = "1234";
		
		MittereConfiguration.configureWithUsernameAndPassword(username, password);
		
		assertEquals(password, configuration.getPassword());
	}
	
}
