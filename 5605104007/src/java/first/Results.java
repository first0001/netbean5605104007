/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "results")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Results.findAll", query = "SELECT r FROM Results r"),
    @NamedQuery(name = "Results.findByIDResults", query = "SELECT r FROM Results r WHERE r.iDResults = :iDResults"),
    @NamedQuery(name = "Results.findByGradeLevel", query = "SELECT r FROM Results r WHERE r.gradeLevel = :gradeLevel"),
    @NamedQuery(name = "Results.findByGPAas", query = "SELECT r FROM Results r WHERE r.gPAas = :gPAas")})
public class Results implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ID_Results")
    private String iDResults;
    @Size(max = 40)
    @Column(name = "GradeLevel")
    private String gradeLevel;
    @Size(max = 40)
    @Column(name = "GPA as")
    private String gPAas;
    @JoinColumn(name = "ID_Results", referencedColumnName = "ID_Results", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TheStudyData theStudyData;

    public Results() {
    }

    public Results(String iDResults) {
        this.iDResults = iDResults;
    }

    public String getIDResults() {
        return iDResults;
    }

    public void setIDResults(String iDResults) {
        this.iDResults = iDResults;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getGPAas() {
        return gPAas;
    }

    public void setGPAas(String gPAas) {
        this.gPAas = gPAas;
    }

    public TheStudyData getTheStudyData() {
        return theStudyData;
    }

    public void setTheStudyData(TheStudyData theStudyData) {
        this.theStudyData = theStudyData;
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
        if (!(object instanceof Results)) {
            return false;
        }
        Results other = (Results) object;
        if ((this.iDResults == null && other.iDResults != null) || (this.iDResults != null && !this.iDResults.equals(other.iDResults))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "first.Results[ iDResults=" + iDResults + " ]";
    }
    
}
