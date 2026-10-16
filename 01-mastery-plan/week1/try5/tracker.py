
def track(results: list[str], s: str, used: list[bool], path: str) -> None:
    if len(s) == len(path):
        results.append(path)
        return

    for i in range(len(s)):

        if used[i]:
            continue

        if i > 0 and s[i] == s[i - 1] and not used[i - 1]:
            continue

        used[i] = True
        track(results, s, used, path + s[i])
        used[i] = False

def values(word: str) -> list[str]:
    results: list[str] = []
    used: list[bool] = [False] * len(word)
    track(results, sorted(word), used, "")
    return results

if __name__ == "__main__":
    print(values("pete"))
