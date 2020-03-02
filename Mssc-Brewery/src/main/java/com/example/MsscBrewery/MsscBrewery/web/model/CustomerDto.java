package com.example.MsscBrewery.MsscBrewery.web.model;

import java.util.UUID;

import javax.validation.constraints.Size;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {

    private UUID id;
    
    @NotBlank
    @Size(min = 3, max = 100)
    private String name;
}