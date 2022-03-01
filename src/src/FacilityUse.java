package src;

public class FacilityUse{

    Facility F = new Facility();

    public boolean isInUseDuringInterval(int startTime, int duration, String facilityName){
        boolean success = false;
        //find facility
        for(int i = 0; i < F.facilityNames.length; i++){
            if(F.facilityNames[i].equalsIgnoreCase(facilityName)){

                //determine if facility is in use
                    //additional info for time needs to be implmented. 
                if (F.capacity == 0 ){
                    success = true;

             } 
        }
   
    }
    return success;
}

    public void assignFacilityToUse(String facilityName, int startingTime){
        //Find facility
        for(int i = 0; i< F.facilityNames.length; i++) {
            if (F.facilityNames[i].equalsIgnoreCase(facilityName)){
                
            }
        }
    

    }

    public void vacateFacility(String facilityName){
        //Find facility
        for(int i = 0; i < F.facilityNames.length; i++){
            if (F.facilityNames[i].equalsIgnoreCase(facilityName)){
                //Found facility, sets capacity to 0.
                F.capacity = 0;
            }
        }
    }

    public String listInspections(String facilityName){
        //default message
        String inspections = "Error retreiving insepctions.";
        //Find facility
        for (int i = 0; i < F.facilityNames.length; i++){
            if (F.facilityNames[i].equalsIgnoreCase(facilityName)){

            }
        }
        inspections = "Inspections for " + facilityName + ": ";
        return inspections;
    }

    public String listActualUsage(){
        //default message
        String actualUsage = "";
        //for every facility
        for (int i = 0; i < F.facilityNames.length; i++){
            //takes every facility, lists capacity (out of 10)
            actualUsage += F.facilityNames[i] + " = " + (10 - F.capacity) + "/n";
       
        }
        return actualUsage;
    }

    public int calcUsageRate(String facilityName){
        //initialize return int
        int usageRate = 0;
        //Find Facility
        for (int i = 0; i<F.facilityNames.length; i++) {
            if (F.facilityNames[i].equalsIgnoreCase(facilityName)){
               //find usage rate by dividing current occupancy by capacity (10), *100 for pecentage)
                usageRate = ((10-F.capacity) / 10) * 100 ;
            }
        }
        return usageRate;
    }
}