package com.sapient.app;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Suraj on 3/17/2017.
 */
public interface IExcelFileService {

    public void readCsvFile (File file) throws FileNotFoundException;

}
