package cse250.pa3.tests;
import cse250.pa3.DataTools;
import cse250.pa3.HealthRecord;
import cse250.pa3.VoterRecord;
import java.io.*;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class DataToolsTests {



    @Test
    public void mytest() throws IOException {



        List<VoterRecord> voterstest = null;
        List<HealthRecord> healthtest = null;
        List<VoterRecord> voters100test = null;
        List<HealthRecord> health100test = null;
        BufferedReader vote1 = null;
        BufferedReader vote100 = null;
        BufferedReader health1 = null;
        BufferedReader health100 = null;


            voterstest = DataTools.loadVoterRecords(new File("data/Voter-Records-10.csv"));
            voters100test = DataTools.loadVoterRecords(new File("data/Voter-Records-100.csv"));
            healthtest = DataTools.loadHealthRecords(new File("data/Health-Records-10.csv"));
            health100test = DataTools.loadHealthRecords(new File("data/Health-Records-100.csv"));

            List<VoterRecord> votersmytest = new ArrayList<>();
            List<HealthRecord> healthmytest = null;
            List<VoterRecord> voters100mytest = null;
            List<HealthRecord> health100mytest = null;


            vote1 = new BufferedReader(new FileReader("data/Voter-Records-10.csv"));
            vote100 = new BufferedReader(new FileReader("data/Voter-Records-100.csv"));
            health1 = new BufferedReader(new FileReader("data/Health-Records-10.csv"));
            health100 = new BufferedReader(new FileReader("data/Health-Records-100.csv"));


            for(int i=0; i<voterstest.size(); i++){
                System.out.println(voterstest.get(i).getFirstName() + " " + voterstest.get(i).getLastName() + " " + voterstest.get(i).getBirthday() + " " + voterstest.get(i).getZipCode());
            }

            System.out.println("BELOWS IS YOURS");

            String line;
            vote1.readLine();
            while((line = vote1.readLine()) != null){

                String[] temp = line.split(",");



                Date birthday = DataTools.parseDate(temp[2]);




                if(temp[3].isEmpty()){
                    temp[3] = null;
                }


                VoterRecord submit = new VoterRecord(
                        temp[0], temp[1], birthday, temp[3]
                );

                    votersmytest.add(submit);


                System.out.println(submit.getFirstName() + " " + submit.getLastName() + " " + submit.getBirthday() + " " + submit.getZipCode());


            }

/*
            while((line = vote100.readLine())!=null){

                voters100mytest.add(helperfunctionvote(line));

            }

        */

//            while((line = health1.readLine()) != null){
//
//                healthmytest.add(helperfunctionhealth(line));
//            }
//
//            while((line = health100.readLine()) != null){
//
//                health100mytest.add(helperfunctionhealth(line));
//            }

            //tests start here
            for(int i=0; i<voterstest.size(); i++){
                assertEquals(votersmytest.get(i).getFirstName(), voterstest.get(i).getFirstName());
                assertEquals(votersmytest.get(i).getZipCode(), voterstest.get(i).getZipCode());
                assertEquals(votersmytest.get(i).getLastName(), voterstest.get(i).getLastName());
                assertEquals(votersmytest.get(i).getBirthday(), voterstest.get(i).getBirthday());
            }
        //assertEquals(voters100mytest, voters100test);
        //assertEquals(healthmytest, healthtest);
        //assertEquals(health100mytest, health100test);

        }





    /*
    public HealthRecord helperfunctionhealth(String x){
        String [] temp = x.split(",");
        HealthRecord submit = null;
        return submit;
    }*/


    @Test
    public void simpleFileTest() {
        List<VoterRecord> voters = null;
        List<HealthRecord> health = null;
        try {
            voters = DataTools.loadVoterRecords(new File("data/Voter-Records-10.csv"));
            health = DataTools.loadHealthRecords(new File("data/Health-Records-10.csv"));
        } catch (IOException e) {
            fail("Failed to load files correctly");
        } finally {
            Map<String, HealthRecord> matches = DataTools.identifyPersons(voters, health);
            assertTrue(matches.containsKey("DEWEY WILSON"));
        }
    }

    @Test
    public void quicktest() throws IOException {
        var test = new ArrayList<HealthRecord>();
        var x = new HealthRecord(null, null, "A+", false, true, true, false);
        test.add(x);
        assertEquals(x.getBirthday(), DataTools.loadHealthRecords(new File("data/healthrecordtest.csv")).get(0).getBirthday());
        assertEquals(x.getZipCode(), DataTools.loadHealthRecords(new File("data/healthrecordtest.csv")).get(0).getZipCode());
    }

}