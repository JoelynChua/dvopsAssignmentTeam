import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author joelyn chua
 *
 */
class ListingServletTest extends Mockito {
	
  @Mock
  HttpServletRequest request;

  @Mock
  HttpServletResponse response;
  
	private ListingServlet LS;
	private Listing L1;
	private Listing L2;
	private ListingCollection LC;
	//private static ListingServlet mockListingServlet;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		//Arrange - set up the prerequisite and objects to be tested
		LC = new ListingCollection();
		
		//create new listing object
		L1 = new Listing("1","AmiAmi","6", "Japan", "Only ships to SG", "Image", "6");
		L2 = new Listing("2","Shopee","2", "China", "Only ships to SG", "Image", "6");
		//add L1 object into array
		LC.add(L1);
		LC.add(L2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ListingServlet#viewAllListing(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	void testViewAllListing() throws SQLException, IOException, ServletException {
		//fail("Not yet implemented");
		
		// Step 1 - create the mock object
		HttpServletRequest req = mock(HttpServletRequest.class);
	    HttpServletResponse resp = mock(HttpServletResponse.class);
	    
	    //declare my requestDispatcher otherwise it will be null
		RequestDispatcher rd = mock(RequestDispatcher.class);
		when(req.getRequestDispatcher(eq("/viewListings.jsp"))).thenReturn(rd); 
		//System.out.println(rd); //returns hashcode
		
		//Act - invoke the mtd being tested ViewAllListing()
	    ListingServlet listingServlet = new ListingServlet();
	    listingServlet.viewAllListing(req, resp);
	    //System.out.println(req);
	    when(req.getAttribute("viewAllListing")).thenReturn(LC.getAllListings());
	    System.out.println("Number of listing: "+ LC.getAllListings().size());
	    
	    //Assert that the size of the array = 2
	    assertEquals(2, LC.getAllListings().size());
	}

	/**
	 * Test method for {@link ListingServlet#showListingDetails(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	void testShowListingDetails() throws SQLException, IOException, ServletException {
		//fail("Not yet implemented");
		// Step 1 - create the mock object
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
			    
		//declare my requestDispatcher otherwise it will be null
		RequestDispatcher rd = mock(RequestDispatcher.class);
		when(req.getRequestDispatcher(eq("/listingDetails.jsp"))).thenReturn(rd); 
		
		when(req.getParameter("listingId")).thenReturn("1");
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		//System.out.println(sw);
		//System.out.println(pw);
		
		//System.out.println(resp); //hashcode
		
		when(resp.getWriter()).thenReturn(pw);
		
		//Act - invoke the mtd being tested ViewAllListing()
		ListingServlet listingServlet = new ListingServlet();
		listingServlet.showListingDetails(req, resp);
		//System.out.println(req);
		
		//verify if listingId was called
		//verify(req, atLeast(1)).getParameter("listingId");
		
		//System.out.println(verify(req, atLeast(1)).getParameter("listingId"));
		//writer.flush(); // it may not have been flushed yet...
		 String result = sw.getBuffer().toString().trim();
		 System.out.println(result);
		 //when(req.getAttribute("listingId")).thenReturn(LC.findListingById(result).getListingId());
		 when(req.getAttribute("listing")).thenReturn(LC.findListingById(result).getListingId());
		 System.out.println("From ListingCollection: " + LC.findListingById(result).getListingId());
	     assertEquals(LC.findListingById(result).getListingId(),"1");					
	}

	/**
	 * Test method for {@link ListingServlet#showEditForm(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	void testShowEditForm() throws SQLException, IOException, ServletException{
		//fail("Not yet implemented");
		
		// Step 1 - create the mock object
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
					    
		//declare my requestDispatcher otherwise it will be null
		RequestDispatcher rd = mock(RequestDispatcher.class);
		when(req.getRequestDispatcher(eq("/editListing.jsp"))).thenReturn(rd); 
				
		when(req.getParameter("listingId")).thenReturn("1");
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		when(resp.getWriter()).thenReturn(pw);
		
		//Act - invoke the mtd being tested ViewAllListing()
		ListingServlet listingServlet = new ListingServlet();
		listingServlet.showEditForm(req, resp);
		
		String editresult = sw.getBuffer().toString().trim();
		System.out.println("check editresult: " + editresult);
		when(req.getAttribute("listing")).thenReturn(LC.findListingById(editresult).getListingId());
		
		System.out.println("editResults: " + LC.findListingById(editresult));
		System.out.println("Edit form listingId: " + LC.findListingById(editresult).getListingId());
		assertTrue(editresult.contains("1"));
				
	}

	/**
	 * Test method for {@link ListingServlet#updateListing(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	void testUpdateListing() throws SQLException, IOException, ServletException {
		//fail("Not yet implemented");
		
		// Step 1 - create the mock object
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		when(resp.getWriter()).thenReturn(pw);
		
		//Act - invoke the mtd being tested ViewAllListing()
		ListingServlet listingServlet = new ListingServlet();
		listingServlet.updateListing(req, resp);
		
		
		String updateSuccessMsg = sw.getBuffer().toString().trim();
		assertEquals(updateSuccessMsg, "Update success!");
	}
	/**
	 * Test method for {@link ListingServlet#deleteListing(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	void testDeleteListing() throws SQLException, IOException, ServletException{
		//fail("Not yet implemented");
		
		// Step 1 - create the mock object
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse resp = mock(HttpServletResponse.class);
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		when(resp.getWriter()).thenReturn(pw);
		
		//Act - invoke the mtd being tested ViewAllListing()
		ListingServlet listingServlet = new ListingServlet();
		listingServlet.deleteListing(req, resp);
				
		String deleteSuccessMsg = sw.getBuffer().toString().trim();
		assertEquals(deleteSuccessMsg, "Delete success!");
	}


}
