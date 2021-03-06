package src;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

public class FacilityMaintenance{

    ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/app-context.xml");

    Facility fac = (Facility) context.getBean("fac");
    FacilityUse facUse = (FacilityUse) context.getBean("facUse");

    Random rand = new Random();

    String[] requestList = new String[10];
    int[] requestCount = new int[10];
    String[] requestDates = new String[10];
    String[] facilityProblem = new String[10];
    int[] problemRate = new int[10];
    int[] downTime = new int[10];
    String[] maintenanceStatus = new String[10];
    String[] maintenanceProgress = {"Request Submitted","Queued", "In progress"};
    int[] maintCost = new int[10];

    public boolean MakeFacilityMaintRequest(String facilityName){
        boolean success = false;

        if(fac.capacity == 10){
            System.out.println("There are no facilities to request maintenance for.");
        }
        else{
            for(int i = 0; i < fac.facilityNames.length; i++){
                if(fac.facilityNames[i].equalsIgnoreCase(facilityName)){
                    System.out.println("What is the specific problem?");
                    facilityProblem[i] = fac.reader.nextLine();
                    System.out.println("What would you like from maintenance?");
                    requestList[i] = fac.reader.nextLine();
                    requestCount[i] += 1;
                    facUse.inspections[i] += 1;


                    System.out.println("Your request was successfully processed and added to the list.");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Enter your preferred month and day for the maintenance (mm/dd): ");
                    String date = fac.reader.nextLine();
                    scheduleMaintenance(date, i);

                    int randInt = rand.nextInt(3);
                    maintenanceStatus[i] = maintenanceProgress[randInt];

                    success = true;
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
                date = fac.reader.nextLine();
                scheduleMaintenance(date, index);
            }
            else{
                requestDates[index] = date;
                success = "Your maintenance date preference was successfully set.";
            }
        }
        return success;
    }

    public String calcMaintenanceCostForFacility(String facilityName){
        int[] maintPrice = {200, 400, 700, 1000};

        String success = "Failed to calculate maintenance cost for this facility, try again";

        for(int i = 0; i < fac.facilityNames.length; i++){
            if(fac.facilityNames[i].equalsIgnoreCase(facilityName)){
                int random = rand.nextInt(4);
                maintCost[i] = requestCount[i] * maintPrice[random];

                success = "Facility " + facilityName + "'s maintenance cost is $" + maintCost[i] + ".";
            }
        }
        return success;
    }

    public String calcProblemRateForFacility(String facilityName){
        String success = "Failed to calculate problem rate, try again";

        for(int i = 0; i < fac.facilityNames.length; i++){
            if(fac.facilityNames[i].equalsIgnoreCase(facilityName)){
                problemRate[i] = ((requestCount[i] / 365) * 100); /* Calculates problem rate,
                                                                    requestCount counts the amount of days needed for requests (1 request takes
                                                                    1 day), divided by
                                                                    days in a year and turned into a percentage.
                                                                    */
                success = facilityName + "'s problem rate is " + problemRate[i] + "%";
            }
        }
        return success;
    }

    public String calcDownTimeForFacility(String facilityName){
        String success = "Failed to calculate down time, try again";

        for(int i = 0; i < fac.facilityNames.length; i++){
            if(fac.facilityNames[i].equalsIgnoreCase(facilityName)){
                downTime[i] = requestCount[i] * 24; /* Since requests take one day to do, facility is down for that day, requestCount has the amount of days
                                                       per facility, so I take amount of days and multiply by 24 to get total amount of hours of downtime. */
                success = "Facility " + facilityName + " was down for " + requestCount[i] + " days or " + downTime[i] + " hours.";
            }
        }
        return success;
    }

    public String listMaintRequests(String facilityName){
        String success = "Failed to find facility, try again";
        for(int i = 0; i < fac.facilityNames.length; i++){
            if(fac.facilityNames[i].equalsIgnoreCase(facilityName)){
                if(requestList[i] != null){
                    success = "The current request at facility " + facilityName + " is: " + maintenanceStatus[i] + " and is set for" + requestDates[i] + ".";
                }
                else{
                    success = "There is no request for facility " + facilityName + ".";
                }
            }
        }
        return success;
    }

    public String listMaintenance(String facilityName){
        String success = "Failed to find facility, try again";
        for(int i = 0; i < fac.facilityNames.length; i++){
            if(fac.facilityNames[i].equalsIgnoreCase(facilityName)){
                if(requestList[i] != null){
                    success = "The current status on your request for facility " + facilityName + " is: " + maintenanceStatus[i] + ".";
                }
                else{
                    success = "There is no request for facility " + facilityName + ".";
                }
            }
        }
        return success;
    }

    public String listFacilityProblems(String facilityName){
        String success = "Failed to find facility, try again";
        for(int i = 0; i < fac.facilityNames.length; i++){
            if(fac.facilityNames[i].equalsIgnoreCase(facilityName)){
                if(facilityProblem[i] != null){
                    success = "The current problem with facility " + facilityName + " is " + facilityProblem[i] + ".";
                }
                else{
                    success = "There are no current problems with facility " + facilityName + ".";
                }
            }
        }
        return success;
    }
}