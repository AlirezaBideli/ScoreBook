package com.aira.scorebook.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.aira.scorebook.R;

import com.aira.scorebook.ui.callbacks.FragmentContainer;
import com.aira.scorebook.ui.tools.FieldsUtil;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddUserFragment extends Fragment {

    //Widgets
    @BindView(R.id.edt_userName)
    TextInputEditText mEdtUserName;
    @BindView(R.id.edt_password)
    TextInputEditText mEdtPassword;
    @BindView(R.id.edt_c_password)
    TextInputEditText mEdtConfirmPassword;
    @BindView(R.id.btn_register)
    MaterialButton mBtnRegister;

    //Variables
    private FragmentContainer mCallBack;


    public static AddUserFragment newInstance() {

        Bundle args = new Bundle();

        AddUserFragment fragment = new AddUserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentContainer)
            mCallBack = (FragmentContainer) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallBack = null;
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
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = mEdtUserName.getText().toString();
                String password = mEdtPassword.getText().toString();
                String confirmPassword = mEdtConfirmPassword.getText().toString();


                TextInputEditText[] fields = {mEdtUserName, mEdtPassword, mEdtConfirmPassword};
                String[] errors = {getString(R.string.userName_error),
                        getString(R.string.password_error),
                        getString(R.string.confirm_password_error)
                };
                boolean isValid=FieldsUtil.setError(fields, errors);

                if (isValid) {
                    Fragment fragment = AddTeacherFragment.newInstance(userName,password);
                    mCallBack.showNextFragment(fragment);
                }

            }
        });

    }


}
