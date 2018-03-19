package Model;

import java.sql.Date;
import java.sql.Timestamp;

public class Account {

    private int account_id;
    private int customer_id;
    private String billing_address;
    private boolean is_active;
    private Date opening_date;

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getBilling_address() {
        return billing_address;
    }

    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Date getOpening_date() {
        return opening_date;
    }

    public void setOpening_date(Date opening_date) {
        this.opening_date = opening_date;
    }


    public static final class AccountBuilder {
        private int account_id;
        private int customer_id;
        private String billing_address;
        private boolean is_active;
        private Date opening_date;

        private AccountBuilder() {
        }

        public static AccountBuilder anAccount() {
            return new AccountBuilder();
        }

        public AccountBuilder setAccount_id(int account_id) {
            this.account_id = account_id;
            return this;
        }

        public AccountBuilder setCustomer_id(int customer_id) {
            this.customer_id = customer_id;
            return this;
        }

        public AccountBuilder setBilling_address(String billing_address) {
            this.billing_address = billing_address;
            return this;
        }

        public AccountBuilder setIs_active(boolean is_active) {
            this.is_active = is_active;
            return this;
        }

        public AccountBuilder setOpening_date(Date opening_date) {
            this.opening_date = opening_date;
            return this;
        }

        public Account build() {
            Account account = new Account();
            account.setAccount_id(account_id);
            account.setCustomer_id(customer_id);
            account.setBilling_address(billing_address);
            account.setIs_active(is_active);
            account.setOpening_date(opening_date);
            return account;
        }
    }
}
