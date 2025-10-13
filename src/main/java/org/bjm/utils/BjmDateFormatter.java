package org.bjm.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author singh
 */
public class BjmDateFormatter {
    
    public static final String getFormattedDate(Timestamp ts){
        Date date=new Date(ts.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.format(date);
    }
    
}
