package com.github.tiggerdine.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueController {

    @Autowired
    private QueueService queueService;

    @PostMapping()
    public ResponseEntity<String> enqueue(@RequestBody String body) {
        queueService.enqueue(body);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Enqueued: " + body);
    }

}
