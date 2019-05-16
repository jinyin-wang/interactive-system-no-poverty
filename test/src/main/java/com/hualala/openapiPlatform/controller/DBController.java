package com.hualala.openapiPlatform.controller;

import com.hualala.openapiPlatform.model.dto.BfPredict;
import com.hualala.openapiPlatform.model.dto.Predict;
import com.hualala.openapiPlatform.service.BDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Administrator on 2019/5/11. a tool to save csv to mysql for this interactive system
 */
@RestController
@RequestMapping("/mydb")
public class DBController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private BDService bdService;

    @RequestMapping("csv")
    public String transSQL() {
//        List<BfPredict> factorsList = readBf();
        List<Predict> predictsList = readPredict();

        return "transfer finished";
    }

    // save the data to sql for queries of no-prediction data
    private List<BfPredict> readBf() {
        try {
            ArrayList<BfPredict> list = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader("D:\\big data\\bf_predict.csv"));// 文件名
            // reader.readLine();
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("***********************8");
                System.out.println(line);
                String item[] = line.split(",");
                BfPredict bfPredict = new BfPredict();
                bfPredict.setCountyname(item[1]);
                bfPredict.setPopulation(item[2]);
                bfPredict.setFoodstamprate(item[3]);
                bfPredict.setPovertyrate(item[4]);
                bfPredict.setMalepovertyrate(item[5]);
                bfPredict.setFemalepovertyrate(item[6]);
                bfPredict.setUnderhighschoolpovertyrate(item[7]);
                bfPredict.setHighschoolpovertyrate(item[8]);
                bfPredict.setCollegepovertyrate(item[9]);
                bfPredict.setBachelorpovertyrate(item[10]);
                bfPredict.setDisabilitycorelation(item[11]);
                bfPredict.setAvghouseagecorelation(item[12]);
                bfPredict.setAvgfueluseagecorelation(item[13]);
                bfPredict.setFulljobcorelation(item[14]);
                bfPredict.setPartjobcorelation(item[15]);
                bfPredict.setNojobcorelation(item[16]);
                bfPredict.setStatus(1);
                Integer id = bdService.insertBf(bfPredict);
                list.add(bfPredict);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    // save the data to sql for queries of the prediction data
    private List<Predict> readPredict() {
        try {
            ArrayList<Predict> list = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader("D:\\big data\\predict.csv"));// 文件名
            // reader.readLine();
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("***********************8");
                String item[] = line.split(",");
                Predict predict = new Predict();
                predict.setCountyname(item[1]);
                predict.setPredict(item[2]);
                predict.setTruepoverty(item[3]);
                predict.setError(item[4]);
                Integer id = bdService.insertPredict(predict);
                list.add(predict);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

}