package cse250.pa3;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static cse250.pa3.HealthRecord.Attribute.HealthRecordBloodType;

public class Main {
    public static void main(String[] args) {
        List<VoterRecord> voterRecords = null;
        List<HealthRecord> healthRecords = null;
        try {
            voterRecords = DataTools.loadVoterRecords(new File("data/Voter-Records-10.csv"));
            healthRecords = DataTools.loadHealthRecords(new File("data/Health-Records-10.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            Map<String, HealthRecord> matches = DataTools.identifyPersons(voterRecords, healthRecords);

            for (String name : matches.keySet()) {
                System.out.println("Found a match for " + name);
            }

            Map<String,Double> dist = DataTools.computeHealthRecordDist(healthRecords, HealthRecordBloodType);

            for (String bloodType : dist.keySet()) {
                System.out.println(bloodType + " appears in " + dist.get(bloodType) * 100 + " percent of the population");
            }
        }
    }
}
