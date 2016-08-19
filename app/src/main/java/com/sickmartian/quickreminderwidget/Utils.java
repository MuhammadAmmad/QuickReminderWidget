package com.sickmartian.quickreminderwidget;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.view.ContextThemeWrapper;
import android.widget.Toast;

import org.joda.time.LocalDateTime;

/**
 * Created by ***REMOVED*** on 8/12/16.
 */
public class Utils {
    public static LocalDateTime getNow() {
        return LocalDateTime.now();
    }

    public static int getAppSmallIcon() {
        int smallIcon = R.drawable.ic_alarm_on_black_24dp;
        return smallIcon;
    }

    private static boolean isBetweenAndroidVersions(int min, int max) {
        return Build.VERSION.SDK_INT >= min && Build.VERSION.SDK_INT <= max;
    }

    private static boolean isBrokenSamsungDevice() {
        return (Build.MANUFACTURER.equalsIgnoreCase("samsung")
                && isBetweenAndroidVersions(
                Build.VERSION_CODES.LOLLIPOP,
                Build.VERSION_CODES.LOLLIPOP_MR1));
    }

    public static DatePickerDialog getDatePickerDialog(Context context, DatePickerDialog.OnDateSetListener onDateSetListener, int year, int month, int day) {
        if (isBrokenSamsungDevice()) {
            context = new ContextThemeWrapper(context, android.R.style.Theme_Holo_Light_Dialog);
            return new DatePickerDialog(context,
                    onDateSetListener,
                    year, month, day);
        } else {
            return new DatePickerDialog(context,
                    onDateSetListener,
                    year, month, day);
        }
    }

    public static TimePickerDialog getTimePickerDialog(Context context,
                                                       TimePickerDialog.OnTimeSetListener onTimeSetListener,
                                                       int hour, int minute, boolean is24HourFormat) {
        return new TimePickerDialog(context,
                onTimeSetListener,
                hour, minute,
                is24HourFormat);
    }

    public static void toastTo(final String toastMessage) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(App.getAppContext(),
                        toastMessage,
                        Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}
