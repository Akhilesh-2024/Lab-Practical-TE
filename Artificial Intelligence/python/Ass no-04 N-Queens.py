def is_safe(queens, row, col):
    for r in range(row):
        c = queens[r]
        if c == col or abs(c - col) == abs(r - row):
            return False
    return True

def solve_n_queens(n):
    solutions = []
    
    def backtrack(row, queens):
        if row == n:
            solutions.append(queens[:])
            return
        for col in range(n):
            if is_safe(queens, row, col):
                queens[row] = col
                backtrack(row + 1, queens)
    
    backtrack(0, [-1] * n)
    return solutions

def print_board(solution):
    for row in solution:
        print(' '.join('Q' if i == row else '.' for i in range(len(solution))))
    print()

n = 8
all_solutions = solve_n_queens(n)
print(f"Total Solutions for {n}-Queens: {len(all_solutions)}\n")
print("Sample Solution:")
print_board(all_solutions[0])
