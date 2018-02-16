package Model;

public class OrderRule {

    private int id;
    private int order_id;
    private int product_id;
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

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public static final class OrderRuleBuilder {
        private int id;
        private int order_id;
        private int product_id;
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

        public OrderRuleBuilder setProduct_id(int product_id) {
            this.product_id = product_id;
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
            orderRule.setProduct_id(product_id);
            orderRule.setAmount(amount);
            return orderRule;
        }
    }
}
