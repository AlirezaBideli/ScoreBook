package com.aira.scorebook.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.StringPrepParseException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aira.scorebook.R;
import com.aira.scorebook.model.Student;
import com.aira.scorebook.network.StudentController;
import com.aira.scorebook.tools.MySharedPreferences;
import com.aira.scorebook.tools.SharedKeys;
import com.aira.scorebook.ui.tools.FieldsUtil;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddStudentActivity extends AppCompatActivity {

    @BindView(R.id.edt_first_name)
    TextInputEditText mEdtFirstName;
    @BindView(R.id.edt_last_name)
    TextInputEditText mEdtLastName;
    @BindView(R.id.edt_student_code)
    TextInputEditText mEdtStudentCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_submit)
    public void onSubmit(View view) {

        String firstName=mEdtFirstName.getText().toString().trim();
        String lastName=mEdtLastName.getText().toString().trim();
        String studentCode=mEdtStudentCode.getText().toString().trim();

        TextInputEditText[] fields={mEdtFirstName,mEdtLastName};
        String[] errors={getString(R.string.firstName_error)};
        boolean isValid= FieldsUtil.setError(fields,errors);

        if (isValid) {
            int studentCodeInt;
            if(studentCode.isEmpty())
                studentCodeInt=0;
            else
                studentCodeInt= Integer.parseInt(studentCode);
            long teacherId= Long.parseLong(MySharedPreferences.getInstance()
                    .getData(SharedKeys.TEACHER_ID));
            Student student=new Student(firstName,lastName,studentCodeInt,teacherId);
            StudentController controller = new StudentController();
            controller.start(student);
        }
    }
}
