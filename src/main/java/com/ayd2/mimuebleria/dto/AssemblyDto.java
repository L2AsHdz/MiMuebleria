package com.ayd2.mimuebleria.dto;

import com.ayd2.mimuebleria.dto.AssemblyDetailDto;
import com.ayd2.mimuebleria.model.Assembly;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Assembly}
 */
@Value
public class AssemblyDto implements Serializable {
    String name;
    String instructions;
    String description;
    Set<AssemblyDetailDto> assemblyDetails;
}