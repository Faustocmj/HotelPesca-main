package com.hotelaria.projetohotelpesca.converters;

import com.hotelaria.projetohotelpesca.enums.CategoriaQuarto;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CategoriaQuartoConverter implements AttributeConverter<CategoriaQuarto, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CategoriaQuarto attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCodigo();
    }

    @Override
    public CategoriaQuarto convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return CategoriaQuarto.valueOf(dbData);
    }
}
