package ru.pf.service.conf.check;

import org.springframework.stereotype.Service;
import ru.pf.metadata.object.AbstractMetadataObject;
import ru.pf.metadata.object.Conf;
import ru.pf.metadata.object.MetadataObject;
import ru.pf.metadata.object.common.Subsystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Поиск объектов метаданных, не включенных в подсистемы
 * @author a.kakushin
 */
@Service
public class SubsystemCheck implements ServiceCheck<MetadataObject> {

    @Override
    public List<MetadataObject> check(Conf conf) {
        List<MetadataObject> result = new ArrayList<>();
        Set<String> included = new HashSet<>();

        for (MetadataObject subsystem : conf.getSubsystems()) {
            included.addAll(((Subsystem) subsystem).getAllItems());
        }

        Set<MetadataObject> objects = conf.getAllObjects();
        for (MetadataObject object : objects) {
            Class<?> objectClass = object.getClass();
            if (!objectClass.equals(Subsystem.class)) {
                String mdRef = object.getXmlName() + "." + ((AbstractMetadataObject) object).getName();
                if (!included.contains(mdRef)) {
                    result.add(object);
                }
            }
        }
        return result;
    }

    @Override
    public String getAlias() {
        return "Не включенные в подсистемы";
    }
}
