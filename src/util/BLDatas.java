
package util;

import java.text.ParseException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author thiag
 */
public class BLDatas {
    
    public java.sql.Date converterDataParaDateUS(Date pData) throws Exception{
        SimpleDateFormat formatarDate = new SimpleDateFormat ("yyyy/MM/dd");
        String dataString = formatarDate.format(pData);
        if (pData == null || pData.equals(""))
            return null;
        
        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            date = new java.sql.Date( ((java.util.Date)formatter.parse(dataString)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }
    
}
