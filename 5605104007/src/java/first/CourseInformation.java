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
@Table(name = "course information")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseInformation.findAll", query = "SELECT c FROM CourseInformation c"),
    @NamedQuery(name = "CourseInformation.findByIDCourse", query = "SELECT c FROM CourseInformation c WHERE c.iDCourse = :iDCourse"),
    @NamedQuery(name = "CourseInformation.findByNameCourse", query = "SELECT c FROM CourseInformation c WHERE c.nameCourse = :nameCourse"),
    @NamedQuery(name = "CourseInformation.findByNumberCredit", query = "SELECT c FROM CourseInformation c WHERE c.numberCredit = :numberCredit"),
    @NamedQuery(name = "CourseInformation.findByHoursLearning", query = "SELECT c FROM CourseInformation c WHERE c.hoursLearning = :hoursLearning")})
public class CourseInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ID_Course")
    private String iDCourse;
    @Size(max = 40)
    @Column(name = "NameCourse")
    private String nameCourse;
    @Size(max = 40)
    @Column(name = "NumberCredit")
    private String numberCredit;
    @Size(max = 40)
    @Column(name = "HoursLearning")
    private String hoursLearning;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDCourse")
    private Collection<TheStudyData> theStudyDataCollection;

    public CourseInformation() {
    }

    public CourseInformation(String iDCourse) {
        this.iDCourse = iDCourse;
    }

    public String getIDCourse() {
        return iDCourse;
    }

    public void setIDCourse(String iDCourse) {
        this.iDCourse = iDCourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getNumberCredit() {
        return numberCredit;
    }

    public void setNumberCredit(String numberCredit) {
        this.numberCredit = numberCredit;
    }

    public String getHoursLearning() {
        return hoursLearning;
    }

    public void setHoursLearning(String hoursLearning) {
        this.hoursLearning = hoursLearning;
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
        hash += (iDCourse != null ? iDCourse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseInformation)) {
            return false;
        }
        CourseInformation other = (CourseInformation) object;
        if ((this.iDCourse == null && other.iDCourse != null) || (this.iDCourse != null && !this.iDCourse.equals(other.iDCourse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "first.CourseInformation[ iDCourse=" + iDCourse + " ]";
    }
    
}
