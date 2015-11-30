/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nitid
 */
@Entity
@Table(name = "staff information")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StaffInformation.findAll", query = "SELECT s FROM StaffInformation s"),
    @NamedQuery(name = "StaffInformation.findByIDStaff", query = "SELECT s FROM StaffInformation s WHERE s.iDStaff = :iDStaff"),
    @NamedQuery(name = "StaffInformation.findByNameStaff", query = "SELECT s FROM StaffInformation s WHERE s.nameStaff = :nameStaff"),
    @NamedQuery(name = "StaffInformation.findByAddress", query = "SELECT s FROM StaffInformation s WHERE s.address = :address"),
    @NamedQuery(name = "StaffInformation.findByTelephoneNumbers", query = "SELECT s FROM StaffInformation s WHERE s.telephoneNumbers = :telephoneNumbers"),
    @NamedQuery(name = "StaffInformation.findBySalary", query = "SELECT s FROM StaffInformation s WHERE s.salary = :salary"),
    @NamedQuery(name = "StaffInformation.findByPosition", query = "SELECT s FROM StaffInformation s WHERE s.position = :position")})
public class StaffInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ID_Staff")
    private String iDStaff;
    @Size(max = 40)
    @Column(name = "NameStaff")
    private String nameStaff;
    @Size(max = 40)
    @Column(name = "Address")
    private String address;
    @Size(max = 40)
    @Column(name = "Telephone Numbers")
    private String telephoneNumbers;
    @Size(max = 40)
    @Column(name = "Salary")
    private String salary;
    @Size(max = 40)
    @Column(name = "Position")
    private String position;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDStaff")
    private Collection<TheStudyData> theStudyDataCollection;

    public StaffInformation() {
    }

    public StaffInformation(String iDStaff) {
        this.iDStaff = iDStaff;
    }

    public String getIDStaff() {
        return iDStaff;
    }

    public void setIDStaff(String iDStaff) {
        this.iDStaff = iDStaff;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public void setTelephoneNumbers(String telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @XmlTransient
    public Collection<TheStudyData> getTheStudyDataCollection() {
        return theStudyDataCollection;
    }

    public void setTheStudyDataCollection(Collection<TheStudyData> theStudyDataCollection) {
        this.theStudyDataCollection = theStudyDataCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDStaff != null ? iDStaff.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StaffInformation)) {
            return false;
        }
        StaffInformation other = (StaffInformation) object;
        if ((this.iDStaff == null && other.iDStaff != null) || (this.iDStaff != null && !this.iDStaff.equals(other.iDStaff))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "first.StaffInformation[ iDStaff=" + iDStaff + " ]";
    }
    
}
