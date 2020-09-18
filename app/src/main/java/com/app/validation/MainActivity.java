package com.app.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ValidationRuleTest validationRule=new ValidationRuleTest();

        EditText edpassword =findViewById(R.id.edpassword);

        edpassword.setText("");
        if(validationRule.checkEmptyString(edpassword)==0)
        {
          System.out.println("Enter Stringggggg");
        }

        edpassword.setText("hjhjjhj");
        if(validationRule.checkEmail(edpassword)==0)
        {
            System.out.println("Enter valid email");
        }

        edpassword.setText("ram@gmail.com");
        if(validationRule.checkEmail(edpassword)==2)
        {
            System.out.println("Enter  email is valid");
        }


        edpassword.setText("ram");
        if(validationRule.checkMobileNumber(edpassword,10)==0)
        {
            System.out.println("Enter   valid mobile");
        }

        edpassword.setText("1234567890");
        if(validationRule.checkMobileNumber(edpassword,10)==2)
        {
            System.out.println("Enter    mobile is valid");
        }

        edpassword.setText("1234567890");
        if(validationRule.checkpasswordPattern(edpassword,10, ValidationRuleTest.digitMustOccurAtlestOnce, ValidationRuleTest.lowercaseMustOccurAtlestOnce)==0)
        {
            System.out.println("Enter password is not valid");
        }

        edpassword.setText("1234567uUTY");

        if(validationRule.checkpasswordPattern(edpassword,11, ValidationRuleTest.digitMustOccurAtlestOnce, ValidationRuleTest.lowercaseMustOccurAtlestOnce, ValidationRuleTest.specialchrMustOccurAtlestOnce)==2)
        {
            System.out.println("Enter password is valid");
        }

     }
}
