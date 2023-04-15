package ruby.csvfile.exception;

public class CSVFileExtensionException extends RuntimeException{

    public static String MESSAGE = "파일 형식이 csv 형식이 아닙니다.";

    public CSVFileExtensionException() {
        super(MESSAGE);
    }
}
