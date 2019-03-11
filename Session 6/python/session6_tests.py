# This Exercise uses the following encoding: utf-8
import unittest
from session6 import validate_grid


class TestSudokuGrid(unittest.TestCase):
    def test_empty(self):
        self.assertIs(validate_grid([]), False)

    def test_empty_grid(self):
        self.assertIs(validate_grid([([' '] * 9)] * 9), True)

    def test_horz_grid(self):
        self.assertIs(validate_grid([[1, 2, 3, 4, 5, 6, 7, 8, 9],
                                     [4, 5, 6, 7, 8, 9, 1, 2, 3],
                                     [7, 8, 9, 1, 2, 3, 4, 5, 6],
                                     [2, 3, 4, 5, 6, 7, 8, 9, 1],
                                     [5, 6, 7, 8, 9, 1, 2, 3, 4],
                                     [8, 9, 1, 2, 3, 4, 5, 6, 7],
                                     [3, 4, 5, 6, 7, 8, 9, 1, 2],
                                     [6, 7, 8, 9, 1, 2, 3, 4, 5],
                                     [9, 1, 2, 3, 4, 5, 6, 7, 8]]), True)

    def test_vert_grid(self):
        self.assertIs(validate_grid([[1, 4, 7, 2, 5, 8, 3, 6, 9],
                                     [2, 5, 8, 3, 6, 9, 4, 7, 1],
                                     [3, 6, 9, 4, 7, 1, 5, 8, 2],
                                     [4, 7, 1, 5, 8, 2, 6, 9, 3],
                                     [5, 8, 2, 6, 9, 3, 7, 1, 4],
                                     [6, 9, 3, 7, 1, 4, 8, 2, 5],
                                     [7, 1, 4, 8, 2, 5, 9, 3, 6],
                                     [8, 2, 5, 9, 3, 6, 1, 4, 7],
                                     [9, 3, 6, 1, 4, 7, 2, 5, 8]]), True)

    def test_valid_incomplete(self):
        self.assertIs(validate_grid([[6, ' ', ' ', 5, ' ', ' ', 4, 8, 7],
                                     [' ', ' ', 3, 6, ' ', ' ', 1, ' ', ' '],
                                     [5, ' ', 8, ' ', 2, 7, 6, ' ', ' '],
                                     [8, 6, ' ', ' ', ' ', 3, 5, ' ', ' '],
                                     [9, ' ', 1, 4, ' ', 8, 7, ' ', 3],
                                     [' ', ' ', 5, 7, ' ', ' ', ' ', 9, 8],
                                     [' ', ' ', 4, 9, 7, ' ', 3, ' ', 2],
                                     [' ', ' ', 6, ' ', ' ', 2, 9, ' ', ' '],
                                     [2, 7, 9, ' ', ' ', 5, ' ', ' ', 6]]), True)

    def test_bad_complete(self):
        self.assertIs(validate_grid([[1, 2, 3, 4, 5, 6, 7, 8, 9],
                                     [2, 3, 4, 5, 6, 7, 8, 9, 1],
                                     [3, 4, 5, 6, 7, 8, 9, 1, 2],
                                     [4, 5, 6, 7, 8, 9, 1, 2, 3],
                                     [5, 6, 7, 8, 9, 1, 2, 3, 4],
                                     [6, 7, 8, 9, 1, 2, 3, 4, 5],
                                     [7, 8, 9, 1, 2, 3, 4, 5, 6],
                                     [8, 9, 1, 2, 3, 4, 5, 6, 7],
                                     [9, 1, 2, 3, 4, 5, 6, 7, 8]]), False)

    def test_bad_columns(self):
        self.assertIs(validate_grid([[1, 2, 3, 4, 5, 6, 7, 8, 9] * 9]), False)

    def test_bad_rows(self):
        self.assertIs(validate_grid([[n] * 9 for n in range(1, 10)]), False)

    def test_bad_incomplete(self):
        self.assertIs(validate_grid([[6, ' ', ' ', 5, ' ', ' ', 4, 8, 7],
                                     [' ', ' ', 3, 6, ' ', ' ', 1, ' ', ' '],
                                     [5, ' ', 8, ' ', 2, 7, 6, ' ', ' '],
                                     [8, 6, ' ', ' ', ' ', 3, 5, ' ', ' '],
                                     [9, ' ', 1, 4, ' ', 7, 8, ' ', 3],
                                     [' ', ' ', 5, 7, ' ', ' ', ' ', 9, 8],
                                     [' ', ' ', 4, 9, 7, ' ', 3, ' ', 2],
                                     [' ', ' ', 6, ' ', ' ', 2, 9, ' ', ' '],
                                     [2, 7, 9, ' ', ' ', 5, ' ', ' ', 6]]), False)

    def test_all_ones(self):
        self.assertIs(validate_grid([[1] * 9] * 9), False)

    def test_test_too_many_symbols(self):
        self.assertIs(validate_grid(['123 56789',
                                     '4😁6789123',
                                     '78  234 6',
                                     '234567   ',
                                     '5 78😩1234',
                                     '891234567',
                                     ' 4567891 ',
                                     '67 9123😍5',
                                     '9 23 5678']), False)

    def test_not_a_square(self):
        self.assertIs(validate_grid([[1, 2, 3, 4, 5, 6, 7, 8, 9, 0],
                                     [4, 5, 6, 7, 8, 9, 1, 2, 3],
                                     [7, 8, 9, 1, 2, 3, 4, 5, 6],
                                     [2, 3, 4, 5, 6, 7, 8, 9, 1],
                                     [5, 6, 7, 8, 9, 1, 2, 3, 4],
                                     [8, 9, 1, 2, 3, 4, 5, 6, 7],
                                     [3, 4, 5, 6, 7, 8, 9, 1, 2],
                                     [6, 7, 8, 9, 1, 2, 3, 4, 5],
                                     [9, 1, 2, 3, 4, 5, 6, 7, 8]]), False)

    def test_strings(self):
        self.assertIs(validate_grid(['61  9    ',
                                     '   2 1673',
                                     '    4  9 ',
                                     ' 2    5  ',
                                     '7 51 83 9',
                                     '  3    1 ',
                                     ' 6  5    ',
                                     '5798 2   ',
                                     '    6  51']), True)

    def test_emoji_grid(self):
        self.assertIs(validate_grid([['😁', '🙈', '😴', '😍', '😎', '😭', '😩', '😇', '😂'],
                                     ['😍', '😎', '😭', '😩', '😇', '😂', '🙈', '😴', '😁'],
                                     ['😩', '😇', '😂', '🙈', '😴', '😁', '😎', '😭', '😍'],
                                     ['🙈', '😴', '😁', '😎', '😭', '😍', '😇', '😂', '😩'],
                                     ['😎', '😭', '😍', '😇', '😂', '😩', '😴', '😁', '🙈'],
                                     ['😇', '😂', '😩', '😴', '😁', '🙈', '😭', '😍', '😎'],
                                     ['😴', '😁', '🙈', '😭', '😍', '😎', '😂', '😩', '😇'],
                                     ['😭', '😍', '😎', '😂', '😩', '😇', '😁', '🙈', '😴'],
                                     ['😂', '😩', '😇', '😁', '🙈', '😴', '😍', '😎', '😭']]), True)

    def test_japanese(self):
        self.assertIs(validate_grid([[' ', ' ', ' ', '八', ' ', ' ', ' ', ' ', '四'],
                                     [' ', ' ', ' ', ' ', ' ', ' ', ' ', '九', ' '],
                                     [' ', ' ', ' ', '三', ' ', ' ', ' ', ' ', ' '],
                                     [' ', ' ', '九', '七', ' ', '三', ' ', '四', ' '],
                                     [' ', '六', ' ', ' ', ' ', ' ', ' ', '一', ' '],
                                     [' ', '四', ' ', '二', ' ', '九', '三', ' ', ' '],
                                     [' ', ' ', ' ', ' ', ' ', '八', ' ', ' ', ' '],
                                     [' ', '八', ' ', ' ', ' ', ' ', ' ', ' ', ' '],
                                     ['九', ' ', ' ', ' ', ' ', '六', ' ', ' ', ' ']]), True)

    def test_japanese_strings(self):
        self.assertIs(validate_grid([u'四九二八  七五 ',
                                     u'    四一  九',
                                     u'  七 二   八',
                                     u'   九 二  七',
                                     u'         ',
                                     u'八  六 五   ',
                                     u'九   八 一  ',
                                     u'二  三九    ',
                                     u' 三四  六九八二']), True)


suite = unittest.TestLoader().loadTestsFromTestCase(TestSudokuGrid)
unittest.TextTestRunner(verbosity=2).run(suite)