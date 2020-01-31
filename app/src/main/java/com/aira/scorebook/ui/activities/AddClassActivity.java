package com.aira.scorebook.ui.activities;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.aira.scorebook.R;
import com.aira.scorebook.model.ClassT;
import com.aira.scorebook.network.ClassController;
import com.aira.scorebook.tools.MySharedPreferences;
import com.aira.scorebook.tools.SharedKeys;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddClassActivity extends AppCompatActivity {


    @BindView(R.id.edt_name)
    EditText mEdtName;
    @BindView(R.id.edt_class_code)
    EditText mEdtClassCode;
    @BindView(R.id.spn_day)
    Spinner mSpnDay;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    private String mTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        ButterKnife.bind(this);

        String[] days = getResources().getStringArray(R.array.days);
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_dropdown_item, days);
        mSpnDay.setAdapter(adapter);
    }

    @OnClick(R.id.btn_submit)
    public void onSubmit() {

        String name = mEdtName.getText().toString();
        if (name.isEmpty()) {
            String error = getString(R.string.class_name_error);
            mEdtName.setError(error);
            Toast.makeText(this, R.string.complete_fields, Toast.LENGTH_LONG).show();
            return;
        }
        int class_code = Integer.parseInt
                (mEdtClassCode.getText().toString());
        MySharedPreferences sharedPreferences = MySharedPreferences.getInstance();
        String teacherIdStr = sharedPreferences.getData(SharedKeys.TEACHER_ID);
        long teacherId = Long.parseLong(teacherIdStr);
        int dayCode = mSpnDay.getSelectedItemPosition();
        ClassT classT = new ClassT(name, mTime, dayCode, class_code, teacherId);
        ClassController controller = new ClassController();
        controller.start(classT);
    }

    public void OnSelectTime(View view) {


        TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if (view.isShown()) {

                    mTime = hourOfDay + ":" + minute;
                    String time = getString(R.string.selected_time) + "\n" + mTime;
                    mTvTime.setVisibility(View.VISIBLE);
                    mTvTime.setText(time);
                }
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                android.R.style.Theme_Holo_Light_Dialog_NoActionBar, myTimeListener, 7, 30, true);
        String title = getString(R.string.choose_hour);
        timePickerDialog.setTitle(title);
        timePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        timePickerDialog.show();

    }
}
