package Model;

public class AddressInfo {
    private int address_id;
    private int customer_id;
    private String street;
    private String housenumber;
    private String city;
    private String country;
    private String postalcode;

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }


    public static final class AddressInfoBuilder {
        private int address_id;
        private int customer_id;
        private String street;
        private String housenumber;
        private String city;
        private String country;
        private String postalcode;

        private AddressInfoBuilder() {
        }

        public static AddressInfoBuilder anAddressInfo() {
            return new AddressInfoBuilder();
        }

        public AddressInfoBuilder setAddress_id(int address_id) {
            this.address_id = address_id;
            return this;
        }

        public AddressInfoBuilder setCustomer_id(int customer_id) {
            this.customer_id = customer_id;
            return this;
        }

        public AddressInfoBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressInfoBuilder setHousenumber(String housenumber) {
            this.housenumber = housenumber;
            return this;
        }

        public AddressInfoBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public AddressInfoBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public AddressInfoBuilder setPostalcode(String postalcode) {
            this.postalcode = postalcode;
            return this;
        }

        public AddressInfo build() {
            AddressInfo addressInfo = new AddressInfo();
            addressInfo.setAddress_id(address_id);
            addressInfo.setCustomer_id(customer_id);
            addressInfo.setStreet(street);
            addressInfo.setHousenumber(housenumber);
            addressInfo.setCity(city);
            addressInfo.setCountry(country);
            addressInfo.setPostalcode(postalcode);
            return addressInfo;
        }
    }
}
