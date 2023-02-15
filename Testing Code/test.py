def maxArea(height: list[int]) -> int:
    water = []

    for x in range(len(height)):
        leng = 0
        for i in range(x, len(height)):
            h = min(height[x], height[i])
            print(h)
            leng += 1
            print(leng)
            water.append(leng * h - leng + 1)
    
    return max(water)

print(maxArea([1, 1]))