package lesson10;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        User user1 = new User("qwe", "111");
        User user2 = new User("asd", "222");
        User user3 = new User("zxc", "333");
        User user4 = new User();

        HashMap<String, User> userHashMap = new HashMap<>(23);
        userHashMap.put(user1.getLogin(), user1);
        userHashMap.put(user2.getLogin(), user2);
        userHashMap.put(user3.getLogin(), user3);
        userHashMap.put(null, user4);

        System.out.println(userHashMap.get("asd"));

        // перебор
        for(Map.Entry entry: userHashMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

//        LinkedHashMap

        // EnumMap (enum в качестве ключей)
        // нельзя использовать null в качестве ключа
        EnumMap<State, String> enumMap = new EnumMap<>(State.class);
        enumMap.put(State.ERROR, "ERROR");
        enumMap.put(State.START, "START");
        enumMap.put(State.STOP, "STOP");

        System.out.println(enumMap.get(State.ERROR));

        // сортировка по ключам
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "3");
        treeMap.put(1, "1");
        treeMap.put(6, "6");
        treeMap.put(2, "2");
        System.out.println(treeMap);

        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();
        HashMap<Object, String> hashMap = new HashMap<>();

        // ключи и значения
        Object hashKey = new Object();
        String hashValue = "hashValue";

        Object weakKey = new Object();
        String weakValue = "weakValue";

        hashMap.put(hashKey, hashValue);
        weakHashMap.put(weakKey, weakValue);

        System.out.println("hashMap " + hashMap);
        System.out.println("weakHashMap" + weakHashMap);

        hashKey = null;
        weakKey = null;

        System.gc();
        System.out.println("hashMap " + hashMap);
        System.out.println("weakHashMap" + weakHashMap);

        // ключи сравниваются с помощью операции == (не метода equals)
        IdentityHashMap<Integer, String> identityHashMap = new IdentityHashMap<>();

        HashMap<String, Integer> map = new HashMap<>();
        map.put("qwe", 23);
        map.put("asd", 12);
        map.put("zxc", 67);
        map.put("fgh", 33);
        map.put("rty", 10);

        map.remove("zxc");

        // ConcurrentModificationException
       /*for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() < 20) {
                map.remove(entry.getKey());
            }
        }*/

       Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
       // удаление во время итерации
       while (iterator.hasNext()){
           Map.Entry<String, Integer> entry = iterator.next();
           String key = entry.getKey();
           int val = entry.getValue();
           if (val < 20) {
               iterator.remove();
           }
       }


    }
}

enum State {
    START, STOP, ERROR
}

class User {
    private String login;
    private String pwd;

    public User(){}

    public User(String login, String pwd) {
        this.login = login;
        this.pwd = pwd;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return pwd != null ? pwd.equals(user.pwd) : user.pwd == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        return result;
    }
}