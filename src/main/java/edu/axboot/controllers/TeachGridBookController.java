package edu.axboot.controllers;

import com.chequer.axboot.core.api.response.ApiResponse;
import com.chequer.axboot.core.controllers.BaseController;
import edu.axboot.controllers.dto.EducationResponseDto;
import edu.axboot.controllers.dto.EducationSaveRequestDto;
import edu.axboot.controllers.dto.EducationUpdateRequestDto;
import edu.axboot.domain.education.book.EducationBookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TeachGridBookController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(TeachGridBookController.class);

    private final EducationBookService educationBookService;

    @PostMapping("/api/v1/education/teachGridBook")
    public ApiResponse save(@RequestBody EducationSaveRequestDto requestDto) {
        educationBookService.save(requestDto);
        return ok();
    }

    @PutMapping("/api/v1/education/teachGridBook/{id}")
    public ApiResponse update(@PathVariable Long id, @RequestBody EducationUpdateRequestDto requestDto) {
        educationBookService.update(id, requestDto);
        return ok();
    }

    @GetMapping("/api/v1/education/teachGridBook/{id}")
    public EducationResponseDto findById(@PathVariable Long id) {
        return educationBookService.findById(id);
    }



}
