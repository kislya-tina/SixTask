package collect;

import humans.Human;
import humans.IHumanoid;

import java.util.*;

public class CollectionsDemo {

    /**
     * 1
     * среди входного листа строк найти те, у которых первый символ - входной//done + test
     * @param stringList
     * @param symbol
     * @return
     * +++
     */
    public static int countStrings(List<String> stringList, char symbol){
        int count = 0;
        for(String str:stringList){
            if(str == null || str.isEmpty()){
                throw new IllegalArgumentException("String in string list is null");
            }
            if(str.charAt(0) == symbol){
                count++;
            }
        }
        return count;
    }

    /**
     * 3
     * @param humanList
     * @param human
     * @return
     */
    public static List<Human> withoutHuman(List<Human> humanList, Human human){//3::done + test
        if(humanList == null || human == null){
            throw new IllegalArgumentException("List of human or human is null");
        }
        List<Human> result = new ArrayList<>();
        for(Human human1:humanList){
            if(human1 == null){
                throw new IllegalArgumentException("");
            }
            if(!human.equals(human1)){
                Human human2 = new Human(human1);
                result.add(human2);
            }
        }
        return result;
    }

    /**
     * 4
     * @param list
     * @param item
     * @return
     * // TODO: 4/28/2022 // done
     * //Collections.disjoint()
     */
    public static List<Set<Integer>> getNonIntersection(List<Set<Integer>> list, Set<Integer> item) {//4 done - test
        if(item == null){
            throw new IllegalArgumentException("Set is null");
        }
        List<Set<Integer>> helpList = new ArrayList<>();
        for(Set<Integer> set : list){
            helpList.add(new HashSet<>(set));
        }
        List<Set<Integer>> resultList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            helpList.get(i).retainAll(item);
            if(helpList.get(i).size() == 0){
                resultList.add(list.get(i));
            }
        }
        return resultList;
    }

    /**
     * 7
     * @param map
     * @param set
     * @return
     */
    public static Set<Human> findByID(Map<Integer, Human> map, Set<Integer> set){
        if(set == null){
            throw new IllegalArgumentException("Set is null");
        }
        Set<Human> result = new HashSet<>();

        for(Map.Entry<Integer, Human> hum : map.entrySet()) {
            if(hum.getValue() == null){
                throw new IllegalArgumentException("Human in map is null");
            }
            if(set.contains(hum.getKey())){
                result.add(hum.getValue());
            }
        }
        return result;
    }

    public static List<Integer> findByAge(Map<Integer, Human> map){//8
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Human> hum : map.entrySet()) {
            if(hum.getValue() == null){
                throw new IllegalArgumentException("Human in map is null");
            }
            if(hum.getValue().getAge() >= 18){
                result.add(hum.getKey());
            }
        }
        return result;
    }

    public static Map<Integer, Integer> idToAge(Map<Integer, IHumanoid> map){//9::done + test
        Map<Integer, Integer> result = new HashMap<>();
        for(Map.Entry<Integer, IHumanoid> hum : map.entrySet()) {
            if(hum.getValue() == null){
                throw new IllegalArgumentException("Human in map is null");
            }
            result.put(hum.getKey(), hum.getValue().getAge());
        }
        return result;
    }

    /**
     * 10
     * @param set
     * @return
     */
    public static Map<Integer, List<Human>> sortByAge(Set<Human> set){
        if(set == null){
            throw new IllegalArgumentException("Set is null");
        }
        Map<Integer, List<Human>> result = new HashMap<>();
        for(Human human : set){
            if(human == null){
                throw new IllegalArgumentException("Human is null");
            }
            if(!result.containsKey(human.getAge())){
                List<Human> list = new ArrayList<>();
                list.add(human);
                result.putIfAbsent(human.getAge(), list);
            }else{
                result.get(human.getAge()).add(human);
            }
        }
        return result;
    }

    /**
     * 11
     * @param set
     * @return
     */
    public static Map<Integer, Map<Character, List<Human>>> sortByAgeAndLetters(Set<Human> set){
        if(set == null){
            throw new IllegalArgumentException("Set is null");
        }

        Map<Integer, Map<Character, List<Human>>> result = new HashMap<>();

        Map<Integer, List<Human>> helpMap = sortByAge(set);
        Set<Character> helpChar = new HashSet<>();
        for(Map.Entry<Integer, List<Human>> map : helpMap.entrySet()) {
            for (Human human : map.getValue()) {
                if(!helpChar.contains(human.getSurname().charAt(0))){
                    helpChar.add(human.getSurname().charAt(0));
                    List<Human> humanList = new ArrayList<>();
                    humanList.add(human);
                    Map<Character, List<Human>> characterListMap = new HashMap<>();
                    characterListMap.put(human.getSurname().charAt(0), humanList);
                    result.putIfAbsent(map.getKey(), characterListMap);
                }else{
                    result.get(map.getKey()).get(human.getSurname().charAt(0)).add(human);
                }
            }
            helpChar.clear();
        }
        return result;
    }
}