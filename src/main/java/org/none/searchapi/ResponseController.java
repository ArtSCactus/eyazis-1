package org.none.searchapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * @author ArtSCactus
 * @version 1.0
 */
@RestController
public class ResponseController {
    @Autowired
    private SearchService service;
    @RequestMapping(path="/search", method = RequestMethod.POST)
public SearchResponse getResponse(@RequestBody RequestParams params) throws IOException, GeneralSecurityException {
            return service.search(params);
    }
}
