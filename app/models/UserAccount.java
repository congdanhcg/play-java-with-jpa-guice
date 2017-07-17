package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by danh.tc on 7/17/2017.
 */
@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String otherField;

    public UserAccount() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOtherField() {
        return otherField;
    }

    public void setOtherField(String otherField) {
        this.otherField = otherField;
    }
}
