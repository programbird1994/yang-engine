package yang.java.distribute.engine.util;

import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class IsolatedSpringConatinerImpl implements IsolatedClassloaderContainer {

    private String springContextFullClassName;
    private ApplicationContext context;
    private List<String> locations = new ArrayList<String>(10);

    public void setConfigLocations(String... locations) {
        this.locations.clear();
        for (String location : locations) {
            this.locations.add(location);
        }
    }

    public void setClassLoader(ClassLoader classLoader) throws Exception {
        Class<? extends ApplicationContext> clazz = (Class<? extends ApplicationContext>) classLoader.loadClass(springContextFullClassName);
        ApplicationContext applicationContext = clazz.newInstance();
        Method method = clazz.getMethod("setConfigLocation", String.class);
        Method method3 = clazz.getMethod("setClassLoader", ClassLoader.class);
        Method method2 = clazz.getMethod("refresh");
        method3.invoke(applicationContext, classLoader);
        method.invoke(applicationContext, locations.get(0));
        method2.invoke(applicationContext);
        this.context = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return context;
    }

    public void setSpringContextFullClassName(String springContextFullClassName) {
        this.springContextFullClassName = springContextFullClassName;
    }
}
