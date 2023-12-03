package personal.bonnycasi.modulithtest.base.module2;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import personal.bonnycasi.modulithtest.base.CompletedEvent;

@Service
public class Module2Service {
    public String processString() {
        return "Yeah, yeah, yeah.";
    }

    @EventListener
    void on(CompletedEvent second) {
        System.out.println("Got here, too: " + second);
    }
}
