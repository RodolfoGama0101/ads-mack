from NaveEspacial import NaveEspacial

nave1 = NaveEspacial("Millennium Falcon")
nave2 = NaveEspacial("USS Enterprise")

def escolherAcao(nave: NaveEspacial, inimigo: NaveEspacial, escolha): 
    match escolha: 
            case "A": 
                nave.move()
            case "B":
                nave.turn("esquerda")
            case "C": 
                nave.turn("direita")
            case "D": 
                nave.shoot(inimigo)
            case "E": 
                nave.recharge()

def runGame():
    while (True): 
        if nave1.alive == False or nave2.alive == False: 
            return False

        print("-- JOGADOR 01 --")
        print("Escolha a ação:" \
            " (A) Mover para frente" \
            " (B) Girar para esquerda" \
            " (C) Girar para direita" \
            " (D) Atirar" \
            " (E) Recarregar")
        escolhaNave1 = str(input())

        escolherAcao(nave1, nave2, escolhaNave1)

        if nave2.alive == False:
            print("Jogo encerrado: Jogador 01 venceu!")
            return

        print("-- JOGADOR 02 --")
        print("Escolha a ação:" \
            " (A) Mover para frente" \
            " (B) Girar para esquerda" \
            " (C) Girar para direita" \
            " (D) Atirar" \
            " (E) Recarregar")
        escolhaNave2 = str(input())

        escolherAcao(nave2, nave1, escolhaNave2)

        print(" ")

runGame()
