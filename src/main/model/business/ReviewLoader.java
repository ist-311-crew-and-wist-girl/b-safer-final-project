package main.model.business;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import main.model.users.ActorUser;

public class ReviewLoader {
    ArrayList<BusinessReview> reviews;


    //file will be the id number of the business whose reviews are getting loaded
    public ReviewLoader(int file) {
        reviews = new ArrayList<>();
        ReadReviewsFromXML(file);
    }

    //Method to read in XML file of Businesses
    public void ReadReviewsFromXML(int file) {
        try {
            BusinessReview rev;
            XMLDecoder decoder;
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file+".xml")));
            rev = new BusinessReview();
            while (rev != null) {
                try {
                    rev = (BusinessReview) decoder.readObject();
                    reviews.add(rev);

                } catch (ArrayIndexOutOfBoundsException finished) {
                    //System.out.println("end of file");
                    break;
                }
            }
            decoder.close();
        } catch (Exception xx) {
            xx.printStackTrace();
        }
    }

    public ArrayList<BusinessReview> getReviews() {
        return reviews;
    }
}
