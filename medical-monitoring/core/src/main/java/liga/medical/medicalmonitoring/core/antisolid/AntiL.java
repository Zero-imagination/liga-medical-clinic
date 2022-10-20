package liga.medical.medicalmonitoring.core.antisolid;

public class AntiL {
    public static class Bird {
        public void fly() {
            System.out.println("Fly");
        }

        public void eat() {
            System.out.println("Eat");
        }
    }

    public static class Sparrow extends Bird {
        @Override
        public void fly() {
            System.out.println("The sparrow is flying");
        }

        @Override
        public void eat() {
            System.out.println("The sparrow is eating");
        }
    }

    public static class Penguin extends Bird {
        @Override
        public void fly() {
            throw new RuntimeException("Penguins can't fly");
        }

        @Override
        public void eat() {
            System.out.println("The penguin is eating");
        }
    }

}
