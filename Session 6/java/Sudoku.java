import java.util.*;

public class Sudoku {

    public static <X> Boolean validate(ArrayList<ArrayList<X>> grid) {

        Set<X> uniqueElements = new HashSet<X>();
        ArrayList<ArrayList<X>> columns = getColumns(grid);
        ArrayList<ArrayList<X>> threeByThrees = getThreeByThrees(grid);
        
        if ( grid.size() != 9) {
            return false;
        }

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
        for (int startRow=0; startRow<grid.size(); startRow+=3){           
            for (int offset=0; offset<9; offset +=3){
                ArrayList<X> subGrid = new ArrayList<X>();
                for (int column=0; column<3; column++) {
                    subGrid.add(grid.get(startRow).get(column+offset));
                    subGrid.add(grid.get(startRow+1).get(column+offset));
                    subGrid.add(grid.get(startRow+2).get(column+offset));
                }
                subgrids.add(subGrid);
            }
            
        }
        return subgrids;
    }
}