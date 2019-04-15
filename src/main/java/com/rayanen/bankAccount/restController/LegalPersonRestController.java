package com.rayanen.bankAccount.restController;


import com.rayanen.bankAccount.dto.*;
import com.rayanen.bankAccount.dto.ResponseStatus;
import com.rayanen.bankAccount.model.dao.LegalPersonDao;
import com.rayanen.bankAccount.model.entity.LegalPerson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController

public class LegalPersonRestController  {

    private static Logger logger= LoggerFactory.getLogger(LegalPersonRestController.class);
    private LegalPersonDao legalPersonDao;


    public LegalPersonRestController(LegalPersonDao legalPersonDao) {
        this.legalPersonDao = legalPersonDao;

    }



        @RequestMapping(value = "ws/saveLegal", method = RequestMethod.POST)
    public ResponseDto<String> saveLegal(@Valid @RequestBody LegalPersonDto legalPersonDto) {
        logger.info("start save legal");



        return new ResponseDto<>(ResponseStatus.Ok, null, "اطلاعات ذخیره شد.", null);
    }





    @RequestMapping(value = "ws/updateLegal", method = RequestMethod.POST)
    public ResponseDto<String> updateLegal(@RequestBody LegalPersonDto legalPersonDto) {
        logger.info("start update legal");

        return new ResponseDto<>(ResponseStatus.Ok, null, "اطلاعات ذخیره شد.", null);    }




    @RequestMapping(value = "ws/findLegal", method = RequestMethod.POST)
    public ResponseDto<LegalPerson> findLegal(@RequestParam String code) {
        LegalPersonDto legalPersonDto = legalPersonDao.findByCompanyCode(code);
//on objecty ke midi behesh ro bar gargon?

        logger.info("finding legal");
        return new ResponseDto(ResponseStatus.Ok, legalPersonDto, null, null);
    }

    @RequestMapping(value = "ws/findLegalAll", method = RequestMethod.POST)
    public ResponseDto<List<LegalPersonDto>> findLegalAll(@RequestBody LegalPersonDto legalPersonDto) {
        List<LegalPersonDto> result = legalPersonDao.findByNameAndCompanyCode(legalPersonDto.getName(), legalPersonDto.getCompanyCode());
        return new ResponseDto(ResponseStatus.Ok, result, null, null);

    }


}
