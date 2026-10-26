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


def find_first_event_after(items: list[Item], target: Item) -> Item | None:
    left = 0
    right = len(items) - 1
    candidate = None

    while left <= right:
        mid = (left + right) // 2

        if items[mid].create_time >= target.create_time:
            candidate = items[mid]
            right = mid - 1
        else:
            left = mid + 1

    return candidate


def find_last_event_before(items: list[Item], target: Item) -> Item | None:
    left = 0
    right = len(items) - 1
    candidate = None

    while left <= right:
        mid = (left + right) // 2

        if items[mid].create_time < target.create_time:
            candidate = items[mid]
            left = mid + 1
        else:
            right = mid - 1

    return candidate


def find_exact(items: list[Item], target: Item) -> Item | None:
    left = 0
    right = len(items) - 1

    while left <= right:
        mid = (left + right) // 2

        if items[mid].create_time == target.create_time:
            return items[mid]

        if items[mid].create_time < target.create_time:
            left = mid + 1
        else:
            right = mid - 1

    return None


def example_run():

    search_item: Item = Item("2", "name-2", datetime.datetime.fromisoformat("2025-05-04 00:01:00"))

    items: list[Item] = create_sample_data(9)

    j = find_last_event_before(items, search_item)
    if j:
        print("found last before:\n" + str(j))
    else:
        print("not found")

    print("\n" + "-" * 20 + "\n")
    j = find_first_event_after(items, search_item)
    if j:
        print("found first after:\n" + str(j))
    else:
        print("not found")
    print("\n" + "-" * 20 + "\n")
    search_item = Item("2", "name-2", datetime.datetime.fromisoformat("2025-05-09 00:02:00"))
    j = find_exact(items, search_item)
    if j:
        print("found exact:\n" + str(j))
    else:
        print("not found")

    print("\n" + "-" * 20 + "\n")

if __name__ == "__main__":
    example_run()
