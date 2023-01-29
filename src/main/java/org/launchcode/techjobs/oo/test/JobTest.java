package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId(){
        Job testJob = new Job("Software Engineer",new Employer("MasterCard"),new Location("Kansas City"),new PositionType("Software Development"), new CoreCompetency("Google"));
        Job secondTestJob = new Job("Special Education Teacher",new Employer("Premier Charter School"),new Location("St.Louis"),new PositionType("Teacher"), new CoreCompetency("patience"));
        assertNotEquals(testJob.getId(),secondTestJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue( testJob.getEmployer() instanceof Employer);
        assertEquals(testJob.getEmployer().toString(),"ACME");

        assertTrue( testJob.getLocation() instanceof Location);
        assertEquals(testJob.getLocation().toString(),"Desert");

        assertTrue( testJob.getPositionType() instanceof PositionType);
        assertEquals(testJob.getPositionType().toString(),"Quality control");

        assertTrue( testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(testJob.getCoreCompetency().toString(),"Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job testJob = new Job("Software Engineer",new Employer("MasterCard"),new Location("Kansas City"),new PositionType("Software Development"), new CoreCompetency("Google"));
        Job secondJob = new Job("Software Engineer",new Employer("MasterCard"),new Location("Kansas City"),new PositionType("Software Development"), new CoreCompetency("Google"));
        assertFalse(testJob.equals(secondJob));
    }

}
