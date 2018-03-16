package Model;

public class Product {

    private int id;

    private String name;
    private double price;
    private String explanation;
    private String image;
    private Offer offer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "explanation='" + explanation + '\'' +
                ", id=" + id +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", offer=" + offer +
                ", price=" + price +
                '}';
    }

    public static final class ProductBuilder {
        private int id;
        private String name;
        private double price;
        private String explanation;
        private String image;
        private Offer offer;

        private ProductBuilder() {
        }

        public static ProductBuilder aProduct() {
            return new ProductBuilder();
        }

        public ProductBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setPrice(double price) {
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

        public ProductBuilder setOffer(Offer offer) {
            this.offer = offer;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.setId(id);
            product.setName(name);
            product.setPrice(price);
            product.setExplanation(explanation);
            product.setImage(image);
            product.setOffer(offer);
            return product;
        }
    }
}
