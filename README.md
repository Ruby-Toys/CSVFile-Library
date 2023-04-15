## CSVFile
- csv 파일로부터 데이터를 읽어내는 라이브러리

<br>

## API
### CSVFile()
- CSVFile 인스턴스를 생성합니다.
```java
CSVFile csvFile = new CSVFile(file);
```

### convertToData()
- 파일로부터 데이터를 읽어 2차원 List 형태로 반환합니다.
```java
List<List<String>> data = csvFile.convertToData();
```