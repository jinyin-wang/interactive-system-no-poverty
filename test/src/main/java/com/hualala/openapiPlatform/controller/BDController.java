package com.hualala.openapiPlatform.controller;

import com.hualala.openapiPlatform.model.dto.AfCalculate;
import com.hualala.openapiPlatform.model.dto.BfPredict;
import com.hualala.openapiPlatform.model.dto.Predict;
import com.hualala.openapiPlatform.service.BDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2019/5/11, Controller of the project, getting the data from service, while service gets
 * data from Mapper----from MySQL
 */
@Controller
public class BDController {
    private static Logger logger = LoggerFactory.getLogger(BDController.class);
    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private BDService bdService;

    // get All the information from the database of the no-prediction data, then send them to the front page, which will be analysed by javascript
    @RequestMapping(value = "queryAllCounty")
    public String queryAllCounty(ModelMap modelAndView) {
        try {
            logger.info("queryAllCounty");
            List<BfPredict> listCounty = bdService.getAllBf();
            modelAndView.put("listCounty", listCounty.subList(0,10));
            return "queryAllCounty";
        } catch (Exception e) {
            logger.error("queryAllCountyError", e);
                return "queryAllCounty";
            }
        }


    // get the information of one county from the database, then send them to the front page, which will be analysed by
    // javascript, the graph-drawing process is finished by javascript
    @RequestMapping(value = "queryACounty")
    public String queryACounty(String countyName, ModelMap map) {
        BfPredict bfPredict = bdService.getABf(countyName);
        Predict predict = bdService.getAPredict(countyName);
        AfCalculate afCalculate = new AfCalculate();
        double v = Double.parseDouble(bfPredict.getPovertyrate()) - Double.parseDouble(bfPredict.getFoodstamprate());
        if(v > 0){
            String stamp = "enough food stamps";
            afCalculate.setFoodstamp(stamp);
        } else {
            Float x = Float.parseFloat(String.valueOf(-v).substring(0,7));
            String stamp =  (int)(x * Float.parseFloat(bfPredict.getPopulation())) + " food stamps needed";
            afCalculate.setFoodstamp(stamp);
        }

        //get the information of the prediction
        float error = Math.abs(Float.parseFloat(predict.getError()));
        String predictPovertyRate;
        if( error > 10) {
            predictPovertyRate = "predict failed";
        } else {
            predictPovertyRate = predict.getPredict().substring(0,4);
        }
        map.put("county", bfPredict);
        map.put("afCalculate", afCalculate);
        map.put("predictPovertyRate", predictPovertyRate);
        return "queryACounty";
    }
}

