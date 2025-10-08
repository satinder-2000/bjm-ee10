package org.bjm.ejbs;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import java.util.logging.Logger;
import org.bjm.entities.SurveyFromForum;
import org.bjm.entities.SurveyFromForumVote;
import org.bjm.entities.SurveyVote;

/**
 *
 * @author singh
 */
@Stateless
public class SurveyFromForumServiceEjb implements SurveyFromForumServiceEjbLocal {
    
    private static final Logger LOGGER = Logger.getLogger(SurveyFromForumServiceEjb.class.getName());
    
    @PersistenceContext(name = "bjmPU")
    private EntityManager em;

    @Override
    public SurveyFromForum findById(int surveyFromForumId) {
        Query query=em.createNamedQuery("SurveyFromForum.findById", SurveyFromForum.class);
        query.setParameter("id", surveyFromForumId);
        return (SurveyFromForum) query.getSingleResult();
    }

    @Override
    public SurveyFromForumVote postSurveyFromForumVote(SurveyFromForumVote surveyFromForumVote) {
        em.persist(surveyFromForumVote);
        em.flush();
        LOGGER.info(String.format("SurveyFromForumVote created with ID %d", surveyFromForumVote.getId()));
        return surveyFromForumVote;
    }

    @Override
    public List<SurveyFromForumVote> getAllVotesOnSurveyFromForum(int surveyFromForumId) {
        Query query=em.createNamedQuery("SurveyFromForumVote.findBySurveyFromForumId", SurveyFromForumVote.class);
        query.setParameter("surveyFromForumId", surveyFromForumId);
        List<SurveyFromForumVote> toReturn = query.getResultList();
        LOGGER.info(String.format("Count of SurveyFromForumVote with surveyFromForumId %d is %d", surveyFromForumId, toReturn.size()));
        return toReturn;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
