package com.aira.scorebook.ui.tools;

import android.content.Context;
import android.widget.Toast;

import com.aira.scorebook.MyApp;
import com.aira.scorebook.R;
import com.google.android.material.textfield.TextInputEditText;

public class FieldsUtil {


    public static final int PASSWORD_LENGTH = 8;

    public static boolean setError(TextInputEditText[] fields, String[] errors) {

        Context context = MyApp.getContext();
        boolean isValid=true;

        int length = fields.length;
        byte emtyCount = 0;
        for (byte i = 0; i < length; i++) {
            String fieldValue = fields[i].getText().toString();
            if (fieldValue.isEmpty()) {
                emtyCount++;
                fields[i].setError(errors[i]);
            }
            if (i < length - 1
                    && fields[i].getId() == R.id.edt_password
                    && fields[i + 1].getId() == R.id.edt_c_password) {
                String password = fields[i].getText().toString().trim();
                String confirmPassword=fields[i+1].getText().toString().trim();

                byte validCounter=0;
                if(comparePasswords(password, confirmPassword, context))
                    validCounter++;
                if (checkLength(fields[i],fields[i+1]))
                    validCounter++;

                isValid= validCounter == 2;
            }
        }

        if (emtyCount > 0) {
            showToast(context, R.string.complete_fields);
            isValid=false;
        }


        return isValid;

    }

    private static boolean checkLength(TextInputEditText edtPassword, TextInputEditText edtConfirmPassword) {
        boolean isValid=true;
        Context context = MyApp.getContext();
        String password=edtPassword.getText().toString().trim();
        String confirmPassword=edtConfirmPassword.getText().toString().trim();
        String error=context.getString(R.string.password_length);

        if (password.length()< PASSWORD_LENGTH )
        {
            edtPassword.setError(error);
            isValid=false;
        }
        if (confirmPassword.length()<PASSWORD_LENGTH)
        {
            edtConfirmPassword.setError(error);
            isValid=false;
        }

        return isValid;
    }

    private static boolean comparePasswords(String password, String confirmPassword, Context context) {

        if (!password.equals(confirmPassword)) {
            showToast(context, R.string.confirm_password_wrong);
            return false;
        }
        return true;
    }

    private static void showToast(Context context, int p) {
        Toast.makeText(
                context,
                context.getText(p), Toast.LENGTH_LONG)
                .show();
    }
}
