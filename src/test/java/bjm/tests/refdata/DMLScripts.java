package bjm.tests.refdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

/**
 *
 * @author singh
 */
public class DMLScripts {
    
    public static void main(String... args){
        
        FileWriter fw=null;
        
        try {
            File file = new File("/home/singh/nb-ws/bjm-ee10/RefData/States.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();//Discard the column names as we are only interested in the data lines
            String line=br.readLine();
            StringBuilder sb=new StringBuilder();
            while(line!=null){
                StringTokenizer st= new StringTokenizer(",");
                StringBuilder sbLine=new StringBuilder("(");
                sbLine.append("'").append(st.nextToken()).append("'");//code
                sbLine.append("'").append(st.nextToken()).append("'");//name
                sbLine.append("'").append(st.nextToken()).append("'");//postCodePrefix
                sbLine.append("),\\n");
                sb.append(sbLine.toString());
                line=br.readLine();
            }
            sb.replace(sb.lastIndexOf(",")-1, sb.lastIndexOf(","), "");
            File fileSql = new File("/home/singh/nb-ws/bjm-ee10/RefData/States.csv");
            fw = new FileWriter(fileSql);
            fw.write(sb.toString());
                
            
        } catch (Exception ex) {
            System.getLogger(DMLScripts.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            try{
                fw.close();
            }catch(Exception ex2){
                ex2.printStackTrace();
            }
        }
    
    }
    
}
