public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("Image1.jpg");
        Image image2 = new ProxyImage("Image2.jpg");

        image1.display();
        System.out.println();
        image1.display();
        System.out.println();
        image2.display();
        System.out.println();
        image2.display();
    }

    interface Image {
        void display();
    }

    static class RealImage implements Image {
        private final String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromRemoteServer();
        }

        private void loadFromRemoteServer() {
            System.out.println("Loading " + filename + " from remote server...");
        }

        @Override
        public void display() {
            System.out.println("Displaying " + filename);
        }
    }

    static class ProxyImage implements Image {
        private final String filename;
        private RealImage realImage;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename);
            }
            realImage.display();
        }
    }
}
