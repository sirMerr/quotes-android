package cs.dawson.quotestrevortiffany.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sirMerr on 2017-10-24.
 */

public class Category {
    private String title = "";
    private String image = "";
    private List<Quote> quotes = new ArrayList<>();

    public Category() {
    }

    public Category(String title, String image, List<Quote> quotes) {
        this.title = title;
        this.image = image;
        this.quotes = quotes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (getTitle() != null ? !getTitle().equals(category.getTitle()) : category.getTitle() != null)
            return false;
        if (getImage() != null ? !getImage().equals(category.getImage()) : category.getImage() != null)
            return false;
        return getQuotes() != null ? getQuotes().equals(category.getQuotes()) : category.getQuotes() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        result = 31 * result + (getQuotes() != null ? getQuotes().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", quotes=" + quotes +
                '}';
    }
}
