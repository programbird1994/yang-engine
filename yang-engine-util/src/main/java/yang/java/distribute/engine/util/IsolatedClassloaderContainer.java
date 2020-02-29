package yang.java.distribute.engine.util;

public interface IsolatedClassloaderContainer {

    void setClassLoader(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException, Exception;

}
