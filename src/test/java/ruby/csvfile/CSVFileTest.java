package ruby.csvfile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ruby.csvfile.exception.CSVFileExtensionException;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CSVFileTest {

    @Test
    @DisplayName("CSV 파일 변환 테스트")
    void testConvertToData() {
        File file = new File("/Users/ruby/Desktop/java/project/csvfile/src/test/resources/testData.csv");

        CSVFile csvFile = new CSVFile(file);
        List<List<String>> data = csvFile.convertToData();

        assertThat(data.size()).isGreaterThan(0);
        System.out.println("data size = " + data.size());
    }

    @Test
    @DisplayName("확장자가 csv 가 아닌 파일을 변환")
    void testConvertToDataByNotCSVFile() {
        File file = new File("/Users/ruby/Desktop/java/project/csvfile/src/test/resources/testData.numbers");

        CSVFile csvFile = new CSVFile(file);
        assertThatThrownBy(csvFile::convertToData).hasMessage(CSVFileExtensionException.MESSAGE);
    }
}