public class Facility {

    public String[] facilityNames = new String[10];
    public String[] facilityStatus = new String[10];
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
                    System.out.println(facilityStatus[i]); // Print out information of the given facility
                }
                else {
                    System.out.println("There is no facility with the name " + facilityName);
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
    public void addFacilityDetail(String facilityName, String statusValue){

        for(int i = 0; i < facilityNames.length; i++){
            if(facilityNames[i].equalsIgnoreCase(facilityName)){ // Looks for the specified facility
                facilityStatus[i] = statusValue; // Adds status to the specified facility
            }
            else{
                System.out.println("There is no facility with the name " + facilityName + " to add details to.");
            }
        }
    }

    // Remove facilities from the list
    public boolean removeFacility(String facilityName){
        boolean success = false;

        for(int i = 0; i < facilityNames.length; i++){
            if(facilityNames[i].equalsIgnoreCase(facilityName)){ // Looks for the input facility
                facilityNames[i] = null; // Sets the specified facility to null to remove from list
                capacity++; // Adds to capacity tracker to account for the new space
                success = true;
            }
            else{
                System.out.println("There is no facility with the name " + facilityName + " to remove from the list.");
            }
        }
        return success;
    }

    public static void main(String[] args){
        Facility F = new Facility();

        F.listFacilities();
    }
}