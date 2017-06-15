package com.sapient.app;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Suraj on 1/18/2017.
 */
public class Application {

    public static void main(String[] args) throws IOException {

        String fileName = "D:/data.csv";
        File file = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        List<String> list = new ArrayList<>();


        try( BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName)) ){
            list = bufferedReader.lines().collect(Collectors.toList());
        }

        list.forEach(x->{
            System.out.println(x);
        });


/*      ********************  Reading Excel File ***********************************************
        ExcelFileService excelFileService = new ExcelFileService();

        String fileName = "D:/data.xlsx";
        File file = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("Sheet1");

        List<ExcelSheetData> listOfRows = new ArrayList<>();
        List<ExcelSheetData> sortedRows = new ArrayList<>();
        xssfSheet.iterator().forEachRemaining(x -> {
            if (x.getRowNum() > 0) {

                ExcelSheetData excelSheetData = getExcelSheetRow(x);
                listOfRows.add(excelSheetData);
            }


        });

        sortedRows = listOfRows.stream().sorted((o1,o2) -> {
            int i=0;
            if((o1.getPriority() < o2.getPriority()) ){
                i=-1;
            } else if(o1.getPriority() > o2.getPriority()){
                i=1;
            } else {
                i=0;
            }

            if(i!=0){
                return i;

            }

            if(!o1.isMale() && o2.isMale()){
                i=-1;
            } else if(!o1.isMale() && !o2.isMale()){
                i=0;
            } else {
                i=1;
            }

            if(i!=0){
                return i;
            }
            i = Long.compare(o1.getId(),o2.getId());

            if(i!=0){
                return i;
            }

            return o1.getName().compareTo(o2.getName());

        }).collect(Collectors.toList());


        Arrays.asList(ExcelColumnNames.values()).stream().forEach(x->{
            System.out.print(String.format("%-20s", x.name()));
        });
        System.out.println();
        sortedRows.forEach(x->{
            System.out.println(String.format("%-20d%-20s%-20s%-20d", x.getId() , x.getName(), getGender(x), x.getPriority()));
        });
*/

/*        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] arr;
        String line;
        int sum =0;
        while ((line = bufferedReader.readLine()) != null) {
            arr = line.split(",");
            sum =0;
            Arrays.asList(arr).forEach((String x) -> {
                System.out.println(x);
            });
        }


        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
        */



/*      *****************************  Blocking Queue Producer Consumer  ***********************************************
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>(10);

        Thread thread1 = new Thread(new ProducerWithBlockingQueue(blockingQueue));
        Thread thread2 = new Thread(new ConsumerWithBlockingQueue(blockingQueue));
        Thread thread3 = new Thread(new ConsumerWithBlockingQueue(blockingQueue));

        thread1.start();
        thread2.start();
        thread3.start();
*/



/* ***************************  Producer Consumer Example  ************************************
       Queue<String> queue = new LinkedList<String>();

        Thread thread1= new Thread(new Producer(queue));
        Thread thread2= new Thread(new Consumer(queue));

        thread1.start();
        thread2.start();
*/


    }

    private static ExcelSheetData getExcelSheetRow(Row x) {
        ExcelSheetData excelSheetData = new ExcelSheetData();
        excelSheetData.setId((long) x.getCell(ExcelColumnNames.ID.ordinal()).getNumericCellValue());
        excelSheetData.setName(x.getCell(ExcelColumnNames.NAME.ordinal()).getStringCellValue());
        excelSheetData.setMale(x.getCell(ExcelColumnNames.GENDER.ordinal()).getBooleanCellValue());
        excelSheetData.setPriority((long) x.getCell(ExcelColumnNames.PRIORITY.ordinal()).getNumericCellValue());
        return excelSheetData;
    }

    private static String getGender(ExcelSheetData x) {
        return x.isMale()? "Male" : "Female";
    }

}
