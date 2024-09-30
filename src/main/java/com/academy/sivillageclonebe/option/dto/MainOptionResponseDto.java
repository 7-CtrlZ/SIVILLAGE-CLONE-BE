package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.entity.MainOption;
import com.academy.sivillageclonebe.option.vo.MainOptionResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.academy.sivillageclonebe.option.entity.QMainOption.mainOption;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MainOptionResponseDto {

    private Long mainOptionId;
    private String mainOptionName;

    public MainOptionResponseVo toVo() {
        return MainOptionResponseVo.builder()
                .mainOptionId(mainOptionId)
                .mainOptionName(mainOptionName)
                .build();
    }
    public static MainOptionResponseDto from(MainOption mainOption) {
        return MainOptionResponseDto.builder()
                .mainOptionId(mainOption.getId())
                .mainOptionName(mainOption.getMainOptionName())
                .build();
    }
}
