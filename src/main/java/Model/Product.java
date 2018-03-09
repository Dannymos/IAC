package Model;

public class Product {

    private int id;
    private int tax;
    private String name;
    private float price;
    private String explanation;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public static final class ProductBuilder {
        private int id;
        private int tax;
        private String name;
        private float price;
        private String explanation;
        private String image;

        private ProductBuilder() {
        }

        public static ProductBuilder aProduct() {
            return new ProductBuilder();
        }

        public ProductBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public ProductBuilder setTax(int tax) {
            this.tax = tax;
            return this;
        }

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setPrice(float price) {
            this.price = price;
            return this;
        }

        public ProductBuilder setExplanation(String explanation) {
            this.explanation = explanation;
            return this;
        }

        public ProductBuilder setImage(String image) {
            this.image = image;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.setId(id);
            product.setTax(tax);
            product.setName(name);
            product.setPrice(price);
            product.setExplanation(explanation);
            product.setImage(image);
            return product;
    }
    }
}
