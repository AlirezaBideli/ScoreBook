package com.aira.scorebook.ui.activities;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.aira.scorebook.ui.callbacks.FragmentContainer;
import com.aira.scorebook.R;
import com.aira.scorebook.ui.fragments.AddUserFragment;

public class RegisterActivity extends AppCompatActivity implements FragmentContainer {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportFragmentManager().
                beginTransaction()
                .add(R.id.container, AddUserFragment.newInstance())
                .commit();
    }


    @Override
    public void showNextFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,fragment)
                .commit();
    }
}
