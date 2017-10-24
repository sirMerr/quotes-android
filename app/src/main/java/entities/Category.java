package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sirMerr on 2017-10-24.
 */

public class Category {
    private String title;
    private String blurb;
    private String image;
    private List<Quote> quotes;

    public Category() {
        this("","","",new ArrayList<Quote>());
    }

    public Category(String title, String blurb, String image, List<Quote> quotes) {
        this.title = title;
        this.blurb = blurb;
        this.image = image;
        this.quotes = quotes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
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
        if (getBlurb() != null ? !getBlurb().equals(category.getBlurb()) : category.getBlurb() != null)
            return false;
        if (getImage() != null ? !getImage().equals(category.getImage()) : category.getImage() != null)
            return false;
        return getQuotes() != null ? getQuotes().equals(category.getQuotes()) : category.getQuotes() == null;

    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getBlurb() != null ? getBlurb().hashCode() : 0);
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        result = 31 * result + (getQuotes() != null ? getQuotes().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "title='" + title + '\'' +
                ", blurb='" + blurb + '\'' +
                ", image='" + image + '\'' +
                ", quotes=" + quotes +
                '}';
    }
}
