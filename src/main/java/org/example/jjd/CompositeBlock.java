package org.example.jjd;

import java.util.List;

// CompositeBlock nie powinien rozszerzać interfejsu Block
// (ponieważ z założenia jego implementacja będzie przechowywać listę Block, nie wiemy do jakiego elementu w liście odnoszą się metody
// getColor(), getMaterial()).
// Jeśli jednak istnieje założenie, że klasa Wall powinna mieć metode getColor()
// np. kolor ściany jest określony najczęściej występującym kolorem w liście bloków
// wtedy trzeba iterować po liście dodając kolor (klucz), jeśli jeszcze nie wystąpił, z wartością jeden, lub zwiększyć jego wartość o jeden gdy istnieje.
// Następnie przechodząc po kluczach i wartościach wybrać ten klucz który ma największą wartość
/**
 * @see Wall#getColor()
 */
// Ostatetcznie można zmienić aby przyjmowały indeks (tak jak w tym interfejsie).
// Gdyby Java wspierała opcjonalne parametry można by zaimplementować w następujący sposób:
// Interfejs Block miałby metody getColor(int indeks), getMaterial(int indeks)
// Klasy implementujące bezpośrednio Block posiadały by implementacje np. jako getColor(int indeks=null) { return this.color; }
// co umożliwiło by ich wywołanie bez wprowadzania parametru
// a w klasach implementujących CompositeBlock przekazywany byłby indeks
// Bez sprecyzowanych wymagań są to tylko koncepcje rozwiązania problemu
public interface CompositeBlock {
    List<Block> getBlocks();

    String getColor(int i);

    String getMaterial(int i);
}
