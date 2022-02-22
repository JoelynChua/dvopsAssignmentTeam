import java.util.*;


public class ListingCollection {
	private ListingServlet LS;

    private ArrayList<Listing> listings = new ArrayList<>();
    private int capacity;

    public ListingCollection() {
    	/*listings.add(new Listing ("1","AmiAmi","6", "Japan", "Only ships to SG", "Image", "6"))
    	 * songs.add(new Song("0001","good 4 u","Olivia Rodrigo",3.59));
    	songs.add(new Song("0002","Peaches","Justin Bieber",3.18));
    	songs.add(new Song("0003","MONTERO","Lil Nas X",2.3));
    	songs.add(new Song("0004","bad guy","Billie Eilish",3.14));*/

        this.capacity = 20;
    }

    public ListingCollection(int capacity) {
    	 this.capacity = capacity;
    }

    public List<Listing> getAllListings() {
        return listings;
    }
    
//    public Listing findListingById(String listingId) {
//    	for (Listing l : listings) { 		      
//            if(l.getListingId().equals(listingId)) {
//            	l.getListingName();
//            	//System.out.println("testonCollection" + l.getListingName());
//            	l.getListingPrice();
//            	l.getListingCountry();
//            	l.getListingRemarks();
//            	l.getListingImage();
//            	l.getUserId();
//            }
//            	return l;
//       }
//    	return null;
//    }
    
    public Listing findListingById(String listingId) {
    	for (Listing l : listings) { 		      
            if(l.getListingId().equals(listingId)) {
            	l.getListingName();
            	System.out.println("testonCollection" + l.getListingName());
            	l.getListingPrice();
            	l.getListingCountry();
            	l.getListingRemarks();
            	l.getListingImage();
            	l.getUserId();
            	return l;
            }
       }
    	return null;
    }
    
    
    public void add(Listing listing) {
    	if(listings.size() != capacity) {
    		listings.add(listing);
    	}
    }
    
    public Listing delete(String listingId) {
    	for (Listing deletedListing : listings) { 		      
            if(deletedListing.getListingId().equals(listingId))
            	listings.remove(deletedListing);
       }
    	return null;
    }
    
    
    //update 
	public Listing update(String listingId, String listingName, String listingPrice, String listingCountry, String listingRemarks, String listingImage) {
		for (Listing l : listings) {
			if (l.getListingId().equals(listingId)) {
				l.setListingName(listingName);
				l.setListingPrice(listingPrice);
				l.setListingCountry(listingCountry);
				l.setListingRemarks(listingRemarks);
				l.setListingImage(listingImage);
				return l;
			}
		}
		return null;
	}
    
    
    

    


}