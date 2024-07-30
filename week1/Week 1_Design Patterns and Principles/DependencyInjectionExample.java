public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        Customer customer = service.findCustomerById(1);
        System.out.println("Customer found: " + customer.getName());
    }

    interface CustomerRepository {
        Customer findCustomerById(int id);
    }

    static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public Customer findCustomerById(int id) {
            return new Customer(id, "John Doe");
        }
    }

    static class CustomerService {
        private final CustomerRepository repository;

        public CustomerService(CustomerRepository repository) {
            this.repository = repository;
        }

        public Customer findCustomerById(int id) {
            return repository.findCustomerById(id);
        }
    }

    static class Customer {
        private final int id;
        private final String name;

        public Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}