import java.util.*;

public class Sudoku {

    public static <X> Boolean validate(ArrayList<ArrayList<X>> grid) {

        Set<X> uniqueElements = new HashSet<X>();
        if ( grid.size() != 9) {
            return false;
        }
        ArrayList<ArrayList<X>> columns = getColumns(grid);
        ArrayList<ArrayList<X>> threeByThrees = getThreeByThrees(grid);


        for (ArrayList<X> group: grid) {
            if (group.size() != 9) {
                return false;
            }
        }
        grid.addAll(columns);
        grid.addAll(threeByThrees);
        for (ArrayList<X> group: grid) {
            group.removeIf(Objects::isNull);
            uniqueElements.addAll(group);
            if (!validateBlock(group)){
                return false;
            }
        }

        if (uniqueElements.size() > 9){
            return false;
        }


        return true;
    }

    private static <X> Boolean validateBlock(ArrayList<X> block) {
        Set<X> uniqueBlockEntries = new HashSet<X>(block);
        return uniqueBlockEntries.size() == block.size();
    }

    private static <X> ArrayList<ArrayList<X>> getColumns(ArrayList<ArrayList<X>> grid) {
        ArrayList<ArrayList<X>> columns = new ArrayList<ArrayList<X>>();
        for (int i=0; i<grid.size(); i++){
            ArrayList<X> column = new ArrayList<X>();
            for(ArrayList<X> row: grid){
                column.add(row.get(i));
            }
            columns.add(column);
        }
        return columns;
    }

    private static <X> ArrayList<ArrayList<X>> getThreeByThrees(ArrayList<ArrayList<X>> grid) {
        ArrayList<ArrayList<X>> subgrids = new ArrayList<ArrayList<X>>();
        int line=0;
        for (int i=0; i<grid.size(); i+=3){
            ArrayList<X> gridOne = new ArrayList<X>();
            ArrayList<X> gridTwo = new ArrayList<X>();
            ArrayList<X> gridThree = new ArrayList<X>();
            for (int j=0; j <3; j++){
                gridOne.add(grid.get(i).get(j));
                gridOne.add(grid.get(i+1).get(j));
                gridOne.add(grid.get(i+2).get(j));
                gridTwo.add(grid.get(i).get(j+3));
                gridTwo.add(grid.get(i+1).get(j+3));
                gridTwo.add(grid.get(i+2).get(j+3));
                gridThree.add(grid.get(i).get(j+6));
                gridThree.add(grid.get(i+1).get(j+6));
                gridThree.add(grid.get(i+2).get(j+6));
            }
            subgrids.add(gridOne);
            subgrids.add(gridTwo);
            subgrids.add(gridThree);
        }
        return subgrids;
    }
}