package ru.pf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pf.repository.PropertiesRepository;
import ru.pf.utility.Properties;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author a.kakushin
 */
@Service
public class PropertiesService {

    @Autowired
    PropertiesRepository propertiesRepository;

    public String get(String name) {
        return propertiesRepository.getByName(name)
            .map(item -> item.getValue())
                .orElse(null);
    }

    public Path getStorage() {
        return Paths.get(this.get(Properties.STORAGE));
    }

    public int getCheckNameLength() {
        String saved = this.get(Properties.CHECK_NAME_LENGTH);
        return saved != null ? Integer.valueOf(saved) : 0;
    }
}