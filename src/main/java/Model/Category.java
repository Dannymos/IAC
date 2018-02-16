package Model;

public class Category {

    private int id;

    private String name;

    private String description;

    private String picture;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Category{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }

    public static final class CategoryBuilder {
        private int id;
        private String name;
        private String description;
        private String picture;

        private CategoryBuilder() {
        }

        public static CategoryBuilder aCategory() {
            return new CategoryBuilder();
        }

        public CategoryBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public CategoryBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CategoryBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public CategoryBuilder setPicture(String picture) {
            this.picture = picture;
            return this;
        }

        public Category build() {
            Category category = new Category();
            category.setId(id);
            category.setName(name);
            category.setDescription(description);
            category.setPicture(picture);
            return category;
        }

    }
}
