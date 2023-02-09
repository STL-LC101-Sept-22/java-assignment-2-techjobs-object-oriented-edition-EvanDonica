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
    Job testJob = new Job("Software Engineer",new Employer("MasterCard"),new Location(""),new PositionType("Software Development"), new CoreCompetency("Google"));
    Job secondTestJob = new Job("Special Education Teacher",new Employer("Premier Charter School"),new Location("St.Louis"),new PositionType("Teacher"), new CoreCompetency("patience"));
    Job thirdTestJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job copyJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    @Test
    public void testToStringHandlesEmptyField(){
        assertEquals(testJob.toString(),String.format("\nID: %d\nName: Software Engineer\nEmployer: MasterCard\nLocation: Data not available\nPosition Type: Software Development\nCore Competency: Google\n", testJob.getId()));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine (){
        String job = testJob.toString();
        assertEquals(job.charAt(0), '\n');
        assertEquals(job.charAt(job.length()-1), '\n');
    }
    @Test
    public void testSettingJobId(){
        testJob = new Job("Software Engineer",new Employer("MasterCard"),new Location(""),new PositionType("Software Development"), new CoreCompetency("Google"));
        secondTestJob = new Job("Special Education Teacher",new Employer("Premier Charter School"),new Location("St.Louis"),new PositionType("Teacher"), new CoreCompetency("patience"));
        assertNotEquals(testJob.getId(),secondTestJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(thirdTestJob.getName() instanceof String);
        assertEquals(thirdTestJob.getName(),"Product tester");

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
                "ID: "+ secondTestJob.getId()+"\n" +
                "Name: "+secondTestJob.getName()+"\n" +
                "Employer: "+secondTestJob.getEmployer()+"\n" +
                "Location: "+secondTestJob.getLocation()+"\n" +
                "Position Type: "+secondTestJob.getPositionType()+"\n" +
                "Core Competency: "+secondTestJob.getCoreCompetency()+"\n";

        assertEquals(jobString, secondTestJob.toString());
    }

}
