/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nitid
 */
@Entity
@Table(name = "the study data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TheStudyData.findAll", query = "SELECT t FROM TheStudyData t"),
    @NamedQuery(name = "TheStudyData.findByIDResults", query = "SELECT t FROM TheStudyData t WHERE t.iDResults = :iDResults"),
    @NamedQuery(name = "TheStudyData.findByCredit", query = "SELECT t FROM TheStudyData t WHERE t.credit = :credit"),
    @NamedQuery(name = "TheStudyData.findByScore", query = "SELECT t FROM TheStudyData t WHERE t.score = :score"),
    @NamedQuery(name = "TheStudyData.findByGpa", query = "SELECT t FROM TheStudyData t WHERE t.gpa = :gpa"),
    @NamedQuery(name = "TheStudyData.findByYear", query = "SELECT t FROM TheStudyData t WHERE t.year = :year")})
public class TheStudyData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ID_Results")
    private String iDResults;
    @Size(max = 40)
    @Column(name = "Credit")
    private String credit;
    @Size(max = 40)
    @Column(name = "Score")
    private String score;
    @Size(max = 40)
    @Column(name = "GPA")
    private String gpa;
    @Size(max = 40)
    @Column(name = "Year")
    private String year;
    @JoinColumn(name = "ID_Course", referencedColumnName = "ID_Course")
    @ManyToOne(optional = false)
    private CourseInformation iDCourse;
    @JoinColumn(name = "ID_Staff", referencedColumnName = "ID_Staff")
    @ManyToOne(optional = false)
    private StaffInformation iDStaff;
    @JoinColumn(name = "ID_Student", referencedColumnName = "ID_Student")
    @ManyToOne(optional = false)
    private StudentInformation iDStudent;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "theStudyData")
    private Results results;

    public TheStudyData() {
    }

    public TheStudyData(String iDResults) {
        this.iDResults = iDResults;
    }

    public String getIDResults() {
        return iDResults;
    }

    public void setIDResults(String iDResults) {
        this.iDResults = iDResults;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public CourseInformation getIDCourse() {
        return iDCourse;
    }

    public void setIDCourse(CourseInformation iDCourse) {
        this.iDCourse = iDCourse;
    }

    public StaffInformation getIDStaff() {
        return iDStaff;
    }

    public void setIDStaff(StaffInformation iDStaff) {
        this.iDStaff = iDStaff;
    }

    public StudentInformation getIDStudent() {
        return iDStudent;
    }

    public void setIDStudent(StudentInformation iDStudent) {
        this.iDStudent = iDStudent;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDResults != null ? iDResults.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TheStudyData)) {
            return false;
        }
        TheStudyData other = (TheStudyData) object;
        if ((this.iDResults == null && other.iDResults != null) || (this.iDResults != null && !this.iDResults.equals(other.iDResults))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "first.TheStudyData[ iDResults=" + iDResults + " ]";
    }
    
}
