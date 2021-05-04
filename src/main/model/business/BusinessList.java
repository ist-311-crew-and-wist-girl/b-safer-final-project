package main.model.business;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

public class BusinessList {
    private ArrayList<Business> businesses;

    public BusinessList() {
        businesses = new ArrayList<>();
        ReadBusinessesFromXML();
    }

    //Method to read in XML file of Businesses
    public void ReadBusinessesFromXML() {
        try {
            Business bus;
            XMLDecoder decoder;
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("src\\main\\model\\business\\data\\business-data.xml")));
            bus = new Business();
            while (bus != null) {
                try {
                    bus = (Business) decoder.readObject();
                    businesses.add(bus);

                } catch (ArrayIndexOutOfBoundsException finished) {
                    break;
                }
            }
            decoder.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Business> getBusinesses() {
        return businesses;
    }
}
