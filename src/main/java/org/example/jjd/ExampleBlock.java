package org.example.jjd;

public class ExampleBlock implements Block {
    //Jeśli zmiana koloru byłaby możliwa, pola nie powinny być final.
    private final String color;
    private final String material;

    private ExampleBlock(ExampleBlockBuilder builder) {
        this.color = builder.color;
        this.material = builder.material;
    }

    public static ExampleBlockBuilder builder() {
        return new ExampleBlockBuilder();
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getMaterial() {
        return this.material;
    }

    //Wzorzec budowniczego do tworzenia
    public static class ExampleBlockBuilder {
        private String color;
        private String material;

        ExampleBlockBuilder() {

        }

        public ExampleBlock.ExampleBlockBuilder color(String color) {
            this.color = color;
            return this;
        }

        public ExampleBlock.ExampleBlockBuilder material(String material) {
            this.material = material;
            return this;
        }

        public ExampleBlock build() {
            return new ExampleBlock(this);
        }
    }
}
