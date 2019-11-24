package itbzqq.zoocatalogue;


public class Animal implements Comparable<Animal> {
    private long id;
    private String name;
    private String species;
    private String countryOfOrigin;
    private boolean isBorrowed;
    private String nutrition;
    private String medicalPrescript;

    public Animal() {
    }

    public Animal(long id, String name, String species, String countryOfOrigin, boolean isBorrowed, String nutrition, String medicalPrescript) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.countryOfOrigin = countryOfOrigin;
        this.isBorrowed = isBorrowed;
        this.nutrition = nutrition;
        this.medicalPrescript = medicalPrescript;
    }

    public long getId() {
        return id;
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

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public String getMedicalPrescript() {
        return medicalPrescript;
    }

    public void setMedicalPrescript(String medicalPrescript) {
        this.medicalPrescript = medicalPrescript;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("id=").append(id);
        sb.append(", name='").append(name);
        sb.append(", species='").append(species);
        sb.append(", countryOfOrigin='").append(countryOfOrigin);
        sb.append(", isBorrowed=").append(isBorrowed);
        sb.append(", nutrition='").append(nutrition);
        sb.append(", medicalPrescript='").append(medicalPrescript);
       // sb.append("\n");
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
