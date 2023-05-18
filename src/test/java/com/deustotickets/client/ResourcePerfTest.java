//package com.deustotickets.client;
//
//import static org.junit.Assert.*;
//
//import org.databene.contiperf.PerfTest;
//import org.databene.contiperf.Required;
//import org.databene.contiperf.junit.ContiPerfRule;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//
//import com.deustotickets.domain.TipoUsuario;
//import com.deustotickets.domain.Usuario;
//
//public class ResourcePerfTest {
//	private Usuario u = new Usuario("test", "test@example.com", "password", TipoUsuario.CLIENTE); 
//
////	@Rule
////	public JUnitPerfRule rule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));
//	
//	@Rule
//	public ContiPerfRule rule = new ContiPerfRule();
//
//	@Before
//	public void setUp() throws Exception {
//		Resource.registerUser(u.getNombreApellidos(), u.getEmail(), u.getPassword(), u.getTipo());
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		Resource.deleteAccount(u.getEmail());
//	}
//
//	@Test
//	@PerfTest(invocations = 1000, threads = 20)
//    @Required(max = 1200, average = 300)
//	public void testLoginUser() {
//		assertTrue(Resource.loginUser(u.getEmail(), u.getPassword()));
//	}
//	
//	@Test
//	@PerfTest()
//    @Required()
//	public void testRegisterUser() {
//	}
//	
//	@Test
//	@PerfTest()
//    @Required()
//	public void testCloseSession() {
//	}
//	
//	@Test
//	@PerfTest()
//    @Required()
//	public void testChangeUsername() {
//	}
//	
//	@Test
//	@PerfTest()
//    @Required()
//	public void testChangePassword() {
//	}
//	
//	@Test
//	@PerfTest()
//    @Required()
//	public void testDeleteAccount() {
//	}
//	
//	@Test
//	@PerfTest()
//    @Required()
//	public void testAddConcert() {
//	}
//	
//	@Test
//	@PerfTest()
//    @Required()
//	public void testDeleteConcert() {
//	}
//	
//	@Test
//	@PerfTest()
//    @Required()
//	public void testBuyTicket() {
//	}
//	
//	@Test
//	@PerfTest()
//    @Required()
//	public void testUpdateUserTickets() {
//	}
//	
//	@Test
//	@PerfTest()
//    @Required()
//	public void testGetConcerts() {
//	}
//	
//	@Test
//	@PerfTest()
//    @Required()
//	public void testModifyConcert() {
//	}
//	
//	@Test
//	@PerfTest()
//    @Required()
//	public void testVerifyArtist() {
//	}
//	
//	@Test
//	@PerfTest()
//    @Required()
//	public void testBanUser() {
//	}
//	
//	@Test
//	@PerfTest()
//    @Required()
//	public void testGetUsers() {
//	}
//	
//	@Test
//	@PerfTest()
//    @Required()
//	public void testGetArtists() {
//	}
//	
//	@Test
//	@PerfTest()
//    @Required()
//	public void testGenerateReport() {
//	}
//
//}
