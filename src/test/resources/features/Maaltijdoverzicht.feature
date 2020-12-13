Feature: Maaltijdoverzicht

  Als een potentiële klant
  Wil ik alle maaltijden ter beschikking zien
  Zodat ik kan bestellen wat ik wil eten

  # Personas
  # Jan - student TI

  Rule: Toon alle maaltijden die op het menu staan
    Scenario: Alle maaltijden worden getoond
      Given dat er maaltijden op het menu staan
      When Jan op het menu kijkt
      Then worden alle maaltijden getoond die op het menu staan

    Scenario: Er worden geen maaltijden getoond want er staan geen maaltijden op het menu
      Given er geen maaltijden op het menu staan
      When Jan op het menu kijkt
      Then krijgt Jan een melding dat er momenteel nog geen maaltijden op het menu staan

  Rule: Informatie over allergieën, al dan niet vegetarisch en of het al dan niet gluten bevat moet getoond worden
    Scenario Outline: Klant krijgt extra informatie bij een maaltijd
      Given er is een "<Maaltijd>" met informatie over "<Allergieën>" en of het "<Vegetarisch>" is
      When Jan op het menu kijkt
      Then zou Jan de "<Maaltijd>" te zien moeten krijgen met informatie over "<Allergieën>" en "<Vegetarisch>"
      Examples:
        | Maaltijd                  | Allergieën                | Vegetarisch |
        | Broodje brie met walnoten | Sporen van noten, gluten  |             |
        | Broodje Veggylicious      | Gluten                    | Vegetarisch |
        | Frikandel                 |                           |             |


  Rule: De prijs moet altijd getoond worden
    Scenario Outline: Klant ziet de prijs bij een maaltijd in het overzicht
      Given er is een "<Maaltijd>" met een "<Prijs>"
      When Jan op het menu kijkt
      Then ziet Jan de "<Maaltijd>" met een "<Prijs>"
      Examples:
        | Maaltijd                  | Prijs |
        | Broodje brie met walnoten | 2.60 |
        | Broodje Veggylicious      | 2.35 |
        | Frikandel                 | 2.92 |


  Rule: Maaltijden worden gegroepeerd per categorie
    Scenario Outline: De maaltijden worden getoond per categorie
      Given er verschillende categorieën maaltijden zijn
      When Jan het menu bekijkt
      Then zal hij de maaltijden verdeeld zien per categorie
      Examples:
        | Broodjes        | Pasta   | Soepen      |
        | Broodje martino | Lasagne | Tomatensoep |
