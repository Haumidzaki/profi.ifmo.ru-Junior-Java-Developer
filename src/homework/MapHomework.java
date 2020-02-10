package homework;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class MapHomework {
    public static void main(String[] args) throws IOException {

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

//        Сосчитать частоту встречаемости слов в War and peace (файл wp.txt).
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word: words) {
            if (wordMap.containsKey(word)){
                wordMap.put(word, wordMap.get(word)+1);
            } else {
                wordMap.put(word, 1);
            }
        }
        System.out.println(wordMap);

//        Собрать все слова в группы по количеству букв:
//        например, в одну группу попадут слова:
//        [the, war, jar, get, met...], в другую [on, up, no, of...].

        HashMap<Integer, HashSet<String>> groupMap = new HashMap<>();
        for (String word: words) {
            int len = word.length();
            if (!groupMap.containsKey(len)){
                groupMap.put(len, new HashSet<>());
            }
            groupMap.get(len).add(word);
        }

        // Вывести топ 10 самых частых слов и фраз.
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordMap.entrySet());
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
               return  Integer.compare(o1.getValue(), o2.getValue());
            }
        });
    }
}
