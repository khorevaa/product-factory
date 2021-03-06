package ru.pf.metadata.object.common;

import java.nio.file.Path;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.pf.metadata.annotation.CommandModule;
import ru.pf.metadata.object.AbstractMetadataObject;
import ru.pf.metadata.Module;

/**
 * @author a.kakushin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CommonCommand extends AbstractMetadataObject {

    @CommandModule
    private Module commandModule;

    public CommonCommand(Path path) {
        super(path);
    }

    @Override
    public String getListPresentation() {        
        return "Обшие команды";
    }        
}