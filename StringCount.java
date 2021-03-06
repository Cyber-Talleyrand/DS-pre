package e1;

import static java.lang.Character.getNumericValue;

public class StringCount {

    public static int countWords(String text) {
        if(text==null) return 0;
        int count = 0;
        if((text.charAt(0)!=' ')) count++;
        for (int i = 0; i < text.length(); i++) {
            if((i>0)&&(text.charAt(i)!=' ')&&(text.charAt(i-1)==' ')) count++;
        }
        return count;
    }



    public static int countChar(String text, char c) {
        if(text==null) return 0;
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i)==c) count++;
        }
        return count;
    }


    public static int countCharIgnoringCase(String text, char c) {
        if(text==null) return 0;
        int count=0;
        for(int i=0;i<text.length();i++)
        {
            if( getNumericValue(text.charAt(i))==getNumericValue(c) && getNumericValue(c)>=10) count++;
            else if(c>=192 && text.charAt(i)>=192 && Math.abs(text.charAt(i)-c)==32 || text.charAt(i)==c )count++;
            else if(getNumericValue(c)<10 && text.charAt(i)==c) count++;


        }
        return count;
    }
    public static boolean isPasswordSafe(String password){
        if(password==null) throw new IllegalArgumentException();
        int a=password.length();
        if(password.length()<8) return false;
        if(!check_condition(password,65,90)) return false;
        if(!check_condition(password,97,122)) return false;
        if(!check_condition(password,30,39)) return false;
        return check_condition(password, 33, 47) || check_condition(password, 58, 64) ||
                check_condition(password, 92, 96) || check_condition(password, 123, 126);

    }

    private static boolean check_condition(String text, int a, int b){
        if(text==null) return false;
        for(int i = 0;i<text.length();i++){
            if(text.charAt(i)>a && text.charAt(i)<b ) return true;
        }
        return false;
    }
    
}
