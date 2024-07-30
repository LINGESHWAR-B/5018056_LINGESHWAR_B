public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment();
        context.setPaymentStrategy(creditCardPayment);
        context.pay(100);

        PaymentStrategy paypalPayment = new PayPalPayment();
        context.setPaymentStrategy(paypalPayment);
        context.pay(200);
    }

    interface PaymentStrategy {
        void pay(int amount);
    }

    static class CreditCardPayment implements PaymentStrategy {
        @Override
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using Credit Card.");
        }
    }

    static class PayPalPayment implements PaymentStrategy {
        @Override
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using PayPal.");
        }
    }

    static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void pay(int amount) {
            paymentStrategy.pay(amount);
        }
    }
}
