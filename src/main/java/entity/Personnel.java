package entity;

import java.util.Objects;

public class Personnel {
    private String name;
    private String familyName;
    private String nationalCode;
    private long id;

    public Personnel(String name, String familyName, String nationalCode) {
        this.name = name;
        this.familyName = familyName;
        this.nationalCode = nationalCode;
    }

    public Personnel(String name, String familyName, String nationalCode, long id) {
        this.name = name;
        this.familyName = familyName;
        this.nationalCode = nationalCode;
        this.id = id;
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

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personnel personnel = (Personnel) o;
        return Objects.equals(nationalCode, personnel.nationalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationalCode);
    }
}
