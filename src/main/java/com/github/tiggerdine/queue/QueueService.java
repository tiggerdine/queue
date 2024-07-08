package com.github.tiggerdine.queue;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class QueueService {

    private static final Duration DELAY = Duration.ofSeconds(1);

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public void enqueue(String body) {
        executor.execute(process(body));
        System.out.println("Enqueued: " + body);
    }

    private static Runnable process(String body) {
        return () -> {
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Processed: " + body);
        };
    }

}
