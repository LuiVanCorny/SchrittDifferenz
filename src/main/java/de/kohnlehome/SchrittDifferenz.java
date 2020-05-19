package de.kohnlehome;

import java.time.LocalDate;

public class SchrittDifferenz implements ISchrittDifferenz {
    private ISchrittzahl schrittzahl;

    public SchrittDifferenz(ISchrittzahl schrittzahl) {
        this.schrittzahl = schrittzahl;
    }

    public int maximaleSteigerung(LocalDate startdatum, LocalDate enddatum, String benutzername){
        return 0;
    }

    public int maximaleVerminderung(LocalDate startdatum, LocalDate enddatum, String benutzername){
        return 0;
    }
}
