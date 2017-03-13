/**
 * This example is based on example from the book:
 * <p>
 * Pragmatic Unit Testing in Java with JUnit by: Andy Hunt Dave Thomas
 * <p>
 * All rights belong to the authors of the book.
 */
package transition.technologies.unittesting.basic.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class FaxScheduler {

    private enum Area {
        A("12"), B("23"), C("34");

        private String name;

        private Area(String s) {
            name = s;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * Send the named file as a fax to the given phone number.
     */
    public boolean sendFax(String phone, String filename) throws MissingOrBadFileException, PhoneFormatException, PhoneAreaCodeException {
        if (filename != null) {
            if (correctPhoneNumber(phone)) {
                List<String> allAreas = Arrays.asList(Area.A.toString(), Area.B.toString(), Area.C.toString());
                if (!allAreas.contains(phone.substring(0, 2))) {
                    throw new PhoneAreaCodeException();
                }
                return true;
            } else {
                throw new PhoneFormatException();
            }
        } else {
            throw new MissingOrBadFileException();
        }

    }

    private boolean correctPhoneNumber(String phone) {
        return Pattern.matches("[0-9]{2}-[0-9]{7}", phone);
    }

}
