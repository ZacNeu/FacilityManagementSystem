package src;

import java.util.Scanner;
import java.util.Random;

public class FacilityMaintenance{

    Facility F = new Facility();
    String[] requestList = new String[10];
    int[] requestCount = new int[10];
    String[] requestDates = new String[10];
    int[] problemRate = new int[10];
    int[] downTime = new int[10];
    String[] maintenanceStatus = new String[10];
    String[] maintenanceProgress = {"Request Submitted","Queued", "In progress"};

    Scanner reader = new Scanner(System.in);
    Random rand = new Random();

    public boolean MakeFacilityMaintRequest(String facilityName, String request){
        boolean success = false;

        if(F.capacity == 10){
            System.out.println("There are no facilities to request maintenance for.");
        }
        else{
            for(int i = 0; i < F.facilityNames.length; i++){
                if(F.facilityNames[i].equalsIgnoreCase(facilityName)){
                    requestList[i] = request;
                    requestCount[i] += 1;
                    success = true;

                    System.out.println("Your request was successfully processed and added to the list.");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Enter your preferred month and day for the maintenance (mm/dd): ");
                    String date = reader.nextLine();
                    scheduleMaintenance(date, i);

                    int randInt = rand.nextInt(3);
                    maintenanceStatus[i] = maintenanceProgress[randInt];
                }
                else{
                    System.out.println("There is no facility with the name " + facilityName + " in the list.");
                }
            }
        }
        return success;
    }

    public String scheduleMaintenance(String date, int index){
        String success = "There was an error setting the maintenance date.";

        for(int i = 0; i < requestDates.length; i++){
            if(requestDates[i].equals(date)){
                System.out.println("Maintenance exists for that day already, choose a different day (mm/dd): ");
                date = reader.nextLine();
                scheduleMaintenance(date, index);
            }
            else{
                requestDates[index] = date;
                success = "Your maintenance date preference was successfully set.";
            }
        }
        return success;
    }

    public boolean calcProblemRateForFacility(String facilityName){
        boolean success = false;

        for(int i = 0; i < F.facilityNames.length; i++){
            if(F.facilityNames[i].equalsIgnoreCase(facilityName)){
                problemRate[i] = ((requestCount[i] / 365) * 100); /* Calculates problem rate,
                                                                    requestCount counts the amount of days needed for requests (1 request takes
                                                                    1 day), divided by
                                                                    days in a year and turned into a percentage.
                                                                    */
                success = true;
            }
            else{
                System.out.println("There is no facility by the name " + facilityName + " in the current list.");
            }
        }
        return success;
    }

    public boolean calcDownTimeForFacility(String facilityName){
        boolean success = false;

        for(int i = 0; i < F.facilityNames.length; i++){
            if(F.facilityNames[i].equalsIgnoreCase(facilityName)){
                downTime[i] = requestCount[i] * 24; /* Since requests take one day to do, facility is down for that day, requestCount has the amount of days
                                                       per facility, so I take amount of days and multiply by 24 to get total amount of hours of downtime. */
                success = true;
                System.out.println("Facility " + facilityName + " was down for " + requestCount[i] + " days or " + downTime[i] + " hours.");
            }
        }
        return success;
    }

    public void listMaintRequests(){
        for(int i = 0; i < F.facilityNames.length; i++){
            System.out.print("Facility name: " + F.facilityNames[i] + ", ");
            System.out.println("Maintenance Request: " + requestList[i]);
        }
    }

    public void listMaintenance(String facilityName){
        for(int i = 0; i < F.facilityNames.length; i++){
            if(F.facilityNames[i].equalsIgnoreCase(facilityName)){
                if(requestList[i] != null){
                    System.out.println("The current status on your request for facility " + facilityName + " is: " + maintenanceStatus[i] + ".");
                }
                else{
                    System.out.println("There is no request for facility " + facilityName + ".");
                }
            }
            else{
                System.out.println("There is no facility by the name " + facilityName + " in the current list.");
            }
        }
    }

    public object listFacilityProblems(){

    }
}