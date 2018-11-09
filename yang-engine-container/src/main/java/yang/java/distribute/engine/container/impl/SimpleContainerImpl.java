package yang.java.distribute.engine.container.impl;

import yang.java.distribute.engine.container.Container;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleContainerImpl implements Container {

    private AtomicInteger avaliableSlots;
    private int maxSlots;
    private String name;

    public SimpleContainerImpl(int maxSlots, String name) {
        this.maxSlots = maxSlots;
        this.name = name;
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
