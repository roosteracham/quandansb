package 背包;

public class Virtual {
    private String name;
    private int cpu;
    private int mem;
    private int num;
    private Virtual pre;

    public Virtual(String name, int cpu, int mem) {
        this.name = name;
        this.cpu = cpu;
        this.mem = mem;
        this.num = 1;
    }

    public Virtual(String name, int cpu, int mem, int num) {
        this.name = name;
        this.cpu = cpu;
        this.mem = mem;
        this.num = num;
    }

    public void minus(int num) {
        if (this.num >= num) this.num -= num;
    }

    public boolean isEmpty() {
        return this.num <= 0;
    }

    public String getName() {
        return name;
    }

    public int getCpu() {
        return cpu;
    }

    public int getMem() {
        return mem;
    }

    public int getNum() {
        return num;
    }

    public int getValue(boolean cpuOrMem) {
        return cpuOrMem ? getCpu() : getMem();
    }

    public Virtual getPre() {
        return pre;
    }

    public void setPre(Virtual pre) {
        this.pre = pre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Virtual virtual = (Virtual) o;

        return name.equals(virtual.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Virtual{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
