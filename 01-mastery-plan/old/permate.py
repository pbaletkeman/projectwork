
def permate_string(s):
    chars = sorted(s)
    result = []
    used = [False] * len(s)
    path = []

    def backtrack():
        if len(path) == len(s):
            result.append("".join(path))
            return

        for i in range(len(s)):
            if used[i]:
                continue

            if i > 0 and chars[i] == chars[i -1 ] and not used[i - 1]:
                continue

            used[i] = True
            path.append(s[i])

            backtrack()

            path.pop()
            used[i] = False

    backtrack()

    return result

if __name__ == "__main__":
    print(permate_string("pete"))
