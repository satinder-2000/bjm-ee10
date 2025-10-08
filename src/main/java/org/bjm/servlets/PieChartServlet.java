package org.bjm.servlets;

import jakarta.inject.Inject;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.bjm.ejbs.SurveyServiceEjbLocal;
import org.bjm.entities.SurveyVote;
import org.bjm.entities.VoteType;
import org.bjm.utils.ImageUtil;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author singh
 */
@WebServlet(name = "PieChartServlet", urlPatterns = {"/PieChartServlet"})
public class PieChartServlet extends HttpServlet {
    
    private static final Logger LOGGER=Logger.getLogger(PieChartServlet.class.getName());
    
    @Inject
    private SurveyServiceEjbLocal surveyServiceEjbLocal;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String surveyIdStr=request.getParameter("surveyId");
        int dia=Integer.parseInt(request.getParameter("dia"));
        Integer surveyId=Integer.getInteger(surveyIdStr);
        List<SurveyVote> surveyVoteList=surveyServiceEjbLocal.getAllVotesOnSurvey(surveyId);
        int agreeCt=0;
        int disagreeCt=0;
        int undecidedCt=0;
        if(!surveyVoteList.isEmpty()){
            String text="No Vote yet";
            int diaE=Double.valueOf(dia*.5).intValue();
            BufferedImage bufferedImage=ImageUtil.drawEmptyPieChart(diaE, text, diaE);
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            baos.flush();
            byte[] pngData=baos.toByteArray();
            baos.close();
            response.getOutputStream().write(pngData);
        }else{
            for(SurveyVote sv: surveyVoteList){
                if (sv.getVoteType().equals(VoteType.AGREE.toString())){
                    agreeCt++;
                }else if (sv.getVoteType().equals(VoteType.DISAGREE.toString())){
                    disagreeCt++;
                }else if (sv.getVoteType().equals(VoteType.UNDECIDED.toString())){
                    undecidedCt++;
                }
            }
            DefaultPieDataset dataset=new DefaultPieDataset();
            dataset.setValue(VoteType.AGREE.toString(), agreeCt);
            dataset.setValue(VoteType.DISAGREE.toString(), disagreeCt);
            dataset.setValue(VoteType.UNDECIDED.toString(), undecidedCt);
            JFreeChart chart=ChartFactory.createPieChart("Votes till Date", dataset, true, true, false);
            chart.setBorderVisible(false);
            ChartUtils.writeChartAsPNG(response.getOutputStream(), chart, dia, dia);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
