package yang.java.distribute.engine.container.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yang.java.distribute.engine.container.Container;

public class SimpleContainerImpl implements Container {

    @Autowired
    private Holder holder;

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public Holder getHolder() {
        return holder;
    }

    public String getName() {
        return null;
    }

    public int getAvaliableSlots() {
        return 0;
    }

    public int getMaxSlots() {
        return 0;
    }



}


