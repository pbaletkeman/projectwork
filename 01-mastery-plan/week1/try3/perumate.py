
def backtrack(results: list[str], s: str, used: list[bool], path: str):
    if len(path) == len(s):
        results.append(path)
        return

    for i in range(len(s)):
        if used[i]:
            continue

        if i > 0 and s[i] == s[i - 1] and not used[i - 1]:
            continue

        used[i] = True

        backtrack(results, s, used, path + s[i])

        used[i] = False

def permutate(word: str) -> list[str]:
    results: list[str] = []
    used: list[bool] = [False] * len(word)
    s = "".join(sorted(word))
    backtrack(results, s, used, "")
    return results


if __name__ == "__main__":
    print(permutate("pete"))
