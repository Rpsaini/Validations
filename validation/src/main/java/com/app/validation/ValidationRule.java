package com.app.validation;

import android.view.View;
import android.widget.EditText;

public class ValidationRule {

    //0 Mean empty edittext
    //1 mobilenumber length issue
    //2 all valid


    public static String digitMustOccurAtlestOnce="(?=.*[0-9])";
    public static String lowercaseMustOccurAtlestOnce="(?=.*[a-z])";
    public static String uppercaseMustOccurAtlestOnce="(?=.*[A-Z])";
    public static String specialchrMustOccurAtlestOnce="(?=.*[@#$%^&+=])";
    public static String nowhitespace="(?=\\S+$)";
    public static String passwordstartbystring="^";
    public static String passwordendbystring="$";



    public int checkMobileNumber(View view, int reqLength) {
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            if (editText.length() == 0)
            {
                return 0;//
            } else if (reqLength != editText.getText().toString().length()) {
                return 1;
            } else {
                return 2;
            }
        }

        return 2;
    }


    public int checkEmptyString(View view) {
        EditText editText = (EditText) view;
        if (editText.length() == 0) {
            return 0;
        }

        return 2;

    }


    public int checkEmail(View view)
    {
        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        final String emailValidateStr = ((EditText) view).getText().toString().trim();
        if(emailValidateStr.matches(emailPattern) && emailValidateStr.length() > 0) {

            return 2;//valid email

        } else {
            return 0; //email invalid
        }
    }

    public int checkPssword(View pass1,View pass2)
    {
        EditText edPass1=(EditText) pass1;
        EditText edPass2= (EditText) pass2;

        if(checkEmptyString(pass1)==2)
        {

            if(edPass1.getText().length()==edPass2.getText().length())
            {
                return 2;//valid Password
            }
            else
            {
                return 1;  //password does not matched
            }
        }
        else
        {
            return 0;//password length issue
        }

    }


    public int checkpasswordPattern(View  pass1,int length,String...rules)
    {
        EditText edPass1=(EditText) pass1;
        String pattern="";
        for(int x=0;x<rules.length;x++)
        {
            pattern=rules[x]+pattern;
        }
        pattern=pattern+".{"+length+",}";
        if(edPass1.getText().toString().matches(pattern))
        {
            System.out.println("inside======>");
            return 2;
        }
        return 0;
    }

//            String pattern1 = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
//      ^      # start-of-string
//            (?=.*[0-9])       # a digit must occur at least once
//            (?=.*[a-z])       # a lower case letter must occur at least once
//            (?=.*[A-Z])       # an upper case letter must occur at least once
//            (?=.*[@#$%^&+=])  # a special character must occur at least once
//            (?=\S+$)          # no whitespace allowed in the entire string
//            .{8,}             # anything, at least eight places though
//    $       # end-of-string


}



