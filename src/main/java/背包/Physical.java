package 背包;

import java.util.HashSet;
import java.util.Set;

public class Physical {
    private int cpu;
    private int mem;
    private Set<Virtual> virtuals=new HashSet<>();

    public Physical(int cpu, int mem) {
        this.cpu = cpu;
        this.mem = mem;
    }

    public int getCpu() {
        return cpu;
    }

    public int getMem() {
        return mem;
    }
    public void add(Virtual virtual){
        virtuals.add(virtual);
    }

    public Set<Virtual> getVirtuals() {
        return virtuals;
    }

    public void setVirtuals(Set<Virtual> virtuals) {
        this.virtuals = virtuals;
    }

    @Override
    public String toString() {
        return "Physical{" +
                "virtuals=" + virtuals +
                '}';
    }
}
