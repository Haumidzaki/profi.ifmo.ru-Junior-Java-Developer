package fitness;

@AccessMode
public class FullDayClient extends Human{
    private Access group = new Access(8, 22, FitnessServiceEnumeration.GROUP);
    private Access gym = new Access(8, 22, FitnessServiceEnumeration.GYM);
    private Access pool = new Access(8, 22, FitnessServiceEnumeration.POOL);

    public FullDayClient(String name, String surname, int bYear, String regDate) {
        super(name, surname, bYear, regDate);
    }

    public FullDayClient(String name, String surname, int bYear) {
        super(name, surname, bYear);
    }
}
