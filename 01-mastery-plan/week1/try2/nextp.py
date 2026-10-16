from typing import TypeVar

class NextPerm:

    T = TypeVar("T", int, str)

    @staticmethod
    def next_perm(items: list[T]) -> None:
        n: int = len(items)

        i: int = n - 2

        while i > 0 and items[i] >= items[i + 1]:
            i -= 1

        if i > 0:
            j: int = n - 1
            while items[j] <= items[i]:
                j -= 1

            items[i], items[j] = items[j], items[i]

        NextPerm.reverse(items, i + 1, n - 1)

    @staticmethod
    def reverse(items: list[T], left: int, right: int) -> None:
        while left < right:
            items[left], items[right] = items[right], items[left]
            left += 1
            right -= 1

if __name__ == "__main__":
    a: list[int] = [1,2,3]
    NextPerm.next_perm(a)
    print(a)

    b: list[str] = ['a','b','c']
    NextPerm.next_perm(b)
    print(b)
