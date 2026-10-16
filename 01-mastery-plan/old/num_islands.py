
def num_island(grid):
    if not grid:
        return 0

    rows = len(grid)
    cols = len(grid[0])
    visited = set()

    def dfs(r, c):
        if (
            r < 0 or r >= rows or
            c < 0 or c >= cols or
            grid[r][c] == "0" or
            (r, c) in visited
        ):
            return

        visited.add((r, c))

        dfs(r + 1, c)
        dfs(r - 1, c)
        dfs(r, c + 1)
        dfs(r, c - 1)

    count = 0

    for r in range(rows):
        for c in range(cols):
            if grid[r][c] == "1" and (r, c) not in visited:
                dfs(r, c)
                count += 1

    return count


if __name__ == "__main__":
    grid1 = [
        ["1","1","1","1","0"],
        ["1","1","0","1","0"],
        ["1","1","0","0","0"],
        ["0","0","0","0","0"]
    ]
    print(num_island(grid1))  # Expected: 1

    grid2 = [
        ["1","1","0","0","0"],
        ["1","1","0","0","0"],
        ["0","0","1","0","0"],
        ["0","0","0","1","1"]
    ]
    print(num_island(grid2))  # Expected: 3

    grid3 = [
        ["1", "1", "0", "0"],
        ["1", "0", "0", "1"],
        ["0", "0", "1", "1"]
    ]
    print(num_island(grid3))  # Expected: 2
