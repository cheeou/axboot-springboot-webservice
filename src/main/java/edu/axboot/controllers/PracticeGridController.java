package edu.axboot.controllers;

import com.chequer.axboot.core.api.response.Responses;
import com.chequer.axboot.core.controllers.BaseController;
import com.chequer.axboot.core.parameter.RequestParams;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import edu.axboot.domain.practice.EducationPractice;
import org.springframework.stereotype.Controller;
import com.chequer.axboot.core.api.response.ApiResponse;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.axboot.domain.practice.EducationPracticeService;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping(value = "/api/v1/practicegrid")
public class PracticeGridController extends BaseController {

    @Inject
    private EducationPracticeService educationPracticeService;

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "company", value = "회사명", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ceo", value = "대표자", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "bizno", value = "사업자번호", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "useYn", value = "사용여부", dataType = "String", paramType = "query")
    })
    public Responses.ListResponse list(RequestParams<EducationPractice> requestParams) {
        List<EducationPractice> list = educationPracticeService.gets(requestParams);
        return Responses.ListResponse.of(list);
    }

    @RequestMapping(method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse save(@RequestBody List<EducationPractice> request) {
        educationPracticeService.save(request);
        return ok();
    }


    // GET

    /*public Responses.ListResponse listQueryDsl(RequestParams<EducationPractice> requestParams) {
        List<EducationPractice> list = educationPracticeService.getByQueryDsl(requestParams);
        return Responses.ListResponse.of(list);
    }

    // PUT
    @RequestMapping(value = "/queryDslCrud", method = {RequestMethod.PUT}, produces = APPLICATION_JSON)
    public ApiResponse crud(@RequestBody List<EducationPractice> practice) {
        educationPracticeService.saveOneByQueryDsl(practice);
        return ok();
    }*/


}