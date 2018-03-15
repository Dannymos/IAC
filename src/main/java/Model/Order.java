package Model;


import java.util.ArrayList;

public class Order {

    private int id;
    private int customer_id;
    private String status;
    private String deliveryAddress;
    private ArrayList<OrderRule> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public ArrayList<OrderRule> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderRule> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer_id=" + customer_id +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", id=" + id +
                ", items=" + items +
                ", status='" + status + '\'' +
                '}';
    }

    public static final class OrderBuilder {
        private int id;
        private int customer_id;
        private String status;
        private String deliveryAddress;
        private ArrayList<OrderRule> items;

        private OrderBuilder() {
        }

        public static OrderBuilder anOrder() {
            return new OrderBuilder();
        }

        public OrderBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public OrderBuilder setCustomer_id(int customer_id) {
            this.customer_id = customer_id;
            return this;
        }

        public OrderBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public OrderBuilder setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public OrderBuilder setItems(ArrayList<OrderRule> items) {
            this.items = items;
            return this;
        }

        public Order build() {
            Order order = new Order();
            order.setId(id);
            order.setCustomer_id(customer_id);
            order.setStatus(status);
            order.setDeliveryAddress(deliveryAddress);
            order.setItems(items);
            return order;
        }
    }
}

