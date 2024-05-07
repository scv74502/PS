import sys


class Player:
    check: bool
    player_name: str
    player_level: int

    def __init__(self, player_level: int, player_name: str):
        self.player_level = player_level
        self.player_name = player_name
        self.check = False

    def __lt__(self, other):
        return self.player_name < other.player_name


p, m = map(int, sys.stdin.readline().split(" "))
players = [Player(0, "") for _ in range(p)]

for i in range(p):
    level, name = sys.stdin.readline().strip().split(" ")
    level = int(level)
    players[i].player_level, players[i].player_name = level, name

for i in range(p):
    room = []
    if not players[i].check:
        for j in range(i, p):
            if len(room) == m:
                break
            level = players[j].player_level
            name = players[j].player_name
            if not players[j].check and players[i].player_level - 10 <= level <= players[i].player_level + 10:
                players[j].check = True
                room.append(Player(level, name))

        room.sort()
        if len(room) == m:
            print("Started!")
        else:
            print("Waiting!")
        for player in room:
            print(f"{player.player_level} {player.player_name}")
