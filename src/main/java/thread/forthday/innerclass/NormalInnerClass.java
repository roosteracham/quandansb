package thread.forthday.innerclass;

public class NormalInnerClass {
    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        OutClass.InnerClass innerClass = new OutClass.InnerClass();
    }
}

class OutClass {
    private String name;

    static class InnerClass {
        private String pwd;

        public void print() {
            System.out.println(this.pwd);
        }
        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }
    }
}