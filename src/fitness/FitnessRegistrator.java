package fitness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FitnessRegistrator {
    private ArrayList<Human> inGym = new ArrayList<>();
    private ArrayList<Human> inPool = new ArrayList<>();
    private ArrayList<Human> inGroup = new ArrayList<>();
    // либо
    private HashMap<String, HashSet> clients = new HashMap<>();

    public void add(Human human, FitnessServiceEnumeration type) {
        if (FitnessServiceEnumeration.GYM.equals(type)) {

            inGym.add(human);
        }
    }

}
