package org.bjm.mbeans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.bjm.ejbs.ForumServiceEjbLocal;
import org.bjm.entities.Access;
import org.bjm.entities.Forum;

/**
 *
 * @author singh
 */
@Named(value = "forumsByUserMBean")
public class ForumsByUserMBean {
    
    private static final Logger LOGGER=Logger.getLogger(ForumsByUserMBean.class.getName());
    
    @Inject
    private ForumServiceEjbLocal forumServiceEjbLocal;
    
    private List<Forum> userForums;
    
    @PostConstruct
    public void init(){
        HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session= request.getSession();
        Access access=(Access) session.getAttribute("access");
        userForums=forumServiceEjbLocal.getAllUserForums(access.getEmail());
        LOGGER.info(String.format("Count of Forums extracted is %d", userForums.size()));
    }

    public List<Forum> getUserForums() {
        return userForums;
    }

    public void setUserForums(List<Forum> userForums) {
        this.userForums = userForums;
    }
    
    
    
    
}
