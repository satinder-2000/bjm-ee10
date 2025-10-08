package org.bjm.ejbs;

import jakarta.ejb.Local;
import java.util.List;
import org.bjm.entities.SurveyFromForum;
import org.bjm.entities.SurveyFromForumVote;

/**
 *
 * @author singh
 */
@Local
public interface SurveyFromForumServiceEjbLocal {
    public SurveyFromForum findById(int surveyFromForumId);
    public SurveyFromForumVote postSurveyFromForumVote(SurveyFromForumVote surveyFromForumVote);
    public List<SurveyFromForumVote> getAllVotesOnSurveyFromForum(int surveyFromForumId);
}
