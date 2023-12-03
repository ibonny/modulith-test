package personal.bonnycasi.modulithtest.base.module1.services;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import personal.bonnycasi.modulithtest.base.CompletedEvent;

@Service
@RequiredArgsConstructor
public class InternalService {
    private final ApplicationEventPublisher events;

    public String someCall() {
        return "This is another string.";
    }

    @Async
    @Transactional
    @EventListener
    void on(CompletedEvent event) {
        System.out.println("Event is: " + event);

        System.out.println("Stage 2.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (event.message().startsWith("response:")) {
            return;
        }

        events.publishEvent(new CompletedEvent("response: Some other message back."));
    }
}
