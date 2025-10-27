package org.bjm.mbeans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.bjm.ejbs.SurveyServiceEjbLocal;
import org.bjm.ejbs.UserServiceEjbLocal;
import org.bjm.entities.Access;
import org.bjm.entities.Survey;
import org.bjm.entities.SurveyVote;
import org.bjm.entities.VoteType;
import org.bjm.utils.BjmConstants;
import org.bjm.utils.ImageVO;

/**
 *
 * @author singh
 */
@Named(value = "surveyDetailsMBean")
@ViewScoped
public class SurveyDetailsMBean implements Serializable{
    
    private static final Logger LOGGER=Logger.getLogger(SurveyDetailsMBean.class.getName());
    private int commentChars;
    private Survey survey;
    private String userComment;
    private SurveyVote surveyVote;
    private List<SurveyVote> otherSurveyVotes;
    
    @Inject
    private SurveyServiceEjbLocal surveyServiceEjbLocal;
    @Inject
    private UserServiceEjbLocal userServiceEjbLocal;
    
    private double agreePct, disagreePct, undecidedPct;
    
    
    @PostConstruct
    public void init(){
        HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String surveyIdStr=request.getParameter("surveyId");
        int surveyId=Integer.parseInt(surveyIdStr);
        survey = surveyServiceEjbLocal.findById(surveyId);
        LOGGER.info(String.format("Survey with ID: %d Loaded successfully.", survey.getId()));
        
        Access surveyCreator=userServiceEjbLocal.getAccessByEmail(survey.getSurveyCreatorEmail());
        HttpSession session=request.getSession();
        session.setAttribute(BjmConstants.SURVEY_CREATOR_ACCESS, surveyCreator);
        surveyVote=new SurveyVote();
        LOGGER.info(String.format("Survey with ID: %s Loaded successfully.", survey.getId()));
    }
    
    public String postSurveyVote(){
        if(surveyVote.getComment().trim().isEmpty()){
           FacesContext.getCurrentInstance().addMessage("usercomment", new FacesMessage(FacesMessage.SEVERITY_ERROR, "No comment entered", "No comment entered"));
        }else{
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            //surveyVote.setComment(userComment);
            surveyVote.setSurveyId(survey.getId());
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession();
            Access access = (Access) session.getAttribute("access");
            surveyVote.setVoterAccessId(access.getId());
            surveyVote.setVoterEmail(access.getEmail());
            surveyVote.setDated(Timestamp.valueOf(LocalDateTime.now(ZoneId.of(servletContext.getInitParameter("zoneId")))));
            surveyVote=surveyServiceEjbLocal.postSurveyVote(surveyVote);
            LOGGER.info(String.format("New SurveyVote added with ID: %d", surveyVote.getId()));
            surveyVote=new SurveyVote();
            FacesContext.getCurrentInstance().addMessage("usercomment", new FacesMessage(FacesMessage.SEVERITY_INFO, "Vote casted successfully!!", "Vote casted successfully!!"));
        }
        return null;
    }
    
    private void loadOtherSurveyVotes(){
        
        otherSurveyVotes=surveyServiceEjbLocal.getAllVotesOnSurvey(survey.getId());
        if(otherSurveyVotes.isEmpty()){
            FacesContext.getCurrentInstance().addMessage("otherMsgForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "No Survey Vote found!!", "No Survey Vote found!!"));
        }else{
            Map<Integer, ImageVO> surveyVoteerImageMap = new HashMap<>();
            int agreeCt = 0;
            int disagreeCt = 0;
            int undecidedCt = 0;
            for (SurveyVote sv : otherSurveyVotes) {
                Access surveyVoterAccess = userServiceEjbLocal.getAccessById(sv.getVoterAccessId());
                String imageType = surveyVoterAccess.getProfileFile().substring(surveyVoterAccess.getProfileFile().indexOf('.') + 1);
                ImageVO surveyVoterImageVO = new ImageVO(imageType, surveyVoterAccess.getImage());
                surveyVoteerImageMap.put(surveyVoterAccess.getId(), surveyVoterImageVO);
                if (sv.getVoteType().equals(VoteType.AGREE.toString())) {
                    agreeCt++;
                } else if (sv.getVoteType().equals(VoteType.DISAGREE.toString())) {
                    disagreeCt++;
                } else if (sv.getVoteType().equals(VoteType.UNDECIDED.toString())) {
                    undecidedCt++;
                }
            }
            int totalVotes = agreeCt + disagreeCt + undecidedCt;
            agreePct = (agreeCt / totalVotes) * 100;
            disagreePct = (disagreeCt / totalVotes) * 100;
            undecidedPct = (undecidedCt / totalVotes) * 100;
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession();
            session.setAttribute(BjmConstants.SURVEY_VOTER_IMAGE_MAP, surveyVoteerImageMap);
            LOGGER.info(String.format("Count of other Survey Comments for Survey ID: %d is : %d", survey.getId(), otherSurveyVotes.size()));
        }
        
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public int getCommentChars() {
        return commentChars;
    }

    public void setCommentChars(int commentChars) {
        this.commentChars = commentChars;
    }
    
    public List<SurveyVote> getOtherSurveyVotes(){
        loadOtherSurveyVotes();
        return otherSurveyVotes;
    }
    
    public void setOtherSurveyVotes(List<SurveyVote> otherSurveyVotes){
        this.otherSurveyVotes=otherSurveyVotes;
    }

    public SurveyVote getSurveyVote() {
        return surveyVote;
    }

    public void setSurveyVote(SurveyVote surveyVote) {
        this.surveyVote = surveyVote;
    }

    public double getAgreePct() {
        return agreePct;
    }

    public void setAgreePct(double agreePct) {
        this.agreePct = agreePct;
    }

    public double getDisagreePct() {
        return disagreePct;
    }

    public void setDisagreePct(double disagreePct) {
        this.disagreePct = disagreePct;
    }

    public double getUndecidedPct() {
        return undecidedPct;
    }

    public void setUndecidedPct(double undecidedPct) {
        this.undecidedPct = undecidedPct;
    }
    
    
    
    
}
