import java.beans.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class SudokuTest {

    @Test
    public void testEmptyInput() {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
        assertEquals(false, Sudoku.validate(grid));
    }

    @Test
    public void testBlankGrid() {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <9; i++) {
            grid.add(new ArrayList<>(Arrays.asList(null,null,null,null,null,null,null,null,null)));
        }
        assertEquals(true, Sudoku.validate(grid));
    }

    @Test
    public void testHorizontalGrid() {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
        grid.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        grid.add(new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 9, 1, 2, 3)));
        grid.add(new ArrayList<>(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6)));
        grid.add(new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 1)));
        grid.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 1, 2, 3, 4)));
        grid.add(new ArrayList<>(Arrays.asList(8, 9, 1, 2, 3, 4, 5, 6, 7)));
        grid.add(new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7, 8, 9, 1, 2)));
        grid.add(new ArrayList<>(Arrays.asList(6, 7, 8, 9, 1, 2, 3, 4, 5)));
        grid.add(new ArrayList<>(Arrays.asList(9, 1, 2, 3, 4, 5, 6, 7, 8)));
        assertEquals(true, Sudoku.validate(grid));
    }

    @Test
    public void testVerticalGrid() {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
        grid.add(new ArrayList<>(Arrays.asList(1, 4, 7, 2, 5, 8, 3, 6, 9)));
        grid.add(new ArrayList<>(Arrays.asList(2, 5, 8, 3, 6, 9, 4, 7, 1)));
        grid.add(new ArrayList<>(Arrays.asList(3, 6, 9, 4, 7, 1, 5, 8, 2)));
        grid.add(new ArrayList<>(Arrays.asList(4, 7, 1, 5, 8, 2, 6, 9, 3)));
        grid.add(new ArrayList<>(Arrays.asList(5, 8, 2, 6, 9, 3, 7, 1, 4)));
        grid.add(new ArrayList<>(Arrays.asList(6, 9, 3, 7, 1, 4, 8, 2, 5)));
        grid.add(new ArrayList<>(Arrays.asList(7, 1, 4, 8, 2, 5, 9, 3, 6)));
        grid.add(new ArrayList<>(Arrays.asList(8, 2, 5, 9, 3, 6, 1, 4, 7)));
        grid.add(new ArrayList<>(Arrays.asList(9, 3, 6, 1, 4, 7, 2, 5, 8)));
        assertEquals(true, Sudoku.validate(grid));
    }

    @Test
    public void testIncompleteGrid() {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
        grid.add(new ArrayList<>(Arrays.asList(6, null, null, 5, null, null, 4, 8, 7)));
        grid.add(new ArrayList<>(Arrays.asList(null, null, 3, 6, null, null, 1, null, null)));
        grid.add(new ArrayList<>(Arrays.asList(5, null, 8, null, 2, 7, 6, null, null)));
        grid.add(new ArrayList<>(Arrays.asList(8, 6, null, null, null, 3, 5, null, null)));
        grid.add(new ArrayList<>(Arrays.asList(9, null, 1, 4, null, 8, 7, null, 3)));
        grid.add(new ArrayList<>(Arrays.asList(null, null, 5, 7, null, null, null, 9, 8)));
        grid.add(new ArrayList<>(Arrays.asList(null, null, 4, 9, 7, null, 3, null, 2)));
        grid.add(new ArrayList<>(Arrays.asList(null, null, 6, null, null, 2, 9, null, null)));
        grid.add(new ArrayList<>(Arrays.asList(2, 7, 9, null, null, 5, null, null, 6)));
        assertEquals(true, Sudoku.validate(grid));
    }

    @Test
    public void testBadComplete() {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
        grid.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        grid.add(new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 1)));
        grid.add(new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7, 8, 9, 1, 2)));
        grid.add(new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 9, 1, 2, 3)));
        grid.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 1, 2, 3, 4)));
        grid.add(new ArrayList<>(Arrays.asList(6, 7, 8, 9, 1, 2, 3, 4, 5)));
        grid.add(new ArrayList<>(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6)));
        grid.add(new ArrayList<>(Arrays.asList(8, 9, 1, 2, 3, 4, 5, 6, 7)));
        grid.add(new ArrayList<>(Arrays.asList(9, 1, 2, 3, 4, 5, 6, 7, 8)));       
        assertEquals(false, Sudoku.validate(grid));
    }

    @Test
    public void testBadColumns() {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <9; i++) {
            grid.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        }
        assertEquals(false, Sudoku.validate(grid));
    }

    @Test
    public void testBadRows() {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
        grid.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1)));
        grid.add(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2, 2)));
        grid.add(new ArrayList<>(Arrays.asList(3, 3, 3, 3, 3, 3, 3, 3, 3)));
        grid.add(new ArrayList<>(Arrays.asList(4, 4, 4, 4, 4, 4, 4, 4, 4)));
        grid.add(new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5)));
        grid.add(new ArrayList<>(Arrays.asList(6, 6, 6, 6, 6, 6, 6, 6, 6)));
        grid.add(new ArrayList<>(Arrays.asList(7, 7, 7, 7, 7, 7, 7, 7, 7)));
        grid.add(new ArrayList<>(Arrays.asList(8, 8, 8, 8, 8, 8, 8, 8, 8)));
        grid.add(new ArrayList<>(Arrays.asList(9, 9, 9, 9, 9, 9, 9, 9, 9)));
        assertEquals(false, Sudoku.validate(grid));
    }

    @Test
    public void testBadIncomplete() {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
        grid.add(new ArrayList<>(Arrays.asList(6, null, null, 5, null, null, 4, 8, 7)));
        grid.add(new ArrayList<>(Arrays.asList(null, null, 3, 6, null, null, 1, null, null)));
        grid.add(new ArrayList<>(Arrays.asList(5, null, 8, null, 2, 7, 6, null, null)));
        grid.add(new ArrayList<>(Arrays.asList(8, 6, null, null, null, 3, 5, null, null)));
        grid.add(new ArrayList<>(Arrays.asList(9, null, 1, 4, null, 7, 8, null, 3)));
        grid.add(new ArrayList<>(Arrays.asList(null, null, 5, 7, null, null, null, 9, 8)));
        grid.add(new ArrayList<>(Arrays.asList(null, null, 4, 9, 7, null, 3, null, 2)));
        grid.add(new ArrayList<>(Arrays.asList(null, null, 6, null, null, 2, 9, null, null)));
        grid.add(new ArrayList<>(Arrays.asList(2, 7, 9, null, null, 5, null, null, 6)));
        assertEquals(false, Sudoku.validate(grid));
    }

    @Test
    public void testAllOnes() {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <9; i++) {
            grid.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1)));
        }
        assertEquals(false, Sudoku.validate(grid));
    }
    @Test
    public void testStrings() {
        ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();
        grid.add(new ArrayList<>(Arrays.asList("6","1",null,null,"9",null,null,null,null)));
        grid.add(new ArrayList<>(Arrays.asList(null,null,null,"2",null,"1","6","7","3")));
        grid.add(new ArrayList<>(Arrays.asList(null,null,null,null,"4",null,null,"9",null)));
        grid.add(new ArrayList<>(Arrays.asList(null,"2",null,null,null,null,"5",null,null)));
        grid.add(new ArrayList<>(Arrays.asList("7",null,"5","1",null,"8","3",null,"9")));
        grid.add(new ArrayList<>(Arrays.asList(null,null,"3",null,null,null,null,"1",null)));
        grid.add(new ArrayList<>(Arrays.asList(null,"6",null,null,"5",null,null,null,null)));
        grid.add(new ArrayList<>(Arrays.asList("5","7","9","8",null,"2",null,null,null)));
        grid.add(new ArrayList<>(Arrays.asList(null,null,null,null,"6",null,null,"5","1")));

    }
    @Test
    public void testTooManySymbols() {
        ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();
        grid.add(new ArrayList<>(Arrays.asList("1", "2","3",null,"5","6","7","8","9")));
        grid.add(new ArrayList<>(Arrays.asList("4","😁","6","7","8","9","1","2","3")));
        grid.add(new ArrayList<>(Arrays.asList("7","8",null,null,"2","3","4",null,"6")));
        grid.add(new ArrayList<>(Arrays.asList("2","3","4","5","6","7",null,null,null)));
        grid.add(new ArrayList<>(Arrays.asList("5",null,"7","8","😩","1","2","3","4")));
        grid.add(new ArrayList<>(Arrays.asList("8","9","1","2","3","4","5","6","7")));
        grid.add(new ArrayList<>(Arrays.asList(null,"4","5","6","7","8","9","1",null)));
        grid.add(new ArrayList<>(Arrays.asList("6","7",null,"9","1","2","3","😍","5")));
        grid.add(new ArrayList<>(Arrays.asList("9",null,"2","3",null,"5","6","7","8")));
    
        assertEquals(false, Sudoku.validate(grid));
    }

    @Test
    public void testNotASquare() {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
        grid.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)));
        grid.add(new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 9, 1, 2, 3)));
        grid.add(new ArrayList<>(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6)));
        grid.add(new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 1)));
        grid.add(new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 1, 2, 3, 4)));
        grid.add(new ArrayList<>(Arrays.asList(8, 9, 1, 2, 3, 4, 5, 6, 7)));
        grid.add(new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7, 8, 9, 1, 2)));
        grid.add(new ArrayList<>(Arrays.asList(6, 7, 8, 9, 1, 2, 3, 4, 5)));
        grid.add(new ArrayList<>(Arrays.asList(9, 1, 2, 3, 4, 5, 6, 7, 8)));
        assertEquals(false, Sudoku.validate(grid));
    }

    @Test
    public void testEmoji() {
        ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();
        grid.add(new ArrayList<>(Arrays.asList("😁", "🙈", "😴", "😍", "😎", "😭", "😩", "😇", "😂")));
        grid.add(new ArrayList<>(Arrays.asList("😍", "😎", "😭", "😩", "😇", "😂", "🙈", "😴", "😁")));
        grid.add(new ArrayList<>(Arrays.asList("😩", "😇", "😂", "🙈", "😴", "😁", "😎", "😭", "😍")));
        grid.add(new ArrayList<>(Arrays.asList("🙈", "😴", "😁", "😎", "😭", "😍", "😇", "😂", "😩")));
        grid.add(new ArrayList<>(Arrays.asList("😎", "😭", "😍", "😇", "😂", "😩", "😴", "😁", "🙈")));
        grid.add(new ArrayList<>(Arrays.asList("😇", "😂", "😩", "😴", "😁", "🙈", "😭", "😍", "😎")));
        grid.add(new ArrayList<>(Arrays.asList("😴", "😁", "🙈", "😭", "😍", "😎", "😂", "😩", "😇")));
        grid.add(new ArrayList<>(Arrays.asList("😭", "😍", "😎", "😂", "😩", "😇", "😁", "🙈", "😴")));
        grid.add(new ArrayList<>(Arrays.asList("😂", "😩", "😇", "😁", "🙈", "😴", "😍", "😎", "😭")));
        assertEquals(true, Sudoku.validate(grid));
    }

    @Test
    public void testJapanese() {
        ArrayList<ArrayList<String>> grid = new ArrayList<ArrayList<String>>();
        grid.add(new ArrayList<>(Arrays.asList(null, null, null, "八", null, null, null, null, "四")));
        grid.add(new ArrayList<>(Arrays.asList(null, null, null, null, null, null, null, "九", null)));
        grid.add(new ArrayList<>(Arrays.asList(null, null, null, "三", null, null, null, null, null)));
        grid.add(new ArrayList<>(Arrays.asList(null, null, "九", "七", null, "三", null, "四", null)));
        grid.add(new ArrayList<>(Arrays.asList(null, "六", null, null, null, null, null, "一", null)));
        grid.add(new ArrayList<>(Arrays.asList(null, "四", null, "二", null, "九", "三", null, null)));
        grid.add(new ArrayList<>(Arrays.asList(null, null, null, null, null, "八", null, null, null)));
        grid.add(new ArrayList<>(Arrays.asList(null, "八", null, null, null, null, null, null, null)));
        grid.add(new ArrayList<>(Arrays.asList("九", null, null, null, null, "六", null, null, null)));
        assertEquals(true, Sudoku.validate(grid));
    }
}

