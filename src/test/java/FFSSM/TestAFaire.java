

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author colin
 */
public class TestAFaire {
    
    Club PlongeAumax;
    Site Marseille;
    Moniteur John;
    Plongee Calangues;
    Plongeur Thibault;
    Licence licenceThib;
    
    
    @BeforeEach
    public void setUp(){
        PlongeAumax = new Club(John, "PlongeAumax", "07 89 89 76 66");
        Marseille = new Site("Marseille", "Observer les plus beaux fonds marins de Marseille");
        John = new Moniteur("20345", "Shelby", "John","11 rue des sapins", "06 06 06 06 06", LocalDate.of(1995, 6, 25),799);
        Calangues = new Plongee(Marseille, John, LocalDate.of(2020, 11, 27),20, 2);
        Thibault = new Plongeur("34567", "Lancon", "Thibault","27 rue roland Garros","07 07 07 07 07", LocalDate.of(1997, 12, 12), 2);
        licenceThib = new Licence(Thibault, "123456", LocalDate.of(2020, 9, 28),2,PlongeAumax);
    }
    
    @Test
    public void testOrganisePlongee(){
        PlongeAumax.organisePlongee(Calangues);
        assertEquals(Calangues, PlongeAumax.plongeesOrga.get(0), 
                 "Plongée non ajoutée");
    }
    
    @Test
    public void testEstValide(){
        assertTrue(licenceThib.estValide(LocalDate.now()), "Licence non-valide");
    }
    
    @Test
    public void testAjouteParticipant(){
       Calangues.ajouteParticipant(Thibault);
        assertEquals(Thibault, Calangues.listeDesParticipants.get(0),
                "Plongeur  non-ajouté à la plongée");  
    }
     
    @Test
    public void testNouvelleEmbauche(){
        John.nouvelleEmbauche(PlongeAumax, LocalDate.of(2020, 10, 25));
        assertTrue(John.emplois().contains(John.embaucher));
    }
    
    @Test
    public void testTerminerEmbauche(){
        John.nouvelleEmbauche(PlongeAumax, LocalDate.of(2020, 10, 27));
        John.embaucher.terminer(LocalDate.now());
        assertTrue(John.embaucher.estTerminee(), "L'embauche de John n'est pas terminée");
    }
    
}   
