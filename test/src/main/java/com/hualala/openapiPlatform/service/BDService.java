package com.hualala.openapiPlatform.service;

import com.hualala.openapiPlatform.model.dto.BfPredict;
import com.hualala.openapiPlatform.model.dto.Predict;

import java.util.List;

/**
 * This one is just an interface, specific functions are on the BDserviceImpl.class
 * Created by Administrator on 2019/5/11.
 * big data, check the impl info for details
 */
public interface BDService {


    public List<BfPredict> getAllBf();

    public BfPredict getABf(String countyName);

    public Integer insertBf(BfPredict bfPredict);

    public Predict getAPredict(String countyName);

    public Integer insertPredict(Predict predict);

}
