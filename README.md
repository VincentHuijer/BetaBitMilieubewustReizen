# PROJ2_KLAS_6_GROEP6D_BetaBit
**Instellen rewards -** Als manager bij betabit wil ik beloningen kunnen toevoegen/verwijderen aan de applicatie zodat we medewerkers op een leuke manier kunnen belonen voor het verminderen van hun CO2 uitstoot.

- Te vinden in class:
    - [BeloningAdminController](https://github.com/hhs-semester-se-s2/PROJ2_KLAS_6_GROEP6D_BetaBit/blob/master/src/main/java/hhs/Controllers/BeloningAdminController.java)
    - [BeloningAdminScherm](https://github.com/hhs-semester-se-s2/PROJ2_KLAS_6_GROEP6D_BetaBit/blob/master/src/main/java/hhs/Schermen/BeloningAdminScherm.java)
    - [Rewards](https://github.com/hhs-semester-se-s2/PROJ2_KLAS_6_GROEP6D_BetaBit/blob/master/src/main/java/hhs/proj2_klas6_groep6d/Rewards.java)
    - [RewardsList](https://github.com/hhs-semester-se-s2/PROJ2_KLAS_6_GROEP6D_BetaBit/blob/master/src/main/java/hhs/proj2_klas6_groep6d/RewardsList.java)

**Punten systeem -** Als product owner wil ik dat er een systeem wordt ontwikkeld waarmee het juiste aantal punten toegekend kan worden aan een gebruiker en een gebruiker punten kan inruilen voor een beloning.

- Te vinden in class:
    - [ReisSysteemController](https://github.com/hhs-semester-se-s2/PROJ2_KLAS_6_GROEP6D_BetaBit/blob/master/src/main/java/hhs/Controllers/ReisSysteemController.java)
    - [ReisSysteemScherm](https://github.com/hhs-semester-se-s2/PROJ2_KLAS_6_GROEP6D_BetaBit/blob/master/src/main/java/hhs/Schermen/ReisSysteemScherm.java)
    - [BeloningController](https://github.com/hhs-semester-se-s2/PROJ2_KLAS_6_GROEP6D_BetaBit/blob/master/src/main/java/hhs/Controllers/BeloningController.java)
    - [BeloningScherm](https://github.com/hhs-semester-se-s2/PROJ2_KLAS_6_GROEP6D_BetaBit/blob/master/src/main/java/hhs/Schermen/BeloningScherm.java)
    - [Gebruiker](https://github.com/hhs-semester-se-s2/PROJ2_KLAS_6_GROEP6D_BetaBit/blob/master/src/main/java/hhs/proj2_klas6_groep6d/Gebruiker.java)
    - [Punten](https://github.com/hhs-semester-se-s2/PROJ2_KLAS_6_GROEP6D_BetaBit/blob/master/src/main/java/hhs/proj2_klas6_groep6d/Punten.java)


**Layout -** Als stakeholder wil ik een overzichtelijke layout, zodat ik makkelijk door alle menu's van de applicaties heen kan klikken.

- Te vinden in de fxml files/scherm classes


**Alternatieve opties -** Als gebruiker wil ik dat de applicatie mij een duurzamere optie als vervoermiddel suggereert nadat ik heb gekozen welk vervoermiddel ik ga gebruiken voor betreffende reis. (auto -> ov, ov -> fiets)

- Te vinden in class:
    - [ReisSysteemScherm](https://github.com/hhs-semester-se-s2/PROJ2_KLAS_6_GROEP6D_BetaBit/blob/master/src/main/java/hhs/Schermen/ReisSysteemScherm.java)


**Reisgegevens -** Als gebruiker wil ik kunnen aangeven wat voor vervoersmiddel ik gebruik en welke afstand ik afleg, zodat de applicatie mij de juiste hoeveelheid punten kan toekennen.

- Te vinden in class:
    - [ReisSysteemScherm](https://github.com/hhs-semester-se-s2/PROJ2_KLAS_6_GROEP6D_BetaBit/blob/master/src/main/java/hhs/Schermen/ReisSysteemScherm.java)
    - [ReisSysteemController](https://github.com/hhs-semester-se-s2/PROJ2_KLAS_6_GROEP6D_BetaBit/blob/master/src/main/java/hhs/Controllers/ReisSysteemController.java)
    - [Punten](https://github.com/hhs-semester-se-s2/PROJ2_KLAS_6_GROEP6D_BetaBit/blob/master/src/main/java/hhs/proj2_klas6_groep6d/Punten.java)
    - [Gebruiker](https://github.com/hhs-semester-se-s2/PROJ2_KLAS_6_GROEP6D_BetaBit/blob/master/src/main/java/hhs/proj2_klas6_groep6d/Gebruiker.java)

**Individuele beloningen** - Als gebruiker wil ik individuele rewards kunnen kiezen, zodat ik beloond wordt voor mijn individuele bijdrage en extra gemotiveerd raak.

- Te vinden in class:
    - [BeloningScherm](https://github.com/hhs-semester-se-s2/PROJ2_KLAS_6_GROEP6D_BetaBit/blob/master/src/main/java/hhs/Schermen/BeloningScherm.java)
    - [BeloningController](https://github.com/hhs-semester-se-s2/PROJ2_KLAS_6_GROEP6D_BetaBit/blob/master/src/main/java/hhs/Controllers/BeloningController.java)


**Formules**

Berekening CO2 uitstoot per vervoersmiddel


    private double berekenUitstoot() {
        //formule voor het berekenen van de CO2 uitstoot
        if (vervoersmiddel.equalsIgnoreCase("auto")) {
            if (elektrisch) {
                return this.km * 107;
            } else {
                return this.km * 224;
            }
        }

        if (vervoersmiddel.equalsIgnoreCase("RegionaalOV")) {
            return this.km * 116;
            //Bus
        }

        return 0;
    }


Berekening punten woon-werkverkeer


    
    public static double berekenAantalPuntenWoonWerkVerkeer(double grootsteAfstandInKm, double afstand, String vervoersMiddel, boolean elektrisch){
        double multiplier = 1;
        if(vervoersMiddel.equalsIgnoreCase("Auto") || vervoersMiddel.equalsIgnoreCase("Motor")){ //auto en motor geven even veel punten.
            multiplier = 0;
            if(elektrisch){
                multiplier = 0.69;
            }
        }
        else if(vervoersMiddel.equalsIgnoreCase("RegionaalOV")){
            multiplier = 0.69;
        }
        else if(afstand > 10 && !vervoersMiddel.equalsIgnoreCase("Tram")){
            multiplier = 1.5;
        }
        if (grootsteAfstandInKm < afstand){
            return -1;
        }
        return (Math.round(grootsteAfstandInKm - afstand + (afstand * multiplier)));
    }

Berekening punten zakelijk verkeer

    public static double berekenAantalPuntenZakelijkVerkeer(double afstand, String vervoersMiddel, boolean elektrisch){
        double multiplier = 1;
        if(vervoersMiddel.equalsIgnoreCase("Auto") || vervoersMiddel.equalsIgnoreCase("Motor")){ //auto en motor zijn niet zuinig en belonen geen punten.
            multiplier = 0;
            if(elektrisch){ //elektrisch vervoer is zuiniger en beloond evenveel punten als regionaal OV voor nu.
                multiplier = 0.69;
            }
        }
        else if(vervoersMiddel.equalsIgnoreCase("RegionaalOV")){
            multiplier = 0.69;
        }else if(afstand > 10 && !vervoersMiddel.equalsIgnoreCase("Tram")){
            multiplier = 1.5;
        }

        return (Math.round(afstand * multiplier));
    }
