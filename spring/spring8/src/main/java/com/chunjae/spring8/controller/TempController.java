package com.chunjae.spring8.controller;

import com.chunjae.spring8.dto.TempDTO;
import com.chunjae.spring8.service.TempService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class TempController {
    private TempService service;
    public TempController(TempService service){
        this.service=service;
    }
    @GetMapping("/emplist/{did}")
    public @ResponseBody List<TempDTO> emplist(@PathVariable int did){
        return service.findTempList(did);
    }
    /* 이걸 정적으로 리턴하면 url 통해 들어갈 시 json 형태의 새 창으로 볼 수 있는데
       fetch 요청으로는 res.json()으로 받으면 되고, Accept type 은 지정된 MiME type 으로 정해주면 된다.
       @ResponseBody 가 지정된 MiME type 으로 리턴값을 만들어 주기 때문.
    */

    @PostMapping("/insertemp/{did}")
    public @ResponseBody HashMap<String, Object>
    insertEmp(@PathVariable int did
            , @RequestBody HashMap<String,Object> hm) {
        hm.put("department_id",did);
        Logger logger = LoggerFactory.getLogger("TempController.class");
        logger.info("from insertemp: {}",hm.get("first_name"));
        logger.info("from insertemp: {}",hm.get("salary"));
        logger.info("from insertemp: {}",hm.get("department_id"));
        int result = service.insertTemp(hm);
        return hm;
    }
}

