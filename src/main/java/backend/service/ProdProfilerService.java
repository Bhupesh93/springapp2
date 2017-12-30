package backend.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdProfilerService implements ProfilerService {
    @Override
    public String getProfileName() {
        return "This is Prod profile";
    }
}
