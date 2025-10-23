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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.bjm.ejbs.SurveyFromForumServiceEjbLocal;
import org.bjm.ejbs.UserServiceEjbLocal;
import org.bjm.entities.Access;
import org.bjm.entities.Survey;
import org.bjm.entities.SurveyFromForum;
import org.bjm.entities.SurveyFromForumVote;
import org.bjm.entities.SurveyVote;
import org.bjm.entities.VoteType;
import org.bjm.utils.BjmConstants;
import org.bjm.utils.ImageVO;


/**
 *
 * @author singh
 */
@Named(value = "surveyFromForumDetailsMBean")
@ViewScoped
public class SurveyFromForumDetailsMBean implements Serializable{
    
    private static final Logger LOGGER = Logger.getLogger(SurveyFromForumDetailsMBean.class.getName());
    
    @Inject
    private SurveyFromForumServiceEjbLocal surveyFromForumServiceEjbLocal;
    @Inject
    private UserServiceEjbLocal userServiceEjbLocal;
    
    private int commentChars;
    private SurveyFromForum surveyFromForum;
    private Access surveyFromForumCreatorAccess;
    private SurveyFromForumVote surveyFromForumVote;
    private List<SurveyFromForumVote> otherSurveyFromForumVotes;
    
    private int votesTillDate;
    private double agreePct=0;
    private double disagreePct=0;
    private double undecidedPct=0;
    
    
    @PostConstruct
    public void init(){
        HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String surveyIdStr=request.getParameter("surveyId");
        int surveyId = Integer.parseInt(surveyIdStr);
        surveyFromForum=surveyFromForumServiceEjbLocal.findById(surveyId);
        LOGGER.info(String.format("SurveyFromForum loaded with ID: %s", surveyFromForum.getId()));
        surveyFromForumCreatorAccess=userServiceEjbLocal.getAccessByEmail(surveyFromForum.getSurveyCreatorEmail());
        HttpSession session = request.getSession();
        session.setAttribute(BjmConstants.SURVEY_FROM_FORUM_CREATOR_ACCESS, surveyFromForumCreatorAccess);
        surveyFromForumVote=new SurveyFromForumVote();
    }
    
    public String postSurveyFromForumVote(){
        if(surveyFromForumVote.getComment().trim().isEmpty()){
           FacesContext.getCurrentInstance().addMessage("usercomment", new FacesMessage(FacesMessage.SEVERITY_ERROR, "No comment entered", "No comment entered"));
        }else{
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            //surveyVote.setComment(userComment);
            surveyFromForumVote.setSurveyFromForumId(surveyFromForum.getId());
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession();
            Access access = (Access) session.getAttribute("access");
            surveyFromForumVote.setVoterAccessId(access.getId());
            surveyFromForumVote.setVoterEmail(access.getEmail());
            surveyFromForumVote.setDated(Timestamp.valueOf(LocalDateTime.now(ZoneId.of(servletContext.getInitParameter("zoneId")))));
            surveyFromForumVote=surveyFromForumServiceEjbLocal.postSurveyFromForumVote(surveyFromForumVote);
            LOGGER.info(String.format("New SurveyFromForumVote added with ID: %d", surveyFromForumVote.getId()));
            surveyFromForumVote=new SurveyFromForumVote();
            FacesContext.getCurrentInstance().addMessage("usercomment", new FacesMessage(FacesMessage.SEVERITY_INFO, "Vote casted successfully!!", "Vote casted successfully!!"));
        }
        return null;
    }
    
    private void loadOtherSurveyFromForumVotes(){
        otherSurveyFromForumVotes=surveyFromForumServiceEjbLocal.getAllVotesOnSurveyFromForum(surveyFromForum.getId());
        Map<Integer, ImageVO> surveyVoteerImageMap=new HashMap<>();
        int agreeCt =0 ;
        int disagreeCt =0;
        int undecidedCt =0;
        for(SurveyFromForumVote sv: otherSurveyFromForumVotes){
            Access surveyVoterAccess= userServiceEjbLocal.getAccessById(sv.getVoterAccessId());
            String imageType=surveyVoterAccess.getProfileFile().substring(surveyVoterAccess.getProfileFile().indexOf('.')+1);
            ImageVO surveyVoterImageVO=new ImageVO(imageType, surveyVoterAccess.getImage());
            surveyVoteerImageMap.put(surveyVoterAccess.getId(), surveyVoterImageVO);
            if (sv.getVoteType().equals(VoteType.AGREE.toString())){
                    agreeCt++;
                }else if (sv.getVoteType().equals(VoteType.DISAGREE.toString())){
                    disagreeCt++;
                }else if (sv.getVoteType().equals(VoteType.UNDECIDED.toString())){
                    undecidedCt++;
                }
        }
        int totalVotes=agreeCt+disagreeCt+undecidedCt;
        agreePct=(agreeCt/totalVotes)*100;
        disagreePct=(disagreeCt/totalVotes)*100;
        undecidedPct=(undecidedCt/totalVotes)*100;
        HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session=request.getSession();
        session.setAttribute(BjmConstants.SURVEY_FROM_FORUM_VOTER_IMAGE_MAP, surveyVoteerImageMap);
        LOGGER.info(String.format("Count of other SurveyFromForum Comments for Survey ID: %d is : %d", surveyFromForum.getId(), otherSurveyFromForumVotes.size()));
        votesTillDate=otherSurveyFromForumVotes.size();
        
        
        
    }

    public SurveyFromForum getSurveyFromForum() {
        return surveyFromForum;
    }

    public void setSurveyFromForum(SurveyFromForum surveyFromForum) {
        this.surveyFromForum = surveyFromForum;
    }

    public SurveyFromForumVote getSurveyFromForumVote() {
        return surveyFromForumVote;
    }

    public void setSurveyFromForumVote(SurveyFromForumVote surveyFromForumVote) {
        this.surveyFromForumVote = surveyFromForumVote;
    }

    public List<SurveyFromForumVote> getOtherSurveyFromForumVotes() {
        loadOtherSurveyFromForumVotes();
        return otherSurveyFromForumVotes;
    }

    public void setOtherSurveyFromForumVotes(List<SurveyFromForumVote> otherSurveyFromForumVotes) {
        this.otherSurveyFromForumVotes = otherSurveyFromForumVotes;
    }
    
    

    public int getCommentChars() {
        return commentChars;
    }

    public void setCommentChars(int commentChars) {
        this.commentChars = commentChars;
    }

    public int getVotesTillDate() {
        return votesTillDate;
    }

    public void setVotesTillDate(int votesTillDate) {
        this.votesTillDate = votesTillDate;
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