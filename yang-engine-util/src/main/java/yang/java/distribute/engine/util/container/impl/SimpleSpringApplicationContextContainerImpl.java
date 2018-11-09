package yang.java.distribute.engine.util.container.impl;

import org.springframework.context.ApplicationContext;
import yang.java.distribute.engine.util.ApplicationContextProcessingUnitContainer;

public class SimpleSpringApplicationContextContainerImpl implements ApplicationContextProcessingUnitContainer {

    private ApplicationContext applicationContext;
    private ClassLoader classLoader;

    public SimpleSpringApplicationContextContainerImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return this.applicationContext;
    }

    public void stop() {

    }

    public ClassLoader getClassLoader() {
        return this.classLoader;
    }
}
