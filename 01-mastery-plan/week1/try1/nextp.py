from typing import TypeVar

class NextPerm:

    T = TypeVar("T", int, str)

    def next_perm(self, my_list: list[T]) -> list[T]:
        n = len(my_list)

        i = n - 2

        while i >= 0 and my_list[i] >= my_list[i + 1]:
            i -= 1

        if i >= 0:
            j = n - 1
            while my_list[j] <= my_list[i]:
                j -= 1

            my_list[i], my_list[j] = my_list[j], my_list[i]

        NextPerm.reverse(my_list, i + 1, n - 1)

        return my_list

    @staticmethod
    def reverse(my_list: list[T], left: int, right: int) -> None:
        while left < right:
            my_list[left], my_list[right] = my_list[right], my_list[left]
            left += 1
            right -= 1

if __name__ == "__main__":
    nextP = NextPerm()
    t = nextP.next_perm(['a','b','c'])
    print(t)
    t = nextP.next_perm([1,2,3])
    print(t)
