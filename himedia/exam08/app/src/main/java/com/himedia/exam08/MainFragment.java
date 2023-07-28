package com.himedia.exam08;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainFragment extends Fragment
{
    EditText nameInput ;
    EditText ageInput ;

    Button birthButton ;

    public static SimpleDateFormat dateFormat = new SimpleDateFormat( "YYYY년 MM월 dd일" ) ;

    Date selectedDate ;

    public MainFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        ViewGroup rootView = ( ViewGroup ) inflater.inflate( R.layout.fragment_main, container, false ) ;

        nameInput = rootView.findViewById( R.id.nameInput ) ;
        ageInput = rootView.findViewById( R.id.ageInput ) ;

        birthButton = rootView.findViewById( R.id.birthButton ) ;
        birthButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showDateDialog() ;
            }
        });

        Button saveButton = rootView.findViewById( R.id.saveButton ) ;
        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String nameStr = nameInput.getText().toString() ;
                String ageStr = ageInput.getText().toString() ;
                String birthStr = birthButton.getText().toString() ;

                Toast.makeText(getContext(), "이름 : " + nameStr + "나이 : " + ageStr + "생년월일 : " + birthStr , Toast.LENGTH_SHORT).show() ;
            }
        });


        return rootView ;

    }

    private void showDateDialog()
    {
        String birthDateStr = birthButton.getText().toString() ;

        Calendar calendar = Calendar.getInstance() ;

        Date curBirthDate = new Date() ;
        try
        {
            curBirthDate = dateFormat.parse( birthDateStr ) ;
        } catch ( Exception exception )
        {
            exception.printStackTrace() ;
        }

        calendar.setTime( curBirthDate ) ;
        int curYear = calendar.get( Calendar.YEAR ) ;
        int curMonth = calendar.get( Calendar.MONTH ) ;
        int curDay = calendar.get( Calendar.DAY_OF_MONTH ) ;

        DatePickerDialog dialog = new DatePickerDialog( getContext(), birthDateSetListener, curYear, curMonth, curDay ) ;
        dialog.show() ;
    }

    private DatePickerDialog.OnDateSetListener birthDateSetListener = new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth )
        {
            Calendar selectedCalendar = Calendar.getInstance() ;
            selectedCalendar.set( Calendar.YEAR, year ) ;
            selectedCalendar.set( Calendar.MONTH, monthOfYear ) ;
            selectedCalendar.set( Calendar.DAY_OF_MONTH, dayOfMonth ) ;

            Date curDate = selectedCalendar.getTime() ;
            setSelectedDate( curDate ) ;
        }
    } ;

    private void setSelectedDate( Date curDate )
    {
        selectedDate = curDate ;
        String selectedDateStr = dateFormat.format( curDate ) ;
        birthButton.setText( selectedDateStr ) ;
    }
}
