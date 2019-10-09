package ua.training.taxsystem.util.parsers;

import ua.training.taxsystem.util.exceptions.FileParsingException;

@FunctionalInterface
public interface FileParser<T> {
    T parseFile(String fileContent) throws FileParsingException;
}
