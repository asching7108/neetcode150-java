class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m, n = len(board), len(board[0])
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        def backtrack(row, col, path):
            if len(path) == len(word):
                return True

            res = False
            if (0 <= row < m
                and 0 <= col < n
                and (row, col) not in path
                and board[row][col] == word[len(path)]
            ):
                path.append((row, col))
                for y, x in directions:
                    if backtrack(row + y, col + x, path):
                        return True
                path.pop()

            return False
            
        for row in range(m):
            for col in range(n):
                if backtrack(row, col, []):
                    return True

        return False

# Time complexity: O(m * n * 3^l) where l is the length of the word to be matched
# Space complexity: O(l) for the recursion stack