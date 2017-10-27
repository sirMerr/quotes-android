package entities;

/**
 * Created by sirMerr on 2017-10-27.
 */

public class Author {
    private String name = "";
    private String birthdate = "";

    public Author() {
    }

    public Author(String name, String birthdate) {
        this.name = name;
        this.birthdate = birthdate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;

        Author author = (Author) o;

        if (getName() != null ? !getName().equals(author.getName()) : author.getName() != null)
            return false;
        return getBirthdate() != null ? getBirthdate().equals(author.getBirthdate()) : author.getBirthdate() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getBirthdate() != null ? getBirthdate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birthdate='" + birthdate + '\'' +
                '}';
    }
}
