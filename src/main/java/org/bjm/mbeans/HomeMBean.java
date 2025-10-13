package org.bjm.mbeans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.bjm.dtos.BlogDto;
import org.bjm.dtos.ForumDto;
import org.bjm.dtos.SurveyFromForumDto;
import org.bjm.dtos.SurveyDto;
import org.bjm.ejbs.UserServiceEjbLocal;
import org.bjm.entities.Access;
import org.bjm.entities.Blog;
import org.bjm.entities.Forum;
import org.bjm.entities.Survey;
import org.bjm.entities.SurveyFromForum;
import org.bjm.utils.BjmDateFormatter;

/**
 *
 * @author singh
 */
@Named(value = "homeMBean")
@ViewScoped
public class HomeMBean implements Serializable {
    
    private static final Logger LOGGER=Logger.getLogger(HomeMBean.class.getName());
    
    @Inject
    private UserServiceEjbLocal userServiceEjbLocal;
    
    private List<Forum> userForums;
    private List<ForumDto> userForumsDtos;
    
    private List<Survey> userSurveys;
    private List<SurveyDto> userSurveysDtos;
    
    private List<SurveyFromForum> userSurveysFromForums;
    private List<SurveyFromForumDto> userSurveysFromForumsDtos;
    
    private List<Blog> userBlogs;
    private List<BlogDto> userBlogsDtos;
    
    @PostConstruct
    public void init(){
        HttpServletRequest request= (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session=request.getSession();
        Access access=(Access) session.getAttribute("access");
        
        userForums=userServiceEjbLocal.getUserForums(access.getEmail());
        userForumsDtos= new ArrayList<>(userForums.size());
        for (Forum f: userForums){
            ForumDto fDto=new ForumDto();
            fDto.setId(f.getId());
            fDto.setCategoryType(f.getCategoryType());
            fDto.setCategorySubType(f.getCategorySubType());
            fDto.setTitle(f.getTitle());
            fDto.setDescription(f.getDescription());
            fDto.setCreatedOn(BjmDateFormatter.getFormattedDate(f.getCreatedOn()));
            fDto.setUpdatedOn(BjmDateFormatter.getFormattedDate(f.getUpdatedOn()));
            userForumsDtos.add(fDto);
        }
        
        userSurveys=userServiceEjbLocal.getUserSurveys(access.getEmail());
        userSurveysDtos = new ArrayList<>(userSurveys.size());
        for (Survey s: userSurveys){
            SurveyDto sDto=new SurveyDto();
            sDto.setId(s.getId());
            sDto.setCategoryType(s.getCategoryType());
            sDto.setCategorySubType(s.getCategorySubType());
            sDto.setTitle(s.getTitle());
            sDto.setDescription(s.getDescription());
            sDto.setCreatedOn(BjmDateFormatter.getFormattedDate(s.getCreatedOn()));
            sDto.setUpdatedOn(BjmDateFormatter.getFormattedDate(s.getUpdatedOn()));
            userSurveysDtos.add(sDto);
        }

        userSurveysFromForums=userServiceEjbLocal.getUserSurveyFromForums(access.getEmail());
        userSurveysFromForumsDtos=new ArrayList<>(userSurveysFromForums.size());
        for (SurveyFromForum sf: userSurveysFromForums){
            SurveyFromForumDto sfDto=new SurveyFromForumDto();
            sfDto.setId(sf.getId());
            sfDto.setCategoryType(sf.getCategoryType());
            sfDto.setCategorySubType(sf.getCategorySubType());
            sfDto.setTitle(sf.getTitle());
            sfDto.setDescription(sf.getDescription());
            sfDto.setCreatedOn(BjmDateFormatter.getFormattedDate(sf.getCreatedOn()));
            sfDto.setUpdatedOn(BjmDateFormatter.getFormattedDate(sf.getUpdatedOn()));
            userSurveysFromForumsDtos.add(sfDto);
        }
        
        userBlogs=userServiceEjbLocal.getUserBlogs(access.getEmail());
        userBlogsDtos=new  ArrayList<>(userBlogs.size());
        for(Blog b: userBlogs){
            BlogDto bDto = new BlogDto();
            bDto.setId(b.getId());
            bDto.setTitle(b.getTitle());
            bDto.setSummary(b.getSummary());
            bDto.setText(b.getText());
            bDto.setPublishedById(b.getPublishedByAccessId());
            bDto.setPublishedByEmail(b.getPublishedByEmail());
            bDto.setPublishedOn(BjmDateFormatter.getFormattedDate(b.getPublishedOn()));
            userBlogsDtos.add(bDto);
        }
        LOGGER.info(String.format("Count of Forums by User %s is %d", access.getEmail(), userForums.size()));
        LOGGER.info(String.format("Count of Surveys by User %s is %d", access.getEmail(), userSurveys.size()));
        LOGGER.info(String.format("Count of SurveysFromForums by User %s is %d", access.getEmail(), userSurveys.size()));
        LOGGER.info(String.format("Count of Blogs by User %s is %d", access.getEmail(), userBlogs.size()));
        
    }
    
    
    
    public String goHome(){
        return "/home/userHome?faces-redirect=true";
    }

    public List<Forum> getUserForums() {
        return userForums;
    }

    public void setUserForums(List<Forum> userForums) {
        this.userForums = userForums;
    }

    public List<Survey> getUserSurveys() {
        return userSurveys;
    }

    public void setUserSurveys(List<Survey> userSurveys) {
        this.userSurveys = userSurveys;
    }

    public List<SurveyFromForum> getUserSurveysFromForums() {
        return userSurveysFromForums;
    }

    public void setUserSurveysFromForums(List<SurveyFromForum> userSurveysFromForums) {
        this.userSurveysFromForums = userSurveysFromForums;
    }

    public List<Blog> getUserBlogs() {
        return userBlogs;
    }

    public void setUserBlogs(List<Blog> userBlogs) {
        this.userBlogs = userBlogs;
    }

    public List<BlogDto> getUserBlogsDtos() {
        return userBlogsDtos;
    }

    public void setUserBlogsDtos(List<BlogDto> userBlogsDtos) {
        this.userBlogsDtos = userBlogsDtos;
    }
    
    

    public List<ForumDto> getUserForumsDtos() {
        return userForumsDtos;
    }

    public void setUserForumsDtos(List<ForumDto> userForumsDtos) {
        this.userForumsDtos = userForumsDtos;
    }

    

    public List<SurveyDto> getUserSurveysDtos() {
        return userSurveysDtos;
    }

    public void setUserSurveysDtos(List<SurveyDto> userSurveysDtos) {
        this.userSurveysDtos = userSurveysDtos;
    }

    public List<SurveyFromForumDto> getUserSurveysFromForumsDtos() {
        return userSurveysFromForumsDtos;
    }

    public void setUserSurveysFromForumsDtos(List<SurveyFromForumDto> userSurveysFromForumsDtos) {
        this.userSurveysFromForumsDtos = userSurveysFromForumsDtos;
    }
    
}
