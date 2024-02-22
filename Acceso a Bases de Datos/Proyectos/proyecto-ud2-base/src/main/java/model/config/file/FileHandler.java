package model.config.file;

public interface FileHandler {
    FileData read() throws Exception;

    void write(FileData paramFileData) throws Exception;
}
