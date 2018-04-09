package test.enumsome;

public enum she implements Runnable{
    NO("no enum"),
    YES("yes enum");

    private String description;

    private she(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (she s : she.values()) {
            System.out.println(s + " " + s.getDescription());
        }
    }

    @Override
    public void run() {
        for (she s : she.values()) {
            System.out.println(s);
        }
    }
}
