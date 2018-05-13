package com.company;

import java.util.Objects;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife).
     * Example: if both persons have spouses - then divorce will set 4 spouse to null and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        if (man == person.isMan()) {
            System.out.println("The same gender.");
            return false;
        }
        if (spouse != null) {
            if (person.getSpouse() != null) {
                if (spouse.equals(person) && person.getSpouse().equals(this)) {
                    System.out.println("Already married.");
                    return false;
                }
                person.getSpouse().divorce();
            }
        } else {
            if (person.getSpouse() != null) {
                person.getSpouse().divorce();
            }
        }
        spouse = person;
        person.setSpouse(this);
        System.out.println(name + " and " + person.getName() + " have just married.");
        return true;
    }

    /***
     * Sets spouse = null if spouse is not null
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        if (spouse != null) {
            spouse = null;
            return true;
        }
        return false;
    }

    // Setter
    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    // Getters
    public boolean isMan() {
        return man;
    }
    public String getName() {
        return name;
    }
    public Person getSpouse() {
        return spouse;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.man ? 1 : 0);
        hash = 41 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.man != other.man) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
