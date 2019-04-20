package com.rayanen.bankAccount.restController;


import com.rayanen.bankAccount.dto.*;
import com.rayanen.bankAccount.dto.ResponseStatus;
import com.rayanen.bankAccount.facade.Facade;
import com.rayanen.bankAccount.model.entity.RealPerson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class RealPersonRestController {

    private static Logger logger= LoggerFactory.getLogger(RealPersonRestController.class);


Facade facade;

    public RealPersonRestController(Facade facade) {
        this.facade = facade;
    }



    @RequestMapping(value = "ws/saveReal", method = RequestMethod.POST)
    public ResponseDto<String> saveReal(@RequestBody RealPersonDto realPersonDto) {
        logger.info("startRealSaveRestController");
        facade.saveReal(realPersonDto);
            logger.info("endRealSaveRestController");
            return new ResponseDto(ResponseStatus.Ok, null, "اطلاعات ذخیره شد.", null);
        }


    @RequestMapping(value = "ws/updateReal", method = RequestMethod.POST)
    public ResponseDto<String> updateReal(@RequestBody RealPersonDto realPersonDto) {
        logger.info("startUpdateSaveRestController");
        facade.updateReal(realPersonDto);
            logger.info("endUpdateSaveRestController");
            return new ResponseDto(ResponseStatus.Ok, null, "اطلاعات ذخیره شد.", null);
        }


    @RequestMapping(value = "ws/findReal", method = RequestMethod.POST)
    public ResponseDto<RealPerson> findReal(@RequestParam String nationalCode) {
        logger.info("startFindRealRestController");
        facade.findReal(nationalCode);
        logger.info("endFindRealRestController");
        return new ResponseDto(ResponseStatus.Ok, null, null, null);
    }



    @RequestMapping(value = "ws/findRealAll", method = RequestMethod.POST)
    public ResponseDto<List<RealPersonDto>> findLegalAll(@RequestBody RealPersonDto realPersonDto) {
        logger.info("startFindRealAllRestController");
        facade.findRealAll(realPersonDto);
        logger.info("endFindRealAllRestController");
        return new ResponseDto(ResponseStatus.Ok, null, null, null);
    }

//    @RequestMapping(value = "ws/delete" , method =RequestMethod.DELETE)
//public  ResponseDto<Boolean> onDeletePerson(@PathVariable Integer id){
//
//}
}


