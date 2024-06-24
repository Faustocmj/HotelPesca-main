package com.hotelaria.projetohotelpesca.converters;

import com.hotelaria.projetohotelpesca.enums.Disponibilidade;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DisponibilidadeConverter implements AttributeConverter<Disponibilidade, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Disponibilidade attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getEstado();
    }

    @Override
    public Disponibilidade convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return Disponibilidade.valueOf(dbData);
    }
}
