import threading

from enum import enum

class State(enum):
	NEW = 1
	RUNNING = 2
	WAITING = 3
	RELEASED = 4
	READY = 5

class Requester:
	def __init__(self) -> None:
		self.lock = threading.Lock()
		self.cond = threading.Condition(self.lock)
		self.state: State

class Pooling:
	def __init__(self) -> None:
		self.counter: int = 0
		self.fairness: bool = False
		self.wait_queue: list[Requester] = []
		# self.lock = threading.Lock()
        # self.cond = threading.Condition(self.lock)


	def aquire(self, requester: Requester) -> str | None:
		requester.state = State.NEW
		with requester.lock:
			can_aquire: bool = (self.counter > 0) and (not self.fairness or len(self.wait_queue) == 0)
			if can_aquire:
				self.counter--

				while requester.state != State.READY:
					requester.cond.wait()

				requester.state = State.RUNNING
				requester.cond.notify()
				return "SUCCESS"

			requester.state = State.WAITING
			self.wait_queue.append(requester)


	def release(self, requester: Requester):
		with requester.lock:
			requester.state = State.RELEASED
			self.counter++

			if len(self.wait_queue) == 0:
				return

			oldest_waiter: Requester = self.wait_queue.pop(0)
			oldest_waiter.state = State.READY
			counter--

		oldest_waiter.state = State.READY
