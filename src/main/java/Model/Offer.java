package Model;

import java.sql.Timestamp;

public class Offer {

    private int offer_id;
    private int product_id;
    private Timestamp start_date;
    private Timestamp end_date;
    private float reduction;

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public Timestamp getStart_date() {
        return start_date;
    }

    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }

    public Timestamp getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Timestamp end_date) {
        this.end_date = end_date;
    }

    public float getReduction() {
        return reduction;
    }

    public void setReduction(float reduction) {
        this.reduction = reduction;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "end_date=" + end_date +
                ", offer_id=" + offer_id +
                ", product_id=" + product_id +
                ", reduction=" + reduction +
                ", start_date=" + start_date +
                '}';
    }

    public static final class OfferBuilder {
        private int offer_id;
        private int product_id;
        private Timestamp start_date;
        private Timestamp end_date;
        private float reduction;

        private OfferBuilder() {
        }

        public static OfferBuilder anOffer() {
            return new OfferBuilder();
        }

        public OfferBuilder setOffer_id(int offer_id) {
            this.offer_id = offer_id;
            return this;
        }

        public OfferBuilder setProduct_id(int product_id) {
            this.product_id = product_id;
            return this;
        }

        public OfferBuilder setStart_date(Timestamp start_date) {
            this.start_date = start_date;
            return this;
        }

        public OfferBuilder setEnd_date(Timestamp end_date) {
            this.end_date = end_date;
            return this;
        }

        public OfferBuilder setReduction(float reduction) {
            this.reduction = reduction;
            return this;
        }

        public Offer build() {
            Offer offer = new Offer();
            offer.setOffer_id(offer_id);
            offer.setProduct_id(product_id);
            offer.setStart_date(start_date);
            offer.setEnd_date(end_date);
            offer.setReduction(reduction);
            return offer;
        }
    }
}
