package Model;

public class Model {
    private static Model instance = null;

    public static Model getInstance(){
        if (instance == null) {
            instance = new Model();
            instance.init();
        }
        return instance;
    }
    private void init(){

    }
    public void shutDown(){

    }
}
