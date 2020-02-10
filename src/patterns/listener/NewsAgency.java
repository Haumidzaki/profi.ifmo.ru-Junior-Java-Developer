package patterns.listener;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency {
    private List<Listener> listeners = new ArrayList<>();

    public void addListener(Listener listener){
        listeners.add(listener);
    }

    public void deleteListener(Listener listener){
        listeners.remove(listener);
    }

    public void someChanges(String message){
        System.out.println("message: " + message);
        notifyListeners(message);
    }

    public void notifyListeners(String message) {
        for (Listener listener: listeners) {
            listener.publish(message);
        }
    }

    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        agency.addListener(new Listener() {
            @Override
            public void publish(String str) {
                System.out.println("Listener 1: " + str);
            }
        });

        agency.addListener(new Listener() {
            @Override
            public void publish(String str) {
                System.out.println("Listener 2: " + str);
            }
        });

        agency.someChanges("Some changes");
    }
}


interface Listener {
    void publish(String str);
}
