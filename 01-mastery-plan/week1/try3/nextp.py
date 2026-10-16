
def next_p(items: list[int] | list[str]) -> None:
    n: int = len(items)

    i: int = n - 2
    while i >= 0 and items[i] > items[i + 1]:
        i -= 1

    if i >= 0:

        j: int = n - 1
        while items[j] <= items[i]:
            j -= 1

        items[i], items[j] = items[j], items[i]

    reverse(items, i + 1, n - 1)

def reverse(items: list[int] | list[str], left: int, right: int) -> None:
    while (left < right):
        items[left], items[right] = items[right], items[left]
        left += 1
        right -= 1

if __name__ == "__main__":
    a = ['1','2','3']
    next_p(a)
    print(a)
    b = [1,2,3]
    next_p(b)
    print(b)
