import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * 
 */

/**
 * @author joelyn chua
 *
 */
class ListingCollectionTest {
	private ListingCollection LC;
	private Listing L1;
	private Listing L2;
	private Listing L3;
	private final int LISTING_COLLECTION_SIZE = 2;
	//private int LISTING_COLLECTION_SIZE;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		LC = new ListingCollection();
		
		L1 = new Listing ("1","AmiAmi","6", "Japan", "Only ships to SG", "Image", "6");
		L2 = new Listing ("2","Bilibi","8", "China", "Only ships to SG", "Image", "6");
		L3 = new Listing ("3","Taobao","8", "China", "Only ships to SG", "Image", "6");
		
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
	 * Test method for {@link ListingCollection#getAllListings()}.
	 */
	@Test
	void testGetAllListings() {
		//fail("Not yet implemented");
		List<Listing> testLC = LC.getAllListings();
		//Assert that Song Collection is equals to song collection size 4
		assertEquals(testLC.size(), LISTING_COLLECTION_SIZE);
		System.out.println("Size after getAll: " + LISTING_COLLECTION_SIZE);
		System.out.println(L1.listingId);
		System.out.println(L2.listingId);
		//Act
//		LC.add(L3);
//		assertEquals(LC.getAllListings().size(), LISTING_COLLECTION_SIZE+1 );
	}

	/**
	 * Test method for {@link ListingCollection#findListingById(java.lang.String)}.
	 */
	@Test
	void testFindListingById() {
		//fail("Not yet implemented");
		//List<Listing> testLC = LC.findListingById(L1.listingId);
		Listing searchedResult = LC.findListingById(L2.listingId);
		System.out.println("searchedResult: "+ searchedResult);
		
		System.out.println("check: " + searchedResult.listingId);
		//System.out.println("check: " + searchedResult.listingName);
		//System.out.println("check: " + searchedResult.listingPrice);
		System.out.println("L2" + L2);
		//System.out.println(result.listingPrice);
		
		//Assert that the values is equals to their corresponding fields
		assertEquals(searchedResult.listingName, "Bilibi");
//		assertEquals(result.listingPrice, "8");
//		assertEquals(result.listingCountry, "China");
//		assertEquals(result.listingRemarks, "Only ships to SG");
//		assertEquals(result.listingImage, "Image");
//		assertEquals(result.userId, "6");
		

	}

	/**
	 * Test method for {@link ListingCollection#add(Listing)}.
	 */
	@Test
	void testAdd() {
		//fail("Not yet implemented");
		LC.add(L3);
		//Note: LISTING_COLLECTION_SIZE = 3 here
		//assertEquals(LC.findListingById(L3.listingId).listingId, "3");
		assertEquals(LC.getAllListings().size(), 3);
		System.out.println("Size after add: " + LISTING_COLLECTION_SIZE);
	}
	


	@Test
	void testUpdate() {
		//fail("Not yet implemented");
		Listing updateResult = LC.update(L1.listingId, "updatedName", "updatedPrice", "updatedCountry", "updatedRemarks", "updatedImage");
		System.out.println(updateResult.listingName);
		System.out.println(updateResult.listingPrice);
		//Assert that Song Collection is equals to song collection size 4
		assertEquals(updateResult.listingName, "updatedName");

	}
	
	@Test
	void testDelete() {
		//fail("Not yet implemented");
		Listing deleteId = LC.delete(L3.listingId);
		//Note: LISTING_COLLECTION_SIZE = 3(after add) - 1
		assertEquals(LC.getAllListings().size(), 2);
		System.out.println("Size after delete: " + LISTING_COLLECTION_SIZE);
		//assertEquals(LC.getAllListings().size(), 2);

	}
	

	

}
