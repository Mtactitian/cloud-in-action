package com.alexb.employeeservice.converters;

import com.alexb.employeeservice.model.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, Character> {

    @Override
    public Character convertToDatabaseColumn(Gender attribute) {
        switch (attribute) {
            case MALE:
                return 'M';
            case FEMALE:
                return 'F';
            default:
                return 'M';
        }
    }

    @Override
    public Gender convertToEntityAttribute(Character dbData) {
        switch (dbData) {
            case 'M':
                return Gender.MALE;
            case 'F':
                return Gender.FEMALE;
            default:
                return Gender.MALE;
        }
    }
}
