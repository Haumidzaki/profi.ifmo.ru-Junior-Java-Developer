package lesson6;

public class SomeClass {

    private static final SomeClass obj = new  SomeClass();

    private SomeClass(){ }

    static SomeClass getObj(){

        return obj;
    }

    public void ptintInfo(String string){
        System.out.println("info" + string);
    }
}


class SomeClass2 {
    public void someVoid(){
        SomeClass someClass = SomeClass.getObj();// new SomeClass();
        SomeClass someClass2 = SomeClass.getObj();// new SomeClass();
        SomeClass someClass3 = SomeClass.getObj();// new SomeClass();

        someClass.ptintInfo("data");
    }
}