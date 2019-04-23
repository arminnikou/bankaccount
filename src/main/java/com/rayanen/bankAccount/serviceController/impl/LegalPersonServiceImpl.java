package com.rayanen.bankAccount.serviceController.impl;

import com.rayanen.bankAccount.dto.LegalPersonDto;
import com.rayanen.bankAccount.dto.ResponseDto;
import com.rayanen.bankAccount.dto.ResponseException;
import com.rayanen.bankAccount.dto.ResponseStatus;
import com.rayanen.bankAccount.model.dao.LegalPersonDao;
import com.rayanen.bankAccount.model.entity.LegalPerson;
import com.rayanen.bankAccount.restController.LegalPersonRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Objects;


@Component
public class LegalPersonServiceImpl {

    private static Logger logger= LoggerFactory.getLogger(LegalPersonRestController.class);



    private LegalPersonDao legalPersonDao;

    public LegalPersonServiceImpl(LegalPersonDao legalPersonDao) {
        this.legalPersonDao = legalPersonDao;

    }

    public ResponseDto<String> saveLegal( @RequestBody LegalPerson legalPerson) {
        logger.info("startSaveLegalService");
        Boolean report = legalPersonDao.existsByCompanyCode(legalPerson.getCompanyCode());

        if(!report) {
            if ( Objects.isNull(legalPerson.getName()) || legalPerson.getName().length() < 2) {
                logger.error("name save legal error");
                return new ResponseDto<>(ResponseStatus.Error, null, null, new ResponseException("نام وارد شده صحیح نمی باشد"));
            }
            if ( Objects.isNull(legalPerson.getManeger()) || legalPerson.getManeger().length() < 2) {
                logger.error("maneger save legal error");
                return new ResponseDto<>(ResponseStatus.Error, null, null, new ResponseException("نام مدیر صحیح نمی باشد"));
            }
            if ( Objects.isNull(legalPerson.getCompanyCode()) || legalPerson.getCompanyCode().length() == 10 ) {
                logger.error("CompanyCode save legal error");
                return new ResponseDto<>(ResponseStatus.Error, null, null, new ResponseException("کدثبتی شرکت صحیح نمی باشد"));
            }

            logger.info("endSaveLegalService");
        }else{
            return new ResponseDto<>(ResponseStatus.Error, null, null, new ResponseException("کدثبتی شرکت موجود می باشد"));
        }

        return new ResponseDto<>(ResponseStatus.Ok, null, "اطلاعات ذخیره شد.", null);
    }


    public ResponseDto<String> updateLegal(@RequestBody LegalPerson legalPerson) {
        logger.info("startUpdateLegalService");
        Boolean report = legalPersonDao.existsByCompanyCode(legalPerson.getCompanyCode());
        if(report){
            if ( Objects.isNull(legalPerson.getName()) || legalPerson.getName().length() < 2) {
                logger.error("name error");
                return new ResponseDto<>(ResponseStatus.Error, null, null, new ResponseException("نام وارد شده صحیح نمی باشد"));
            }
            if (Objects.isNull(legalPerson.getManeger()) || legalPerson.getManeger().length() < 2) {
                logger.error("Maneger error");
                return new ResponseDto<>(ResponseStatus.Error, null, null, new ResponseException("نام مدیر صحیح نمی باشد"));
            }
            if ( Objects.isNull(legalPerson.getCompanyCode()) || legalPerson.getCompanyCode().length() == 10 )  {
                logger.error("CompanyCode error");
                return new ResponseDto<>(ResponseStatus.Error, null, null, new ResponseException("کدثبتی شرکت صحیح نمی باشد"));
            }
            logger.info("endUpdateLegalService");
            return new ResponseDto<>(ResponseStatus.Ok, null, "اطلاعات ذخیره شد.", null);
        }
        return new ResponseDto(ResponseStatus.Error, null, null, new ResponseException("کد ثبتی شرکت مورد نظر را نمی توانید تغییر دهید."));
    }


    public ResponseDto<LegalPerson> findLegal(@RequestBody LegalPerson legalPerson) {
       LegalPerson legalPersonDaoByCompanyCode= legalPersonDao.findByCompanyCode(legalPerson.getCompanyCode());

        logger.info("startFindingLegalService");
        if (Objects.isNull(legalPersonDaoByCompanyCode)) {
            logger.error("not found legal");
            return new ResponseDto<>(ResponseStatus.Error, null, null, new ResponseException("شخصی با این مشخصات یافت نشد"));
        }
        logger.info("endFindingLegalService");
        return new ResponseDto(ResponseStatus.Ok, legalPersonDaoByCompanyCode, null, null);
    }


    public ResponseDto<List<LegalPerson>> findLegalAll(@RequestBody LegalPerson legalPerson) {
        logger.info("startFindingAllLegalService");
        List<LegalPerson> result = legalPersonDao.findByNameAndCompanyCode(legalPerson.getName(), legalPerson.getCompanyCode());
        logger.info("endFindingAllLegalService");
        return new ResponseDto(ResponseStatus.Ok, result, null, null);
    }


    public ResponseDto<String> deleteLegalAccount(@RequestBody LegalPerson legalPerson) {
        logger.info("startLegalUpdateRestController");
//       legalPerson.getBankAccounts().get();

        logger.info("endLegalUpdateRestController");
        return new ResponseDto<>(ResponseStatus.Ok, null, "حساب مسدود شد", null);    }




}
