package com.javaseleniumtemplate.utils;

import com.javaseleniumtemplate.GlobalParameters;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DataDriven {

    public Iterator<Object []> csvProvider(String csvNamePath) {
        String line = "";
        String cvsSplitBy = ";";
        List<Object[]> testCases = new ArrayList<>();
        String[] data;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csvNamePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            data = line.split(cvsSplitBy);
            testCases.add(data);
        }
        return testCases.iterator();
    }

    @DataProvider(name="dataIssuesCSVProvider")
    public Iterator<Object []> dataPetProvider(){
        return csvProvider(GlobalParameters.FILES_PATH +"dataDrivenIssues.csv");}

}
