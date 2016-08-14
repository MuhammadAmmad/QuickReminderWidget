package com.sickmartian.quickalarmwidget;

import com.sickmartian.quickalarmwidget.data.model.Alarm;

import org.joda.time.Duration;
import org.joda.time.LocalDateTime;
import org.parceler.Parcel;

import java.io.Serializable;

/**
 * Created by ***REMOVED*** on 8/13/16.
 */
@Parcel
public class AlarmIntentionData {
    Serializable timeObject;
    Alarm alarm;

    public AlarmIntentionData() { }

    public AlarmIntentionData(Serializable timeObject, Alarm alarm) {
        this.timeObject = timeObject;
        this.alarm = alarm;
    }

    public Alarm getAlarm() {
        return alarm;
    }

    public Serializable getTimeObject() {
        return timeObject;
    }

    public Duration getDuration() {
        return timeObject instanceof Duration ? (Duration) timeObject : null;
    }

    public LocalDateTime getTime() {
        return timeObject instanceof LocalDateTime ? (LocalDateTime) timeObject : null;
    }

    @Override
    public String toString() {
        return "AlarmIntentionData{" +
                "timeObject=" + timeObject +
                ", alarm=" + alarm +
                '}';
    }
}