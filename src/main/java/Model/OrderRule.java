package Model;

public class OrderRule {

    private int id;
    private int order_id;
    private Product product;
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderRule{" +
                "amount=" + amount +
                ", id=" + id +
                ", order_id=" + order_id +
                ", product=" + product +
                '}';
    }

    public static final class OrderRuleBuilder {
        private int id;
        private int order_id;
        private Product product;
        private int amount;

        private OrderRuleBuilder() {
        }

        public static OrderRuleBuilder anOrderRule() {
            return new OrderRuleBuilder();
        }

        public OrderRuleBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public OrderRuleBuilder setOrder_id(int order_id) {
            this.order_id = order_id;
            return this;
        }

        public OrderRuleBuilder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public OrderRuleBuilder setAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public OrderRule build() {
            OrderRule orderRule = new OrderRule();
            orderRule.setId(id);
            orderRule.setOrder_id(order_id);
            orderRule.setAmount(amount);
            orderRule.product = this.product;
            return orderRule;
        }
    }
}
