package backend.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"dev","default"})
public class DevProfilerService implements ProfilerService {
    @Override
    public String getProfileName() {
        return "This is Dev profile";
    }
}
