package execises

// Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



// Example 1:

// Input: grid = [
// ['1','1','1','1','0'],
// ['1','1','0','1','0'],
// ['1','1','0','0','0'],
// ['0','0','0','0','0']
// ]
// Output: 1
// Example 2:

// Input: grid = [
// ['1','1','0','0','0'],
// ['1','1','0','0','0'],
// ['0','0','1','0','0'],
// ['0','0','0','1','1']
// ]
// Output: 3


// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'.

data class Coordinate(val x: Int, val y: Int)


fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty()) return 0

    val visitedLand = mutableSetOf<Coordinate>()
    var numberOfIsland = 0
    for(y in grid.indices) {
        for(x in grid.first().indices) {
            val land = grid[y][x]
            val coordinate = Coordinate(x, y)
            if(land == '1' && !visitedLand.contains(coordinate)) {
                numberOfIsland++
                checkAroundLand(grid, x, y, visitedLand)
            }
        }

    }


    return numberOfIsland
}


fun checkAroundLand(grid: Array<CharArray>, x: Int, y: Int, visited: MutableSet<Coordinate>) {
    if(x< 0 || x > grid.first().size - 1) return
    if(y< 0 || y > grid.size - 1) return

    val land = grid[y][x]
    if(land == '0') return

    val coordinate = Coordinate(x, y)
    if(visited.contains(coordinate)) return

    visited.add(coordinate)

    checkAroundLand(grid, x-1, y, visited)
    checkAroundLand(grid, x+1, y, visited)
    checkAroundLand(grid, x, y-1, visited)
    checkAroundLand(grid, x, y+1, visited)


}