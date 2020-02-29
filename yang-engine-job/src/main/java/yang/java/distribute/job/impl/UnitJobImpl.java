package yang.java.distribute.job.impl;

import yang.java.distribute.job.UnitJob;

public class UnitJobImpl implements UnitJob {
    public void compute() throws Exception {
        System.out.println("Simple unit job 1 computes!");
    }
}
