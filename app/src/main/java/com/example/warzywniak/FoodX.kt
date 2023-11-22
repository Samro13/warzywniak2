package com.example.warzywniak

import kotlinx.serialization.Serializable

@Serializable
data class FoodX(
    val description: String,
    val id: Int,
    val name: String,
    val numbers: List<Long>
)
val test = """{
  "food" : [
    {
      "id" : 1,
      "name" : "Pomidor",
      "description" : "Sekcja w obrębie rodzaju psianka (Solanum) obejmująca grupę gatunków wyodrębnianych dawniej w rodzaj pomidor (Lycopersicon). Rośliny te pochodzą z zachodniej części Ameryki Południowej. Jeden z gatunków – pomidor zwyczajny (Solanum lycopersicum) – jest rozpowszechnioną rośliną uprawną. Według Polskiej Klasyfikacji Wyrobów i Usług jego owoc jest warzywem",
      "numbers" : [
        567823,
        478233,
        382733,
        378927,
        378200
      ]
    },
    {
      "id" : 2,
      "name" : "Banan",
      "description" : "Jadalny owoc tropikalny, z botanicznego punktu widzenia – jagoda[1]. Wytwarzany przez kilka gatunków roślin zielnych z rodzaju banan (Musa) (największe znaczenie użytkowe mają owoce banana zwyczajnego)",
      "numbers" : [
        74892,
        4891,
        291233123
      ]
    },
    {
      "id" : 3,
      "name" : "Jabłko",
      "description" : "Jadalny, kulisty owoc drzew z rodzaju jabłoń Malus. Jabłka odmian uprawnych o mieszańcowym pochodzeniu, uznawanych za gatunek jabłoń domowa Malus domestica, są istotnym komercyjnie owocem o soczystym i chrupkim miąższu. Są spożywane na surowo, a także po obróbce kulinarnej.",
      "numbers" : [
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8
      ]
    },
    {
      "id" : 4,
      "name" : "Burak",
      "description" : "Rodzaj roślin należący do rodziny szarłatowatych (dawniej w wyodrębnianych osobno komosowatych). Obejmuje 12 gatunków[4] występujących w basenie Morza Śródziemnego[5] – w południowej Europie, północnej Afryce i południowo-zachodniej Azji, poza tym niektórzy przedstawiciele zostali szeroko rozpowszechnieni na świecie[6].",
      "numbers" : [
        48291048012804,
        4978129047812904812,
        909090283,
        12376231
      ]
    },
    {
      "id" : 5,
      "name" : "Arbuz",
      "description" : "Rodzaj roślin z rodziny dyniowatych. Obejmuje 7 gatunków[4]. Cztery z nich rosną w południowej Afryce. C. mucosospermus rośnie w tropikalnej Afryce Zachodniej oraz Sudanie. Arbuz kolokwinta C. colocynthis rośnie w północnej Afryce, na południowych krańcach Europy i w południowo-zachodniej Azji[4].",
      "numbers" : [
        42890923,
        321890231,
        231788123,
        32109812045,
        32189074124,
        12490821312,
        321908312,
        3123712412,
        2318902312,
        231980312
      ]
    },
    {
      "id" : 6,
      "name" : "Pyrka",
      "description" : "Pomnik w formie głazu narzutowego, kształtem przypominającego ziemniaka, umieszczony w centralnej części parku Jana Pawła II na Łęgach Dębińskich, na terenie jednostki pomocniczej Osiedle Wilda w Poznaniu.",
      "numbers" : [
        123,
        456,
        789
      ]
    },
    {
      "id" : 7,
      "name" : "Rzodkiewka",
      "description" : "Odmiana rzodkwi zwyczajnej. Jest uprawiana w wielu regionach świata. W Polsce występuje głównie jako roślina uprawna, lecz przejściowo dziczeje (ergazjofigofit)[4]. W uprawie występuje wiele kultywarów. Również rzodkiew czarna i rzodkiew japońska to kultywary rzodkiewki[3]. Roślina uprawna. Rzodkiewka uprawiana jest zarówno w polu, jak i pod osłonami[7]. Czerwona rzodkiewka była uprawiana w Egipcie już 2000 lat temu. Nie znamy jej pochodzenia. Niektórzy przypuszczają, ze pochodziła z basenu Morza Śródziemnego[6], inni, że z Dalekiego Wschodu[8]. Dzika rzodkiewka nadal rośnie na terenie Chin i została wprowadzona przez Chińczyków do środkowej Azji jeszcze w czasach prehistorycznych.\nRzodkiewka była znana w starożytnym Egipcie, podawano ją także na dworze faraonów. Grecy wysoko cenili jej smak w III w. p.n.e., zaś Rzymianie odnotowali istnienie wielu odmian o różnym kształcie i barwie już w czasach chrześcijaństwa. Rzymianie zabrali rzodkiewkę na północ; w Niemczech zaczęto ją regularnie uprawiać w XIII wieku. Rzodkiewka była jedną z pierwszych europejskich roślin uprawnych zabranych na kontynent amerykański.",
      "numbers" : [
        23712893123,
        23712893123,
        23712893123,
        23712893123,
        23712893123,
        23712893123,
        23712893123,
        23712893123,
        23712893123,
        23712893123,
        23712893123,
        23712893123,
        23712893123,
        23712893123,
        23712893123,
        23712893123,
        23712893123,
        23712893123,
        23712893123,
        23712893123,
        23712893123,
        23712893123
      ]
    }
  ]
}"""