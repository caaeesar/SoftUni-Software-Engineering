package _06_;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlarmTest {

    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 21;
    Sensor mockedSensor;
    Alarm alarm;

    @Before
    public void setUp(){
       this.mockedSensor = mock(Sensor.class);
       alarm = new Alarm(mockedSensor);
    }

    @Test
    public void testCheckAlarmShouldBeOn() {
        when(mockedSensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_THRESHOLD - 1);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testCheckAlarmShouldNotBeOn() {
        when(mockedSensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_THRESHOLD);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

}
