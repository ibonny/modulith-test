package personal.bonnycasi.modulithtest.base.module2.internal;

import org.springframework.stereotype.Service;

@Service
public class SecondInternalService {
    public String hiddenFunction() {
        return "This is a hidden string.";
    }
}
