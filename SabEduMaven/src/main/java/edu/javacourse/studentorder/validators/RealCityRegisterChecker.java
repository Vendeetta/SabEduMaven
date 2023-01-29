package edu.javacourse.studentorder.validators;

import edu.javacourse.studentorder.config.Config;
import edu.javacourse.studentorder.domain.register.CityRegisterRequest;
import edu.javacourse.studentorder.domain.register.CityRegisterResponse;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.exception.CityRegisterException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class RealCityRegisterChecker implements CityRegisterChecker{
    public CityRegisterResponse checkPerson(Person person) throws CityRegisterException {

        CityRegisterResponse res = null;
        try {
            CityRegisterRequest request = new CityRegisterRequest(person);
            Client client = ClientBuilder.newClient();
            res = client.target(Config.getProperty(Config.CR_URL)).request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(request, MediaType.APPLICATION_JSON))
                    .readEntity(CityRegisterResponse.class);
        } catch (Exception e) {
            throw new CityRegisterException(e);
        }

        return res;
    }

}
