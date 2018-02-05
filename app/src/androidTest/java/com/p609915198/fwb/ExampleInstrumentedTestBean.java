package com.p609915198.fwb;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import com.p609915198.fwb.mvp.ui.activity.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTestBean extends ActivityInstrumentationTestCase2<MainActivity> {
    public ExampleInstrumentedTestBean(Class<MainActivity> activityClass) {
        super(activityClass);
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.p609915198.project", appContext.getPackageName());
    }
}
