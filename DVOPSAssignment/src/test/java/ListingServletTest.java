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
		
		
		// set EmployeeDAO mock object
		//mockListingServlet = mock(ListingServlet.class);
		// stubbing is done for test cases
	    //when(mockListingServlet.viewAllListing(request, response)).thenReturn(ArrayList(L1, L2));
        
			
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ListingServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	void testDoGetHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
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
	    
	    
	    //System.out.println(req);
	    //System.out.println(resp);
	 
	    
		//List<Listing> testRetriveAll = LC.getAllListings();
		//System.out.print(testRetriveAll); //prints the object inside the Listing array
		//System.out.print(LC.getAllListings().size()); //size of array
		
		
	      //HttpServletRequest req = mock(HttpServletRequest.class);
	      //when(request.getRequest("req")).thenReturn(listings);
		//List allListing = mockListingServlet.viewAllListing(request, response)
		
		//ListingServlet listingServlet = new ListingServlet();
		
		//Arrange - setup desired state: return my listing
		//List<Listing> testRetriveAll = LC.getAllListings();
		//System.out.print(testRetriveAll); //prints the object inside the Listing array
		//System.out.print(LC.getAllListings().size()); //size of array
		
		//Act - invoke the mtd being tested ViewAllListing()
		//LC.getAllListings();
		//listingServlet.viewAllListing(request, response);
		
		//listingServlet.viewAllListing(request, response);
		//HttpServletRequest request = httpRequestService.makeGetRequest("http://localhost:8090/DVOPSAssignment/ListingServlet/viewListings");
		//String request = "http://localhost:8090/DVOPSAssignment/ListingServlet/viewListings";
		// mock the returned value of request.getHeaderNames()
		//when(request.getAttribute("getAllListings")).thenReturn(listings);
		//listings.getRequest().getAttribute("viewAllListing");

		//assertEquals(LC.getAllListings().size(), request.getAttribute("viewAllListing").size());
		
		//System.out.println(request);
		//listingServlet.viewAllListing(request, response);
		//String request = "http://localhost:8090/DVOPSAssignment/ListingServlet/viewListings";
		//System.out.println(request.getAttribute("viewAllListing"));
		
		//assertEquals(1, request.getAttribute("viewAllListing").size());
		 
		//String actual = request.setAttribute("viewAllListing", listings) - void
		
		//List<Listing> testRetriveAll = LS.viewAllListing(request, response);
		//Assert that testRetriveAll is equals to LISTING_SIZE size 1
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

//        StringWriter stringWriter = new StringWriter();
//        PrintWriter writer = new PrintWriter(stringWriter);
//        when(resp.getWriter()).thenReturn(writer);
//        System.out.println(stringWriter);
		
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
        //assertTrue(result.contains("1"));
		//req.expects(atLeastOnce()).method("getParameter").with(eq("name")).will(returnValue("1"));
		
	    //System.out.println(LC.getAllListings().size());
	    
		//String result = sw.toString();
		//System.out.println(result);
		
				//sw.getBuffer().toString().trim();
						
		//when(req.getAttribute("viewAllListing")).thenReturn(LC.getAllListings());
		//System.out.println(LC.getAllListings().size());
		
		//ListingServlet listingServlet = new ListingServlet();
		//listingServlet.showListingDetails(request, response);		
		
		
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
		//System.out.println("Edit form listingName: " + LC.findListingById(result).getListingName());
		assertTrue(editresult.contains("1"));
		//assertEquals(LC.findListingById(result).getListingId(),"1");
		
		
		
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
		
		//Act - invoke the mtd being tested ViewAllListing()
		ListingServlet listingServlet = new ListingServlet();
		listingServlet.updateListing(req, resp);
		
		//LC.update(L2.getListingId(), L2.getListingName());
		 
        //assertNotNull(employeeName);
        //assertEquals("Dhwani Kashyap", employeeName);
	}

	/**
	 * Test method for {@link ListingServlet#deleteListing(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	void testDeleteListing() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ListingServlet#listingPriceSorted(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	void testListingPriceSorted() {
		fail("Not yet implemented");
	}

}
