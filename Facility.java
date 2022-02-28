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

        if(facilityNames[0] == null){
            System.out.println("There are no facilities currently in the list.");
        }
        else{
            for(int i = 0; i < facilityNames.length; i++){
                if(facilityNames[i] != null){
                    System.out.println(facilityNames[i]); // Prints all entries in the names list
                }
            }
        }

    }

    // Request existing facility information
    public object getFacilityInformation(String facilityName){

        if(facilityStatus[0] == null){
            System.out.println("There is no facility status value in the list.");
        }
        else{
            for(int i = 0; i < facilityNames.length; i++){
                if(facilityNames[i].toLowerCase().equals(facilityName.toLowerCase())){
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
        System.out.print("Facility capacity available: " + capacity);
    }

    // Add a new facility to the list
    public object addNewFacility(String newFacility){

        if(capacity > 0){
            for(int i = 0; i < facilityNames.length; i++){
                if(facilityNames[i] == null){
                    facilityNames[i] = newFacility;
                    capacity--;
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
            if(facilityNames[i].toLowerCase().equals(facilityName.toLowerCase())){
                facilityStatus[i] = statusValue; // Adds status to a specific facility
            }
            else{
                System.out.println("There is no facility with the name " + facilityName + " to add details to.");
            }
        }

    }

    // Remove facilities from the list
    public object removeFacility(String facilityName){

        for(int i = 0; i < facilityNames[i]; i++){
            if(facilityNames[i].toLowerCase().equals(facilityName.toLowerCase())){
                facilityNames[i] = null;
                capacity++;
            }
            else{
                System.out.println("There is no facility with the name " + facilityName + " to remove from the list.");
            }
        }

    }
}