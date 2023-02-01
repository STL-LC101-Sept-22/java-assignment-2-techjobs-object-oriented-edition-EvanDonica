package org.launchcode.techjobs.oo.test;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Job testJob;
    Job secondTestJob;
    Job thirdTestJob;
    Job copyJob;

    @Before
    public void createJobObject(){
        testJob = new Job("Software Engineer",new Employer("MasterCard"),new Location(""),new PositionType("Software Development"), new CoreCompetency("Google"));
        secondTestJob = new Job("Special Education Teacher",new Employer("Premier Charter School"),new Location("St.Louis"),new PositionType("Teacher"), new CoreCompetency("patience"));
        thirdTestJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        copyJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }
    @Test
    public void testToStringHandlesEmptyField(){

        String testJobString = "\n" +
                "ID: "+ testJob.getId()+"\n"+
                "Name: Software Engineer\n" +
                "Employer: MasterCard\n" +
                "Location: Data not available\n" +
                "Position Type: Software Development\n" +
                "Core Competency: Google\n";
        assertEquals(testJob.toString(),testJobString);
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine (){
        assertEquals(testJob.toString().charAt(0), '\n');
        assertEquals(testJob.toString().charAt(testJob.toString().length()-1), '\n');
    }
    @Test
    public void testSettingJobId(){
        testJob = new Job("Software Engineer",new Employer("MasterCard"),new Location(""),new PositionType("Software Development"), new CoreCompetency("Google"));
        secondTestJob = new Job("Special Education Teacher",new Employer("Premier Charter School"),new Location("St.Louis"),new PositionType("Teacher"), new CoreCompetency("patience"));
        assertNotEquals(testJob.getId(),secondTestJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue( thirdTestJob.getEmployer() instanceof Employer);
        assertEquals(thirdTestJob.getEmployer().getValue(),"ACME");

        assertTrue( thirdTestJob.getLocation() instanceof Location);
        assertEquals(thirdTestJob.getLocation().getValue(),"Desert");

        assertTrue( thirdTestJob.getPositionType() instanceof PositionType);
        assertEquals(thirdTestJob.getPositionType().getValue(),"Quality control");

        assertTrue( thirdTestJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(thirdTestJob.getCoreCompetency().getValue(),"Persistence");
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(thirdTestJob.equals(copyJob));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        String jobString =
                "\n" +
                "ID: "+ testJob.getId()+"\n" +
                "Name: Software Engineer\n" +
                "Employer: MasterCard\n" +
                "Location: Data not available\n" +
                "Position Type: Software Development\n" +
                "Core Competency: Google\n";

        assertEquals(jobString, testJob.toString());
    }

}
