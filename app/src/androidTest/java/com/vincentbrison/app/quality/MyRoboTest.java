package com.vincentbrison.app.quality;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.robotium.solo.Condition;
import com.robotium.solo.Solo;

import org.mockito.Mockito;

import vb.android.app.quality.ui.MainActivity;
import vb.android.app.quality.pi.PiGenerator;
import vb.android.app.quality.R;

/**
 * Class to test instrumentation testing with the help of robotium.
 */
public class MyRoboTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    public MyRoboTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testUI() {
        solo.waitForActivity(MainActivity.class);
        PiGenerator pi = Mockito.mock(PiGenerator.class);
        Mockito.when(pi.calcPiDigits(5)).thenReturn(3.1415);
/*
        final TextView tv = (TextView) solo.getView(R.id.textView);
        solo.waitForCondition(new Condition() {
            @Override
            public boolean isSatisfied() {
                return tv.isShown();
            }
        }, 5000);

        //assertTrue("TextView should have been set to the flavor name.", tv.getText().toString().equals(Constants.FLAVOR));*/
    }
}
