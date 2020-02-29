package yang.java.distribute.engine.util;

import yang.java.distribute.job.UnitJob;

public class App {

    public static void main(String[] args) throws Exception {
        IsolatedSpringConatinerImpl isolatedClassloaderContainer = new IsolatedSpringConatinerImpl();
        String location = "F:\\JavaProjects\\yang-engine\\yang-engine-job\\target\\yang-engine-job-1.0-SNAPSHOT-jar-with-dependencies.jar";
        ClassLoader classLoader = JobLibraryProvider.provideClassLoader(location);
        isolatedClassloaderContainer.setConfigLocations("classpath:/a.xml");
        isolatedClassloaderContainer.setSpringContextFullClassName("org.springframework.context.support.ClassPathXmlApplicationContext");
        isolatedClassloaderContainer.setClassLoader(classLoader);
        UnitJob a = isolatedClassloaderContainer.getApplicationContext().getBean("a", UnitJob.class);
        a.compute();
    }
}
