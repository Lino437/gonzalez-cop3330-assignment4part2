package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConditionsManagerTest {

    @Test
    void validateDoneForYes() {
        assertEquals(false, ConditionsManager.validateDone("yes"));
    }
    @Test
    void validateDoneForNo() {
        assertEquals(false, ConditionsManager.validateDone("no"));
    }
    @Test
    void validateDoneForNull() {
        assertEquals(true, ConditionsManager.validateDone(""));
    }
    @Test
    void validateDoneForValidString() {
        assertEquals(true, ConditionsManager.validateDone("Hello World"));
    }


    @Test
    void validateDescriptionForNullValue() {
        assertEquals(true, ConditionsManager.validateDescription(""));

    }
    @Test
    void validateDescriptionForValidString() {
        assertEquals(false, ConditionsManager.validateDescription("Hello World"));
    }
    @Test
    void validateDescriptionForStringAbove256Characters() {
        assertEquals(true, ConditionsManager.validateDescription(AlertManager.helpText()));
    }


    @Test
    void validateDateForValidDateTodayDate() {
        assertEquals(false, ConditionsManager.validateDate("2021-07-16"));
    }
    @Test
    void validateDateForInvalidDateWithinGregorianCalendar() {
        assertEquals(true, ConditionsManager.validateDate("2021-16-07"));
    }

    @Test
    void validateDateForInvalidDateFormat() {
        assertEquals(true, ConditionsManager.validateDate("hello"));
    }
    @Test
    void validateDateForInvalidDateNullException() {
        assertEquals(true, ConditionsManager.validateDate(""));
    }
}