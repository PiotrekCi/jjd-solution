package org.example.jjd;

import java.util.*;

public class Wall implements Structure, CompositeBlock {
    private final List<Block> blocks;

    public Wall(final List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return this.blocks.stream()
                .filter(block -> block.getColor().equals(color))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return this.blocks.stream()
                .filter(block -> block.getMaterial().equals(material))
                .toList();
    }

    @Override
    public int count() {
        return this.blocks.size();
    }


    @Override
    public List<Block> getBlocks() {
        return this.blocks;
    }

    @Override
    public String getColor(int index) {
        return this.blocks.get(index).getColor();
    }

    @Override
    public String getMaterial(int index) {
        return this.blocks.get(index).getMaterial();
    }

    //Jeśli kolor byłby określany najczęściej występującym w liście, przykładowa implementacja:
    //Wybierze pierwszy najczęściej występujący kolor (inaczej w komparatorze trzeba uwzględnić zero gdy ilość jest równa)
    public String getColor() {
        Map<String, Integer> colorsCountMap = new HashMap<>();
        this.blocks.forEach(block -> {
           if (colorsCountMap.containsKey(block.getColor())) {
               colorsCountMap.replace(block.getColor(), colorsCountMap.get(block.getColor()) + 1);
           } else {
               colorsCountMap.put(block.getColor(), 1);
           }
        });

        if (colorsCountMap.isEmpty()) return null;

        return colorsCountMap.entrySet().stream()
                .max((v1, v2) -> v1.getValue() > v2.getValue() ? 1 : -1)
                .orElse(null)
                .getKey();
    }
}
