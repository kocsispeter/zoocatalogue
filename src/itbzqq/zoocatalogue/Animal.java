package itbzqq.zoocatalogue;

public class Animal implements Comparable<Animal> {
    private long id;
    private String name;
    private String species;
    private String countryOfOrigin;
    private boolean isBorrowed;

    public Animal() {
    }

    public long getId() {
        return System.currentTimeMillis();
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append("id =").append(id);
        sb.append(", name ='").append(name).append('\'');
        sb.append(", species ='").append(species).append('\'');
        sb.append(", country of origin ='").append(countryOfOrigin).append('\'');
        sb.append(", was it borrowed =").append(isBorrowed);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Animal o) {
        if (getName() == null || o.getName() == null) {
            return 0;
        }
        return getName().compareTo(o.getName());
    }
}
