package ruby.csvfile;

import org.apache.commons.io.FilenameUtils;
import ruby.csvfile.exception.CSVFileExtensionException;
import ruby.csvfile.exception.CSVFileIOException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVFile {

    private static final String EXTENSION = "csv";
    private final File file;
    private int startRow;
    private Integer endRow;

    public CSVFile(File file) {
        this.file = file;
    }

    public CSVFile(File file, int startRow) {
        this.file = file;
        this.startRow = startRow;
    }

    public CSVFile(File file, int startRow, Integer endRow) {
        this.file = file;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    public List<List<String>> convertToData() {
        if (!isCSVFile()) {
            throw new CSVFileExtensionException();
        }

        List<List<String>> data = new ArrayList<>();

        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader br = new BufferedReader(inputStreamReader)
        ){
            String line;
            int row = 0;
            while((line = br.readLine()) != null){
                if (isEndState(row)) {
                    break;
                }

                if (isStartMoreThanState(row)) {
                    List<String> rowData = convertToRowData(line);
                    data.add(rowData);
                }

                row++;
            }
        } catch (IOException e) {
            throw new CSVFileIOException();
        }

        return data;
    }

    private boolean isCSVFile() {
        return file != null && file.isFile() && FilenameUtils.getExtension(file.getName()).equals(EXTENSION);
    }

    private boolean isEndState(int row) {
        return endRow != null && row > endRow;
    }

    private boolean isStartMoreThanState(int row) {
        return row >= startRow;
    }

    private List<String> convertToRowData(String line) {
        return List.of(line.split(","));
    }
}
