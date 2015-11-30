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
@Table(name = "student information")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentInformation.findAll", query = "SELECT s FROM StudentInformation s"),
    @NamedQuery(name = "StudentInformation.findByIDStudent", query = "SELECT s FROM StudentInformation s WHERE s.iDStudent = :iDStudent"),
    @NamedQuery(name = "StudentInformation.findByNameStudent", query = "SELECT s FROM StudentInformation s WHERE s.nameStudent = :nameStudent"),
    @NamedQuery(name = "StudentInformation.findByNumber", query = "SELECT s FROM StudentInformation s WHERE s.number = :number"),
    @NamedQuery(name = "StudentInformation.findByDate", query = "SELECT s FROM StudentInformation s WHERE s.date = :date"),
    @NamedQuery(name = "StudentInformation.findByAddress", query = "SELECT s FROM StudentInformation s WHERE s.address = :address"),
    @NamedQuery(name = "StudentInformation.findByTelephoneNumbers", query = "SELECT s FROM StudentInformation s WHERE s.telephoneNumbers = :telephoneNumbers")})
public class StudentInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ID_Student")
    private String iDStudent;
    @Size(max = 40)
    @Column(name = "NameStudent")
    private String nameStudent;
    @Size(max = 40)
    @Column(name = "Number")
    private String number;
    @Size(max = 40)
    @Column(name = "Date")
    private String date;
    @Size(max = 40)
    @Column(name = "Address")
    private String address;
    @Size(max = 40)
    @Column(name = "Telephone Numbers")
    private String telephoneNumbers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDStudent")
    private Collection<TheStudyData> theStudyDataCollection;

    public StudentInformation() {
    }

    public StudentInformation(String iDStudent) {
        this.iDStudent = iDStudent;
    }

    public String getIDStudent() {
        return iDStudent;
    }

    public void setIDStudent(String iDStudent) {
        this.iDStudent = iDStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
        hash += (iDStudent != null ? iDStudent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentInformation)) {
            return false;
        }
        StudentInformation other = (StudentInformation) object;
        if ((this.iDStudent == null && other.iDStudent != null) || (this.iDStudent != null && !this.iDStudent.equals(other.iDStudent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "first.StudentInformation[ iDStudent=" + iDStudent + " ]";
    }
    
}
