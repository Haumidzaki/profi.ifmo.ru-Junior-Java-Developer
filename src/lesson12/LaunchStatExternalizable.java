package lesson12;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class LaunchStatExternalizable implements Externalizable {
    private static final long serialVersionUID = 0L;
    private static final int VERSION = 0; // изменили версию с 0 на 1


    private int launchCount;
    private Date lastLaunch;

//    private String user;  // добавили user

    public void update() {
        launchCount++;
        lastLaunch = new Date();
//        user = System.getProperty("user.name"); // добавили user
    }

    public boolean isFirstLaunch() {
        return launchCount == 0 && lastLaunch == null;
    }

    @Override
    public String toString() {
        return "LaunchStat{" +
                "launchCount=" + launchCount + "\n" +
                ", lastLaunch=" + lastLaunch + "\n" +
//                ", user=" + user + "\n" + // добавили user
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt( VERSION );
        out.writeInt(launchCount);
        out.writeObject(lastLaunch);
//        out.writeUTF(user); // добавили user
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int version = in.readInt();
        if (version > VERSION )
            throw new IOException("Версие не подерживается: " + version);
        launchCount = in.readInt();
        lastLaunch = (Date) in.readObject();
//        if (version > 0) {
//            user = in.readUTF(); // добавили user
//        }
    }

}
