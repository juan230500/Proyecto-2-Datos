package GUI;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrey
 */
public class InfoLayoutTest {

    @Test
    public void testSetInfo() {
        String test = "test";
        InfoLayout instance = new InfoLayout();
        instance.setInfo(test);
        // TODO review the generated test code and remove the default call to fail.
        if (!(test).equals(instance.info.getText())) {
            fail("The test case is a prototype.");
        }
    }

}