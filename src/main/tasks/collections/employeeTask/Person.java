package tasks.collections.employeeTask;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Person {
    LocalDate birthDate;
    String id;
    String firstName;
    String lastName;

    public Person(LocalDate birthDate, String id, String firstName, String lastName) {
        this.birthDate = birthDate;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other == null || (this.getClass() != other.getClass())) {
            return false;
        } else {
            Person otherPerson = (Person) other;
            return this.id.equals(otherPerson.id);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDate);
    }

    @Override
    public String toString() {
        return String.format("%s# %s %s | %d years old", id, firstName, lastName, getAge());
    }

    public static List<Person> sortPeopleByAge(List<Person> people) {
        return people
                .stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .toList();
    }

    public static Comparator<Person> byAgeOldestFirst() {
        return (Person person1, Person person2) -> Integer.compare(person2.getAge(), person1.getAge());
    }

    public static Comparator<Person> byLastNameAlphabetically() {
        return Comparator.comparing(Person::getLastName);
    }

    public static List<Person> filterAdult(List<Person> people) {
        return people
                .stream()
                .filter(person -> person.getAge() >= 18)
                .sorted(Person.byAgeOldestFirst())
                .sorted(Person.byLastNameAlphabetically())
                .toList();
    }
}