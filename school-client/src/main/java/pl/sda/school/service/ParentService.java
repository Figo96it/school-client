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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public void save(Parent parent) {
        //todo add Parent to repository
    }
}
