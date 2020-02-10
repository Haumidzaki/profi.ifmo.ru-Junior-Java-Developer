package lesson12;

import java.io.Serializable;
import java.util.Date;

public class LaunchStat implements Serializable { // NotSerializableException
    private int launchCount;
    private Date lastLaunch;

    public boolean isFirstLaunch(){
        return launchCount == 0 && lastLaunch == null;
    }

    public void update(){
        launchCount++;
        lastLaunch = new Date();
    }

    @Override
    public String toString() {
        return "LaunchStat{" +
                "launchCount=" + launchCount +
                ", lastLaunch=" + lastLaunch +
                '}';
    }
}
