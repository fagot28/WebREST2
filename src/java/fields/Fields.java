/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fields;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fadee
 */
@Entity
@Table(name = "FIELDS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fields.findAll", query = "SELECT f FROM Fields f"),
    @NamedQuery(name = "Fields.findById", query = "SELECT f FROM Fields f WHERE f.id = :id"),
    @NamedQuery(name = "Fields.findByField", query = "SELECT f FROM Fields f WHERE f.field = :field")})
public class Fields implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Field")
    private String field;

    public Fields() {
    }

    public Fields(Long id) {
        this.id = id;
    }

    public Fields(Long id, String field) {
        this.id = id;
        this.field = field;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fields)) {
            return false;
        }
        Fields other = (Fields) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fields.Fields[ id=" + id + " ]";
    }
    
}
