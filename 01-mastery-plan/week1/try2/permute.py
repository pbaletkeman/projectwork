
def backtrack(results: list[str], s: str, used: list[bool], path: str) -> None:
    if len(path) == len(s):
        results.append(path)
        return

    for i, l in enumerate(s):

        if used[i]:
            continue

        if i > 0 and l == s[i - 1] and not used[i - 1]:
            continue

        used[i] = True
        path += l
        backtrack(results, s, used, path)

        path = path[:-1]

        used[i] = False

def permutate(word: str) -> list[str]:
    results: list[str] = []
    used_elements: list[bool] = [False] * len(word)
    str_list = sorted(word)
    backtrack(results, "".join(str_list), used_elements, "")
    return results

if __name__ == "__main__":
    print(permutate("pete"))
