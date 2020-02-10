package multithreading.concur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentExample {

//    потокобезопасные коллекции
//    блокирующие и неблокирующие очереди
//    пул потоков
//    альтернативы wait() notify() и synchronised

    public static void main(String[] args) {
        LinkedBlockingQueue queue;
        LinkedBlockingDeque deque;

        LinkedTransferQueue transferQueue;

        PriorityBlockingQueue priorityBlockingQueue;

        // нельзя изменить размер
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(4, true);

        SynchronousQueue synchronousQueue; // очередь на один элемент






//        HashMap map = new HashMap();
//        map.putIfAbsent("qwe", 6);
//        map.putIfAbsent("qwe", 89);

//        CopyOnWriteArrayList вмеcто ArrayList
        CopyOnWriteArraySet set;

//        ConcurrentNavigableMap<String, Integer> map;
        // всместо TreeMap
//        ConcurrentSkipListMap<String, Integer> map1;
//        map1.putIfAbsent("qwe", 4);
//        map1.remove("qwe", 4);
//        map1.replace("qwe", 4, 78);
//        map1.replace("qwe", 56);
//        ConcurrentSkipListSet<String> set1;



        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("qwe");
        list.add("asd");
        list.add("zxc");
        list.add("rty");
        list.addIfAbsent("rty");

        new WriteThread(list).start();
        new ReadThread(list).start();

    }

}

class WriteThread extends Thread {
    private List<String> list;
    private ArrayList<String> data = new ArrayList<>();

    public WriteThread(List<String> list) {
        this.list = list;
        data.add("fgh");
        data.add("vbn");
        data.add("uio");
        data.add("jkl");
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            if (count == data.size()-1) count = 0;
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list.add(data.get(count));
            System.out.println("WriteThread added " + data.get(count));
            count++;
        }
    }
}

class ReadThread extends Thread {
    private List<String> list;

    public ReadThread(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            String res = "ReadThread res: ";
            for (String str: list) {
                if (list.contains("asd")) { // asd
                    list.remove(str);
                }
                res += str + " ";
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//            Iterator<String> iterator = list.iterator();
//            while (iterator.hasNext()) {
//                String next = iterator.next();
//                res += next + " ";
//
//                try {
//                    Thread.sleep(20);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

            System.out.println(res);
        }
    }
}




