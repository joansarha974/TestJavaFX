package entity;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 * Created by joanperny on 17/02/2014.
 */
public class Folder{

    private LongProperty id;
    private ObservableList<Gender> gender;
    private StringProperty folderNumber;
    private StringProperty name;
    private StringProperty surname;
    private StringProperty birthdayDate;
    private StringProperty address1;
    private StringProperty address2;
    private StringProperty district;
    private StringProperty postalCode;
    private StringProperty city;
    private StringProperty phone1;
    private StringProperty phone2;
    private StringProperty nationality;
    private StringProperty birthCountry;
    private StringProperty firstEntryFranceDate;
    private StringProperty maritalStatus;
    private StringProperty professionalStatus;
    private StringProperty remarks;
    private StringProperty created;
    private StringProperty lastModified;
    private ObservableList<Visit> visits;
    private Visit old;

    public Folder(){}

    public Folder(ObservableList<Visit> visits,String folderNumber,String name,String surname,String birthdayDate,ObservableList<Gender> gender,
                  String address1,String address2, String district, String postalCode, String city, String phone1,
                  String phone2,String nationality,String birthCountry,String firstEntryFranceDate,String maritalStatus,
                  String professionalStatus,String remarks,String created,String lastModified)
    {
        this.visits = visits;
        this.folderNumber = new SimpleStringProperty(folderNumber);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.birthdayDate = new SimpleStringProperty(birthdayDate);
        this.gender = gender;
        this.address1 = new SimpleStringProperty(address1);
        this.address2 = new SimpleStringProperty(address2);
        this.district = new SimpleStringProperty(district);
        this.postalCode = new SimpleStringProperty(postalCode);
        this.city = new SimpleStringProperty(city);
        this.phone1 = new SimpleStringProperty(phone1);
        this.phone2 = new SimpleStringProperty(phone2);
        this.nationality = new SimpleStringProperty(nationality);
        this.birthCountry = new SimpleStringProperty(birthCountry);
        this.firstEntryFranceDate = new SimpleStringProperty(firstEntryFranceDate);
        this.maritalStatus = new SimpleStringProperty(maritalStatus);
        this.professionalStatus = new SimpleStringProperty(professionalStatus);
        this.remarks = new SimpleStringProperty(remarks);
        this.created = new SimpleStringProperty(created);
        this.lastModified = new SimpleStringProperty(lastModified);
    }

    @Override
    public String toString()
    {
        return name + " "+ surname + " " + birthdayDate + " " + folderNumber;
    }

    public String nameSurname()
    {
        return name + " "+ surname;
    }

    public Long getId() {
        return id == null ? null : id.get();
    }

    public void setId(Long id) {
        this.id.set(id);
    }

    public ObservableList<Gender> getGender() {
        return gender;
    }

    public void setGender(ObservableList<Gender> gender) {
        this.gender = gender;
    }

    public String getAddress1() {
        return address1== null ? null :address1.get();
    }

    public void setAddress1(String address1) {
        this.address1.set(address1);
    }

    public StringProperty address1() {
        if(address1 == null)
            address1 = new SimpleStringProperty(this, "address1");
        return address1;
    }

    public String getAddress2() {
        return address2== null ? null :address2.get();
    }

    public void setAddress2(String address2) {
        this.address2.set(address2);
    }

    public StringProperty address2() {
        if(address2 == null)
            address2 = new SimpleStringProperty(this, "address2");
        return address2;
    }

    public String getDistrict() {
        return district== null ? null :district.get();
    }

    public void setDistrict(String district) {
        this.district.set(district);
    }

    public StringProperty district() {
        if(district == null)
            district = new SimpleStringProperty(this, "district");
        return district;
    }

    public String getPostalCode() {
        return postalCode== null ? null :postalCode.get();
    }

    public void setPostalCode(String postalCode) {
        this.postalCode.set(postalCode);
    }

    public StringProperty postalCode() {
        if(postalCode == null)
            postalCode = new SimpleStringProperty(this, "postalCode");
        return postalCode;
    }

    public String getCity() {
        return city== null ? null :city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty city() {
        if(city == null)
            city = new SimpleStringProperty(this, "city");
        return city;
    }

    public String getPhone1() {
        return phone1== null ? null :phone1.get();
    }

    public void setPhone1(String phone1) {
        this.phone1.set(phone1);
    }

    public StringProperty phone1() {
        if(phone1 == null)
            phone1 = new SimpleStringProperty(this, "phone1");
        return phone1;
    }

    public String getPhone2() {
        return phone2== null ? null :phone2.get();
    }

    public void setPhone2(String phone2) {
        this.phone2.set(phone2);
    }

    public StringProperty phone2() {
        if(phone2 == null)
            phone2 = new SimpleStringProperty(this, "phone2");
        return phone2;
    }

    public String getNationality() {
        return nationality== null ? null :nationality.get();
    }

    public void setNationality(String nationality) {
        this.nationality.set(nationality);
    }

    public StringProperty nationality() {
        if(nationality == null)
            nationality = new SimpleStringProperty(this, "Française");
        return nationality;
    }

    public String getBirthCountry() {
        return birthCountry== null ? null :birthCountry.get();
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry.set(birthCountry);
    }

    public StringProperty birthdayDate() {
        if(birthdayDate == null)
            birthdayDate = new SimpleStringProperty(this, "birthdayDate");
        return birthdayDate;
    }

    public String getMaritalStatus() {
        return maritalStatus== null ? null :maritalStatus.get();
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus.set(maritalStatus);
    }

    public StringProperty maritalStatus() {
        if(maritalStatus == null)
            maritalStatus = new SimpleStringProperty(this, "maritalStatus");
        return maritalStatus;
    }

    public String getFirstEntryFranceDate() {
        return firstEntryFranceDate== null ? null :firstEntryFranceDate.get();
    }

    public void setFirstEntryFranceDate(String firstEntryFranceDate) {
        this.firstEntryFranceDate.set(firstEntryFranceDate);
    }

    public StringProperty firstEntryFranceDate() {
        if(firstEntryFranceDate == null)
            firstEntryFranceDate = new SimpleStringProperty(this, "01-01-01");
        return firstEntryFranceDate;
    }

    public String getProfessionalStatus() {
        return professionalStatus== null ? null :professionalStatus.get();
    }

    public void setProfessionalStatus(String professionalStatus) {
        this.professionalStatus.set(professionalStatus);
    }

    public StringProperty profesionnalStatus() {
        if(professionalStatus == null)
            professionalStatus= new SimpleStringProperty(this, "professionnalStatus");
        return professionalStatus;
    }

    public String getRemarks() {
        return remarks== null ? null :remarks.get();
    }

    public void setRemarks(String remarks) {
        this.remarks.set(remarks);
    }

    public StringProperty remarks() {
        if(remarks == null)
            remarks = new SimpleStringProperty(this, "remarks");
        return remarks;
    }

    public String getCreated() {
        return created== null ? null :created.get();
    }

    public void setCreated(String created) {
        this.created.set(created);
    }

    public StringProperty created() {
        if(created== null)
            created= new SimpleStringProperty(this, "01-01-01");
        return created;
    }

    public String getLastModified() {
        return lastModified== null ? null :lastModified.get();
    }

    public void setLastModified(String lastModified) {
        this.lastModified.set(lastModified);
    }

    public StringProperty lastModified() {
        if(lastModified == null)
            lastModified = new SimpleStringProperty(this, "01-01-01");
        return lastModified;
    }

    public ObservableList<Visit> getVisits() {
        return visits;
    }

    public void setVisits(ObservableList<Visit> visits) {
        this.visits = visits;
    }
}
