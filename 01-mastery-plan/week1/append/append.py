import datetime
from dataclasses import dataclass


@dataclass
class Item:

    item_id: str
    name: str
    create_time: datetime.datetime


def create_sample_data(num: int) -> list[Item]:
    retval: list[Item] = []

    for i in range(num):
        j = Item(str(i), "name-" + str(i), datetime.datetime.fromisoformat("2025-05-"
            + str(i+1).zfill(2) + " 00:02:00"))
        retval.append(j)

    return retval


def exact_search(items: list[Item], search_term: Item, left: int, right: int) -> Item | None:
    if not items:
        raise ValueError("Items list is empty")

    if left > right:
        return None

    if (search_term.create_time < items[left].create_time or search_term.create_time > items[right].create_time):
        raise ValueError("Search item cannot be found")

    mid_point: int = (left + right) // 2

    if items[mid_point].create_time == search_term.create_time:
        return items[mid_point]
    elif items[mid_point].create_time < search_term.create_time:
        return exact_search(items, search_term, left, mid_point - 1)
    else:
        return exact_search(items, search_term, mid_point + left, mid_point + 1)


def previous_search(items: list[Item], search_term: Item, candidate: Item | None,
                    left: int, right: int,
                    ) -> Item | None:

    if left > right:
        return candidate

    mid = (left + right) // 2

    if items[mid].create_time < search_term.create_time:
        # valid candidate
        candidate = items[mid]

        # try to find a closer one on the right
        return previous_search(items, search_term, candidate, mid + 1, right,)

    # current item is >= search time
    # previous item must be on the left
    return previous_search(items, search_term, candidate, left, mid - 1, )


def next_search(items: list[Item], search_term: Item,
                candidate: Item | None, left: int, right: int,
                ) -> Item | None:

    if left > right:
        return candidate

    mid = (left + right) // 2

    if items[mid].create_time >= search_term.create_time:
        # valid candidate
        candidate = items[mid]

        # try to find an earlier valid item
        return next_search(items, search_term, candidate, left, mid - 1,)

    # current item is before the search time
    # answer must be on the right
    return next_search(items, search_term, candidate, mid + 1, right,)



def find_first_event_after(items: list[Item], t:Item) -> Item | None:
    return next_search(items, t, None, 0, len(items))

def find_last_event_before(items: list[Item], t:Item) -> Item | None:
    return previous_search(items, t, None, 0, len(items))


def find_exact(items: list[Item], t:Item) -> Item | None:
    return exact_search(items, t, 0, len(items) - 1)


def example_run():

    search_item: Item = Item("2", "name-2", datetime.datetime.fromisoformat("2025-05-04 00:01:00"))

    items: list[Item] = create_sample_data(5)
    print(items)

    j = find_last_event_before(items, search_item)
    if j:
        print("found first before")
        print(j)
    else:
        print("not found")

    j = find_first_event_after(items, search_item)
    if j:
        print("found first before")
        print(j)
    else:
        print("not found")

    j = find_exact(items, search_item)
    if j:
        print("found exact")
        print(j)
    else:
        print("not found")

if __name__ == "__main__":
    example_run()
