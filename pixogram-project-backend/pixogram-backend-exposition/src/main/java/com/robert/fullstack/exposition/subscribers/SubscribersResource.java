package com.robert.fullstack.exposition.subscribers;

import com.robert.fullstack.application.subscribers.ConsultSubscribers;
import com.robert.fullstack.application.subscribers.RegisterSubscriber;
import com.robert.fullstack.application.subscribers.UnregisterSubscriber;
import com.robert.fullstack.domain.followers.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/subscribers")
public class SubscribersResource {

    @Autowired
    private ConsultSubscribers consultSubscribers;
    @Autowired
    private RegisterSubscriber registerSubscriber;
    @Autowired
    private UnregisterSubscriber unregisterSubscriber;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SubscribedRepresentation>> getAllSubscribers(){
        Set<Subscriber> allSubscribers = consultSubscribers.getAllSubscribers();
        List<SubscribedRepresentation> subscribedRepresentations = allSubscribers.stream().map(SubscribedRepresentation::new).collect(Collectors.toList());
        return new ResponseEntity<>(subscribedRepresentations, HttpStatus.OK);
    }

    @RequestMapping(value = "/add/{subscriberEmail}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addSubscriber(@PathVariable(value = "subscriberEmail") String subscriberEmail){
        registerSubscriber.addSubscriber(subscriberEmail);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/remove/{subscriberEmail}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity removeSubscriber(@PathVariable(value = "subscriberEmail") String subscriberEmail){
        unregisterSubscriber.deleteSubscriber(subscriberEmail);
        return new ResponseEntity(HttpStatus.OK);
    }
}
