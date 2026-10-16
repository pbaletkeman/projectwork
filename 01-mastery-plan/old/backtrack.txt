class permute:
    """
    Generates all unique permutations of the given string.
    The input string should be sorted to ensure duplicates are handled correctly.
    """

    @staticmethod
    def backtrack(result: list[str], s: str, used: list[bool], path: str):
        if len(path) == len(s):
            result.append(path)
            return


        for i, l in enumerate(s):

            if used[i]:
                continue

            if i > 0 and l == s[i -1] and not used[i - 1]:
                continue

            used[i] = True
            path += l

            permute.backtrack(result, s, used, path)

            path = path[:-1]

            used[i] = False


    @staticmethod
    def permutes(s: str) -> list[str]:
        result: list[str] = []
        used: list[bool] = []
        str_list: list[str] = []
        for i in range(len(s)):
            used.append(False)
            str_list.append(s[i])
        str_list = sorted(str_list)
        permute.backtrack(result, "".join(str_list), used, "")
        return result


class nextpermute:
    """
      Transforms the array into its next lexicographic permutation in-place.
      If the array is already the largest permutation, it wraps around to the smallest.
    """

    @staticmethod
    def swap(nums: list[int], i: int, j: int):
        temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp

    @staticmethod
    def reverse(nums: list[int], left: int, right: int):
        while left < right:
            nextpermute.swap(nums, left, right)
            left += 1
            right -= 1

    @staticmethod
    def nextperm(nums: list[int]) -> list[int]:

        n: int = len(nums)

        i: int = n - 2
        while ( i >= 0 and nums[i] >= nums[i + 1]):
            i = i - 1

        if i >= 0:
            j: int = n - 1
            while nums[j] <= nums[i]:
                j = j - 1
            nextpermute.swap(nums, i, j)

        nextpermute.reverse(nums, i + 1, n - 1)

        return nums

print(permute().permutes("pete"))
print(nextpermute().nextperm([0,8,6,7]))
