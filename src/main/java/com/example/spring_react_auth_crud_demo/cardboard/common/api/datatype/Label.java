package com.example.spring_react_auth_crud_demo.cardboard.common.api.datatype;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable  // indicates that the type's attributes can be stored in columns of the owning entity's table
@Access(AccessType.FIELD)
public class Label {

    private String label;

    public Label() {}

    public Label(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // self check
        if (obj == null) return false; // null check
        if (getClass() != obj.getClass())
            return false;              // type check and cast
        Label label = (Label) obj;
        return getLabel().equals(label.getLabel());
    }

    @Override
    public String toString() {
        return "Label: " + label;
    }

}
