import java.io.*;
import java.util.*;

/* Was thinking if we wanna keep things super simple,
we could use a bunch of array for different information and
 just have to keep track of indexes so we don't need to
 implement more complicated data structures*/

public class Facility {

    public String[] facilityNames = new String[10];
    public String[] facilityStatus = new String[10];
    public int capacity = 10;

    // Request list of facilities
    public object listFacilities(){
        int currentActive = 0;

        if(capacity == 10){
            System.out.println("There are no facilities currently in the list.");
        }
        else{
            for(int i = 0; i < facilityNames.length; i++){
                if(facilityNames[i] != null){
                    System.out.println(facilityNames[i]); // Prints all entries in the names list
                }
            }
        }
        currentActive = 10 - capacity; // Checks for currently active facilities
        System.out.println("There are currently " + currentActive + " active facilities currently");

    }

    // Request existing facility information
    public object getFacilityInformation(String facilityName){

        if(capacity == 10){ // Check if the list is empty
            System.out.println("There is no facility status value in the list.");
        }
        else{
            for(int i = 0; i < facilityNames.length; i++){
                if(facilityNames[i].toLowerCase().equals(facilityName.toLowerCase())){ // Looks for the specified facility
                    System.out.println(facilityStatus[i]); // Print out information of the given facility
                /* Add more information to print, not sure
                what other information to list for the facilities */
                }
                else {
                    System.out.println("There is no facility with the name " + facilityName);
                }
            }
        }

    }

    // Request the available capacity of facilities
    public object requestAvailableCapacity(){
        System.out.println("Facility capacity available: " + capacity); // Prints the current capacity value

        if(capacity == 0){
            System.out.println("There is no space for a new facility.");
        }
    }

    // Add a new facility to the list
    public object addNewFacility(String newFacility){

        if(capacity > 0){
            for(int i = 0; i < facilityNames.length; i++){
                if(facilityNames[i] == null){
                    facilityNames[i] = newFacility; // Adds the facility name to the list
                    capacity--; // Decrements capacity to account for taken up space
                }
            }
        }
        else{
            System.out.println("There is no capacity left for a new facility.");
        }

    }

    // Add details to specific facilities; Needs more details as we add details
    public void addFacilityDetail(String facilityName, String statusValue){

        for(int i = 0; i < facilityNames.length; i++){
            if(facilityNames[i].toLowerCase().equals(facilityName.toLowerCase())){ // Looks for the specified facility
                facilityStatus[i] = statusValue; // Adds status to the specified facility
            }
            else{
                System.out.println("There is no facility with the name " + facilityName + " to add details to.");
            }
        }

    }

    // Remove facilities from the list
    public object removeFacility(String facilityName){

        for(int i = 0; i < facilityNames[i]; i++){
            if(facilityNames[i].toLowerCase().equals(facilityName.toLowerCase())){ // Looks for the input facility
                facilityNames[i] = null; // Sets the specified facility to null to remove from list
                capacity++; // Adds to capacity tracker to account for the new space
            }
            else{
                System.out.println("There is no facility with the name " + facilityName + " to remove from the list.");
            }
        }

    }
}