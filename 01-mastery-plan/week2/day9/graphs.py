from dataclasses import dataclass
from enum import StrEnum


class Visited (StrEnum):
    UNVISITED = "unvisted"
    VISITING = "visiting"
    VISITED = "visted"

@dataclass
class DirNode:
    value: str
    children: list['DirNode']
    status: Visited

@dataclass(eq=False)
class UnDirNode:
    value: str
    neighbors: list['UnDirNode']


def process(dir_node: DirNode) -> None:
    print(f"sample processing for {dir_node.value}")


def traverse_dfs(dir_node: DirNode | None, result: list[str]) -> bool:

    if dir_node is None:
        return False

    if dir_node.status == Visited.VISITED:
        return False
    elif dir_node.status == Visited.VISITING:
        return True
    else:  # dir_node.status == Visited.UNVISITED
        pass

    dir_node.status = Visited.VISITING
    result.append(dir_node.value)
    process(dir_node)

    if any(traverse_dfs(n, result) for n in dir_node.children):
        return True

    dir_node.status = Visited.VISITED
    return False


def get_sample_data_no_cycle() -> DirNode:
    d = DirNode(
        value="D",
        children=[],
        status=Visited.UNVISITED
    )

    f = DirNode(
        value="F",
        children=[],
        status=Visited.UNVISITED
    )

    h = DirNode(
        value="H",
        children=[],
        status=Visited.UNVISITED
    )

    e = DirNode(
        value="E",
        children=[h],
        status=Visited.UNVISITED
    )

    g = DirNode(
        value="G",
        children=[h],
        status=Visited.UNVISITED
    )

    b = DirNode(
        value="B",
        children=[d, e],
        status=Visited.UNVISITED
    )

    c = DirNode(
        value="C",
        children=[f, g],
        status=Visited.UNVISITED
    )

    a = DirNode(
        value="A",
        children=[b, c],
        status=Visited.UNVISITED
    )

    return a


def get_sample_data_cycle() -> DirNode:
    d = DirNode(
        value="D",
        children=[],
        status=Visited.UNVISITED
    )

    f = DirNode(
        value="F",
        children=[],
        status=Visited.UNVISITED
    )

    h = DirNode(
        value="H",
        children=[],
        status=Visited.UNVISITED
    )

    e = DirNode(
        value="E",
        children=[],
        status=Visited.UNVISITED
    )

    g = DirNode(
        value="G",
        children=[],
        status=Visited.UNVISITED
    )

    b = DirNode(
        value="B",
        children=[],
        status=Visited.UNVISITED
    )

    c = DirNode(
        value="C",
        children=[],
        status=Visited.UNVISITED
    )

    a = DirNode(
        value="A",
        children=[],
        status=Visited.UNVISITED
    )
    b.children = [d, e]
    c.children = [f, g]
    e.children = [h]
    g.children = [h]
    h.children = [a]
    a.children = [b, c]
    return a


def directed_graph_sample() -> None:
    # Directed Graph
    print("directed")
    data1 = get_sample_data_no_cycle()
    result1: list[str] = []
    has_cycle1: bool = False
    has_cycle1 = traverse_dfs(data1, result1)
    print(result1)
    print("cycle: " + str(has_cycle1))
    print("-" * 30)
    data2 = get_sample_data_cycle()
    result2: list[str] = []
    has_cycle2: bool = False
    has_cycle2 = traverse_dfs(data2, result2)
    print(result2)
    print("cycle: " + str(has_cycle2))
    print("-" * 30)

# Undirected Graph

def has_cycle(un_dir_node: UnDirNode) -> bool:
    visited: set[UnDirNode] = set()

    for n in un_dir_node.neighbors:
        if n not in visited and dfs(n, None, visited):
            return True
    return False

def dfs(node:UnDirNode | None, parent: UnDirNode | None, visited: set[UnDirNode]) -> bool:
    if not node:
        return False

    visited.add(node)

    for n in node.neighbors:
        if not n in visited:
            if dfs(n, node, visited):
                return True
        elif n is not parent:
            return True

    return False


def get_undirected_data_no_cycle() -> UnDirNode:
    d = UnDirNode(value="D", neighbors=[])
    f = UnDirNode(value="F", neighbors=[])
    h = UnDirNode(value="H", neighbors=[])
    e = UnDirNode(value="E", neighbors=[])
    g = UnDirNode(value="G", neighbors=[])
    b = UnDirNode(value="B", neighbors=[])
    c = UnDirNode(value="C", neighbors=[])
    a = UnDirNode(value="A", neighbors=[])

    def link(x: UnDirNode, y: UnDirNode) -> None:
        x.neighbors.append(y)
        y.neighbors.append(x)   # undirected = both directions

    link(a, b)
    link(a, c)
    link(b, d)
    link(b, e)
    link(c, f)
    link(c, g)
    link(e, h)                  # H hangs off E only

    return a


def get_undirected_data_cycle() -> UnDirNode:
    d = UnDirNode(value="D", neighbors=[])
    f = UnDirNode(value="F", neighbors=[])
    h = UnDirNode(value="H", neighbors=[])
    e = UnDirNode(value="E", neighbors=[])
    g = UnDirNode(value="G", neighbors=[])
    b = UnDirNode(value="B", neighbors=[])
    c = UnDirNode(value="C", neighbors=[])
    a = UnDirNode(value="A", neighbors=[])

    def link(x: UnDirNode, y: UnDirNode) -> None:
        x.neighbors.append(y)
        y.neighbors.append(x)

    link(a, b)
    link(a, c)
    link(b, d)
    link(b, e)
    link(c, f)
    link(c, g)
    link(e, h)
    link(g, h)                  # <-- the only difference: G–H too

    return a

def undirected_graph_sample() -> None:
    print("Undirected")
    data1 = get_undirected_data_cycle()
    data2 = get_undirected_data_no_cycle()
    print(data1)
    print("has cycle: " + str(has_cycle(data1)))
    print("-" * 20)
    print(data2)
    print("has cycle: " + str(has_cycle(data2)))


if __name__ == '__main__':
    directed_graph_sample()
    print("\n\n\n")
    undirected_graph_sample()
