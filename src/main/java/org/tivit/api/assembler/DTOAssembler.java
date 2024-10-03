package org.tivit.api.assembler;

import java.util.Collection;
import java.util.List;

public interface DTOAssembler<T, R> {

    T toDTO(R objectModel);

    List<T> toCollectionDTO(Collection<R> models);
}
