package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }

    // Additional Test 1: Not your code, available to others, not coursework, expect false
    @Test
    public void testAvailableCodeNotCoursework() {
        assertFalse("Expected false: publicly available but not coursework",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
    }

    // Additional Test 2: Not your code, available, coursework, cited, expect true
    @Test
    public void testCitedCoursework() {
        assertTrue("Expected true: cited coursework available to others",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }
}
