import humans.Human;

import humans.IHumanoid;
import humans.Student;
import org.testng.annotations.Test;


import java.util.*;

import static collect.CollectionsDemo.*;
import static collect.ListDemo.*;
import static org.testng.Assert.assertEquals;

public class CollectionsDemoTests {
    Human human = new Human("Jonny", "John", "jhon", 18);
    Human human1 = new Human("jony", "Johny", "jhony", 19);
    Human human2 = new Human("Jonny", "Johnny", "jhonny", 19);
    Human student = new Student("Jonny", "Johnny", "jhonny", "FMIT", 17);

    @Test
    public void withoutHumanTest(){

        List<Human>  originalList = new ArrayList<>();
        Collections.addAll(originalList, human, human1, human2);

        List<Human>  expected = new ArrayList<>();
        Collections.addAll(expected, human, human2);

        List<Human>  actual = withoutHuman(originalList, human1);

        assertEquals(actual, expected);
    }

    @Test
    public void countStringsTest(){
        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, human.getSurname(), human1.getSurname(), human2.getSurname());
        int actual = countStrings(stringList, 'j');
        assertEquals(actual, 1);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void sameSurnamesTest(){
        List<Human>  originalList = new ArrayList<>();
        Collections.addAll(originalList, human, null, human1, human2);

        List<Human>  expected = new ArrayList<>();
        Collections.addAll(expected, human, human2);

        assertEquals(sameSurnames(originalList, human), expected);
    }

    @Test
    public void nonIntersection(){//done
        Set<Integer> singlesSet = new HashSet<>();
        Collections.addAll(singlesSet, 1, 2);

        Set<Integer> singlesSet1 = new HashSet<>();
        Collections.addAll(singlesSet1, 3, 4);

        Set<Integer> tensSet = new HashSet<>();
        Collections.addAll(tensSet, 10, 20);

        List<Set<Integer>> actual = new ArrayList<>();
        Collections.addAll(actual, singlesSet, tensSet);
        actual = getNonIntersection(actual, singlesSet1);

        List<Set<Integer>> expected = new ArrayList<>();
        Collections.addAll(expected, singlesSet, tensSet);

        assertEquals(actual, expected);
    }

    @Test
    public void findOldestTest(){//done
        List<IHumanoid> hummi = new ArrayList<>();
        Collections.addAll(hummi, human, human1, human2, student);

        Set<IHumanoid> expected = new HashSet<>();
        Collections.addAll(expected, human1, human2);

        Set<IHumanoid> actual = findOldest(hummi);

        assertEquals(actual, expected);
    }

    @Test
    public void findByIDTest(){//7::done
        Map<Integer, Human> map = new HashMap<>();
        map.put(000, human);
        map.put(001, human1);
        map.put(002, human2);
        map.put(003, student);

        Set<Integer> set = new HashSet<>();
        Collections.addAll(set, 111, 12, 3, 5);

        Set<Human> actual = findByID(map, set);

        Set<Human> expectedID = new HashSet<>();
        Collections.addAll(expectedID,   student);

        assertEquals(actual, expectedID);
    }

    @Test
    public void idToAgeTest(){//9::done
        Map<Integer, IHumanoid> map = new HashMap<>();
        map.put(000, human);
        map.put(001, human1);
        map.put(002, human2);
        map.put(003, student);

        Map<Integer, Integer> actual = idToAge(map);

        Map<Integer, Integer> expectedID = new HashMap<>();
        expectedID.put(000, 18);
        expectedID.put(001, 19);
        expectedID.put(002, 19);
        expectedID.put(003, 17);

        assertEquals(actual, expectedID);
    }

    @Test
    public void findByAgeTest(){//8:: done
        Map<Integer, Human> map = new HashMap<>();
        map.put(000, human);
        map.put(001, human1);
        map.put(002, human2);
        map.put(003, student);

        List<Integer> actual = findByAge(map);

        List<Integer> expectedAge = new ArrayList<>();
        Collections.addAll(expectedAge, 0, 1, 2);

        assertEquals(actual, expectedAge);
    }

    @Test
    public void sortByAgeTest(){//10
        Set<Human> set = new HashSet<>();
        Collections.addAll(set, human, human1, human2);

        List<Human> eighteenYO = new ArrayList<>();
        eighteenYO.add(human);
        List<Human> nineteenYO = new ArrayList<>();
        nineteenYO.add(human1);
        nineteenYO.add(human2);

        Map<Integer, List<Human>> actual = sortByAge(set);

        Map<Integer, List<Human>> expected = new HashMap<>();
        expected.put(18, eighteenYO);
        expected.put(19, nineteenYO);

        assertEquals(actual, expected);
    }

    @Test
    public void sortByAgeAndLetterTest(){//10
        Set<Human> set = new HashSet<>();
        Collections.addAll(set, human, human1, human2);


        List<Human> humanJ18 = new ArrayList<>();
        humanJ18.add(human);

        List<Human> human1j19 = new ArrayList<>();
        human1j19.add(human1);
        List<Human> human2J19 = new ArrayList<>();
        human2J19.add(human2);

        Map<Character, List<Human>> map = new HashMap<>();
        map.put('J', humanJ18);
        Map<Character, List<Human>> map1 = new HashMap<>();
        map1.put('j', human1j19);
        Map<Character, List<Human>> map2 = new HashMap<>();
        map2.put('J', human2J19);

        Map<Integer, Map<Character, List<Human>>> actual = sortByAgeAndLetters(set);

        Map<Integer, Map<Character, List<Human>>> expected = new HashMap<>();
        expected.put(18, map);
        expected.put(19, map1);

        assertEquals(actual, expected);
    }
}