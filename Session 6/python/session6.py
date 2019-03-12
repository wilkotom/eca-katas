def validate_grid(grid):
    return None


def validate_grid(grid):
    symbols = set()
    if len(grid) != 9:
        return False
    for line in grid:
        symbols = symbols.union(line)
        if len(line) != 9:
            return False
        numbers = [num for num in line if num != ' ']
        if len(numbers) != len(set(numbers)):
            return False

    for col_num in range(0, 9):
        column = []
        for row in range(0, 9):
            if grid[row][col_num] != ' ':
                column.append(grid[row][col_num])
        if len(column) != len(set(column)):
            return False

    for sq_row in (0, 3, 6):
        for sq_col in 0, 3, 6:
            square = grid[sq_row][sq_col:sq_col + 3] + \
                     grid[sq_row + 1][sq_col:sq_col + 3] + \
                     grid[sq_row + 2][sq_col:sq_col + 3]
            numbers = [num for num in square if num != ' ']
            if len(numbers) != len(set(numbers)):
                return False
    if ' ' in symbols:
        symbols.remove(' ')
    if len(symbols) > 9:
        return False
    return True


def validate_grid(grid):
    def valid_set(numbers):
        numbers = [num for num in numbers if num != ' ']
        return len(numbers) == len(set(numbers))

    symbols = set()

    if len(grid) != 9:
        return False

    for line in grid:
        if len(line) != 9 or not valid_set(line):
            return False

    for col_num in range(0, 9):
        column = []
        for row in range(0, 9):
            column.append(grid[row][col_num])
        if not valid_set(column):
            return False

    for sq_row in (0, 3, 6):
        for sq_col in 0, 3, 6:
            square = grid[sq_row][sq_col:sq_col + 3] + \
                     grid[sq_row + 1][sq_col:sq_col + 3] + \
                     grid[sq_row + 2][sq_col:sq_col + 3]
            if not valid_set(square):
                return False

    if ' ' in symbols:
        symbols.remove(' ')
    if len(symbols) > 9:
        return False

    return True


from itertools import groupby
def validate_grid(grid):

    def valid_set(numbers):
        numbers = [num for num in numbers if num != ' ']
        return len(numbers) == len(set(numbers))

    line_lengths = list(groupby([len(line) for line in grid]))
    if len(grid) != 9 or \
                    len(list(groupby(line_lengths))) != 1 or \
                    line_lengths[0][0] != 9:
        return False

    symbols = set(x for line in grid for x in line)
    if len(symbols.difference(' ')) > 9:
        return False

    sets_to_test = [line for line in grid] + \
                   [[row[x] for row in grid] for x in range(0, 9)]
    for sq_row in 0, 3, 6:
        for sq_col in 0, 3, 6:
            sets_to_test.append(grid[sq_row][sq_col:sq_col + 3] +
                                grid[sq_row + 1][sq_col:sq_col + 3] +
                                grid[sq_row + 2][sq_col:sq_col + 3])

    return False not in [valid_set(num_set) for num_set in sets_to_test]


def validate_grid(grid):
    def valid_set(numbers):
        numbers = [num for num in numbers if num != ' ']
        return len(numbers) == len(set(numbers))

    line_lengths = list(groupby([len(line) for line in grid]))
    if len(line_lengths) != 1 or line_lengths[0][0] != 9:
        return False
    symbols = set(x for line in grid for x in line)
    if len(symbols.difference(' ')) > 9:
        return False
    rows = [line for line in grid]
    cols = zip(*grid)
    squares = []
    square_rows = list(zip(*grid[0:3])) + list(zip(*grid[3:6])) + list(zip(*grid[6:9]))
    while square_rows:
        squares.append(square_rows[0] + square_rows[1] + square_rows[2])
        del square_rows[:3]
    return False not in [valid_set(num_set) for num_set in rows + cols + squares]

