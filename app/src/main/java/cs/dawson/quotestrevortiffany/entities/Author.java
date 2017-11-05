package cs.dawson.quotestrevortiffany.entities;

/**
 * Author relates to the author of a quote. They have
 * a birth date, a name, and a blurb, which is a small summary of who they are
 *
 * Created by sirMerr on 2017-10-27.
 */

public class Author {
    private String name = "";
    private String birthdate = "";
    private String blurb = "";

    public Author() {
    }

    public Author(String name, String birthdate, String blurb) {
        this.name = name;
        this.birthdate = birthdate;
        this.blurb = blurb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;

        Author author = (Author) o;

        if (getName() != null ? !getName().equals(author.getName()) : author.getName() != null)
            return false;
        if (getBirthdate() != null ? !getBirthdate().equals(author.getBirthdate()) : author.getBirthdate() != null)
            return false;
        return getBlurb() != null ? getBlurb().equals(author.getBlurb()) : author.getBlurb() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getBirthdate() != null ? getBirthdate().hashCode() : 0);
        result = 31 * result + (getBlurb() != null ? getBlurb().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", blurb='" + blurb + '\'' +
                '}';
    }
}
