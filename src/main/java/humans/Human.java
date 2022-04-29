package humans;

import java.util.Objects;

public class Human implements IHumanoid{
    private String surname;//фамилия
    private String name;//имя
    private String lastname;//отчество
    private int age;

    public Human(String surname, String name, String lastname, int age) {
        this.setSurname(surname);
        this.setName(name);
        this.setLastname(lastname);
        this.setAge(age);
    }

    public Human(Human human){
        surname = human.getSurname();
        name = human.getName();
        lastname = human.getLastname();
        age = human.getAge();
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public void setSurname(String surname) {
        if(surname == null || surname.isEmpty()){
            throw new IllegalArgumentException("Surname is empty");
        }
        this.surname = surname;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name is empty");
        }
        this.name = name;
    }

    public void setLastname(String lastname) {
        if(lastname == null || lastname.isEmpty()){
            throw new IllegalArgumentException("Lastname is empty");
        }
        this.lastname = lastname;
    }

    public void setAge(int age) {
        if(age < 0){
            throw new IllegalArgumentException("Human too young");
        }
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        return age == human.age &&
                surname.equals(human.surname) &&
                name.equals(human.name) &&
                lastname.equals(human.lastname);
    }

    @Override
    public String toString() {
        return "Human{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, lastname, age);
    }
}
