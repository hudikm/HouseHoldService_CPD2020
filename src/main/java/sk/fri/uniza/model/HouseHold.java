package sk.fri.uniza.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Set;


public class HouseHold {
    @ApiModelProperty(hidden = true) // Swagger nebude zobrazovať atribút
    private Long id;
    @NotEmpty
    @ApiModelProperty(example = "Univerzitná") // Príklad pre swagger doku.
    private String street;
    @NotEmpty
    @ApiModelProperty(example = "Žilina") // Príklad pre swagger doku.
    private String city;
    @NotEmpty
    @ApiModelProperty(example = "Slovakia") // Príklad pre swagger doku.
    private String state;
    @NotEmpty
    @Pattern(regexp = "^\\d*$")
    @ApiModelProperty(example = "01008") // Príklad pre swagger doku.
    private String zip;
    @Valid
    private ContactPerson contactPerson;
    @JsonIgnore // Ignorovanie danej premenej s pohladu Serializacie do
    // Objektu JSON.Gneroval by sa obrovský JSON a dochádzalo by aj k zacykleniu
    private Set<AbstractData> data;
    @JsonIgnore // Ignorovanie danej premenej s pohladu Serializacie do
    // Objektu JSON.Gneroval by sa obrovský JSON a dochádzalo by aj k zacykleniu
    private Collection<IotNode> iotNode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Set<AbstractData> getData() {
        return data;
    }

    public Collection<IotNode> getIotNode() {
        return iotNode;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

