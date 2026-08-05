class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {}
        for num in nums:
            count[num] = count.get(num, 0) + 1
        
        heap = []
        for num in count:
            heapq.heappush(heap, (count.get(num), num))
            if len(heap) > k:
                heapq.heappop(heap)
        
        result = []
        for count in heap:
            result.append(count[1])
        return result
        