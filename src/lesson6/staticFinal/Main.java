package lesson6.staticFinal;

import lesson6.nested.LinkedList;

public class Main {
    public static void main(String[] args) {
        String fileName = "file.json";

        // вызов статического метода
        Handler handler = Handler.getInstance(fileName);
        handler.read();
        handler.write();

//        CalcUtils calcUtils = new CalcUtils();
//        calcUtils.summ(3, 8);

        System.out.println(CalcUtils.summ(2, 7));

        LinkedList list = new LinkedList();
        list.add(2);
        list.add(6);
        list.add(3);

        for (Object o: list){

        }
    }
}
