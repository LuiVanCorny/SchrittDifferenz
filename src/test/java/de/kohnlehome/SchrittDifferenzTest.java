package de.kohnlehome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


public class SchrittDifferenzTest {
    private ISchrittzahl schrittzahl;
    private SchrittDifferenz schrittDifferenz;

    @BeforeEach
    public void init(){
        // ===== ARRANGE =====
        // Testdouble erstellen
        schrittzahl = mock(ISchrittzahl.class);

        // Verhalten des Testdoubles definieren
        when(schrittzahl.getSchritteFromUser(LocalDate.of(2020, 03, 01), "Korn")).thenReturn(1000);
        when(schrittzahl.getSchritteFromUser(LocalDate.of(2020, 03, 02), "Korn")).thenReturn(1100);
        when(schrittzahl.getSchritteFromUser(LocalDate.of(2020, 03, 03), "Korn")).thenReturn(1050);
        when(schrittzahl.getSchritteFromUser(LocalDate.of(2020, 03, 04), "Korn")).thenReturn(2500);
        when(schrittzahl.getSchritteFromUser(LocalDate.of(2020, 03, 05), "Korn")).thenReturn(100);

        when(schrittzahl.getSchritteFromUser(LocalDate.of(2020, 04, 01), "Fueger")).thenReturn(2400);
        when(schrittzahl.getSchritteFromUser(LocalDate.of(2020, 04, 02), "Fueger")).thenReturn(2333);
        when(schrittzahl.getSchritteFromUser(LocalDate.of(2020, 04, 03), "Fueger")).thenReturn(3100);
        when(schrittzahl.getSchritteFromUser(LocalDate.of(2020, 04, 04), "Fueger")).thenReturn(2800);
        when(schrittzahl.getSchritteFromUser(LocalDate.of(2020, 04, 05), "Fueger")).thenReturn(2450);
        when(schrittzahl.getSchritteFromUser(LocalDate.of(2020, 04, 06), "Fueger")).thenReturn(2733);
        when(schrittzahl.getSchritteFromUser(LocalDate.of(2020, 04, 07), "Fueger")).thenReturn(3000);


        schrittDifferenz = new SchrittDifferenz(schrittzahl);
    }

    @Test
    public void test_maximaleSteigerung_March_Korn(){
        // ===== ACT =====
        // zu testende Methode aufrufen
        int maximaleSteigerung = schrittDifferenz.maximaleSteigerung(LocalDate.of(2020,03,01), LocalDate.of(2020,03,05),"Korn");

        // ===== ASSERT =====
        // Überprüfen, ob Methode richtigen Wert zurückgibt
        assertThat(maximaleSteigerung).isEqualTo(1450);
    }

    @Test
    public void test_maximaleVerminderung_March_Korn(){
        // ===== ACT =====
        // zu testende Methode aufrufen
        int maximaleVerminderung = schrittDifferenz.maximaleVerminderung(LocalDate.of(2020,03,01), LocalDate.of(2020,03,05),"Korn");

        // ===== ASSERT =====
        // Überprüfen, ob Methode richtigen Wert zurückgibt
        assertThat(maximaleVerminderung).isEqualTo(2400);
    }

    @Test
    public void test_maximaleSteigerung_April_Fueger(){
        // ===== ACT =====
        // zu testende Methode aufrufen
        int maximaleSteigerung = schrittDifferenz.maximaleSteigerung(LocalDate.of(2020,04,01), LocalDate.of(2020,04,07),"Fueger");

        // ===== ASSERT =====
        // Überprüfen, ob Methode richtigen Wert zurückgibt
        assertThat(maximaleSteigerung).isEqualTo(767);
    }

    @Test
    public void test_maximaleVerminderung_April_Fueger(){
        // ===== ACT =====
        // zu testende Methode aufrufen
        int maximaleVerminderung = schrittDifferenz.maximaleVerminderung(LocalDate.of(2020,04,01), LocalDate.of(2020,04,07),"Fueger");

        // ===== ASSERT =====
        // Überprüfen, ob Methode richtigen Wert zurückgibt
        assertThat(maximaleVerminderung).isEqualTo(350);
    }
}