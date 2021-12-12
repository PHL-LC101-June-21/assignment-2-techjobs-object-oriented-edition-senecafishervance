package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.


    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        return id == job.id;
    }

    @Override
    public int hashCode() {
        return id;
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }


    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }


    @Override
    public String toString() {
        String noData = "Data not available";
        String toStringName;
        String toStringEmployer;
        String toStringLocation;
        String toStringPositionType;
        String toStringCoreCompetency;

        if (getName() == null && getLocation() == null && getPositionType() == null && getCoreCompetency() == null) {
            return "OOPS! This job does not seem to exist";
        }

        if (getName() == null || getName().isEmpty()) {
            toStringName = noData;
        } else {
            toStringName = getName();
        }
        ;
        if (getEmployer() == null || getEmployer().getValue().isEmpty()) {
            toStringEmployer = noData;
        } else {
            toStringEmployer = getEmployer().toString();
        }
        ;
        if (getLocation() == null || getLocation().getValue().isEmpty()) {
            toStringLocation = noData;
        } else {
            toStringLocation = getLocation().toString();
        }
        ;
        if (getPositionType() == null || getPositionType().getValue().isEmpty()) {
            toStringPositionType = noData;
        } else {
            toStringPositionType =
                    getPositionType().toString();
        }
        ;
        if (getCoreCompetency() == null || getCoreCompetency().getValue().isEmpty()) {
            toStringCoreCompetency = noData;
        } else {
            toStringCoreCompetency =
                    getCoreCompetency().toString();
        }
        ;

        return "\n" + "ID: " + getId() + "\n" + "Name: " + toStringName + "\n" + "Employer: " + toStringEmployer + "\n" + "Location: " + toStringLocation + "\n" + "Position Type: " + toStringPositionType + "\n" + "Core Competency: " + toStringCoreCompetency + "\n";
    }


}
