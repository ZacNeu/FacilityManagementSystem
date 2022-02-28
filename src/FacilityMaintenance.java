import java.util.Scanner;

public class FacilityMaintenance{

    Facility F = new Facility();
    String[] requestList = new String[10];
    int[] requestCount = new int[10];
    String[] requestDates = new String[10];
    int[] problemRate = new int[10];
    int[] downTime = new int[10];

    Scanner reader = new Scanner(System.in);

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

                    System.out.println("Your request was successfully processed and added to the list");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Enter your preferred month and day for the maintenance (mm/dd): ");
                    String date = reader.nextLine();
                    scheduleMaintenance(date, i);
                }
                else{
                    System.out.println("There is no facility with the name " + facilityName + " in the list.");
                }
            }
        }
        return success;
    }

    public String scheduleMaintenance(String date, int index){
        String success = "There was an error setting the maintenance date";

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
                                                                    requestCount count the amount of days needed for requests, divided by
                                                                    days in a year and turned into a percentage.
                                                                    */
                success = true;
            }
            else{
                System.out.println("There is no facility by the name " + facilityName + " in the current list");
            }
        }
        return success;
    }

    public boolean calcDownTimeForFacility(String facilityName){
        boolean success = false;
    }

    public void listMaintRequests(){
        for(int i = 0; i < F.facilityNames.length; i++){
            System.out.print("Facility name: " + F.facilityNames[i] + ", ");
            System.out.println("Maintenance Request: " + requestList[i]);
        }
    }

    public object listMaintenance(){

    }

    public object listFacilityProblems(){

    }
}