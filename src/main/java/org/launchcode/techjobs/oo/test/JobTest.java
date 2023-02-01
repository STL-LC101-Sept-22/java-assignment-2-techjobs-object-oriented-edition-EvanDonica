package org.launchcode.techjobs.oo.test;

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
        copyJob = new Job("Software Engineer",new Employer("MasterCard"),new Location("Kansas City"),new PositionType("Software Development"), new CoreCompetency("Google"));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine (){
        char firstChar = testJob.toString().charAt(0);
        char lastChar = testJob.toString().charAt(testJob.toString().length()-1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
    }
    @Test
    public void testSettingJobId(){
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
        assertFalse(testJob.equals(copyJob));
    }

}
