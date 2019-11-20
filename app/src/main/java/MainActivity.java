public class MainActivity {
    public interface Playable{
        void move();
        void attack();
        void defense();
    }

    class Robot implements Playable{
        @Override
        public void attack() {
            System.out.println("shoot");
        }

        @Override
        public void defense() {
            System.out.println("block");
        }

        @Override
        public void move() {
            System.out.println("ride");
        }
    }

    class Wizard implements Playable{
        @Override
        public void attack() {
            System.out.println("magic shoot");
        }

        @Override
        public void defense() {
            System.out.println("magic block");
        }

        @Override
        public void move() {
            System.out.println("walk");
        }
    }
}
