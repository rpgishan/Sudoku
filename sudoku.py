import math

initial_board = [[0, 0, 2, 0, 0, 0, 0, 1, 0],
                 [0, 8, 5, 4, 0, 0, 0, 6, 0],
                 [0, 0, 4, 0, 6, 1, 0, 0, 8],
                 [5, 3, 1, 9, 8, 0, 0, 0, 0],
                 [0, 4, 9, 2, 0, 0, 8, 3, 0],
                 [0, 2, 7, 6, 0, 0, 0, 0, 9],
                 [4, 0, 0, 0, 3, 2, 1, 5, 7],
                 [0, 0, 8, 7, 0, 5, 0, 0, 0],
                 [0, 5, 0, 0, 9, 6, 2, 8, 0]]


def print_board(board):
    if board is None:
        print("No Solution")
        return
    if not board:
        print("No Matrix")
        return
    line = "-" * 22

    rows = len(board)
    cols = len(board[0])

    for i in range(rows):
        if i % 3 == 0:
            print(line)
        row_to_print = ""
        for j in range(cols):
            if j % 3 == 0:
                row_to_print += "|"
            value = str(board[i][j]) if board[i][j] != 0 else " "
            row_to_print += value + " "
        row_to_print += "|"
        print(row_to_print)
    print(line)


def find_zero(board):
    if board is None:
        return None
    if not board:
        return None

    rows = len(board)
    cols = len(board[0])

    for i in range(rows):
        for j in range(cols):
            if board[i][j] == 0:
                return [i, j]

    return None


def is_valid(board, row, col, value):
    if board is None:
        return False
    if not board:
        return False

    length = len(board)

    # check the row
    for i in range(length):
        if board[row][i] == value:
            return False

    # check the column
    for i in range(length):
        if board[i][col] == value:
            return False

    grid_size = int(math.sqrt(length))

    grid_row = (row // grid_size) * grid_size
    grid_col = (col // grid_size) * grid_size

    for i in range(3):
        for j in range(3):
            if board[grid_row + i][grid_col + j] == value:
                return False

    return True


def solve(board, depth=0):
    cell = find_zero(board)

    if cell is None:
        return board

    row = cell[0]
    col = cell[1]

    for i in range(1, 10):
        if is_valid(board, row, col, i):
            board[row][col] = i
            print_board(board)
            solution = solve(board, depth + 1)

            if solution is not None:
                return solution

            board[row][col] = 0

    if depth == 0:
        print("Error: No value can satisfy this")
        print_board(board)
    return None


print_board(initial_board)
print_board(solve(initial_board))
