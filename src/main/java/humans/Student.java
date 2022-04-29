package humans;

import java.util.Objects;

public class Student extends Human implements IHumanoid{
    private String faculty;
    public Student(String surname, String name, String lastname, String faculty, int age) {
        super(surname, name, lastname, age);
        if(faculty == null || faculty.isEmpty()){
            throw new IllegalArgumentException("Faculty is null");
        }
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        if(faculty == null || faculty.isEmpty()){
            throw new IllegalArgumentException("Faculty is null");
        }
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "faculty='" + faculty + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(getFaculty(), student.getFaculty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFaculty());
    }
}
