package vn.jupiter.simpletestproject.test.activities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import vn.jupiter.simpletestproject.StringUtils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Jupiter (vu.cao.duy@gmail.com) on 8/6/14.
 */
@Config(manifest="src/main/AndroidManifest.xml", emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class StringUtilsTest {

    @Test
    public void testEmptyString() {
        assertFalse("Empty string should return false", StringUtils.isNotEmpty(""));
    }
    @Test
    public void testStringWithSpaces() {
        assertFalse("String with spaces should return false", StringUtils.isNotEmpty("    "));
    }

    @Test
    public void testNotNullString() {
        assertTrue(StringUtils.isNotEmpty("abc"));
    }

    @Test
    public void testStringWithLeadingSpaces() {
        assertTrue(StringUtils.isNotEmpty("    abc"));
    }

    @Test
    public void testStringWithTrailingSpaces() {
        assertTrue(StringUtils.isNotEmpty("abc   "));
    }

    @Test
    public void testNullString() {
        assertFalse(StringUtils.isNotEmpty(null));
    }

}
