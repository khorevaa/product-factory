package ru.pf.service.conf.check;

import org.springframework.stereotype.Service;
import ru.pf.metadata.Method;
import ru.pf.metadata.object.Conf;

import java.util.List;

/**
 * @author a.kakushin
 */
@Service
public class DescriptionMethodCheck {

    /**
     * Проверка наличия описаний (комментариев) к методам в общих модулях
     * @param conf Конфигурация
     * @return список методов
     */
    public List<Method> check(Conf conf) {
        return null;
    }
}