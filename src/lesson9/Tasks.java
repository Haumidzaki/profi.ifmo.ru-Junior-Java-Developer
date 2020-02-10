package lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tasks {
    List<Integer> div2;
    List<Integer> div3;
    List<Integer> others;
    public static void main(String[] args) {
        new Tasks().run();
    }
    private void run(){
        List<Integer> numList = getData(20);
        div2 = new ArrayList<>();
        div3 = new ArrayList<>();
        others = new ArrayList<>();
        for(int i :numList){
            if(i%2 == 0) div2.add(i);
            if(i%3 == 0) div3.add(i);
            if(i%2 != 0 && i%3 != 0) others.add(i);
        }
        printList();
    }
    private List<Integer> getData(int lenght){
        List<Integer> numList = new ArrayList<>(lenght);
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 20; i++){
            numList.add(sc.nextInt());
        }
        return numList;
    }
    private void printList(){
        System.out.println(div2.toString());
        System.out.println(div3.toString());
        System.out.println(others.toString());
    }
    private void printList(List<Integer> list){
        System.out.println(list);
    }
}