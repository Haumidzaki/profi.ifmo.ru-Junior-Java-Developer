package multithreading.synchronize;

import homework.MapHomework;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;






// Пиццерия
// Клиент (main), официант, повар
//        Каждый из потоков послевыполнения операции засыпает.
//        официант и повар спят, пока не появится клиент
//        Клиент оставляет заказ, будит официанта, официант передает заказ
//        повару и будит его
//        Повар готовит заказ и возвращает блюдо.
//        Повар будит официанта, передает ему блюдо,
//        официант передает блюдо клиенту
public class Top100 {


    public static void main(String[] args) throws IOException {
        // выполнить подсчет топ 100 слов параллельно

        // количество потоков должно
        // быть равно числу доступных процессоров системы
        // Runtime.getRuntime().availableProcessors();

        ClassLoader loader = MapHomework.class.getClassLoader();
        File file = new File(loader.getResource("file.txt").getFile());
        List<String> lines = Files.readAllLines(file.toPath());

        List<String> words = new ArrayList<>();

        for (String line: lines){
            String[] wordSplit = line.toLowerCase() // приведение к нижнему регистру
                    .replaceAll("\\p{Punct}", " ") // знаки препинания на пробел
                    .trim() // убираем пробелы
                    .split("\\s");
            for (String s: wordSplit){
                if (s.length() > 0) {
                    words.add(s.trim());
                }
            }
        }

        HashMap<String, Integer> map = new HashMap<>();
        int threadCount = Runtime.getRuntime().availableProcessors();
        int wordSize = words.size();

    }
}

class WordCounter implements Runnable {

    HashMap<String, Integer> localMap = new HashMap<>();
    HashMap<String, Integer> map;
    List<String> words;

    public WordCounter(HashMap<String, Integer> map, List<String> words) {
        this.map = map;
        this.words = words;
    }

    @Override
    public void run() {
        for (String word: words) {
            if (localMap.containsKey(word)){
                localMap.put(word, localMap.get(word)+1);
            } else {
                localMap.put(word, 1);
            }
        }

        synchronized (map) {
            for (Map.Entry<String, Integer> entry: localMap.entrySet()) {
                String  key = entry.getKey();
                if(map.containsKey(key)) {
                    map.put(key, map.get(key) + entry.getValue());
                } else {
                    map.put(key, entry.getValue());
                }
            }
        }
    }
}
