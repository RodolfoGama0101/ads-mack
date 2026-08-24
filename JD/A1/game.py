from Tank import Tank
import random

eter = Tank("Eter")
kito = Tank("Kito")
lore = Tank("Lore")
lebi = Tank("Lebi")
dika = Tank("Dika")

listaTanques = [eter, kito, lore, lebi, dika]

def batalhar(listaTanques):
    print("-- Super Batalha de Tanques --")

    while len(listaTanques) > 1: 
        n = random.randrange(len(listaTanques))
        x = random.randrange(len(listaTanques))

        while (x == n):
            x = random.randrange(len(listaTanques))

        tanqueAtirador = listaTanques[n]
        tanqueAlvo = listaTanques[x]

        tanqueAtirador.fire_at(tanqueAlvo)
        tanqueAlvo.hit()

        if not tanqueAlvo.alive: 
            listaTanques.remove(tanqueAlvo)

batalhar(listaTanques)