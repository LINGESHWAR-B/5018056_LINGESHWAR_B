import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        stockMarket.setStockPrice(100);
        stockMarket.setStockPrice(150);
    }

    interface Stock {
        void register(Observer o);
        void deregister(Observer o);
        void notifyObservers();
    }

    static class StockMarket implements Stock {
        private final List<Observer> observers;
        private int stockPrice;

        public StockMarket() {
            observers = new ArrayList<>();
        }

        @Override
        public void register(Observer o) {
            observers.add(o);
        }

        @Override
        public void deregister(Observer o) {
            observers.remove(o);
        }

        @Override
        public void notifyObservers() {
            for (Observer o : observers) {
                o.update(stockPrice);
            }
        }

        public void setStockPrice(int newPrice) {
            this.stockPrice = newPrice;
            notifyObservers();
        }
    }

    interface Observer {
        void update(int stockPrice);
    }

    static class MobileApp implements Observer {
        @Override
        public void update(int stockPrice) {
            System.out.println("MobileApp: Stock price updated to " + stockPrice);
        }
    }

    static class WebApp implements Observer {
        @Override
        public void update(int stockPrice) {
            System.out.println("WebApp: Stock price updated to " + stockPrice);
        }
    }
}
