
def backtrack(result: list[str], s: str, used: list[bool], path: str) -> None:
    if len(path) == len(s):
        result.append(path)
        return

    for i, l in enumerate(s):

        if used[i]:
            continue

        if i > 0 and l == s[i - 1] and not used[i - 1]:
            continue

        used[i] = True
        path += l

        backtrack(result, s, used, path)

        path = path[:-1]

        used[i] = False

def perumate(word: str)  ->  list[str]:
    results: list[str] = []
    used_elements: list[bool] = [False] * len(word)
    str_list = sorted(word)
    backtrack(results, "".join(str_list), used_elements, "")
    return results

if __name__ == "__main__":
    print(perumate("pete"))
