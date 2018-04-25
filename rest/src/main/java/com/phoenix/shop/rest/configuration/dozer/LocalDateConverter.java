package com.phoenix.shop.rest.configuration.dozer;

import org.dozer.DozerConverter;

import java.time.LocalDate;

public class LocalDateConverter extends DozerConverter<LocalDate, LocalDate> {

    public LocalDateConverter() {
        super(LocalDate.class, LocalDate.class);
    }

    @Override
    public LocalDate convertTo(final LocalDate source, final LocalDate destination) {
        return convert(source, destination);
    }

    @Override
    public LocalDate convertFrom(final LocalDate source, final LocalDate destination) {
        return convert(source, destination);
    }

    private LocalDate convert(final LocalDate source, final LocalDate destination) {
        return LocalDate.of(source.getYear(), source.getMonth(), source.getDayOfMonth());
    }
}
