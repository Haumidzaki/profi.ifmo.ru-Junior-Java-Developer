package lesson6.staticFinal;

public interface Handler {
    public void read();
    public void write();

    public static Handler getInstance(String fileName){
        Handler handler = null;

        if (fileName.endsWith(".xml")) {
            handler = new XMLHandler();
        } else if (fileName.endsWith(".json")) {
            handler = new JSONHandler();
        }

        return handler;
    }
}

class XMLHandler implements Handler{

    @Override
    public void read() {
        System.out.println("read XML");
    }

    @Override
    public void write() {
        System.out.println("write XML");
    }
}

class JSONHandler implements Handler{

    @Override
    public void read() {
        System.out.println("read JSON");
    }

    @Override
    public void write() {
        System.out.println("write JSON");
    }
}
