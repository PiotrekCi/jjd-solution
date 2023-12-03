import org.example.jjd.Block;
import org.example.jjd.ExampleBlock;
import org.example.jjd.Wall;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WallTest {
    @Test
    void shouldReturnCorrectWallWhenFindBlockByColor() {
        //given
        List<Block> sampleBlocks = this.sampleBlocks();
        Wall sampleWall = new Wall(sampleBlocks);
        //when
        var firstRedBlock = sampleWall.findBlockByColor("Red").get();
        //then
        assertEquals("Red", firstRedBlock.getColor());
        assertEquals("Wood", firstRedBlock.getMaterial());
    }

    @Test
    void shouldReturnCorrectListWhenFindByMaterial() {
        //given
        List<Block> sampleBlocks = this.sampleBlocks();
        Wall sampleWall = new Wall(sampleBlocks);
        //when
        var matchingBlocks = sampleWall.findBlocksByMaterial("Glass");
        //then
        assertEquals(3, matchingBlocks.size());
    }

    @Test
    void shouldReturnCorrectSizeForWall() {
        //given
        List<Block> sampleBlocks = this.sampleBlocks();
        Wall sampleWall = new Wall(sampleBlocks);
        //when
        var actualListSize = sampleWall.count();
        //then
        assertEquals(6, actualListSize);
    }

    @Test
    void shouldReturnOptionalEmptyWhenNonMatchingColor() {
        //given
        List<Block> sampleBlocks = this.sampleBlocks();
        Wall sampleWall = new Wall(sampleBlocks);
        //when
        var nonMatchingColorBlock = sampleWall.findBlockByColor("NonExistingColor");
        //then
        assertTrue(nonMatchingColorBlock.isEmpty());
    }

    @Test
    void shouldReturnEmptyListWhenNonMatchingMaterial() {
        //given
        List<Block> sampleBlocks = this.sampleBlocks();
        Wall sampleWall = new Wall(sampleBlocks);
        //when
        var nonMatchingMaterialResult = sampleWall.findBlocksByMaterial("NonExistingMaterial");
        //then
        assertTrue(nonMatchingMaterialResult.isEmpty());
    }

    @Test
    void shouldReturnMostCommonColor() {
        //given
        List<Block> sampleBlocks = this.sampleBlocks();
        Wall sampleWall = new Wall(sampleBlocks);
        //when
        var mostCommonColor = sampleWall.getColor();
        //then
        assertEquals("Red", mostCommonColor);
    }

    @Test
    void shouldReturnNullWhenNoColors() {
        //given
        List<Block> emptyBlocksList = List.of();
        Wall sampleWall = new Wall(emptyBlocksList);
        //when
        var resultForEmptyList = sampleWall.getColor();
        //then
        assertNull(resultForEmptyList);
    }

    @Test
    void shouldReturnFirstMostCommonColorWhenEqualOccurrence() {
        //given
        List<Block> sampleBlocks = new ArrayList<>(this.sampleBlocks());
        sampleBlocks.add(0, ExampleBlock.builder().color("White").build());
        Wall sampleWall = new Wall(sampleBlocks);
        //when
        var firstMostCommonColor = sampleWall.getColor();
        //then
        assertEquals("White", firstMostCommonColor);
    }

    private List<Block> sampleBlocks() {
        ExampleBlock block1 = ExampleBlock.builder().color("Red").material("Wood").build();
        ExampleBlock block2 = ExampleBlock.builder().color("Blue").material("Wood").build();
        ExampleBlock block3 = ExampleBlock.builder().color("White").material("Glass").build();
        ExampleBlock block4 = ExampleBlock.builder().color("Red").material("Metal").build();
        ExampleBlock block5 = ExampleBlock.builder().color("Orange").material("Glass").build();
        ExampleBlock block6 = ExampleBlock.builder().color("Green").material("Glass").build();
        return List.of(block1, block2, block3, block4, block5, block6);
    }
}
