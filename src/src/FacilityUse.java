package src;

public class FacilityUse {

    Facility F = new Facility();
    String[] user = new String[10];
    int[] inspections = new int[10];
    int[] usageCount = new int[10];
    int[] usageRate = new int[10];


    public boolean isInUseDuringInterval(String facilityName) {
        boolean success = false;
        //find facility
        for (int i = 0; i < F.facilityNames.length; i++) {
            if (F.facilityNames[i].equalsIgnoreCase(facilityName)) {

                //determine if facility is in use
                //additional info for time needs to be implemented.
                if (F.capacity == 0) {
                    success = true;
                }
            }
        }
        return success;
    }

    public void assignFacilityToUse(String facilityName) {
        System.out.println("What is your name?");
        String userName = F.reader.nextLine();

        //Find facility
        for (int i = 0; i < F.facilityNames.length; i++) {
            if (F.facilityNames[i].equalsIgnoreCase(facilityName)) {
                for (int j = 0; j < user.length; j++) {
                    if (!user[j].equalsIgnoreCase(userName)) {
                        user[i] = userName;
                        usageCount[i] += 1;
                        System.out.println("Facility " + facilityName + " has been assigned to " + userName + " successfully.");
                    }
                }
            }
        }
    }

    public void vacateFacility(String facilityName) {
        //Find facility
        for (int i = 0; i < F.facilityNames.length; i++) {
            if (F.facilityNames[i].equalsIgnoreCase(facilityName)) {
                F.employeeCount[i] = 0; // Vacates facility
            }
        }
    }

    public String listInspections(String facilityName) {
        //Find facility
        String success = "Looking for facility";
        for (int i = 0; i < F.facilityNames.length; i++) {
            if (F.facilityNames[i].equalsIgnoreCase(facilityName)) {
                if (inspections[i] != 0) {
                    success = "Facility " + facilityName + " has had " + inspections[i] + " inspections/maintenance calls";
                } else {
                    success = "Facility " + facilityName + " has had no inspections/maintenance calls";
                }
            }
        }
        return success;
    }

    public void listActualUsage() {
        for (int i = 0; i < F.facilityNames.length; i++) {
            if (F.employeeCount[i] != 0 && user[i] != null) {
                System.out.println("Facility " + F.facilityNames[i] + " is being used by " + F.employeeCount[i] + "amount of employees used by " + user[i]);
            }
        }
    }

    public String calcUsageRate(String facilityName) {
        int currentUsageRate = 0;

        for (int i = 0; i < F.facilityNames.length; i++) {
            if (F.facilityNames[i].equalsIgnoreCase(facilityName)) {
                usageRate[i] = ((usageCount[i] / 365) * 100);
                currentUsageRate = usageRate[i];
            }
        }
        return facilityName + "'s usage rate is " + currentUsageRate + "%";
    }
}