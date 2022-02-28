import java.io.*;
import java.util.*;

/* Was thinking if we wanna keep things super simple,
we could use a bunch of array for different information and
 just have to keep track of indexes so we don't need to
 implement more complicated data structures*/

public class Facility {

    String[] facilityNames = {"Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty"};
    String[] facilityStatus = {"Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty"};

    // Request list of facilities
    public object listFacilities(){
       for(int i = 0; i < facilityNames.length; i++){
           System.out.println(facilityNames[i]) // Prints all entries in the names list
       }
    }

    // Request existing facility information
    public object getFacilityInformation(String facilityName){
        for(int i = 0; i < facilityNames.length; i++){
            if(facilityNames[i].equals(facilityName)){
                System.out.println(facilityStatus[i]) // Print out information of the given facility
                /* Add more information to print, not sure
                what other information to list for the facilities */
            }
        }
    }

    // Request the available capacity of facilities
    public object requestAvailableCapacity(){
        int capacity = 0;

        for(int i = 0; i < facilityNames.length; i++){
            if(facilityNames[i].equals("Empty")){
                capacity++;
            }
        }

        System.out.print("Facility capacity: " + capacity);
    }

    // Add a new facility to the list
    public object addNewFacility(String newFacility){

    }

    // Add details to specific facilities
    public void addFacilityDetail(){

    }

    // Remove facilities from the list
    public object removeFacility(){

    }
}