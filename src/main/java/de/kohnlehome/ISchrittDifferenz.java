package de.kohnlehome;

import java.time.LocalDate;

public interface ISchrittDifferenz {
    int maximaleSteigerung(LocalDate startdatum, LocalDate enddatum, String benutzername);
    int maximaleVerminderung(LocalDate startdatum, LocalDate enddatum, String benutzername);
}
