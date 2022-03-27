package src;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FacilityUse {

    ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/app-context.xml");

    Facility fac = (Facility) context.getBean("fac");
    FacilityMaintenance facMaint = (FacilityMaintenance) context.getBean("facMaint");

    String[] user = new String[10];
    int[] inspections = new int[10];
    int[] usageCount = new int[10];
    int[] usageRate = new int[10];


    public boolean isInUseDuringInterval(String facilityName) {
        boolean success = false;
        //find facility
        for (int i = 0; i < fac.facilityNames.length; i++) {
            if (fac.facilityNames[i].equalsIgnoreCase(facilityName)) {
                if(user[i] != null){
                    System.out.println("This facility is in use by " + user[i] + ".");
                    success = true;
                }
            }
        }
        return success;
    }

    public void assignFacilityToUse(String facilityName) {
        System.out.println("What is your name?");
        String userName = fac.reader.nextLine();

        //Find facility
        for (int i = 0; i < fac.facilityNames.length; i++) {
            if (fac.facilityNames[i].equalsIgnoreCase(facilityName)) {
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
        for (int i = 0; i < fac.facilityNames.length; i++) {
            if (fac.facilityNames[i].equalsIgnoreCase(facilityName)) {
                fac.employeeCount[i] = 0; // Vacates facility
            }
        }
    }

    public String listInspections(String facilityName) {
        //Find facility
        String success = "Looking for facility";
        for (int i = 0; i < fac.facilityNames.length; i++) {
            if (fac.facilityNames[i].equalsIgnoreCase(facilityName)) {
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
        for (int i = 0; i < fac.facilityNames.length; i++) {
            if (fac.employeeCount[i] != 0 && user[i] != null) {
                System.out.println("Facility " + fac.facilityNames[i] + " is being used by " + fac.employeeCount[i] + "amount of employees used by " + user[i]);
            }
        }
    }

    public String calcUsageRate(String facilityName) {
        int currentUsageRate = 0;

        for (int i = 0; i < fac.facilityNames.length; i++) {
            if (fac.facilityNames[i].equalsIgnoreCase(facilityName)) {
                usageRate[i] = ((usageCount[i] / 365) * 100);
                currentUsageRate = usageRate[i];
            }
        }
        return facilityName + "'s usage rate is " + currentUsageRate + "%";
    }
}