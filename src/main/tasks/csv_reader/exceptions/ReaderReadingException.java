package tasks.csv_reader.exceptions;

public class ReaderReadingException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Failed to read from provided Reader!";
    }
}
