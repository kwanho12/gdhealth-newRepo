package com.tree.gdhealth.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

/**
 * @author 정인호
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SportsEquipment {
	
    private int sportsEquipmentNo;
    private int employeeNo;
    
    @Size(min = 2, max = 15, message = "물품 이름은 2~15자로 입력 가능합니다.")
    private String itemName;
    
    @Max(value = 100000000, message = "설정 가능한 물품의 최대 가격은 1억입니다.")
    @PositiveOrZero(message = "물품 가격은 0 이상이어야 합니다.")
    @NotNull(message = "물품 가격을 입력해주세요.")
    private Integer itemPrice;
    
    @Size(max = 40, message = "비고는 최대 40자까지 입력 가능합니다.")
    private String note;
    
    private LocalDateTime createdate;
    private LocalDateTime updatedate;
}
