

class Node:
    """A simple graph node used to model a dependency (e.g. a build step)."""

    value: str
    neighbor: list['Node'] | None

    def __init__(self, value: str, neighbor: list['Node'] | None = None) -> None:
        self.value = value
        # Directed edges: `neighbor` lists the nodes that must come *after* this one.
        self.neighbor = neighbor

    def __repr__(self) -> str:
        """Print-friendly label so test output is readable (A -> B -> C)."""
        return self.value


def topological_sort(root: Node | None) -> list[Node] | str | None:
    """DFS-based topological sort (Kahn's algorithm's recursive cousin).

    Returns:
        - None           if the graph is empty (root is None)
        - "cycle found"  if the graph contains a cycle (no valid ordering)
        - list[Node]     otherwise, ordered so every node appears before its dependents
    """
    if root is None:
        return None

    visited: set[Node] = set()   # nodes whose subtree is fully processed
    on_path: set[Node] = set()   # nodes on the current recursion stack (cycle detection)
    results: list[Node] = []

    # A False from dfs means we hit a back edge -> the graph is not a DAG.
    if not dfs(root, visited, on_path, results):
        return "cycle found"

    # DFS finishes a node *after* its dependencies, so the list is reversed
    # to get the correct dependency-first ordering.
    results.reverse()

    return results


def dfs(node: Node, visited: set[Node], on_path: set[Node], results: list[Node]) -> bool:
    """Depth-first helper: marks `node` visited and appends it to `results`.

    Returns False as soon as a cycle is detected anywhere below `node`.
    """
    visited.add(node)
    on_path.add(node)

    # Explore every outgoing edge (treat a missing/None neighbor list as empty).
    for neighbor in (node.neighbor or []):
        # Back edge to a node still on our recursion stack => cycle.
        if neighbor in on_path:
            return False
        # Recurse only into unvisited nodes; propagate any failure upward.
        if neighbor not in visited and not dfs(neighbor, visited, on_path, results):
            return False

    # Node is fully processed: pop it off the current path and record it.
    on_path.remove(node)
    results.append(node)
    return True


def kahns_topological_sort(root: Node | None) -> list[Node] | str | None:
    """Kahn's algorithm: repeatedly remove nodes with in-degree 0.

    Same return contract as `topological_sort`, but iterative and
    BFS/queue-driven instead of recursive.

    Returns:
        - None           if the graph is empty (root is None)
        - "cycle found"  if nodes remain that never reach in-degree 0
        - list[Node]     otherwise, in dependency-first order
    """
    if root is None:
        return None

    # Trivial case: a single node with no outgoing edges.
    if root.neighbor is None:
        return [root]

    # --- Step 1: collect every node reachable from `root` -------------------
    nodes: set[Node] = set()
    stack: list[Node] = [root]
    while stack:
        n = stack.pop()
        if n in nodes:
            continue
        nodes.add(n)
        if n.neighbor:
            stack.extend(n.neighbor)

    # --- Step 2: compute in-degrees (how many edges point *at* each node) --
    in_degree: dict[Node, int] = {n: 0 for n in nodes}

    for node in nodes:
        if node.neighbor:
            for nb in node.neighbor:
                in_degree[nb] += 1

    # --- Step 3: seed the queue with all source nodes (in-degree 0) --------
    k_queue: list[Node] = [n for n in nodes if in_degree[n] == 0]

    result: list[Node] = []

    # --- Step 4: repeatedly "remove" a source and decrement its neighbors --
    while len(k_queue) != 0:
        node = k_queue.pop()          # pop() acts as a stack; appendleft() would be BFS
        result.append(node)

        for neighbor in (node.neighbor or []):
            in_degree[neighbor] -= 1

            # Neighbor just became a source -> it's ready to be scheduled.
            if in_degree[neighbor] == 0:
                k_queue.append(neighbor)

    # If we couldn't place every node, the leftover nodes form at least one cycle.
    if len(result) != len(nodes):
        return "cycle found"

    return result


def _build_sample_graph() -> Node:
    """Builds a small DAG used by the sample test below.

        A -> B -> D
        A -> C -> D
        D -> E

    Valid orderings include: A, B, C, D, E
    """
    e = Node("E")
    d = Node("D", [e])
    b = Node("B", [d])
    c = Node("C", [d])
    a = Node("A", [b, c])
    return a


def _build_cyclic_graph() -> Node:
    """Builds a graph containing a cycle: A -> B -> C -> A."""
    a = Node("A")
    b = Node("B", [a])
    c = Node("C", [b])
    a.neighbor = [c]  # close the loop
    return a


def _print_result(label: str, result: list[Node] | str | None) -> None:
    """Formats either an ordering, the cycle message, or None for display."""
    if isinstance(result, list):
        ordered = " -> ".join(str(n) for n in result)
    else:
        ordered = repr(result)
    print(f"{label}: {ordered}")


def sample_test() -> None:
    """Sample driver that exercises both algorithms on valid and cyclic graphs."""
    print("--- Valid DAG ---")
    _print_result("DFS sort   ", topological_sort(_build_sample_graph()))
    _print_result("Kahn's sort", kahns_topological_sort(_build_sample_graph()))

    print("\n--- Cyclic graph (should report the cycle) ---")
    _print_result("DFS sort   ", topological_sort(_build_cyclic_graph()))
    _print_result("Kahn's sort", kahns_topological_sort(_build_cyclic_graph()))

    print("\n--- Empty input ---")
    _print_result("DFS sort   ", topological_sort(None))
    _print_result("Kahn's sort", kahns_topological_sort(None))


if __name__ == "__main__":
    sample_test()
