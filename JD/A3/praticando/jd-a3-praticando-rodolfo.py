import random
import pygame

LARGURA = 640
ALTURA = 480

def criar_retangulo(largura, altura, cor):
    """Retorna uma surface com um retangulo preenchido."""
    superficie = pygame.Surface((largura, altura))
    pygame.draw.rect(superficie, cor, (0, 0, largura, altura))
    return superficie

def criar_circulo(raio, cor):
    """Retorna uma surface com um circulo preenchido."""
    superficie = pygame.Surface((raio * 2, raio * 2), pygame.SRCALPHA)
    pygame.draw.circle(superficie, cor, (raio, raio), raio)
    return superficie

def cor_aleatoria():
    return (random.randint(0, 255), random.randint(0, 255), random.randint(0, 255))

def lerp(valor1, valor2, fator):
    return valor1 + (valor2 - valor1) * fator

def lerp_cor(cor1, cor2, fator):
    return tuple(int(lerp(cor1[i], cor2[i], fator)) for i in range(3))

def criar_formas_aleatorias():
    formas = []
    for _ in range(12):
        largura = random.randint(30, 120)
        altura = random.randint(30, 100)
        x = random.randint(0, LARGURA - largura)
        y = random.randint(0, ALTURA - altura)
        formas.append((criar_retangulo(largura, altura, cor_aleatoria()), (x, y)))

    for _ in range(12):
        raio = random.randint(15, 50)
        x = random.randint(0, LARGURA - raio * 2)
        y = random.randint(0, ALTURA - raio * 2)
        formas.append((criar_circulo(raio, cor_aleatoria()), (x, y)))
    return formas

def criar_seis_retangulos():
    retangulos = []
    largura = LARGURA // 3
    altura = ALTURA // 2
    for linha in range(2):
        for coluna in range(3):
            retangulo = pygame.Rect(coluna * largura, linha * altura, largura, altura)
            retangulos.append({
                "area": retangulo,
                "cor": cor_aleatoria(),
                "destino": cor_aleatoria(),
            })
    return retangulos

def main():
    pygame.init()
    tela = pygame.display.set_mode((LARGURA, ALTURA))
    pygame.display.set_caption("Atividade de cores - 1: formas | 2: desafio | R: novas formas")
    relogio = pygame.time.Clock()

    formas = criar_formas_aleatorias()
    retangulos = criar_seis_retangulos()
    modo = 1
    executando = True

    while executando:
        for evento in pygame.event.get():
            if evento.type == pygame.QUIT:
                executando = False
            elif evento.type == pygame.KEYDOWN:
                if evento.key == pygame.K_1:
                    modo = 1
                elif evento.key == pygame.K_2:
                    modo = 2
                elif evento.key == pygame.K_r:
                    formas = criar_formas_aleatorias()

        if modo == 1:
            tela.fill((30, 30, 30))
            for forma, posicao in formas:
                tela.blit(forma, posicao)
        else:
            mouse_x, mouse_y = pygame.mouse.get_pos()
            for item in retangulos:
                area = item["area"]

                item["cor"] = lerp_cor(item["cor"], item["destino"], 0.02)
                if all(abs(item["cor"][i] - item["destino"][i]) <= 1 for i in range(3)):
                    item["destino"] = cor_aleatoria()

                if area.collidepoint(mouse_x, mouse_y):
                    cor_mouse = (
                        int(mouse_x / LARGURA * 255),
                        int(mouse_y / ALTURA * 255),
                        180,
                    )
                    item["cor"] = lerp_cor(item["cor"], cor_mouse, 0.08)

                tela.blit(criar_retangulo(area.width, area.height, item["cor"]), area.topleft)

        pygame.display.flip()
        relogio.tick(60)

    pygame.quit()

if __name__ == "__main__":
    main()