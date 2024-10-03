package org.tivit.api.disassembler;

public interface InputDisassembler<T, R> {

    T toObjectModel(R input);
}
