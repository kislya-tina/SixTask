package collect;

import humans.Human;
import humans.IHumanoid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListDemo {
    /**
     * 2
     * @param list
     * @param human
     * @return
     */
    public static List<Human> sameSurnames(List<Human> list, Human human){//2 done + test
        List<Human> result = new ArrayList<>();
        for(Human hum : list){
            if(hum == null){
                throw new IllegalArgumentException("Human in list is null");
            }
            if(hum.getSurname().equals(human.getSurname())){
                Human hum1 = new Human(hum);
                result.add(hum1);
            }
        }
        return result;
    }

    /**
     * 5
     * @param list
     * @return
     */
    public static Set<IHumanoid> findOldest(List<IHumanoid> list){//done + test
        Set<IHumanoid> result = new HashSet<>();
        int maxAge = -1;
        for(IHumanoid hum : list){
            if(hum == null){
                throw new IllegalArgumentException("Human is null");
            }
            if(hum.getAge() > maxAge){
                maxAge = hum.getAge();
            }
        }
        for(IHumanoid hum : list){
            if(hum.getAge() == maxAge){
                result.add(hum);
            }
        }
        return result;
    }
}