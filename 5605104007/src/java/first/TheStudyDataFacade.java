/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nitid
 */
@Stateless
public class TheStudyDataFacade extends AbstractFacade<TheStudyData> {

    @PersistenceContext(unitName = "5605104007PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TheStudyDataFacade() {
        super(TheStudyData.class);
    }
    
}
