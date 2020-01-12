package com.aira.scorebook;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.aira.scorebook.model.Teacher;
import com.aira.scorebook.network.TeacherController;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RegisterTeacher extends AppCompatActivity {

    private static final String TAG = "RegisterTeacherTag";
    @BindView(R.id.edt_name)
    public EditText mEdtName;
    @BindView(R.id.edt_last_name)
    public EditText mEdtLastName;
    @BindView(R.id.edt_teacher_code)
    public EditText mEdtTeacherCode;
    @BindView(R.id.btn_submit)
    public Button mBtnSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_submit)
    public void onSubmit()
    {
        String name=mEdtName.getText().toString();
        String lname=mEdtLastName.getText().toString();
        int teacher_code= Integer.parseInt(
                mEdtTeacherCode.getText().toString()
        );
        Teacher teacher=new Teacher(name,lname,teacher_code);
        TeacherController controller=new TeacherController();
        controller.start(teacher);
   }
}
