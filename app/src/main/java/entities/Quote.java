package entities;

import java.util.Date;

/**
 * Created by sirMerr on 2017-10-24.
 */

public class Quote {
    private Author author = new Author();
    private String dateAdded = "";
    private String fullQuote = "";
    private String shortQuote = "";
    private String url = "";

    public Quote() {
    }

    public Quote(Author author, String dateAdded, String fullQuote, String shortQuote, String url) {
        this.author = author;
        this.dateAdded = dateAdded;
        this.fullQuote = fullQuote;
        this.shortQuote = shortQuote;
        this.url = url;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getFullQuote() {
        return fullQuote;
    }

    public void setFullQuote(String fullQuote) {
        this.fullQuote = fullQuote;
    }

    public String getShortQuote() {
        return shortQuote;
    }

    public void setShortQuote(String shortQuote) {
        this.shortQuote = shortQuote;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quote)) return false;

        Quote quote = (Quote) o;

        if (getAuthor() != null ? !getAuthor().equals(quote.getAuthor()) : quote.getAuthor() != null)
            return false;
        if (getDateAdded() != null ? !getDateAdded().equals(quote.getDateAdded()) : quote.getDateAdded() != null)
            return false;
        if (getFullQuote() != null ? !getFullQuote().equals(quote.getFullQuote()) : quote.getFullQuote() != null)
            return false;
        if (getShortQuote() != null ? !getShortQuote().equals(quote.getShortQuote()) : quote.getShortQuote() != null)
            return false;
        return getUrl() != null ? getUrl().equals(quote.getUrl()) : quote.getUrl() == null;

    }

    @Override
    public int hashCode() {
        int result = getAuthor() != null ? getAuthor().hashCode() : 0;
        result = 31 * result + (getDateAdded() != null ? getDateAdded().hashCode() : 0);
        result = 31 * result + (getFullQuote() != null ? getFullQuote().hashCode() : 0);
        result = 31 * result + (getShortQuote() != null ? getShortQuote().hashCode() : 0);
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "author='" + author + '\'' +
                ", dateAdded=" + dateAdded +
                ", fullQuote='" + fullQuote + '\'' +
                ", shortQuote='" + shortQuote + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
