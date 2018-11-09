package yang.java.distribute.engine.util;

import org.springframework.context.ApplicationContext;

public interface ApplicationContextProcessingUnitContainer extends ProcessingUnitContainer {

    ApplicationContext getApplicationContext();
}
