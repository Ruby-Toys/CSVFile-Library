package ruby.csvfile.exception;

public class CSVFileIOException extends RuntimeException{

    public static String MESSAGE = "데이터 변환 중 오류가 발생했습니다.";

    public CSVFileIOException() {
        super(MESSAGE);
    }
}
