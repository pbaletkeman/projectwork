# Backtrack.java Method Explanations

## 1. `permute` — Entry point

**What it does:** Sets up the data structures and kicks off backtracking.

**Memory hook:** It's just setup. Create a `used[]` array and an empty `StringBuilder`, then call `backtrack`.

```
permute("abc")
  → used = [false, false, false]
  → path = ""
  → calls backtrack(...)
```

---

## 2. `backtrack` — The recursive builder

**What it does:** Builds permutations one character at a time, backtracking when stuck.

**Memory hook — 3 rules:**

| Rule | Code | Why |
|------|------|-----|
| **Base case** | `path.length() == chars.length` | Permutation is complete, save it |
| **Skip used** | `if (used[i]) continue` | Can't reuse a character |
| **Skip duplicates** | `chars[i] == chars[i-1] && !used[i-1]` | Avoids duplicate permutations |

**The 4-step pattern inside the loop:**

| Step | Code | Purpose |
|------|------|---------|
| 1 | `used[i] = true` | Choose |
| 2 | `path.append(chars[i])` | Add to path |
| 3 | `backtrack(...)` | Explore |
| 4 | `path.pop + used[i]=false` | Un-choose (backtrack) |

**Why the duplicate check works:** If `chars[i] == chars[i-1]` and `used[i-1]` is false, it means we skipped the first `e` and are now trying the second `e` — which would produce the same result. So skip it.

---

## 3. `nextperm` — In-place next permutation

**What it does:** Finds the next lexicographically larger permutation. Example: `[1,2,3] → [1,3,2]`.

**Memory hook — 3 steps:**

| Step | Action | Example |
|------|--------|---------|
| 1 | Find the first decrease from the right (`nums[i] < nums[i+1]`) | `[1,2,3]` → i=1 (2 < 3) |
| 2 | Find the smallest value larger than `nums[i]` to the right, swap | swap 2 and 3 → `[1,3,2]` |
| 3 | Reverse everything after i | (nothing to reverse here) |

**Full example:** `[1,3,5,4,2]`

| Step | Action | Result |
|------|--------|--------|
| 1 | First decrease from right: i=1 (3 < 5) | i=1 |
| 2 | Smallest value > 3 to the right is 4, swap | `[1,4,5,3,2]` |
| 3 | Reverse after i | `[1,4,2,3,5]` |

**Edge case:** If no decrease found (e.g., `[3,2,1]`), `i = -1`, so just reverse the whole array → `[1,2,3]` (wraps to smallest).

---

## 4. `swap` — Simple helper

```java
int temp = nums[a];
nums[a] = nums[b];
nums[b] = temp;
```

**Memory hook:** temp = a, a = b, b = temp.

---

## 5. `reverse` — Two-pointer reversal

```java
while (left < right) swap(nums, left++, right--);
```

**Memory hook:** Two pointers walk toward each other, swapping as they go.

---

## 6. `kperm` — K-th permutation (factorial number system)

**What it does:** Given n=4 and k=3, returns the 3rd lexicographic permutation of `[1,2,3,4]`.

**Memory hook — the key insight:**

With 4 digits, each position has a "block" of permutations:

```
Position 0 (3! = 6 each):  [1xxx] [2xxx] [3xxx] [4xxx]
                           k=1-6  k=7-12 k=13-18 k=19-24
```

So `idx = k / fact[i]` tells you which digit goes in position i.

**The loop (backwards from n-1 to 0):**

| Step | Code | Purpose |
|------|------|---------|
| 1 | `idx = k / fact[i]` | Which remaining digit to pick |
| 2 | `sb.append(nums.get(idx))` | Add it to result |
| 3 | `nums.remove(idx)` | Remove from available digits |
| 4 | `k %= fact[i]` | Remaining k within the sub-block |

**Example:** n=4, k=3

| i | fact[i] | k | idx | nums before | pick | nums after |
|---|---------|---|-----|-------------|------|------------|
| 3 | 6 | 2 | 0 | [1,2,3,4] | 1 | [2,3,4] |
| 2 | 2 | 2 | 1 | [2,3,4] | 3 | [2,4] |
| 1 | 1 | 0 | 0 | [2,4] | 2 | [4] |
| 0 | 1 | 0 | 0 | [4] | 4 | [] |

**Result:** `"1324"`

---

## Quick reference card to recreate from scratch

| Method | Pattern | Key lines |
|--------|---------|-----------|
| `permute` | Setup + call backtrack | `used[]`, `StringBuilder`, call `backtrack` |
| `backtrack` | Choose → explore → un-choose | `used[i]=true`, recurse, `path.pop + used[i]=false` |
| `nextperm` | Find decrease → swap → reverse | `while(i>=0 && nums[i]>=nums[i+1]) i--` |
| `kperm` | Factorial number system | `idx = k / fact[i]`, remove digit, `k %= fact[i]` |
