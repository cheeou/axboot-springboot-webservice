package edu.axboot.domain.education.book;

import edu.axboot.controllers.dto.EducationResponseDto;
import edu.axboot.controllers.dto.EducationSaveRequestDto;
import edu.axboot.controllers.dto.EducationUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
//public class EducationBookService extends BaseService<EducationBook, Long> {
public class EducationBookService {
    private final EducationBookRepository educationBookRepository;

    @Transactional
    public Long save(EducationSaveRequestDto requestDto) {
        return educationBookRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, EducationUpdateRequestDto requestDto) {
        EducationBook educationBook = educationBookRepository.findOne(id);

        if (educationBook == null) {
            throw new IllegalArgumentException("해당 거래처가 없습니다. id=" + id);
        }

        educationBook.update(requestDto.getTel(), requestDto.getEmail());

        return id;
    }


    public EducationResponseDto findById(Long id) {
        EducationBook entity = educationBookRepository.findOne(id);

        if (entity == null) {
            throw new IllegalArgumentException("해당 거래처가 없습니다. id=" + id);
        }

        return new EducationResponseDto(entity);
    }



}

