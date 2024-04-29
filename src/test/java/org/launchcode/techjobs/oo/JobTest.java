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

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job test_job_one = new Job("Bob", new Employer("Target"), new Location("Chicago"), new PositionType("Manager"), new CoreCompetency("Leadership"));
        String newline = System.lineSeparator();
        String test_string = newline + "Job{" +
                "id=" + test_job_one.getId() +
                ", name='" + test_job_one.getName() + '\'' +
                ", employer=" + test_job_one.getEmployer() +
                ", location=" + test_job_one.getLocation() +
                ", positionType=" + test_job_one.getPositionType() +
                ", coreCompetency=" + test_job_one.getCoreCompetency() +
                '}' + newline;;

        assertEquals(test_string.startsWith(newline) && test_string.endsWith(newline), test_job_one.toString().startsWith(newline) && test_job_one.toString().endsWith(newline));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job test_job_one = new Job("Bob", new Employer("Target"), new Location("Chicago"), new PositionType("Manager"), new CoreCompetency("Leadership"));
        String newline = System.lineSeparator();
        String test_string = newline +
                "ID: " + test_job_one.getId() + newline +
                "Name: " + test_job_one.getName() + newline +
                "Employer: " + test_job_one.getEmployer() + newline +
                "Location: " + test_job_one.getLocation() + newline +
                "Position Type: " + test_job_one.getPositionType() + newline +
                "Core Competency: " + test_job_one.getCoreCompetency() + newline;

        assertEquals(test_string, test_job_one.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job test_job_one = new Job("Bob", new Employer(""), new Location("Chicago"), new PositionType(""), new CoreCompetency("Leadership"));
        String newline = System.lineSeparator();
        String test_string = newline +
                "ID: " + test_job_one.getId() + newline +
                "Name: " + test_job_one.getName() + newline +
                "Employer: Data not available" + newline +
                "Location: " + test_job_one.getLocation() + newline +
                "Position Type: Data not available" + newline +
                "Core Competency: " + test_job_one.getCoreCompetency() + newline;

        assertEquals(test_string, test_job_one.toString());
    }
}
