package pl.sda.school.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.sda.AppController;
import pl.sda.model.Parent;
import pl.sda.school.iservice.IParentService;

import java.util.*;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class ParentService implements IParentService {

    private static final Logger logger = getLogger(AppController.class);
    private RestTemplate restTemplate;

    @Value("${school.server.port}")
    private String port;

    @Value("${school.server.address}")
    private String address;

    @Autowired
    public ParentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Parent> findAll() {
        List<Parent> parentList = new ArrayList<>();
        String PARENT_URL = address + port + "/parent/findAll";

        try {
            logger.debug(PARENT_URL);
            ResponseEntity<Parent[]> parents = restTemplate.getForEntity(PARENT_URL, Parent[].class);
            logger.info(parents.toString());
            if (parents.getBody() != null && parents.getBody().length != 0) {
                Parent[] parent = parents.getBody();
                Collections.addAll(parentList, parent);
            }
            return parentList;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return parentList;
    }

    @Override
    public Parent findParentById(Integer id) {
        Parent parent = new Parent();
        Map<String, String> params = new HashMap<>();
        String PARENT_BY_ID_URL = address + port + "/parent/find/id/{id}";
        params.put("id", id.toString());

        try {
            logger.debug(PARENT_BY_ID_URL);
            parent = restTemplate.getForObject(PARENT_BY_ID_URL, Parent.class, params);
            logger.info(parent.toString());
            return parent;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return parent;
    }

    @Override
    public List<Parent> findParentsByFirstName(String firstName) {
        List<Parent> parentList = new ArrayList<>();
        Map<String, String> params = new HashMap<>();
        String PARENT_BY_FIRST_NAME_URL = address + port + "/parent/find/name/{firstName}";
        params.put("firstName", firstName);

        try {
            logger.debug(PARENT_BY_FIRST_NAME_URL);
            ResponseEntity<Parent[]> parents = restTemplate.getForEntity(PARENT_BY_FIRST_NAME_URL, Parent[].class, params);
            logger.info(parents.toString());
            if (parents.getBody() != null && parents.getBody().length != 0) {
                Parent[] parent = parents.getBody();
                Collections.addAll(parentList, parent);
            }
            return parentList;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return parentList;
    }

    @Override
    public List<Parent> findParentsByLastName(String surname) {
        List<Parent> parentBySurnameList = new ArrayList<>();
        Map<String, String> params = new HashMap<>();
        String PARENT_BY_LAST_NAME_URL = address + port + "/parent/find/surname/{surname}";
        params.put("surname", surname);

        try {
            logger.debug(PARENT_BY_LAST_NAME_URL);
            ResponseEntity<Parent[]> parents = restTemplate.getForEntity(PARENT_BY_LAST_NAME_URL, Parent[].class, params);
            logger.info(parents.toString());
            if (parents.getBody() != null && parents.getBody().length != 0) {
                Parent[] parent = parents.getBody();
                Collections.addAll(parentBySurnameList, parent);
            }
            return parentBySurnameList;
        } catch (HttpClientErrorException e) {
            logger.error(String.valueOf(e));
        }
        return parentBySurnameList;
    }

    @Override
    public void save(Parent parent) {
        //todo add Parent to repository
    }
}
