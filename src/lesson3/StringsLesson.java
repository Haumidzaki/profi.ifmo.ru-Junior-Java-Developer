package lesson3;

public class StringsLesson {
    public static void main(String[] args) {
        String string = "Строка";
        String string2 = "Строка";
        String string3 = new String("Строка");
        string3 = string3.intern(); // добавит строку в пул строк

        System.out.println(string == string2); // true
        System.out.println(string == string3); // true

        // сравнение строк
        System.out.println(string.equals(string2));

        // сравнение строк без учета регистра
        System.out.println(string.equalsIgnoreCase(string2));

        System.out.println(string.startsWith("Ст"));
        System.out.println(string.endsWith("a"));

        String string4 = "Начало ";

        for (int i = 0; i < 3; i++) {
            string4 += "итерация цикла ";
        }
        System.out.println(string4);

//        StringBuffer | StringBuilder
        string4 = "Начало ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string4);
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(" итерация цикла ")
                    .append(i)
                    .append(" ");
        }
        string4 = stringBuilder.toString();
        System.out.println(string4);


































    }
}
