package com.hualala.openapiPlatform.service.impl;

import com.hualala.openapiPlatform.mapper.BfPredictMapper;
import com.hualala.openapiPlatform.mapper.PredictMapper;
import com.hualala.openapiPlatform.model.dto.BfPredict;
import com.hualala.openapiPlatform.model.dto.BfPredictExample;

import com.hualala.openapiPlatform.model.dto.Predict;
import com.hualala.openapiPlatform.model.dto.PredictExample;
import com.hualala.openapiPlatform.service.BDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2019/5/11. This is the service implement, the controller uses the functions of here, and
 *
 */
@Service("bdService")
public class BDserviceImpl implements BDService {
    Logger logger = LoggerFactory.getLogger(BDserviceImpl.class);

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    BfPredictMapper bfPredictMapper;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    PredictMapper predictMapper;


    /**
     * resorting the list according to one or more of the attributes, so we can get the top 10 or 20
     * poverty-county after resorting the information we get from the database
     * @param list
     */
    @SuppressWarnings("unchecked")
    public static void sortIntMethod(List list){
        Collections.sort(list, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                BfPredict stu1=(BfPredict) o1;
                BfPredict stu2=(BfPredict) o2;
                Float x = Float.parseFloat(stu1.getPovertyrate()) - Float.parseFloat(stu2.getPovertyrate());
                if(x > 0){
                    return -1;
                }else if(x == 0){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
        System.out.println("/////////////after resorting///////////////");
        for (Object aList : list) {
            BfPredict st = (BfPredict) aList;
//            System.out.println("st.age="+st.getAge()+",st.name="+st.getName());
        }
    }

    //get all the information of the county
    public List<BfPredict> getAllBf() {
        try {
            BfPredictExample bfPredictExample = new BfPredictExample();
            bfPredictExample.createCriteria().andStatusEqualTo(1);
            List<BfPredict> list = bfPredictMapper.selectByExample(bfPredictExample);
            sortIntMethod(list);
            if (list == null || list.size() <= 0) {
                return null;
            }
            return list;
        } catch (Exception e) {
            logger.error("Bf findAll error", e);
            throw e;
        }
    }

    // get the information of one county
    public BfPredict getABf(String countyName) {
        try {
            BfPredictExample bfPredictExample = new BfPredictExample();
            bfPredictExample.createCriteria().andCountynameEqualTo(countyName);
            List<BfPredict> list = bfPredictMapper.selectByExample(bfPredictExample);
            System.out.println(list.size());
            System.out.println("******");
            return list.get(0);
        } catch (Exception e) {
            logger.error("get A Bf  error", e);
            throw e;
        }
    }

    // insert information to the database
    public Integer insertBf(BfPredict bfPredict) {
        try {
            Integer countId = bfPredictMapper.insert(bfPredict);
            return countId;
        } catch (Exception e) {
            logger.error("insertBf error", e);
            throw e;
        }
    }


    public Predict getAPredict(String countyName) {
        try {
            PredictExample predictExample = new PredictExample();
            predictExample.createCriteria().andCountynameEqualTo(countyName);
            List<Predict> list = predictMapper.selectByExample(predictExample);
            System.out.println(list.size());
            System.out.println("******");
            return list.get(0);
        } catch (Exception e) {
            logger.error("get A Predict  error", e);
            Predict predict = new Predict();
            predict.setError("100");
            predict.setCountyname(countyName);
            predict.setPredict("100");
            return predict;
        }
    }

    // insert information to the database
    public Integer insertPredict(Predict predict) {
        try {
            Integer countId = predictMapper.insert(predict);
            return countId;
        } catch (Exception e) {
            logger.error("insertPredict error", e);
            throw e;
        }
    }

}



