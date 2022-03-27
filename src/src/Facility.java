package src;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Facility {

    ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/app-context.xml");

    FacilityMaintenance facMaint = (FacilityMaintenance) context.getBean("facMaint");
    FacilityUse facUse = (FacilityUse) context.getBean("facUse");

    Scanner reader = new Scanner(System.in);

    String[] facilityNames = new String[10];
    String[] facilityDetail = new String[10];
    int[] employeeCount = new int[10];
    public int capacity = 10;

    // Request list of facilities
    public void listFacilities(){
        int currentActive;

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
    public void getFacilityInformation(String facilityName){

        if(capacity == 10){ // Check if the list is empty
            System.out.println("There is no facility status value in the list.");
        }
        else{
            for(int i = 0; i < facilityNames.length; i++){
                if(facilityNames[i].equalsIgnoreCase(facilityName)){ // Looks for the specified facility

                    System.out.println("Facility name: " + facilityName);

                    if(facUse.user[i] != null){
                        System.out.println(facilityName + " is in use by " + facUse.user[i] + ".");
                    }

                    System.out.println(facilityName + "'s employee count is " + employeeCount[i] + ".");
                    System.out.println(facUse.calcUsageRate(facilityName));
                    System.out.println(facUse.listInspections(facilityName));
                    System.out.println(facMaint.calcProblemRateForFacility(facilityName));
                    System.out.println(facMaint.calcDownTimeForFacility(facilityName));
                    System.out.println(facMaint.listMaintRequests(facilityName));
                    System.out.println(facMaint.listMaintenance(facilityName));
                    System.out.println(facMaint.listFacilityProblems(facilityName));
                    System.out.println(facMaint.calcMaintenanceCostForFacility(facilityName));

                    if(facilityDetail[i] != null){
                        System.out.println(facilityName + "'s details: " + facilityDetail[i] + ".");
                    }
                }
            }
        }
    }

    // Request the available capacity of facilities
    public String requestAvailableCapacity(){
        return "Facility capacity available: " + capacity; // Prints the current capacity value
    }

    // Add a new facility to the list
    public boolean addNewFacility(String newFacility){
        boolean success = false;

        if(capacity > 0){
            for(int i = 0; i < facilityNames.length; i++){
                if(facilityNames[i] == null){
                    facilityNames[i] = newFacility; // Adds the facility name to the list
                    capacity--; // Decrements capacity to account for taken up space
                    System.out.println("How many employees will be hired at this facility?");
                    employeeCount[i] = reader.nextInt();
                    success = true;
                }
            }
        }
        else{
            System.out.println("There is no capacity left for a new facility.");
        }
        return success;
    }

    // Add details to specific facilities; Needs more details as we add details
    public void addFacilityDetail(String facilityName){

        for(int i = 0; i < facilityNames.length; i++){
            if(facilityNames[i].equalsIgnoreCase(facilityName)){ // Looks for the specified facility
                System.out.println("What detail would you like to add to facility " + facilityName + "?");
                facilityDetail[i] = reader.nextLine(); // Adds status to the specified facility
            }
        }
    }

    // Remove facilities from the list
    public boolean removeFacility(String facilityName){
        boolean success = false;

        for(int i = 0; i < facilityNames.length; i++){
            if(facilityNames[i].equalsIgnoreCase(facilityName)){ // Looks for the input facility
                facilityNames[i] = null; // Sets the specified facility to null to remove from list
                facUse.user[i] = null;
                employeeCount[i] = 0;
                facUse.usageRate[i] = 0;
                facUse.usageCount[i] = 0;
                facUse.inspections[i] = 0;
                facMaint.problemRate[i] = 0;
                facMaint.requestList[i] = null;
                facMaint.requestCount[i] = 0;
                facMaint.requestDates[i] = null;
                facMaint.facilityProblem[i] = null;
                facMaint.downTime[i] = 0;
                facMaint.maintenanceStatus[i] = null;
                facMaint.maintCost[i] = 0;
                capacity++; // Adds to capacity tracker to account for the new space
                success = true;
            }
        }
        return success;
    }
}