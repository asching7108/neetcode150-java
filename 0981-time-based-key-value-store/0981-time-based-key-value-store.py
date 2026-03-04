class TimeMap:

    def __init__(self):
        self.key_time_map = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if not key in self.key_time_map:
            self.key_time_map[key] = []

        self.key_time_map[key].append([timestamp, value])

    def get(self, key: str, timestamp: int) -> str:
        if not key in self.key_time_map or timestamp < self.key_time_map[key][0][0]:
            return ''
        
        lo, hi = 0, len(self.key_time_map[key]) - 1

        result = -1
        while lo <= hi:
            mid = (lo + hi) // 2
            if self.key_time_map[key][mid][0] <= timestamp:
                result = mid
                lo = mid + 1
            else:
                hi = mid - 1

        return self.key_time_map[key][result][1] if result > -1 else ''

# M is the number of set function calls
# N is the number of get function calls
# L is the average length of key and value strings
# Time complexity: O(M * L) for set(), O(N * L * log M) for get()
# Space complexity: O(M * L) to store all values

# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)