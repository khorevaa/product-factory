package ru.pf.repository;

import ru.pf.entity.Cr;

/**
 * Репозиторий "Хранилища конфигураций"
 * @author a.kakushin
 */
public interface CrRepository extends PfRepository<Cr, Long> {

    @Override
    default Cr newInstance() {
        return new Cr();
    }
}
