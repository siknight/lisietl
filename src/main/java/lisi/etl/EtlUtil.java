package lisi.etl;

import org.apache.commons.lang.StringUtils;

public class EtlUtil {
    public static String str(String s) {
        String[] split = s.split("\t");
        if(split.length<9){
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        split[3]=split[3].replace(" ","");
        for (int i=0;i<split.length;i++){
            if (i<9){

                if (i==split.length-1){
                    stringBuffer.append(split[i]);
                }else{
                    stringBuffer.append(split[i]).append("\t");
                }

            }else{
                if (i==split.length-1){
                    stringBuffer.append(split[i]);
                }else{
                    stringBuffer.append(split[i]).append("&");
                }
            }
        }

        return stringBuffer.toString();
    }
}