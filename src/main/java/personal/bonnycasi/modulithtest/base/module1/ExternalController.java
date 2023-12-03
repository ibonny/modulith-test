package personal.bonnycasi.modulithtest.base.module1;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import personal.bonnycasi.modulithtest.base.CompletedEvent;
import personal.bonnycasi.modulithtest.base.module1.services.InternalService;
import personal.bonnycasi.modulithtest.base.module2.Module2Service;

@RestController
@RequiredArgsConstructor
public class ExternalController {
    private final ApplicationEventPublisher events;
    private final InternalService internalService;
    private final Module2Service m2Service;

    @GetMapping("/")
    public String rootMap() {
        return "This is a test. " +
                internalService.someCall() + " " +
                m2Service.processString() + " ";
    }

    @Transactional
    @GetMapping("/eventTest")
    public String eventTest() {
        events.publishEvent(new CompletedEvent("Got it."));

        System.out.println("Doing something here.");

        return "Yo.";
    }

    @EventListener
    public void on(CompletedEvent ce) {
        if (ce.message().startsWith("response")) {
            System.out.println("We are here.");
        }
    }
}
