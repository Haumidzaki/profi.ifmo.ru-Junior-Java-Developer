package fitness;

import java.util.Date;

@AccessMode(group = "0")
public class Client extends Human{

    private boolean isVisited = false;
    private Access gym = new Access(8, 22, FitnessServiceEnumeration.GYM);
    private Access pool = new Access(8, 22, FitnessServiceEnumeration.POOL);

    public Client(String name, String surname, int bYear, String regDate) {
        super(name, surname, bYear, regDate);
    }

    public Client(String name, String surname, int bYear) {
        super(name, surname, bYear);
    }

    public Access getGym() {
        return gym;
    }

    public void setGym(Access gym) {
        this.gym = gym;
    }

    public Access getPool() {
        return pool;
    }

    public void setPool(Access pool) {
        this.pool = pool;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }


    public static void main(String[] args) {

    }
}
