package edu.javacourse.studentorder.validators;

import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.domain.register.CityRegisterResponse;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.exception.CityRegisterException;
import edu.javacourse.studentorder.exception.TransportException;

public class FakeCityRegisterChecker implements CityRegisterChecker{

    private static final String GOOD_1 = "1000";
    private static final String GOOD_2 = "2000";
    private static final String BAD_1 = "1001";
    private static final String BAD_2 = "2001";
    private static final String ERROR_1 = "1002";
    private static final String ERROR_2 = "2002";
    private static final String ERROR_T_1 = "1003";
    private static final String ERROR_T_2 = "2003";
    public CityRegisterResponse checkPerson(Person person) throws CityRegisterException, TransportException {
        CityRegisterResponse crcr = new CityRegisterResponse();
        if (person instanceof Adult){
            Adult t = (Adult) person;
            String ps = t.getPassportSeria();
            if(ps.equals(GOOD_1) || ps.equals(GOOD_2)){
                crcr.setExisting(true);
                crcr.setTemporal(false);
            }
            if (ps.equals(BAD_1) || ps.equals(BAD_2)){
                crcr.setExisting(false);
            }
            if (ps.equals(ERROR_1) || ps.equals(ERROR_2)){
                CityRegisterException ex = new CityRegisterException("1", "GRN Error");
                throw ex;
            }

            if (ps.equals(ERROR_T_1) || ps.equals(ERROR_T_2)){
                TransportException ex = new TransportException("TransportError");
                throw ex;
            }
        }
        return crcr;
    }
}
