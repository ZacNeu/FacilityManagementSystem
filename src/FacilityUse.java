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

    public object assignFacilityToUse(){

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

    public object listInspections(){

    }

    public object listActualUsage(){

    }

    public object calcUsageRate(){

    }

}