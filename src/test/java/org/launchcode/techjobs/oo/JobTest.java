package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job test_job_one = new Job();
        Job test_job_two = new Job();
        assertNotEquals(test_job_one.getId(), test_job_two.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        String name = "Product tester";
        Employer employer = new Employer("ACME");
        Location location = new Location("Desert");
        PositionType position = new PositionType("Quality control");
        CoreCompetency coreCompetency = new CoreCompetency("Persistence");

        Job test_job = new Job(name, employer, location, position, coreCompetency);

        assertEquals(name, test_job.getName());
        assertEquals(employer, test_job.getEmployer());
        assertEquals(location, test_job.getLocation());
        assertEquals(position, test_job.getPositionType());
        assertEquals(coreCompetency, test_job.getCoreCompetency());

        assertTrue(employer instanceof Employer);
        assertTrue(location instanceof Location);
        assertTrue(position instanceof PositionType);
        assertTrue(coreCompetency instanceof CoreCompetency);
        assertTrue(test_job instanceof Job);
    }

    @Test
    public void testJobsForEquality() {
        Job test_job_one = new Job("Bob", new Employer("Target"), new Location("Chicago"), new PositionType("Manager"), new CoreCompetency("Leadership"));
        Job test_job_two = new Job("Bob", new Employer("Target"), new Location("Chicago"), new PositionType("Manager"), new CoreCompetency("Leadership"));

        assertFalse(equals(test_job_one) != equals(test_job_two));
    }

}
