package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import javax.print.DocFlavor;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId()
    {
        Job jobOne = new Job();
        Job jobTwo = new Job();

//        id values are not the same
        Assert.assertNotEquals(jobOne, jobTwo);

//        id values differ by 1
        Assert.assertSame((jobTwo.getId() - 1), jobOne.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertTrue(true);

        Assert.assertSame("Product tester", testJob.getName());

        Assert.assertNotNull(testJob.getEmployer());
        Assert.assertSame("ACME", testJob.getEmployer().getValue());

        Assert.assertNotNull(testJob.getLocation());
        Assert.assertSame("Desert", testJob.getLocation().getValue());

        Assert.assertNotNull(testJob.getPositionType());
        Assert.assertSame("Quality control", testJob.getPositionType().getValue());

        Assert.assertNotNull(testJob.getCoreCompetency());
        Assert.assertSame("Persistence", testJob.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality() {
        Job Job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job Job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // id values are not the same
        Assert.assertFalse(Job1.equals(Job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job();
        job.setName("name");
        Assert.assertEquals('\n', job.toString().charAt(0));
        Assert.assertEquals('\n', job.toString().charAt(job.toString().length() - 1));

    }

    @Test
    public void testToStringPrintLabels() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String[] lines = testJob.toString().trim().split("\n");

        System.out.println(testJob.toString());

        Assert.assertTrue(lines.length == 6);

        Assert.assertTrue(lines[0].startsWith("ID:"));
        Assert.assertTrue(lines[1].startsWith("Name:"));
        Assert.assertTrue(lines[2].startsWith("Employer:"));
        Assert.assertTrue(lines[3].startsWith("Location:"));
        Assert.assertTrue(lines[4].startsWith("Position Type:"));
        Assert.assertTrue(lines[5].startsWith("Core Competency:"));

        Assert.assertTrue(lines[0].endsWith(Integer.toString(testJob.getId())));
        Assert.assertTrue(lines[1].endsWith(testJob.getName()));
        Assert.assertTrue(lines[2].endsWith(testJob.getEmployer().toString()));
        Assert.assertTrue(lines[3].endsWith(testJob.getLocation().toString()));
        Assert.assertTrue(lines[4].endsWith(testJob.getPositionType().toString()));
        Assert.assertTrue(lines[5].endsWith(testJob.getCoreCompetency().toString()));
    }

    @Test
    public void testToStringHandlesEmptyField(){
        String idLabel = "ID: "; String nameLabel = "Name: "; String employerLabel = "Employer: "; String locationLabel = "Location: "; String positionTypeLabel = "Position Type: "; String coreCompetencyLabel = "Core Competency: ";
        Job emptyJob3 = new Job("",new Employer(""),new Location("location name"), new PositionType(""), new CoreCompetency(""));
        String noData = "Data not available";

        Assert.assertTrue(emptyJob3.getName().equals("") && emptyJob3.toString().contains(nameLabel + noData));
        Assert.assertTrue(emptyJob3.getEmployer().getValue().equals("") && emptyJob3.toString().contains(employerLabel + noData));
        Assert.assertTrue(emptyJob3.getPositionType().getValue().isEmpty() && emptyJob3.toString().contains(positionTypeLabel + noData));
        Assert.assertTrue(emptyJob3.getCoreCompetency().getValue().isEmpty() && emptyJob3.toString().contains(coreCompetencyLabel + noData));
    }

    @Test
    public void testForEmptyJob(){
        Job emptyJob2 = new Job();
        Assert.assertTrue(emptyJob2.toString().equals("OOPS! This job does not seem to exist"));
    }

    @Test
    public void testJobFieldsDataForNull(){
        String idLabel = "ID: "; String nameLabel = "Name: "; String employerLabel = "Employer: "; String locationLabel = "Location: "; String positionTypeLabel = "Position Type: "; String coreCompetencyLabel = "Core Competency: ";
        Job emptyJob = new Job();
        emptyJob.setName("Job has name!");
        String noData = "Data not available";

        Assert.assertTrue(emptyJob.getEmployer() == null && emptyJob.toString().contains(employerLabel + noData));
        Assert.assertTrue(emptyJob.getLocation() == null && emptyJob.toString().contains(locationLabel + noData));
        Assert.assertTrue(emptyJob.getPositionType() == null && emptyJob.toString().contains(positionTypeLabel + noData));
        Assert.assertTrue(emptyJob.getCoreCompetency() == null && emptyJob.toString().contains(coreCompetencyLabel + noData));
    }

}
