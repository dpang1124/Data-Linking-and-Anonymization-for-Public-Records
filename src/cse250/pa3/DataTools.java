package cse250.pa3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

public class DataTools {
    /**
     * Converts a string to a [[Date]] object, or null if the string is empty
     * @param dateString the string representing a date (or empty)
     * @return a date object corresponding to the passed in string (or null)
     */
    public static Date parseDate(String dateString) {
        if ("".equals(dateString)) {
            return null;
        } else {
            try {
                return DateFormat.getDateInstance(DateFormat.SHORT).parse(dateString);
            } catch (ParseException e) {
                System.err.println("Failed to parse date string: " + dateString);
                return null;
            }
        }
    }

    /**
     * Reads in and parses [[HealthRecord]]s from a CSV file

     * @return a list of [[HealthRecord]] objects corresponding to the lines of the csv file
     * @throws IOException
     *
     * This function should make the following assumptions about the CSV file:
     * 1. The first line of the CSV file is a header.
     * 2. Header fields are
     *     * "Birthday"
     *     * "Zip Code"
     *     * "Blood Type"
     *     * "Allergic to Dogs?"
     *     * "Allergic to Cats?"
     *     * "Allergic to Peanuts?"
     *     * "Allergic to Gluten?"
     * 3. Every subsequent line may be split into fields with [[String]]'s split method
     * 4. Columns containing dates are in a format interpretable by [[parseDate]]
     * 5. Columns containing strings may not have consistent capitalization
     * 6. Valid blood types are A+, A-, B+, B-, O+, O-, AB+, AB-. If the bloodtype in the csv file
     * does not match one of these (modulo capitalization) it should be entered as "N/A"
     * 7. Columns related to allergies will contain strings "yes" or "no" (modulo capitalization)
     *
     * Examples of valid CSV files can be found in `data/`
     */

    static boolean check1(String x){
        if(x.equalsIgnoreCase("yes")){return true;}
        else return false;
    }

    static String check2(String x){
        if(x.equalsIgnoreCase("a+")){return "A+";}
        else if (x.equalsIgnoreCase("a-")){return "A-";}
        else if (x.equalsIgnoreCase("b+")) {return "B+";}
        else if (x.equalsIgnoreCase("b-")) {return "B-";}
        else if (x.equalsIgnoreCase("o+")) {return "O+";}
        else if (x.equalsIgnoreCase("o-")) {return "O-";}
        else if (x.equalsIgnoreCase("AB+")) {return "AB+";}
        else if (x.equalsIgnoreCase("AB-")) {return "AB-";}
        else return "N/A";
        }

        static String zipcheck(String x){
        if(x.isEmpty()){
           return null;}

        else {
            return x;}
        }

    public static List<HealthRecord> loadHealthRecords(File file) throws IOException {
        var file1 = new BufferedReader(new FileReader(file));
        var loaded = new ArrayList<HealthRecord>();
        String line;
        file1.readLine();
        while((line = file1.readLine()) != null){

            String[] parse = line.split(",");


            var hold = new HealthRecord(parseDate(parse[0]), zipcheck(parse[1]), check2(parse[2]), check1(parse[3]), check1(parse[4]), check1(parse[5]), check1(parse[6]));
            loaded.add(hold);

        }
        return loaded;
    }

    /**
     * Reads in and parses [[VoterRecord]]s from a CSV file
     * @param file the [[File]] object to read the data from
     * @return a list of [[VoterRecord]] objects corresponding to the lines of the csv file
     * @throws IOException
     *
     * This function should make the following assumptions:
     * 1. The first line of the CSV file is a header.
     * 2. Header fields are
     *     * "First Name"
     *     * "Last Name"
     *     * "Birthday"
     *     * "Zip Code"
     * 3. Every subsequent line may be split into fields with [[String]]'s split method
     * 4. Columns containing dates are in a format interpretable by [[parseDate]]
     *
     * Examples of valid CSV files can be found in `data/`
     */
    public static List<VoterRecord> loadVoterRecords(File file) throws IOException {
        var file1 = new BufferedReader(new FileReader(file));
        var loaded = new ArrayList<VoterRecord>();
        String line;
        file1.readLine();
        while((line = file1.readLine()) != null){
            String[] parse = line.split(",",-1);


            var hold = new VoterRecord(parse[0], parse[1], parseDate(parse[2]), zipcheck(parse[3]));
            loaded.add(hold);

        }
        return loaded;
    }

    /**
     * De-anonymize a collection of "anonymized" [[HealthRecord]] objects using [[VoterRecord]]s
     * @param   voterRecords   A [[List]] of [[VoterRecord]]s containing names.
     * @param   healthRecords  A [[List]] of "anonymized" [[HealthRecord]]s.
     * @return                 A [[Map]] of Full Names associated with their [[HealthRecord]]s.
     *
     * For every [[HealthRecord]] that can be **uniquely** linked to a [[VoterRecord]], the map
     * returned by this function should contain a key-value pair.
     * The key should be the return value of the [[VoterRecord]]'s `fullName` method.
     * The value should be the (**unique**) associated [[HealthRecord]].
     *
     * If a [[VoterRecord]] can not be associated to any [[HealthRecord]], if it can not be
     * **uniquely** associated to just one [[HealthRecord]], or if the one [[HealthRecord]] it can
     * be associated with can be associated with multiple [[VoterRecord]]s, it should not be present
     * in the result map.
     *
     * This function **must** run in O(voterRecords.size() + healthRecords.size())
     */
    public static Map<String, HealthRecord> identifyPersons(List<VoterRecord> voterRecords, List<HealthRecord> healthRecords) {
        return new HashMap<>();
    }

    /**
     * Compute a histogram over one of the attributes of [[HealthRecord]]
     * @param    records      A [[List]] of [[HealthRecord]]s
     * @param    attribute    Either [[HealthRecordBloodType]] or [[HealthRecordAllergies]]
     * @return                A key-value pair of each stringified attribute value and the
     *                        percentage of the records that have this value. The percentage should
     *                        be a value in the range (0, 1]
     *
     * If attribute == HealthRecordBloodType, use [[HealthRecord]]'s `m_BloodType` field.
     *
     * If attribute == HealthRecordAllergies, use [[HealthRecord]]'s `m_DogAllergy`, `m_CatAllergy`,
     * `m_PeanutAllergy`, and `m_GlutenAllergy` fields.
     *
     * This function **must** run in O(healthRecords.size)
     */
    public static Map<String, Double> computeHealthRecordDist(List<HealthRecord> records, HealthRecord.Attribute attribute) {
        return new HashMap<>();
    }
}