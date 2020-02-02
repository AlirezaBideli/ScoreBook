package com.aira.scorebook.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.aira.scorebook.R;
import com.aira.scorebook.model.Teacher;
import com.aira.scorebook.network.TeacherController;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddTeacherFragment extends Fragment {

    private static final String TAG = "RegisterTeacherTag";
    private static final String PASSWORD_ARG = "password";
    private static final String USERNAME_ARG = "userName";
    @BindView(R.id.edt_name)
    public TextInputEditText mEdtName;
    @BindView(R.id.edt_last_name)
    public TextInputEditText mEdtLastName;
    @BindView(R.id.edt_teacher_code)
    public TextInputEditText mEdtTeacherCode;
    @BindView(R.id.btn_submit)
    public TextInputEditText mBtnSubmit;


    public static AddTeacherFragment newInstance(String usetName,String password) {
        
        Bundle args = new Bundle();
        args.putString(USERNAME_ARG,usetName);
        args.putString(PASSWORD_ARG,password);
        AddTeacherFragment fragment = new AddTeacherFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getWindow()
                .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_add_teacher, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_submit)
    public void onSubmit() {
        String name = mEdtName.getText().toString();
        String lname = mEdtLastName.getText().toString();
        int teacher_code = Integer.parseInt(
                mEdtTeacherCode.getText().toString()
        );

        String userName=getArguments().getString(USERNAME_ARG);
        String password=getArguments().getString(PASSWORD_ARG);
        Teacher teacher = new Teacher(userName,password,name, lname, teacher_code);
        TeacherController controller = new TeacherController();
        controller.start(teacher);
    }
}
