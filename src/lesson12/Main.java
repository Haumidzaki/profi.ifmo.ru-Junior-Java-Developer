package lesson12;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*File statFile = new File("stat.bin");
        LaunchStat launchStat = null;
        if (!statFile.exists()) {
            // если первый запуск
            launchStat = new LaunchStat();
        } else {
            // если не первый запуск, читаем из файла
            try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(statFile))){
                launchStat = (LaunchStat) objIn.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (launchStat.isFirstLaunch()){
            System.out.println("Первый запуск");
        } else {
            System.out.println(launchStat);
        }

        launchStat.update();
        // запись объекта
        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(statFile))){
            objOut.writeObject(launchStat);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        File file = new File("stat2.bin");
        LaunchStatExternalizable stat;

        if (!file.exists()) {
            stat = new LaunchStatExternalizable();
        } else {
            try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(file)
            )) {
                stat = (LaunchStatExternalizable) ois.readObject();
            }
        }

        if (stat.isFirstLaunch()) {
            System.out.println("Первый запуск");
        } else {
            System.out.println(stat.toString());
        }

        stat.update();

        try (ObjectOutputStream oouts = new ObjectOutputStream(
                new FileOutputStream(file)
        )) {
            oouts.writeObject(stat);
        }
    }
}
