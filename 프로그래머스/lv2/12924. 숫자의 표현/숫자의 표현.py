def solution(n):
    nums = [i for i in range(1, n+1)]
    left = 0
    right = 1
    answer = 0
    
    while left < n and right <= n:
        if sum(nums[left:right]) == n:
            # print(left, right)
            # print(nums[left:right])
            answer += 1
            left += 1
        elif sum(nums[left:right]) < n:
            right += 1
        elif sum(nums[left:right]) > n:
            left += 1
        
    return answer