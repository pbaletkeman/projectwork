from dataclasses import dataclass


@dataclass
class Node:
    value: str
    children: list['Node']
    visited: bool

def process(node: Node) -> None:
    print(f"sample processuing for {node.value}")

def traverse_dfs(node: Node | None, search_value: str | None, found: bool, result: list[str]) -> None:
    '''
    DFS (Depth-First Search)
    '''
    if node is None:
        return

    if node.visited is True:
        return

    node.visited = True
    result.append(node.value)

    if found:
        return

    if search_value and node.value == search_value:
        found = True
        return

    process(node)
    for n in node.children:
        traverse_dfs(n, search_value, found, result)


def transverse_bfs(node: Node | None, search_value: str | None, result: list[str]) -> None:
    '''
    BFS - Breadth-First Search
    '''
    if node is None:
        return

    found: bool = False
    node.visited = True
    result.append(node.value)
    if search_value and node.value == search_value:
        found = True
        return

    bfs_queue: list[Node] = []
    bfs_queue.append(node)
    while len(bfs_queue) > 0:
        n = bfs_queue.pop(0)
        process(n)
        for child in n.children:
            if found:
                return
            if not child.visited and not found:
                child.visited = True
                result.append(child.value)
                if search_value and node.value == search_value:
                    found = True
                    return
                bfs_queue.append(child)

def example() -> None:

    d = Node(
        value="D",
        children=[],
        visited=False
    )

    f = Node(
        value="F",
        children=[],
        visited=False
    )

    h = Node(
        value="H",
        children=[],
        visited=False
    )

    e = Node(
        value="E",
        children=[h],
        visited=False
    )

    g = Node(
        value="G",
        children=[h],
        visited=False
    )

    b = Node(
        value="B",
        children=[d, e],
        visited=False
    )

    c = Node(
        value="C",
        children=[f, g],
        visited=False
    )

    a = Node(
        value="A",
        children=[b, c],
        visited=False
    )

    result: list[str] = []
    search_value = "C"
    traverse_dfs(a, search_value, False, result)
    print(f"result\n{result}")

if __name__ == "__main__":
    example()
