package Model;

public class ProdCats {

    private int id;
    private int category;
    private int product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }



    @Override
    public String toString() {
        return "ProdCats{" +
                "category=" + category +
                ", id=" + id +
                ", product=" + product +
                '}';
    }

    public static final class ProdCatsBuilder {
        private int id;
        private int category;
        private int product;

        private ProdCatsBuilder() {
        }

        public static ProdCatsBuilder aProdCats() {
            return new ProdCatsBuilder();
        }

        public ProdCatsBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public ProdCatsBuilder setCategory(int category) {
            this.category = category;
            return this;
        }

        public ProdCatsBuilder setProduct(int product) {
            this.product = product;
            return this;
        }

        public ProdCats build() {
            ProdCats prodCats = new ProdCats();
            prodCats.setId(id);
            prodCats.setCategory(category);
            prodCats.setProduct(product);
            return prodCats;
        }
    }

}

