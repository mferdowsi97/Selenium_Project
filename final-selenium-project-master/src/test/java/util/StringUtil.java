package util;

public class StringUtil {

    public double getValueByRemovingDegreeSign(String tempString){
        //split the string around degree symbol (˚)
        String[] strings = tempString.split("˚");
        String temp = strings[0];
        return Double.parseDouble(temp);
    }


}
